package com.example.santanu.day5_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        //Toast.makeText(getApplicationContext(),"hello shantanu",Toast.LENGTH_LONG).show();
        Bundle extras=getIntent().getExtras();
        String value1=extras.getString("Value1");
        String value2=extras.getString("Value2");
        Toast.makeText(getApplicationContext(),"Values are "+value1+" and "+value2,Toast.LENGTH_LONG).show();
        Button button1=(Button)findViewById(R.id.Button01);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(),MainActivity.class);
              //   i.putExtra("Value1","Hello World");
                // i.putExtra("Value2","Good Afternoon");
                startActivity(i);
            }
        });
    }
}



