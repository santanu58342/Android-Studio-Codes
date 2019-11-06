package jecrc.databaseinsertexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     Dvs_Db mydb;
    EditText rl,nm,mb,st;
    Button add,fetch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl=(EditText)findViewById(R.id.editText);
        nm=(EditText)findViewById(R.id.editText2);
        mb=(EditText)findViewById(R.id.editText3);
        st=(EditText)findViewById(R.id.editText4);
        add=(Button)findViewById(R.id.button);
        fetch=(Button)findViewById(R.id.button2);

        mydb=new Dvs_Db(MainActivity.this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String roll=rl.getText().toString();
                String name=nm.getText().toString();
                String mobile=mb.getText().toString();
                String stream=st.getText().toString();


                try {
                    mydb.add_record(Integer.parseInt(roll), name, Integer.parseInt(mobile), stream);
                    cln();
                    Toast.makeText(MainActivity.this, "Insert Record.", Toast.LENGTH_LONG).show();
                }
                catch (Exception t)
                {
                    Toast.makeText(MainActivity.this, "Error"+t, Toast.LENGTH_LONG).show();
                }
                }
        });

        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,Display.class);

                startActivity(i);
            }
        });
    }

    public void cln(){

        rl.setText(null);
        nm.setText(null);
        mb.setText(null);
        st.setText(null);
        rl.requestFocus();
    }
}
