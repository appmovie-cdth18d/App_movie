package com.example.app.giaodien.DanhSachPhim.TrangPhim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.Model.Phim;
import com.example.app.Networking.MyAsyncTask;
import com.example.app.R;
import com.example.app.giaodien.TrangChu.PagePhim.SliderAdapter_Phim;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class frag_fiml_sc extends Fragment implements LoaderManager.LoaderCallbacks<String> {
    private static final String URL_CONNECT = "http://10.0.2.2:8080/cinema_admin/api/topphim_sc";
    private LoaderManager loaderManager;
    private RecyclerView pager;
    private LinkedList<Phim> lstPhim_sc;
    private fimlAdapter sliderAdapterPhim;
    View v;

    public frag_fiml_sc() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstPhim_sc = new LinkedList<>();

        Bundle bundle = new Bundle();
        bundle.putString("url", URL_CONNECT);
        loaderManager = LoaderManager.getInstance(this);
        loaderManager.initLoader(1, bundle, this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.list_phim, container, false);
        pager = (RecyclerView) v.findViewById(R.id.page_phim);


        return v;
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new MyAsyncTask(getContext(), args.getString("url"));
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            JSONArray arr_Phim = new JSONArray(data);
            JSONObject phim;

            int ID, Diem;
            String Hinhanh, Tenphim, ThoiGianChieu, NgayKhoiChieu, DoTuoi;
            int len = arr_Phim.length();
            for (int i = 0; i < len; i++) {
                phim = (JSONObject) arr_Phim.get(i);

                ID = phim.getInt("id");
                Diem = phim.getInt("Diem");
                Hinhanh = phim.getString("Hinhanh");
                Tenphim = phim.getString("Tenphim");
                ThoiGianChieu = phim.getString("ThoiGianChieu");
                NgayKhoiChieu = phim.getString("NgayKhoiChieu");
                DoTuoi = phim.getString("DoTuoi");

                lstPhim_sc.add(new Phim(ID, Diem, Hinhanh, Tenphim, ThoiGianChieu,NgayKhoiChieu,DoTuoi));
            }
            LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
            pager.setLayoutManager(manager);
            sliderAdapterPhim = new fimlAdapter(lstPhim_sc, getContext());
            pager.setClipToPadding(false);
            pager.setClipChildren(false);
            pager.setAdapter(sliderAdapterPhim);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}
