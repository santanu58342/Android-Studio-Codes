package com.example.browser_ex1;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.browser_ex1.MainActivity.*;
public class tab_three extends AppCompatActivity {
    WebView w1;
    EditText e2;
    Button b11,b12,b13,b14;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_one);
        w1=findViewById(R.id.w1);
        b11=findViewById(R.id.b11);
        b12=findViewById(R.id.b12);
        b13=findViewById(R.id.b13);
        b14=findViewById(R.id.b14);
        e2=findViewById(R.id.e2);
        e2.setText(url1);
        e2.clearFocus();
        w1.loadUrl(url1);
        w1.getSettings().setJavaScriptEnabled(true);
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(tab_three.this,MainActivity.class);
                startActivity(i);
                h3=0;
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url1=w1.getUrl();
                w1.loadUrl(url1);
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        e2.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v,int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    e2.setText(e2.getText().toString().trim());
                    if(e2.getText().toString().contains(".") && !e2.getText().toString().contains(" ")){
                        url1 = url2+e2.getText().toString();
                    }
                    else{
                        url1 = url + e2.getText().toString();
                    }
                    w1.loadUrl(url1);
                    e2.setText(url1);
                    closeKeyboard();
                    e2.clearFocus();
                    return true;
                }
                return false;
            }
        });
        w1.setWebViewClient(new MyWebClient());
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf=getMenuInflater();
        inf.inflate(R.menu.menu,menu);
        return true;
    }
    public void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    public class MyWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            url1=url;
            w1.loadUrl(url1);
            return true;
        }
    }
}