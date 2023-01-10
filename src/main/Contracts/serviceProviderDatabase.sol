// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

contract serviceProviderDatabase {

    constructor (address _addressBook){
        addressBook = AddressBook(_addressBook);
        addressBook.setNewAddress(address(this), "RSPDB");
    }

    mapping(int => address) registeredServiceProviders;
    mapping(address => address) registerdProviderContract;

    function addNewProvider (int _code, address _spAddress) public {
        // add a new registered service provider in the list of system providers.
        require (msg.sender == addressBook.getAddress('REG'), 'This function only can be called by Registeration contract');
        registeredServiceProviders[_code] = _spAddress;
    }

    function registerContract (address _spAddress, address _spContract) public {
        // add the contract address of newly registered service provider's contract'.
        require (msg.sender == addressBook.getAddress('REG'), 'This function only can be called by Registeration contract');
        registerdProviderContract[_spAddress] = _spContract;
    }

    function isProviderExist(address _sp) view returns (bool){
        return(!registerdProviderContract[address] == address(0x00));
    }

    function getSPContractAddressByCode(int _code) returns (address){
        return(registerdProviderContract[registeredServiceProviders[_code]]);
    }
}

