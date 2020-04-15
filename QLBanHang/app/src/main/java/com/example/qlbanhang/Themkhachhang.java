package com.example.qlbanhang;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Themkhachhang extends AppCompatActivity {
    Button btnThemKhachhang;
  KhachhangDAO khachhangDAO;
    EditText edMa,edTen,edS,edE,edDia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themkhachhang);
        setTitle("THÊM KHACH HANG");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnThemKhachhang = (Button) findViewById(R.id.btnThem);
        edMa = (EditText) findViewById(R.id.edMa);
        edTen = (EditText) findViewById(R.id.edTen);
        edS = (EditText) findViewById(R.id.edS);
        edE = (EditText) findViewById(R.id.edE);
        edDia = (EditText) findViewById(R.id.edDia);
        TextView text = (TextView) findViewById(R.id.text);;
        Typeface type=Typeface.createFromAsset(getAssets(), "fonts/f.ttf");
        text.setTypeface(type);
    }
    public void showkhachhang(View view) {
        finish();
    }
    public void quaylai(View view) {
        onBackPressed();
    }

    public void themkhachhang(View view) {
        khachhangDAO = new KhachhangDAO(Themkhachhang.this);
        Khachhang user = new Khachhang(edMa.getText().toString(), edTen.getText().toString(),edS.getText().toString(),edE.getText().toString(),edDia.getText().toString());
        try {
            if (validateForm()>0){
                if (khachhangDAO.inserKhachhang(user) > 0) {
                    Toast.makeText(getApplicationContext(), "Thêm thành công",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Thêm thất bại",
                            Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Log.e("Lỗi:", ex.toString());
        }
    }
    public int validateForm(){
        int check = 1;
        if (edMa.getText().length() == 0 || edTen.getText().length() == 0
                || edS.getText().length() == 0 || edE.getText().length()==0 || edDia.getText().length()==0) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông tin ",
                    Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}
