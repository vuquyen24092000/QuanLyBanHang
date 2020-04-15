package com.example.reddragon.assduan.Dulieu;

public class Khachhang {
    private String maKhachhang;
    private String tenKhachhang;
    private String sdt;
    private String email;
    private String diaChi;
    public Khachhang() {
    }

    public Khachhang(String maKhachhang, String tenKhachhang, String sdt, String email, String diaChi) {
        this.maKhachhang = maKhachhang;
        this.tenKhachhang = tenKhachhang;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
    }

    public String getMaKhachhang() {
        return maKhachhang;
    }

    public void setMaKhachhang(String maKhachhang) {
        this.maKhachhang = maKhachhang;
    }

    public String getTenKhachhang() {
        return tenKhachhang;
    }

    public void setTenKhachhang(String tenKhachhang) {
        this.tenKhachhang = tenKhachhang;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return getMaKhachhang()+" | "+getTenKhachhang();
    }
}