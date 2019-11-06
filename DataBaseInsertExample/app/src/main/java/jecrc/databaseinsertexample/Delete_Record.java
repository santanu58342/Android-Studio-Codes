package jecrc.databaseinsertexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete_Record extends AppCompatActivity {

    EditText rl_id;
     Button dl,nxt;
     Dvs_Db obj;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete__record);
        rl_id=(EditText)findViewById(R.id.editText5);
        dl=(Button)findViewById(R.id.button6);
        nxt=(Button)findViewById(R.id.button8);

        obj=new Dvs_Db(Delete_Record.this);
        dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String r=rl_id.getText().toString();

                try{

                    obj.dell_record_byRoll(Integer.parseInt(r));

                    rl_id.setText(null);
                    Toast.makeText(Delete_Record.this, "Delete Record", Toast.LENGTH_LONG).show();
                }catch (Exception t){

                    Toast.makeText(Delete_Record.this, "Try again..", Toast.LENGTH_LONG).show();
                }

            }
        });

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Delete_Record.this,Login.class);

                startActivity(i);
            }
        });
    }
}
