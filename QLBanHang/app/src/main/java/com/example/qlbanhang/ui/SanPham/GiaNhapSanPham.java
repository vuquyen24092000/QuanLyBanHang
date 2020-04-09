package com.example.qlbanhang.ui.SanPham;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.qlbanhang.R;

public class GiaNhapSanPham extends AppCompatActivity {
    private EditText ed_saLe;
    private EditText ed_moTaSp;
    private EditText ed_giaBan;
    private Button btn_themGiaSp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gia_nhap_san_pham);
        setTitle("Thêm Giá Sản Phẩm");

        ed_saLe=findViewById(R.id.ed_saLe);
        ed_moTaSp=findViewById(R.id.ed_moTaSp);
        ed_saLe=findViewById(R.id.ed_saLe);
        btn_themGiaSp=findViewById(R.id.btn_giaNhap);

        moder();
    }
    public void moder(){

    }
}
