package com.cse305.Models;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    // private static String myKey = "supersecretkey";

    static public String encrypt(String strToEncrypt) {
        // try {
        // MessageDigest sha = MessageDigest.getInstance("SHA-1");
        // byte[] key = myKey.getBytes("UTF-8");
        // key = sha.digest(key);
        // key = Arrays.copyOf(key, 16);
        // SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        // Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        // cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        // return
        // Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        // } catch (Exception e) {
        // System.out.println(e.toString());
        // }
        // return null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(strToEncrypt.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // static public String decrypt(String strToDecrypt) {
    // try {
    // MessageDigest sha = MessageDigest.getInstance("SHA-1");
    // byte[] key = myKey.getBytes("UTF-8");
    // key = sha.digest(key);
    // key = Arrays.copyOf(key, 16);
    // SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
    // Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
    // cipher.init(Cipher.DECRYPT_MODE, secretKey);
    // return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
    // } catch (Exception e) {
    // System.out.println(e.toString());
    // }
    // return null;
    // }
}
