pragma solidity >=0.4.22 <0.9.0;

import "./AddressBook.sol";
import "./UserDataBase.sol";

contract registeredUserPolicy {
    address addressBook;

    constructor(address _addressBook) public{
        addressBook = _addressBook;
    }

    function isUserRegistered(address _userAddress) public view returns (bool){
        AddressBook adb = AddressBook(addressBook);
        UserDataBase userDataBase = UserDataBase(adb.getAddress("RUDB"));
        return(userDataBase.getContractAddress(_userAddress) != address(0x0));
    }
}

