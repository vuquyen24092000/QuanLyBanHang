package com.example.quanlibanhang.thuonghieu;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.quanlibanhang.R;
//import com.squareup.picasso.Picasso;


import java.util.ArrayList;
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
        ImageView imgTH;
        TextView maTH, tenTH;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowview = convertView;
        ViewHolder viewHolder = new ViewHolder();

        if (rowview == null) {
            rowview = inflater.inflate(myLayout, null);
            viewHolder.maTH = (TextView) rowview.findViewById(R.id.tvMaTH);
            viewHolder.tenTH = (TextView) rowview.findViewById(R.id.tvTenTH);
            viewHolder.imgTH = (ImageView) rowview.findViewById(R.id.imgTH);
            rowview.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) rowview.getTag();
        }
        viewHolder.maTH.setText(arrayList.get(position).maTH);
        viewHolder.tenTH.setText(arrayList.get(position).tenTH);
        Glide.with(context).load(arrayList.get(position)).into(viewHolder.imgTH);
        return rowview;
    }
}
