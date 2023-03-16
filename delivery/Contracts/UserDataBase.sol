pragma solidity >=0.4.22 <0.9.0;

import "./AddressBook.sol";
import "./Owned.sol";

contract UserDataBase {
    mapping (address => address) registeredUsers; // This mapping will map the user's address to a unique QoS contract with Service Provider.
    address addressBook;
    constructor (address _addressBook) public{
        addressBook = _addressBook;
        AddressBook adb = AddressBook(addressBook);
        adb.setNewAddress(address(this), "RUDB");
    }
    function addNewUser (address _uAddress, address _cAddress) public {
        // add a new registered user in the list of system users.
        AddressBook adb = AddressBook(addressBook);
        require (msg.sender == adb.getAddress("RegContract"), 'This function only can be called by Registeration contract');
        registeredUsers[_uAddress] = _cAddress;
    }

    function getContractAddress(address _userAddress) view public returns (address){
        return registeredUsers[_userAddress];
    }

    function isRegisteredUser(address _userAddress) view public returns (bool){
        return (registeredUsers[_userAddress] != address(0x00));
    }

}
