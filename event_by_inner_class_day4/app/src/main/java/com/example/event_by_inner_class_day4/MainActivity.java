package com.example.event_by_inner_class_day4;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b11);
        b2=findViewById(R.id.b21);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        /*b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Hello world",Toast.LENGTH_LONG).show();
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.b11) {
            Toast.makeText(this, "hello Interface Listener", Toast.LENGTH_LONG).show();
        }
        if(v.getId()==R.id.b21) {
            Toast.makeText(this, "2nd one", Toast.LENGTH_LONG).show();
        }
    }
}