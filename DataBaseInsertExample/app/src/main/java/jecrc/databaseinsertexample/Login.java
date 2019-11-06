package jecrc.databaseinsertexample;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Currency;
public class Login extends AppCompatActivity {
    Dvs_Db obj;
     EditText u,p;
      Button lg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lg=(Button)findViewById(R.id.button7);
        u=findViewById(R.id.userr);
        p=findViewById(R.id.passwee);
        obj=new Dvs_Db(Login.this);

        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=u.getText().toString();
                String pass=p.getText().toString();

                try{

                   Cursor c =obj.login_user(Integer.parseInt(user));

                   if(c.getCount()==0){

                       Toast.makeText(Login.this, "No data found", Toast.LENGTH_LONG).show();
                   }

                   else{

                     c.moveToFirst();

                     int password=c.getInt(3);

                     String pas=String.valueOf(password);


                     if(pas.equals(pass)){
                         Intent i=new Intent(Login.this,MainActivity.class);

                         startActivity(i);

                     }
                     else {
                         Toast.makeText(Login.this, "Invalid u&&p", Toast.LENGTH_LONG).show();
                     }
                   }
               }
               catch (Exception t){}
            }
        });
    }
}
