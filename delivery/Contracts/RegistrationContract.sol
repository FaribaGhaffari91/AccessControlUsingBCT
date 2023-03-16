pragma solidity >=0.4.22 <0.9.0;

import "./AddressBook.sol";
import "./serviceProviderDatabase.sol";
import "./ServiceProviderContract.sol";
import "./UserDataBase.sol";
import "./UserContract.sol";
import "./policyDataBaseContract.sol";
import "./registeredUserPolicy.sol";
import "./NetworkProviderSupportPolicy.sol";


contract RegistrationContract {

    address addressBook;
    mapping(address=> string) spRegistrationTokens; // This tokens will be issued by NP that shows their confirmation of data
    int serviceProviderCode;
    int networkProviderCode;

    constructor(address _addressBook) public{
        addressBook = _addressBook;
        AddressBook adb = AddressBook(addressBook);
        adb.setNewAddress(address(this), "RegContract");
        serviceProviderCode = 0;
        networkProviderCode = 0;
    }

//    function isSpTokenValidToRegister(string _token, address _spAddress){
//        return _token == spRegistrationTokens[_spAddress];
//    }

    function registerServiceProvider(address _sp) public returns(address){
        AddressBook adb = AddressBook(addressBook);
        serviceProviderDatabase SP = serviceProviderDatabase(adb.getAddress("RSPDB"));
        require(!SP.isProviderExist(_sp), "This service provider exists....");
        serviceProviderCode += 1;
        ServiceProviderContract newSP = new ServiceProviderContract(addressBook, msg.sender, serviceProviderCode);
        newSP.addToken(15000);
        SP.addNewProvider(serviceProviderCode, _sp);
        SP.registerContract(_sp, address(newSP));
        return address(newSP);
    }

    function registerNewUser(address _user) public returns(address){
        // this function register the user in platform, only to create the contract
        AddressBook adb = AddressBook(addressBook);
        UserDataBase UDB = UserDataBase(adb.getAddress("RUDB"));
        require(!UDB.isRegisteredUser(_user), "This user is already registered...");
        UserContract uc = new UserContract(addressBook, msg.sender);
        uc.chargeToken(10000); //for thest, in real implementation it is not required
        UDB.addNewUser(msg.sender, address(uc));
        return address(uc);
    }

    function registerNewNP(address _npAddress) public returns(address){
        AddressBook adb = AddressBook(addressBook);
        networkProviderDatabase NPD = networkProviderDatabase(adb.getAddress("RNPDB"));
        require(!NPD.isNPExist(_npAddress), "This network provider exists....");
        networkProviderCode += 1;
        NetworkProviderContract newNP = new NetworkProviderContract(addressBook, msg.sender, networkProviderCode);
        NPD.addNewProvider(networkProviderCode, _npAddress);
        NPD.registerContract(_npAddress, address(newNP));
        return address(newNP);
    }

    function registerToServicePrePaid(address _user, address _sp, int _serviceProviderCode, int _serviceCode, uint256 timeOrData) public{
        AddressBook adb = AddressBook(addressBook);
        //policyDataBaseContract PDBC = policyDataBaseContract(adb.getAddress("PDB"));
        serviceProviderDatabase SPDB = serviceProviderDatabase(adb.getAddress("RSPDB"));
        UserDataBase udb = UserDataBase(adb.getAddress("RUDB"));

        //check if the user is already registered in the system
        //registeredUserPolicy RUP = registeredUserPolicy(PDBC.getContract(1));
        //require(RUP.isUserRegistered(_user), "The user is not registered");
        require(udb.getContractAddress(_user) != address(0x0), "The user is not registered");

        //check if the user's NP serves that service
        //NetworkProviderSupportPolicy NPSupportContract = NetworkProviderSupportPolicy(PDBC.getContract(2));
        //require(NPSupportContract.doProviderSupport(_npCode, _serviceProviderCode), "Your NP doesnt support this service provider");
        //check if the user has enough balance
            //to do this:
                //get service price from the service provider contract
                // multiply to time/storrage that user whants, and check if the user has enough money for that.
        ServiceProviderContract spc = ServiceProviderContract(SPDB.getSPContractAddressByAddress(_sp));
        UserContract uc = UserContract(udb.getContractAddress(_user));
        int256 price = int256(spc.getRegPriceForUser(_serviceCode)) * int256(timeOrData);
        require(price <= uc.getToken() , "User doesnt have sufficient token in her wallet");
        //update the user's contract based on registration
        //int t =  spc.getServiceType(_serviceCode);
        uc.serviceRegistration(_serviceProviderCode, _serviceCode, timeOrData, 1);
        uc.payToken(price);
        spc.addToken(price);
    }

    function registerToServicePayAsYouGo(address _user, int _serviceProviderCode, int _serviceCode, uint256 timeOrData) public{
        AddressBook adb = AddressBook(addressBook);
        //policyDataBaseContract PDBC = policyDataBaseContract(adb.getAddress("PDB"));
        UserDataBase udb = UserDataBase(adb.getAddress("RUDB"));

        //serviceProviderDatabase SPDB = serviceProviderDatabase(adb.getAddress("RSPDB"));
        //ServiceProviderContract spc = ServiceProviderContract(SPDB.getSPContractAddressByAddress(_sp));

        //check if the user is already registered in the system
        //registeredUserPolicy RUP = registeredUserPolicy(PDBC.getContract(1));
        //require(RUP.isUserRegistered(msg.sender), "The user is not registered");
        require(udb.getContractAddress(_user) != address(0x0), "The user is not registered");

        //check if the user's NP serves that service
        //NetworkProviderSupportPolicy NPSupportContract = NetworkProviderSupportPolicy(PDBC.getContract(2));
        //require(NPSupportContract.doProviderSupport(_npCode, _serviceProviderCode), "Your NP doesnt support this service provider");
        //update the user's contract based on registration
        UserContract uc = UserContract(udb.getContractAddress(_user));
        //int typeservice = spc.getServiceType(_serviceCode);
        uc.serviceRegistration(_serviceProviderCode, _serviceCode, timeOrData, 2);
    }

    function addNewServiceInSP(address _spAddress, int _serviceType, int _serviceCostforUser, int _operatorFee, int _costForUser, int _minPrice, int _operatorShare) public {
        AddressBook adb = AddressBook(addressBook);
        serviceProviderDatabase spdb = serviceProviderDatabase(adb.getAddress("RSPDB"));
        ServiceProviderContract spc = ServiceProviderContract(spdb.getSPContractAddressByAddress(_spAddress));
        spc.addNewService(_serviceType, _serviceCostforUser, _operatorFee, _costForUser, _minPrice, _operatorShare);
    }

    function addPolicyInService(int _title, int _serviceCode, address _spAddress) public {
        AddressBook adb = AddressBook(addressBook);
        serviceProviderDatabase spdb = serviceProviderDatabase(adb.getAddress("RSPDB"));
        ServiceProviderContract spc = ServiceProviderContract(spdb.getSPContractAddressByAddress(_spAddress));
        spc.addPolicy(_title, _serviceCode);
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
