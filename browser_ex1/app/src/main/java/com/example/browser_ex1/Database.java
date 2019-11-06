package com.example.browser_ex1;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    String table;
    public Database(Context context) {
        super(context, "browser",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        table="create table history(history text,date date,)";
        db.execSQL(table);
        table="create table bookmark(bookmark text)";
        db.execSQL(table);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
    public void addh(String h){
        SQLiteDatabase call=this.getWritableDatabase();
        ContentValues collection=new ContentValues();
        collection.put("history",h);
        call.insert("history",null,collection);
        call.close();
    }
    public void addb(String h){
        SQLiteDatabase call=this.getWritableDatabase();
        ContentValues collection=new ContentValues();
        collection.put("bookmark",h);
        call.insert("bookmark",null,collection);
        call.close();
    }
}