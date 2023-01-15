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
    private static final String BINARY = "608060405234801561001057600080fd5b5060405161068e38038061068e8339818101604052606081101561003357600080fd5b5080516020820151604090920151600080546001600160a01b031990811633178255600180546001600160a01b0395861690831617905560028054949095169316929092179092556003919091556005556105fb806100936000396000f3fe608060405234801561001057600080fd5b50600436106100cf5760003560e01c80635bc4fc471161008c5780639f474b20116100665780639f474b2014610216578063a121a6c214610233578063b120a15a14610250578063e87ec79d1461026d576100cf565b80635bc4fc47146101875780637c3f5921146101be5780637d8411af146101db576100cf565b80632032c8b8146100d457806321df0da7146100f957806325752b051461011357806341c18af3146101305780634bfbf7731461014d578063574a9a341461016a575b600080fd5b6100f7600480360360408110156100ea57600080fd5b508035906020013561028a565b005b6101016102c6565b60408051918252519081900360200190f35b6100f76004803603602081101561012957600080fd5b50356102cc565b6100f76004803603602081101561014657600080fd5b503561037d565b6101016004803603602081101561016357600080fd5b5035610394565b6101016004803603602081101561018057600080fd5b50356103a9565b6101aa6004803603604081101561019d57600080fd5b50803590602001356103bf565b604080519115158252519081900360200190f35b610101600480360360208110156101d457600080fd5b50356103de565b6100f7600480360360c08110156101f157600080fd5b5080359060208101359060408101359060608101359060808101359060a001356103f3565b6100f76004803603602081101561022c57600080fd5b503561049a565b6101016004803603602081101561024957600080fd5b503561054a565b6101016004803603602081101561026657600080fd5b503561055f565b6101016004803603602081101561028357600080fd5b5035610574565b6002546001600160a01b031633146102a157600080fd5b600090815260076020908152604080832093835292905220805460ff19166001179055565b60065490565b6001546040805163bf40fac160e01b8152602060048201819052600b60248301526a149959d0dbdb9d1c9858dd60aa1b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b15801561033257600080fd5b505afa158015610346573d6000803e3d6000fd5b505050506040513d602081101561035c57600080fd5b50516001600160a01b0316331461037257600080fd5b600680549091019055565b6002546001600160a01b0316331461037257600080fd5b60009081526004602052604090206006015490565b6000908152600460208190526040909120015490565b6000908152600760209081526040808320938352929052205460ff1690565b60009081526004602052604090206001015490565b6002546001600160a01b0316331461040a57600080fd5b60058054600101905561041b610589565b506040805160e0810182526005805480835260208084019a8b52838501998a52606084019889526080840197885260a0840196875260c084019586526000918252600490819052939020915182559751600182015595516002870155935160038601559151928401929092559051928201929092559051600690910155565b6001546040805163bf40fac160e01b8152602060048201819052600960248301526820a1a6b0b730b3b2b960b91b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b1580156104fe57600080fd5b505afa158015610512573d6000803e3d6000fd5b505050506040513d602081101561052857600080fd5b50516001600160a01b0316331461053e57600080fd5b60068054919091039055565b60009081526004602052604090206003015490565b60009081526004602052604090206002015490565b60009081526004602052604090206005015490565b6040518060e0016040528060008152602001600081526020016000815260200160008152602001600081526020016000815260200160008152509056fea265627a7a723158202416a05d51b4927cb6d58b843b86070ef0b726be539addd90fb83fbfa282755364736f6c63430005100032";

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
