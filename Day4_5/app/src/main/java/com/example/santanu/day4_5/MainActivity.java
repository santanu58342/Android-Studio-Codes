package com.example.santanu.day4_5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.Menu;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    TimePicker tp1;
    TextView t1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView)findViewById(R.id.textView1);
        b1=(Button)findViewById(R.id.button1);
        tp1=(TimePicker)findViewById(R.id.timePicker1);
        t1.setText(getCurrentTime());
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText(getCurrentTime());
            }
        });
    }
    public String getCurrentTime(){
        String s="Current time:- "+tp1.getCurrentHour()+" : "+tp1.getCurrentMinute();
        return s;
    }
}
