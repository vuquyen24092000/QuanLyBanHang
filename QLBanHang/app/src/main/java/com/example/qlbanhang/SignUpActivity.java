package com.example.qlbanhang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {
EditText edUsername, edPassword, edRepassword, edHoten, edGhiChu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edUsername=findViewById(R.id.edtUsername);

    }

    public void dangKi(View view) {
    }
}
