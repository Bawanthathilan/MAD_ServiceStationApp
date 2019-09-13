package com.example.servicestationcustomer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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
}
