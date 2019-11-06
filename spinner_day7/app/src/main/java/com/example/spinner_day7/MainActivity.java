package com.example.spinner_day7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import static com.example.spinner_day7.display.q;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    static String city[]={"kolkata","pochinki","military base","georgepool"};
    static String s;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=findViewById(R.id.sp);
        b1=findViewById(R.id.b1);
        ArrayAdapter<String>obj;
        obj=new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,city);
        sp.setAdapter(obj);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                s=(String)parent.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,display.class);
                startActivity(i);
                if(s==null)
                    b1.setText("show");
                else
                    b1.setText(q);
            }
        });
    }
}
