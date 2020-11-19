package com.example.app.giaodien.TrangChu;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.R;
import com.google.android.material.tabs.TabLayout;

public class fragment_TrangChu extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    View v;
    public fragment_TrangChu() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_trang_chu, container, false);
        //Ánh xạ dữ liệu
        tabLayout = (TabLayout)v.findViewById(R.id.tabLayout);
        //tạo TabLayout
        tabLayout.addTab(tabLayout.newTab().setText("Phim Dang Chieu"));
        tabLayout.addTab(tabLayout.newTab().setText("Phim Sap Chieu"));

        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) v.findViewById(R.id.pagePhim);
        pageAdapter = new PageAdapter(getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return v;
    }

}