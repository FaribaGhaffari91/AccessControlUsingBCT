package CompiledContracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
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
public class PolicyDataBaseContract extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060405161020c38038061020c8339818101604052602081101561003357600080fd5b5051600080546001600160a01b031990811633178255600180546001600160a01b038086169190931617908190556040805163d75bbaa760e01b815230600482015260248101829052600360448201526228222160e91b60648201529051919092169263d75bbaa7926084808201939182900301818387803b1580156100b857600080fd5b505af11580156100cc573d6000803e3d6000fd5b505050505061012c806100e06000396000f3fe6080604052348015600f57600080fd5b506004361060325760003560e01c80636e29e75c146037578063dac3c769146062575b600080fd5b606060048036036040811015604b57600080fd5b506001600160a01b0381351690602001356098565b005b607c60048036036020811015607657600080fd5b503560dc565b604080516001600160a01b039092168252519081900360200190f35b6000546001600160a01b0316331460ae57600080fd5b600090815260026020526040902080546001600160a01b0319166001600160a01b0392909216919091179055565b6000908152600260205260409020546001600160a01b03169056fea265627a7a7231582018c242625ced5b0c716dd1c311fa7416d226b1fe69efe6ecdd3e2e13d7756bb764736f6c63430005100032";

    public static final String FUNC_ADDPOLICY = "addPolicy";

    public static final String FUNC_GETCONTRACT = "getContract";

    @Deprecated
    protected PolicyDataBaseContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PolicyDataBaseContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PolicyDataBaseContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PolicyDataBaseContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addPolicy(String _policyContract, BigInteger _code) {
        final Function function = new Function(
                FUNC_ADDPOLICY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _policyContract), 
                new org.web3j.abi.datatypes.generated.Int256(_code)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getContract(BigInteger _code) {
        final Function function = new Function(FUNC_GETCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_code)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static PolicyDataBaseContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PolicyDataBaseContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PolicyDataBaseContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PolicyDataBaseContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PolicyDataBaseContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PolicyDataBaseContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PolicyDataBaseContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PolicyDataBaseContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PolicyDataBaseContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(PolicyDataBaseContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<PolicyDataBaseContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(PolicyDataBaseContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<PolicyDataBaseContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(PolicyDataBaseContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<PolicyDataBaseContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(PolicyDataBaseContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
