package com.example.quanlibanhang.ui.nguoidung;

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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;


import com.example.quanlibanhang.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class NguoiDungAdapter extends BaseAdapter {
    Context context;
    List<NguoiDung> list;
    int layout;

    public NguoiDungAdapter(Context context, List<NguoiDung> list, int layout) {
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

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = inflater.inflate(layout, null);
            viewHolder.tvUsername = (TextView) convertView.findViewById(R.id.tvUsername);
            viewHolder.tvPassword = (TextView) convertView.findViewById(R.id.tvPassword);
            viewHolder.tvHoten = (TextView) convertView.findViewById(R.id.tvHoten);
            viewHolder.imgDelete = (ImageView) convertView.findViewById(R.id.imgDelete);
            viewHolder.imgUpdate = (ImageView) convertView.findViewById(R.id.imgUpdate);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvUsername.setText(list.get(position).getUsername());
        viewHolder.tvPassword.setText(list.get(position).getPassword());
        viewHolder.tvHoten.setText(list.get(position).getHoTen());
        viewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference mData = FirebaseDatabase.getInstance().getReference();
                mData.child("NguoiDung").removeValue();
                Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.imgUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //context (activity) và du lieu
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ThemNguoiDungActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("username", list.get(position).getUsername());
                    intent.putExtra("bundleND", bundle);
                    context.startActivity(intent);
                } catch (Exception e) {
                    Log.e("Lỗi", e.getMessage());
                }
            }
        });
        return convertView;
    }

    public class ViewHolder {
        TextView tvUsername, tvPassword, tvHoten;
        ImageView imgDelete, imgUpdate;
    }
}
