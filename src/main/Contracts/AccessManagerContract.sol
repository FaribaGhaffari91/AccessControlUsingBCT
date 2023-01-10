// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

import "./AddressBook.sol";
import "./UserDataBase.sol";
import "./serviceProviderDatabase.sol";
import "./ServiceProviderContract.sol";
import "./registeredUserPolicy.sol";
import "./policyDataBaseContract.sol";
import "./NetworkProviderSupportPolicy.sol";

contract AccessManagerContract {
    AddressBook addressBook;

    constructor(){
        addressBook = AddressBook(_addressBook);
        addressBook.setNewAddress("ACManager");
    }

     //storedToken : indicates the stored token of specific user in this contract, for payment after.
    //Normally during service provision this amount should b non zero, but after, it should be zero
    mapping(address => int) storedToken;

    function userValidation(int _providerCode, int _networkProviderCode, int _serviceCode){
        //check the list of service policies
        serviceProviderDatabase SPDB = serviceProviderDatabase(addressBook.getAddress("RSPDB"));
        ServiceProviderContract spc = ServiceProviderContract(SPDB.getSPContractAddressByCode(_providerCode));
        policyDataBaseContract PDBC = policyDataBaseContract(addressBook.getAddress("PDB"));
        UserDataBase udb = UserDataBase(addressBook.getAddress("RUDB"));



        if(spc.isPolicyApplicable(1, _serviceCode)){
            registeredUserPolicy RUP = registeredUserPolicy(PDBC.getContract(1));
            require(RUP.isUserRegistered(msg.sender), "The user is not registered");
        }
        if(spc.isPolicyApplicable(2, _serviceCode)){
            NetworkProviderSupportPolicy NPSupportContract = NetworkProviderSupportPolicy(PDBC.getContract(2));
            require(NPSupportContract.doProviderSupport(_npCode, _serviceCode), "Your NP doesnt support this service provider");
        }
        if(spc.isPolicyApplicable(3, _serviceCode)){
        }
        if(spc.isPolicyApplicable(4, _serviceCode)){

        }
        if(spc.isPolicyApplicable(5, _serviceCode)){

        }

    }

    function UserValidation_and_Connection(address _Uaddress, uint _serviceCode) public returns (bytes32){
        require (msg.sender == _Uaddress, "Only user itself can run this contract");
        Addresses address_Contract = Addresses(addrConract);
        address _UCDB = address_Contract.getAddress("UCDB");
        address _SPDB = address_Contract.getAddress("SPDB");
        UserContractDB contractDB = UserContractDB(_UCDB);
        ServiceProviderDB SPDB = ServiceProviderDB(_SPDB);
        SPContractWithNP SP_NP = SPContractWithNP(SPDB.getContractAddress(_serviceCode));
        userContractWithSP UC= userContractWithSP(contractDB.getQosContractAddress(_Uaddress, _serviceCode));
        address USPaddress = SPDB.getSPAddress(_serviceCode); // To get SP's Balance
        require(SPDB.getAvailableBalance(_serviceCode)>= SP_NP.getNeededToken(), "SP's balance is not enough");
        require(block.timestamp <= UC.GetExpireTime(), "account's balance is expired");
        require(UC.GetRemainedToken() >= UC.GetToken(), "user do not have enough token in service providers account");
        SPDB.decreaseAvailableBalance(_serviceCode, SP_NP.getNeededToken());
        Balance += SP_NP.getNeededToken();
        UC.Activate(true);
        bytes32 token = tokenGeneration(USPaddress, _Uaddress);
        ValidTokens[token] = true;
        return token;
    }

    function tokenGeneration(address sp, address user) private pure returns (bytes32){
        return keccak256(abi.encodePacked(sp,user));
    }
    function isValid(address user, bytes32 token) public returns(bool){ // The SP calls this function before providing the service to user
        bytes32 generatedToken = keccak256(abi.encodePacked(msg.sender,user));
        require(token == generatedToken, 'The token is not correct');
        require(ValidTokens[generatedToken], 'Invalid Token');
        ValidTokens[generatedToken] = false;
        return true;
    }
    function PayNP(address _Uaddress, uint _serviceCode) public {
        Addresses address_Contract = Addresses(addrConract);
        address SPAddresses = address_Contract.getAddress("SPDB");
        address UCDB = address_Contract.getAddress("UCDB");
        ServiceProviderDB SP = ServiceProviderDB(SPAddresses);
        UserContractDB _UCDB = UserContractDB(UCDB);
        userContractWithSP UC = userContractWithSP(_UCDB.getQosContractAddress(_Uaddress, _serviceCode)); // To get user's QoS smart contract with specific SP
        SPContractWithNP SP_NP_contract = SPContractWithNP(SP.getContractAddress(_serviceCode));
        require(UC.getFlag(), "The contract is not active");
        SP_NP_contract.increaseOwe(SP_NP_contract.getNeededToken());
        Balance -= SP_NP_contract.getNeededToken();
        UC.updateRemainedToken();
        UC.Activate(false);
    }





}
