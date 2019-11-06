package com.example.santanu.day8_6;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
    private Button btnzIn;
    private Button btnzOut;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnzIn = (Button)findViewById(R.id.btnZoomIn);
        btnzOut = (Button)findViewById(R.id.btnZoomOut);
        img = (ImageView)findViewById(R.id.imgvw);
        btnzIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
                img.startAnimation(animZoomIn);
            }
        });
        btnzOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
                img.startAnimation(animZoomOut);
            }
        });
    }
}