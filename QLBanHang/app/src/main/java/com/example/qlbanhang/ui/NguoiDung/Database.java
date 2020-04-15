package com.example.qlbanhang.ui.NguoiDung;

import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {NguoiDung.class},version = 1)
public abstract class Database extends RoomDatabase {
    public abstract NguoiDungDAO nguoiDungDAO();
}
