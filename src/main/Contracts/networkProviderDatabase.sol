// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

import "./AddressBook.sol";

contract networkProviderDatabase is Owned{
    AddressBook addressBook;
    constructor (address _addressBook){
        addressBook = AddressBook(_addressBook);
        addressBook.setNewAddress(address(this), "RNPDB");
    }

    mapping(int => address) registeredNetworkProviders;
    mapping(address => address) registerdNPContract;

    function addNewProvider (int _code, address _npAddress) public onlyOwner{
        // add a new network provider in the list of registered providers by the admin.
        registeredNetworkProviders[_code] = _npAddress;
    }

    function registerContract (address _npAddress, address _npContract) public onlyOwner{
        // add the contract address of newly registered network provider'.
        registerdNPContract[_npAddress] = _npContract;
    }

    function isNPExist(address _sp) view returns (bool){
        return(!registeredNetworkProviders[address] == address(0x00));
    }

    function getNPContractAddressByCode(int _code) returns (address){
        return(registerdNPContract[registeredNetworkProviders[_code]]);
    }
}
