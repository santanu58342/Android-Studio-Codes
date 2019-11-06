package com.android.animatedgif.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.animatedgif.R;
import com.android.animatedgif.Utils.GifImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GifImageView gifImageView = (GifImageView) findViewById(R.id.GifImageView);
        gifImageView.setGifImageResource(R.drawable.smartphone_drib);
    }
}
