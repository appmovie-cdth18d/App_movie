package com.example.app.giaodien.TrangChu.PagePhim;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.Model.Phim;
import com.example.app.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class fragment_phim_sc extends Fragment {
    private RecyclerView pager;
    private LinkedList<Phim> lstPhim;
    private SliderAdapter_Phim sliderAdapterPhim;
    View v;

    public fragment_phim_sc() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstPhim = new LinkedList<>();
        lstPhim.add(new Phim(R.drawable.ic_launcher_foreground,"Quái Vật Săn Đêm","Phim Kinh Dị"));
        lstPhim.add(new Phim(R.drawable.ic_launcher_foreground,"Chiến Binh Hồi Sinh","Phim Khoa Học Viễn Tưỡng"));
        lstPhim.add(new Phim(R.drawable.ic_launcher_foreground,"Tí Hon Hậu Đậu","Phim Hoạt Hình"));
        lstPhim.add(new Phim(R.drawable.ic_launcher_foreground,"Tay Đấm Mỹ","Phim Hành Động"));
        lstPhim.add(new Phim(R.drawable.ic_launcher_foreground,"Sóng Thần","Phim Hành Động"));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_phim, container, false);
        pager = (RecyclerView) v.findViewById(R.id.page_phim);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        pager.setLayoutManager(manager);
        sliderAdapterPhim = new SliderAdapter_Phim(lstPhim, getContext());
        pager.setClipToPadding(false);
        pager.setClipChildren(false);
        pager.setAdapter(sliderAdapterPhim);
        return v;
    }
}