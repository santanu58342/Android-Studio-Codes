package com.trendingdesign.shoppinguikit;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by trending design on 15/3/19.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        Thread thread = new Thread() {
            public void run() {
                try {
                    // Thread will sleep for 5 seconds
                    sleep(2*1000);
                    Intent intent = new Intent(SplashActivity.this, ShoppingActivity.class);
                    startActivity(intent);
                    finish();

                } catch (Exception e) {

                }
            }
        };
        thread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
