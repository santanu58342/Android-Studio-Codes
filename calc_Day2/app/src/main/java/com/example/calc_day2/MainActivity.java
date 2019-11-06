package com.example.calc_day2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5;
    EditText e1,e2;
    TextView t1;
    int i1,i2,i3;
    String s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        t1=findViewById(R.id.t1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                i1=Integer.parseInt(s1);
                s2=e2.getText().toString();
                i2=Integer.parseInt(s2);
                i3=i1+i2;
                s3=String.valueOf(i3);
                t1.setText(s3);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                i1=Integer.parseInt(s1);
                s2=e2.getText().toString();
                i2=Integer.parseInt(s2);
                i3=i1-i2;
                s3=String.valueOf(i3);
                t1.setText(s3);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                i1=Integer.parseInt(s1);
                s2=e2.getText().toString();
                i2=Integer.parseInt(s2);
                i3=i1*i2;
                s3=String.valueOf(i3);
                t1.setText(s3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                i1=Integer.parseInt(s1);
                s2=e2.getText().toString();
                i2=Integer.parseInt(s2);
                float i3=(float)i1/i2;
                s3=String.valueOf(i3);
                t1.setText(s3);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(null);
                e2.setText(null);
                t1.setText(null);
            }
        });
    }
}
