// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

import "./AddressBook.sol";
import "./UserDataBase.sol";
import "./UserContract.sol";

contract timeControlPolicy {
    AddressBook addressBook;

    constructor(address _addressBook){
        addressBook = _addressBook;
    }

    function isAccessTimeValid(address _userAddress, string _serviceProvider, string _serviceCode) view public returns (bool){
        UserDataBase UDB = UserDataBase(addressBook.getAddress("RUDB"));
        UserContract UC = UserContract(UDB.getContractAddress(_userAddress));
        string id = string(abi.encodePacked(_serviceProvider, _serviceCode));
        return(block.time < UC.getExpirationTime(id));
    }
}
