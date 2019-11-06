package com.example.santanu.day4_3;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.DialogInterface;
public class MainActivity extends AppCompatActivity {
    String s[]={"Santanu","Sushant","Vicky","Ponting"};
    AutoCompleteTextView a1;
    Button b1;
    TextView t1;
    EditText e1;
    double f,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show();
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,s);
        a1=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        a1.setThreshold(1);
        a1.setAdapter(adapter);
        a1.setTextColor(Color.RED);
    }
    public void onBackPressed(){
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setMessage("Do you want to quit this application?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog a=b.create();
        a.setTitle("Alert");
        a.show();
        return;
    }
    public void show(){
        t1=(TextView)findViewById(R.id.textView);
        e1=(EditText)findViewById(R.id.editText);
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=e1.getText().toString();
                c=Double.parseDouble(n);
                f=(9*c+160)/5;
                t1.setText(Double.toString(f));
                Toast.makeText(getApplicationContext(),"Converted value :-  "+Double.toString(f),Toast.LENGTH_LONG).show();
            }
        });
    }
}