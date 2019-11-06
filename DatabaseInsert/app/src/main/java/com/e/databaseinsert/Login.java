package com.e.databaseinsert;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    DB obj;
    EditText u,p;
    Button lg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lg= findViewById(R.id.button7);
        u=findViewById(R.id.userr);
        p=findViewById(R.id.passwee);
        obj=new DB(Login.this);
        u.setInputType(InputType.TYPE_CLASS_NUMBER);
        p.setInputType(InputType.TYPE_CLASS_NUMBER);

        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=u.getText().toString();
                String pass=p.getText().toString();

                try{

                    Cursor c =obj.login_user(Integer.parseInt(user));

                    if(c.getCount()==0){

                        Toast.makeText(Login.this, "No data found", Toast.LENGTH_LONG).show();
                    }

                    else{

                        c.moveToFirst();

                        int password=c.getInt(2);

                        String pas=String.valueOf(password);


                        if(pas.equals(pass)){
                            Intent i=new Intent(Login.this,MainActivity.class);

                            startActivity(i);

                        }
                        else {
                            Toast.makeText(Login.this, "Invalid u&&p", Toast.LENGTH_LONG).show();
                        }

                    }
                }
                catch (Exception t){
                    Toast.makeText(Login.this, ""+t, Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
