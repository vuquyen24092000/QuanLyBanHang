package com.example.quanlibanhang.ui.nguoidung;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "NguoiDung")
public class NguoiDung {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "hoTen")
    private String hoTen;

    @ColumnInfo(name = "ghiChu")
    private String ghiChu;

    public NguoiDung(String username, String password, String hoTen, String ghiChu) {
        this.username = username;
        this.password = password;
        this.hoTen = hoTen;
        this.ghiChu = ghiChu;
    }

    public String  getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
