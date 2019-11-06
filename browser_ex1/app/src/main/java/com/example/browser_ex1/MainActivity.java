package com.example.browser_ex1;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText e1;
    Button b1;
    static int f=1,h1=0,h2=0,h3=0,t=1,r=0,max=1;
    static String url="https://www.google.com/search?q=",url2="https://",url1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.e1);
        b1=findViewById(R.id.b13);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(f==1) {
                    if (!e1.getText().toString().matches("")) {
                        e1.setText(e1.getText().toString().trim());
                        if(e1.getText().toString().contains(".") && !e1.getText().toString().contains(" ")){
                            url1 = url2+e1.getText().toString();
                        }
                        else{
                            url1 = url + e1.getText().toString();
                        }
                        Intent i = new Intent(MainActivity.this, tab_one.class);
                        startActivity(i);
                        closeKeyboard();
                        e1.setText(null);
                        h1=1;
                    }
                }
                if(f==2) {
                    if (!e1.getText().toString().matches("")) {
                        e1.setText(e1.getText().toString().trim());
                        if(e1.getText().toString().contains(".") && !e1.getText().toString().contains(" ")){
                            url1 = url2+e1.getText().toString();
                        }
                        else{
                            url1 = url + e1.getText().toString();
                        }
                        Intent i = new Intent(MainActivity.this, tabe_two.class);
                        startActivity(i);
                        closeKeyboard();
                        e1.setText(null);
                        h2=1;
                    }
                }
                if(f==3) {
                    if (!e1.getText().toString().matches("")) {
                        e1.setText(e1.getText().toString().trim());
                        if(e1.getText().toString().contains(".") && !e1.getText().toString().contains(" ")){
                            url1 = url2+e1.getText().toString();
                        }
                        else{
                            url1 = url + e1.getText().toString();
                        }
                        Intent i = new Intent(MainActivity.this, tab_three.class);
                        startActivity(i);
                        closeKeyboard();
                        e1.setText(null);
                        h3=1;
                    }
                }
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf=getMenuInflater();
        inf.inflate(R.menu.menu,menu);
        MenuItem menu2 = menu.findItem(R.id.m2);
        SubMenu subMenu2 = menu2.getSubMenu();
        if(t==2) {
            subMenu2.clear();
            subMenu2.add("1");
            subMenu2.add("2");
        }
        if (t==3) {
            subMenu2.clear();
            subMenu2.add("1");
            subMenu2.add("2");
            subMenu2.add("3");
        }
        if(t==4){
            subMenu2.add("3");
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        String title= (String) item.getTitle();
        if(id==R.id.m1){
            if(f==3){
                Toast.makeText(this, "maximum 3 tabs", Toast.LENGTH_SHORT).show();
            }
            else {
                f++;max++;
                t++;
                invalidateOptionsMenu();
                Toast.makeText(this, "tab created successfully", Toast.LENGTH_SHORT).show();
            }
        }
        if(id==R.id.m3){
            Intent i=new Intent(getApplicationContext(),bookmarks.class);
            startActivity(i);
        }
        if(id==R.id.m4){
            Intent i=new Intent(getApplicationContext(),history.class);
            startActivity(i);
        }
        if(id==R.id.m5){
            finish();
        }
        if (title.equals("1")){
            if(f==1){
                Toast.makeText(this, "this is current tab", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent i = new Intent(getApplicationContext(), tab_one.class);
                startActivity(i);
                f = 1;
            }
        }
        if (title.equals("2")){
            if(f==2){
                Toast.makeText(this, "this is current tab", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent i = new Intent(MainActivity.this, tabe_two.class);
                startActivity(i);
                f = 2;
            }
        }
        if (title.equals("3")){
            if(f==2){
                Toast.makeText(this, "this is current tab", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent i = new Intent(MainActivity.this, tab_three.class);
                startActivity(i);
                f = 3;
            }
        }
        return super.onOptionsItemSelected(item);
    }
    public void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}