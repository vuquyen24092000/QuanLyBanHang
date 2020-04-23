package com.example.quanlibanhang.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
    WebView webView;

    FragmentManager fragmentManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        webView = root.findViewById(R.id.webview);
        webView.loadUrl("https://kenh14.vn/my-pham.html");
        webView.setWebViewClient(new WebViewClient());
        return root;
    }


}
