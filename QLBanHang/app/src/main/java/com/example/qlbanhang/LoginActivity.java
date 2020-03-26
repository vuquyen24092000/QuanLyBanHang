package com.example.qlbanhang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUsername=findViewById(R.id.edtUsername);
        edtPassword=findViewById(R.id.edtPassword);
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
            }, 1000);
        }

    }

    public void signIn(View view) {
    }
}
