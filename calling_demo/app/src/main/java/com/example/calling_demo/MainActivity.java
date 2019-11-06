package com.example.calling_demo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    WebView w1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        w1=findViewById(R.id.w1);
        ActionBar a=getSupportActionBar();
        a.hide();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 7278284618"));
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.in"));
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    SmsManager sm=SmsManager.getDefault();
                    sm.sendTextMessage("7278284618",null,"hello",null,null);
                    Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        w1.loadUrl("youtube.com");
    }
}