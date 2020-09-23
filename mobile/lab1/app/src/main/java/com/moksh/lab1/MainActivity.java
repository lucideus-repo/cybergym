package com.moksh.lab1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    int i;
    Cursor cursor;
    SQLiteDatabase secureDB;
    Context context;
    int max_tries = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase.loadLibs(this);
        context = this.getApplicationContext();
        final Pinview pin1 = findViewById(R.id.pinview1);
        final TextView tv1 = findViewById(R.id.textView1);
        final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        int d1 = b.checkAppSignature(this);
        if(d1 < 1){
            Toast.makeText(context,"Application Tampered",Toast.LENGTH_LONG).show();
            this.finishAffinity();
        }
        try{
            String  bb = new String("123456");
            File dbFile = this.getDatabasePath("q.db");
            dbFile.getParentFile().mkdir();
            this.deleteDatabase("q.db");
            secureDB = SQLiteDatabase.openOrCreateDatabase(this.getDatabasePath("q.db"), bb, null);
            secureDB.execSQL("CREATE TABLE IF NOT EXISTS a(z VARCHAR,a VARCHAR);");
            SQLiteDatabase dbdb = SQLiteDatabase.openOrCreateDatabase(this.getDatabasePath("kkk.db"),"12345678",null);
            dbdb.execSQL("CREATE TABLE IF NOT EXISTS name(user VARCHAR, pass VARCHAR)");
            dbdb.execSQL("INSERT INTO name VALUES('moksh','password')");
            dbdb.close();
        }catch(Exception e){
            Toast.makeText(MainActivity.this, "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.e("PinView",e.getMessage());
            e.printStackTrace();
        }

        cursor = secureDB.rawQuery("SELECT * from a;",null);
        cursor.moveToFirst();
        //Toast.makeText(MainActivity.this, "Rows: "+cursor.getCount(), Toast.LENGTH_SHORT).show();
        if(cursor.getCount() < 1){
            //Add pin
            String pinx1 = createPin();
            String pinx2 = createPin();
            //Toast.makeText(MainActivity.this, "Pin: "+pinx1, Toast.LENGTH_SHORT).show();
            secureDB.execSQL("INSERT INTO a(z,a) VALUES('"+pinx1+"','"+pinx2+"');");
            cursor.close();
        }else{
            //Pin already present, do nothing
            cursor.close();
        }


        final SharedPreferences sharedPref = getSharedPreferences("a", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();
        if(!sharedPref.contains("val")){
            editor.putInt("val",0);
            editor.commit();
        }


        pin1.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                //Make api calls here or what not
                i = sharedPref.getInt("val",0);
                if(i >= max_tries){
                    Toast.makeText(MainActivity.this, "Attempts made! Wait 30 seconds", Toast.LENGTH_SHORT).show();
                    pin1.clearValue();
                    if(v.hasVibrator()){
                        v.vibrate(400);
                    }



                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            pin1.setEnabled(true);
                            pin1.setFocusable(true);
                            Toast.makeText(MainActivity.this, "Enabled, please try again.", Toast.LENGTH_SHORT).show();
                            i = 0;
                            editor.putInt("val",i);
                            editor.commit();
                        }
                    }, 30 * 1000);

                }
                else{
                    i = i+1;
                    editor.putInt("val",i);
                    editor.commit();
                    String pp = pinview.getValue();
                    //Toast.makeText(MainActivity.this, pp, Toast.LENGTH_SHORT).show();
                    cursor = secureDB.rawQuery("SELECT * FROM a;",null);
                    cursor.moveToFirst();
                    if(pp.equalsIgnoreCase(cursor.getString(0))){
                        Toast.makeText(MainActivity.this, "Right Pin, Congratulations", Toast.LENGTH_SHORT).show();
                        pin1.removeAllViews();
                        String xo = getResources().getString(R.string.google_api_key);
                        a mo = new a();
                        xo = mo.func1(xo,xo.substring(4));
                        xo = a.func2(xo);
                        xo = a.func3(xo.substring(1),xo);
                        xo = a.func4(xo,xo,xo.substring(2));
                        tv1.setText("Flag: "+xo);
                    }else{
                        Toast.makeText(MainActivity.this, "Incorrect Pin, "+(max_tries+1-i)+" attempts remaining", Toast.LENGTH_SHORT).show();
                    }
                    cursor.close();
                }
            }
        });

    }

    private String createPin(){
        int randomPIN = (int)(Math.random()*9000)+1000;
        return String.valueOf(randomPIN);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        secureDB.close();
    }
}
