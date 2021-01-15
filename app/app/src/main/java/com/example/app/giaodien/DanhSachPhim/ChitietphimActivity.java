package com.example.app.giaodien.DanhSachPhim;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app.Model.BinhLuan;
import com.example.app.Model.Phim;
import com.example.app.R;
import com.example.app.giaodien.DanhSachPhim.TrangPhim.YoutubeAPI;
import com.example.app.giaodien.DanhSachPhim.TrangPhim.binhluanAdapter;
import com.example.app.giaodien.DatVeVaThanhToan.ChonGheActivity;
import com.example.app.giaodien.DatVeVaThanhToan.DatVeActivity;
import com.example.app.giaodien.TrangTimKiem.TimKiemAdapter;
import com.example.app.giaodien.TrangTimKiem.TrangTimKiem;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

import static android.widget.Toast.LENGTH_SHORT;
import static com.example.app.giaodien.DanhSachPhim.TrangPhim.YoutubeAPI.getApiKey;

public class ChitietphimActivity extends AppCompatActivity {

    private TextView txtTenPhim, txtNoiDung,txtDienVien, txtKhoiChieu, txtTheLoai, txtDaodien, txtDinhDang, txtThoiLuong, txtNgonNgu;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;

    private RecyclerView rcl;
    private binhluanAdapter binhluanAdapter;
    private LinkedList<BinhLuan> lst_BL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietphim);

        rcl = (RecyclerView)findViewById(R.id.recycler_binhluan);
        txtTenPhim = (TextView)findViewById(R.id.txtTenPhim);
        txtNoiDung = (TextView)findViewById(R.id.txtNoidung);
        txtDienVien = (TextView)findViewById(R.id.txtDienVien);
        txtKhoiChieu = (TextView)findViewById(R.id.txtKhoiChieu);
        txtTheLoai = (TextView)findViewById(R.id.txtTheLoai);
        txtDaodien = (TextView)findViewById(R.id.txtDaoDien);
        txtDinhDang = (TextView)findViewById(R.id.txtDinhDang);
        txtThoiLuong = (TextView)findViewById(R.id.txtThoiLuong);
        txtNgonNgu = (TextView)findViewById(R.id.txtNgonNgu);


        if (getIntent() != null) {
            Intent t = getIntent();
            int ID = t.getIntExtra("ID", 1);
            GetData("http://192.168.0.103:8080/cinema_admin/api/phim" + ID);
        }



        Load_BinhLuan();
    }

    public void Load_BinhLuan() {
        String url = "http://192.168.223.2:8080/";
        RequestQueue requestQueue = Volley.newRequestQueue(ChitietphimActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray arr_BL = new JSONArray(response);
                            JSONObject item_binhluan;
                            lst_BL = new LinkedList<>();

                            int ID;
                            String TaiKhoan, NoiDung, NgayDang;
                            int len = arr_BL.length();
                            for (int i = 0; i < len; i++) {
                                try {
                                    item_binhluan = (JSONObject) arr_BL.get(i);
                                    ID = item_binhluan.getInt("id");
                                    TaiKhoan = item_binhluan.getString("Taikhoan");
                                    NoiDung = item_binhluan.getString("Noidung");
                                    NgayDang = item_binhluan.getString("Ngaydang");

                                    lst_BL.add(new BinhLuan(ID, TaiKhoan, NoiDung, NgayDang));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            binhluanAdapter = new binhluanAdapter(lst_BL, getApplicationContext());
                            rcl.setAdapter(binhluanAdapter);
                            rcl.setLayoutManager(new LinearLayoutManager(ChitietphimActivity.this));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Lỗi", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(stringRequest);
    }

    public void GetData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(ChitietphimActivity.this, response, LENGTH_SHORT).show();
                        try {
                            JSONArray phim = new JSONArray(response);
                            JSONObject p = (JSONObject) phim.get(0);
                            txtTenPhim.setText("Tên phim"+ p.getString("Tenphim"));
                            txtNoiDung.setText("Nội dung: "+ p.getString("Mota"));
                            txtDienVien.setText("Diễn viên: "+ p.getString("Ds_dienvien"));
                            txtKhoiChieu.setText("Khởi chiếu" + p.getString("Ngaykhoichieu"));
                            txtTheLoai.setText("Thể loại: "+ p.getString("Tentheloai"));
                            txtDaodien.setText("Đạo diễn: "+ p.getString("Tendaodien"));
                            txtDinhDang.setText("Định dạng: "+ p.getString("LoaiDinhdang"));
                            txtThoiLuong.setText("Thời lượng: "+ p.getString("ThoiLuong"));
                            txtNgonNgu.setText("Ngôn ngữ" + p.getString("Ngonngu"));

                            onInitializedListener = new YouTubePlayer.OnInitializedListener() {
                                @Override
                                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                                    try {
                                        youTubePlayer.loadVideo(p.getString("Trailer"));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                                }
                            };
//                            youTubePlayerView.initialize(getApiKey(), onInitializedListener);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ChitietphimActivity.this, "Error Connection!!", LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest);
    }

    public void back(View view) {
        Intent intent = new Intent(ChitietphimActivity.this, DanhsachphimActivity.class);
        startActivity(intent);
    }

    public void Datve(View view) {
        Intent t = new Intent(this, DatVeActivity.class);
        startActivity(t);
    }

}