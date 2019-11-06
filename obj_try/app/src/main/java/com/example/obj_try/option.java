package com.example.obj_try;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class option extends AppCompatActivity {
    Button b11,b12;
    static int s,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        b11=findViewById(R.id.b11);
        b12=findViewById(R.id.b12);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=0;d=4;
                Intent m=new Intent(option.this,MainActivity.class);
                startActivity(m);
                finish();
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=5;d=9;
                Intent k=new Intent(option.this,MainActivity.class);
                startActivity(k);
                finish();
            }
        });
    }
}