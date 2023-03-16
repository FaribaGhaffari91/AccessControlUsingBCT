pragma solidity >=0.4.22 <0.9.0;

import "./AddressBook.sol";
import "./UserDataBase.sol";
import "./serviceProviderDatabase.sol";
import "./ServiceProviderContract.sol";
import "./registeredUserPolicy.sol";
import "./policyDataBaseContract.sol";
import "./NetworkProviderSupportPolicy.sol";
import "./timeControlPolicy.sol";
import "./registeredInSPPolicy.sol";
import "./walletControlPolicy.sol";

contract AccessManagerContract {
    address addressBook;

    constructor(address _addressBook) public{
        addressBook = _addressBook;
        AddressBook adb = AddressBook(addressBook);
        adb.setNewAddress(address(this), "ACManager");
    }

     //storedToken : indicates the stored token of specific user in this contract, for payment after.
    //Normally during service provision this amount should b non zero, but after, it should be zero
    mapping(address => int) storedToken;

    function userValidation(address _userAddress, int _providerCode, int _networkProviderCode, int _serviceCode) public returns (bool){
        //check the list of service policies
        AddressBook adb = AddressBook(addressBook);
        serviceProviderDatabase SPDB = serviceProviderDatabase(adb.getAddress("RSPDB"));
        ServiceProviderContract spc = ServiceProviderContract(SPDB.getSPContractAddressByCode(_providerCode));
        policyDataBaseContract PDBC = policyDataBaseContract(adb.getAddress("PDB"));
        UserDataBase udb = UserDataBase(adb.getAddress("RUDB"));

        if(spc.isPolicyApplicable(1, _serviceCode)){
            require(udb.getContractAddress(_userAddress) != address(0x00), "The user is not registered");
            //registeredUserPolicy RUP = registeredUserPolicy(PDBC.getContract(1));
            //require(RUP.isUserRegistered(_userAddress), "The user is not registered");
        }
        if(spc.isPolicyApplicable(2, _serviceCode)){
            NetworkProviderSupportPolicy NPSupportContract = NetworkProviderSupportPolicy(PDBC.getContract(2));
            require(NPSupportContract.doProviderSupport(_networkProviderCode, _serviceCode), "Your NP doesnt support this service provider");
        }
        if(spc.isPolicyApplicable(3, _serviceCode)){
            timeControlPolicy tcp = timeControlPolicy(PDBC.getContract(3));
            require(tcp.isAccessTimeValid(_userAddress, _providerCode, _serviceCode), "the registration time is expired");
        }

        if(spc.isPolicyApplicable(4, _serviceCode) && spc.getServiceType(_serviceCode) == 1){ // for prepaid
            walletControlPolicy wcp = walletControlPolicy(PDBC.getContract(4));
            require(wcp.isSPTokenEnough(_providerCode, _serviceCode));
        }

        if(spc.isPolicyApplicable(4, _serviceCode) && spc.getServiceType(_serviceCode) == 2){ // for Pay as you go
            walletControlPolicy wcp = walletControlPolicy(PDBC.getContract(4));
            require(wcp.isUserTokenEnough(_userAddress, _providerCode, _serviceCode));
        }

        if(spc.isPolicyApplicable(5, _serviceCode)){
            UserContract UC = UserContract(udb.getContractAddress(_userAddress));
            require(UC.isRegisteredInService(_providerCode, _serviceCode), "The user is not registered in this service");
            //registeredInSPPolicy rip = registeredInSPPolicy(PDBC.getContract(5));
            //require(rip.isUserRegistered(_userAddress, _providerCode, _serviceCode), "The user is not registered in this service");
        }

        //if all the aplicable polcies satisfies, it means that the user is eligible to acces the service
        //So, first we get the token from user account for the non prepaid services, and then, return true.
        if(spc.getServiceType(_serviceCode) == 2){ // for pay as you go
            //UserDataBase UDB = UserDataBase(adb.getAddress("RUDB"));
            UserContract UC = UserContract(udb.getContractAddress(_userAddress));
            //ServiceProviderContract spc = ServiceProviderContract(SPDB.getSPContractAddressByCode(_providerCode));
            //To block money in "this" contract
            storedToken[_userAddress] = storedToken[_userAddress] + spc.getMinPrice(_serviceCode);
            UC.payToken(spc.getMinPrice(_serviceCode));
        }
        if(spc.getServiceType(_serviceCode) == 1) // for prepaid
        {
            //serviceProviderDatabase SPDB = serviceProviderDatabase(addressBook.getAddress("RSPDB"));
            //ServiceProviderContract spc = ServiceProviderContract(SPDB.getNPContractAddressByCode(_providerCode));
            //To block money in "this" contract
            storedToken[_userAddress] = storedToken[_userAddress] + spc.getPricePrepaid(_serviceCode);
            spc.payToNP(spc.getPricePrepaid(_serviceCode));
        }
        return true;
    }

    function terminationAndPayment(address _userAddress, int _providerCode, int _networkProviderCode, int _serviceCode, int _usage) public {
        AddressBook adb = AddressBook(addressBook);
        serviceProviderDatabase SPDB = serviceProviderDatabase(adb.getAddress("RSPDB"));
        ServiceProviderContract spc = ServiceProviderContract(SPDB.getSPContractAddressByCode(_providerCode));
        networkProviderDatabase npd = networkProviderDatabase(adb.getAddress("RNPDB"));
        NetworkProviderContract npc = NetworkProviderContract(npd.getNPContractAddressByCode(_networkProviderCode));
        UserDataBase UDB = UserDataBase(adb.getAddress("RUDB"));
        UserContract UC = UserContract(UDB.getContractAddress(_userAddress));
        if(spc.getServiceType(_serviceCode) == 2){
            int finalPrice = spc.getPricePayAsYouGo(_serviceCode) * _usage;
            //if(finalPrice > UC.getToken() + spc.getMinPrice(_serviceCode)){ // user already paid spc.getMinPrice(_serviceCode)
                //if the user's available token was less than his usage, the final price would be set to user's available token. To avoid error
                //finalPrice = UC.getToken() + storedToken[_userAddress];
            //}

            if(finalPrice >= spc.getMinPrice(_serviceCode)) { // if user paid less than his real usage
                UC.payToken(finalPrice - spc.getMinPrice(_serviceCode));
                spc.addToken(finalPrice * (1- (spc.getNPShare(_serviceCode)/10))); //since the NP share is defined in int, I devided to 10 to make it as percentage
                npc.addBalance(finalPrice * (spc.getNPShare(_serviceCode)/10));
                storedToken[_userAddress] = storedToken[_userAddress] - spc.getMinPrice(_serviceCode);
            } else{ // if the user paid more than his real usage
                UC.chargeToken(spc.getMinPrice(_serviceCode) - finalPrice);
                spc.addToken(finalPrice * (1- (spc.getNPShare(_serviceCode)/10))); //since the NP share is defined in int, I devided to 10 to make it as percentage
                npc.addBalance(finalPrice * (spc.getNPShare(_serviceCode)/10));
                storedToken[_userAddress] = storedToken[_userAddress] - spc.getMinPrice(_serviceCode);
            }
        } else{
            storedToken[_userAddress] = storedToken[_userAddress] - spc.getPricePrepaid(_serviceCode);
            npc.addBalance(spc.getPricePrepaid(_serviceCode));
        }
    }

    function getUserStoredToken(address _ue) public view returns(int){
        return storedToken[_ue];
    }

    function getUserToken(address _user) public view returns (int){
        AddressBook adb = AddressBook(addressBook);
        UserDataBase udb = UserDataBase(adb.getAddress("RUDB"));
        UserContract uc = UserContract(udb.getContractAddress(_user));
        return uc.getToken();
    }

    function getSPToken(int _spCode) public view returns (int){
        AddressBook adb = AddressBook(addressBook);
        serviceProviderDatabase udb = serviceProviderDatabase(adb.getAddress("RSPDB"));
        ServiceProviderContract uc = ServiceProviderContract(udb.getSPContractAddressByCode(_spCode));
        return uc.getToken();
    }

    function getNPToken(int _npCode) public view returns (int){
        AddressBook adb = AddressBook(addressBook);
        networkProviderDatabase udb = networkProviderDatabase(adb.getAddress("RNPDB"));
        NetworkProviderContract np = NetworkProviderContract(udb.getNPContractAddressByCode(_npCode));
        return np.getToken();
    }
}
