package com.example.login_day2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.login_day2.MainActivity.p1;
import static com.example.login_day2.MainActivity.u1;

public class register extends AppCompatActivity {
    TextView t2,t3,t4,t5;
    EditText e3,e4,e5;
    Button b3;
    String cp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        e3=findViewById(R.id.e3);
        e4=findViewById(R.id.e4);
        e5=findViewById(R.id.e5);
        b3=findViewById(R.id.b3);
        u1=e3.getText().toString();
        p1=e4.getText().toString();
        cp=e5.getText().toString();
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (p1.equals(cp)){
                    Intent k=new Intent(register.this,MainActivity.class);
                    k.putExtra("u",u1);
                    k.putExtra("p",p1);
                    k.putExtra("m","Registered successfully \n you can login now");
                    startActivity(k);
                    finish();
                }
                else{
                    t5.setText("Password did not matched try again");
                    e4.setText(null);
                    e5.setText(null);
                }
            }
        });
    }
}