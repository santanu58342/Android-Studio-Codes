package jecrc.d_ex2_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static String item;
     ListView lt;
     ArrayList<String>nm,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lt=(ListView)findViewById(R.id.listt);
        nm=new ArrayList<>();
        age=new ArrayList<>();

        nm.add("Pawan");
        age.add("27");
        nm.add("Pawan");
        age.add("27");
        nm.add("Pawan");
        age.add("27");
        nm.add("Pawan");
        age.add("27");
        nm.add("Pawan");
        age.add("27");
        nm.add("Pawan");
        age.add("27");
        MyDesing data_format=new MyDesing(MainActivity.this,nm,age);
        lt.setAdapter(data_format);

        lt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               item =(String)adapterView.getItemAtPosition(i);

                Toast.makeText(MainActivity.this, ""+item, Toast.LENGTH_LONG).show();

                Intent ik=new Intent(MainActivity.this,Display.class);
                startActivity(ik);
            }
        });

    }
}
