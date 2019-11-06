package com.example.login_day2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ls extends AppCompatActivity {
    TextView t6;
    Button b4;
    String m;
    public static String u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ls);
        t6=findViewById(R.id.t6);
        b4=findViewById(R.id.b4);
        u=getIntent().getStringExtra("lu");
        m="Login successfully\n Welcome "+u;
        t6.setText(m);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lo=new Intent(ls.this,MainActivity.class);
                startActivity(lo);
                finish();
            }
        });
    }
}