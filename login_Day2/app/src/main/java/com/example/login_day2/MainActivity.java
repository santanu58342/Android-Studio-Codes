package com.example.login_day2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    TextView t1;
    EditText e1,e2;
    public static String u,p,u1,p1;
    final String u11=u1;
    final String p11=p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        t1=findViewById(R.id.t1);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        u=e1.getText().toString();
        p=e2.getText().toString();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (u.equals(u11) && p.equals(p11)){
                    Intent i = new Intent(MainActivity.this,ls.class);
                    i.putExtra("lu",e1.getText().toString());
                    startActivity(i);
                    finish();
                }
                else if(!u.equals(u11) && p.equals(p11)){
                    t1.setText("username did not match try again");
                    e1.setText(null);
                }
                else if(!p.equals(p11) && u.equals(u11)){
                    t1.setText("password did not match try again");
                    e2.setText(null);
                }
                else{
                    t1.setText("User not found register now");
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this,register.class);
                startActivity(j);
                finish();
            }
        });
        u1=getIntent().getStringExtra("u");
        p1=getIntent().getStringExtra("p");
        String m= getIntent().getStringExtra("m");
        t1.setText(m);
    }
}