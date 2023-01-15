package CompiledContracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.0.
 */
public class UserContract extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50604051610aff380380610aff8339818101604052604081101561003357600080fd5b508051602091820151600180546001600160a01b0319166001600160a01b0380851691909117918290556040805163bf40fac160e01b815260048101879052600b60248201526a149959d0dbdb9d1c9858dd60aa1b6044820152905194959394929091169263bf40fac192606480840193829003018186803b1580156100b857600080fd5b505afa1580156100cc573d6000803e3d6000fd5b505050506040513d60208110156100e257600080fd5b50516001600160a01b0316331461012a5760405162461bcd60e51b8152600401808060200182810382526037815260200180610ac86037913960400191505060405180910390fd5b60008055600380546001600160a01b03909216610100026001600160a81b031990921691909117905550610965806101636000396000f3fe608060405234801561001057600080fd5b50600436106100935760003560e01c806341c18af31161006657806341c18af314610137578063507966e0146101545780636298ca4f14610171578063979c86f114610190578063a330de2b146101ad57610093565b806305364a1d146100985780630f248d38146100cf57806321df0da7146100fa57806322fa871814610114575b600080fd5b6100bb600480360360408110156100ae57600080fd5b50803590602001356101dc565b604080519115158252519081900360200190f35b6100f8600480360360608110156100e557600080fd5b50803590602081013590604001356101ff565b005b610102610365565b60408051918252519081900360200190f35b6101026004803603604081101561012a57600080fd5b508035906020013561036b565b6100f86004803603602081101561014d57600080fd5b5035610389565b6100f86004803603602081101561016a57600080fd5b50356103b0565b6100f86004803603602081101561018757600080fd5b5035151561049c565b6100f8600480360360208110156101a657600080fd5b503561059b565b6100f8600480360360808110156101c357600080fd5b5080359060208101359060408101359060600135610737565b600091825260026020908152604080842092845291905290206004015460ff1690565b6001546040805163bf40fac160e01b8152602060048201819052600b60248301526a149959d0dbdb9d1c9858dd60aa1b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b15801561026557600080fd5b505afa158015610279573d6000803e3d6000fd5b505050506040513d602081101561028f57600080fd5b50516001600160a01b031633146102ed576040805162461bcd60e51b815260206004820152601e60248201527f796f752063616e206e6f742063616c6c20746869732066756e6374696f6e0000604482015290519081900360640190fd5b6000838152600260208181526040808420868552909152909120015442106103395760008381526002602081815260408084208685529091529091204262015180840201910155610360565b60008381526002602081815260408084208685529091529091200180546201518083020190555b505050565b60005490565b60009182526002602081815260408085209385529290529120015490565b60035461010090046001600160a01b031633146103a557600080fd5b600080549091019055565b6001546040805163bf40fac160e01b8152602060048201819052600960248301526820a1a6b0b730b3b2b960b91b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b15801561041457600080fd5b505afa158015610428573d6000803e3d6000fd5b505050506040513d602081101561043e57600080fd5b50516001600160a01b031633146103a5576040805162461bcd60e51b815260206004820152601c60248201527f54686973202066756e6374696f6e206973207265737472696374656400000000604482015290519081900360640190fd5b6001546040805163bf40fac160e01b8152602060048201819052600960248301526820a1a6b0b730b3b2b960b91b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b15801561050057600080fd5b505afa158015610514573d6000803e3d6000fd5b505050506040513d602081101561052a57600080fd5b50516001600160a01b03163314610588576040805162461bcd60e51b815260206004820152601e60248201527f796f752063616e206e6f742063616c6c20746869732066756e6374696f6e0000604482015290519081900360640190fd5b6003805460ff1916911515919091179055565b6001546040805163bf40fac160e01b8152602060048201819052600960248301526820a1a6b0b730b3b2b960b91b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b1580156105ff57600080fd5b505afa158015610613573d6000803e3d6000fd5b505050506040513d602081101561062957600080fd5b50516001600160a01b03163314806106da57506001546040805163bf40fac160e01b8152602060048201819052600b60248301526a149959d0dbdb9d1c9858dd60aa1b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b1580156106a257600080fd5b505afa1580156106b6573d6000803e3d6000fd5b505050506040513d60208110156106cc57600080fd5b50516001600160a01b031633145b61072b576040805162461bcd60e51b815260206004820152601c60248201527f54686973202066756e6374696f6e206973207265737472696374656400000000604482015290519081900360640190fd5b60008054919091039055565b6001546040805163bf40fac160e01b8152602060048201819052600b60248301526a149959d0dbdb9d1c9858dd60aa1b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b15801561079d57600080fd5b505afa1580156107b1573d6000803e3d6000fd5b505050506040513d60208110156107c757600080fd5b50516001600160a01b03163314610825576040805162461bcd60e51b815260206004820152601e60248201527f796f752063616e206e6f742063616c6c20746869732066756e6374696f6e0000604482015290519081900360640190fd5b61082d6108ff565b816001141561086f576040518060a0016040528086815260200185815260200184620151800242018152602001600081526020016001151581525090506108a6565b81600214156108a6576040518060a00160405280868152602001858152602001600081526020018481526020016001151581525090505b600094855260026020818152604080882096885295815295859020825181559582015160018701559381015193850193909355505060608101516003830155608001516004909101805460ff1916911515919091179055565b6040518060a0016040528060008152602001600081526020016000815260200160008152602001600015158152509056fea265627a7a72315820cdc18ff77283808e53044a7d44e784d2611d741ad63c631d8ec93d09931739eb64736f6c634300051000325468697320636f6e7472616374206f6e6c792063616e206265206465706c6f79656420627920526567697374657220436f6e7472616374";

    public static final String FUNC_ACTIVATE = "Activate";

    public static final String FUNC_CHARGEMYWALLET = "chargeMyWallet";

    public static final String FUNC_CHARGETOKEN = "chargeToken";

    public static final String FUNC_GETEXPIRATIONTIME = "getExpirationTime";

    public static final String FUNC_GETTOKEN = "getToken";

    public static final String FUNC_ISREGISTEREDINSERVICE = "isRegisteredInService";

    public static final String FUNC_PAYTOKEN = "payToken";

    public static final String FUNC_SERVICEREGISTRATION = "serviceRegistration";

    public static final String FUNC_UPDATEEXPIRATIONTIME = "updateExpirationTime";

    @Deprecated
    protected UserContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected UserContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected UserContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected UserContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> Activate(Boolean _flag) {
        final Function function = new Function(
                FUNC_ACTIVATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Bool(_flag)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> chargeMyWallet(BigInteger Token) {
        final Function function = new Function(
                FUNC_CHARGEMYWALLET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(Token)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> chargeToken(BigInteger _token) {
        final Function function = new Function(
                FUNC_CHARGETOKEN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_token)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getExpirationTime(BigInteger _providerCode, BigInteger _serviceCode) {
        final Function function = new Function(FUNC_GETEXPIRATIONTIME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_providerCode), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceCode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getToken() {
        final Function function = new Function(FUNC_GETTOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> isRegisteredInService(BigInteger _providerCode, BigInteger _serviceCode) {
        final Function function = new Function(FUNC_ISREGISTEREDINSERVICE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_providerCode), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceCode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> payToken(BigInteger _token) {
        final Function function = new Function(
                FUNC_PAYTOKEN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_token)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> serviceRegistration(BigInteger _providerCode, BigInteger _serviceCode, BigInteger _dateOrTime, BigInteger _serviceType) {
        final Function function = new Function(
                FUNC_SERVICEREGISTRATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_providerCode), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceCode), 
                new org.web3j.abi.datatypes.generated.Uint256(_dateOrTime), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceType)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateExpirationTime(BigInteger _providerCode, BigInteger _serviceCode, BigInteger _validationDuration) {
        final Function function = new Function(
                FUNC_UPDATEEXPIRATIONTIME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_providerCode), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceCode), 
                new org.web3j.abi.datatypes.generated.Uint256(_validationDuration)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static UserContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new UserContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static UserContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new UserContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static UserContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new UserContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static UserContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new UserContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<UserContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _addressBook, String _userAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook), 
                new org.web3j.abi.datatypes.Address(160, _userAddress)));
        return deployRemoteCall(UserContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<UserContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _addressBook, String _userAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook), 
                new org.web3j.abi.datatypes.Address(160, _userAddress)));
        return deployRemoteCall(UserContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<UserContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _addressBook, String _userAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook), 
                new org.web3j.abi.datatypes.Address(160, _userAddress)));
        return deployRemoteCall(UserContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<UserContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _addressBook, String _userAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook), 
                new org.web3j.abi.datatypes.Address(160, _userAddress)));
        return deployRemoteCall(UserContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
