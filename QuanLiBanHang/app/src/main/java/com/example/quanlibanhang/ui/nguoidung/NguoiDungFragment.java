package com.example.quanlibanhang.ui.nguoidung;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.ui.hoadon.HoaDon;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungFragment extends Fragment {
    ImageView imgAdd;
    ListView lvList;
    NguoiDungAdapter adapter;
    List<NguoiDung> list;
    DatabaseReference mData;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_nguoi_dung, container, false);
        imgAdd = root.findViewById(R.id.btnAdd);
        lvList = root.findViewById(R.id.lvNguoiDung);
        mData = FirebaseDatabase.getInstance().getReference();

        list = new ArrayList<>();
        adapter=new NguoiDungAdapter(getActivity().getApplicationContext(),list,R.layout.item_user);
        lvList.setAdapter(adapter);
        LoadData();
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThemNguoiDungActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }

    private void LoadData() {
        mData.child("NguoiDung").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                NguoiDung nguoiDung = dataSnapshot.getValue(NguoiDung.class);
                list.add(new NguoiDung(nguoiDung.username, nguoiDung.password, nguoiDung.hoTen, nguoiDung.ghiChu));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                HoaDon hoaDon = dataSnapshot.getValue(HoaDon.class);
                hoaDon.setMaHD(dataSnapshot.getKey());
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                list.remove(dataSnapshot.getKey());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String key = dataSnapshot.getKey();
                list.remove(key);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
