package com.example.app.giaodien.DanhSachPhim.TrangPhim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
import java.util.List;

public class frag_fiml_dc extends Fragment implements LoaderManager.LoaderCallbacks<String>{
    private static final String URL_CONNECT = "http://192.168.1.4:8080/cinema_admin/api/topphim_dc";
    private LoaderManager loaderManager;

    private RecyclerView pager;
    private List<Phim> lstPhim_dc;
    private fimlAdapter sliderAdapterPhim;
    View v;

    public frag_fiml_dc() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstPhim_dc = new LinkedList<>();

        Bundle bundle = new Bundle();
        bundle.putString("url", URL_CONNECT);
        loaderManager = LoaderManager.getInstance(this);
        loaderManager.initLoader(1, bundle, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.list_phim, container, false);
        pager = (RecyclerView) v.findViewById(R.id.page_phim);


        return  v;
    }
    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new MyAsyncTask(getContext(), args.getString("url"));
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        JSONArray arr_phim = null;
        try {
            arr_phim = new JSONArray(data);
            JSONObject phim;

            int ID, Diem;
            String Hinhanh, Tenphim, ThoiGianChieu, NgayKhoiChieu, DoTuoi;
            int len = arr_phim.length();
            for (int i = 0; i < len; i++) {
                    phim = (JSONObject) arr_phim.get(i);

                    ID = phim.getInt("id");
                    Diem = phim.getInt("Diem");
                    Hinhanh = phim.getString("Hinhanh");
                    Tenphim = phim.getString("Tenphim");
                    ThoiGianChieu = phim.getString("ThoiGianChieu");
                    NgayKhoiChieu = phim.getString("NgayKhoiChieu");
                    DoTuoi = phim.getString("DoTuoi");

                    lstPhim_dc.add(new Phim(ID, Diem, Hinhanh, Tenphim, ThoiGianChieu,NgayKhoiChieu,DoTuoi));
            }
            LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
            pager.setLayoutManager(manager);
            sliderAdapterPhim = new fimlAdapter(lstPhim_dc, getContext());
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
