package com.example.quanlibanhang.thuonghieu;

public class ThuongHieu {
    String maTH;
    String tenTH;
    String linkAnh;

    public ThuongHieu() {
    }

    public ThuongHieu(String maTH, String tenTH, String linkAnh) {
        this.maTH = maTH;
        this.tenTH = tenTH;
        this.linkAnh = linkAnh;
    }

    public String getMaTH() {
        return maTH;
    }

    public void setMaTH(String maTH) {
        this.maTH = maTH;
    }

    public String getTenTH() {
        return tenTH;
    }

    public void setTenTH(String tenTH) {
        this.tenTH = tenTH;
    }

    public String getLinkAnh() {
        return linkAnh;
    }

    public void setLinkAnh(String linkAnh) {
        this.linkAnh = linkAnh;
    }
}
