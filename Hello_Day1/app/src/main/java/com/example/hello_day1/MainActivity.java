package com.example.hello_day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.y);
        t=findViewById(R.id.x);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                t.setText("Hello World");
            }
        });
    }
}