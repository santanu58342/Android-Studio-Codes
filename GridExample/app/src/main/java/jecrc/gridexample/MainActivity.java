package jecrc.gridexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
static  int id;
    GridView gridView;
    ArrayList<Integer>images;
    ArrayList<String>name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=(GridView)findViewById(R.id.gd);

          images=new ArrayList<>();
          name=new ArrayList<>();
          images.add(R.drawable.kitkat);
          name.add("Vaibhav");
        images.add(R.drawable.kitkat);
        name.add("Vaibhav");
        images.add(R.drawable.kitkat);
        name.add("Vaibhav");
        images.add(R.drawable.kitkat);
        name.add("Vaibhav");
        images.add(R.drawable.kitkat);
        name.add("Vaibhav");
        images.add(R.drawable.kitkat);
        name.add("Vaibhav");
        images.add(R.drawable.kitkat);
        name.add("Vaibhav");
        images.add(R.drawable.kitkat);
        name.add("Vaibhav");
        images.add(R.drawable.kitkat);
        name.add("Vaibhav");
        images.add(R.drawable.kitkat);
        name.add("Vaibhav");
        images.add(R.drawable.kitkat);
        name.add("Vaibhav");
        images.add(R.drawable.kitkat);
        name.add("Vaibhav");


        GetImageLoader obj=new GetImageLoader(MainActivity.this,images,name);

        gridView.setAdapter(obj);


   gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
       @Override
       public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


           id=images.get(i);
           Intent obj=new Intent(MainActivity.this,Display.class);

           startActivity(obj);
       }
   });

    }
}
