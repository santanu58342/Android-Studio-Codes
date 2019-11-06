package com.example.santanu.day_1_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Button;
//import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
    private TextView t1,t2;
    String s="";
    String k="";
    long res=0,n;
    int a[]=new int[100];

    String str[]=new String[100];
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show();
    }
    public void show(){
        b0=(Button)findViewById(R.id.button0);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);
        b6=(Button)findViewById(R.id.button6);
        b7=(Button)findViewById(R.id.button7);
        b8=(Button)findViewById(R.id.button8);
        b9=(Button)findViewById(R.id.button9);
        b10=(Button)findViewById(R.id.button10);
        b11=(Button)findViewById(R.id.button11);
        b12=(Button)findViewById(R.id.button12);
        b13=(Button)findViewById(R.id.button13);
        b14=(Button)findViewById(R.id.button14);
        b15=(Button)findViewById(R.id.button15);
        t1=(TextView)findViewById(R.id.textView1);
        t2=(TextView)findViewById(R.id.textView2);

        b0.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                s=s+b0.getText();
                k=b0.getText().toString();
                t1.setText(s);
            }
        });
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                s=s+b1.getText();
                k=b1.getText().toString();
                t1.setText(s);
            }
        });
        b2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                s=s+b2.getText();
                k=b2.getText().toString();
                t1.setText(s);
            }
        });
        b3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                s=s+b3.getText();
                k=b3.getText().toString();
                t1.setText(s);
            }
        });
        b4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                s=s+b4.getText();
                k=b4.getText().toString();
                t1.setText(s);
            }
        });
        b5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                s=s+b5.getText();
                k=b5.getText().toString();
                t1.setText(s);
            }
        });
        b6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                s=s+b6.getText();
                k=b6.getText().toString();
                t1.setText(s);
            }
        });
        b7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                s=s+b7.getText();
                k=b7.getText().toString();
                t1.setText(s);
            }
        });
        b8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                s=s+b8.getText();
                k=b8.getText().toString();
                t1.setText(s);
            }
        });
        b9.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                s=s+b9.getText();
                k=b9.getText().toString();
                t1.setText(s);
            }
        });
        b10.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(res==0)
                   res=1;
               n=Long.parseLong(k);
                s=s+b10.getText();
                res=res*Long.parseLong(k);
                k="";
                t1.setText(s);
                t2.setText(String.valueOf(res));
            }
        });

        b13.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                str[i]=s;
                i++;
                str[i]=b13.getText().toString();
                i++;
                s="";
            }
        });
        b12.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                str[i]=s;
                i++;
                str[i]=b12.getText().toString();
                i++;
                s="";
            }
        });
        b11.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                str[i]=s;
                i++;
                str[i]=b11.getText().toString();
                i++;
                s="";
            }
        });
        b10.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                str[i]=s;
                i++;
                str[i]=b10.getText().toString();
                i++;
                s="";
            }
        });
        b14.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText(String.valueOf(res));
            }
        });
        b15.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                s=s.substring(0,s.length()-1);
                if(s.length()==0)
                    s="";
                t2.setText(String.valueOf(res));
            }
        });
    } // show close
}