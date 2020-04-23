package com.example.quanlibanhang.ui.nguoidung;

public class NguoiDung {
    String username, password, hoTen, ghiChu;

    public NguoiDung() {
    }

    public NguoiDung(String username, String password, String hoTen, String ghiChu) {
        this.username = username;
        this.password = password;
        this.hoTen = hoTen;
        this.ghiChu = ghiChu;
    }

    public String getUsername() {
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
