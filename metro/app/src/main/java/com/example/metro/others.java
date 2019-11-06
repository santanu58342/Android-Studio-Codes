package com.example.metro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class others extends AppCompatActivity {
    Button b1,b2,b3,b4;
    static String s11,s12;
    static int k=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(others.this,display.class);
                s11="This is kolkata app.Kolkata metro have route of 17 kms.";
                s12="First metro:- 8:30 am\nLast metro:- 9:30pm";
                startActivity(i);
                k=0;
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(others.this,list.class);
                startActivity(i);
                k=1;
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(others.this,list.class);
                startActivity(i);
                k=2;
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(others.this,list.class);
                startActivity(i);
                k=3;
            }
        });
    }
}