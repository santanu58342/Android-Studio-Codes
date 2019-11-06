package com.example.santanu.day8_4;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
    private Button btnSDown;
    private Button btnSUp;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSDown = (Button)findViewById(R.id.btnSlideDown);
        btnSUp = (Button)findViewById(R.id.btnSlideUp);
        img = (ImageView)findViewById(R.id.imgvw);
        btnSDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animSlideDown = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
                img.startAnimation(animSlideDown);
            }
        });
        btnSUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animSlideUp = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
                img.startAnimation(animSlideUp);
            }
        });
    }
}