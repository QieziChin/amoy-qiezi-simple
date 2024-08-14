package com.amoy.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    protected static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    protected static MessageDigest messagedigest = null;

    static {
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String getMD5String(String s){
        return getMD5String(s.getBytes());
    }

    /**
     * 为了集成PHP fastAdmin 的加密算法
     * @param s
     * @param salt
     * @return
     */
    public static String getMD5SaltString(String s, String salt){
        String t = getMD5String(s.getBytes()) + salt;
        return getMD5String(t.getBytes()).toLowerCase();
    }

    public static String getMD5String(byte[] s){
        messagedigest.update(s);
        byte[] md5 = messagedigest.digest();
        int j = md5.length;
        char[] str = new char[j * 2];
        int k = 0;
        for (byte byte0 : md5) {
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return  new String(str);
    }
}
