package com.example.quanlibanhang.ui.nguoidung;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlibanhang.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ThemNguoiDungActivity extends AppCompatActivity {
    EditText edUsername, edPassword, edHoten, edGhichu;
    DatabaseReference mData;
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
        mData = FirebaseDatabase.getInstance().getReference();

        try {
            Intent intent = getIntent();
            Bundle b = intent.getBundleExtra("bundleND");
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
        mData.child("NguoiDung").push().setValue(nguoiDung, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if (databaseError == null) {
                    Toast.makeText(ThemNguoiDungActivity.this, "Lưu dữ liệu thành công", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ThemNguoiDungActivity.this, "Lỗi!!!" + databaseError, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void capNhatNguoiDung(View view) {
        String name = edUsername.getText().toString();
        String pw = edPassword.getText().toString();
        String ten = edHoten.getText().toString();
        String ghiChu = edGhichu.getText().toString();
        NguoiDung nguoiDung = new NguoiDung(name, pw, ten, ghiChu);
        mData.child("NguoiDung").push().setValue(nguoiDung, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if (databaseError == null) {
                    Toast.makeText(ThemNguoiDungActivity.this, "Lưu dữ liệu thành công", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ThemNguoiDungActivity.this, "Lỗi!!!" + databaseError, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void cancel(View view) {
        edUsername.setText("");
        edPassword.setText("");
        edHoten.setText("");
        edGhichu.setText("");
    }
}
