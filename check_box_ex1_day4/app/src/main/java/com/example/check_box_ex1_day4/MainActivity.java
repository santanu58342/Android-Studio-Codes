package com.example.check_box_ex1_day4;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5;
    static CheckBox c1,c2,c3;
    TextView t1,t2,t3,t4,t5,t6;
    static String s;
    static int c=0,cc=0,m=0,mc=0,f=0,fc=0,tc=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        c3=findViewById(R.id.c3);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        t6=findViewById(R.id.t6);
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true){
                    c=1;
                    cc=120;
                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            c++;
                            cc=c*120;
                            t4.setText(""+cc);
                            s=Integer.toString(c);
                            b1.setText(s);
                        }
                    });
                }
                else{
                    c=0;
                    cc=0;
                    b1.setText("+");
                    t4.setText("120");
                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                }
            }
        });
        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true){
                    m=1;
                    mc=160;
                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            m++;
                            mc=m*160;
                            t5.setText(""+mc);
                            s=Integer.toString(m);
                            b2.setText(s);
                        }
                    });
                }
                else{
                    m=0;
                    mc=0;
                    b2.setText("+");
                    t5.setText("160");
                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                }
            }
        });
        c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true){
                    f=1;
                    fc=140;
                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            f++;
                            fc=f*140;
                            t6.setText(""+fc);
                            s=Integer.toString(f);
                            b3.setText(s);
                        }
                    });
                }
                else{
                    f=0;
                    fc=0;
                    b3.setText("+");
                    t6.setText("140");
                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c1.isChecked()==false && c2.isChecked()==false && c3.isChecked()==false){
                    Toast.makeText(MainActivity.this, "You have not choosed any item\nSelect item to order", Toast.LENGTH_LONG).show();
                }
                else {
                    tc = cc + mc + fc;
                    Intent i = new Intent(MainActivity.this, Final.class);
                    startActivity(i);
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }
    void reset(){
        t4.setText("120");
        t5.setText("160");
        t6.setText("140");
        c=0;cc=0;m=0;mc=0;f=0;fc=0;tc=0;
        b1.setText("+");
        b2.setText("+");
        b3.setText("+");
        if (c1.isChecked()==true){
            c1.setChecked(false);
            c1.setSelected(false);
        }
        if (c2.isChecked()==true){
            c2.setChecked(false);
            c2.setSelected(false);
        }
        if (c3.isChecked()==true){
            c3.setChecked(false);
            c3.setSelected(false);
        }
    }
}