package com.example.check_box_ex1_day4;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.check_box_ex1_day4.MainActivity.*;
public class Final extends AppCompatActivity{
    TextView t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        t6=findViewById(R.id.t6);
        t7=findViewById(R.id.t7);
        t8=findViewById(R.id.t8);
        t9=findViewById(R.id.t9);
        t10=findViewById(R.id.t10);
        t11=findViewById(R.id.t11);
        t12=findViewById(R.id.t12);
        t13=findViewById(R.id.t13);
        t14=findViewById(R.id.t14);
        t15=findViewById(R.id.t15);
        t16=findViewById(R.id.t16);
        t16.setText("Thank you for order\nYour order will be delivered shortly");
        if (c1.isChecked()==true) {
            t4.setText("" +c1.getText().toString());
            t5.setText("" + c);
            t6.setText("" + cc);
            i++;
        }
        if (c2.isChecked()==true) {
            t7.setText("" +c2.getText().toString());
            t8.setText("" + m);
            t9.setText("" + mc);
            i++;
        }
        if (c3.isChecked()==true) {
            t10.setText("" +c3.getText().toString());
            t11.setText("" + f);
            t12.setText("" + fc);
            i++;
        }
        t13.setText("Total item ="+i);
        t14.setText("Total quantity = "+(c+m+f));
        t15.setText("Total amount = "+tc);
        t16.setText("App will exit within 5 second");
        /*Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                t16.setText("App will exit within 5 second");
            }}, 0,5000);*/
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
                System.exit(0);
            }
        }, 5000);
    }
}