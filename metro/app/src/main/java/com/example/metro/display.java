package com.example.metro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import static com.example.metro.others.*;
import static com.example.metro.list.*;
public class display extends AppCompatActivity {
    TextView t1,t2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        b1=findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(display.this,MainActivity.class);
                startActivity(i);
            }
        });
        if(k==0){
            t1.setText(s11);
            t2.setText(s12);
        }
        if (k==1){
            t1.setText(police[i2]);
            t2.setText(psinfo[i2]);
        }
        if(k==2){
            t1.setText(hospital[i2]);
            t2.setText(hinfo[i2]);
        }
        if(k==3){
            t1.setText(parking[i2]);
            t2.setText(pkinfo[i2]);
        }
    }
}
