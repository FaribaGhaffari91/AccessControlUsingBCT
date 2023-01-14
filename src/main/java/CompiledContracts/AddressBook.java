package CompiledContracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
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
public class AddressBook extends Contract {
    private static final String BINARY = "6080806040523461007057602560018060a01b031991338360005416176000556427bbb732b960d91b815260016005820152203382825416179055602b6040516a41646472657373426f6f6b60a81b81526001600b8201522090309082541617905560405161023a90816100768239f35b600080fdfe608060405260048036101561001357600080fd5b600090813560e01c8063bf40fac1146100f95763d75bbaa71461003557600080fd5b346100f55760403660031901126100f5576001600160a01b03813581811692908390036100f15760243567ffffffffffffffff81116100ed5761007b903690830161014d565b91610085836101cb565b54166100a95750610095906101cb565b80546001600160a01b031916909117905580f35b60649060206040519162461bcd60e51b8352820152602060248201527f74686973206164647265737320697320696e69746961746564206265666f72656044820152fd5b8480fd5b8380fd5b5080fd5b50903461014a57602036600319011261014a5781359067ffffffffffffffff821161014a57506020916001600160a01b03916101409161013b9136910161014d565b6101cb565b5416604051908152f35b80fd5b81601f820112156101b05780359067ffffffffffffffff928383116101b55760405193601f8401601f19908116603f01168501908111858210176101b557604052828452602083830101116101b057816000926020809301838601378301015290565b600080fd5b634e487b7160e01b600052604160045260246000fd5b604051908181519160005b8381106101ef5750506020918101600181520301902090565b602082820181015186830152859350016101d656fea26469706673582212200296dffe3c70f6706334cc56e9979ce8a0873ed5013e0872da367f99c1dfa98564736f6c63430008110033";

    public static final String FUNC_GETADDRESS = "getAddress";

    public static final String FUNC_SETNEWADDRESS = "setNewAddress";

    @Deprecated
    protected AddressBook(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AddressBook(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AddressBook(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AddressBook(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> getAddress(String _name) {
        final Function function = new Function(
                FUNC_GETADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setNewAddress(String _Address, String _name) {
        final Function function = new Function(
                FUNC_SETNEWADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _Address), 
                new org.web3j.abi.datatypes.Utf8String(_name)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static AddressBook load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AddressBook(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AddressBook load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AddressBook(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AddressBook load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AddressBook(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AddressBook load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AddressBook(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AddressBook> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AddressBook.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<AddressBook> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AddressBook.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AddressBook> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AddressBook.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AddressBook> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AddressBook.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
