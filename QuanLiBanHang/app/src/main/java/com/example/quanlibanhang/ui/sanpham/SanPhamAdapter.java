package com.example.quanlibanhang.ui.sanpham;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.ui.nguoidung.ThemNguoiDungActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SanPhamAdapter extends BaseAdapter {

    Context context;
    List<SanPham> arrayList;
    int myLayout;

    public SanPhamAdapter(Context context, List<SanPham> arrayList, int myLayout) {
        this.context = context;
        this.arrayList = arrayList;
        this.myLayout = myLayout;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        ImageView imgSP, imgDelete, imgUpdate;
        TextView tenSP, HSD, giaBan;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder viewHolder = new ViewHolder();

        if (convertView == null) {
            convertView = inflater.inflate(myLayout, null);
            viewHolder.tenSP = (TextView) convertView.findViewById(R.id.tvTenSP);
            viewHolder.HSD = (TextView) convertView.findViewById(R.id.tvHSD);
            viewHolder.giaBan = (TextView) convertView.findViewById(R.id.tvGiaBan);
            viewHolder.imgSP = (ImageView) convertView.findViewById(R.id.imgSP);
            viewHolder.imgDelete = (ImageView) convertView.findViewById(R.id.imgDelete);
            viewHolder.imgUpdate = (ImageView) convertView.findViewById(R.id.imgUpdate);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView
                    .getTag();
        }
        viewHolder.tenSP.setText(arrayList.get(position).tenSP);
        viewHolder.HSD.setText(arrayList.get(position).HSD);
        viewHolder.giaBan.setText("" + arrayList.get(position).giaBan);
        Picasso.get().load(arrayList.get(position).linkAnhSP).into(viewHolder.imgSP);
        viewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference mData = FirebaseDatabase.getInstance().getReference();
                mData.child("SanPham").removeValue();
                Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.imgUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //context (activity) và du lieu
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ThemSanPhamAcitivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("maSP", arrayList.get(position).getMaSP());
                    intent.putExtra("bundleSP", bundle);
                    context.startActivity(intent);
                } catch (Exception e) {
                    Log.e("Lỗi", e.getMessage());
                }
            }
        });
        return convertView;
    }
}

