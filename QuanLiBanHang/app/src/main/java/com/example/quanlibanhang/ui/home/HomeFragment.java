package com.example.quanlibanhang.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.example.quanlibanhang.R;
import com.example.quanlibanhang.ui.hoadon.HoaDonFragment;
import com.example.quanlibanhang.ui.nguoidung.NguoiDungFragment;
import com.example.quanlibanhang.ui.sanpham.SanPhamFragment;
import com.example.quanlibanhang.ui.thongke.ThongKeFragment;

public class HomeFragment extends Fragment {
    ImageView user, product, bill, total;

    FragmentManager fragmentManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        fragmentManager = getActivity().getSupportFragmentManager();
        return root;
    }

//    public void callFragment(View view) {
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        Fragment fragment = null;
//        switch (view.getId()) {
//            case R.id.img1:
//                fragment = new NguoiDungFragment();
//
//                break;
//            case R.id.img2:
//                fragment = new SanPhamFragment();
//
//                break;
//            case R.id.img3:
//                fragment = new HoaDonFragment();
//
//                break;
//            case R.id.img4:
//                fragment = new ThongKeFragment();
//
//                break;
//        }
//        fragmentTransaction.add(R.id.frame, fragment);
//        fragmentTransaction.commit();
//    }


}
