pragma solidity >=0.4.22 <0.9.0;

contract Owned {
    address owner;
    constructor() public{
        owner = msg.sender;
    }

    modifier onlyOwner {
        require(msg.sender == owner);
        _;
    }
}
