package com.example.qlbanhang.ui.SanPham;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.qlbanhang.R;

public class ThemThuongHieu extends AppCompatActivity {
    private ImageView img_PictureTH;
    private Button btn_taiAnhTH;
    private Button btn_themTH;
    private EditText ed_maTH;
    private EditText ed_tenTH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_thuong_hieu);
        setTitle("Thêm Thương Hiệu");

        img_PictureTH=findViewById(R.id.imgPictureTH);
        btn_taiAnhTH=findViewById(R.id.btn_taiAnhTH);
        btn_themTH=findViewById(R.id.btn_themTH);
        ed_maTH=findViewById(R.id.ed_nhapMaTH);
        ed_tenTH=findViewById(R.id.ed_nhapTenTH);
    }
}
