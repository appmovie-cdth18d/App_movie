package com.example.app.giaodien.TrangChu.PagePhim;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;


import com.example.app.Model.Phim;
import com.example.app.Networking.MyAsyncTask;
import com.example.app.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;


public class fragment_phim_sc extends Fragment implements LoaderManager.LoaderCallbacks<String> {

    private static final String URL_CONNECT = "http://10.0.2.2:8080/cinema_admin/api/topphim_sc";
    private LoaderManager loaderManager;
    private Handler SlideHanlder = new Handler();
    private ViewPager2 pager;
    private LinkedList<Phim> lstPhim_sc;
    private SliderAdapter_Phim sliderAdapterPhim;
    View v;

    public fragment_phim_sc() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_phim, container, false);

        pager = (ViewPager2) v.findViewById(R.id.page_phim);

        Bundle bundle = new Bundle();
        bundle.putString("url", URL_CONNECT);
        loaderManager = LoaderManager.getInstance(this);
        loaderManager.initLoader(1, bundle, this);

        pager.setClipToPadding(false);
        pager.setClipChildren(false);
        pager.setOffscreenPageLimit(3);
        pager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(20));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        pager.setPageTransformer(compositePageTransformer);
        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                SlideHanlder.removeCallbacks(SlideRunable);
                SlideHanlder.postDelayed(SlideRunable, 3000);
            }
        });
        return v;
    }

    private Runnable SlideRunable = new Runnable() {
        @Override
        public void run() {
            pager.setCurrentItem(pager.getCurrentItem() + 1);
        }
    };

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new MyAsyncTask(getContext(), args.getString("url"));
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        lstPhim_sc = new LinkedList<>();
        try {
            JSONArray arr_Phim = null;
            arr_Phim = new JSONArray(data);
            JSONObject phim;
            int ID_phim, Diem;
            String Hinhanh, Tenphim, Theloai;

            int len = arr_Phim.length();
            for (int i = 0; i < len; i++) {

                phim = (JSONObject) arr_Phim.get(i);

                ID_phim = phim.getInt("id");
                Diem = phim.getInt("Diem");
                Hinhanh = phim.getString("Hinhanh");
                Tenphim = phim.getString("Tenphim");
                Theloai = phim.getString("Tentheloai");

                lstPhim_sc.add(new Phim(ID_phim, Diem, Hinhanh, Tenphim, Theloai));
            }
            sliderAdapterPhim = new SliderAdapter_Phim(lstPhim_sc, pager, getContext());
            pager.setAdapter(sliderAdapterPhim);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}
