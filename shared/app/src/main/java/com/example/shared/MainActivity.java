package com.example.shared;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    String u,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=getSharedPreferences("x",MODE_PRIVATE);
        u=sp.getString("k1",null);
        p=sp.getString("k2",null);
        Thread t=new Thread(){
            @Override
            public void run() {
                try{
                    sleep(3000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    if(u!=null && p!=null) {
                        Intent obj = new Intent(MainActivity.this, home.class);
                        startActivity(obj);
                    }
                    else{
                        Intent obj = new Intent(MainActivity.this, login.class);
                        startActivity(obj);
                    }
                }
            }
        };
        t.start();
    }
}
