package com.example.qlbanhang;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbBookManager";
    public static final int VERSION = 1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(KhachhangDAO.SQL_KHACH_HANG);

        db.execSQL(HoadonDAO.SQL_HOA_DON);
        //db.execSQL(HoadonchitietDAO.SQL_HOA_DON_CHI_TIET);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("Drop table if exists "+KhachhangDAO.TABLE_NAME);

        db.execSQL("Drop table if exists "+HoadonDAO.TABLE_NAME);
        //db.execSQL("Drop table if exists "+HoadonchitietDAO.TABLE_NAME);
        onCreate(db);
    }
}