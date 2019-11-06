package com.example.list_view_day6;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lv1;
    static String data;
    String city[]={"kolkata","mumbai","chennai","jaipur","pochinki"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv1=findViewById(R.id.lv1);
        ArrayAdapter<String>obj;
        obj=new ArrayAdapter<>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,city);
        lv1.setAdapter(obj);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l){
                data=(String)parent.getItemAtPosition(i);
                Intent i1=new Intent(MainActivity.this,display.class);
                startActivity(i1);
            }
        });
    }
}
