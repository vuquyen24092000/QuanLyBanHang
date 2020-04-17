package com.example.qlbanhang.thuonghieu;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ThuongHieu")
public class ThuongHieu {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "maTH")
    private int maTH;

    @ColumnInfo(name = "anhTH")
    private int anhTH ;

    @ColumnInfo(name = "tenTH")
    private String tenTH;

    public ThuongHieu() {
    }

    public ThuongHieu(int maTH, int anhTH, String tenTH) {
        this.maTH = maTH;
        this.anhTH = anhTH;
        this.tenTH = tenTH;
    }

    public int getMaTH() {
        return maTH;
    }

    public void setMaTH(int maTH) {
        this.maTH = maTH;
    }

    public int getAnhTH() {
        return anhTH;
    }

    public void setAnhTH(int anhTH) {
        this.anhTH = anhTH;
    }

    public String getTenTH() {
        return tenTH;
    }

    public void setTenTH(String tenTH) {
        this.tenTH = tenTH;
    }
}
