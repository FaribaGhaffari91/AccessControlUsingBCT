// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

import "./AddressBook.sol";
import "./UserDataBase.sol";

contract registeredUserPolicy {
    AddressBook addressBook;

    constructor(address _addressBook){
        addressBook = AddressBook(_addressBook);
    }

    function isUserRegistered(address _userAddress) public view returns (bool){
        UserDataBase userDataBase = UserDataBase(addressBook.getAddress("RUDB"));
        return(!(userDataBase.getContractAddress(_userAddress) == address(0x0)));
    }
}
