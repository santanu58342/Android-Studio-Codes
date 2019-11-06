package com.example.obj_try;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class Database extends SQLiteOpenHelper {
    public Database(Context context) {
        super(context, "user",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String table="create table user(username text,password text)";
        db.execSQL(table);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
    public void addu(String username,String password){
        SQLiteDatabase call=this.getWritableDatabase();
        ContentValues collection=new ContentValues();
        collection.put("username",username);
        collection.put("password",password);
        call.insert("user",null,collection);
        call.close();
    }
    public boolean getu(String username, String password){
        SQLiteDatabase call=this.getWritableDatabase();
        String all="select username,password from user where username=='"+username+"' and "+"password=='"+password+"'";
        Cursor cursor=call.rawQuery(all,null);
        int count = cursor.getCount();
        cursor.close();
        close();
        if(count > 0){
            return true;
        }
        else {
            return false;
        }
    }
}