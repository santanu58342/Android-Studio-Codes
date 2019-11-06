package jecrc.maildemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail=findViewById(R.id.button);

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

String[]to={"bijendarartiya@gmail.com"};
                Intent m=new Intent(Intent.ACTION_SEND);


                m.setType("text/plain");


                m.putExtra(Intent.EXTRA_EMAIL  ,to);
                m.putExtra(Intent.EXTRA_SUBJECT,"Mail");
                m.putExtra(Intent.EXTRA_CC,"apoorvvarshney04@gmail.com");
                m.putExtra(Intent.EXTRA_TEXT,"hello good mng....");

                startActivity(Intent.createChooser(m,"sent"));
            }
        });
    }
}
