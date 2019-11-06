package com.example.santanu.day8_1;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private Button b1;
    private ImageView i1;
    private static final int i_c_code=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        i1=(ImageView)findViewById(R.id.i1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,i_c_code);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == i_c_code) {
            if(resultCode==RESULT_OK){
                Bitmap b=(Bitmap) data.getExtras().get("data");
                i1.setImageBitmap(b);
            }
            else if(resultCode==RESULT_CANCELED){
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            }
        }
    }
}
