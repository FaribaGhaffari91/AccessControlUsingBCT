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
public class NetworkProviderContract extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516102e23803806102e28339818101604052606081101561003357600080fd5b5080516020820151604090920151600080546001600160a01b039384166001600160a01b031991821617909155600380549390941692169190911790915560045561025f806100836000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c806321df0da71461005157806351b5ed4c1461006b578063ba6a037a1461008a578063f74a3d6e146100a7575b600080fd5b6100596100d8565b60408051918252519081900360200190f35b6100886004803603602081101561008157600080fd5b50356100de565b005b610088600480360360208110156100a057600080fd5b50356101c0565b6100c4600480360360208110156100bd57600080fd5b50356101db565b604080519115158252519081900360200190f35b60015490565b6000546040805163bf40fac160e01b8152602060048201819052600960248301526820a1a6b0b730b3b2b960b91b604483015291516001600160a01b0390931692839263bf40fac19260648082019391829003018186803b15801561014257600080fd5b505afa158015610156573d6000803e3d6000fd5b505050506040513d602081101561016c57600080fd5b50516001600160a01b031633146101b45760405162461bcd60e51b815260040180806020018281038252603a8152602001806101f1603a913960400191505060405180910390fd5b50600180549091019055565b6000908152600260205260409020805460ff19166001179055565b60009081526002602052604090205460ff169056fe4f6e6c7920616363657373206d616e6167657220636f6e74726163742063616e206164642062616c616e636520696e204e50206163636f756e74a265627a7a72315820f4c665ce20d2893f1e6b05939c8b6cf9017f3c75aea090b91202c3b74bbc46c164736f6c63430005100032";

    public static final String FUNC_ADDBALANCE = "addBalance";

    public static final String FUNC_ADDNEWSERVICE = "addNewService";

    public static final String FUNC_GETTOKEN = "getToken";

    public static final String FUNC_ISSERVICEVALID = "isServiceValid";

    @Deprecated
    protected NetworkProviderContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected NetworkProviderContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected NetworkProviderContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected NetworkProviderContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addBalance(BigInteger _token) {
        final Function function = new Function(
                FUNC_ADDBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_token)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addNewService(BigInteger _providerCode) {
        final Function function = new Function(
                FUNC_ADDNEWSERVICE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_providerCode)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getToken() {
        final Function function = new Function(FUNC_GETTOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> isServiceValid(BigInteger _providerCode) {
        final Function function = new Function(FUNC_ISSERVICEVALID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_providerCode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static NetworkProviderContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new NetworkProviderContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static NetworkProviderContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new NetworkProviderContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static NetworkProviderContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new NetworkProviderContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static NetworkProviderContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new NetworkProviderContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<NetworkProviderContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _addressBook, String _npAddress, BigInteger _code) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook), 
                new org.web3j.abi.datatypes.Address(160, _npAddress), 
                new org.web3j.abi.datatypes.generated.Int256(_code)));
        return deployRemoteCall(NetworkProviderContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<NetworkProviderContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _addressBook, String _npAddress, BigInteger _code) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook), 
                new org.web3j.abi.datatypes.Address(160, _npAddress), 
                new org.web3j.abi.datatypes.generated.Int256(_code)));
        return deployRemoteCall(NetworkProviderContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<NetworkProviderContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _addressBook, String _npAddress, BigInteger _code) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook), 
                new org.web3j.abi.datatypes.Address(160, _npAddress), 
                new org.web3j.abi.datatypes.generated.Int256(_code)));
        return deployRemoteCall(NetworkProviderContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<NetworkProviderContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _addressBook, String _npAddress, BigInteger _code) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook), 
                new org.web3j.abi.datatypes.Address(160, _npAddress), 
                new org.web3j.abi.datatypes.generated.Int256(_code)));
        return deployRemoteCall(NetworkProviderContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
