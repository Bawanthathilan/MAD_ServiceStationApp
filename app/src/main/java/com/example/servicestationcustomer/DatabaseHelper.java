package com.example.servicestationcustomer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="addservice.db";
    public static final String TABLE_NAME="service";
    public static final String COL_1="id";
    public static final String COL_2="servicename";
    public static final String COL_3="servicetype";
    public static final String COL_4="amountofemp";
    public static final String COL_5="needprice";

    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( id INTEGER PRIMARY KEY AUTOINCREMENT , servicename TEXT , servicetype TEXT , amountofemp INTEGER , needprice INTEGER )" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String servicename , String servicetype , String amountofemp,String needprice  ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,servicename);
        contentValues.put(COL_3,servicetype);
        contentValues.put(COL_4,amountofemp);
        contentValues.put(COL_5,needprice);
        long result = db.insert(TABLE_NAME,null , contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public boolean updateData(String id , String serviceName , String serviceType,String aoe , String needPrice){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,serviceName);
        contentValues.put(COL_3,serviceType);
        contentValues.put(COL_4,aoe);
        contentValues.put(COL_5,needPrice);
        db.update(TABLE_NAME,contentValues,"id = ?",new String[] { id });
        return true;

    }
    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"id = ?",new String[]{id});
    }
}
