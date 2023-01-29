package com.example.accesscontrol;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.MessageDigest;
import java.util.*;

public class StreamUtils {
    public static void writeString(String str, File file) throws IOException {
        writeBytes(str.getBytes("UTF-8"), file);
    }

    public static void writeBytes(byte b[], File file) throws IOException {
        OutputStream os = new FileOutputStream(file);
        os.write(b);
        os.flush();
        os.close();
    }
    public static String readString(File file) throws IOException {
        return new String(readBytes(file), "UTF-8");
    }

    public static String readString(InputStream is) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        copy(is, os, false, false);
        return new String(os.toByteArray(), "UTF-8");
    }

    public static void listFiles(File file, List<File> list) {
        if (file.isDirectory()) {
            list.add(file);
            for (File f : file.listFiles()) {
                listFiles(f, list);
            }
        } else {
            list.add(file);
        }
    }

    public static byte[] readBytes(String filename, long start, long end) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filename));
        fis.skip(start);
        byte[] result = new byte[(int) (end - start) + 1];
        DataInputStream is = new DataInputStream(fis);
        is.readFully(result);
        is.close();
        fis.close();
        return result;
    }

    public static byte[] readBytes(File file) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        copy(new FileInputStream(file), os, true, true);
        byte b[] = os.toByteArray();
        return b;
    }

    public static void copy(InputStream is, OutputStream os, boolean closeInput, boolean closeOutput) throws IOException {
        byte b[] = new byte[4000];
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

    public static String hash(String s) {
        try {
            if (s == null) {
                s = "";
            }
            return hash(s.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String hash(byte b[]) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(b);
            return toHex(hash, "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public static String encrypt(String text, String key) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE,
                new SecretKeySpec(digest.digest(key.getBytes("UTF-8")), "AES"),
                new IvParameterSpec(new byte[16]));
        byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String toBase64(byte b[]) {
        return Base64.getEncoder().encodeToString(b);
    }

    public static String decrypt(String text, String key) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE,
                new SecretKeySpec(digest.digest(key.getBytes("UTF-8")), "AES"),
                new IvParameterSpec(new byte[16]));
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(text));
        return new String(original, "UTF-8");
    }

    public static String toHex(byte b[], String delimeter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            String h = String.format("%h", b[i] & 0xff);
            h = (h.length() == 1) ? "0" + h : h;
            sb.append((i == 0) ? h : (delimeter + h));
        }
        return sb.toString();
    }

    public static byte[] fromHex(String hex, String delimeter) {
        int step = 2 + delimeter.length();
        byte b[] = new byte[(int) Math.ceil((double) hex.length() / step)];
        for (int i = 0; i < hex.length(); i += step) {
            String h = hex.substring(i, i + 2);
            b[i / step] = (byte) Integer.parseInt(h, 16);
        }
        return b;
    }

    public static void delete(File file) {
        if (file.isDirectory()) {
            for (File inner : file.listFiles()) {
                delete(inner);
            }
        }
        file.delete();
    }

}
