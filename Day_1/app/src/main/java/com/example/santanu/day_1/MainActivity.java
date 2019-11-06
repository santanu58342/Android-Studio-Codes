package com.example.santanu.day_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
//import android.view.View;
//import android.view.Menu;
//import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android .widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ToggleButton t1,t2;
    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(this,"Santanu Banerjee",Toast.LENGTH_LONG).show();
        show();
    }
    public void show(){
        t1=(ToggleButton)findViewById(R.id.toggleButton1);
        t2=(ToggleButton)findViewById(R.id.toggleButton2);
        b1=(Button)findViewById(R.id.button1);

         b1.setOnClickListener(new OnClickListener() {
             @Override
             public void onClick(View view) {
                //StringBuffer sb=new StringBuffer();
                 t1.setChecked(true);
                 t2.setChecked(true);
                //sb.append("Toggle button 1:- ").append(t1.getText());
                //sb.append("Toggle button 2:- ").append(t2.getText());
                 //Toast.makeText(getApplicationContext(),sb.toString(),Toast.LENGTH_LONG).show();
             }
         });
    }//show close
}
