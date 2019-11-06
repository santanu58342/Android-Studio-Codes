package jecrc.viewstub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    ViewStub viewStub;
    Button k1,k2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        k1=findViewById(R.id.button);
        k2=findViewById(R.id.button2);
        viewStub=(ViewStub)findViewById(R.id.viewStub);
        viewStub.inflate();
        k1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewStub.setVisibility(View.VISIBLE);
            }
        });

        k2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewStub.setVisibility(View.GONE);
            }
        });
    }
}
