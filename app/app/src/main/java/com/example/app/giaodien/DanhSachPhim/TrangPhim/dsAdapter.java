package com.example.app.giaodien.DanhSachPhim.TrangPhim;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.app.giaodien.TrangChu.PagePhim.fragment_phim_dc;
import com.example.app.giaodien.TrangChu.PagePhim.fragment_phim_sc;

public class dsAdapter extends FragmentStatePagerAdapter {
    int numPage;

    public dsAdapter(@NonNull FragmentManager fm, int numPage) {
        super(fm, numPage);
        this.numPage = numPage;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new frag_fiml_dc();
            case 1:
                return new frag_fiml_sc();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numPage;
    }
}