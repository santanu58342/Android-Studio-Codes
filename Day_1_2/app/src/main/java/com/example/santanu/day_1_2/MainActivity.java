package com.example.santanu.day_1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import  android.view.View;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
        private  Button b1;
        private EditText t1;
        private TextView v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show();

    }
    public void show(){
        b1=(Button)findViewById(R.id.button1);
        t1=(EditText)findViewById(R.id.editText1);
        v1=(TextView)findViewById(R.id.textView1);
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String s;
                s=t1.getText().toString();
                v1.setText(s);
            }
        });
    }
}
