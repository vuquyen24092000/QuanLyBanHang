package com.example.qlbanhang.ui.SanPham;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.qlbanhang.R;

public class SuaSanPham extends AppCompatActivity {
    private EditText ed_updatensx;
    private EditText ed_updatehsd;
    private Spinner sp_updatethuongHieu;
    private EditText ed_updatenhapMaSp;
    private EditText ed_updatenhapTenSp;
    private EditText ed_updatemoTa;
    private EditText ed_updategiaBan;
    private Button btn_suaSanPham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_san_pham);
        setTitle("Sửa Sản Phẩm");

        ed_updatenhapMaSp=findViewById(R.id.ed_updatenhapMaSp);
        ed_updatenhapTenSp=findViewById(R.id.ed_updatenhapTenSp);
        ed_updatensx=findViewById(R.id.ed_updatensx);
        ed_updatehsd=findViewById(R.id.ed_updatehsd);
        btn_suaSanPham=findViewById(R.id.btn_suaSanPham);
        sp_updatethuongHieu=findViewById(R.id.sp_updatethuongHieu);
        ed_updatemoTa=findViewById(R.id.ed_updatemoTa);
        ed_updategiaBan=findViewById(R.id.ed_updategiaBan);

        moder();
    }
        public void moder(){

        }
}
