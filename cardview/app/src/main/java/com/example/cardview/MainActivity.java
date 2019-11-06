package com.example.cardview;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CardView c1;
    ListView l1;
    ArrayList<String>nm,version;
    ArrayList<Integer>img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c1=findViewById(R.id.c1);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "hello world", Toast.LENGTH_SHORT).show();
            }
        });
        l1=findViewById(R.id.l1);
        nm=new ArrayList<>();
        version=new ArrayList<>();
        img=new ArrayList<>();
        nm.add("santanu1");
        version.add("marshmallow1");
        img.add(R.drawable.abc);
        nm.add("santanu2");
        version.add("marshmallow2");
        img.add(R.drawable.abc);
        nm.add("santanu3");
        version.add("marshmallow3");
        img.add(R.drawable.abc);
        nm.add("santanu4");
        version.add("marshmallow4");
        img.add(R.drawable.abc);
        Mycard obj=new Mycard(MainActivity.this,nm,version,img);
        l1.setAdapter(obj);
    }
}