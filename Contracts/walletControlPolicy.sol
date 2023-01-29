pragma solidity >=0.4.22 <0.9.0;

import "./AddressBook.sol";
import "./networkProviderDatabase.sol";
import "./UserDataBase.sol";
import "./UserContract.sol";
import "./ServiceProviderContract.sol";
import "./serviceProviderDatabase.sol";

contract walletControlPolicy {

     address addressBook;

    constructor(address _addressBook) public{

        addressBook = _addressBook;
    }

    function isUserTokenEnough(address _userAddress, int _providerCode, int _serviceCode) public view returns (bool)
    { //To be called in pay as you go scenario
        AddressBook adb = AddressBook(addressBook);
        UserDataBase UDB = UserDataBase(adb.getAddress("RUDB"));
        UserContract UC = UserContract(UDB.getContractAddress(_userAddress));
        serviceProviderDatabase SPDB = serviceProviderDatabase(adb.getAddress("RSPDB"));
        ServiceProviderContract spc = ServiceProviderContract(SPDB.getSPContractAddressByCode(_providerCode));
        require(UC.getToken() >= spc.getMinPrice(_serviceCode), "User's token is not enough to start the service");
        return true;
    }

    function isSPTokenEnough(int _providerCode, int _serviceCode) public view returns (bool){// To be called in prepaid scenario
        AddressBook adb = AddressBook(addressBook);
        serviceProviderDatabase SPDB = serviceProviderDatabase(adb.getAddress("RSPDB"));
        ServiceProviderContract sp = ServiceProviderContract(SPDB.getSPContractAddressByCode(_providerCode));
        require(sp.getToken() >= sp.getPricePrepaid(_serviceCode), "SP's token is not enough to start the service");
        return true;
    }

}
