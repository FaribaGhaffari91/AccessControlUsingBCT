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
public class ServiceProviderContract extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516104e23803806104e28339818101604052606081101561003357600080fd5b5080516020820151604090920151600080546001600160a01b031990811633178255600180546001600160a01b03958616908316179055600280549490951693169290921790925560039190915560055561044f806100936000396000f3fe608060405234801561001057600080fd5b50600436106100cf5760003560e01c80635bc4fc471161008c5780639f474b20116100665780639f474b20146101f9578063a121a6c214610216578063b120a15a14610233578063e87ec79d14610250576100cf565b80635bc4fc471461016a5780637c3f5921146101a15780637d8411af146101be576100cf565b80632032c8b8146100d457806321df0da7146100f957806325752b051461011357806341c18af3146101135780634bfbf77314610130578063574a9a341461014d575b600080fd5b6100f7600480360360408110156100ea57600080fd5b508035906020013561026d565b005b610101610292565b60408051918252519081900360200190f35b6100f76004803603602081101561012957600080fd5b5035610298565b6101016004803603602081101561014657600080fd5b50356102a3565b6101016004803603602081101561016357600080fd5b50356102b8565b61018d6004803603604081101561018057600080fd5b50803590602001356102ce565b604080519115158252519081900360200190f35b610101600480360360208110156101b757600080fd5b50356102ed565b6100f7600480360360c08110156101d457600080fd5b5080359060208101359060408101359060608101359060808101359060a00135610302565b6100f76004803603602081101561020f57600080fd5b5035610392565b6101016004803603602081101561022c57600080fd5b503561039e565b6101016004803603602081101561024957600080fd5b50356103b3565b6101016004803603602081101561026657600080fd5b50356103c8565b600090815260076020908152604080832093835292905220805460ff19166001179055565b60065490565b600680549091019055565b60009081526004602052604090206006015490565b6000908152600460208190526040909120015490565b6000908152600760209081526040808320938352929052205460ff1690565b60009081526004602052604090206001015490565b6005805460010190556103136103dd565b506040805160e0810182526005805480835260208084019a8b52838501998a52606084019889526080840197885260a0840196875260c084019586526000918252600490819052939020915182559751600182015595516002870155935160038601559151928401929092559051928201929092559051600690910155565b60068054919091039055565b60009081526004602052604090206003015490565b60009081526004602052604090206002015490565b60009081526004602052604090206005015490565b6040518060e0016040528060008152602001600081526020016000815260200160008152602001600081526020016000815260200160008152509056fea265627a7a72315820dbfff7e5ae4628c0a83b4af7a947be7aea04dc659d500cd233e1753a8eecc35064736f6c63430005100032";

    public static final String FUNC_ADDNEWSERVICE = "addNewService";

    public static final String FUNC_ADDPOLICY = "addPolicy";

    public static final String FUNC_ADDTOKEN = "addToken";

    public static final String FUNC_CHARGEMYWALLET = "chargeMyWallet";

    public static final String FUNC_GETMINPRICE = "getMinPrice";

    public static final String FUNC_GETNPSHARE = "getNPShare";

    public static final String FUNC_GETPRICEPAYASYOUGO = "getPricePayAsYouGo";

    public static final String FUNC_GETPRICEPREPAID = "getPricePrepaid";

    public static final String FUNC_GETREGPRICEFORUSER = "getRegPriceForUser";

    public static final String FUNC_GETSERVICETYPE = "getServiceType";

    public static final String FUNC_GETTOKEN = "getToken";

    public static final String FUNC_ISPOLICYAPPLICABLE = "isPolicyApplicable";

    public static final String FUNC_PAYTONP = "payToNP";

    @Deprecated
    protected ServiceProviderContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ServiceProviderContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ServiceProviderContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ServiceProviderContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addNewService(BigInteger _serviceType, BigInteger _serviceCostforUser, BigInteger _operatorFee, BigInteger _costForUser, BigInteger _minPrice, BigInteger _operatorShare) {
        final Function function = new Function(
                FUNC_ADDNEWSERVICE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_serviceType), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceCostforUser), 
                new org.web3j.abi.datatypes.generated.Int256(_operatorFee), 
                new org.web3j.abi.datatypes.generated.Int256(_costForUser), 
                new org.web3j.abi.datatypes.generated.Int256(_minPrice), 
                new org.web3j.abi.datatypes.generated.Int256(_operatorShare)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addPolicy(BigInteger _title, BigInteger _serviceCode) {
        final Function function = new Function(
                FUNC_ADDPOLICY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_title), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceCode)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addToken(BigInteger Token) {
        final Function function = new Function(
                FUNC_ADDTOKEN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(Token)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> chargeMyWallet(BigInteger Token) {
        final Function function = new Function(
                FUNC_CHARGEMYWALLET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(Token)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getMinPrice(BigInteger _serviceCode) {
        final Function function = new Function(FUNC_GETMINPRICE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_serviceCode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getNPShare(BigInteger _serviceCode) {
        final Function function = new Function(FUNC_GETNPSHARE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_serviceCode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getPricePayAsYouGo(BigInteger _serviceCode) {
        final Function function = new Function(FUNC_GETPRICEPAYASYOUGO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_serviceCode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getPricePrepaid(BigInteger _serviceCode) {
        final Function function = new Function(FUNC_GETPRICEPREPAID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_serviceCode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getRegPriceForUser(BigInteger _serviceCode) {
        final Function function = new Function(FUNC_GETREGPRICEFORUSER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_serviceCode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getServiceType(BigInteger _serviceCode) {
        final Function function = new Function(FUNC_GETSERVICETYPE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_serviceCode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getToken() {
        final Function function = new Function(FUNC_GETTOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> isPolicyApplicable(BigInteger _title, BigInteger _serviceCode) {
        final Function function = new Function(FUNC_ISPOLICYAPPLICABLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_title), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceCode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> payToNP(BigInteger Token) {
        final Function function = new Function(
                FUNC_PAYTONP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(Token)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ServiceProviderContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ServiceProviderContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ServiceProviderContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ServiceProviderContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ServiceProviderContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ServiceProviderContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ServiceProviderContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ServiceProviderContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ServiceProviderContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _addressBook, String _spOwner, BigInteger _providerCode) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook), 
                new org.web3j.abi.datatypes.Address(160, _spOwner), 
                new org.web3j.abi.datatypes.generated.Int256(_providerCode)));
        return deployRemoteCall(ServiceProviderContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ServiceProviderContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _addressBook, String _spOwner, BigInteger _providerCode) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook), 
                new org.web3j.abi.datatypes.Address(160, _spOwner), 
                new org.web3j.abi.datatypes.generated.Int256(_providerCode)));
        return deployRemoteCall(ServiceProviderContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ServiceProviderContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _addressBook, String _spOwner, BigInteger _providerCode) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook), 
                new org.web3j.abi.datatypes.Address(160, _spOwner), 
                new org.web3j.abi.datatypes.generated.Int256(_providerCode)));
        return deployRemoteCall(ServiceProviderContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ServiceProviderContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _addressBook, String _spOwner, BigInteger _providerCode) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook), 
                new org.web3j.abi.datatypes.Address(160, _spOwner), 
                new org.web3j.abi.datatypes.generated.Int256(_providerCode)));
        return deployRemoteCall(ServiceProviderContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
