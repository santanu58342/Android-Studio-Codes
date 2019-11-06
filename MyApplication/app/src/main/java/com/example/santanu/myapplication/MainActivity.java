package com.example.santanu.myapplication;
         import android.app.Activity;
         import android.os.Bundle;
         import android.view.View;
         import android.widget.Button;

public class MainActivity extends Activity {

    Button EXIT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EXIT = (Button)findViewById(R.id.button);

        EXIT.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                finish();

            }
        });
    }
    public void exits(View view){System.exit(0);}
}