package com.example.obj_try;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import static com.example.obj_try.MainActivity.*;
import static com.example.obj_try.login.*;
public class result extends AppCompatActivity {
    Button b1;
    TextView t1,t2,t3,t4,t5,t7;
    String s;
    static  String m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        t7=findViewById(R.id.t7);
        b1=findViewById(R.id.b1);
        m=u;
        s=t1.getText().toString();
        t1.setText(s.concat(m));
        s=t2.getText().toString();
        t2.setText(s+tq);
        s=t3.getText().toString();
        t3.setText(s+ta);
        s=t4.getText().toString();
        t4.setText(s+ca);
        s=t5.getText().toString();
        t5.setText(s+wa);
        s=t7.getText().toString();
        t7.setText(s+ts);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tq=0;ta=0;ca=0;wa=0;ts=0;

                Intent i=new Intent(result.this,login.class);
                startActivity(i);
            }
        });
    }
}