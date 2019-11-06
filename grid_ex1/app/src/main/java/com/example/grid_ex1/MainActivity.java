package com.example.grid_ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView g1;
    String[] alpha={"a","b","c","d","e","f","g","h","i","j","k","m","n","o","p","q"};
    Integer[] img={R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc};
    ArrayList<Integer> imga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g1=findViewById(R.id.g1);
        //ArrayAdapter<Integer> obj=new ArrayAdapter<>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,img);
        //g1.setAdapter(obj);

        g1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}