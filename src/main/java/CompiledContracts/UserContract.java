package CompiledContracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
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
public class UserContract extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516105453803806105458339818101604052604081101561003357600080fd5b508051602091820151600180546001600160a01b0319166001600160a01b0380851691909117918290556040805163bf40fac160e01b815260048101879052600b60248201526a149959d0dbdb9d1c9858dd60aa1b60448201529051949593949290911692839263bf40fac1926064808201939291829003018186803b1580156100bc57600080fd5b505afa1580156100d0573d6000803e3d6000fd5b505050506040513d60208110156100e657600080fd5b50516001600160a01b0316331461012e5760405162461bcd60e51b815260040180806020018281038252603781526020018061050e6037913960400191505060405180910390fd5b5060008055600380546001600160a01b03909216610100026001600160a81b0319909216919091179055506103a6806101686000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c806341c18af31161005b57806341c18af31461012c578063507966e014610149578063979c86f114610166578063a330de2b1461018357610088565b806305364a1d1461008d5780630f248d38146100c457806321df0da7146100ef57806322fa871814610109575b600080fd5b6100b0600480360360408110156100a357600080fd5b50803590602001356101b2565b604080519115158252519081900360200190f35b6100ed600480360360608110156100da57600080fd5b50803590602081013590604001356101d5565b005b6100f761024d565b60408051918252519081900360200190f35b6100f76004803603604081101561011f57600080fd5b5080359060200135610253565b6100ed6004803603602081101561014257600080fd5b5035610271565b6100ed6004803603602081101561015f57600080fd5b503561028d565b6100ed6004803603602081101561017c57600080fd5b5035610298565b6100ed6004803603608081101561019957600080fd5b50803590602081013590604081013590606001356102a4565b600091825260026020908152604080842092845291905290206004015460ff1690565b6000838152600260208181526040808420868552909152909120015442106102215760008381526002602081815260408084208685529091529091204262015180840201910155610248565b60008381526002602081815260408084208685529091529091200180546201518083020190555b505050565b60005490565b60009182526002602081815260408085209385529290529120015490565b60035461010090046001600160a01b0316331461028d57600080fd5b600080549091019055565b60008054919091039055565b6102ac610339565b506040805160c081018252858152602080820186815262015180860242018385019081526060840196875260016080850181815260a0860197885260009a8b526002808652878c209a8c52999094529490982092518355519282019290925594519385019390935590516003840155905160048301805460ff191691151591909117905551600590910155565b6040518060c001604052806000815260200160008152602001600081526020016000815260200160001515815260200160008152509056fea265627a7a723158201affa6c768e678dad6572280437bc8cdfbdb0f547c9b287eb19fc1ee2bab740964736f6c634300051000325468697320636f6e7472616374206f6e6c792063616e206265206465706c6f79656420627920526567697374657220436f6e7472616374";

    public static final String FUNC_CHARGEMYWALLET = "chargeMyWallet";

    public static final String FUNC_CHARGETOKEN = "chargeToken";

    public static final String FUNC_GETEXPIRATIONTIME = "getExpirationTime";

    public static final String FUNC_GETTOKEN = "getToken";

    public static final String FUNC_ISREGISTEREDINSERVICE = "isRegisteredInService";

    public static final String FUNC_PAYTOKEN = "payToken";

    public static final String FUNC_SERVICEREGISTRATION = "serviceRegistration";

    public static final String FUNC_UPDATEEXPIRATIONTIME = "updateExpirationTime";

    @Deprecated
    protected UserContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected UserContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected UserContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected UserContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> chargeMyWallet(BigInteger Token) {
        final Function function = new Function(
                FUNC_CHARGEMYWALLET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(Token)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> chargeToken(BigInteger _token) {
        final Function function = new Function(
                FUNC_CHARGETOKEN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_token)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getExpirationTime(BigInteger _providerCode, BigInteger _serviceCode) {
        final Function function = new Function(FUNC_GETEXPIRATIONTIME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_providerCode), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceCode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getToken() {
        final Function function = new Function(FUNC_GETTOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> isRegisteredInService(BigInteger _providerCode, BigInteger _serviceCode) {
        final Function function = new Function(FUNC_ISREGISTEREDINSERVICE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_providerCode), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceCode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> payToken(BigInteger _token) {
        final Function function = new Function(
                FUNC_PAYTOKEN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_token)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> serviceRegistration(BigInteger _providerCode, BigInteger _serviceCode, BigInteger _dateOrTime, BigInteger _serviceType) {
        final Function function = new Function(
                FUNC_SERVICEREGISTRATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_providerCode), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceCode), 
                new org.web3j.abi.datatypes.generated.Uint256(_dateOrTime), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceType)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateExpirationTime(BigInteger _providerCode, BigInteger _serviceCode, BigInteger _validationDuration) {
        final Function function = new Function(
                FUNC_UPDATEEXPIRATIONTIME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_providerCode), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceCode), 
                new org.web3j.abi.datatypes.generated.Uint256(_validationDuration)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static UserContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new UserContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static UserContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new UserContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static UserContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new UserContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static UserContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new UserContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<UserContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _addressBook, String _userAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook), 
                new org.web3j.abi.datatypes.Address(160, _userAddress)));
        return deployRemoteCall(UserContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<UserContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _addressBook, String _userAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook), 
                new org.web3j.abi.datatypes.Address(160, _userAddress)));
        return deployRemoteCall(UserContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<UserContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _addressBook, String _userAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook), 
                new org.web3j.abi.datatypes.Address(160, _userAddress)));
        return deployRemoteCall(UserContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<UserContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _addressBook, String _userAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook), 
                new org.web3j.abi.datatypes.Address(160, _userAddress)));
        return deployRemoteCall(UserContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
