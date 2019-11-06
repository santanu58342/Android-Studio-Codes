package com.example.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        manager=getSupportFragmentManager();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f_code(new f1());
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f_code(new f2());
            }
        });
    }
    public void f_code(Fragment f){
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction tr=manager.beginTransaction();
        tr.replace(R.id.fm,f);
        tr.commit();
    }
}