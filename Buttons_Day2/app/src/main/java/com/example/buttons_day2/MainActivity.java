package com.example.buttons_day2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b;
    TextView t;
    EditText e;
    int s;
    String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.b1);
        t = findViewById(R.id.t1);
        e=findViewById(R.id.e1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e.getText().toString();
                s=Integer.parseInt(s1);
                s=s*s;
                e.setText(null);
                s1=String.valueOf(s);
                t.setText(s1);
            }
        });
    }
}