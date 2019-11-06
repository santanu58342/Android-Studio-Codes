package com.example.splash_scrn_day6;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread th=new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }
                catch (Exception e){ }
                finally {
                    Intent i=new Intent(MainActivity.this,home.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        th.start();
    }
}