package com.example.quanlibanhang.ui.hoadon;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.quanlibanhang.R;

public class HoaDonFragment extends Fragment {
    ImageView btnAdd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hoa_don, container, false);
        btnAdd=root.findViewById(R.id.btnAddHD);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ThemHoaDonActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }
}
