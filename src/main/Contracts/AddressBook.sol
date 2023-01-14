// SPDX-License-Identifier: MIT
pragma solidity >=0.4.22 <0.9.0;

import "./Owned.sol";


contract AddressBook is Owned{
    mapping (string => address) HandlerAddresses;
    constructor(){
        //HandlerAddresses ['MNO'] = np;
        HandlerAddresses ['Owner'] = owner;
        HandlerAddresses ['AddressBook'] = address(this);
    }
    function setNewAddress(address _Address, string memory _name) external {
        //note that this function should be OnlyOwner, but to make it simple we let adding new contract in the cunstruct()
        require (HandlerAddresses[_name] == address(0x0), "this address is initiated before");
        HandlerAddresses[_name] = _Address;
    }

    function getAddress(string memory _name) external view returns(address) {
    return(HandlerAddresses[_name]);
}

    //---------------Doesnt work for now-------------------------------------------------
/*    function UpdateAddress(address _Address, string memory _name) external onlyOwner{
        //MAYBE can be used to evaluate the update/maintainability change in the system
        require (HandlerAddresses[_name] != address(0x0), "this address is not initiated before, you can not update that");
        bytes32 _nameHash = keccak256(abi.encodePacked(_name));
        require(!(_nameHash == keccak256(abi.encodePacked('SPDB'))
        ||_nameHash == keccak256(abi.encodePacked('UCDB'))
        ||_nameHash == keccak256(abi.encodePacked('Payment'))
        ||_nameHash == keccak256(abi.encodePacked('Network_Provider'))),
            'These addresses are permanent');
        HandlerAddresses[_name] = _Address;
    }*/
    //------------------------------------------------------------------------------------

}
