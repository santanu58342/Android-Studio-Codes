package jecrc.imageloadexample;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    Button k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        k=findViewById(R.id.button);
        img=findViewById(R.id.imageView);
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Picasso.with(MainActivity.this).load("http://dvswebinfotech.com/webservice/uploadimage/marsh.png").into(img);


                                   // optional
                getImage();                                  // optional



            }
        });
    }


    public void getImage(){

        final ProgressDialog d=new ProgressDialog(MainActivity.this);
        d.setMessage("Loading...");
        d.setCancelable(false);
        d.show();
        StringRequest stringRequest=new StringRequest(Request.Method.GET, "http://dvswebinfotech.com/webservice/getCompleteData.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                d.dismiss();
                getJsonRes(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
         d.dismiss();
            }
        });

        RequestQueue q= Volley.newRequestQueue(MainActivity.this);
        q.add(stringRequest);

    }

    public void getJsonRes(String Res){
        try{
            JSONObject obj=new JSONObject(Res);

            JSONArray arr=obj.getJSONArray("data");

                      JSONObject object=arr.getJSONObject(2);

            Picasso.with(MainActivity.this)
                    .load(object.getString("imageField"))
                    .placeholder(R.drawable.ic_launcher_background)   // optional
                    // optional
                    .resize(100, 100).into(img);

        }catch (Exception t){}

    }
}
