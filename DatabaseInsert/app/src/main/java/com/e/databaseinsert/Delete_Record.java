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

public class Delete_Record extends AppCompatActivity {
    EditText rl_id;
    Button dl,nxt;
    DB obj;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete__record);
        rl_id= findViewById(R.id.editText5);
        dl= findViewById(R.id.button6);
        nxt= findViewById(R.id.button8);
        rl_id.setInputType(InputType.TYPE_CLASS_NUMBER);

        obj=new DB(Delete_Record.this);
        dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    String r = rl_id.getText().toString();
                    int r12=Integer.parseInt(r);
                    Cursor c = obj.login_user(Integer.parseInt(r));
                    if (c.getCount() == 0) {

                        Toast.makeText(Delete_Record.this, "No data found", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                    c.moveToFirst();
                    int id = c.getInt(0);
                    if(id==r12) {
                        obj.dell_record_byRoll(Integer.parseInt(r));
                        rl_id.setText(null);
                        Toast.makeText(Delete_Record.this, "Found and deleted", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(Delete_Record.this, ""+e, Toast.LENGTH_SHORT).show();
                }
            }
        });

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Delete_Record.this,Login.class);

                startActivity(i);
            }
        });
    }
}
