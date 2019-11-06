package com.example.obj_try;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class terms extends AppCompatActivity {
    Button b1;
    CheckBox c1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);
        b1=findViewById(R.id.b1);
        c1=findViewById(R.id.c1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c1.isChecked()){
                    Intent i=new Intent(terms.this,option.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(terms.this,"You have to accept\nterms and conditions",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
