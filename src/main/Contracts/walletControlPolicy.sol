// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

import "./AddressBook.sol";

contract walletControlPolicy {
    AddressBook addressBook;

    constructor(address _addressBook){
        addressBook = AddressBook(_addressBook);
    }


}
