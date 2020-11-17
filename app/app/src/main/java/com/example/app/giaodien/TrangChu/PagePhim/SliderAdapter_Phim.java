package com.example.app.giaodien.TrangChu.PagePhim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.app.Phim;
import com.example.app.R;

import java.util.List;


public class SliderAdapter_Phim extends RecyclerView.Adapter<SliderAdapter_Phim.SliderViewHolder> {
    private List<Phim> lstPhim;
    private ViewPager2 viewPager2;

    public SliderAdapter_Phim(List<Phim> lstPhim, ViewPager2 viewPager2) {
        this.lstPhim = lstPhim;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_slide_phim, parent, false
             )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImg(lstPhim.get(position));
        holder.setTenPhim(lstPhim.get(position));
        holder.setTheloaiPhim(lstPhim.get(position));
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView txtTen, txtTheloai;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_phim);
            txtTen = (TextView) itemView.findViewById(R.id.txt_ten_phim);
            txtTheloai = (TextView) itemView.findViewById(R.id.txt_theloai_phim);
        }

        void setImg(Phim phim) {
            img.setImageResource(phim.getHinh());
        }

        void setTenPhim(Phim phim) {
            txtTen.setText(phim.getTen());
        }

        void setTheloaiPhim(Phim phim) {
            txtTheloai.setText(phim.getTheLoai());
        }
    }
}
