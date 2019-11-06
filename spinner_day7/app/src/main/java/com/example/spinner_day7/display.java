package com.example.spinner_day7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import static com.example.spinner_day7.MainActivity.*;
public class display extends AppCompatActivity {
    TextView t1;
    AutoCompleteTextView a1;
    static  String q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        t1=findViewById(R.id.t1);
        a1=findViewById(R.id.a1);
        t1.setText(s);
        ArrayAdapter<String>obj;
        obj=new ArrayAdapter<>(display.this,R.layout.support_simple_spinner_dropdown_item,city);
        a1.setThreshold(1);
        a1.setAdapter(obj);
        a1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                q=(String)parent.getItemAtPosition(position);
                Intent i=new Intent(display.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
