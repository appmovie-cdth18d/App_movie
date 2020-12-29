package com.example.app.giaodien.TrangTimKiem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.Model.Phim;
import com.example.app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TimKiemAdapter extends RecyclerView.Adapter<TimKiemAdapter.TimPhimViewHolder> implements Filterable {
    private List<Phim> lstPhim;
    private List<Phim> lstPhim_Filter;
    private Context context;

    public TimKiemAdapter(List<Phim> lstPhim, Context context) {
        this.lstPhim = lstPhim;
        this.context = context;
        this.lstPhim_Filter = lstPhim;
    }

    // --------- Search Filter ----------
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String char_search = constraint.toString(); //Chuỗi nhập vào

                //Kiểm tra chuỗi nhập vào
                if (char_search.isEmpty()) lstPhim_Filter = lstPhim; // Nếu chuỗi nhập là rỗng thì ds filter = là ds hiện tại
                else {
                    List<Phim> filter = new LinkedList<>();
                    for (Phim item_phim : lstPhim) {
                        if (item_phim.getTen().toUpperCase().contains(char_search.toUpperCase()) ||
                                item_phim.getTen().toLowerCase().contains(char_search.toLowerCase())) {
                            filter.add(item_phim);
                        }
                    }

                    lstPhim_Filter = filter; // Ds Filter là ds các item vừa tìm được
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = lstPhim_Filter;

                return filterResults;  // Trả về ds KQ là ds Filter
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                lstPhim_Filter = (List<Phim>) results.values;
                notifyDataSetChanged();
            }
        };
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
        Phim phim = lstPhim_Filter.get(position);
        Picasso.with(context)
                .load("http://192.168.137.43:8080/WebAdmin1/public/Image/" + phim.getHinh())
                .placeholder(R.drawable.hai_phuong)
                .into(holder.Hinhanh);
        holder.TenPhim.setText(phim.getTen());
        holder.TheLoai.setText(phim.getTheLoai());
    }

    @Override
    public int getItemCount() {
        return lstPhim_Filter.size();
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
