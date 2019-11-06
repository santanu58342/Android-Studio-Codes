package jecrc.volleyexample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
String url="http://maid4u.xyz/dvs_trg2019/getCompleteData.php";
    Button k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        k=findViewById(R.id.button);
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getdata();
            }
        });
    }

    public  void getdata(){
        final ProgressDialog d=new ProgressDialog(MainActivity.this);
        d.setMessage("Loading...");
        d.setCancelable(false);
        d.show();
        StringRequest st;
        st=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               d.dismiss();
                getResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                d.dismiss();
                Toast.makeText(MainActivity.this, "Server Errro"+error, Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue q= Volley.newRequestQueue(MainActivity.this);

        q.add(st);

    }

    public void getResponse(String res){
StringBuilder b=new StringBuilder();
        try{

            JSONObject obj=new JSONObject(res);
               JSONArray arr =obj.getJSONArray("data");

                          for(int i=0;i<arr.length();i++) {
                              JSONObject pos = arr.getJSONObject(i);

                            //  b.append(pos.getInt("id") + "\n");
                              b.append(pos.getString("name") + "\n");
                            //  b.append(pos.getString("stream") + "\n");
                             // b.append(pos.getString("mobile") + "\n");
                              b.append(pos.getString("mail") + "\n");
                              b.append("=======================" + "\n");
                          }
                           String serverResponse=obj.getString("status");

                           if(serverResponse.equals("1")){


                               Intent i=new Intent(MainActivity.this,Display.class);
                               i.putExtra("k",b.toString());

                               startActivity(i);
                           }
        }catch (Exception t){}
    }
}
