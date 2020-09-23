package com.moksh.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a x = new a();
        int d1 = b.checkAppSignature(this);
        String s1 = this.getResources().getString(R.string.key1);
        String s2 = this.getResources().getString(R.string.key2);
        if(d1 < 1){
            Toast.makeText(this,"Application Tampered",Toast.LENGTH_LONG).show();
            this.finishAffinity();
        }
        String s3 = x.d(s2,s1);
        //s3 is false flag
        Toast.makeText(MainActivity.this,"Decrypted: Nothing specified",Toast.LENGTH_LONG).show();
    }
}
