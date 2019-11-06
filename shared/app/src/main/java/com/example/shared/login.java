package com.example.shared;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    String u,p;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        b1=findViewById(R.id.b1);
        sp=getSharedPreferences("x", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit=sp.edit();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                u=e1.getText().toString();
                p=e2.getText().toString();
                if(u.equals("admin") && p.equals("123")){
                    edit.putString("k1",u);
                    edit.putString("k2",p);
                    edit.commit();
                    Toast.makeText(login.this, "success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(login.this,home.class));
                }
                else
                    Toast.makeText(login.this, "wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
