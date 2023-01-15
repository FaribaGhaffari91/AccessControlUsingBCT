package CompiledContracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
    private static final String BINARY = "608060405234801561001057600080fd5b506040516102cd3803806102cd8339818101604052606081101561003357600080fd5b5080516020820151604090920151600080546001600160a01b039384166001600160a01b031991821617909155600380549390941692169190911790915560045561024a806100836000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806351b5ed4c14610046578063ba6a037a14610065578063f74a3d6e14610082575b600080fd5b6100636004803603602081101561005c57600080fd5b50356100b3565b005b6100636004803603602081101561007b57600080fd5b5035610194565b61009f6004803603602081101561009857600080fd5b50356101c6565b604080519115158252519081900360200190f35b6000546040805163bf40fac160e01b8152602060048201819052600960248301526820a1a6b0b730b3b2b960b91b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b15801561011757600080fd5b505afa15801561012b573d6000803e3d6000fd5b505050506040513d602081101561014157600080fd5b50516001600160a01b031633146101895760405162461bcd60e51b815260040180806020018281038252603a8152602001806101dc603a913960400191505060405180910390fd5b600180549091019055565b6003546001600160a01b031633146101ab57600080fd5b6000908152600260205260409020805460ff19166001179055565b60009081526002602052604090205460ff169056fe4f6e6c7920616363657373206d616e6167657220636f6e74726163742063616e206164642062616c616e636520696e204e50206163636f756e74a265627a7a723158200db1e8c57e6c42d8a842578a770d6dc6f69980742977b332a48bf4e0b190288364736f6c63430005100032";

    public static final String FUNC_ADDBALANCE = "addBalance";

    public static final String FUNC_ADDNEWSERVICE = "addNewService";

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
