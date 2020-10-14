package com.moksh.lab3;

import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import java.security.MessageDigest;

public class t {

    static {
        System.loadLibrary("local");
    }

    private String y(byte[] t1, byte[] t2){
        // t1 is false, t2 will contain the flag value
        //Log.e("Keyy: ",new String(t2));
        try{
            MessageDigest co = null;
            co = MessageDigest.getInstance("SHA-256");
            t1 = co.digest(t2);
            return Base64.encodeToString(t1,0);

        }catch(Exception e){
            e.printStackTrace();
            return "123";
        }
    }

    public String z(){
        String result = new String();
        char[] charArray = k1().toCharArray();
        for(int i = 0; i < charArray.length; i=i+2) {
            String st = ""+charArray[i]+""+charArray[i+1];
            char ch = (char)Integer.parseInt(st, 16);
            result = result + ch;

        }
        String result2 = new String();
        char[] charArray2 = k2().toCharArray();
        for(int i = 0; i < charArray2.length; i=i+2) {
            String st = ""+charArray2[i]+""+charArray2[i+1];
            char ch2 = (char)Integer.parseInt(st, 16);
            result2 = result2 + ch2;

        }
        result = "cygym3{"+result+"}";
        result2= "cygym3{"+result2+"}";
        try{
            return y(result.getBytes("UTF-8"),result2.getBytes("UTF-8"));
        }catch(Exception e){
            e.printStackTrace();
            return "123";
        }
    }

    public native String k1(); //false flag
    public native String k2(); //real key
}
