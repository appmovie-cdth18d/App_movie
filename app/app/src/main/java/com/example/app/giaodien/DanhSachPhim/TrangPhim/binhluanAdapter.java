package com.example.app.giaodien.DanhSachPhim.TrangPhim;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.Model.BinhLuan;
import com.example.app.R;
import com.example.app.giaodien.DanhSachPhim.ChitietphimActivity;
import com.example.app.giaodien.ItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class binhluanAdapter extends RecyclerView.Adapter<binhluanAdapter.binhluanViewHolder> {
    private List<BinhLuan> lst_BL;
    private Context context;

    public binhluanAdapter(List<BinhLuan> lst_BL, Context context){
        this.lst_BL = lst_BL;
        this.context = context;
    }

    @NonNull
    @Override
    public binhluanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new binhluanViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.binhluan_phim, parent, false
        )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull binhluanViewHolder holder, int position) {
        holder.TaiKhoan.setText(lst_BL.get(position).getTaiKhoan());
        holder.NoiDung.setText(lst_BL.get(position).getNoiDung());
        holder.NgayDang.setText(lst_BL.get(position).getNgayDang());
    }

    @Override
    public int getItemCount() {
        return lst_BL.size();
    }

    public static class binhluanViewHolder extends RecyclerView.ViewHolder {
        TextView TaiKhoan,NoiDung,NgayDang;
        public binhluanViewHolder(@NonNull View itemView) {
            super(itemView);
            TaiKhoan = (TextView) itemView.findViewById(R.id.txt_TenKH);
            NoiDung = (TextView) itemView.findViewById(R.id.txt_noidungBL);
            NgayDang = (TextView) itemView.findViewById(R.id.txtTime);
        }
    }
}
