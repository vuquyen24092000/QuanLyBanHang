package com.example.qlbanhang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Listkhachhang extends AppCompatActivity {
    public static List<Khachhang> dsKhachhang = new ArrayList<>();
    ListView lvKhachhang;
    KhachhangAdapter adapter = null;
    KhachhangDAO khachhangDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listkhachhang);
        setTitle("KHACH HANG");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lvKhachhang = (ListView) findViewById(R.id.lvKhachhang);
        registerForContextMenu(lvKhachhang);
        khachhangDAO = new KhachhangDAO(Listkhachhang.this);
        dsKhachhang = khachhangDAO.getAllKhachhang();
        adapter = new KhachhangAdapter(this, dsKhachhang);
        lvKhachhang.setAdapter(adapter);
        lvKhachhang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Listkhachhang.this,Khachhangdetail.class);
                Bundle b = new Bundle();
                b.putString("MAKHACHHANG", dsKhachhang.get(position).getMaKhachhang());
                b.putString("TENKHACHHANG", dsKhachhang.get(position).getTenKhachhang());
                b.putString("SDT", String.valueOf(dsKhachhang.get(position).getSdt()));
                b.putString("EMAIL", dsKhachhang.get(position).getEmail());
                b.putString("DIACHI", dsKhachhang.get(position).getDiaChi());

                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menukhachhang, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.addd:
//                Intent intent = new Intent(Listkhachhang.this, Khachhang.class);
//                startActivity(intent);
//                return (true);
//            case android.R.id.home:
//                onBackPressed();
//                return true;
//
//            default:break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        dsKhachhang.clear();
//        dsKhachhang = khachhangDAO.getAllKhachhang();
//        adapter.changeDataset(dsKhachhang);
//    }
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menucontext, menu);
//        menu.setHeaderTitle("Chọn thông tin");
//    }
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        switch(item.getItemId()) {
//            case R.id.eedit:
//                Intent intent1 = new
//                        Intent(Listtheloai.this,Theloai.class);
//                startActivity(intent1);
//                return(true);
//            case R.id.ddelete:
//                Intent intent2 = new
//                        Intent(Listtheloai.this,Theloai.class);
//                startActivity(intent2);
//                return(true);
//        }
//        return super.onContextItemSelected(item);
//    }
}
