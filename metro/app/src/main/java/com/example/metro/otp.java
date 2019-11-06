package com.example.metro;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class otp extends AppCompatActivity {
    Button b1,b2;
    EditText e1;
    int n,o;
    String s;
    Random r = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        e1=findViewById(R.id.e1);
        n = r.nextInt(9999 - 1000);
        Toast.makeText(otp.this,"OTP is "+n,Toast.LENGTH_LONG).show();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=e1.getText().toString();
                if(s.isEmpty() || s.length() == 0 || s.equals("") || s == null) {
                    Toast.makeText(otp.this,"Enter otp first",Toast.LENGTH_LONG).show();
                    return;
                }
                o=Integer.parseInt(s);
                e1.setText(null);
                if(o==n){
                    n=r.nextInt(9999 - 1000);;
                    Intent i=new Intent(otp.this,MainActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(otp.this,"OTP did not matched try again",Toast.LENGTH_LONG).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = r.nextInt(9999 - 1000);
                Toast.makeText(otp.this,"OTP is "+n,Toast.LENGTH_LONG).show();
            }
        });
    }
}