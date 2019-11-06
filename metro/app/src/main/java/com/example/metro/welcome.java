package com.example.metro;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class welcome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Thread th=new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }
                catch (Exception e){ }
                finally {
                    Intent i=new Intent(welcome.this,otp.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        th.start();
    }
}