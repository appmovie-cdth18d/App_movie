package com.example.app.giaodien.TrangTimKiem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.Model.Phim;
import com.example.app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TimKiemAdapter extends RecyclerView.Adapter<TimKiemAdapter.TimPhimViewHolder> {
    private List<Phim> lstPhim;
    private Context context;

    public TimKiemAdapter(List<Phim> lstPhim, Context context) {
        this.lstPhim = lstPhim;
        this.context = context;
    }

    @NonNull
    @Override
    public TimPhimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TimPhimViewHolder(LayoutInflater.from(context).inflate(
                R.layout.item_phim, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull TimPhimViewHolder holder, int position) {
        Phim phim = lstPhim.get(position);
        Picasso.with(context)
                .load("http://192.168.43.222:8080/WebAdmin/public/Image/" + phim.getHinh())
                .placeholder(R.drawable.hai_phuong)
                .into(holder.Hinhanh);
        holder.TenPhim.setText(phim.getTen());
        holder.TheLoai.setText(phim.getTheLoai());
    }

    @Override
    public int getItemCount() {
        return lstPhim.size();
    }

    public class TimPhimViewHolder extends RecyclerView.ViewHolder {
        ImageView Hinhanh;
        TextView TenPhim, TheLoai;

        public TimPhimViewHolder(@NonNull View itemView) {
            super(itemView);
            Hinhanh = (ImageView) itemView.findViewById(R.id.imgPhim);
            TenPhim = (TextView) itemView.findViewById(R.id.txt_tieude);
            TheLoai = (TextView) itemView.findViewById(R.id.txt_theloai);
        }
    }
}
