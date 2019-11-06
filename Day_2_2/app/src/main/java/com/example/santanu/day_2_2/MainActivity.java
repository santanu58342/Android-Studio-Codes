package com.example.santanu.day_2_2;

import android.support.v7.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private Button b1;
    private EditText e1,e2;
    private TextView t1;
    private CheckBox c1,c2,c3;
    double a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show();
    }

    void show(){


        b1=(Button)findViewById(R.id.button1);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        t1=(TextView)findViewById(R.id.textView1);

        c1 = (CheckBox) findViewById(R.id.checkBox);
        c2 = (CheckBox) findViewById(R.id.checkBox2);
        c3 = (CheckBox) findViewById(R.id.checkBox3);

        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                a=Double.parseDouble(e1.getText().toString());
                b=Double.parseDouble(e2.getText().toString());


                if(a>b){
                    t1.setText(Double.toString(a)+" is greater");
                }
                else if(a<b){
                    t1.setText(Double.toString(b)+" is greater");
                }
                else if(a==b){
                    t1.setText(Double.toString(a)+" equals to "+Double.toString(b));
                }
                else{
                    t1.setText("Invalid entries");
                }

                int totalamount = 0;

                StringBuilder result = new StringBuilder();
                result.append("Selected Items:");


                if (c1.isChecked()) {
                    result.append("\n Mutton");
                    totalamount += 500;
                }
                if (c2.isChecked()) {
                    result.append("\n Chicken");
                    totalamount += 400;
                }
                if (c3.isChecked()) {
                    result.append("\n Fish");
                    totalamount += 200;
                }
                result.append("\n Total : Rs" + totalamount);
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();


                // Toast.makeText(getApplicationContext(), "Hello world", Toast.LENGTH_LONG).show();


            }
        });
    }
}