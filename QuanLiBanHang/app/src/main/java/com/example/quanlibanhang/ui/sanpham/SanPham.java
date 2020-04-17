package com.example.quanlibanhang.ui.sanpham;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SanPham {
    String linkAnhSP, maSP, tenSP, tenTH, NSX, HSD, moTaSP;
    double giaNhap, giaBan;

    public SanPham() {
    }

    public SanPham(String linkAnhSP, String maSP, String tenSP, String tenTH, String NSX, String HSD, String moTaSP, double giaNhap, double giaBan) {
        this.linkAnhSP = linkAnhSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.tenTH = tenTH;
        this.NSX = NSX;
        this.HSD = HSD;
        this.moTaSP = moTaSP;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public String getLinkAnhSP() {
        return linkAnhSP;
    }

    public void setLinkAnhSP(String linkAnhSP) {
        this.linkAnhSP = linkAnhSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTenTH() {
        return tenTH;
    }

    public void setTenTH(String tenTH) {
        this.tenTH = tenTH;
    }

    public String getNSX() {
        return NSX;
    }

    public void setNSX(String NSX) {
        this.NSX = NSX;
    }

    public String getHSD() {
        return HSD;
    }

    public void setHSD(String HSD) {
        this.HSD = HSD;
    }

    public String getMoTaSP() {
        return moTaSP;
    }

    public void setMoTaSP(String moTaSP) {
        this.moTaSP = moTaSP;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
}