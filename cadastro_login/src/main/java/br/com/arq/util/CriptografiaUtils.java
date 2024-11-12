package br.com.arq.util;

import java.security.MessageDigest;

public class CriptografiaUtils {

    public static String criptografar(String senha) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md5.digest(senha.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : messageDigest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}