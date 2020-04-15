package com.example.qlbanhang;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class KhachhangDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String TABLE_NAME = "Khachhang";
    public static final String SQL_KHACH_HANG="CREATE TABLE KhachHang (makhachhang text primary key, tenkhachhang text, sdt int, email text, diachi text);";
    public static final String TAG = "KhachhangDAO";
    public KhachhangDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int inserKhachhang(Khachhang khachhang){
        ContentValues values = new ContentValues();
        values.put("makhachhang",khachhang.getMaKhachhang());
        values.put("tenkhachhang",khachhang.getTenKhachhang());
        values.put("sdt",khachhang.getSdt());
        values.put("email",khachhang.getEmail());
        values.put("diachi",khachhang.getDiaChi());
        try {
            if(db.insert(TABLE_NAME,null,values)== -1){
                return -1;
            }
        }catch (Exception ex){
            Log.e(TAG,ex.toString());
        }
        return 1;
    }

    public List<Khachhang> getAllKhachhang(){
        List<Khachhang> dsKhachhang = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
          Khachhang ee = new Khachhang();
            ee.setMaKhachhang(c.getString(0));
            ee.setTenKhachhang(c.getString(1));
            ee.setSdt(c.getString(2));
            ee.setEmail(c.getString(3));
            ee.setDiaChi(c.getString(4));
            dsKhachhang.add(ee);
            Log.d("//=====",ee.toString());
            c.moveToNext();
        }
        c.close();
        return dsKhachhang;
    }
    //update
    public int updateKhachhang(Khachhang khachhang){
        ContentValues values = new ContentValues();
        values.put("makhachhang",khachhang.getMaKhachhang());
        values.put("tenkhachhang",khachhang.getTenKhachhang());
        values.put("sdt",khachhang.getSdt());
        values.put("email",khachhang.getEmail());
        values.put("diachi",khachhang.getDiaChi());
        int result = db.update(TABLE_NAME,values,"makhachhang=?", new
                String[]{khachhang.getMaKhachhang()});
        if (result == 0){
            return -1;
        }
        return 1;
    }
    public int updateInfoKhachhang(String makhachhang,String s, String s1,String s2,String s3, String s4){
        ContentValues values = new ContentValues();
        values.put("makhachhang",s);
        values.put("tenkhachhang",s1);
        values.put("sdt",s2);
        values.put("email",s3);
        values.put("diachi",s4);
        int result = db.update(TABLE_NAME,values,"makhachhang=?", new
                String[]{makhachhang});
        if (result == 0){
            return -1;
        }
        return 1;
    }

    //delete
    public int deleteKhachHangByID(String makhachhang){
        int result = db.delete(TABLE_NAME,"makhachhang=?",new String[]{makhachhang});
        if (result == 0)
            return -1;
        return 1;
    }
}