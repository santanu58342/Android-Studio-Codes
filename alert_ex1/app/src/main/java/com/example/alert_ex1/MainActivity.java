package com.example.alert_ex1;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*AlertDialog.Builder objj=new AlertDialog.Builder(MainActivity.this);
                objj.setTitle("hhh");
                objj.setMessage("djhadhada");
                objj.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                objj.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                objj.show();*/
                c_alert();
            }
        });
    }
    public void c_alert(){
        LayoutInflater inf=getLayoutInflater();
        View v=inf.inflate(R.layout.custom,null);
        e1=v.findViewById(R.id.e1);
        e2=v.findViewById(R.id.e2);
        b2=v.findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().matches("admin") && e2.getText().toString().matches("admin")){
                    Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
        AlertDialog.Builder b=new AlertDialog.Builder(MainActivity.this);
        b.setTitle("");
        b.setView(v);
        b.setCancelable(false);
        b.show();
    }
}