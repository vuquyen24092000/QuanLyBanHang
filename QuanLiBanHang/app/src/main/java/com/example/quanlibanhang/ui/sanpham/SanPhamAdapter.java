package com.example.quanlibanhang.ui.sanpham;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlibanhang.R;
//import com.squareup.picasso.Picasso;


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
        ImageView imgSP;
        TextView tenSP, HSD, giaBan, moTa;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowview = convertView;
        ViewHolder viewHolder = new ViewHolder();

        if (rowview == null) {
            rowview = inflater.inflate(myLayout, null);
            viewHolder.tenSP = (TextView) rowview.findViewById(R.id.tvTenSP);
            viewHolder.HSD = (TextView) rowview.findViewById(R.id.tvHSD);
            viewHolder.giaBan = (TextView) rowview.findViewById(R.id.tvGiaBan);
            viewHolder.moTa = (TextView) rowview.findViewById(R.id.tvMoTa);
            viewHolder.imgSP = (ImageView) rowview.findViewById(R.id.imgSP);
            rowview.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) rowview.getTag();
        }
        viewHolder.tenSP.setText(arrayList.get(position).tenSP);
        viewHolder.HSD.setText(arrayList.get(position).HSD);
        viewHolder.giaBan.setText("" + arrayList.get(position).giaBan);
        viewHolder.moTa.setText(arrayList.get(position).moTaSP);
        //Picasso.get().load(arrayList.get(position).linkAnhSP).into(viewHolder.imgSP);
        return rowview;
    }
}

