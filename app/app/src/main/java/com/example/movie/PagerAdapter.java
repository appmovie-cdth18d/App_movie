package com.example.movie;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTab;

    public PagerAdapter(@NonNull FragmentManager fm, int mNumOfTab) {
        super(fm, mNumOfTab);
        this.mNumOfTab = mNumOfTab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new phim_dang_chieu();
            case 1: return new phim_sap_chieu();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTab;
    }
}
