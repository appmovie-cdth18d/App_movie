package com.example.app.giaodien.TrangChu.PagePhim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.app.Model.Phim;
import com.example.app.R;

import java.util.LinkedList;


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
        lstPhim.add(new Phim(R.mipmap.cucnohoacuccung, "Ròm", "Phim Hành Động"));
        lstPhim.add(new Phim(R.mipmap.cucnohoacuccung, "Đại Dịch Xác Sống", "Phim Kinh Dị"));
        lstPhim.add(new Phim(R.mipmap.cucnohoacuccung, "Cục Nợ Hóa Cục Cưng", "Phim Tình Cảm"));
        lstPhim.add(new Phim(R.mipmap.cucnohoacuccung, "Vì Sao Đưa Bạn Tới", "Phim Hoat Hình"));
        lstPhim.add(new Phim(R.mipmap.cucnohoacuccung, "Phi Vụ Hoàn Lương", "Phim Hành Động"));
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