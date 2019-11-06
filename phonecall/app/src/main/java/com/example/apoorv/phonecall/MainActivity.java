package com.example.apoorv.phonecall;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn,btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
    }
    public void click(View v){
    String ph="8696785996";
    Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+ph));
    startActivity(i);
    }
    public void click1(View v){
       String ph1="7728852714";
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+ph1));
        startActivity(i);
    }
    public void click2(View v){
      String ph2="8233338084";
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+ph2));
        startActivity(i);
    }
}