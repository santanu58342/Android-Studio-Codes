package com.example.metro;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.metro.list.*;
public class MainActivity extends AppCompatActivity {
    TextView t1,t2;
    static Button b1,b2,b3,b4;
    static int f,si,di,c,j;
    static String s=null,s1=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,list.class);
                startActivity(i);
                f=0;j=0;
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,list.class);
                startActivity(i);
                f=1;j=0;
            }
        });
        if (f==1) {
            t1.setText(stations[i2]);
            s = t1.getText().toString();
            si=i2;
        }
        t1.setText(s);
        if (f==2) {
            t2.setText(stations[i2]);
            s1= t2.getText().toString();
            f = 0;
            di=i2;
        }
        if(si<di)
            c=di-si+1;
        else
            c=si-di+1;
        t2.setText(s1);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s!=null && s1!=null && s!=s1) {
                    Intent i = new Intent(MainActivity.this, find.class);
                    startActivity(i);
                }
                else if(s==null && s1!=null){
                    Toast.makeText(MainActivity.this, "Set source field", Toast.LENGTH_SHORT).show();
                }
                else if(s1==null && s!=null){
                    Toast.makeText(MainActivity.this, "Set destination field", Toast.LENGTH_SHORT).show();
                }
                else if(s==s1 && s!=null && s1!=null){
                    Toast.makeText(MainActivity.this, "Same source and destination choose other\nsource or destination", Toast.LENGTH_SHORT).show();
                }
                else if (s==null && s1==null){

                    Toast.makeText(MainActivity.this, "Set both field first", Toast.LENGTH_SHORT).show();
                }
                else{
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,others.class);
                startActivity(i);
                j=1;
            }
        });
    }
}