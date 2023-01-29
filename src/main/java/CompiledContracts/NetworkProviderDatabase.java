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
public class NetworkProviderDatabase extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516104b43803806104b48339818101604052602081101561003357600080fd5b5051600080546001600160a01b0319166001600160a01b03808416919091178083556040805163d75bbaa760e01b8152306004820152602481018290526005604482015264292728222160d91b606482015290519190921692839263d75bbaa7926084808301939282900301818387803b1580156100b057600080fd5b505af11580156100c4573d6000803e3d6000fd5b5050505050506103db806100d96000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80632ff6312d146100515780633f7d7df11461008a578063d7e5fbf3146100b8578063f434744f146100e6575b600080fd5b61006e6004803603602081101561006757600080fd5b5035610120565b604080516001600160a01b039092168252519081900360200190f35b6100b6600480360360408110156100a057600080fd5b50803590602001356001600160a01b031661014c565b005b6100b6600480360360408110156100ce57600080fd5b506001600160a01b0381358116916020013516610269565b61010c600480360360208110156100fc57600080fd5b50356001600160a01b0316610386565b604080519115158252519081900360200190f35b6000908152600160209081526040808320546001600160a01b0390811684526002909252909120541690565b6000546040805163bf40fac160e01b8152602060048201819052600b60248301526a149959d0dbdb9d1c9858dd60aa1b604483015291516001600160a01b0390931692839263bf40fac19260648082019391829003018186803b1580156101b257600080fd5b505afa1580156101c6573d6000803e3d6000fd5b505050506040513d60208110156101dc57600080fd5b50516001600160a01b0316331461023a576040805162461bcd60e51b815260206004820152601b60248201527f746869732066756e6374696f6e20697320726573747269637465640000000000604482015290519081900360640190fd5b5060009182526001602052604090912080546001600160a01b0319166001600160a01b03909216919091179055565b6000546040805163bf40fac160e01b8152602060048201819052600b60248301526a149959d0dbdb9d1c9858dd60aa1b604483015291516001600160a01b0390931692839263bf40fac19260648082019391829003018186803b1580156102cf57600080fd5b505afa1580156102e3573d6000803e3d6000fd5b505050506040513d60208110156102f957600080fd5b50516001600160a01b03163314610357576040805162461bcd60e51b815260206004820152601b60248201527f746869732066756e6374696f6e20697320726573747269637465640000000000604482015290519081900360640190fd5b506001600160a01b03918216600090815260026020526040902080546001600160a01b03191691909216179055565b6001600160a01b039081166000908152600260205260409020541615159056fea265627a7a723158205b9a1bf614e73d92308a2df2a69b8ba14faf7e6a93293586c9b02c908c41050864736f6c63430005100032";

    public static final String FUNC_ADDNEWPROVIDER = "addNewProvider";

    public static final String FUNC_GETNPCONTRACTADDRESSBYCODE = "getNPContractAddressByCode";

    public static final String FUNC_ISNPEXIST = "isNPExist";

    public static final String FUNC_REGISTERCONTRACT = "registerContract";

    @Deprecated
    protected NetworkProviderDatabase(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected NetworkProviderDatabase(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected NetworkProviderDatabase(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected NetworkProviderDatabase(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addNewProvider(BigInteger _code, String _npAddress) {
        final Function function = new Function(
                FUNC_ADDNEWPROVIDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_code), 
                new org.web3j.abi.datatypes.Address(160, _npAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getNPContractAddressByCode(BigInteger _code) {
        final Function function = new Function(FUNC_GETNPCONTRACTADDRESSBYCODE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_code)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> isNPExist(String _np) {
        final Function function = new Function(FUNC_ISNPEXIST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _np)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> registerContract(String _npAddress, String _npContract) {
        final Function function = new Function(
                FUNC_REGISTERCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _npAddress), 
                new org.web3j.abi.datatypes.Address(160, _npContract)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static NetworkProviderDatabase load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new NetworkProviderDatabase(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static NetworkProviderDatabase load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new NetworkProviderDatabase(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static NetworkProviderDatabase load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new NetworkProviderDatabase(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static NetworkProviderDatabase load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new NetworkProviderDatabase(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<NetworkProviderDatabase> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(NetworkProviderDatabase.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<NetworkProviderDatabase> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(NetworkProviderDatabase.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<NetworkProviderDatabase> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(NetworkProviderDatabase.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<NetworkProviderDatabase> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(NetworkProviderDatabase.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
