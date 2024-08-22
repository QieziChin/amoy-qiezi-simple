package com.amoy.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public enum Digest {
    MD5("MD5"),
    SHA1("SHA1"),
    SHA256("SHA-256"),
    SHA512("SHA-512");
    private String name;

    private char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    Digest(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public String getHash(File input) {
        try (InputStream in = new FileInputStream(input)) {
            MessageDigest digest = MessageDigest.getInstance(getName());
            byte[] block = new byte[4096];
            int length;
            while ((length = in.read(block)) > 0) {
                digest.update(block, 0, length);
            }
            byte[] bytes = digest.digest();

            StringBuilder builder = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                builder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getHash(byte[] s){
        try {
            MessageDigest digest = MessageDigest.getInstance(getName());
            digest.update(s);
            byte[] md5 = digest.digest();
            int j = md5.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (byte byte0 : md5) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return  new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getHash(String s){
        return getHash(s.getBytes()).toLowerCase();
    }

    public String getHashSalt(String s, String salt){
        String t = getHash(s.getBytes()) + salt;
        return getHash(t.getBytes()).toLowerCase();
    }
}
