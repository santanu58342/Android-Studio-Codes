package com.example.santanu.day_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import  android.widget.EditText;
import  android.widget.TextView;
import android.view.Menu;
import  android.view.View;
import android.app.Activity;
public class MainActivity extends AppCompatActivity {
    private Button b1;
    private EditText e1, e2;
    private TextView t1;
    double a, b, c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show();
    }
    public void show() {
        b1 = (Button) findViewById(R.id.button1);
        e1 = (EditText) findViewById(R.id.editText1);
        e2 = (EditText) findViewById(R.id.editText2);
        t1 = (TextView) findViewById(R.id.textView1);

        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String n1 = e1.getText().toString();
                a = Double.parseDouble(n1);
                String n2 = e2.getText().toString();
                b = Double.parseDouble(n2);
                c=a+b;
                t1.setText(String.valueOf(c));
            }
        });
    }
}
