package com.example.quanlibanhang.ui.sanpham;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.thuonghieu.ThemThuongHieuActivity;
import com.example.quanlibanhang.thuonghieu.ThuongHieu;
import com.example.quanlibanhang.thuonghieu.ThuongHieuActivity;
import com.example.quanlibanhang.thuonghieu.ThuongHieuAdapter;
import com.example.quanlibanhang.ui.nguoidung.ThemNguoiDungActivity;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class SanPhamFragment extends Fragment {
    ImageView btnAddSP;
    ListView lvSP;
    List<SanPham> arrayList;
    SanPhamAdapter adapter;
    DatabaseReference mData;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_san_pham, container, false);
        btnAddSP = root.findViewById(R.id.btnAddSP);
        lvSP=root.findViewById(R.id.lvSanPham);
        btnAddSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ThemSanPhamAcitivity.class);
                startActivity(intent);
            }
        });

        mData = FirebaseDatabase.getInstance().getReference();

        arrayList=new ArrayList<>();
        adapter=new SanPhamAdapter(getActivity().getApplicationContext(),arrayList ,R.layout.item_sanpham);
        lvSP.setAdapter(adapter);
        LoadData();
        return root;
    }

    private void LoadData() {
        mData.child("SanPham").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                SanPham sanPham = dataSnapshot.getValue(SanPham.class);
                arrayList.add(new SanPham(sanPham.linkAnhSP,sanPham.maSP,sanPham.tenSP, sanPham.tenTH,sanPham.NSX,sanPham.HSD,sanPham.moTaSP,sanPham.giaNhap,sanPham.giaBan ));
                adapter.notifyDataSetChanged();
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
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuThuongHieu) {
            Intent intent = new Intent(getActivity(), ThuongHieuActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
