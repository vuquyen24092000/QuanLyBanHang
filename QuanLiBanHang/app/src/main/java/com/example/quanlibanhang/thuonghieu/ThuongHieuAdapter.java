package com.example.quanlibanhang.thuonghieu;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ThuongHieuAdapter extends BaseAdapter {
    Context context;
    List<ThuongHieu> arrayList;
    int myLayout;

    public ThuongHieuAdapter(Context context, List<ThuongHieu> arrayList, int myLayout) {
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
        ImageView imgTH, imgDelete, imgUpdate;
        TextView maTH, tenTH;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder viewHolder = new ViewHolder();

        if (convertView == null) {
            convertView = inflater.inflate(myLayout, null);
            viewHolder.maTH = (TextView) convertView.findViewById(R.id.tvMaTH);
            viewHolder.tenTH = (TextView) convertView.findViewById(R.id.tvTenTH);
            viewHolder.imgTH = (ImageView) convertView.findViewById(R.id.imgTH);
            viewHolder.imgDelete = (ImageView) convertView.findViewById(R.id.imgDelete);
            viewHolder.imgUpdate = (ImageView) convertView.findViewById(R.id.imgUpdate);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.maTH.setText(arrayList.get(position).maTH);
        viewHolder.tenTH.setText(arrayList.get(position).tenTH);
        Picasso.get().load(arrayList.get(position).linkAnh).into(viewHolder.imgTH);
        viewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference mData = FirebaseDatabase.getInstance().getReference();
                mData.child("ThuongHieu").removeValue();
                Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
            }
        });


        viewHolder.imgUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ThemThuongHieuActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("maTH", arrayList.get(position).maTH);
                intent.putExtra("bundleTH", bundle);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
