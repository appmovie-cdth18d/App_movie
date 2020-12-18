package com.example.app.giaodien.TrangChu.PagePhim;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.app.Model.Phim;
import com.example.app.R;
import com.example.app.giaodien.DanhSachPhim.ChitietphimActivity;
import com.example.app.giaodien.TrangChu.ItemClickListener;

import java.util.List;


public class SliderAdapter_Phim extends RecyclerView.Adapter<SliderAdapter_Phim.SliderViewHolder> {
    private List<Phim> lstPhim;
    private Context context;

    public SliderAdapter_Phim(List<Phim> lstPhim, Context context) {
        this.lstPhim = lstPhim;
        this.context = context;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View Item = layoutInflater.inflate(R.layout.item_slide_phim,parent,false);
        return new SliderViewHolder(Item);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.img.setImageResource(lstPhim.get(position).getHinh());
        holder.txtTen.setText(lstPhim.get(position).getTen());
        holder.txtTheloai.setText(lstPhim.get(position).getTheLoai());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent t = new Intent(context, ChitietphimActivity.class);
                t.putExtra("ten",lstPhim.get(position).getTen());
                context.startActivity(t);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstPhim.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView img;
        private TextView txtTen, txtTheloai;
        private ItemClickListener itemClickListener;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_phim);
            txtTen = (TextView) itemView.findViewById(R.id.txt_ten_phim);
            txtTheloai = (TextView) itemView.findViewById(R.id.txt_theloai_phim);

            itemView.setOnClickListener(this);
        }
        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }
        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);
        }
    }
}
