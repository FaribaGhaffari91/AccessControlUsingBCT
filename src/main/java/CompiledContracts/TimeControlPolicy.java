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
public class TimeControlPolicy extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516102a43803806102a48339818101604052602081101561003357600080fd5b5051600080546001600160a01b039092166001600160a01b031990921691909117905561023f806100656000396000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c80631a6c187314610030575b600080fd5b6100626004803603606081101561004657600080fd5b506001600160a01b038135169060208101359060400135610076565b604080519115158252519081900360200190f35b600080546040805163bf40fac160e01b815260206004808301829052602483015263292aa22160e11b604483015291516001600160a01b03909316928492849263bf40fac19260648083019392829003018186803b1580156100d757600080fd5b505afa1580156100eb573d6000803e3d6000fd5b505050506040513d602081101561010157600080fd5b505160408051633115e48760e11b81526001600160a01b03898116600483015291519293506000929184169163622bc90e91602480820192602092909190829003018186803b15801561015357600080fd5b505afa158015610167573d6000803e3d6000fd5b505050506040513d602081101561017d57600080fd5b50516040805163045f50e360e31b8152600481018990526024810188905290519192506001600160a01b038316916322fa871891604480820192602092909190829003018186803b1580156101d157600080fd5b505afa1580156101e5573d6000803e3d6000fd5b505050506040513d60208110156101fb57600080fd5b5051421097965050505050505056fea265627a7a72315820ef722bdba9364eefb8b58a76257e37c3403f5a7312644db3ac82b715613a256a64736f6c63430005100032";

    public static final String FUNC_ISACCESSTIMEVALID = "isAccessTimeValid";

    @Deprecated
    protected TimeControlPolicy(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TimeControlPolicy(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TimeControlPolicy(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TimeControlPolicy(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Boolean> isAccessTimeValid(String _userAddress, BigInteger _serviceProvider, BigInteger _serviceCode) {
        final Function function = new Function(FUNC_ISACCESSTIMEVALID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _userAddress), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceProvider), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceCode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static TimeControlPolicy load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TimeControlPolicy(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TimeControlPolicy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TimeControlPolicy(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TimeControlPolicy load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TimeControlPolicy(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TimeControlPolicy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TimeControlPolicy(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TimeControlPolicy> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(TimeControlPolicy.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<TimeControlPolicy> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(TimeControlPolicy.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TimeControlPolicy> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(TimeControlPolicy.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TimeControlPolicy> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(TimeControlPolicy.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
