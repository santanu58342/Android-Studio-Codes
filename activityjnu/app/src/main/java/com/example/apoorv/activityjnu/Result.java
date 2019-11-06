package com.example.apoorv.activityjnu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv=findViewById(R.id.textView2);
        Bundle b=getIntent().getExtras();
        tv.setText(b.getString("str"));
    }
}
