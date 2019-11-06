package com.example.obj_try;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class login extends AppCompatActivity {
    Button b1,b2;
    Database db=new Database(login.this);
    TextView t1;
    EditText e1,e2;
    static String u=null,p=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        t1=findViewById(R.id.t1);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e1.setText(null);
        e2.setText(null);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                u=e1.getText().toString();
                p=e2.getText().toString();
                if(!u.matches("") && !p.matches("")){
                    if(db.getu(u,p)==true){
                        Intent i = new Intent(login.this,terms.class);
                        u=e1.getText().toString();
                        i.putExtra("u",u);
                        startActivity(i);
                        finish();
                    }
                    else{
                        t1.setText("User not found register now");
                    }
                }
                else if(u.matches("") && !p.matches("")){
                    Toast.makeText(login.this, "Enter username", Toast.LENGTH_SHORT).show();
                }
                else if(!u.matches("") && p.matches("")){
                    Toast.makeText(login.this, "Enter password", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(login.this, "Enter username and password first", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(login.this,regis.class);
                startActivity(j);
                finish();
            }
        });
        String m= getIntent().getStringExtra("m");
        t1.setText(m);
    }
}