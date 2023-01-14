pragma solidity >=0.4.22 <0.9.0;

import "./networkProviderDatabase.sol";
import "./NetworkProviderContract.sol";

contract NetworkProviderSupportPolicy {
    AddressBook addressBook;

    constructor(address _addressBook) public{
        addressBook = AddressBook(_addressBook);
    }

    function doProviderSupport(int _npCode, int _serviceCode) public view returns (bool){
        networkProviderDatabase NPDB = networkProviderDatabase(addressBook.getAddress("RNPDB"));
        address NPcontract = NPDB.getNPContractAddressByCode(_npCode);
        NetworkProviderContract npc = NetworkProviderContract(NPcontract);
        return (npc.isServiceValid(_serviceCode));
    }
}
