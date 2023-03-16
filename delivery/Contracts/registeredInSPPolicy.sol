pragma solidity >=0.4.22 <0.9.0;

import "./UserDataBase.sol";
import "./UserContract.sol";

contract registeredInSPPolicy {
    address addressBook;

    constructor(address _addressBook) public{
        addressBook = _addressBook;
    }

    function isUserRegistered(address _userAddress, int _providerCode, int _serviceCode) public view returns (bool){
        AddressBook adb = AddressBook(addressBook);
        UserDataBase userDataBase = UserDataBase(adb.getAddress("RUDB"));
        UserContract uc = UserContract(userDataBase.getContractAddress(_userAddress));
        return(uc.isRegisteredInService(_providerCode, _serviceCode));
    }
}

