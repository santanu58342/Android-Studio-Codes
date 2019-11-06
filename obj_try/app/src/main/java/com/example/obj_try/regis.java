package com.example.obj_try;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class regis extends AppCompatActivity {
    TextView t2,t3,t4,t5;
    EditText e3,e4,e5;
    Button b3;
    Database db=new Database(regis.this);
    static String cp,p11,u11;
    String ut,pt,cpt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        e3=findViewById(R.id.e3);
        e4=findViewById(R.id.e4);
        e5=findViewById(R.id.e5);
        b3=findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ut=e3.getText().toString();
                u11 = ut;
                pt=e4.getText().toString();
                p11 = pt;
                cpt=e5.getText().toString();
                cp=cpt;
                if (p11.equals(cp) && !u11.matches("") && !p11.matches("") && !cp.matches("")){
                    u11=e3.getText().toString();
                    p11=e4.getText().toString();
                    db.addu(u11,p11);
                    Intent k=new Intent(regis.this,login.class);
                    k.putExtra("m","Registered successfully \n you can login now");
                    startActivity(k);
                    t5.setText(null);
                    finish();
                }
                else if(u11.matches("") && p11.matches("") && cp.matches("")){
                    Toast.makeText(regis.this, "Fill the fields", Toast.LENGTH_SHORT).show();
                }
                else if(u11.matches("") && !p11.matches("") && !cp.matches("")){
                    Toast.makeText(regis.this, "Enter user name", Toast.LENGTH_SHORT).show();
                }
                else if(!u11.matches("") && p11.matches("") && !cp.matches("")){
                    Toast.makeText(regis.this, "Enter password", Toast.LENGTH_SHORT).show();
                }
                else if(!u11.matches("") && p11.matches("") && cp.matches("")){
                    Toast.makeText(regis.this, "Enter password and confirm password", Toast.LENGTH_SHORT).show();
                }
                else if(!u11.matches("") && !p11.matches("") && cp.matches("")){
                    Toast.makeText(regis.this, "Enter confirm password", Toast.LENGTH_SHORT).show();
                }
                else{
                    t5.setText("Password did not matched try again");
                    e4.setText(null);
                    e5.setText(null);
                }
            }
        });
    }
}