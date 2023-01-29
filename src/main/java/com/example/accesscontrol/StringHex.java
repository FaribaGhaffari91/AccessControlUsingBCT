package com.example.accesscontrol;

import java.io.*;

public class StringHex {
    public static String getString(byte b[]) {
        String str = "";
        for (int i = 0; i < b.length; i++) {
            str += String.format("%h ", b[i] & 0xff);
        }
        return str;
    }

    public static byte[] readBytes(File file) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        copy(new FileInputStream(file), os, true, true);
        byte b[] = os.toByteArray();
        return b;
    }

    public static void copy(InputStream is, OutputStream os, boolean closeInput, boolean closeOutput) throws IOException {
        byte b[] = new byte[10000];
        while (true) {
            int r = is.read(b);
            if (r < 0) {
                break;
            }
            os.write(b, 0, r);
        }
        if (closeInput) {
            is.close();
        }
        if (closeOutput) {
            os.flush();
            os.close();
        }
    }

    public static void readHex() throws Exception {
        File file1 = new File("./ABIFiles/AccessManagerContract.bin");
        File file2 = new File("./ABIFiles/AddressBook.bin");
        byte[] bytes1 = readBytes(file1);
        byte[] bytes2 = readBytes(file2);

        for (int i = 0; i < bytes1.length; i++) {
            if (bytes1[i] != bytes2[i]) {
                System.out.println(i);
                return;
            }
        }

        String str = new String(bytes1, "UTF-8");
        str = str.trim();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        for (int i = 0; i < str.length(); i += 2) {
            String s = "" + str.charAt(i) + str.charAt(i + 1);
            os.write(Integer.parseInt(s, 16));
        }
        str = new String(os.toByteArray(), "UTF-8");
        System.out.println(str);
    }
}
