package com.example.app.giaodien.TrangChu.PagePhim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app.Model.Phim;
import com.example.app.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;


public class fragment_phim_dc extends Fragment {
    private RecyclerView pager;
    private List<Phim> lstPhim_dc;
    private SliderAdapter_Phim sliderAdapterPhim;
    private Button datve;
    View v;

    public fragment_phim_dc() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstPhim_dc = new LinkedList<>();
        Load_phim_dc("http://192.168.7.31:8080/WebAdmin/api/phim_dc");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_phim, container, false);
        pager = (RecyclerView) v.findViewById(R.id.page_phim);


        return  v;
    }

    private void Load_phim_dc(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest ds_phim_dc = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray arr_phim = new JSONArray(response);
                            JSONObject phim;
                            int ID_phim, Diem;
                            String Hinhanh, Tenphim, Theloai;

                            int len = arr_phim.length();
                            for (int i = 0; i < len; i++) {
                                phim = (JSONObject) arr_phim.get(i);
                                ID_phim = phim.getInt("id");
                                Diem = phim.getInt("Diem");
                                Hinhanh = phim.getString("Hinhanh");
                                Tenphim = phim.getString("Tenphim");
                                Theloai = phim.getString("Tentheloai");
                                lstPhim_dc.add(new Phim(ID_phim, Diem, Hinhanh,Tenphim, Theloai));
                            }
                            LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                            pager.setLayoutManager(manager);
                            sliderAdapterPhim = new SliderAdapter_Phim(lstPhim_dc, getContext());
                            pager.setClipToPadding(false);
                            pager.setClipChildren(false);
                            pager.setAdapter(sliderAdapterPhim);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "Lỗi Kết nối phim đang chiếu !!", Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(ds_phim_dc);
    }
}