package jecrc.d_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView lt;
 ArrayList<String>nm,mb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lt=(ListView)findViewById(R.id.mylist);
        nm=new ArrayList<>();
        mb=new ArrayList<>();
        nm.add("Aman");
        mb.add("90909090");
        nm.add("Aman");
        mb.add("90909090");
        nm.add("Aman");
        mb.add("90909090");
        nm.add("Aman");
        mb.add("90909090");
        nm.add("Aman");
        mb.add("90909090");
        nm.add("Aman");
        mb.add("90909090");
        nm.add("Aman");
        mb.add("90909090");
        nm.add("Aman");
        mb.add("90909090");
        nm.add("Aman");
        mb.add("90909090");
        nm.add("Aman");
        mb.add("90909090");

       MyDesign mydata =new MyDesign(MainActivity.this,nm,mb);

       lt.setAdapter(mydata);
    }
}
