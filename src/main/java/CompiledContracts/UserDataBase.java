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
public class UserDataBase extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516103883803806103888339818101604052602081101561003357600080fd5b5051600080546001600160a01b031990811633178255600280546001600160a01b038086169190931617908190556040805163d75bbaa760e01b81523060048083019190915260248201839052604482015263292aa22160e11b60648201529051919092169263d75bbaa7926084808201939182900301818387803b1580156100bb57600080fd5b505af11580156100cf573d6000803e3d6000fd5b50505050506102a5806100e36000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c8063196fe859146100465780631f5bdf5d14610076578063622bc90e146100b0575b600080fd5b6100746004803603604081101561005c57600080fd5b506001600160a01b03813581169160200135166100f2565b005b61009c6004803603602081101561008c57600080fd5b50356001600160a01b03166101f8565b604080519115158252519081900360200190f35b6100d6600480360360208110156100c657600080fd5b50356001600160a01b0316610218565b604080516001600160a01b039092168252519081900360200190f35b6002546040805163bf40fac160e01b8152602060048201819052600b60248301526a149959d0dbdb9d1c9858dd60aa1b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b15801561015857600080fd5b505afa15801561016c573d6000803e3d6000fd5b505050506040513d602081101561018257600080fd5b50516001600160a01b031633146101ca5760405162461bcd60e51b815260040180806020018281038252603a815260200180610237603a913960400191505060405180910390fd5b6001600160a01b03918216600090815260016020526040902080546001600160a01b03191691909216179055565b6001600160a01b0390811660009081526001602052604090205416151590565b6001600160a01b03908116600090815260016020526040902054169056fe546869732066756e6374696f6e206f6e6c792063616e2062652063616c6c65642062792052656769737465726174696f6e20636f6e7472616374a265627a7a72315820566aa01bca20fd393cc87a2f819702536b486937f827189c339a91208c6016c064736f6c63430005100032";

    public static final String FUNC_ADDNEWUSER = "addNewUser";

    public static final String FUNC_GETCONTRACTADDRESS = "getContractAddress";

    public static final String FUNC_ISREGISTEREDUSER = "isRegisteredUser";

    @Deprecated
    protected UserDataBase(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected UserDataBase(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected UserDataBase(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected UserDataBase(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addNewUser(String _uAddress, String _cAddress) {
        final Function function = new Function(
                FUNC_ADDNEWUSER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _uAddress), 
                new org.web3j.abi.datatypes.Address(160, _cAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getContractAddress(String _userAddress) {
        final Function function = new Function(FUNC_GETCONTRACTADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _userAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> isRegisteredUser(String _userAddress) {
        final Function function = new Function(FUNC_ISREGISTEREDUSER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _userAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static UserDataBase load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new UserDataBase(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static UserDataBase load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new UserDataBase(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static UserDataBase load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new UserDataBase(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static UserDataBase load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new UserDataBase(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<UserDataBase> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(UserDataBase.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<UserDataBase> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(UserDataBase.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<UserDataBase> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(UserDataBase.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<UserDataBase> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(UserDataBase.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
