package CompiledContracts;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
public class RegisteredInSPPolicy extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516102a23803806102a28339818101604052602081101561003357600080fd5b5051600080546001600160a01b039092166001600160a01b031990921691909117905561023d806100656000396000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c8063ad12ef0a14610030575b600080fd5b6100626004803603606081101561004657600080fd5b506001600160a01b038135169060208101359060400135610076565b604080519115158252519081900360200190f35b600080546040805163bf40fac160e01b815260206004808301829052602483015263292aa22160e11b604483015291516001600160a01b03909316928492849263bf40fac19260648083019392829003018186803b1580156100d757600080fd5b505afa1580156100eb573d6000803e3d6000fd5b505050506040513d602081101561010157600080fd5b505160408051633115e48760e11b81526001600160a01b03898116600483015291519293506000929184169163622bc90e91602480820192602092909190829003018186803b15801561015357600080fd5b505afa158015610167573d6000803e3d6000fd5b505050506040513d602081101561017d57600080fd5b5051604080516305364a1d60e01b8152600481018990526024810188905290519192506001600160a01b038316916305364a1d91604480820192602092909190829003018186803b1580156101d157600080fd5b505afa1580156101e5573d6000803e3d6000fd5b505050506040513d60208110156101fb57600080fd5b505197965050505050505056fea265627a7a723158205b2bbb771b09d1f46d7623cdc4bcf4128fc71a2c69f7a40d71fec1fb561ab85e64736f6c63430005100032";

    public static final String FUNC_ISUSERREGISTERED = "isUserRegistered";

    @Deprecated
    protected RegisteredInSPPolicy(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RegisteredInSPPolicy(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected RegisteredInSPPolicy(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected RegisteredInSPPolicy(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Boolean> isUserRegistered(String _userAddress, BigInteger _providerCode, BigInteger _serviceCode) {
        final Function function = new Function(FUNC_ISUSERREGISTERED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _userAddress), 
                new org.web3j.abi.datatypes.generated.Int256(_providerCode), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceCode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static RegisteredInSPPolicy load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RegisteredInSPPolicy(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static RegisteredInSPPolicy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RegisteredInSPPolicy(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RegisteredInSPPolicy load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new RegisteredInSPPolicy(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static RegisteredInSPPolicy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new RegisteredInSPPolicy(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<RegisteredInSPPolicy> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(RegisteredInSPPolicy.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<RegisteredInSPPolicy> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(RegisteredInSPPolicy.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<RegisteredInSPPolicy> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(RegisteredInSPPolicy.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<RegisteredInSPPolicy> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(RegisteredInSPPolicy.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
