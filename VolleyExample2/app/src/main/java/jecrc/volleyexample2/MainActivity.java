package jecrc.volleyexample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
EditText nm,strm,eml,mb;
Button k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        k=findViewById(R.id.button);
        nm=findViewById(R.id.editText);
        strm=findViewById(R.id.editText2);
        eml=findViewById(R.id.editText3);
        mb=findViewById(R.id.editText4);

        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userRegister();
            }
        });
    }


    public void userRegister(){

        StringRequest st=new StringRequest(Request.Method.POST, "http://maid4u.xyz/dvs_trg2019/insertData_without_image.php\n" +
                "\n", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                chekResponse(response);
                cln();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
cln();
            }
        }){

          protected Map<String,String>getParams(){

              Map<String,String>mp=new HashMap<>();

              mp.put("name",nm.getText().toString());
              mp.put("stream",strm.getText().toString());
              mp.put("mobile",eml.getText().toString());
              mp.put("mail",mb.getText().toString());

              return  mp;
          }

        };

        RequestQueue q= Volley.newRequestQueue(MainActivity.this);

        q.add(st);
    }

    public void chekResponse(String res){
        try{

            JSONObject obj=new JSONObject(res);
                     String status=obj.getString("status");

                     if(status.equals("1")){
                         Toast.makeText(this, "Record inserted..", Toast.LENGTH_LONG).show();

                     }

                     else{
                         Toast.makeText(this, "try again...", Toast.LENGTH_LONG).show();

                     }
        }
        catch (Exception t){}
    }

    public void cln(){

        nm.setText(null);
        nm.requestFocus();
        strm.setText(null);
        eml.setText(null);
        mb.setText(null);
    }
}
