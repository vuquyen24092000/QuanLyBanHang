package com.example.qlbanhang.ui.NguoiDung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlbanhang.R;

import java.util.ArrayList;
import java.util.List;

public class ThemNguoiDungActivity extends AppCompatActivity {
    EditText edUsername, edPassword, edHoten, edGhichu;
    Database database;
    NguoiDungDAO nguoiDungDAO;
    NguoiDungAdapter nguoiDungAdapter;
    List<NguoiDung> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nguoi_dung);
        edUsername = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPassword);
        edHoten = findViewById(R.id.edHoten);
        edGhichu = findViewById(R.id.edGhiChu);
        list = new ArrayList<>();
        database = Room.databaseBuilder(getApplicationContext(), Database.class, "NguoiDung").allowMainThreadQueries().build();

        try {
            Intent intent = getIntent();
            Bundle b = intent.getBundleExtra("bundle");
            edUsername.setText(b.getString("username"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void themNguoiDung(View view) {
        String name = edUsername.getText().toString();
        String pw = edPassword.getText().toString();
        String ten = edHoten.getText().toString();
        String ghiChu = edGhichu.getText().toString();
        NguoiDung nguoiDung = new NguoiDung(name, pw, ten, ghiChu);
        long[] result = database.nguoiDungDAO().insertNguoiDung(nguoiDung);
        if (result[0] > 0) {
            Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
            this.list.add(nguoiDung);
            nguoiDungAdapter.notifyDataSetChanged();

        }

    }

    public void capNhatNguoiDung(View view) {
        String name = edUsername.getText().toString();
        String pw = edPassword.getText().toString();
        String ten = edHoten.getText().toString();
        String ghiChu = edGhichu.getText().toString();
        NguoiDung nguoiDung = new NguoiDung(name, pw, ten, ghiChu);
        int result=database.nguoiDungDAO().updateNguoiDung(nguoiDung);
        if (result> 0) {
            Toast.makeText(this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
            nguoiDungAdapter.notifyDataSetChanged();

        }
    }

    public void cancel(View view) {
        edUsername.setText("");
        edPassword.setText("");
        edHoten.setText("");
        edGhichu.setText("");
    }
}
