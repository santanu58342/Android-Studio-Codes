package jecrc.animationexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    Animation m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView im=findViewById(R.id.imageView2);

        m= AnimationUtils.loadAnimation(Splash.this,R.anim.zoom_in);

        im.startAnimation(m);

        Thread t=new Thread(){

          public void run(){
              try{

                  sleep(4000);
              }catch (Exception t){}

              finally {
                  Intent i=new Intent(Splash.this,MainActivity.class);
                  startActivity(i);
                  finish();
              }
          }
        };
        t.start();
    }
}
