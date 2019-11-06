package com.example.apoorv.activityjnu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b;
    EditText ed;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.button2);
        ed=findViewById(R.id.editText);
        sp=getSharedPreferences("mypref",MODE_PRIVATE);
        ed.setText(sp.getString("mydata",""));
        b.setOnClickListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        String data=ed.getText().toString();
        SharedPreferences.Editor s=sp.edit();
        s.putString("mydata",data);
        s.commit();
    }

    @Override
    public void onClick(View view) {
        String data=ed.getText().toString();
        Intent i=new Intent(this,Result.class);
        i.putExtra("str",data);
        startActivity(i);
    }
}
