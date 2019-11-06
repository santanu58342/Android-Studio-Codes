package com.example.obj_try;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.obj_try.option.*;
public class MainActivity extends AppCompatActivity {
    TextView t1;
    RadioGroup rg1;
    RadioButton r1,r2,r3,r4,rr;
    Button b1,b2;
    static int tq,ta=0,ca=0,wa=0,ts=0;
    int max=10;
    int cou=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Vd obj[]=new Vd[max];
        obj[0]=new Vd("Which is the way in which a thread can enter the waiting state?","Invoke its sleep() method.","invoke object's wait method.","Invoke its suspend() method.","All of the above.",3);
        obj[1]=new Vd("Which of the following is a thread safe?","StringBuilder","StringBuffer","Both of the above","none of the above",1);
        obj[2]=new Vd("Which Set class should be most popular in a multi-threading environment, considering performance constraint?","HashSet","ConcurrentSkipListSet","LinkedHashSet","CopyOnWriteArraySet",1);
        obj[3]=new Vd("3. What is the difference between servlets and applets?\n" +
                "i.Servlets execute on Server; Applets execute on browser\n" +
                "ii.Servlets have no GUI; Applet has GUI\n" +
                "iii.Servlets creates static web pages; Applets creates dynamic web pages\n" +
                "iv.Servlets can handle only a single request; Applet can handle multiple requests","i,ii are correct","i,iii are correct","i,ii,iii are correct","i,ii,iii,iv are correct",0);
        obj[4]=new Vd("What is the disadvantage of Type-4 Native-Protocol Driver?","Type-4 driver is entirely written in Java","It does not support to read MySQL data.","At client side, a separate driver is needed for each database.","The driver converts JDBC calls into vendor-specific database protocol",2);
        obj[5]=new Vd("Space between edge to of widget content of widget can be customized using_________?","margins","height","padding","weight",2);
        obj[6]=new Vd("Multiple inheritance is not allowed in Java therefore in an android activity there cannot be more then one_________?","super class","child class","sub class","public class",0);
        obj[7]=new Vd("A type of layout elements that allows all included elements in order is___________? ","ConstraintLayout","GridLayout","LinearLayout","RelativeLayout",2);
        obj[8]=new Vd("One of option that is not part of palette elements is__________?","date and time","layouts","containers","default",3);
        obj[9]=new Vd("Android component that controls external elements of file is called___________?","resource","intent","view","manifest",0);
        cou=s;
        max=d;
        tq=(max-cou)+1;
        t1=findViewById(R.id.t1);
        rg1=findViewById(R.id.rg1);
        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);
        r3=findViewById(R.id.r3);
        r4=findViewById(R.id.r4);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
            t1.setText(obj[cou].getQ());
            String[] temp =obj[cou].getOp();
            r1.setText(temp[0]);
            r2.setText(temp[1]);
            r3.setText(temp[2]);
            r4.setText(temp[3]);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (r1.isChecked() != true && r2.isChecked() != true && r3.isChecked() != true && r4.isChecked() != true) {
                        Toast.makeText(MainActivity.this, "You have to choose answer\nto submit", Toast.LENGTH_SHORT).show();
                    } else {
                        ta++;
                        int get_id = rg1.getCheckedRadioButtonId();
                        rr = findViewById(get_id);
                        String s1 = rr.getText().toString();
                        if (s1.equals(obj[cou].getAns())) {
                            cou++;
                            ca++;
                            if (cou > max) {
                                Intent i = new Intent(MainActivity.this, result.class);
                                startActivity(i);
                                finish();
                                return;
                            }
                            t1.setText(obj[cou].getQ());
                            String[] temp = obj[cou].getOp();
                            r1.setText(temp[0]);
                            r2.setText(temp[1]);
                            r3.setText(temp[2]);
                            r4.setText(temp[3]);
                            rg1.clearCheck();
                        } else {
                            rg1.clearCheck();
                            wa++;
                            cou++;
                            if (cou > max) {
                                Intent i = new Intent(MainActivity.this, result.class);
                                startActivity(i);
                                finish();
                                return;
                            }
                            t1.setText(obj[cou].getQ());
                            String[] temp = obj[cou].getOp();
                            r1.setText(temp[0]);
                            r2.setText(temp[1]);
                            r3.setText(temp[2]);
                            r4.setText(temp[3]);
                        }
                    }
                }
            });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r1.isChecked()==true || r2.isChecked()==true || r3.isChecked()==true || r4.isChecked()==true ){
                    Toast.makeText(MainActivity.this, "You have to submit now", Toast.LENGTH_SHORT).show();
                }
                else{
                    cou++;
                    ts++;
                    if (cou > max) {
                        Intent i=new Intent(MainActivity.this,result.class);
                        startActivity(i);
                        finish();
                        return;
                    }
                    t1.setText(obj[cou].getQ());
                    String[] temp =obj[cou].getOp();
                    r1.setText(temp[0]);
                    r2.setText(temp[1]);
                    r3.setText(temp[2]);
                    r4.setText(temp[3]);
                }
            }
        });
    }
}
class Vd {
    String qs;
    String op[];
    int corr;
    Vd(String a,String b, String c, String d,String e,int f){
        qs=a;
        op=new String[4];
        op[0]=b;
        op[1]=c;
        op[2]=d;
        op[3]=e;
        corr=f;
    }
    String getQ(){
        return qs;
    }
    String[] getOp(){
        return op;
    }
    String getAns(){
        return op[corr];
    }
}