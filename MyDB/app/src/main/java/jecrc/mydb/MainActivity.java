package jecrc.mydb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseClass obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        obj=new DatabaseClass(MainActivity.this);

        Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
    }
}
