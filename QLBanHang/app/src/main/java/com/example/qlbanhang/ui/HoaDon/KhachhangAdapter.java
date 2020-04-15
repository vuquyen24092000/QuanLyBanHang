package com.example.reddragon.assduan.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reddragon.assduan.DAO.KhachhangDAO;
import com.example.reddragon.assduan.Dulieu.Khachhang;
import com.example.reddragon.assduan.R;

import java.util.List;

public class KhachhangAdapter extends BaseAdapter {
    List<Khachhang> arrKhachhang;
    public Activity context;
    public LayoutInflater inflater;
    KhachhangDAO KhachhangDAO;
    public KhachhangAdapter(Activity context, List<Khachhang> arrayKhachhang) {
        super();
        this.context = context;
        this.arrKhachhang = arrayKhachhang;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        KhachhangDAO = new KhachhangDAO(context);
    }
    @Override
    public int getCount() {
        return arrKhachhang.size();
    }
    @Override
    public Object getItem(int position) {
        return arrKhachhang.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    public static class ViewHolder {
        ImageView img;
        TextView txtMaKhachhang;
        TextView txtTenKhachhang;
        ImageView imgDelete;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null)
        {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.khachhangitem, null);
            holder.img = (ImageView) convertView.findViewById(R.id.ivIcon);
            holder.txtMaKhachhang = (TextView) convertView.findViewById(R.id.tvMaKhachhang);
            holder.txtTenKhachhang = (TextView) convertView.findViewById(R.id.tvTenKhachhang);
            holder.imgDelete = (ImageView)convertView.findViewById(R.id.ivDelete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    KhachhangDAO.deleteKhachHangByID(arrKhachhang.get(position).getMaKhachhang());
                    arrKhachhang.remove(position);
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(holder);
        }
        else
            holder=(ViewHolder)convertView.getTag();
        Khachhang _entry = (Khachhang) arrKhachhang.get(position);
        if (position % 3 ==0) {
            holder.img.setImageResource(R.drawable.ss);
        }else if (position % 3 == 1){
            holder.img.setImageResource(R.drawable.kk);
        }else {
            holder.img.setImageResource(R.drawable.bookstack);
        }
        holder.txtMaKhachhang.setText(_entry.getMaKhachhang());
        holder.txtTenKhachhang.setText(_entry.getTenKhachhang());
        return convertView;
    }
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
    public void changeDataset(List<Khachhang> items){
        this.arrKhachhang = items;
        notifyDataSetChanged();
    }
}

