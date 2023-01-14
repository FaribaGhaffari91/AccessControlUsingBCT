// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

import "./AddressBook.sol";
import "./serviceProviderDatabase.sol";
import "./ServiceProviderContract.sol";
import "./UserDataBase.sol";
import "./UserContract.sol";
import "./policyDataBaseContract.sol";
import "./registeredUserPolicy.sol";
import "./NetworkProviderSupportPolicy.sol";

contract RegistrationContract {

    AddressBook addressBook;
    mapping(address=> string) spRegistrationTokens; // This tokens will be issued by NP that shows their confirmation of data
    int serviceProviderCode;
    int networkProviderCode;

    constructor(address _addressBook){
        addressBook = AddressBook(_addressBook);
        addressBook.setNewAddress(address(this), "RegContract");
        serviceProviderCode = 0;
        networkProviderCode = 0;
    }

//    function isSpTokenValidToRegister(string _token, address _spAddress){
//        return _token == spRegistrationTokens[_spAddress];
//    }

    function registerServiceProvider(address _sp) public returns(address){
        serviceProviderDatabase SP = serviceProviderDatabase(addressBook.getAddress("RSPDB"));
        require(!SP.isProviderExist(_sp), "This service provider exists....");
        serviceProviderCode += 1;
        ServiceProviderContract newSP = new ServiceProviderContract(addressBook.getAddress("AddressBook"), msg.sender, serviceProviderCode);
        SP.addNewProvider(serviceProviderCode, _sp);
        SP.registerContract(_sp, address(newSP));
        return address(newSP);
    }

    function registerNewUser(address _user) public returns(address){
        // this function register the user in platform, only to create the contract
        UserDataBase UDB = UserDataBase(addressBook.getAddress("RUDB"));
        require(!UDB.isRegisteredUser(_user), "This user is already registered...");
        UserContract uc = new UserContract(addressBook.getAddress("AddressBook"), msg.sender);
        UDB.addNewUser(msg.sender, address(uc));
        return address(uc);
    }

    function registerNewNP(address _npAddress) public returns(address){
        networkProviderDatabase NPD = networkProviderDatabase(addressBook.getAddress("RNPDB"));
        require(!NPD.isNPExist(_npAddress), "This network provider exists....");
        networkProviderCode += 1;
        NetworkProviderContract newNP = new NetworkProviderContract(addressBook.getAddress("AddressBook"), msg.sender, networkProviderCode);
        NPD.addNewProvider(networkProviderCode, _npAddress);
        NPD.registerContract(_npAddress, address(newNP));
        return address(newNP);
    }

    function registerToServicePrePaid(int _npCode, int _serviceProviderCode, int _serviceCode, uint256 timeOrData) public{
        policyDataBaseContract PDBC = policyDataBaseContract(addressBook.getAddress("PDB"));
        serviceProviderDatabase SPDB = serviceProviderDatabase(addressBook.getAddress("RSPDB"));
        UserDataBase udb = UserDataBase(addressBook.getAddress("RUDB"));

        //check if the user is already registered in the system
        registeredUserPolicy RUP = registeredUserPolicy(PDBC.getContract(1));
        require(RUP.isUserRegistered(msg.sender), "The user is not registered");
        //check if the user's NP serves that service
        NetworkProviderSupportPolicy NPSupportContract = NetworkProviderSupportPolicy(PDBC.getContract(2));
        require(NPSupportContract.doProviderSupport(_npCode, _serviceProviderCode), "Your NP doesnt support this service provider");
        //check if the user has enough balance
            //to do this:
                //get service price from the service provider contract
                // multiply to time/storrage that user whants, and check if the user has enough money for that.
        ServiceProviderContract spc = ServiceProviderContract(SPDB.getSPContractAddressByCode(_serviceProviderCode));
        UserContract uc = UserContract(udb.getContractAddress(msg.sender));
        int256 price = int256(spc.getRegPriceForUser(_serviceCode)) * int256(timeOrData);
        require(price <= uc.getToken() , "User doesnt have sufficient token in her wallet");
        //update the user's contract based on registration
        int t =  spc.getServiceType(_serviceCode);
        uc.serviceRegistration(_serviceProviderCode, _serviceCode, timeOrData, t);
        uc.payToken(price);
        spc.addToken(price);
    }

    function registerToServicePayAsYouGo(int _npCode, int _serviceProviderCode, int _serviceCode, uint256 timeOrData) public{
        policyDataBaseContract PDBC = policyDataBaseContract(addressBook.getAddress("PDB"));
        UserDataBase udb = UserDataBase(addressBook.getAddress("RUDB"));

        serviceProviderDatabase SPDB = serviceProviderDatabase(addressBook.getAddress("RSPDB"));
        ServiceProviderContract spc = ServiceProviderContract(SPDB.getSPContractAddressByCode(_serviceProviderCode));

        //check if the user is already registered in the system
        registeredUserPolicy RUP = registeredUserPolicy(PDBC.getContract(1));
        require(RUP.isUserRegistered(msg.sender), "The user is not registered");
        //check if the user's NP serves that service
        NetworkProviderSupportPolicy NPSupportContract = NetworkProviderSupportPolicy(PDBC.getContract(2));
        require(NPSupportContract.doProviderSupport(_npCode, _serviceProviderCode), "Your NP doesnt support this service provider");
        //update the user's contract based on registration
        UserContract uc = UserContract(udb.getContractAddress(msg.sender));
        uc.serviceRegistration(_serviceProviderCode, _serviceCode, timeOrData, spc.getServiceType(_serviceCode));
    }
}
