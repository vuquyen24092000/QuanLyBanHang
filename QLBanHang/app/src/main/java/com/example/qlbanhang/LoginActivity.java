package com.example.qlbanhang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlbanhang.ui.NguoiDung.Database;

public class LoginActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Đăng nhập");
        setContentView(R.layout.activity_login);
        edtUsername=findViewById(R.id.edtUsername);
        edtPassword=findViewById(R.id.edtPassword);
        database = Room.databaseBuilder(getApplicationContext(), Database.class, "NguoiDung.db").allowMainThreadQueries().build();
    }

    public void logIn(View view) {
        String username=edtUsername.getText().toString();
        String password=edtPassword.getText().toString();
        if (username.equals("") || password.equals("")){
            Toast.makeText(this,"Nhập thông tin đầy đủ",Toast.LENGTH_SHORT).show();
        } else if (edtPassword.length()<6){
            Toast.makeText(this,"Mật khẩu phải có trên 6 kí tự",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            //finish();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
            }, 500);
        }

    }

    public void signUp(View view) {
        Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(intent);

    }
}
