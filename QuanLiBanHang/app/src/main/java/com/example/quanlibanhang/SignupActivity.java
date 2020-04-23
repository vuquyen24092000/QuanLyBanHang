package com.example.quanlibanhang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    EditText edUsername, edPassword, edRepassword, edHoten, edGhiChu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Đăng kí");
        setContentView(R.layout.activity_signup);
        edUsername = findViewById(R.id.edtUsername);
        edPassword = findViewById(R.id.edtPassword);
        edUsername = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPassword);
        edRepassword = findViewById(R.id.edRePassword);
        edHoten = findViewById(R.id.edHoten);
        edGhiChu = findViewById(R.id.edGhiChu);
    }

    public void dangKy(View view) {
        if (edUsername.getText().toString().equals("") || edPassword.getText().toString().equals("") || edRepassword.getText().toString().equals("") || edHoten.getText().toString().equals("") || edGhiChu.getText().toString().equals("")) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
        } else if (edUsername.getText().toString().equals("")) {
            Toast.makeText(this, "Đăng ký thất bại, nhập username", Toast.LENGTH_LONG).show();
        } else if (edPassword.getText().toString().equals("")) {
            Toast.makeText(this, "Đăng ký thất bại, nhập password", Toast.LENGTH_LONG).show();
        } else if (edHoten.getText().toString().equals("")) {
            Toast.makeText(this, "Đăng ký thất bại, nhập họ tên", Toast.LENGTH_LONG).show();
        } else if (edGhiChu.getText().toString().equals("")) {
            Toast.makeText(this, "Đăng ký thất bại, nhập ghi chú", Toast.LENGTH_LONG).show();
        } else if (!edPassword.getText().toString().equals(edRepassword.getText().toString())) {
            Toast.makeText(this, "Mật khẩu không trùng nhau", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                    finish();
                }
            }, 500);
        }
    }
}
