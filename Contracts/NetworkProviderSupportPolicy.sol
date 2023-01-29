pragma solidity >=0.4.22 <0.9.0;

import "./networkProviderDatabase.sol";
import "./NetworkProviderContract.sol";

contract NetworkProviderSupportPolicy {
    address addressBook;

    constructor(address _addressBook) public{
        addressBook = _addressBook;
    }

    function doProviderSupport(int _npCode, int _serviceCode) public view returns (bool){
        AddressBook adb = AddressBook(addressBook);
        networkProviderDatabase NPDB = networkProviderDatabase(adb.getAddress("RNPDB"));
        address NPcontract = NPDB.getNPContractAddressByCode(_npCode);
        NetworkProviderContract npc = NetworkProviderContract(NPcontract);
        return (npc.isServiceValid(_serviceCode));
    }
}
