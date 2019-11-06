package com.example.chkbox_rdiobtn_day4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    CheckBox c1,c2;
    String s="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c1.isChecked()==true){
                    s=s+c1.getText().toString();
                }
                if (c2.isChecked()==true){
                    s=s+c2.getText().toString();
                }
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
                s="";
            }
        });
    }
}
