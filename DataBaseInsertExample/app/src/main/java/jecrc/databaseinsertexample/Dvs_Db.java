package jecrc.databaseinsertexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dvs_Db extends SQLiteOpenHelper {
    public Dvs_Db(Context context) {
        super(context, "student1",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String table="create table record(id integer primary key autoincrement ,roll integer,name text,mobile integer,stream text)";

        sqLiteDatabase.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void add_record(int rl,String nm,int mob,String strm){

        SQLiteDatabase call=this.getWritableDatabase();

        ContentValues collection=new ContentValues();

         collection.put("roll",rl);
        collection.put("name",nm);
        collection.put("mobile",mob);
        collection.put("stream",strm);

        call.insert("record",null,collection);

        call.close();

    }

    public Cursor get_record(){
        SQLiteDatabase call=this.getWritableDatabase();

        String all="select* from record";

        Cursor cursor=call.rawQuery(all,null);
        return cursor;
    }
    public void update_record(int rl,String nm,int mob,String strm){

        SQLiteDatabase call=this.getWritableDatabase();

        String update="update record set name='"+nm+"',mobile="+mob+",stream='"+strm+"' where roll="+rl+"";

        call.execSQL(update);


    }

    public void dell_record_all(){
        SQLiteDatabase call=this.getWritableDatabase();

        call.execSQL("delete from record");

    }


    public void dell_record_byRoll(int r){
        SQLiteDatabase call=this.getWritableDatabase();

        call.execSQL("delete from record where roll="+r+"");

    }

public Cursor login_user(int user){
    SQLiteDatabase call=this.getWritableDatabase();

    String lgg="select* from record where roll="+user+"";

     Cursor c=call.rawQuery(lgg,null);

     return  c;

}

}
