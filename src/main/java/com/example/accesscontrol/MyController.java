package com.example.accesscontrol;

import CompiledContracts.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api")
public class MyController {

    private static Web3j web3;

    @GetMapping("/Init")
    public String init(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long beginTime = System.currentTimeMillis();

        String ADMIN_PRIVATE_KEY = "ae7c5d419c37c52e61777a7fb0c7396092d4e713ca97ca66ad14968f2c54b60f"; // address is: 0xe2F9199Be4A76238E5A033DcDe9fdDbF234193E7

        web3 = Web3j.build(new HttpService());
        Credentials adminCredential = Credentials.create(ADMIN_PRIVATE_KEY);
        systemSetup(web3, adminCredential); // no need for web

        //------wallet generation--------------------------------------
        generateWallet(1, "./MNOs/", "mno");
        generateWallet(1, "./SPs/", "sp");
        generateWallet(1, "./UEs/", "ue");

        long endTime = System.currentTimeMillis();
        long duration = endTime - beginTime;
        return "Initialized in " + duration + " ms";
    }

    @GetMapping("/MNO")
    public String MNO(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long beginTime = System.currentTimeMillis();

        //------------ NP Registration in the system-------------------------------------------
        long duration = RegistrationInSystem(web3, addressesInWorkspace.get(2), "NP" , 1);

        long endTime = System.currentTimeMillis();
        long durationST = endTime - beginTime;
        return "Registered in " + duration + " ms and server time is: " + durationST;
    }

    @GetMapping("/SP")
    public String SP(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long beginTime = System.currentTimeMillis();

        //------------ SP Registration in the system-------------------------------------------
        long duration1 = RegistrationInSystem(web3, addressesInWorkspace.get(2), "SP" , 1);
        long duration2 = serviceInsertion(web3, addressesInWorkspace.get(2), 1);

        long endTime = System.currentTimeMillis();
        long durationST = endTime - beginTime;
        return "Registered in " + (duration1 + duration2) + " ms and server time is: " + durationST;
    }

    @GetMapping("/UE")
    public String UE(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long beginTime = System.currentTimeMillis();

        //------------ UE Registration in the system-------------------------------------------
        long duration = RegistrationInSystem(web3, addressesInWorkspace.get(2), "UE" , 1);

        long endTime = System.currentTimeMillis();
        long durationST = endTime - beginTime;
        return "Registered in " + duration + " ms and server time is: " + durationST;
    }

    @GetMapping("/User1Reg")
    public String User1Reg(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long beginTime = System.currentTimeMillis();

        long duration = userRegistrationInPrepaid(web3, addressesInWorkspace.get(2), 1); //user service 1

        long endTime = System.currentTimeMillis();
        long durationST = endTime - beginTime;
        return "Registered in " + duration + " ms and server time is" + durationST;
    }

    @GetMapping("/User1Access")
    public String User1Access(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long beginTime = System.currentTimeMillis();

        long duration = userAccessToPrepaid(web3, addressesInWorkspace.get(1), 1);

        long endTime = System.currentTimeMillis();
        long durationST = endTime - beginTime;
        return "Accessed in " + duration + " ms, server time is " + durationST;
    }

    @GetMapping("/User1Pay")
    public String User1Pay(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long beginTime = System.currentTimeMillis();

        long duration = PaymentToMNOPrepaid(web3, addressesInWorkspace.get(1), 1);

        long endTime = System.currentTimeMillis();
        long durationDApp = endTime - beginTime;
        return "Paid in " + duration + " ms, and the DApp latency is " + durationDApp + " ms";
    }

    @GetMapping("/User2Reg")
    public String User2Reg(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long beginTime = System.currentTimeMillis();

        long duration = userRegistrationInPAYG(web3, addressesInWorkspace.get(2), 1);//user service

        long endTime = System.currentTimeMillis();
        long durationST = endTime - beginTime;
        return "Registered in " + duration + " ms, and server time is: "+ durationST;
    }

    @GetMapping("/User2Access")
    public String User2Access(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long beginTime = System.currentTimeMillis();

        long duration = userAccessToPAYG(web3, addressesInWorkspace.get(1), 1);

        long endTime = System.currentTimeMillis();
        long durationST = endTime - beginTime;
        return "Accessed in " + duration + " ms, server time is: " + durationST;
    }

    @GetMapping("/User2Pay")
    public String User2Pay(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long beginTime = System.currentTimeMillis();

        long duration = PaymentToMNOPAYG(web3, addressesInWorkspace.get(1), 1);

        long endTime = System.currentTimeMillis();
        long durationST = endTime - beginTime;
        return "Paid in " + duration + " ms, and server time is: "+ durationST;
    }

    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(20000000L);
    //6721978999999999L
    //Max gas limit 9007199254740991
    private final static BigInteger GAS_PRICE = BigInteger.ZERO;

    //String ADMIN_PRIVATE_KEY = "ae7c5d419c37c52e61777a7fb0c7396092d4e713ca97ca66ad14968f2c54b60f";
    private static List<String> addressesInWorkspace = new ArrayList<>(); //0 is addressBook, 1 is acm, 2 is RegM, 3 is npdb, 4 is policy, 5 is spdb, 6 is udb

    private static long PaymentToMNOPAYG(Web3j web3, String _accessControlContract, int _ueNumber) throws Exception {

        //----To read th credentials from generated file
        String path = "./UEs/ue";
        String pathSP = "./SPs/sp";
        String pathNP = "./MNOs/mno";
        List<Credentials> credentials = new ArrayList<>();
        List<String> address = new ArrayList<>();
        List<String> addressSP = new ArrayList<>();
        List<String> addressNP = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(_ueNumber);
        for (int i = 0; i < _ueNumber; i++) {
            final int index = i;
            String finalPath = path;
            String finalPathSP = pathSP;
            String finalPathNP = pathNP;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Credentials credential = null;
                    try {
                        credential = WalletUtils.loadCredentials("secr3t", finalPath +(index+1));
                        System.out.println("Credential " + index + " loaded");
                        credentials.add(credential);
                        address.add(credential.getAddress());
                        credential = WalletUtils.loadCredentials("secr3t", finalPathSP +(index+1));
                        addressSP.add(credential.getAddress());
                        credential = WalletUtils.loadCredentials("secr3t", finalPathNP +(index+1));
                        addressNP.add(credential.getAddress());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (CipherException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Finished");
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        long beginTime = 0;
        long endTime = 0;
        for (int i = 0; i < credentials.size(); i++) {
            AccessManagerContract acm = AccessManagerContract.load(_accessControlContract, web3, credentials.get(i), GAS_PRICE, GAS_LIMIT);
            beginTime = System.currentTimeMillis();
            TransactionReceipt tr = acm.terminationAndPayment(address.get(i), BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(2),BigInteger.valueOf(2)).send();
            endTime = System.currentTimeMillis();
            System.out.println("Payment PAYG gas usage = " + tr.getCumulativeGasUsed());
            System.out.println("user's blocked token for Prepaid service resuet in access manager is: " + acm.getUserStoredToken(address.get(i)).send());
            System.out.println("user available token after access in PAYG is: " + acm.getUserToken(address.get(i)).send());
            System.out.println("SP available token after access in PAYG is: " + acm.getSPToken(BigInteger.valueOf(1)).send());
            System.out.println("NP available token after access in PAYG is: " + acm.getNPToken(BigInteger.valueOf(1)).send());
        }
        return (endTime - beginTime);
    }
    private static long PaymentToMNOPrepaid(Web3j web3, String _accessControlContract, int _ueNumber) throws Exception {

        //----To read th credentials from generated file
        String path = "./UEs/ue";
        String pathSP = "./SPs/sp";
        String pathNP = "./MNOs/mno";
        List<Credentials> credentials = new ArrayList<>();
        List<String> address = new ArrayList<>();
        List<String> addressSP = new ArrayList<>();
        List<String> addressNP = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(_ueNumber);
        for (int i = 0; i < _ueNumber; i++) {
            final int index = i;
            String finalPath = path;
            String finalPathSP = pathSP;
            String finalPathNP = pathNP;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Credentials credential = null;
                    try {
                        credential = WalletUtils.loadCredentials("secr3t", finalPath +(index+1));
                        System.out.println("Credential " + index + " loaded");
                        credentials.add(credential);
                        address.add(credential.getAddress());
                        credential = WalletUtils.loadCredentials("secr3t", finalPathSP +(index+1));
                        addressSP.add(credential.getAddress());
                        credential = WalletUtils.loadCredentials("secr3t", finalPathNP +(index+1));
                        addressNP.add(credential.getAddress());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (CipherException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Finished");
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        long beginTime = 0;
        long endTime = 0;
        for (int i = 0; i < credentials.size(); i++) {
            AccessManagerContract acm = AccessManagerContract.load(_accessControlContract, web3, credentials.get(i), GAS_PRICE, GAS_LIMIT);
            beginTime = System.currentTimeMillis();
            TransactionReceipt tr = acm.terminationAndPayment(address.get(i), BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(1),BigInteger.valueOf(2)).send();
            System.out.println("Payment prepaid gas usage = " + tr.getCumulativeGasUsed());
            endTime = System.currentTimeMillis();
            System.out.println("user's blocked token for Prepaid service resuet in access manager is: " + acm.getUserStoredToken(address.get(i)).send());
            System.out.println("user available token after access in Prepaid is: " + acm.getUserToken(address.get(i)).send());
            System.out.println("SP available token after access in Prepaid is: " + acm.getSPToken(BigInteger.valueOf(1)).send());
            System.out.println("NP available token after access in Prepaid is: " + acm.getNPToken(BigInteger.valueOf(1)).send());
        }
        return (endTime - beginTime);
    }
    private static long userAccessToPAYG(Web3j web3, String _accessControlContract, int _ueNumber) throws Exception {

        //----To read th credentials from generated file
        String path = "./UEs/ue";
        String pathSP = "./SPs/sp";
        String pathNP = "./MNOs/mno";
        List<Credentials> credentials = new ArrayList<>();
        List<String> address = new ArrayList<>();
        List<String> addressSP = new ArrayList<>();
        List<String> addressNP = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(_ueNumber);
        for (int i = 0; i < _ueNumber; i++) {
            final int index = i;
            String finalPath = path;
            String finalPathSP = pathSP;
            String finalPathNP = pathNP;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Credentials credential = null;
                    try {
                        credential = WalletUtils.loadCredentials("secr3t", finalPath +(index+1));
                        System.out.println("Credential " + index + " loaded");
                        credentials.add(credential);
                        address.add(credential.getAddress());
                        credential = WalletUtils.loadCredentials("secr3t", finalPathSP +(index+1));
                        addressSP.add(credential.getAddress());
                        credential = WalletUtils.loadCredentials("secr3t", finalPathNP +(index+1));
                        addressNP.add(credential.getAddress());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (CipherException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Finished");
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        long beginTime = 0;
        long endTime = 0;
        for (int i = 0; i < credentials.size(); i++) {
            AccessManagerContract acm = AccessManagerContract.load(_accessControlContract, web3, credentials.get(i), GAS_PRICE, GAS_LIMIT);
            beginTime = System.currentTimeMillis();
            TransactionReceipt tr = acm.userValidation(address.get(i), BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(2)).send();
            endTime = System.currentTimeMillis();
            System.out.println("UE access to SP PAYG gas usage = " + tr.getCumulativeGasUsed());
            System.out.println("user access request is: " + tr.isStatusOK());
            System.out.println("user's blocked token for PAYG service resuet in access manager is: " + acm.getUserStoredToken(address.get(i)).send());
            System.out.println("user available token after registration in PAYG is: " + acm.getUserToken(address.get(i)).send());
            System.out.println("SP available token after registration in PAYG is: " + acm.getSPToken(BigInteger.valueOf(1)).send());
            System.out.println("NP available token after registration in PAYG is: " + acm.getNPToken(BigInteger.valueOf(1)).send());
        }
        return (endTime-beginTime);
    }

    private static long userAccessToPrepaid(Web3j web3, String _accessControlContract, int _ueNumber) throws Exception {
        //----To read th credentials from generated file
        String path = "./UEs/ue";
        String pathSP = "./SPs/sp";
        String pathNP = "./MNOs/mno";
        List<Credentials> credentials = new ArrayList<>();
        List<String> address = new ArrayList<>();
        List<String> addressSP = new ArrayList<>();
        List<String> addressNP = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(_ueNumber);
        for (int i = 0; i < _ueNumber; i++) {
            final int index = i;
            String finalPath = path;
            String finalPathSP = pathSP;
            String finalPathNP = pathNP;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Credentials credential = null;
                    try {
                        credential = WalletUtils.loadCredentials("secr3t", finalPath +(index+1));
                        System.out.println("Credential " + index + " loaded");
                        credentials.add(credential);
                        address.add(credential.getAddress());
                        credential = WalletUtils.loadCredentials("secr3t", finalPathSP +(index+1));
                        addressSP.add(credential.getAddress());
                        credential = WalletUtils.loadCredentials("secr3t", finalPathNP +(index+1));
                        addressNP.add(credential.getAddress());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (CipherException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Finished");
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        long beginTime = 0;
        long endTime = 0;

        for (int i = 0; i < credentials.size(); i++) {
            AccessManagerContract acm = AccessManagerContract.load(_accessControlContract, web3, credentials.get(i), GAS_PRICE, GAS_LIMIT);
            beginTime = System.currentTimeMillis();
            TransactionReceipt tr = acm.userValidation(address.get(i), BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(1)).send();
            endTime = System.currentTimeMillis();
            System.out.println("UE access to SP prepaid gas usage = " + tr.getCumulativeGasUsed());
            System.out.println("user access request is: " + tr.isStatusOK());
            System.out.println("user's blocked token in access manager is: " + acm.getUserStoredToken(address.get(i)).send());
            System.out.println("user available token after registration in PAYG is: " + acm.getUserToken(address.get(i)).send());
            System.out.println("SP available token after registration in PAYG is: " + acm.getSPToken(BigInteger.valueOf(1)).send());
            System.out.println("NP available token after registration in PAYG is: " + acm.getNPToken(BigInteger.valueOf(1)).send());
        }
        return endTime-beginTime;
    }

    private static long userRegistrationInPAYG(Web3j web3, String _regidtrationContract, int _ueNumber) throws Exception {

        //----To read th credentials from generated file
        String path = "./UEs/ue";
        String pathSP = "./SPs/sp";
        List<Credentials> credentials = new ArrayList<>();
        List<String> address = new ArrayList<>();
        List<String> addressSP = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(_ueNumber);
        for (int i = 0; i < _ueNumber; i++) {
            final int index = i;
            String finalPath = path;
            String finalPathSP = pathSP;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Credentials credential = null;
                    try {
                        credential = WalletUtils.loadCredentials("secr3t", finalPath +(index+1));
                        System.out.println("Credential " + index + " loaded");
                        credentials.add(credential);
                        address.add(credential.getAddress());
                        credential = WalletUtils.loadCredentials("secr3t", finalPathSP +(index+1));
                        addressSP.add(credential.getAddress());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (CipherException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Finished");
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        long beginTime = 0;
        long endTime = 0;

        for (int i = 0; i < credentials.size(); i++) {
            RegistrationContract regC = RegistrationContract.load(_regidtrationContract, web3, credentials.get(i), GAS_PRICE, GAS_LIMIT);
            System.out.println("user available token before registration in PAYG is: " + regC.getUserToken(address.get(i)).send());
            System.out.println("SP available token before registration in PAYG is: " + regC.getSPToken(BigInteger.valueOf(1)).send());
            System.out.println("NP available token before registration in PAYG is: " + regC.getNPToken(BigInteger.valueOf(1)).send());
            beginTime = System.currentTimeMillis();
            TransactionReceipt tr = regC.registerToServicePayAsYouGo(address.get(i), BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(70)).send();
            endTime = System.currentTimeMillis();
            System.out.println("UE registration in SP PAYG gas usage = " + tr.getCumulativeGasUsed());
            System.out.println("user available token after registration in PAYG is: " + regC.getUserToken(address.get(i)).send());
            System.out.println("SP available token after registration in PAYG is: " + regC.getSPToken(BigInteger.valueOf(1)).send());
            System.out.println("NP available token after registration in PAYG is: " + regC.getNPToken(BigInteger.valueOf(1)).send());
        }
        return (endTime-beginTime);
    }

    private static long userRegistrationInPrepaid(Web3j web3, String _regidtrationContract, int _ueNumber) throws Exception {

        //----To read th credentials from generated file
        String path = "./UEs/ue";
        String pathSP = "./SPs/sp";
        List<Credentials> credentials = new ArrayList<>();
        List<String> address = new ArrayList<>();
        List<String> addressSP = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < _ueNumber; i++) {
            final int index = i;
            String finalPath = path;
            String finalPathSP = pathSP;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Credentials credential = null;
                    try {
                        credential = WalletUtils.loadCredentials("secr3t", finalPath +(index+1));
                        System.out.println("Credential " + index + " loaded");
                        credentials.add(credential);
                        address.add(credential.getAddress());
                        credential = WalletUtils.loadCredentials("secr3t", finalPathSP +(index+1));
                        addressSP.add(credential.getAddress());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (CipherException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Finished");
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        long beginTime = 0;
        long endTime = 0;

        for (int i = 0; i < credentials.size(); i++) {
            RegistrationContract regC = RegistrationContract.load(_regidtrationContract, web3, credentials.get(i), GAS_PRICE, GAS_LIMIT);
            System.out.println("user available token before registration is: " + regC.getUserToken(address.get(i)).send());
            System.out.println("SP available token before registration is: " + regC.getSPToken(BigInteger.valueOf(1)).send());
            System.out.println("NP available token before registration is: " + regC.getNPToken(BigInteger.valueOf(1)).send());
            beginTime = System.currentTimeMillis();
            TransactionReceipt tr = regC.registerToServicePrePaid(address.get(i), addressSP.get(i), BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(70)).send();
            endTime = System.currentTimeMillis();
            System.out.println("UE registration in SP prepaid gas usage = " + tr.getCumulativeGasUsed());
            System.out.println("user available token is: " + regC.getUserToken(address.get(i)).send());
            System.out.println("SP available token is: " + regC.getSPToken(BigInteger.valueOf(1)).send());
            System.out.println("NP available token after registration is: " + regC.getNPToken(BigInteger.valueOf(1)).send());
        }
        return (endTime-beginTime);
    }

    private static long RegistrationInSystem(Web3j web3, String _regidtrationContract, String entity, int _spNumber) throws Exception {

        //----To read th credentials from generated file
        String path = "";
        if(entity.equals("SP")) {
            path = "./SPs/sp";
        } else if (entity.equals("NP")) {
            path = "./MNOs/mno";
        } else{
            path = "./UEs/ue";
        }
        List<Credentials> credentials = new ArrayList<>();
        List<String> address = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(_spNumber);
        for (int i = 0; i < _spNumber; i++) {
            final int index = i;
            String finalPath = path;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Credentials credential = null;
                    try {
                        credential = WalletUtils.loadCredentials("secr3t", finalPath +(index+1));
                        System.out.println("Credential " + index + " loaded");
                        credentials.add(credential);
                        address.add(credential.getAddress());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (CipherException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Finished");
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        long beginTime = 0;
        long endTime = 0;

        for (int i = 0; i < credentials.size(); i++) {

            RegistrationContract regC = RegistrationContract.load(_regidtrationContract, web3, credentials.get(i), GAS_PRICE, GAS_LIMIT);
            beginTime = System.currentTimeMillis();
            if(entity.equals("SP")) {
                TransactionReceipt tr = regC.registerServiceProvider(credentials.get(i).getAddress()).send();
                System.out.println("SP registration gas usage = " + tr.getCumulativeGasUsed());
            } else if (entity.equals("NP")){
                TransactionReceipt tr = regC.registerNewNP(credentials.get(i).getAddress()).send();
                System.out.println("MNO registration gas usage = " + tr.getCumulativeGasUsed());
            } else{
                TransactionReceipt tr = regC.registerNewUser(credentials.get(i).getAddress()).send();
                System.out.println("UE registration gas usage = " + tr.getCumulativeGasUsed());
            }
            endTime = System.currentTimeMillis();
            System.out.println("New " + entity + "'s address is: " + credentials.get(i).getAddress());
        }
        return (endTime - beginTime);
    }

    public static long serviceInsertion(Web3j web3, String _regidtrationContract, int _spNumber) throws Exception {

        //----To read th credentials from generated file
        String path = "./SPs/sp";
        List<Credentials> credentials = new ArrayList<>();
        List<String> address = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(_spNumber);
        for (int i = 0; i < _spNumber; i++) {
            final int index = i;
            String finalPath = path;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Credentials credential = null;
                    try {
                        credential = WalletUtils.loadCredentials("secr3t", finalPath +(index+1));
                        System.out.println("Credential " + index + " loaded");
                        credentials.add(credential);
                        address.add(credential.getAddress());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (CipherException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Finished");
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        long beginTime = 0;
        long endTime = 0;

        for (int i = 0; i < credentials.size(); i++) {
            RegistrationContract regC = RegistrationContract.load(_regidtrationContract, web3, credentials.get(i), GAS_PRICE, GAS_LIMIT);
            beginTime = System.currentTimeMillis();
            TransactionReceipt tr = regC.addNewServiceInSP(address.get(i),BigInteger.valueOf(1), BigInteger.valueOf(5), BigInteger.valueOf(1), BigInteger.valueOf(0), BigInteger.valueOf(0), BigInteger.valueOf(0)).send(); // prepaid service
            System.out.println("Add new service in SP gas usage = " + tr.getCumulativeGasUsed());
            tr = regC.addPolicyInService(BigInteger.valueOf(1), BigInteger.valueOf(1), address.get(i)).send();
            System.out.println("Add new policy in SP gas usage = " + tr.getCumulativeGasUsed());
            regC.addPolicyInService(BigInteger.valueOf(1), BigInteger.valueOf(5), address.get(i)).send();
            regC.addNewServiceInSP(address.get(i), BigInteger.valueOf(2), BigInteger.valueOf(0), BigInteger.valueOf(0), BigInteger.valueOf(1), BigInteger.valueOf(3), BigInteger.valueOf(3)).send(); // Pay as you go service
            //regC.addPolicyInService(BigInteger.valueOf(1), BigInteger.valueOf(2), address.get(i)).send();
            regC.addPolicyInService(BigInteger.valueOf(1), BigInteger.valueOf(3), address.get(i)).send();
            regC.addPolicyInService(BigInteger.valueOf(1), BigInteger.valueOf(4), address.get(i)).send();
            endTime = System.currentTimeMillis();
            System.out.println("New service is added to SP: " + credentials.get(i).getAddress());
        }
        return (endTime-beginTime);
    }

    public static void systemSetup(Web3j web3, Credentials adminCredential) throws Exception {

        FileOutputStream outputStream = new FileOutputStream("./WorkSpace.txt", true);
        AddressBook addressBook = AddressBook.deploy(web3, adminCredential, GAS_PRICE, GAS_LIMIT).send();
        addressesInWorkspace.add(addressBook.getContractAddress());
        String st = "AddressBook " + addressBook.getContractAddress() + "\n";
        outputStream.write(st.getBytes());
        System.out.println("AddressBook contract address is: " + addressBook.getContractAddress());
        System.out.println("The owner (admin) address is: " + addressBook.getAddress("Owner").send());

        AccessManagerContract acm = AccessManagerContract.deploy(web3, adminCredential, GAS_PRICE, GAS_LIMIT, addressBook.getContractAddress()).send();
        addressesInWorkspace.add(acm.getContractAddress());

        st = "ACM " + acm.getContractAddress() + "\n";
        outputStream.write(st.getBytes());
        System.out.println("AccessManagerContract address is: " + acm.getContractAddress());

        RegistrationContract regC = RegistrationContract.deploy(web3, adminCredential, GAS_PRICE, GAS_LIMIT, addressBook.getContractAddress()).send();
        addressesInWorkspace.add(regC.getContractAddress());
        st = "RegC " + regC.getContractAddress() + "\n";
        outputStream.write(st.getBytes());
        System.out.println("Registration contract address is: " + regC.getContractAddress());

        NetworkProviderDatabase npdb = NetworkProviderDatabase.deploy(web3, adminCredential, GAS_PRICE, GAS_LIMIT, addressBook.getContractAddress()).send();
        addressesInWorkspace.add(npdb.getContractAddress());
        st = "mnoDB " + npdb.getContractAddress() + "\n";
        outputStream.write(st.getBytes());
        System.out.println("MNO database address is: " + npdb.getContractAddress());

        PolicyDataBaseContract pdb = PolicyDataBaseContract.deploy(web3, adminCredential, GAS_PRICE, GAS_LIMIT, addressBook.getContractAddress()).send();
        addressesInWorkspace.add(pdb.getContractAddress());
        st = "Policy " + pdb.getContractAddress() + "\n";
        outputStream.write(st.getBytes());
        System.out.println("Policy database contract address is: " + pdb.getContractAddress());

        ServiceProviderDatabase spdb = ServiceProviderDatabase.deploy(web3, adminCredential, GAS_PRICE, GAS_LIMIT, addressBook.getContractAddress()).send();
        addressesInWorkspace.add(spdb.getContractAddress());
        st = "SPDB " + spdb.getContractAddress() + "\n";
        outputStream.write(st.getBytes());
        System.out.println("Service Provider contract address is: " + spdb.getContractAddress());

        UserDataBase udb = UserDataBase.deploy(web3, adminCredential, GAS_PRICE, GAS_LIMIT, addressBook.getContractAddress()).send();
        addressesInWorkspace.add(udb.getContractAddress());
        st = "UDB " + udb.getContractAddress() + "\n";
        outputStream.write(st.getBytes());
        System.out.println("User database contract address is: " + udb.getContractAddress());

        //------Add policies in PDB--------------------------------
        // "SubAttrRegNP" = 1 is the subject attribute check that calls the registeredUserPolicy contract,
        //"EnvAttrNPAgreement"  = 2 is the environment attribute check that the user's network provider supports this service,
        //"EnvAttrTime" = 3 is the environment attribute check that calls the timeControlPolicy contract,
        //"EnvAttrToken" = 4 is the environment attribute check that calls the walletControlPolicy contract,
        // "SubAttrRegSP" = 5 is the subject attribute check that if the user is registered in the service provider.
        PolicyDataBaseContract policies = PolicyDataBaseContract.load(pdb.getContractAddress(), web3, adminCredential, GAS_PRICE, GAS_LIMIT);

        RegisteredUserPolicy rgp = RegisteredUserPolicy.deploy(web3, adminCredential, GAS_PRICE, GAS_LIMIT, addressBook.getContractAddress()).send();
        policies.addPolicy(rgp.getContractAddress(), BigInteger.valueOf(1));

        NetworkProviderSupportPolicy npsp = NetworkProviderSupportPolicy.deploy(web3, adminCredential, GAS_PRICE, GAS_LIMIT, addressBook.getContractAddress()).send();
        policies.addPolicy(npsp.getContractAddress(), BigInteger.valueOf(2));

        TimeControlPolicy tcp = TimeControlPolicy.deploy(web3, adminCredential, GAS_PRICE, GAS_LIMIT, addressBook.getContractAddress()).send();
        policies.addPolicy(tcp.getContractAddress(), BigInteger.valueOf(3));

        WalletControlPolicy wcp = WalletControlPolicy.deploy(web3, adminCredential, GAS_PRICE, GAS_LIMIT, addressBook.getContractAddress()).send();
        policies.addPolicy(wcp.getContractAddress(), BigInteger.valueOf(4));

        RegisteredInSPPolicy risp = RegisteredInSPPolicy.deploy(web3, adminCredential, GAS_PRICE, GAS_LIMIT, addressBook.getContractAddress()).send();
        policies.addPolicy(risp.getContractAddress(), BigInteger.valueOf(5));



        outputStream.write(st.getBytes());
        outputStream.flush();

    }

    public static void generateWallet(int number, String _path, String _prefix){ //_prefix can be MNO, SP, UE
        try {
            String password = "secr3t";
            for (int i = 0; i < number; i++) {
                String fileName = WalletUtils.generateNewWalletFile(password,new File(_path)); //e.g., _path = "./src/test/ServiceProviders/"
                new File(_path +fileName).renameTo(new File(_path + _prefix +(i+1)));
                System.out.println("Generated i = " + (i+1));
            }
        } catch(Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static String execute(String cmd, String dir) throws Exception {
        File tempFile = null;
        try {
            cmd = "cd " + dir + "\n" + cmd;
            boolean windows = System.getProperty("os.name").toLowerCase().contains("windows");
            tempFile = File.createTempFile("command-" + System.currentTimeMillis() , (windows ? ".bat" : ".sh"));
            StreamUtils.writeString(cmd, tempFile);
            Process proc = Runtime.getRuntime().exec(windows ? tempFile.getPath() : ("sh " + tempFile.getPath()), null, new File(tempFile.getParent()));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            StreamUtils.copy(proc.getInputStream(), outputStream, false, false);
            StreamUtils.copy(proc.getErrorStream(), outputStream, false, false);
            int r = proc.waitFor();
            String out = new String(outputStream.toByteArray(), "UTF-8");
            if(r != 0) {
                throw new Exception("Command failed! cmd: " + cmd + "\n" + out);
            }
            return out;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Execution failed! cmd: " + cmd;
        } finally {
            if (tempFile != null && tempFile.exists()) {
                tempFile.delete();
            }
        }
    }

    public static void compile() throws Exception{
        String dir1 = "/home/fariba/IdeaProjects/AccessControl";
        String dir2 = "/web3j/web3j-4.5.0/bin";
        System.out.println(execute("solc --optimize --overwrite -o ABIFiles  --bin Contracts/RegistrationContract.sol --abi Contracts/RegistrationContract.sol", dir1));
        System.out.println(execute("solc --optimize --overwrite -o ABIFiles  --bin Contracts/AccessManagerContract.sol --abi Contracts/AccessManagerContract.sol", dir1));

        System.out.println(execute("./web3j solidity generate -a=/home/fariba/IdeaProjects/AccessControl/ABIFiles/AccessManagerContract.abi -b=/home/fariba/IdeaProjects/AccessControl/ABIFiles/AccessManagerContract.bin -o=/home/fariba/IdeaProjects/AccessControl/src/main/java -p=CompiledContracts", dir2));
        System.out.println(execute("./web3j solidity generate -a=/home/fariba/IdeaProjects/AccessControl/ABIFiles/AddressBook.abi -b=/home/fariba/IdeaProjects/AccessControl/ABIFiles/AddressBook.bin -o=/home/fariba/IdeaProjects/AccessControl/src/main/java -p=CompiledContracts", dir2));
        System.out.println(execute("./web3j solidity generate -a=/home/fariba/IdeaProjects/AccessControl/ABIFiles/NetworkProviderContract.abi -b=/home/fariba/IdeaProjects/AccessControl/ABIFiles/NetworkProviderContract.bin -o=/home/fariba/IdeaProjects/AccessControl/src/main/java -p=CompiledContracts", dir2));
        System.out.println(execute("./web3j solidity generate -a=/home/fariba/IdeaProjects/AccessControl/ABIFiles/networkProviderDatabase.abi -b=/home/fariba/IdeaProjects/AccessControl/ABIFiles/networkProviderDatabase.bin -o=/home/fariba/IdeaProjects/AccessControl/src/main/java -p=CompiledContracts", dir2));
        System.out.println(execute("./web3j solidity generate -a=/home/fariba/IdeaProjects/AccessControl/ABIFiles/NetworkProviderSupportPolicy.abi -b=/home/fariba/IdeaProjects/AccessControl/ABIFiles/NetworkProviderSupportPolicy.bin -o=/home/fariba/IdeaProjects/AccessControl/src/main/java -p=CompiledContracts", dir2));
        System.out.println(execute("./web3j solidity generate -a=/home/fariba/IdeaProjects/AccessControl/ABIFiles/Owned.abi -b=/home/fariba/IdeaProjects/AccessControl/ABIFiles/Owned.bin -o=/home/fariba/IdeaProjects/AccessControl/src/main/java -p=CompiledContracts", dir2));
        System.out.println(execute("./web3j solidity generate -a=/home/fariba/IdeaProjects/AccessControl/ABIFiles/policyDataBaseContract.abi -b=/home/fariba/IdeaProjects/AccessControl/ABIFiles/policyDataBaseContract.bin -o=/home/fariba/IdeaProjects/AccessControl/src/main/java -p=CompiledContracts", dir2));
        System.out.println(execute("./web3j solidity generate -a=/home/fariba/IdeaProjects/AccessControl/ABIFiles/registeredInSPPolicy.abi -b=/home/fariba/IdeaProjects/AccessControl/ABIFiles/registeredInSPPolicy.bin -o=/home/fariba/IdeaProjects/AccessControl/src/main/java -p=CompiledContracts", dir2));
        System.out.println(execute("./web3j solidity generate -a=/home/fariba/IdeaProjects/AccessControl/ABIFiles/registeredUserPolicy.abi -b=/home/fariba/IdeaProjects/AccessControl/ABIFiles/registeredUserPolicy.bin -o=/home/fariba/IdeaProjects/AccessControl/src/main/java -p=CompiledContracts", dir2));
        System.out.println(execute("./web3j solidity generate -a=/home/fariba/IdeaProjects/AccessControl/ABIFiles/RegistrationContract.abi -b=/home/fariba/IdeaProjects/AccessControl/ABIFiles/RegistrationContract.bin -o=/home/fariba/IdeaProjects/AccessControl/src/main/java -p=CompiledContracts", dir2));
        System.out.println(execute("./web3j solidity generate -a=/home/fariba/IdeaProjects/AccessControl/ABIFiles/ServiceProviderContract.abi -b=/home/fariba/IdeaProjects/AccessControl/ABIFiles/ServiceProviderContract.bin -o=/home/fariba/IdeaProjects/AccessControl/src/main/java -p=CompiledContracts", dir2));
        System.out.println(execute("./web3j solidity generate -a=/home/fariba/IdeaProjects/AccessControl/ABIFiles/serviceProviderDatabase.abi -b=/home/fariba/IdeaProjects/AccessControl/ABIFiles/serviceProviderDatabase.bin -o=/home/fariba/IdeaProjects/AccessControl/src/main/java -p=CompiledContracts", dir2));
        System.out.println(execute("./web3j solidity generate -a=/home/fariba/IdeaProjects/AccessControl/ABIFiles/timeControlPolicy.abi -b=/home/fariba/IdeaProjects/AccessControl/ABIFiles/timeControlPolicy.bin -o=/home/fariba/IdeaProjects/AccessControl/src/main/java -p=CompiledContracts", dir2));
        System.out.println(execute("./web3j solidity generate -a=/home/fariba/IdeaProjects/AccessControl/ABIFiles/UserContract.abi -b=/home/fariba/IdeaProjects/AccessControl/ABIFiles/UserContract.bin -o=/home/fariba/IdeaProjects/AccessControl/src/main/java -p=CompiledContracts", dir2));
        System.out.println(execute("./web3j solidity generate -a=/home/fariba/IdeaProjects/AccessControl/ABIFiles/UserDataBase.abi -b=/home/fariba/IdeaProjects/AccessControl/ABIFiles/UserDataBase.bin -o=/home/fariba/IdeaProjects/AccessControl/src/main/java -p=CompiledContracts", dir2));
        System.out.println(execute("./web3j solidity generate -a=/home/fariba/IdeaProjects/AccessControl/ABIFiles/walletControlPolicy.abi -b=/home/fariba/IdeaProjects/AccessControl/ABIFiles/walletControlPolicy.bin -o=/home/fariba/IdeaProjects/AccessControl/src/main/java -p=CompiledContracts", dir2));
    }

}

