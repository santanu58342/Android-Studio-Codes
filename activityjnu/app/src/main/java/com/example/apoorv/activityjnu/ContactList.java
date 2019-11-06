package com.example.apoorv.activityjnu;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactList extends AppCompatActivity {

    ListView lv;
    Cursor c;
    ArrayList a=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        c=getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null,
                null,null, ContactsContract.Contacts.DISPLAY_NAME);
       lv=findViewById(R.id.lv);
        while(c.moveToNext())
        {
        int i=c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
        a.add(c.getString(i));
        }
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,a);
        lv.setAdapter(adapter);
    }
}
