package jecrc.gridexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Display extends AppCompatActivity {

    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        im=findViewById(R.id.imageView2);

        im.setImageResource(MainActivity.id);
    }
}
