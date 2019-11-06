package com.example.gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView img;
Gallery gallery;
ArrayList<Integer> images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery=findViewById(R.id.simple);
        img=findViewById(R.id.imageView);
        images=new ArrayList<>();
        images.add(R.drawable.img1);
        images.add(R.drawable.img2);
        images.add(R.drawable.img3);
        images.add(R.drawable.img4);
        images.add(R.drawable.img5);
        images.add(R.drawable.img6);

        ImagesData data=new ImagesData(MainActivity.this,images);
        gallery.setAdapter(data);

        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                img.setImageResource(images.get(position));
            }
        });
    }
}
