package com.example.reddragon.assduan;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reddragon.assduan.DAO.KhachhangDAO;
import com.example.reddragon.assduan.Dulieu.Khachhang;

public class Khachhangdetail extends AppCompatActivity {
    EditText edMakhachhang,edTenkhachhang,edSdt,edEmail,edDiachi;
   KhachhangDAO khachhangDAO;
    String ma,ten,sdt,email,diachi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("CHI TIẾT KHACH HANG");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_khachhangdetail);
        edMakhachhang = (EditText) findViewById(R.id.edMakhachhang);
        edTenkhachhang = (EditText) findViewById(R.id.edTenkhachhang);
        edSdt= (EditText) findViewById(R.id.edSdt);
        edEmail= (EditText) findViewById(R.id.edEmail);
        edDiachi= (EditText) findViewById(R.id.edDiachi);
       khachhangDAO = new KhachhangDAO(this);
        TextView text = (TextView) findViewById(R.id.text);;
        Typeface type=Typeface.createFromAsset(getAssets(), "fonts/f.ttf");
        text.setTypeface(type);
        Intent in = getIntent();
        Bundle c = in.getExtras();
        ma=c.getString("MAKHACHHANG");
        ten = c.getString("TENKHACHHANG");
        sdt = c.getString("SDT");
       email= c.getString("EMAIL");
       diachi= c.getString("DIACHI");
       edMakhachhang.setText(ma);
        edTenkhachhang.setText(ten);
        edSdt.setText(sdt);
        edEmail.setText(email);
        edDiachi.setText(diachi);
    }
    public void updateU(View view){

        if (khachhangDAO.updateInfoKhachhang(ma,edMakhachhang.getText().toString(),edTenkhachhang.getText().toString(),edSdt.getText().toString(),edEmail.getText().toString(),edDiachi.getText().toString())>0){
            Toast.makeText(getApplicationContext(),"Lưu thành công",Toast.LENGTH_SHORT).show();
        }
    }
    public void Huy(View view){
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
