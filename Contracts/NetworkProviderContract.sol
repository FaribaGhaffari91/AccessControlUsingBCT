pragma solidity >=0.4.22 <0.9.0;

import "./AddressBook.sol";

contract NetworkProviderContract {
    address addressBook;
    int Token;
    mapping(int => bool) registeredServices;
    address npAddress;
    int code;

    struct service{
        int serviceCode;
    }

    modifier onlyNP {
        require(msg.sender == npAddress);
        _;
    }

    constructor(address _addressBook, address _npAddress, int _code) public{
        addressBook = _addressBook;
        npAddress = _npAddress;
        code = _code;
    }

    function isServiceValid(int _providerCode) public view returns(bool){
        //return(registeredServices[_providerCode])
        return(registeredServices[_providerCode]);
    }

    function addBalance(int _token) public {
        AddressBook adb = AddressBook(addressBook);
        require(msg.sender == adb.getAddress("ACManager"), "Only access manager contract can add balance in NP account");
        Token += _token;
    }

    function addNewService(int _providerCode) public {
        registeredServices[_providerCode] = true;
    }

    function getToken() public view returns(int){
        return Token;
    }

}
