package jecrc.loginwithvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView t=findViewById(R.id.textView);
        t.setText(getIntent().getStringExtra("user"));
    }
}
