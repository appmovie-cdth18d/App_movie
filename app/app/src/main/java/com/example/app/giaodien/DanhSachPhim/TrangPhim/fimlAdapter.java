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
import com.example.app.giaodien.TrangChu.PagePhim.SliderAdapter_Phim;
import com.example.app.giaodien.TrangTimKiem.TimKiemAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class fimlAdapter extends RecyclerView.Adapter<fimlAdapter.fimViewHolder> {
    private List<Phim> lstPhim;
    private Context context;

    public fimlAdapter(List<Phim> lstPhim, Context context) {
        this.lstPhim = lstPhim;
        this.context = context;
    }

    @NonNull
    @Override
    public fimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View Item = layoutInflater.inflate(R.layout.phim,parent,false);
        return new fimViewHolder(Item);
    }

    @Override
    public void onBindViewHolder(@NonNull fimlAdapter.fimViewHolder holder, int position) {
        Picasso.with(context)
                .load("http://192.168.137.43:8080/WebAdmin1/public/Image/" + lstPhim.get(position).getHinh())
                .placeholder(R.drawable.nam)
                .into(holder.Hinhanh);
        holder.TenPhim.setText(lstPhim.get(position).getTen());
        holder.ThoiGianChieu.setText(lstPhim.get(position).getTen());
        holder.NgayKhoiChieu.setText(lstPhim.get(position).getTen());
        holder.DoTuoi.setText(lstPhim.get(position).getTen());
        holder.Diem.setText(lstPhim.get(position).getTen());


        holder.setItemclickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent t = new Intent(context, ChitietphimActivity.class);
                t.putExtra("ID", lstPhim.get(position).getTen());
                context.startActivity(t);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstPhim.size();
    }


    public class fimViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView Hinhanh;
        TextView TenPhim , ThoiGianChieu, NgayKhoiChieu, DoTuoi, Diem;
        ItemClickListener itemClickListener;

        public fimViewHolder(@NonNull View itemView) {
            super(itemView);
            Hinhanh = (ImageView) itemView.findViewById(R.id.imgPhim);
            TenPhim = (TextView) itemView.findViewById(R.id.txtTenPhim);
            ThoiGianChieu = (TextView) itemView.findViewById(R.id.txtTimeChieu);
            NgayKhoiChieu = (TextView) itemView.findViewById(R.id.txtNgayKhoiChieu);
            DoTuoi = (TextView) itemView.findViewById(R.id.txtDoTuoi);
            Diem = (TextView) itemView.findViewById(R.id.txtDiem);
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
