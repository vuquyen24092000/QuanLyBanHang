package com.example.quanlibanhang.ui.hoadon;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.thuonghieu.ThemThuongHieuActivity;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HoaDonFragment extends Fragment {
    ImageView btnAdd;
    ListView lvList;
    List<HoaDon> list;
    HoaDonAdapter adapter;
    DatabaseReference mData;
    List<String> keyList = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hoa_don, container, false);
        btnAdd = root.findViewById(R.id.btnAddHD);
        lvList = root.findViewById(R.id.lvHD);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThemHoaDonActivity.class);
                startActivity(intent);
            }
        });
        mData = FirebaseDatabase.getInstance().getReference();

        list = new ArrayList<>();
        adapter = new HoaDonAdapter(getActivity().getApplicationContext(), list, R.layout.item_hoadon);
        lvList.setAdapter(adapter);
        LoadData();
        return root;
    }

    private void LoadData() {
        mData.child("HoaDon").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                HoaDon hoaDon = dataSnapshot.getValue(HoaDon.class);
                list.add(new HoaDon(hoaDon.maHD, hoaDon.tenHD, hoaDon.tenKH, hoaDon.tenSP, hoaDon.username, hoaDon.dateHD, hoaDon.tongTien, hoaDon.ghiChuHD));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                HoaDon hoaDon = dataSnapshot.getValue(HoaDon.class);
                String key = dataSnapshot.getKey();

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                String key = dataSnapshot.getKey();
                int index = keyList.indexOf(key);

                if (index != -1) {
                    list.remove(index);
                    keyList.remove(index);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
