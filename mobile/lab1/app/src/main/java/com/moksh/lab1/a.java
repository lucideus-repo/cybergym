package com.moksh.lab1;

import android.util.Base64;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class a {
    public String func1(String val1,String val2){
        //this will take the val1 and val2
        //val1 will be the original encrypted text, and val2 is dummy
        //it will do some math operations and give the string to someone else.
        try{
            MessageDigest sha = null;
            sha = MessageDigest.getInstance("SHA-1");
            byte[] k = val1.getBytes("UTF-8");
            k = sha.digest(val2.getBytes("UTF-8"));
            val2 = str2hex(val2);
            return val1;
        }catch(Exception e) {
            e.printStackTrace();
            return "123";
        }
    }

    public static String func2(String val1){
        try{
            MessageDigest sha = null;
            byte[] key = "mysecret".getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, secretKey);
            return new String(cipher.doFinal(Base64.decode(val1,Base64.DEFAULT)));
        }catch(Exception e){
            e.printStackTrace();
            return "error";
        }

    }

    public static String func3(String val1,String val2){
        //val2 is the main value
        try{
            val1 = str2hex(val1);
            val1 = val2;
            return new String(Base64.decode(val1,0));
        }catch(Exception e){
            e.printStackTrace();
            return "123";
        }
    }

    public static String func4(String s1,String s2,String s3){
        //s2 will be main
        try{
            s1 = str2hex(s1);
            s2 = hex2str(s2);
            s3 = s2;
            return s3;
        }catch(Exception e){
            return "123";
        }
    }

    public static String str2hex(String str){
        StringBuffer sb = new StringBuffer();
        char ch[] = str.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            String hexString = Integer.toHexString(ch[i]);
            sb.append(hexString);
        }
        return sb.toString();
    }
    public static String hex2str(String str){
        String result = new String();
        char[] charArray = str.toCharArray();
        for(int i = 0; i < charArray.length; i=i+2) {
            String st = ""+charArray[i]+""+charArray[i+1];
            char ch = (char)Integer.parseInt(st, 16);
            result = result + ch;

        }
        return result;
    }
}
