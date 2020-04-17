package com.example.qlbanhang.thuonghieu;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface ThuongHieuDAO {
    @Query("SELECT * FROM ThuongHieu")
    List<ThuongHieu> getAll();

    @Insert
    long[] insertTH(ThuongHieu... thuongHieus);

    @Delete
    int deleteTH(ThuongHieu thuongHieu);

    @Update
    int updateTH(ThuongHieu thuongHieu);
}
