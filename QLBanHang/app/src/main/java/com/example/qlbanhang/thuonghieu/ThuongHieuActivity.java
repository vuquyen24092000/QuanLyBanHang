package com.example.qlbanhang.thuonghieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.qlbanhang.R;

public class ThuongHieuActivity extends AppCompatActivity {
    ImageView btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Thương hiệu");
        setContentView(R.layout.activity_thuong_hieu);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThuongHieuActivity.this, ThemThuongHieuActivity.class);
                startActivity(intent);
            }
        });
    }
}
