package com.example.quanlibanhang.ui.hoadon;

public class HoaDon {
    String maHD, tenHD, tenKH, tenSP, username, dateHD, tongTien, ghiChuHD;

    public HoaDon() {
    }

    public HoaDon(String maHD, String tenHD, String tenKH, String tenSP, String username, String dateHD, String tongTien, String ghiChuHD) {
        this.maHD = maHD;
        this.tenHD = tenHD;
        this.tenKH = tenKH;
        this.tenSP = tenSP;
        this.username = username;
        this.dateHD = dateHD;
        this.tongTien = tongTien;
        this.ghiChuHD = ghiChuHD;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenHD() {
        return tenHD;
    }

    public void setTenHD(String tenHD) {
        this.tenHD = tenHD;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateHD() {
        return dateHD;
    }

    public void setDateHD(String dateHD) {
        this.dateHD = dateHD;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public String getGhiChuHD() {
        return ghiChuHD;
    }

    public void setGhiChuHD(String ghiChuHD) {
        this.ghiChuHD = ghiChuHD;
    }
}
