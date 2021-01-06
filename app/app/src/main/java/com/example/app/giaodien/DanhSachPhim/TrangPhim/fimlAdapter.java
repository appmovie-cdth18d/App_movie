package com.example.app.giaodien.DanhSachPhim.TrangPhim;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.Model.Phim;
import com.example.app.R;
import com.example.app.giaodien.DanhSachPhim.ChitietphimActivity;
import com.example.app.giaodien.ItemClickListener;
import com.example.app.giaodien.TrangTimKiem.TimKiemAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class fimlAdapter extends RecyclerView.Adapter<fimlAdapter.fimViewHolder> {
    private List<Phim> lstPhim;
    private List<Phim> lstPhim_Filter;
    private Context context;

    public fimlAdapter(List<Phim> lstPhim, Context context) {
        this.lstPhim = lstPhim;
        this.context = context;
        this.lstPhim_Filter = lstPhim;
    }

    @NonNull
    @Override
    public fimlAdapter.fimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new fimlAdapter.fimViewHolder(LayoutInflater.from(context).inflate(
                R.layout.list_phim, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull fimlAdapter.fimViewHolder holder, int position) {
        Phim phim = lstPhim_Filter.get(position);
        Picasso.with(context)
                .load("http://192.168.137.43:8080/WebAdmin1/public/Image/" + phim.getHinh())
                .placeholder(R.drawable.hai_phuong)
                .into(holder.Hinhanh);
        holder.TenPhim.setText(phim.getTen());

        holder.setItemclickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent t = new Intent(context, ChitietphimActivity.class);
                t.putExtra("ID", phim.getID());
                context.startActivity(t);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstPhim_Filter.size();
    }


    public class fimViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView Hinhanh;
        TextView TenPhim;
        ItemClickListener itemClickListener;

        public fimViewHolder(@NonNull View itemView) {
            super(itemView);
            Hinhanh = (ImageView) itemView.findViewById(R.id.imgPhim);
            TenPhim = (TextView) itemView.findViewById(R.id.txtTenPhim);

            itemView.setOnClickListener(this);
        }

        public void setItemclickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);
        }
    }

}
