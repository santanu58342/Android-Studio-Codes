package com.example.santanu.day7_2;
import android.content.Intent;
import android.net.Uri;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private EditText e1;
    private EditText e2;
    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.mblTxt);
        e2=(EditText)findViewById(R.id.msgTxt);
        b1=(Button)findViewById(R.id.btnSend);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SmsManager smgr = SmsManager.getDefault();
                    smgr.sendTextMessage(e1.getText().toString(), null, e2.getText().toString(), null, null);
                    Toast.makeText(MainActivity.this, "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
