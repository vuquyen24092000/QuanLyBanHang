package com.example.quanlibanhang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlibanhang.ui.nguoidung.Database;

public class LoginActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Database database;
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
        chkpass=findViewById(R.id.checkBox);
        database = Room.databaseBuilder(getApplicationContext(), Database.class, "NguoiDung.db").allowMainThreadQueries().build();
        sharedPreferences = getSharedPreferences("Shared", MODE_PRIVATE);
        edtUsername.setText(sharedPreferences.getString("username", ""));
        edtPassword.setText(sharedPreferences.getString("password", ""));
    }
    public int checkUP(String userName, String passWord) {
        if (userName.equals("admin") && passWord.equals("admin")) {
            return 1;
        } else {
            return -1;
        }

    }

    public void logIn(View view) {
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();
        if (username.equals("") || password.equals("")) {
            Toast.makeText(this, "Nhập thông tin đầy đủ", Toast.LENGTH_SHORT).show();
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
            if (chkpass.isChecked()) {
                editor = sharedPreferences.edit();
                editor.putString("username", edtUsername.getText().toString().trim());
                editor.putString("password", edtPassword.getText().toString().trim());
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
