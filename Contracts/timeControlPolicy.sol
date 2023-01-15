pragma solidity >=0.4.22 <0.9.0;

import "./AddressBook.sol";
import "./UserDataBase.sol";
import "./UserContract.sol";

contract timeControlPolicy {
    AddressBook addressBook;

    constructor(address _addressBook) public{
        addressBook = AddressBook(_addressBook);
    }

    function isAccessTimeValid(address _userAddress, int _serviceProvider, int _serviceCode) view public returns (bool){
        UserDataBase UDB = UserDataBase(addressBook.getAddress("RUDB"));
        UserContract UC = UserContract(UDB.getContractAddress(_userAddress));
        return((block.timestamp < UC.getExpirationTime(_serviceProvider, _serviceCode)));
    }
}
