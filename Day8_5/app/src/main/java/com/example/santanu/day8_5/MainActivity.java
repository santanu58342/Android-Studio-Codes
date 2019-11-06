package com.example.santanu.day8_5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button btnfIn;
    private Button btnfOut;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnfIn = (Button)findViewById(R.id.btnFadeIn);
        btnfOut = (Button)findViewById(R.id.btnFadeOut);
        img = (ImageView)findViewById(R.id.imgvw);
        btnfIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                img.startAnimation(animFadeIn);
            }
        });
        btnfOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                img.startAnimation(animFadeOut);
            }
        });
    }
}