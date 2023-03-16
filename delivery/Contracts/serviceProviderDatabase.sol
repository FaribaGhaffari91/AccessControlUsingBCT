pragma solidity >=0.4.22 <0.9.0;

import "./AddressBook.sol";


contract serviceProviderDatabase {

    address addressBook;

    constructor (address _addressBook) public{
        addressBook = _addressBook;
        AddressBook adb = AddressBook(addressBook);
        adb.setNewAddress(address(this), "RSPDB");
    }

    mapping(int => address) registeredServiceProviders;
    mapping(address => address) registerdProviderContract;

    function addNewProvider (int _code, address _spAddress) public {
        // add a new registered service provider in the list of system providers.
        AddressBook adb = AddressBook(addressBook);
        require (msg.sender == adb.getAddress("RegContract"), 'This function only can be called by Registeration contract');
        registeredServiceProviders[_code] = _spAddress;
    }

    function registerContract (address _spAddress, address _spContract) public {
        // add the contract address of newly registered service provider's contract'.
        AddressBook adb = AddressBook(addressBook);
        require (msg.sender == adb.getAddress('RegContract'), 'This function only can be called by Registeration contract');
        registerdProviderContract[_spAddress] = _spContract;
    }

    function isProviderExist(address _sp) public view returns (bool){
        return(!(registerdProviderContract[_sp] == address(0x00)));
    }

    function getSPContractAddressByCode(int _code) public view returns (address){
        address t = registeredServiceProviders[_code];
        return(registerdProviderContract[t]);
    }

    function getSPContractAddressByAddress(address _spAddress) public view returns (address){
        return(registerdProviderContract[_spAddress]);
    }
}

