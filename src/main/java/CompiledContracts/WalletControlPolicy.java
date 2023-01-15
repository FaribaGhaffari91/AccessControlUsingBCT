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
public class WalletControlPolicy extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516107053803806107058339818101604052602081101561003357600080fd5b5051600080546001600160a01b039092166001600160a01b03199092169190911790556106a0806100656000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c806331256e731461003b5780635cc9f42114610081575b600080fd5b61006d6004803603606081101561005157600080fd5b506001600160a01b0381351690602081013590604001356100a4565b604080519115158252519081900360200190f35b61006d6004803603604081101561009757600080fd5b50803590602001356103e0565b600080546040805163bf40fac160e01b815260206004808301829052602483015263292aa22160e11b6044830152915184936001600160a01b03169263bf40fac19260648082019391829003018186803b15801561010157600080fd5b505afa158015610115573d6000803e3d6000fd5b505050506040513d602081101561012b57600080fd5b505160408051633115e48760e11b81526001600160a01b03888116600483015291519293506000929184169163622bc90e91602480820192602092909190829003018186803b15801561017d57600080fd5b505afa158015610191573d6000803e3d6000fd5b505050506040513d60208110156101a757600080fd5b5051600080546040805163bf40fac160e01b815260206004820181905260056024830152642929a8222160d91b6044830152915194955092936001600160a01b039092169263bf40fac19260648083019392829003018186803b15801561020d57600080fd5b505afa158015610221573d6000803e3d6000fd5b505050506040513d602081101561023757600080fd5b505160408051636ef3669360e11b81526004810189905290519192506000916001600160a01b0384169163dde6cd26916024808301926020929190829003018186803b15801561028657600080fd5b505afa15801561029a573d6000803e3d6000fd5b505050506040513d60208110156102b057600080fd5b50516040805163e87ec79d60e01b81526004810189905290519192506001600160a01b0383169163e87ec79d91602480820192602092909190829003018186803b1580156102fd57600080fd5b505afa158015610311573d6000803e3d6000fd5b505050506040513d602081101561032757600080fd5b5051604080516321df0da760e01b815290516001600160a01b038616916321df0da7916004808301926020929190829003018186803b15801561036957600080fd5b505afa15801561037d573d6000803e3d6000fd5b505050506040513d602081101561039357600080fd5b505112156103d25760405162461bcd60e51b815260040180806020018281038252602f81526020018061063d602f913960400191505060405180910390fd5b506001979650505050505050565b600080546040805163bf40fac160e01b815260206004820181905260056024830152642929a8222160d91b6044830152915184936001600160a01b03169263bf40fac19260648082019391829003018186803b15801561043f57600080fd5b505afa158015610453573d6000803e3d6000fd5b505050506040513d602081101561046957600080fd5b505160408051636ef3669360e11b81526004810187905290519192506000916001600160a01b0384169163dde6cd26916024808301926020929190829003018186803b1580156104b857600080fd5b505afa1580156104cc573d6000803e3d6000fd5b505050506040513d60208110156104e257600080fd5b505160408051635090d36160e11b81526004810187905290519192506001600160a01b0383169163a121a6c291602480820192602092909190829003018186803b15801561052f57600080fd5b505afa158015610543573d6000803e3d6000fd5b505050506040513d602081101561055957600080fd5b5051604080516321df0da760e01b815290516001600160a01b038416916321df0da7916004808301926020929190829003018186803b15801561059b57600080fd5b505afa1580156105af573d6000803e3d6000fd5b505050506040513d60208110156105c557600080fd5b505112156106045760405162461bcd60e51b815260040180806020018281038252602d815260200180610610602d913960400191505060405180910390fd5b50600194935050505056fe5350277320746f6b656e206973206e6f7420656e6f75676820746f20737461727420746865207365727669636555736572277320746f6b656e206973206e6f7420656e6f75676820746f207374617274207468652073657276696365a265627a7a723158202cae76f254753e9e85620f0160e2ccc142b880287285c83c8b3ab97cc906b6a564736f6c63430005100032";

    public static final String FUNC_ISSPTOKENENOUGH = "isSPTokenEnough";

    public static final String FUNC_ISUSERTOKENENOUGH = "isUserTokenEnough";

    @Deprecated
    protected WalletControlPolicy(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected WalletControlPolicy(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected WalletControlPolicy(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected WalletControlPolicy(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Boolean> isSPTokenEnough(BigInteger _providerCode, BigInteger _serviceCode) {
        final Function function = new Function(FUNC_ISSPTOKENENOUGH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_providerCode), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceCode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> isUserTokenEnough(String _userAddress, BigInteger _providerCode, BigInteger _serviceCode) {
        final Function function = new Function(FUNC_ISUSERTOKENENOUGH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _userAddress), 
                new org.web3j.abi.datatypes.generated.Int256(_providerCode), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceCode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static WalletControlPolicy load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new WalletControlPolicy(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static WalletControlPolicy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new WalletControlPolicy(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static WalletControlPolicy load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new WalletControlPolicy(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static WalletControlPolicy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new WalletControlPolicy(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<WalletControlPolicy> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(WalletControlPolicy.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<WalletControlPolicy> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(WalletControlPolicy.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<WalletControlPolicy> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(WalletControlPolicy.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<WalletControlPolicy> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(WalletControlPolicy.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
