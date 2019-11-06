package com.example.santanu.day4_4;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
public class MainActivity extends AppCompatActivity {
    WebView w1,w2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        w1=(WebView)findViewById(R.id.WebView1);
        w2=(WebView)findViewById(R.id.WebView2);
        /*String str="<html><body><h1>Hello,Android Code!</h1></body></html>";
        w1.loadData(str, "text/html", "UTF-8");*/
       // w1.loadUrl("assets/a1.html");
        //w1.loadUrl("file:///assets/a1.html");
        w1.getSettings().setLoadsImagesAutomatically(true);
        w1.getSettings().setJavaScriptEnabled(true);
        w1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        w1.loadUrl("https://www.google.com");
        w2.getSettings().setLoadsImagesAutomatically(true);
        w2.getSettings().setJavaScriptEnabled(true);
        w2.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        w2.loadUrl("https://www.bing.com");
    }
}