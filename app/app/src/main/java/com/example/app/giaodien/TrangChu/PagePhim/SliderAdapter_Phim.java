package com.example.app.giaodien.TrangChu.PagePhim;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.app.Model.Phim;
import com.example.app.R;
import com.example.app.giaodien.DanhSachPhim.ChitietphimActivity;
import com.squareup.picasso.Picasso;

import java.util.List;


public class SliderAdapter_Phim extends RecyclerView.Adapter<SliderAdapter_Phim.SliderViewHolder> {
    private List<Phim> lstPhim;
    private ViewPager2 viewPager2;
    private Context context;
    public SliderAdapter_Phim(List<Phim> lstPhim, ViewPager2 viewPager2, Context context) {
        this.lstPhim = lstPhim;
        this.viewPager2 = viewPager2;
        this.context = context;
    }



    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(LayoutInflater.from(context).inflate(
                R.layout.item_slide_phim, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        Phim p = lstPhim.get(position);
        Picasso.with(context)
                .load("http://10.0.2.2:8080/cinema_admin/public/Image/"+p.getHinh())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.img);
        holder.setTxtTenPhim(p);
        holder.setTxtTheLoai(p);
        holder.setTxtDiem(p);
        holder.layoutPhim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Send_ID_Phim = new Intent(context, ChitietphimActivity.class);
                Send_ID_Phim.putExtra("ID_phim", p.getID());
                context.startActivity(Send_ID_Phim);
            }
        });

        if(position == lstPhim.size() - 2){
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return lstPhim.size();
    }

    public class SliderViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txtTenPhim, txtTheLoai, txtDiem;
        ConstraintLayout layoutPhim;
        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_phim);
            txtTenPhim = (TextView) itemView.findViewById(R.id.txt_ten_phim);
            txtTheLoai = (TextView) itemView.findViewById(R.id.txt_theloai_phim);
            txtDiem = (TextView) itemView.findViewById(R.id.txtDiem);
            layoutPhim = (ConstraintLayout) itemView.findViewById(R.id.layout_itemPhim);
        }
       void setTxtTenPhim (Phim p) { txtTenPhim.setText(p.getTen());}
       void setTxtTheLoai (Phim p) { txtTheLoai.setText(p.getTheLoai());}
       void setTxtDiem (Phim p) { txtDiem.setText(""+p.getDiem());}

    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            lstPhim.addAll(lstPhim);
            notifyDataSetChanged();
        }
    };
}
