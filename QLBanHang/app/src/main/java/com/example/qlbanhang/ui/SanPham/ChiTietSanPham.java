package com.example.qlbanhang.ui.SanPham;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qlbanhang.R;

public class ChiTietSanPham extends AppCompatActivity {
    private TextView tv_tenSanPham;
    private ImageView img_anhSanPham;
    private TextView tv_giaSanPham;
    private TextView tv_thuongHieu;
    private TextView tv_nxsSanPham;
    private TextView tv_hsdSanPham;
    private TextView tv_moTaSanPham;
    private Button btn_themVaoGH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        setTitle("Chi Tiết Sản Phẩm");

        tv_tenSanPham=findViewById(R.id.tv_tenSanPham);
        tv_giaSanPham=findViewById(R.id.tv_giaSanPham);
        tv_thuongHieu=findViewById(R.id.tv_thuongHieu);
        tv_nxsSanPham=findViewById(R.id.tv_nxsSanPham);
        tv_hsdSanPham=findViewById(R.id.tv_hsdSanPham);
        tv_moTaSanPham=findViewById(R.id.tv_moTaSanPham);
        img_anhSanPham=findViewById(R.id.img_anhSanPham);
        btn_themVaoGH=findViewById(R.id.btn_themVaoGH);

        moder();
    }
    public void moder(){
        btn_themVaoGH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(ChiTietSanPham.this,GioHang.class);
            startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chitietsp,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.it_suasp:
                intent=new Intent(ChiTietSanPham.this,SuaSanPham.class);
                startActivity(intent);
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }
}
