package CompiledContracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
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
public class ServiceProviderDatabase extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516104ad3803806104ad8339818101604052602081101561003357600080fd5b5051600080546001600160a01b0319166001600160a01b03808416919091178083556040805163d75bbaa760e01b81523060048201526024810182905260056044820152642929a8222160d91b60648201529051919092169263d75bbaa7926084808201939182900301818387803b1580156100ae57600080fd5b505af11580156100c2573d6000803e3d6000fd5b50505050506103d7806100d66000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80633eed642c146100515780633f7d7df11461008b578063d7e5fbf3146100b9578063dde6cd26146100e7575b600080fd5b6100776004803603602081101561006757600080fd5b50356001600160a01b0316610120565b604080519115158252519081900360200190f35b6100b7600480360360408110156100a157600080fd5b50803590602001356001600160a01b0316610140565b005b6100b7600480360360408110156100cf57600080fd5b506001600160a01b038135811691602001351661023e565b610104600480360360208110156100fd57600080fd5b503561033c565b604080516001600160a01b039092168252519081900360200190f35b6001600160a01b0390811660009081526002602052604090205416151590565b6000546040805163bf40fac160e01b8152602060048201819052600360248301526252454760e81b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b15801561019e57600080fd5b505afa1580156101b2573d6000803e3d6000fd5b505050506040513d60208110156101c857600080fd5b50516001600160a01b031633146102105760405162461bcd60e51b815260040180806020018281038252603a815260200180610369603a913960400191505060405180910390fd5b60009182526001602052604090912080546001600160a01b0319166001600160a01b03909216919091179055565b6000546040805163bf40fac160e01b8152602060048201819052600360248301526252454760e81b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b15801561029c57600080fd5b505afa1580156102b0573d6000803e3d6000fd5b505050506040513d60208110156102c657600080fd5b50516001600160a01b0316331461030e5760405162461bcd60e51b815260040180806020018281038252603a815260200180610369603a913960400191505060405180910390fd5b6001600160a01b03918216600090815260026020526040902080546001600160a01b03191691909216179055565b6000908152600160209081526040808320546001600160a01b039081168452600290925290912054169056fe546869732066756e6374696f6e206f6e6c792063616e2062652063616c6c65642062792052656769737465726174696f6e20636f6e7472616374a265627a7a7231582057536a0d6ea9b5755bb4d807578ff966ed9769600814f8e0016c594f9a2961a864736f6c63430005100032";

    public static final String FUNC_ADDNEWPROVIDER = "addNewProvider";

    public static final String FUNC_GETSPCONTRACTADDRESSBYCODE = "getSPContractAddressByCode";

    public static final String FUNC_ISPROVIDEREXIST = "isProviderExist";

    public static final String FUNC_REGISTERCONTRACT = "registerContract";

    @Deprecated
    protected ServiceProviderDatabase(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ServiceProviderDatabase(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ServiceProviderDatabase(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ServiceProviderDatabase(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addNewProvider(BigInteger _code, String _spAddress) {
        final Function function = new Function(
                FUNC_ADDNEWPROVIDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_code), 
                new org.web3j.abi.datatypes.Address(160, _spAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getSPContractAddressByCode(BigInteger _code) {
        final Function function = new Function(FUNC_GETSPCONTRACTADDRESSBYCODE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_code)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> isProviderExist(String _sp) {
        final Function function = new Function(FUNC_ISPROVIDEREXIST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _sp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> registerContract(String _spAddress, String _spContract) {
        final Function function = new Function(
                FUNC_REGISTERCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _spAddress), 
                new org.web3j.abi.datatypes.Address(160, _spContract)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ServiceProviderDatabase load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ServiceProviderDatabase(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ServiceProviderDatabase load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ServiceProviderDatabase(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ServiceProviderDatabase load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ServiceProviderDatabase(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ServiceProviderDatabase load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ServiceProviderDatabase(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ServiceProviderDatabase> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(ServiceProviderDatabase.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ServiceProviderDatabase> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(ServiceProviderDatabase.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ServiceProviderDatabase> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(ServiceProviderDatabase.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ServiceProviderDatabase> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(ServiceProviderDatabase.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
