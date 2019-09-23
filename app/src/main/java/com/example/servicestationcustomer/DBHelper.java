package com.example.servicestationcustomer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="serviceSelect.db";
    public static final String TABLE_NAME="serviceSelect";
    public static final String COL_1="id";
    public static final String COL_2="customerName";
    public static final String COL_3="vehicleNumber";
    public static final String COL_4="mobile";
    public static final String COL_5="service";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( id INTEGER PRIMARY KEY AUTOINCREMENT , customerName TEXT , vehicleNumber TEXT , mobile INTEGER , service TEXT )" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String customerName , String vehicleNumber , String mobile, String service  ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,customerName);
        contentValues.put(COL_3,vehicleNumber);
        contentValues.put(COL_4,mobile);
        contentValues.put(COL_5,service);
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
    public boolean updateData(String id , String customerName , String vehicleNumber,String mobile , String service){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,customerName);
        contentValues.put(COL_3,vehicleNumber);
        contentValues.put(COL_4,mobile);
        contentValues.put(COL_5,service);
        db.update(TABLE_NAME,contentValues,"id = ?",new String[] { id });
        return true;

    }
    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"id = ?",new String[]{id});
    }
}
