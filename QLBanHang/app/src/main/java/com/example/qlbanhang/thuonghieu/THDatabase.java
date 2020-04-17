package com.example.qlbanhang.thuonghieu;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ThuongHieu.class},version = 1)
public abstract class THDatabase extends RoomDatabase {
    public abstract ThuongHieuDAO thuongHieuDAO();
}
