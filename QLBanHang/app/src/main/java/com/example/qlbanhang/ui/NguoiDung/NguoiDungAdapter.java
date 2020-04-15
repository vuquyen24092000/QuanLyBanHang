package com.example.qlbanhang.ui.NguoiDung;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.qlbanhang.R;

import java.util.List;

public class NguoiDungAdapter extends RecyclerView.Adapter<NguoiDungAdapter.ViewHolder> {
    List<NguoiDung> list;
    Context context;
    NguoiDungDAO nguoiDungDAO;
    Database database;

    public NguoiDungAdapter(List<NguoiDung> list, Context context) {
        this.list = list;
        this.context = context;
        //database=database = Room.databaseBuilder(getActivity().getApplicationContext(),Database.class,"NguoiDung").allowMainThreadQueries().build();
        nguoiDungDAO = new NguoiDungDAO() {
            @Override
            public List<NguoiDung> getAll() {
                return getAll();
            }

            @Override
            public long[] insertNguoiDung(NguoiDung... nguoiDung) {
                return new long[0];
            }

            @Override
            public int deleteNguoiDung(NguoiDung nguoiDung) {
                return 0;
            }

            @Override
            public int updateNguoiDung(NguoiDung nguoiDung) {
                return 0;
            }
        };
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final NguoiDung nguoiDung = list.get(position);
        holder.tvUsername.setText(nguoiDung.getUsername());
        holder.tvPassword.setText(nguoiDung.getPassword());
        holder.tvHoten.setText(nguoiDung.getHoTen());
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(nguoiDung);
                nguoiDungDAO.deleteNguoiDung(nguoiDung);
                notifyDataSetChanged();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    //context (activity) và du lieu
                    Context context = v.getContext();
                    Intent intent=new Intent(context, ThemNguoiDungActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("username",list.get(position).getUsername());
                    intent.putExtra("bundle",bundle);
                    context.startActivity(intent);
                } catch (Exception e){
                    Log.e("Lỗi",nguoiDung.getUsername());
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvUsername, tvPassword, tvHoten;
        ImageView imgDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvPassword = itemView.findViewById(R.id.tvPassword);
            tvHoten = itemView.findViewById(R.id.tvHoten);
            imgDelete = itemView.findViewById(R.id.imgDeleteUser);
        }
    }
}
