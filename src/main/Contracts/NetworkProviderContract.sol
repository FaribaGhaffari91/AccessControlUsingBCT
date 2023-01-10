// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

import "./AddressBook.sol";

contract NetworkProviderContract {
    AddressBook addressBook;
    int Token;
    mapping(int => bool) registeredServices;
    address npAddress;

    struct service{
        int serviceCode;

    }

    modifier onlyNP {
        require(msg.sender == npAddress);
        _;
    }

    constructor(address _addressBook, address _npAddress){
        addressBook = AddressBook(_addressBook);
        npAddress = _npAddress;
    }

    function isServiceValid(int _providerCode) public returns(bool){
        //return(registeredServices[_providerCode])
        return(registeredServices[_providerCode]);
    }

    function addBalance(int _token) public {
        require(msg.sender == addressBook.getAddress("ACManager"), "Only access manager contract can add balance in NP account");
        Token += _token;
    }

    function addNewService(int _providerCode) public onlyNP{
        registeredServices[_providerCode] = true;
    }

}
