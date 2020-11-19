package com.example.app.giaodien.TrangTimKiem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.Model.Phim;
import com.example.app.R;

import java.util.List;

public class TimKiemAdapter extends RecyclerView.Adapter<TimKiemAdapter.TimKiemViewholder>{
    private List<Phim> lstPhim;
    private RecyclerView recyclerView;

    public TimKiemAdapter(List<Phim> lstPhim, RecyclerView recyclerView) {
        this.lstPhim = lstPhim;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public TimKiemViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TimKiemViewholder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_phim, parent, false
            )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull TimKiemViewholder holder, int position) {
            holder.setImgPhim(lstPhim.get(position));
            holder.setTxtTen(lstPhim.get(position));
            holder.setTxtTheloai(lstPhim.get(position));
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class TimKiemViewholder extends RecyclerView.ViewHolder{
        ImageView imgPhim;
        TextView txtTen, txtTheloai;
        public TimKiemViewholder(@NonNull View itemView) {
            super(itemView);
            imgPhim = (ImageView)itemView.findViewById(R.id.imgPhim);
            txtTen = (TextView)itemView.findViewById(R.id.txt_tieude);
            txtTheloai = (TextView)itemView.findViewById(R.id.txtTheloai);
        }
        void setImgPhim(Phim phim){imgPhim.setImageResource(phim.getHinh());}
        void setTxtTen(Phim phim){txtTen.setText(phim.getTen());}
        void setTxtTheloai(Phim phim){txtTheloai.setText(phim.getTheLoai());}
    }
}
