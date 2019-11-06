package jecrc.animationexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

     Animation animation;
     Button n1,n2,n3;
     ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1=findViewById(R.id.button);
        n2=findViewById(R.id.button2);
        n3=findViewById(R.id.button3);
        img=findViewById(R.id.imageView);

        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.move);

                img.startAnimation(animation);
            }
        });

        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoom_out);

                img.startAnimation(animation);
            }
        });
        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
//
//                img.startAnimation(animation);

                startActivity(new Intent(MainActivity.this,Next.class));
               // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
overridePendingTransition(R.anim.slide_up,R.anim.slide_down);
            }
        });
    }
}
