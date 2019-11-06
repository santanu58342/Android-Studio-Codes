package com.example.santanu.day7_1;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText e1;
    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.mblTxt);
        b1=(Button)findViewById(R.id.btnCall);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callPhoneNumber();
            }
        });
    }
    public void onRequstPermissionResult(int requestCode,String[] permissions,int[] grantResults){
        if(requestCode==101){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                callPhoneNumber();
            }
        }
    }
    public void callPhoneNumber() {
        try {
            if (Build.VERSION.SDK_INT > 22) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
                    return;
                }
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + e1.getText().toString()));
                startActivity(callIntent);
            }
            else {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + e1.getText().toString()));
                startActivity(callIntent);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
