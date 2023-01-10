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
    int providerCode;

    constructor(address _addressBook){
        addressBook = AddressBook(_addressBook);
        addressBook.setNewAddress("RegContract");
        providerCode = 0;
    }

    function isSpTokenValidToRegister(string _token, address _spAddress){
        return _token == spRegistrationTokens[_spAddress];
    }

    function registerServiceProvider(address _sp) public returns(address){
        serviceProviderDatabase SP = serviceProviderDatabase(addressBook.getAddress("RSPDB"));
        require(!SP.isProviderExist(), "This service provider exists....");
        providerCode += 1;
        ServiceProviderContract newSP = new serviceProviderContract(addressBook, msg.sender, providerCode);
        SP.addNewProvider(providerCode, _sp);
        SP.registerContract(_sp, address(newSP));
        return address(newSP);
    }

    function registerNewUser(address _user) public returns(address){
        // this function register the user in platform, only to create the contract
        UserDataBase UDB = UserDataBase(addressBook.getAddress("RUDB"));
        require(!UDB.isRegisteredUser(_user), "This user is already registered...");
        UserContract uc = new UserContract(addressBook, msg.sender);
        UDB.addNewUser(msg.sender, address(uc));
        return address(uc);
    }

    function registerToServicePrePaid(int _npCode, int _serviceProviderCode, int _serviceCode, int timeOrData){
        policyDataBaseContract PDBC = policyDataBaseContract(addressBook.getAddress("PDB"));
        serviceProviderDatabase SPDB = serviceProviderDatabase(addressBook.getAddress("RSPDB"));
        UserDataBase udb = UserDataBase(addressBook.getAddress("RUDB"));

        //check if the user is already registered in the system
        registeredUserPolicy RUP = registeredUserPolicy(PDBC.getContract(1));
        require(RUP.isUserRegistered(msg.sender), "The user is not registered");
        //check if the user's NP serves that service
        NetworkProviderSupportPolicy NPSupportContract = NetworkProviderSupportPolicy(PDBC.getContract("EnvAttrNPAgreement"));
        require(NPSupportContract.doProviderSupport(_npCode, _serviceProviderCode), "Your NP doesnt support this service provider");
        //check if the user has enough balance
            //to do this:
                //get service price from the service provider contract
                // multiply to time/storrage that user whants, and check if the user has enough money for that.
        ServiceProviderContract spc = ServiceProviderContract(SPDB.getSPContractAddressByCode(_serviceProviderCode));
        UserContract uc = UserContract(udb.getContractAddress(msg.sender));
        int price = spc.getPricePrepaid(_serviceCode) * timeOrData;
        require(price <= uc.getToken() , "User doesnt have sufficient token in her wallet");
        //update the user's contract based on registration
        uc.serviceRegistration(_serviceProviderCode, _serviceCode, dateOrTime, spc.getServiceType(_serviceCode));
        uc.payToken(price);
        spc.addToken(price);
    }

    function registerToServicePayAsYouGo(){
        policyDataBaseContract PDBC = policyDataBaseContract(addressBook.getAddress("PDB"));
        UserDataBase udb = UserDataBase(addressBook.getAddress("RUDB"));

        //check if the user is already registered in the system
        registeredUserPolicy RUP = registeredUserPolicy(PDBC.getContract(1));
        require(RUP.isUserRegistered(msg.sender), "The user is not registered");
        //check if the user's NP serves that service
        NetworkProviderSupportPolicy NPSupportContract = NetworkProviderSupportPolicy(PDBC.getContract(2));
        require(NPSupportContract.doProviderSupport(_npCode, _serviceCode), "Your NP doesnt support this service provider");
        //update the user's contract based on registration
        UserContract uc = UserContract(udb.getContractAddress(msg.sender));
        uc.serviceRegistration(_serviceProviderCode, _serviceCode, dateOrTime, spc.getServiceType(_serviceCode));
    }
}
