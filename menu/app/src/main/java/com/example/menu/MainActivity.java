package com.example.menu;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*MenuInflater inf=getMenuInflater();
        inf.inflate(R.menu.mymenu,menu);*/
        //getMenuInflater().inflate(R.menu.mymenu,menu);
        menu.add("1");
        menu.add("2");
        menu.add("3");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //int id=item.getItemId();
        String title= (String) item.getTitle();
        /*if(id==R.id.s1){
            fragment_menu(new f1());
            Toast.makeText(this,"hello1",Toast.LENGTH_LONG).show();
        }
        if(id==R.id.s2){
            Toast.makeText(this,"hello2",Toast.LENGTH_LONG).show();
        }
        if(id==R.id.m3){
            Toast.makeText(this,"hello3",Toast.LENGTH_LONG).show();
        }
        if(id==R.id.m4){
            Toast.makeText(this,"hello4",Toast.LENGTH_LONG).show();
        }*/
        if (title.equals("1")){
            Toast.makeText(this,"hello1",Toast.LENGTH_LONG).show();
        }
        if (title.equals("2")){
            Toast.makeText(this,"hello2",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
    public  void fragment_menu(Fragment fragment){
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction trg=manager.beginTransaction();
        trg.replace(R.id.f1,fragment);
        trg.commit();
    }
}