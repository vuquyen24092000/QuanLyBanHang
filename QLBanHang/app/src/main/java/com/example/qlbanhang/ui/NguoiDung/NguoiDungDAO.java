package com.example.qlbanhang.ui.NguoiDung;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface NguoiDungDAO {

    @Query("SELECT * FROM NguoiDung")
    List<NguoiDung> getAll();

    @Insert
    long[] insertNguoiDung(NguoiDung... nguoiDung);

    @Delete
    int deleteNguoiDung(NguoiDung nguoiDung);

    @Update
    int updateNguoiDung(NguoiDung nguoiDung);

//    @Query("DELETE FROM NguoiDung")
//    void deleteAllUser();
}
