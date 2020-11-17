package com.example.app.giaodien.TrangChu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.app.giaodien.TrangChu.PagePhim.fragment_phim_dc;
import com.example.app.giaodien.TrangChu.PagePhim.fragment_phim_sc;

public class PageAdapter extends FragmentStatePagerAdapter {
    int numPage;

    public PageAdapter(@NonNull FragmentManager fm, int numPage) {
        super(fm, numPage);
        this.numPage = numPage;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new fragment_phim_dc();
            case 1:
                return new fragment_phim_sc();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numPage;
    }
}
