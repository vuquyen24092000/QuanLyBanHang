package com.example.qlbanhang.ui.SanPham;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.qlbanhang.R;

public class ThuongHieu extends AppCompatActivity {
    private ListView lv_thuongHieu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thuong_hieu);
        setTitle("Thương Hiệu");

        lv_thuongHieu=findViewById(R.id.lv_thuongHieu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_themthuonghieu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id == R.id.it_searchTH){

        }
        if (id == R.id.it_themThuongHieu){
            Intent intent=new Intent(ThuongHieu.this,ThemThuongHieu.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
