// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

import "./AddressBook.sol";

contract serviceProviderDatabase {

    AddressBook addressBook;

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

    function isProviderExist(address _sp) public view returns (bool){
        return(!(registerdProviderContract[_sp] == address(0x00)));
    }

    function getSPContractAddressByCode(int _code) public view returns (address){
        address t = registeredServiceProviders[_code];
        return(registerdProviderContract[t]);
    }
}

