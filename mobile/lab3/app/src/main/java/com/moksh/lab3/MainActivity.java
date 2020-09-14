package com.moksh.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView txt1;
    Button bt1;
    JSONObject jso = new JSONObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = findViewById(R.id.button);
        txt1 = findViewById(R.id.txtValue);
        int d1 = b.checkAppSignature(this);
        if(d1 < 1){
            Toast.makeText(this,"Application Tampered",Toast.LENGTH_LONG).show();
            this.finishAffinity();
        }
        try{
            jso.put("algo","SHA256");
            jso.put("challenge","lab3");
        }catch(Exception e){
            e.printStackTrace();
        }
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,jso.toString(),Toast.LENGTH_SHORT).show();
                try{
                    jso.put("flag",new t().z().replaceAll("\\n",""));
                    //Toast.makeText(MainActivity.this,jso.toString(),Toast.LENGTH_SHORT).show();
                    txt1.setText("Request sent: "+jso.toString());
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
}
