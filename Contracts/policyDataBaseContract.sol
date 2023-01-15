pragma solidity >=0.4.22 <0.9.0;

import "./AddressBook.sol";

contract policyDataBaseContract is Owned {
    // In order to provide high maintainability in terms of adding new policies or removing the user-less policies, each type of policy is stored in seperate smart contract
    //e.g., registeredUserPolicy will check if the user is registered in the given service or not? (subject attribute of ABAV model)
    //in this version, each policy type has an id as following:
    // "SubAttrRegNP" = 1 is the subject attribute check that calls the registeredUserPolicy contract,
    //"EnvAttrNPAgreement"  = 2 is the environment attribute check that the user's network provider supports this service,
    //"EnvAttrTime" = 3 is the environment attribute check that calls the timeControlPolicy contract,
    //"EnvAttrToken" = 4 is the environment attribute check that calls the walletControlPolicy contract,
    // "SubAttrRegSP" = 5 is the subject attribute check that if the user is registered in the service provider.
    // There is a function to add other policies in the system that its owner is the system admin.
    //in serviceProviderContract, each service code will have one/several of these policies.
    AddressBook addressBook;
    mapping (int => address) policyContracts;
    //int counter;
    //mapping(int => int[]) allPolicies;// This is only for being able to have the list of all stored policies

    constructor(address _addressBook) public{
        addressBook = AddressBook(_addressBook);
        addressBook.setNewAddress(address(this), "PDB");
        //counter = 0;
    }

    function addPolicy(address _policyContract, int _code) onlyOwner public {
        policyContracts [_code] = _policyContract;
        //counter +=1;
        //allPolicies [counter] = _title;
    }

    function getContract(int _code) public view returns (address){
        return (policyContracts [_code]);
    }

/*    function getAllPolicies() view returns (int[] memory){
        int[] memory temp;
        for(int i = 0; i<= counter; i++){
            temp.push(allPolicies[counter]);
        }
        return temp;
    }*/

}
