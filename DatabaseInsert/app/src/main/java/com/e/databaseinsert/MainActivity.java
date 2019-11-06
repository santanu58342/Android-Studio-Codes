package com.e.databaseinsert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DB db;
EditText e1,e2,e3,e4;
Button b,b1,up,abc,del;
String roll,name,mobile,stream;
int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.r);
        e2=findViewById(R.id.n);
        e3=findViewById(R.id.m);
        e4=findViewById(R.id.s);
        b=findViewById(R.id.s1);
        b1=findViewById(R.id.get);
        up= findViewById(R.id.button3);
        abc= findViewById(R.id.button4);
        del= findViewById(R.id.button5);
        db=new DB(MainActivity.this);
        e1.setInputType(InputType.TYPE_CLASS_NUMBER);
        e2.setInputType(InputType.TYPE_CLASS_TEXT);
        e3.setInputType(InputType.TYPE_CLASS_PHONE);
        e4.setInputType(InputType.TYPE_CLASS_TEXT);

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent(MainActivity.this,Delete_Record.class);
                startActivity(obj);
            }
        });

        abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    db.dell_record_all();

                    Toast.makeText(MainActivity.this, "delete ho gya", Toast.LENGTH_LONG).show();
                }catch (Exception t){

                    Toast.makeText(MainActivity.this, "Try again..", Toast.LENGTH_LONG).show();
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll = e1.getText().toString();
                name = e2.getText().toString();
                mobile = e3.getText().toString();
                stream = e4.getText().toString();
                try {
                    db.add(Integer.parseInt(roll), name, Integer.parseInt(mobile), stream);
                    clean();
                    Toast.makeText(MainActivity.this, "data inserted Successfully", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "Error"+e, Toast.LENGTH_SHORT).show();
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Display.class));
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll=e1.getText().toString();
                name=e2.getText().toString();
                mobile=e3.getText().toString();
                stream=e4.getText().toString();
                if(count==0)
                {
                    count++;
                    e1.setText(roll);
                    e2.setText(name);
                    e3.setText(mobile);
                    e4.setText(stream);
                    Toast.makeText(MainActivity.this, "Confirm", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    count=0;
                    try{
                        db.update_record(Integer.parseInt(roll), name, Integer.parseInt(mobile), stream);

                        clean();
                        Toast.makeText(MainActivity.this, "Record update..", Toast.LENGTH_LONG).show();
                    }catch (Exception t){

                        Toast.makeText(MainActivity.this, "try again..", Toast.LENGTH_LONG).show();

                        clean();
                    }
                }

                    }
                });
            }

    public void clean()
    {
        e1.setText(null);
        e2.setText(null);
        e3.setText(null);
        e4.setText(null);
        e1.requestFocus();
    }

}
