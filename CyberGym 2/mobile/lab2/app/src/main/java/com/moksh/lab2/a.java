package com.moksh.lab2;

import android.util.Base64;

import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class a {

    private byte[] a(byte[] a, byte[] b){
        try{
            a = Arrays.copyOf(a, 16);
            SecretKeySpec sk = new SecretKeySpec(a, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, sk);
            return cipher.doFinal(b);
        }catch(Exception e){
            e.printStackTrace();
            return new byte[]{(byte) 1, (byte) 2};
        }
    }
    private byte[] b(byte[] a, byte[] b){
        try{
            a = Arrays.copyOf(a, 16);
            SecretKeySpec sk = new SecretKeySpec(a, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, sk);
            return cipher.doFinal(b);
        }catch(Exception e){
            e.printStackTrace();
            return new byte[]{(byte) 1, (byte) 2};
        }
    }
    public String c(String a, String b){
        try{
            byte[] d = a(a.getBytes("UTF-8"),b.getBytes("UTF-8"));
            return Base64.encodeToString(d,0);
        }catch(Exception e){
            e.printStackTrace();
            return "123";
        }
    }
    public String d(String a,String b){
        try{
            byte[] e = Base64.decode(b,0);
            e = b(a.getBytes("UTF-8"),e);
            return new String(e);
        }catch(Exception e){
            e.printStackTrace();
            return "123";
        }
    }
}
