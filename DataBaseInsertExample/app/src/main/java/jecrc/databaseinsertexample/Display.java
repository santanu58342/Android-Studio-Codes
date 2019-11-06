package jecrc.databaseinsertexample;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Display extends AppCompatActivity {

    Dvs_Db db;
    TextView tt;
    StringBuilder b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        tt = (TextView) findViewById(R.id.textView);
        db = new Dvs_Db(Display.this);

        b=new StringBuilder();
try {
    Cursor record = db.get_record();

    if (record.getCount() == 0) {
        Toast.makeText(this, "Record not found", Toast.LENGTH_LONG).show();
        tt.setText("Record not found....");
    }


    while (record.moveToNext()) {

        b.append(record.getInt(0) + "\n");
        b.append(record.getInt(1) + "\n");
        b.append(record.getString(2) + "\n");
        b.append(record.getInt(3) + "\n");
        b.append(record.getString(4) + "\n");

    }

    tt.setText(b.toString());

}catch (Exception ty)
{
    tt.setText(""+ty);
}
    }
}
