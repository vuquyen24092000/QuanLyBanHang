package com.example.quanlibanhang.ui.hoadon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.thuonghieu.ThemThuongHieuActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class HoaDonAdapter extends BaseAdapter {
    Context context;
    List<HoaDon> list;
    int layout;


    public HoaDonAdapter(Context context, List<HoaDon> list, int layout) {
        this.context = context;
        this.list = list;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        ImageView imgDelete, imgUpdate;
        TextView tvTenHD, tvTenKH, tvTongTien, tvGhiChu;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder viewHolder = new ViewHolder();

        if (convertView == null) {
            convertView = inflater.inflate(layout, null);
            viewHolder.tvTenHD = (TextView) convertView.findViewById(R.id.tvTenHD);
            viewHolder.tvTenKH = (TextView) convertView.findViewById(R.id.tvKH);
            viewHolder.tvTongTien = (TextView) convertView.findViewById(R.id.tvTongTien);
            viewHolder.tvGhiChu = (TextView) convertView.findViewById(R.id.tvGhiChuHD);
            viewHolder.imgDelete = (ImageView) convertView.findViewById(R.id.imgDelete);
            viewHolder.imgUpdate = (ImageView) convertView.findViewById(R.id.imgUpdate);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvTenHD.setText(list.get(position).tenHD);
        viewHolder.tvTenKH.setText(list.get(position).tenKH);
        viewHolder.tvTongTien.setText(list.get(position).tongTien);
        viewHolder.tvGhiChu.setText(list.get(position).ghiChuHD);
        viewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference mData = FirebaseDatabase.getInstance().getReference();
                mData.child("HoaDon").removeValue();
                Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.imgUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ThemHoaDonActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("maHD", list.get(position).maHD);
                intent.putExtra("bundleHD", bundle);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
