package com.example.metro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import static com.example.metro.MainActivity.*;

public class list extends AppCompatActivity {
    ListView l1;
    static String s;
    static int i2;
    static String stations[]={"Dum Dum","Sutanuti","Esplanade","Kalighat","Rabindra Sarobar"};
    static int dis[]={0,3,7,13,17};
    static String hospital[]={"Hospital 1","Hospital 2","Hospital 3","Hospital 4","Hospital 5"};
    static String hinfo[]={"private 5 *","gvmt. 4*","private 3*","gvmnt 2*","private 2*"};
    static String parking[]={"Parking 1","Parking 2","Parking 3","Parking 4","Parking 5"};
    static String pkinfo[]={"2w:- 30, 4w:- 40","2w:- 10, 4w:- 20","2w:- 90, 4w:- 70","2w:- 40, 4w:- 30","2w:- 20, 4w:- 60",};
    static String police[]={"Police Station 1","Police Station 2","Police Station 3","Police Station 4","Police Station 5"};
    static String psinfo[]={"lane A 600m","lane B 500m","lane C 200m","lane D 800m","lane E 1.2km",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        l1=findViewById(R.id.l1);
        ArrayAdapter<String> obj;
        obj=new ArrayAdapter<>(list.this,R.layout.support_simple_spinner_dropdown_item,stations);
        l1.setAdapter(obj);
        if(j==0) {
            l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                    //s=(String)parent.getItemAtPosition(i);
                    i2 = i;
                    Intent i1 = new Intent(list.this, MainActivity.class);
                    startActivity(i1);
                    f++;
                }
            });
        }
        if(j==1) {
            l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                    i2 = i;
                    Intent i1 = new Intent(list.this,display.class);
                    startActivity(i1);
                }
            });
        }
    }
}
