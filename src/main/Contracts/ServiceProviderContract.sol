// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

import "./AddressBook.sol";
import "./Owned.sol";

contract ServiceProviderContract is Owned {
    AddressBook addressBook;
    address spOwner;
    int providerCode;
    mapping(int => Services) providedServices;
    int serviceCode;
    int availableToken;

    modifier onlySP {
        require(msg.sender == spOwner);
        _;
    }

    constructor(address _addressBook, address _spOwner, int _providerCode){
        addressBook = AddressBook(_addressBook);
        //Addressbook in real implementation is a fix number, not argument, so No Problem
        spOwner = _spOwner;
        providerCode = _providerCode;
        serviceCode = 0;
    }

    struct Services {
        int serviceCode;
        int serviceType; //if serviceType ==1, the service is time-based (days), if it is 2, the service is data-usage-based (MB)-- This variable is important in policy definition
        //Next two variable are for prepaid scenario, this amount will be deducted from user's wallet in registration.
        //if serviceType ==1 price is per day, if it is 2 price is for each MB
        //In the pay as you go scenario, these parameters can be set to 0
        int serviceCostforUser;
        int operatorFee; //the cost per second/MB that SP should pay to MNO for providing this service to user
        //Next variable is for pay as you go scenario, the registration in service will not cost anything to user.
        //if serviceType ==1 price is per second, if it is 2 price is for each MB
        //In the pay as you go scenario, after finishing the service the following two parameters will be used for payment
        int costForUser;
        int operatorShare; // percentage
        mapping(int => bool) policyTitle; // This parameter can be added by sp themselves
    }

    function addPolicy(int _title, int _serviceCode) public onlySP{
        providedServices[_serviceCode].policyTitle[_title] = true;
    }

    function addNewService(int _serviceType, int _serviceCostforUser, int _operatorFee, int _costForUser, int _operatorShare) public onlySP {
        serviceCode +=1;
        Services service = Services(serviceCode, _serviceType, _serviceCostforUser, _operatorFee, _costForUser, _operatorShare);
        providedServices[serviceCode] = service;
        //after this, the SP needs to call addPolicy function
    }

    function chargeMyWallet(int Token) public onlySP{
        //In real implementation this function must be based on ERC20, but here it is for test
        //This function is more useful for second scenario (pay as you go)
        availableToken += Token;
    }

    function addToken(int Token) public {
        //In real implementation this function must be based on ERC20, but here it is for test
        //This function is more useful for first scenario when registration contact will charge the service provider as prepaid method
        require(msg.sender == addressBook.getAddress("RegContract"));
        availableToken += Token;
    }

    function getPricePrepaid(int _serviceCode) public view returns (int) {
        return providedServices[_serviceCode].serviceCostforUser;
    }

    function getServiceType(int _serviceCode) public view returns (int) {
        return providedServices[_serviceCode].serviceType;
    }

    function isPolicyApplicable(int _title, int _serviceCode) public view returns (bool) {
        return providedServices[_serviceCode].policyTitle[_title];
    }

}
