package com.example.santanu.day7_3;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button b1;
    private EditText e1;
    private EditText e2;
    private EditText e3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.txtTo);
        e2=(EditText)findViewById(R.id.txtSub);
        e3=(EditText)findViewById(R.id.txtMsg);
        b1=(Button)findViewById(R.id.btnSend);
        b1.setOnClickListener(this);
        /*b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_EMAIL, new String[]{e1.getText().toString()});
                it.putExtra(Intent.EXTRA_SUBJECT,e2.getText().toString());
                it.putExtra(Intent.EXTRA_TEXT,e3.getText());
                it.setType("message/rfc822");
                startActivity(Intent.createChooser(it,"Choose Mail App"));
            }
        });*/
    }
    private void sendEmail(){
        String email=e1.getText().toString().trim();
        String subject=e2.getText().toString().trim();
        String message=e3.getText().toString().trim();
        SentMail sm = new SentMail(this, email, subject, message);
        sm.execute();
    }
    public void onClick(View v){
        sendEmail();
    }
}