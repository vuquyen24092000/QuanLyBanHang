package com.example.quanlibanhang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    CheckBox chkpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Đăng nhập");
        setContentView(R.layout.activity_login);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        chkpass = findViewById(R.id.checkBox);

        sharedPreferences = getSharedPreferences("Shared", MODE_PRIVATE);
        edtUsername.setText(sharedPreferences.getString("username", ""));
        edtPassword.setText(sharedPreferences.getString("password", ""));
    }


    public void logIn(View view) {
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();
        if (username.equals("") || password.equals("")) {
            Toast.makeText(this, "Đăng nhập thất bại, nhập thông tin đầy đủ", Toast.LENGTH_SHORT).show();
        } else if (username.equals("")) {
            Toast.makeText(this, "Đăng nhập thất bại, bạn phải nhập username", Toast.LENGTH_SHORT).show();
        } else if (password.equals("")) {
            Toast.makeText(this, "Đăng nhập thất bại, bạn phải nhập password", Toast.LENGTH_SHORT).show();
        } else if (edtPassword.length() < 6) {
            Toast.makeText(this, "Password phải có ít nhất 6 kí tự", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
            }, 500);
            if (chkpass.isChecked()) {
                editor = sharedPreferences.edit();
                editor.putString("username", edtUsername.getText().toString().trim());
                editor.putString("password", edtPassword.getText().toString().trim());
                Toast.makeText(this, "Đã lưu mật khẩu", Toast.LENGTH_SHORT).show();
                editor.commit();
            }
        }

    }

    public void checkPass(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("Shared", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String ten = edtUsername.getText().toString();
        String mk = edtPassword.getText().toString();
        boolean check = chkpass.isChecked();
        if (!check) {
            editor.clear();
        } else {
            editor.putString("username", ten);
            editor.putString("password", mk);
            editor.putBoolean("save", check);
        }
        editor.commit();
    }

    public void signUp(View view) {
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(intent);

    }
}
