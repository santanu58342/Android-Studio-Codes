package com.example.radiobtn_day5;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rg;
    RadioGroup rg1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg1=findViewById(R.id.rg1);
        b1=findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int get_id=rg1.getCheckedRadioButtonId();
                rg=findViewById(get_id);
                Toast.makeText(MainActivity.this,""+rg.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}