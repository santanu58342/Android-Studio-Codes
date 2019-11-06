package com.example.context_menu;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    ProgressDialog d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        registerForContextMenu(b1);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pbar();
                Thread t1=new Thread(){
                    public void run(){
                        try{
                            sleep(5000);
                            d.dismiss();
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                t1.start();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add("hello");
        menu.add("world");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String s= (String) item.getTitle();
        if(s.equals("hello")){
            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
        }
        if(s.equals("world")){
            Toast.makeText(this, "world", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
    public void pbar(){
        d=new ProgressDialog(MainActivity.this);
        d.setMessage("Loading...");
        d.setCancelable(false);
        d.show();
    }
}