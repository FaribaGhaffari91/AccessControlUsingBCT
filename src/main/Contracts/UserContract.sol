pragma solidity >=0.4.22 <0.9.0;

import "./AddressBook.sol";

contract UserContract {
    //------------Structs---------------
    struct userRegisteredServices {
        int serviceProviderCode;
        int serviceCode;
        uint256 expirationTime; //if the service is not time-based this can be ZERO
        uint256 availableStorage; //if the service is not storage-based this can be ZERO
        bool registered;
    }

    modifier onlyUser {
        require(msg.sender == userAddress);
        _;
    }

    //--------Variables-----------
    int availableToken;
    AddressBook addressBook;
    mapping (int => mapping(int => userRegisteredServices)) allRegisteredServices;//ProviderCode to userRegisteredServices

    bool active;
    address userAddress;

    constructor(address _addressBook, address _userAddress) public{ //This function is only used for user registration in the system
        addressBook = AddressBook(_addressBook); // in realworld setup, addressBook will not be sent as parameter, it is the ONLY fix address
        //in the platform. So, it will be an address.
        require (msg.sender == addressBook.getAddress("RegContract"), 'This contract only can be deployed by Register Contract');
        availableToken = 0;
        active = false;
        userAddress = _userAddress;
    }


    //----------Functions----------
/*    function updateAvailableToken(int _token) public {
        //This function can be used either to charge the user's wallet by registration contract (when token is positive),
        //or payment to service provider by AccessManagerContract (when token is negative)
        if(_token < 0 )
            require(msg.sender == addressBook.getAddress('AC_Mng'), 'you can not call this function');
        if(_token > 0 )
            require(msg.sender == addressBook.getAddress('Reg'), 'you can not call this function');
        availableToken = availableToken + _token;
    }*/

    function chargeMyWallet(int Token) public onlyUser{
        //In real implementation this function must be based on ERC20, but here it is for test
        //This function is to charge the user's wallet.
        //In real implementation it can be connected to the crypto wallet apps such as crypto.com, ....
        availableToken += Token;
    }

    function serviceRegistration(int _providerCode, int _serviceCode, uint256 _dateOrTime, int _serviceType) public {
    //This function is called when registration smart contract validates the user's registration request and wants to add th new service in the user's service list.
        require(msg.sender == addressBook.getAddress("RegContract"), 'you can not call this function');
        userRegisteredServices memory _temp;
        if(_serviceType == 1)
            _temp = userRegisteredServices(_providerCode, _serviceCode, (block.timestamp + _dateOrTime * 86400), 0, true);
            //the registration has TIME limitation
        else if(_serviceType == 2) //the registration has storage/data usage limitation
        _temp = userRegisteredServices(_providerCode, _serviceCode, 0, _dateOrTime, true);
        allRegisteredServices[_providerCode][_serviceCode] = _temp;
    }

    function updateExpirationTime(int _providerCode, int _serviceCode, uint256 _validationDuration) public {
        //MAYBE to evaluate the the update in user's status in the system
        require(msg.sender == addressBook.getAddress("RegContract"), 'you can not call this function');
        if(allRegisteredServices[_providerCode][_serviceCode].expirationTime <= block.timestamp)
            allRegisteredServices[_providerCode][_serviceCode].expirationTime = (block.timestamp) + _validationDuration * 86400;
        else
            allRegisteredServices[_providerCode][_serviceCode].expirationTime = allRegisteredServices[_providerCode][_serviceCode].expirationTime + _validationDuration * 86400;
    }

    function Activate(bool _flag) public {
        require(msg.sender == addressBook.getAddress("ACManager"), 'you can not call this function');
        active = _flag;
    }

    function getExpirationTime(int _providerCode, int _serviceCode) public view returns(uint256) {
        return(allRegisteredServices[_providerCode][_serviceCode].expirationTime);
    }

    function getToken() public view returns(int) {
        return(availableToken);
    }

    function payToken(int _token) public {
        require(msg.sender == addressBook.getAddress("ACManager") || msg.sender == addressBook.getAddress("RegContract"), "This  function is restricted");
        availableToken -= _token;
    }

    function chargeToken(int _token) public {
        require(msg.sender == addressBook.getAddress("ACManager"), "This  function is restricted");
        availableToken += _token;
    }

    function isRegisteredInService(int _providerCode, int _serviceCode) public view returns(bool){
        return(allRegisteredServices[_providerCode][_serviceCode].registered);
    }
}


