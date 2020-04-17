package com.example.quanlibanhang.thuonghieu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.quanlibanhang.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


import java.util.ArrayList;
import java.util.List;

public class ThuongHieuActivity extends AppCompatActivity {
    ImageView btnAdd;
    ListView lvListTH;
    List<ThuongHieu> arrayList;
    ThuongHieuAdapter thuongHieuAdapter;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    DatabaseReference mData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Thương hiệu");
        setContentView(R.layout.activity_thuong_hieu);
        btnAdd = findViewById(R.id.btnAdd);
        lvListTH = findViewById(R.id.lvThuongHieu);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThuongHieuActivity.this, ThemThuongHieuActivity.class);
                startActivity(intent);
            }
        });

        mData = FirebaseDatabase.getInstance().getReference();
        final StorageReference storageRef = storage.getReferenceFromUrl("gs://quanlibanhang-1d8ea.appspot.com");

        arrayList = new ArrayList<>();
        thuongHieuAdapter = new ThuongHieuAdapter(this, arrayList, R.layout.item_thuonghieu);
        lvListTH.setAdapter(thuongHieuAdapter);
        LoadData();
    }


    private void LoadData() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {
            mData.child("ThuongHieu").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    ThuongHieu thuongHieu = dataSnapshot.getValue(ThuongHieu.class);
                    arrayList.add(new ThuongHieu(thuongHieu.maTH, thuongHieu.tenTH, thuongHieu.linkAnh));
                    thuongHieuAdapter.notifyDataSetChanged();
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET},10);
        }

    }


}
