package com.example.app.giaodien.TrangChu.PagePhim;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.app.Model.Phim;
import com.example.app.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class fragment_phim_dc extends Fragment {
    private RecyclerView pager;
    private LinkedList<Phim> lstPhim;
    private SliderAdapter_Phim sliderAdapterPhim;
    private Button datve;
    View v;

    public fragment_phim_dc() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstPhim = new LinkedList<>();
        lstPhim.add(new Phim(R.drawable.ic_launcher_foreground, "Ròm", "Phim Hành Động"));
        lstPhim.add(new Phim(R.drawable.ic_launcher_foreground, "Đại Dịch Xác Sống", "Phim Kinh Dị"));
        lstPhim.add(new Phim(R.drawable.ic_launcher_foreground, "Cục Nợ Hóa Cục Cưng", "Phim Tình Cảm"));
        lstPhim.add(new Phim(R.drawable.ic_launcher_foreground, "Vì Sao Đưa Bạn Tới", "Phim Hoat Hình"));
        lstPhim.add(new Phim(R.drawable.ic_launcher_foreground, "Phi Vụ Hoàn Lương", "Phim Hành Động"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_phim, container, false);
        pager = (RecyclerView) v.findViewById(R.id.page_phim);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        pager.setLayoutManager(manager);
        sliderAdapterPhim = new SliderAdapter_Phim(lstPhim, getContext());
        pager.setClipToPadding(false);
        pager.setClipChildren(false);
        pager.setAdapter(sliderAdapterPhim);
        return  v;
    }
}