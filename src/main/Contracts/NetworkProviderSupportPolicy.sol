// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

import "./networkProviderDatabase.sol";
import "./NetworkProviderContract.sol";

contract NetworkProviderSupportPolicy {
    AddressBook addressBook;

    constructor(address _addressBook){
        addressBook = AddressBook(_addressBook);
    }

    function doProviderSupport(int _npCode, int _serviceCode) view returns (bool){
        networkProviderDatabase NPDB = networkProviderDatabase(addressBook.getAddress("PDB"));
        address NPcontract = NPDB.getNPContractAddressByCode(_npCode);
        NetworkProviderContract npc = NetworkProviderContract(NPcontract);
        return (npc.isServiceValid(_serviceCode));
    }
}
