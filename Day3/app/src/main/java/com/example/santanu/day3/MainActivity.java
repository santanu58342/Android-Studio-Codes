package com.example.santanu.day3;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.app.Activity;
import android.view.View;
//import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.Spinner;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {

    String []str={"Rose","Lotus","lily","Jesmine","MeriGold"};

    void showToast(CharSequence msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner s1 = (Spinner) findViewById(R.id.spinner1);

        //   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.colors, android.R.layout.simple_spinner_item);


        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, str);

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(aa);
    }
        //   s1.setOnItemSelectedListener new OnItemSelectedListener() {
        public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){
            showToast("Spinner1: position=" + str[position] + " id=" + id);
        }

        public void onNothingSelected (AdapterView < ? > parent){
          //  showToast("Spinner1: unselected");
        }



}