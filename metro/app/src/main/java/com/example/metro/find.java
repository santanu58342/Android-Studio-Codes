package com.example.metro;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import static com.example.metro.MainActivity.*;
import static com.example.metro.list.*;
public class find extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5;
    ListView l1;
    ArrayList<String>route= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        l1=findViewById(R.id.l1);
        t1.setText("From:- "+stations[si]+"  To:- "+stations[di]);
        if(si>di){
            for (int j = si; j>= di;j--) {
                route.add(stations[j]);
            }
            t3.setText("Total distance:-"+(dis[si]-dis[di])+" kms");
            t4.setText("Fare:- Rs."+((dis[si]-dis[di])*1.5));
            t5.setText("Estimated time:- "+(((dis[si]-dis[di])*77)/60)+" minutes");
        }
        else {
            for (int j = si;j <= di;j++) {
                route.add(stations[j]);
            }
            t3.setText("Total distance:-"+(dis[di]-dis[si])+" kms");
            t4.setText("Fare:- Rs."+((dis[di]-dis[si])*1.5));
            t5.setText("Estimated time:- "+(((dis[si]-dis[di])*77)/60)+" minutes");
        }
        ArrayAdapter<String> obj;
        obj=new ArrayAdapter<>(find.this,R.layout.support_simple_spinner_dropdown_item,route);
        l1.setAdapter(obj);
    }
}