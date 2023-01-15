pragma solidity >=0.4.22 <0.9.0;

import "./UserDataBase.sol";
import "./UserContract.sol";

contract registeredInSPPolicy {
    AddressBook addressBook;

    constructor(address _addressBook) public{
        addressBook = AddressBook(_addressBook);
    }

    function isUserRegistered(address _userAddress, int _providerCode, int _serviceCode) public view returns (bool){
        UserDataBase userDataBase = UserDataBase(addressBook.getAddress("RUDB"));
        UserContract uc = UserContract(userDataBase.getContractAddress(_userAddress));
        return(uc.isRegisteredInService(_providerCode, _serviceCode));
    }
}

