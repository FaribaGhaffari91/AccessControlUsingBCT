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
public class ServiceProviderDatabase extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516105113803806105118339818101604052602081101561003357600080fd5b5051600080546001600160a01b0319166001600160a01b03808416919091178083556040805163d75bbaa760e01b81523060048201526024810182905260056044820152642929a8222160d91b606482015290519190921692839263d75bbaa7926084808301939282900301818387803b1580156100b057600080fd5b505af11580156100c4573d6000803e3d6000fd5b505050505050610438806100d96000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c80633eed642c1461005c5780633f7d7df114610096578063cace74b3146100c4578063d7e5fbf314610106578063dde6cd2614610134575b600080fd5b6100826004803603602081101561007257600080fd5b50356001600160a01b0316610151565b604080519115158252519081900360200190f35b6100c2600480360360408110156100ac57600080fd5b50803590602001356001600160a01b0316610171565b005b6100ea600480360360208110156100da57600080fd5b50356001600160a01b0316610278565b604080516001600160a01b039092168252519081900360200190f35b6100c26004803603604081101561011c57600080fd5b506001600160a01b0381358116916020013516610296565b6100ea6004803603602081101561014a57600080fd5b503561039d565b6001600160a01b0390811660009081526002602052604090205416151590565b6000546040805163bf40fac160e01b8152602060048201819052600b60248301526a149959d0dbdb9d1c9858dd60aa1b604483015291516001600160a01b0390931692839263bf40fac19260648082019391829003018186803b1580156101d757600080fd5b505afa1580156101eb573d6000803e3d6000fd5b505050506040513d602081101561020157600080fd5b50516001600160a01b031633146102495760405162461bcd60e51b815260040180806020018281038252603a8152602001806103ca603a913960400191505060405180910390fd5b5060009182526001602052604090912080546001600160a01b0319166001600160a01b03909216919091179055565b6001600160a01b039081166000908152600260205260409020541690565b6000546040805163bf40fac160e01b8152602060048201819052600b60248301526a149959d0dbdb9d1c9858dd60aa1b604483015291516001600160a01b0390931692839263bf40fac19260648082019391829003018186803b1580156102fc57600080fd5b505afa158015610310573d6000803e3d6000fd5b505050506040513d602081101561032657600080fd5b50516001600160a01b0316331461036e5760405162461bcd60e51b815260040180806020018281038252603a8152602001806103ca603a913960400191505060405180910390fd5b506001600160a01b03918216600090815260026020526040902080546001600160a01b03191691909216179055565b6000908152600160209081526040808320546001600160a01b039081168452600290925290912054169056fe546869732066756e6374696f6e206f6e6c792063616e2062652063616c6c65642062792052656769737465726174696f6e20636f6e7472616374a265627a7a723158205024106e85a117c471912bd8516ddb54de2b5f84ace5236074720940bea848d964736f6c63430005100032";

    public static final String FUNC_ADDNEWPROVIDER = "addNewProvider";

    public static final String FUNC_GETSPCONTRACTADDRESSBYADDRESS = "getSPContractAddressByAddress";

    public static final String FUNC_GETSPCONTRACTADDRESSBYCODE = "getSPContractAddressByCode";

    public static final String FUNC_ISPROVIDEREXIST = "isProviderExist";

    public static final String FUNC_REGISTERCONTRACT = "registerContract";

    @Deprecated
    protected ServiceProviderDatabase(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ServiceProviderDatabase(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ServiceProviderDatabase(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ServiceProviderDatabase(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addNewProvider(BigInteger _code, String _spAddress) {
        final Function function = new Function(
                FUNC_ADDNEWPROVIDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_code), 
                new org.web3j.abi.datatypes.Address(160, _spAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getSPContractAddressByAddress(String _spAddress) {
        final Function function = new Function(FUNC_GETSPCONTRACTADDRESSBYADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _spAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getSPContractAddressByCode(BigInteger _code) {
        final Function function = new Function(FUNC_GETSPCONTRACTADDRESSBYCODE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_code)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> isProviderExist(String _sp) {
        final Function function = new Function(FUNC_ISPROVIDEREXIST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _sp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> registerContract(String _spAddress, String _spContract) {
        final Function function = new Function(
                FUNC_REGISTERCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _spAddress), 
                new org.web3j.abi.datatypes.Address(160, _spContract)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ServiceProviderDatabase load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ServiceProviderDatabase(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ServiceProviderDatabase load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ServiceProviderDatabase(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ServiceProviderDatabase load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ServiceProviderDatabase(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ServiceProviderDatabase load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ServiceProviderDatabase(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ServiceProviderDatabase> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(ServiceProviderDatabase.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ServiceProviderDatabase> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(ServiceProviderDatabase.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ServiceProviderDatabase> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(ServiceProviderDatabase.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ServiceProviderDatabase> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(ServiceProviderDatabase.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
