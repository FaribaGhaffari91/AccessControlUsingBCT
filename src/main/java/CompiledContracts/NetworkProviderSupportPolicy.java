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
public class NetworkProviderSupportPolicy extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060405161028c38038061028c8339818101604052602081101561003357600080fd5b5051600080546001600160a01b039092166001600160a01b0319909216919091179055610227806100656000396000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c8063c413aff614610030575b600080fd5b6100536004803603604081101561004657600080fd5b5080359060200135610067565b604080519115158252519081900360200190f35b600080546040805163bf40fac160e01b81526020600482018190526005602483015264292728222160d91b604483015291516001600160a01b03909316928492849263bf40fac19260648083019392829003018186803b1580156100ca57600080fd5b505afa1580156100de573d6000803e3d6000fd5b505050506040513d60208110156100f457600080fd5b505160408051632ff6312d60e01b81526004810188905290519192506000916001600160a01b03841691632ff6312d916024808301926020929190829003018186803b15801561014357600080fd5b505afa158015610157573d6000803e3d6000fd5b505050506040513d602081101561016d57600080fd5b505160408051637ba51eb760e11b815260048101889052905191925082916001600160a01b0383169163f74a3d6e916024808301926020929190829003018186803b1580156101bb57600080fd5b505afa1580156101cf573d6000803e3d6000fd5b505050506040513d60208110156101e557600080fd5b505197965050505050505056fea265627a7a723158201a1012004d29cd995936ba80646a9b12e187d9197bbcfa6705cb02e5eae65f1d64736f6c63430005100032";

    public static final String FUNC_DOPROVIDERSUPPORT = "doProviderSupport";

    @Deprecated
    protected NetworkProviderSupportPolicy(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected NetworkProviderSupportPolicy(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected NetworkProviderSupportPolicy(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected NetworkProviderSupportPolicy(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Boolean> doProviderSupport(BigInteger _npCode, BigInteger _serviceCode) {
        final Function function = new Function(FUNC_DOPROVIDERSUPPORT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_npCode), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceCode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static NetworkProviderSupportPolicy load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new NetworkProviderSupportPolicy(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static NetworkProviderSupportPolicy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new NetworkProviderSupportPolicy(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static NetworkProviderSupportPolicy load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new NetworkProviderSupportPolicy(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static NetworkProviderSupportPolicy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new NetworkProviderSupportPolicy(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<NetworkProviderSupportPolicy> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(NetworkProviderSupportPolicy.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<NetworkProviderSupportPolicy> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(NetworkProviderSupportPolicy.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<NetworkProviderSupportPolicy> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(NetworkProviderSupportPolicy.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<NetworkProviderSupportPolicy> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(NetworkProviderSupportPolicy.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
