package com.example.qlbanhang.ui.SanPham;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.qlbanhang.R;

public class ThemSanPham extends AppCompatActivity {
    private EditText ed_nsx;
    private EditText ed_hsd;
    private Spinner sp_thuongHieu;
    private EditText ed_nhapMaSp;
    private EditText ed_nhapTenSp;
    private ImageView img_anhSp;
    private Button btn_themSanPham;
    private Button btn_taiAnhSp;
    private TextView tv_giaNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_san_pham);
        setTitle("Thêm Sản Phẩm");

        ed_nhapMaSp=findViewById(R.id.ed_nhapMaSp);
        ed_nhapTenSp=findViewById(R.id.ed_nhapTenSp);
        img_anhSp=findViewById(R.id.imgPicture);
        ed_nsx=findViewById(R.id.ed_nsx);
        ed_hsd=findViewById(R.id.ed_hsd);
        btn_taiAnhSp=findViewById(R.id.btn_taiAnh);
        btn_themSanPham=findViewById(R.id.btn_themSanPham);
        sp_thuongHieu=findViewById(R.id.sp_thuongHieu);
        tv_giaNhap=findViewById(R.id.tv_giaNhap);
        moder();
    }

    public void moder() {
        tv_giaNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThemSanPham.this,GiaNhapSanPham.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_thuonghieu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id == R.id.it_ThuongHieu){
            Intent intent=new Intent(ThemSanPham.this,ThuongHieu.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
