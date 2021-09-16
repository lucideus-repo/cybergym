package com.moksh.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView flagValue;
    Button button;
    int i =0;
    String lbl_url_part1;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flagValue = findViewById(R.id.flagValue);
        button = findViewById(R.id.button);
        int d1 = b.checkAppSignature(this);
        msg = "The Flag is: ";
        if(d1 < 1){
            Toast.makeText(this,"Application Tampered",Toast.LENGTH_LONG).show();
            this.finishAffinity();
        }
        lbl_url_part1 = "cygym3{damn_morty";
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i +=1;
                if(i == 10){
                    Toast.makeText(MainActivity.this,"Oh, the flag looks incomplete. Fishy!",Toast.LENGTH_SHORT).show();
                    i = 0;
                }else if(i == 3){
                    flagValue.setText(msg+lbl_url_part1);
                }

            }
        });

        Flag f = new Flag();
        f.setFlag("mRte5rK801pHFRv");
        f.setFlag("LYdn7wH2lAMhvAN");
        f.setFlag("xT2Zuo3nCbiqvyV");
    }
}
