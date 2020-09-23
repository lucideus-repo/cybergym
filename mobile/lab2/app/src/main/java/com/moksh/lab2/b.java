package com.moksh.lab2;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;

public class b {
    public static final String p0 = "<Add Signature Here>";
    public static int checkAppSignature(Context context){
        try{
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : packageInfo.signatures){
                byte[] signatureBytes = signature.toByteArray();
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                final String currentSignature = Base64.encodeToString(md.digest(), Base64.DEFAULT);
                //Log.e("Sherlock","Sig: "+currentSignature);
                /*if(p0.trim().equalsIgnoreCase(currentSignature.trim())){
                    return 1;
                }else{
                    return 0;
                }*/
                //return true for now
                return 1;
            }
        }catch(Exception e){
            return 0;
        }
        return 0;
    }
}
