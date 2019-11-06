package jecrc.loginwithvolley;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText u,p;
     Button k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        k=findViewById(R.id.button);
        u=findViewById(R.id.editText);
        p=findViewById(R.id.editText2);


      k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String c = getConnectivityStatusString(MainActivity.this);
                if(c.equals("1")){
                    user_login();

                }
               else{

                    Toast.makeText(MainActivity.this, "First Connect to internet", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void user_login(){

        StringRequest st=new StringRequest(Request.Method.POST, "http://maid4u.xyz/maid_project/login.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                server_Response(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, "Server Error"+error, Toast.LENGTH_LONG).show();
            }
        }){

          protected Map<String,String>getParams(){

              Map<String,String>mp=new HashMap<>();

              mp.put("user_name",u.getText().toString());
              mp.put("password",p.getText().toString());

              return  mp;

          }


        };

        RequestQueue q= Volley.newRequestQueue(MainActivity.this);

        q.add(st);
    }

    public void server_Response(String rs){

        try{
            JSONObject obj=new JSONObject(rs);
               String res =obj.getString("status");

                 if(res.equals("1")){

                     JSONArray array =obj.getJSONArray("data");

                                 JSONObject data= array.getJSONObject(0);

                                 String user=data.getString("user_name");


                     Intent i=new Intent(MainActivity.this,Profile.class);

                     i.putExtra("user",user);
                     startActivity(i);

                 }

                 else{

                     Toast.makeText(this, "invalid user & pas", Toast.LENGTH_LONG).show();
                 }


        }catch (Exception t){}
    }


    public static String getConnectivityStatusString(Context context) {
        String status = null;
        ConnectivityManager cm = (ConnectivityManager)           context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                status = "1";
                return status;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                status = "1";
                return status;
            }
        } else {
            status = "No internet is available";
            return status;
        }
        return status;
    }
}
