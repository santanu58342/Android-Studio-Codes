package com.example.santanu.day5_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import java.net.URL;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
public class MainActivity extends AppCompatActivity {
    EditText e1;
    Button b1;
    WebView w1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button1);
        e1=(EditText)findViewById(R.id.editText1);
        w1=(WebView)findViewById(R.id.webview1);
        Intent intent=getIntent();
        Uri data=intent.getData();
        URL url=null;
        try{
            url=new URL(data.getScheme(),data.getHost(),data.getPath());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        w1.loadUrl(url.toString());
        /*b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String u=e1.getText().toString();
               // Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse(u));
                Intent i=new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(u));
                startActivity(i);
            }
        });*/
    }
}
