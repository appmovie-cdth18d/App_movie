package com.example.app.giaodien.TrangChu.PagePhim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app.Model.Phim;
import com.example.app.Networking.MyAsyncTask;
import com.example.app.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;


public class fragment_phim_sc extends Fragment  implements LoaderManager.LoaderCallbacks<String> {
    private static final String URL_CONNECT = "http://10.0.2.2:8080/cinema_admin/api/topphim_sc";
    private LoaderManager loaderManager;
    private RecyclerView pager;
    private LinkedList<Phim> lstPhim_sc;
    private SliderAdapter_Phim sliderAdapterPhim;
    View v;

    public fragment_phim_sc() {

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
        v = inflater.inflate(R.layout.fragment_phim, container, false);
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
            LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
            pager.setLayoutManager(manager);
            sliderAdapterPhim = new SliderAdapter_Phim(lstPhim_sc, getContext());
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
