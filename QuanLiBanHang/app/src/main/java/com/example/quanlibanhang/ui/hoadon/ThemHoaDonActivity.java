package com.example.quanlibanhang.ui.hoadon;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.ui.sanpham.ThemSanPhamAcitivity;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ThemHoaDonActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    Button btnPicDate, btnAddHD, btnSuaHD;
    EditText edMaHD, edTenHD, edTenKH, edTenSP, edUsername, edDate, edTongTien, edGhiChuHD;
    DatabaseReference mData;
    HoaDon hoaDon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_hoa_don);
        AnhXa();
        mData = FirebaseDatabase.getInstance().getReference();

        try {
            Intent intent = getIntent();
            Bundle b = intent.getBundleExtra("bundleHD");
            edMaHD.setText(b.getString("maHD"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        btnAddHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hoaDon = new HoaDon(edMaHD.getText().toString(), edTenHD.getText().toString(), edTenKH.getText().toString(), edTenSP.getText().toString(), edUsername.getText().toString(), edDate.getText().toString(), edTongTien.getText().toString(), edGhiChuHD.getText().toString());
                mData.child("HoaDon").push().setValue(hoaDon, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                        if (databaseError == null) {
                            Toast.makeText(ThemHoaDonActivity.this, "Lưu dữ liệu thành công", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(ThemHoaDonActivity.this, "Lỗi!!!" + databaseError, Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
//        btnSuaHD.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                hoaDon = new HoaDon(edMaHD.getText().toString(), edTenHD.getText().toString(), edTenKH.getText().toString(), edTenSP.getText().toString(), edUsername.getText().toString(), edDate.getText().toString(), edTongTien.getText().toString(), edGhiChuHD.getText().toString());
//                mData.child("HoaDon").push().setValue(hoaDon, new DatabaseReference.CompletionListener() {
//                    @Override
//                    public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
//                        if (databaseError == null) {
//                            Toast.makeText(ThemHoaDonActivity.this, "Cập nhật dữ liệu thành công", Toast.LENGTH_LONG).show();
//                        } else {
//                            Toast.makeText(ThemHoaDonActivity.this, "Lỗi!!!" + databaseError, Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//            }
//        });
    }

    private void AnhXa() {
        edMaHD = findViewById(R.id.edMaHD);
        edTenHD = findViewById(R.id.edTenHD);
        edTenKH = findViewById(R.id.edTenKH);
        edTenSP = findViewById(R.id.edTenSP);
        edUsername = findViewById(R.id.edUsername);
        edDate = findViewById(R.id.edDate);
        edTongTien = findViewById(R.id.edTongTien);
        edGhiChuHD = findViewById(R.id.edGhiChuHĐ);
        btnPicDate = findViewById(R.id.btnPicDate);
        btnAddHD = findViewById(R.id.btnThemHD);
        btnSuaHD = findViewById(R.id.btnSuaHD);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar cal = new GregorianCalendar(year, month, dayOfMonth);
        setDate(cal);
    }


    private void setDate(Calendar calendar) {
        edDate.setText(sdf.format(calendar.getTime()));
    }

    public static class DatePickerFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
        }
    }

    public void datePicker(View view) {
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getSupportFragmentManager(), "date");
    }
}
