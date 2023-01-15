package CompiledContracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
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
public class RegistrationContract extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50604051612d88380380612d888339818101604052602081101561003357600080fd5b5051600080546001600160a01b0319166001600160a01b03808416919091178083556040805163d75bbaa760e01b815230600482015260248101829052600b60448201526a149959d0dbdb9d1c9858dd60aa1b60648201529051919092169263d75bbaa7926084808201939182900301818387803b1580156100b457600080fd5b505af11580156100c8573d6000803e3d6000fd5b505060006002819055600355505050612ca2806100e66000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c806318b17c951461005c5780634ebd5f911461008d5780637d5224d3146100cf578063a204c145146100f5578063f3d7a5111461011b575b600080fd5b61008b6004803603608081101561007257600080fd5b508035906020810135906040810135906060013561014a565b005b6100b3600480360360208110156100a357600080fd5b50356001600160a01b031661074d565b604080516001600160a01b039092168252519081900360200190f35b6100b3600480360360208110156100e557600080fd5b50356001600160a01b0316610a7f565b6100b36004803603602081101561010b57600080fd5b50356001600160a01b0316610ce6565b61008b6004803603608081101561013157600080fd5b5080359060208101359060408101359060600135610f8d565b600080546040805163bf40fac160e01b8152602060048201819052600360248301526228222160e91b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b1580156101a957600080fd5b505afa1580156101bd573d6000803e3d6000fd5b505050506040513d60208110156101d357600080fd5b5051600080546040805163bf40fac160e01b815260206004808301829052602483015263292aa22160e11b6044830152915194955092936001600160a01b039092169263bf40fac19260648083019392829003018186803b15801561023757600080fd5b505afa15801561024b573d6000803e3d6000fd5b505050506040513d602081101561026157600080fd5b5051600080546040805163bf40fac160e01b815260206004820181905260056024830152642929a8222160d91b6044830152915194955092936001600160a01b039092169263bf40fac19260648083019392829003018186803b1580156102c757600080fd5b505afa1580156102db573d6000803e3d6000fd5b505050506040513d60208110156102f157600080fd5b505160408051636ef3669360e11b81526004810189905290519192506000916001600160a01b0384169163dde6cd26916024808301926020929190829003018186803b15801561034057600080fd5b505afa158015610354573d6000803e3d6000fd5b505050506040513d602081101561036a57600080fd5b50516040805163dac3c76960e01b81526001600482015290519192506000916001600160a01b0387169163dac3c769916024808301926020929190829003018186803b1580156103b957600080fd5b505afa1580156103cd573d6000803e3d6000fd5b505050506040513d60208110156103e357600080fd5b505160408051630b1fba9160e11b815233600482015290519192506001600160a01b0383169163163f752291602480820192602092909190829003018186803b15801561042f57600080fd5b505afa158015610443573d6000803e3d6000fd5b505050506040513d602081101561045957600080fd5b50516104ac576040805162461bcd60e51b815260206004820152601a60248201527f5468652075736572206973206e6f742072656769737465726564000000000000604482015290519081900360640190fd5b6000856001600160a01b031663dac3c76960026040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b1580156104f357600080fd5b505afa158015610507573d6000803e3d6000fd5b505050506040513d602081101561051d57600080fd5b505160408051636209d7fb60e11b8152600481018d9052602481018c905290519192506001600160a01b0383169163c413aff691604480820192602092909190829003018186803b15801561057157600080fd5b505afa158015610585573d6000803e3d6000fd5b505050506040513d602081101561059b57600080fd5b50516105d85760405162461bcd60e51b815260040180806020018281038252602c815260200180612bf1602c913960400191505060405180910390fd5b60408051633115e48760e11b815233600482015290516000916001600160a01b0388169163622bc90e91602480820192602092909190829003018186803b15801561062257600080fd5b505afa158015610636573d6000803e3d6000fd5b505050506040513d602081101561064c57600080fd5b505160408051637c3f592160e01b8152600481018c905290519192506001600160a01b038084169263a330de2b928e928e928e92918b1691637c3f5921916024808301926020929190829003018186803b1580156106a957600080fd5b505afa1580156106bd573d6000803e3d6000fd5b505050506040513d60208110156106d357600080fd5b5051604080516001600160e01b031960e088901b168152600481019590955260248501939093526044840191909152606483015251608480830192600092919082900301818387803b15801561072857600080fd5b505af115801561073c573d6000803e3d6000fd5b505050505050505050505050505050565b600080546040805163bf40fac160e01b815260206004820181905260056024830152642929a8222160d91b6044830152915184936001600160a01b03169263bf40fac19260648082019391829003018186803b1580156107ac57600080fd5b505afa1580156107c0573d6000803e3d6000fd5b505050506040513d60208110156107d657600080fd5b505160408051630fbb590b60e21b81526001600160a01b038681166004830152915192935090831691633eed642c91602480820192602092909190829003018186803b15801561082557600080fd5b505afa158015610839573d6000803e3d6000fd5b505050506040513d602081101561084f57600080fd5b5051156108a3576040805162461bcd60e51b815260206004820181905260248201527f5468697320736572766963652070726f7669646572206578697374732e2e2e2e604482015290519081900360640190fd5b600280546001019055600080546040805163bf40fac160e01b8152602060048201819052600b60248301526a41646472657373426f6f6b60a81b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b15801561091357600080fd5b505afa158015610927573d6000803e3d6000fd5b505050506040513d602081101561093d57600080fd5b50516002546040513391906109519061176f565b6001600160a01b039384168152919092166020820152604080820192909252905190819003606001906000f08015801561098f573d6000803e3d6000fd5b509050816001600160a01b0316633f7d7df1600254866040518363ffffffff1660e01b815260040180838152602001826001600160a01b03166001600160a01b0316815260200192505050600060405180830381600087803b1580156109f457600080fd5b505af1158015610a08573d6000803e3d6000fd5b50506040805163d7e5fbf360e01b81526001600160a01b03888116600483015285811660248301529151918616935063d7e5fbf3925060448082019260009290919082900301818387803b158015610a5f57600080fd5b505af1158015610a73573d6000803e3d6000fd5b50929695505050505050565b600080546040805163bf40fac160e01b815260206004808301829052602483015263292aa22160e11b6044830152915184936001600160a01b03169263bf40fac19260648082019391829003018186803b158015610adc57600080fd5b505afa158015610af0573d6000803e3d6000fd5b505050506040513d6020811015610b0657600080fd5b505160408051631f5bdf5d60e01b81526001600160a01b038681166004830152915192935090831691631f5bdf5d91602480820192602092909190829003018186803b158015610b5557600080fd5b505afa158015610b69573d6000803e3d6000fd5b505050506040513d6020811015610b7f57600080fd5b505115610bbd5760405162461bcd60e51b8152600401808060200182810382526022815260200180612c1d6022913960400191505060405180910390fd5b600080546040805163bf40fac160e01b8152602060048201819052600b60248301526a41646472657373426f6f6b60a81b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b158015610c2457600080fd5b505afa158015610c38573d6000803e3d6000fd5b505050506040513d6020811015610c4e57600080fd5b50516040513390610c5e9061177c565b6001600160a01b03928316815291166020820152604080519182900301906000f080158015610c91573d6000803e3d6000fd5b506040805163196fe85960e01b81523360048201526001600160a01b03808416602483015291519293509084169163196fe8599160448082019260009290919082900301818387803b158015610a5f57600080fd5b600080546040805163bf40fac160e01b81526020600482018190526005602483015264292728222160d91b6044830152915184936001600160a01b03169263bf40fac19260648082019391829003018186803b158015610d4557600080fd5b505afa158015610d59573d6000803e3d6000fd5b505050506040513d6020811015610d6f57600080fd5b50516040805163f434744f60e01b81526001600160a01b03868116600483015291519293509083169163f434744f91602480820192602092909190829003018186803b158015610dbe57600080fd5b505afa158015610dd2573d6000803e3d6000fd5b505050506040513d6020811015610de857600080fd5b505115610e3c576040805162461bcd60e51b815260206004820181905260248201527f54686973206e6574776f726b2070726f7669646572206578697374732e2e2e2e604482015290519081900360640190fd5b600380546001019055600080546040805163bf40fac160e01b8152602060048201819052600b60248301526a41646472657373426f6f6b60a81b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b158015610eac57600080fd5b505afa158015610ec0573d6000803e3d6000fd5b505050506040513d6020811015610ed657600080fd5b5051600354604051339190610eea90611789565b6001600160a01b039384168152919092166020820152604080820192909252905190819003606001906000f080158015610f28573d6000803e3d6000fd5b509050816001600160a01b0316633f7d7df1600354866040518363ffffffff1660e01b815260040180838152602001826001600160a01b03166001600160a01b0316815260200192505050600060405180830381600087803b1580156109f457600080fd5b600080546040805163bf40fac160e01b8152602060048201819052600360248301526228222160e91b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b158015610fec57600080fd5b505afa158015611000573d6000803e3d6000fd5b505050506040513d602081101561101657600080fd5b5051600080546040805163bf40fac160e01b815260206004820181905260056024830152642929a8222160d91b6044830152915194955092936001600160a01b039092169263bf40fac19260648083019392829003018186803b15801561107c57600080fd5b505afa158015611090573d6000803e3d6000fd5b505050506040513d60208110156110a657600080fd5b5051600080546040805163bf40fac160e01b815260206004808301829052602483015263292aa22160e11b6044830152915194955092936001600160a01b039092169263bf40fac19260648083019392829003018186803b15801561110a57600080fd5b505afa15801561111e573d6000803e3d6000fd5b505050506040513d602081101561113457600080fd5b50516040805163dac3c76960e01b81526001600482015290519192506000916001600160a01b0386169163dac3c769916024808301926020929190829003018186803b15801561118357600080fd5b505afa158015611197573d6000803e3d6000fd5b505050506040513d60208110156111ad57600080fd5b505160408051630b1fba9160e11b815233600482015290519192506001600160a01b0383169163163f752291602480820192602092909190829003018186803b1580156111f957600080fd5b505afa15801561120d573d6000803e3d6000fd5b505050506040513d602081101561122357600080fd5b5051611276576040805162461bcd60e51b815260206004820152601a60248201527f5468652075736572206973206e6f742072656769737465726564000000000000604482015290519081900360640190fd5b6000846001600160a01b031663dac3c76960026040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b1580156112bd57600080fd5b505afa1580156112d1573d6000803e3d6000fd5b505050506040513d60208110156112e757600080fd5b505160408051636209d7fb60e11b8152600481018c9052602481018b905290519192506001600160a01b0383169163c413aff691604480820192602092909190829003018186803b15801561133b57600080fd5b505afa15801561134f573d6000803e3d6000fd5b505050506040513d602081101561136557600080fd5b50516113a25760405162461bcd60e51b815260040180806020018281038252602c815260200180612bf1602c913960400191505060405180910390fd5b6000846001600160a01b031663dde6cd268a6040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b1580156113e857600080fd5b505afa1580156113fc573d6000803e3d6000fd5b505050506040513d602081101561141257600080fd5b505160408051633115e48760e11b815233600482015290519192506000916001600160a01b0387169163622bc90e916024808301926020929190829003018186803b15801561146057600080fd5b505afa158015611474573d6000803e3d6000fd5b505050506040513d602081101561148a57600080fd5b50516040805163589050ad60e11b8152600481018c905290519192506000918a916001600160a01b0386169163b120a15a91602480820192602092909190829003018186803b1580156114dc57600080fd5b505afa1580156114f0573d6000803e3d6000fd5b505050506040513d602081101561150657600080fd5b5051604080516321df0da760e01b815290519290910292506001600160a01b038416916321df0da791600480820192602092909190829003018186803b15801561154f57600080fd5b505afa158015611563573d6000803e3d6000fd5b505050506040513d602081101561157957600080fd5b50518113156115b95760405162461bcd60e51b815260040180806020018281038252602f815260200180612c3f602f913960400191505060405180910390fd5b6000836001600160a01b0316637c3f59218c6040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b1580156115ff57600080fd5b505afa158015611613573d6000803e3d6000fd5b505050506040513d602081101561162957600080fd5b50516040805163a330de2b60e01b8152600481018f9052602481018e9052604481018d90526064810183905290519192506001600160a01b0385169163a330de2b9160848082019260009290919082900301818387803b15801561168c57600080fd5b505af11580156116a0573d6000803e3d6000fd5b50505050826001600160a01b031663979c86f1836040518263ffffffff1660e01b815260040180828152602001915050600060405180830381600087803b1580156116ea57600080fd5b505af11580156116fe573d6000803e3d6000fd5b50505050836001600160a01b03166325752b05836040518263ffffffff1660e01b815260040180828152602001915050600060405180830381600087803b15801561174857600080fd5b505af115801561175c573d6000803e3d6000fd5b5050505050505050505050505050505050565b61068e8061179783390190565b610aff80611e2583390190565b6102cd806129248339019056fe608060405234801561001057600080fd5b5060405161068e38038061068e8339818101604052606081101561003357600080fd5b5080516020820151604090920151600080546001600160a01b031990811633178255600180546001600160a01b0395861690831617905560028054949095169316929092179092556003919091556005556105fb806100936000396000f3fe608060405234801561001057600080fd5b50600436106100cf5760003560e01c80635bc4fc471161008c5780639f474b20116100665780639f474b2014610216578063a121a6c214610233578063b120a15a14610250578063e87ec79d1461026d576100cf565b80635bc4fc47146101875780637c3f5921146101be5780637d8411af146101db576100cf565b80632032c8b8146100d457806321df0da7146100f957806325752b051461011357806341c18af3146101305780634bfbf7731461014d578063574a9a341461016a575b600080fd5b6100f7600480360360408110156100ea57600080fd5b508035906020013561028a565b005b6101016102c6565b60408051918252519081900360200190f35b6100f76004803603602081101561012957600080fd5b50356102cc565b6100f76004803603602081101561014657600080fd5b503561037d565b6101016004803603602081101561016357600080fd5b5035610394565b6101016004803603602081101561018057600080fd5b50356103a9565b6101aa6004803603604081101561019d57600080fd5b50803590602001356103bf565b604080519115158252519081900360200190f35b610101600480360360208110156101d457600080fd5b50356103de565b6100f7600480360360c08110156101f157600080fd5b5080359060208101359060408101359060608101359060808101359060a001356103f3565b6100f76004803603602081101561022c57600080fd5b503561049a565b6101016004803603602081101561024957600080fd5b503561054a565b6101016004803603602081101561026657600080fd5b503561055f565b6101016004803603602081101561028357600080fd5b5035610574565b6002546001600160a01b031633146102a157600080fd5b600090815260076020908152604080832093835292905220805460ff19166001179055565b60065490565b6001546040805163bf40fac160e01b8152602060048201819052600b60248301526a149959d0dbdb9d1c9858dd60aa1b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b15801561033257600080fd5b505afa158015610346573d6000803e3d6000fd5b505050506040513d602081101561035c57600080fd5b50516001600160a01b0316331461037257600080fd5b600680549091019055565b6002546001600160a01b0316331461037257600080fd5b60009081526004602052604090206006015490565b6000908152600460208190526040909120015490565b6000908152600760209081526040808320938352929052205460ff1690565b60009081526004602052604090206001015490565b6002546001600160a01b0316331461040a57600080fd5b60058054600101905561041b610589565b506040805160e0810182526005805480835260208084019a8b52838501998a52606084019889526080840197885260a0840196875260c084019586526000918252600490819052939020915182559751600182015595516002870155935160038601559151928401929092559051928201929092559051600690910155565b6001546040805163bf40fac160e01b8152602060048201819052600960248301526820a1a6b0b730b3b2b960b91b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b1580156104fe57600080fd5b505afa158015610512573d6000803e3d6000fd5b505050506040513d602081101561052857600080fd5b50516001600160a01b0316331461053e57600080fd5b60068054919091039055565b60009081526004602052604090206003015490565b60009081526004602052604090206002015490565b60009081526004602052604090206005015490565b6040518060e0016040528060008152602001600081526020016000815260200160008152602001600081526020016000815260200160008152509056fea265627a7a723158202416a05d51b4927cb6d58b843b86070ef0b726be539addd90fb83fbfa282755364736f6c63430005100032608060405234801561001057600080fd5b50604051610aff380380610aff8339818101604052604081101561003357600080fd5b508051602091820151600180546001600160a01b0319166001600160a01b0380851691909117918290556040805163bf40fac160e01b815260048101879052600b60248201526a149959d0dbdb9d1c9858dd60aa1b6044820152905194959394929091169263bf40fac192606480840193829003018186803b1580156100b857600080fd5b505afa1580156100cc573d6000803e3d6000fd5b505050506040513d60208110156100e257600080fd5b50516001600160a01b0316331461012a5760405162461bcd60e51b8152600401808060200182810382526037815260200180610ac86037913960400191505060405180910390fd5b60008055600380546001600160a01b03909216610100026001600160a81b031990921691909117905550610965806101636000396000f3fe608060405234801561001057600080fd5b50600436106100935760003560e01c806341c18af31161006657806341c18af314610137578063507966e0146101545780636298ca4f14610171578063979c86f114610190578063a330de2b146101ad57610093565b806305364a1d146100985780630f248d38146100cf57806321df0da7146100fa57806322fa871814610114575b600080fd5b6100bb600480360360408110156100ae57600080fd5b50803590602001356101dc565b604080519115158252519081900360200190f35b6100f8600480360360608110156100e557600080fd5b50803590602081013590604001356101ff565b005b610102610365565b60408051918252519081900360200190f35b6101026004803603604081101561012a57600080fd5b508035906020013561036b565b6100f86004803603602081101561014d57600080fd5b5035610389565b6100f86004803603602081101561016a57600080fd5b50356103b0565b6100f86004803603602081101561018757600080fd5b5035151561049c565b6100f8600480360360208110156101a657600080fd5b503561059b565b6100f8600480360360808110156101c357600080fd5b5080359060208101359060408101359060600135610737565b600091825260026020908152604080842092845291905290206004015460ff1690565b6001546040805163bf40fac160e01b8152602060048201819052600b60248301526a149959d0dbdb9d1c9858dd60aa1b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b15801561026557600080fd5b505afa158015610279573d6000803e3d6000fd5b505050506040513d602081101561028f57600080fd5b50516001600160a01b031633146102ed576040805162461bcd60e51b815260206004820152601e60248201527f796f752063616e206e6f742063616c6c20746869732066756e6374696f6e0000604482015290519081900360640190fd5b6000838152600260208181526040808420868552909152909120015442106103395760008381526002602081815260408084208685529091529091204262015180840201910155610360565b60008381526002602081815260408084208685529091529091200180546201518083020190555b505050565b60005490565b60009182526002602081815260408085209385529290529120015490565b60035461010090046001600160a01b031633146103a557600080fd5b600080549091019055565b6001546040805163bf40fac160e01b8152602060048201819052600960248301526820a1a6b0b730b3b2b960b91b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b15801561041457600080fd5b505afa158015610428573d6000803e3d6000fd5b505050506040513d602081101561043e57600080fd5b50516001600160a01b031633146103a5576040805162461bcd60e51b815260206004820152601c60248201527f54686973202066756e6374696f6e206973207265737472696374656400000000604482015290519081900360640190fd5b6001546040805163bf40fac160e01b8152602060048201819052600960248301526820a1a6b0b730b3b2b960b91b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b15801561050057600080fd5b505afa158015610514573d6000803e3d6000fd5b505050506040513d602081101561052a57600080fd5b50516001600160a01b03163314610588576040805162461bcd60e51b815260206004820152601e60248201527f796f752063616e206e6f742063616c6c20746869732066756e6374696f6e0000604482015290519081900360640190fd5b6003805460ff1916911515919091179055565b6001546040805163bf40fac160e01b8152602060048201819052600960248301526820a1a6b0b730b3b2b960b91b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b1580156105ff57600080fd5b505afa158015610613573d6000803e3d6000fd5b505050506040513d602081101561062957600080fd5b50516001600160a01b03163314806106da57506001546040805163bf40fac160e01b8152602060048201819052600b60248301526a149959d0dbdb9d1c9858dd60aa1b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b1580156106a257600080fd5b505afa1580156106b6573d6000803e3d6000fd5b505050506040513d60208110156106cc57600080fd5b50516001600160a01b031633145b61072b576040805162461bcd60e51b815260206004820152601c60248201527f54686973202066756e6374696f6e206973207265737472696374656400000000604482015290519081900360640190fd5b60008054919091039055565b6001546040805163bf40fac160e01b8152602060048201819052600b60248301526a149959d0dbdb9d1c9858dd60aa1b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b15801561079d57600080fd5b505afa1580156107b1573d6000803e3d6000fd5b505050506040513d60208110156107c757600080fd5b50516001600160a01b03163314610825576040805162461bcd60e51b815260206004820152601e60248201527f796f752063616e206e6f742063616c6c20746869732066756e6374696f6e0000604482015290519081900360640190fd5b61082d6108ff565b816001141561086f576040518060a0016040528086815260200185815260200184620151800242018152602001600081526020016001151581525090506108a6565b81600214156108a6576040518060a00160405280868152602001858152602001600081526020018481526020016001151581525090505b600094855260026020818152604080882096885295815295859020825181559582015160018701559381015193850193909355505060608101516003830155608001516004909101805460ff1916911515919091179055565b6040518060a0016040528060008152602001600081526020016000815260200160008152602001600015158152509056fea265627a7a72315820cdc18ff77283808e53044a7d44e784d2611d741ad63c631d8ec93d09931739eb64736f6c634300051000325468697320636f6e7472616374206f6e6c792063616e206265206465706c6f79656420627920526567697374657220436f6e7472616374608060405234801561001057600080fd5b506040516102cd3803806102cd8339818101604052606081101561003357600080fd5b5080516020820151604090920151600080546001600160a01b039384166001600160a01b031991821617909155600380549390941692169190911790915560045561024a806100836000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806351b5ed4c14610046578063ba6a037a14610065578063f74a3d6e14610082575b600080fd5b6100636004803603602081101561005c57600080fd5b50356100b3565b005b6100636004803603602081101561007b57600080fd5b5035610194565b61009f6004803603602081101561009857600080fd5b50356101c6565b604080519115158252519081900360200190f35b6000546040805163bf40fac160e01b8152602060048201819052600960248301526820a1a6b0b730b3b2b960b91b604483015291516001600160a01b039093169263bf40fac192606480840193919291829003018186803b15801561011757600080fd5b505afa15801561012b573d6000803e3d6000fd5b505050506040513d602081101561014157600080fd5b50516001600160a01b031633146101895760405162461bcd60e51b815260040180806020018281038252603a8152602001806101dc603a913960400191505060405180910390fd5b600180549091019055565b6003546001600160a01b031633146101ab57600080fd5b6000908152600260205260409020805460ff19166001179055565b60009081526002602052604090205460ff169056fe4f6e6c7920616363657373206d616e6167657220636f6e74726163742063616e206164642062616c616e636520696e204e50206163636f756e74a265627a7a723158200db1e8c57e6c42d8a842578a770d6dc6f69980742977b332a48bf4e0b190288364736f6c63430005100032596f7572204e5020646f65736e7420737570706f7274207468697320736572766963652070726f766964657254686973207573657220697320616c726561647920726567697374657265642e2e2e5573657220646f65736e7420686176652073756666696369656e7420746f6b656e20696e206865722077616c6c6574a265627a7a723158202434e0498de46e774f12e91dad7a02024a9e4b1840c4a6ffb775c8c0ef34328164736f6c63430005100032";

    public static final String FUNC_REGISTERNEWNP = "registerNewNP";

    public static final String FUNC_REGISTERNEWUSER = "registerNewUser";

    public static final String FUNC_REGISTERSERVICEPROVIDER = "registerServiceProvider";

    public static final String FUNC_REGISTERTOSERVICEPAYASYOUGO = "registerToServicePayAsYouGo";

    public static final String FUNC_REGISTERTOSERVICEPREPAID = "registerToServicePrePaid";

    @Deprecated
    protected RegistrationContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RegistrationContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected RegistrationContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected RegistrationContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> registerNewNP(String _npAddress) {
        final Function function = new Function(
                FUNC_REGISTERNEWNP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _npAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> registerNewUser(String _user) {
        final Function function = new Function(
                FUNC_REGISTERNEWUSER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _user)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> registerServiceProvider(String _sp) {
        final Function function = new Function(
                FUNC_REGISTERSERVICEPROVIDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _sp)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> registerToServicePayAsYouGo(BigInteger _npCode, BigInteger _serviceProviderCode, BigInteger _serviceCode, BigInteger timeOrData) {
        final Function function = new Function(
                FUNC_REGISTERTOSERVICEPAYASYOUGO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_npCode), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceProviderCode), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceCode), 
                new org.web3j.abi.datatypes.generated.Uint256(timeOrData)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> registerToServicePrePaid(BigInteger _npCode, BigInteger _serviceProviderCode, BigInteger _serviceCode, BigInteger timeOrData) {
        final Function function = new Function(
                FUNC_REGISTERTOSERVICEPREPAID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_npCode), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceProviderCode), 
                new org.web3j.abi.datatypes.generated.Int256(_serviceCode), 
                new org.web3j.abi.datatypes.generated.Uint256(timeOrData)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static RegistrationContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RegistrationContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static RegistrationContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RegistrationContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RegistrationContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new RegistrationContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static RegistrationContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new RegistrationContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<RegistrationContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(RegistrationContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<RegistrationContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(RegistrationContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<RegistrationContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(RegistrationContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<RegistrationContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _addressBook) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addressBook)));
        return deployRemoteCall(RegistrationContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
