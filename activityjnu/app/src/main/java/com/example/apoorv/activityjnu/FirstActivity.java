package com.example.apoorv.activityjnu;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Apoorv on 24-03-2018.
 */

public class FirstActivity extends Activity implements View.OnClickListener {

    TextView tv;
    Button b;
    int i=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstactivity);
        tv=findViewById(R.id.textView);
        b=findViewById(R.id.button);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(i==0)
        {
            tv.setVisibility(View.VISIBLE);
            b.setText("HIDE MESSAGE");
            i=1;
        }
        else
        {
            i=0;
            tv.setVisibility(View.INVISIBLE);
            b.setText("SHOW MESSAGE");
        }
    }
}
