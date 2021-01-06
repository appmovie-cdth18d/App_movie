package com.example.app.giaodien.DanhSachPhim;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app.MainActivity;
import com.example.app.Model.Phim;
import com.example.app.R;
import com.example.app.giaodien.DanhSachPhim.TrangPhim.fimlAdapter;
import com.example.app.giaodien.ThongTinKhachHang.ThongTinKhachHang;
import com.example.app.giaodien.TrangChu.Trangchu;
import com.example.app.giaodien.TrangTimKiem.TimKiemAdapter;
import com.example.app.giaodien.TrangTimKiem.TrangTimKiem;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class DanhsachphimActivity extends AppCompatActivity {

    private List<Phim> filter_phim;
    private List<Phim> lstPhim;

    private RecyclerView rcl_phim;
    private fimlAdapter fimlAdapter;

    private NavigationView nav;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachphim);

        rcl_phim = (RecyclerView) findViewById(R.id.recycler);

        Menu();
        Load_data("http://192.168.137.43:8080/WebAdmin1/api/phim");

    }

    public void Load_data(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray arr_Phim = new JSONArray(response);
                            JSONObject item_phim;
                            lstPhim = new LinkedList<>();

                            int ID, Diem;
                            String Hinhanh, Tenphim, ThoiGianChieu, NgayKhoiChieu, DoTuoi;
                            int len = arr_Phim.length();
                            for (int i = 0; i < len; i++) {
                                try {
                                    item_phim = (JSONObject) arr_Phim.get(i);
                                    ID = item_phim.getInt("id");
                                    Diem = item_phim.getInt("Diem");
                                    Hinhanh = item_phim.getString("Hinhanh");
                                    Tenphim = item_phim.getString("Tenphim");
                                    ThoiGianChieu = item_phim.getString("ThoiGianChieu");
                                    NgayKhoiChieu = item_phim.getString("NgayKhoiChieu");
                                    DoTuoi = item_phim.getString("DoTuoi");

                                    lstPhim.add(new Phim(ID, Diem, Hinhanh, Tenphim, ThoiGianChieu,NgayKhoiChieu,DoTuoi));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            fimlAdapter = new fimlAdapter(lstPhim, getApplicationContext());
                            rcl_phim.setAdapter(fimlAdapter);
                            rcl_phim.setLayoutManager(new LinearLayoutManager(DanhsachphimActivity.this));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Lỗi kết nối", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(stringRequest);
    }
    public void Menu() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawable_timkiem);
        toolbar = (Toolbar) findViewById(R.id.toolbar_timkiem);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        nav = (NavigationView) findViewById(R.id.navView_timkiem);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Intent t;
                switch (id) {
                    case R.id.home:
                        t = new Intent(getApplicationContext(), Trangchu.class);
                        startActivity(t);
                        drawerLayout.closeDrawer(nav);
                        break;
                    case R.id.canhan:
                        t = new Intent(getApplicationContext(), ThongTinKhachHang.class);
                        startActivity(t);
                        drawerLayout.closeDrawer(nav);
                        break;
                    case R.id.ve_phim:
                        t = new Intent(getApplicationContext(), DanhsachphimActivity.class);
                        startActivity(t);
                        drawerLayout.closeDrawer(nav);
                        break;
                    case R.id.dangxuat:
                        t = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(t);
                        drawerLayout.closeDrawer(nav);
                        break;
                    default:
                        return true;
                }
                return false;
            }
        });
    }
}