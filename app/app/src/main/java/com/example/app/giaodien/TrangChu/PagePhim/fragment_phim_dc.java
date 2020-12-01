package com.example.app.giaodien.TrangChu.PagePhim;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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
import java.util.List;


public class fragment_phim_dc extends Fragment {
    private ViewPager2 pager;
    private List<Phim> lstPhim;
    private SliderAdapter_Phim sliderAdapterPhim;
    private Button datve;
    View v;

    public fragment_phim_dc() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstPhim = new ArrayList<>();
        lstPhim.add(new Phim(R.mipmap.movie_0, "Ròm", "Phim Hành Động"));
        lstPhim.add(new Phim(R.mipmap.movie_1, "Đại Dịch Xác Sống", "Phim Kinh Dị"));
        lstPhim.add(new Phim(R.mipmap.movie_2, "Cục Nợ Hóa Cục Cưng", "Phim Tình Cảm"));
        lstPhim.add(new Phim(R.mipmap.movie_3, "Vì Sao Đưa Bạn Tới", "Phim Hoat Hình"));
        lstPhim.add(new Phim(R.mipmap.movie_4, "Phi Vụ Hoàn Lương", "Phim Hành Động"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_phim, container, false);
        pager = (ViewPager2) v.findViewById(R.id.page_phim);
        sliderAdapterPhim = new SliderAdapter_Phim(lstPhim, pager);
        pager.setAdapter(sliderAdapterPhim);
        pager.setClipToPadding(false);
        pager.setClipChildren(false);
        pager.setOffscreenPageLimit(3);
        pager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        pager.setPageTransformer(compositePageTransformer);
        return v;
    }
}