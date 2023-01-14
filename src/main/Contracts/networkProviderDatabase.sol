pragma solidity >=0.4.22 <0.9.0;

import "./AddressBook.sol";
import "./NetworkProviderContract.sol";

contract networkProviderDatabase is Owned{
    AddressBook addressBook;
    constructor (address _addressBook) public{
        addressBook = AddressBook(_addressBook);
        addressBook.setNewAddress(address(this), "RNPDB");
    }

    mapping(int => address) registeredNetworkProviders;
    mapping(address => address) registerdNPContract;

    function addNewProvider (int _code, address _npAddress) public onlyOwner{
        // add a new network provider in the list of registered providers by the admin.
        require(msg.sender == addressBook.getAddress("RegContract"), "this function is restricted");
        registeredNetworkProviders[_code] = _npAddress;
    }

    function registerContract (address _npAddress, address _npContract) public onlyOwner{
        // add the contract address of newly registered network provider'.
        require(msg.sender == addressBook.getAddress("RegContract"), "this function is restricted");
        registerdNPContract[_npAddress] = _npContract;
    }

    function isNPExist(address _np) public view returns (bool){
        return(!(registerdNPContract[_np] == address(0x00)));
    }

    function getNPContractAddressByCode(int _code) public view returns (address){
        return(registerdNPContract[registeredNetworkProviders[_code]]);
    }
}
