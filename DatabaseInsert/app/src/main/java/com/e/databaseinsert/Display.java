package com.e.databaseinsert;

import android.content.ContentUris;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Display extends AppCompatActivity {
    DB db;
TextView dt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        dt=findViewById(R.id.textView);
        db=new DB(Display.this);
        StringBuilder b=new StringBuilder();
        Cursor record=db.get_record();
        try {
            if (record.getCount() == 0) {
                Toast.makeText(this, "Record not Found", Toast.LENGTH_SHORT).show();
                dt.setText("404 not found...");
            }
            else {
                while (record.moveToNext()) {
                    b.append(record.getInt(0) + "\n");
                    b.append(record.getString(1) + "\n");
                    b.append(record.getInt(2) + "\n");
                    b.append(record.getString(3) + "\n");
                }
                dt.setText(b.toString());
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Error"+e, Toast.LENGTH_SHORT).show();
        }
    }
}
