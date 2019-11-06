package com.example.santanu.day5_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1=(Button)findViewById(R.id.Button01);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_LONG).show();
                Intent i=new Intent(MainActivity.this,MainActivity2.class);
              i.putExtra("Value1","Hello World");
               i.putExtra("Value2","Good Afternoon");
               startActivity(i);
            }
        });
    }
}
