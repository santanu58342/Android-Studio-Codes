package com.example.santanu.day4_6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu p=new PopupMenu(MainActivity.this,b1);
                p.getMenuInflater().inflate(R.menu.popmenu,p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this,"You Clicked:- "+item.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                p.show();
            }
        });
    }
}