package com.example.qlbanhang.ui.NguoiDung;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.qlbanhang.R;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungFragment extends Fragment {
    ImageView imgAdd;
    RecyclerView recyclerView;
    NguoiDungAdapter nguoiDungAdapter;
    List<NguoiDung> list;
    NguoiDungDAO nguoiDungDAO;
    Database database;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_nguoidung, container, false);
        imgAdd = root.findViewById(R.id.btnAdd);
        recyclerView = root.findViewById(R.id.rcViewNguoiDung);
        nguoiDungDAO = new NguoiDungDAO() {
            @Override
            public List<NguoiDung> getAll() {
                return getAll();
            }

            @Override
            public long[] insertNguoiDung(NguoiDung... nguoiDung) {
                return new long[0];
            }

            @Override
            public int deleteNguoiDung(NguoiDung nguoiDung) {
                return 0;
            }

            @Override
            public int updateNguoiDung(NguoiDung nguoiDung) {

                return 0;
            }
        };
        database = Room.databaseBuilder(getActivity().getApplicationContext(),Database.class,"NguoiDung").allowMainThreadQueries().build();
        list=database.nguoiDungDAO().getAll();
        nguoiDungAdapter=new NguoiDungAdapter(list,getActivity().getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(nguoiDungAdapter);
        nguoiDungAdapter.notifyDataSetChanged();


        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThemNguoiDungActivity.class);
                startActivity(intent);
            }
        });


        return root;
    }
}
