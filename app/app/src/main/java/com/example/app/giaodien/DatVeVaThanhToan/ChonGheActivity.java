package com.example.app.giaodien.DatVeVaThanhToan;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.DrawFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app.MainActivity;
import com.example.app.R;
import com.example.app.giaodien.DanhSachPhim.DanhsachphimActivity;
import com.example.app.giaodien.ThongTinKhachHang.SuaThongTin;
import com.example.app.giaodien.ThongTinKhachHang.TaiKhoan;
import com.example.app.giaodien.ThongTinKhachHang.ThongTinKhachHang;
import com.example.app.giaodien.TrangTimKiem.TrangTimKiem;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.function.ToIntBiFunction;

public class ChonGheActivity extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    TextView ghe;
    DrawerLayout drawerLayout;
    String tenphim, tenrap, chinhanh, ngaychieu;
    String giochieu;
    private int phim_id, suatchieu_id;
    private int rap_id, tongtien = 0, soluong;
    private ArrayList<Integer> soluongghe, giatienghe;
    private ArrayList<String> tencacghe;
    Button chonghe;
    String url = "http://192.168.64.2/WebAdmin/api/ghe";
    String urlve = "http://192.168.64.2/WebAdmin/api/ve";
    private ArrayList<Ghe> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_ghe);
        ghe = findViewById(R.id.soghe);
        Intent intent = getIntent();;
        tenphim = intent.getStringExtra("tenphim");
        tenrap = intent.getStringExtra("tenrap");
        chinhanh = intent.getStringExtra("chinhanh");
        ngaychieu = intent.getStringExtra("ngaychieu");
        giochieu = intent.getStringExtra("giochieu");
        phim_id = intent.getIntExtra("phim_id", 0);
        rap_id = intent.getIntExtra("rap_id", 0);
        suatchieu_id = intent.getIntExtra("suatchieu_id", 0);
        soluongghe = new ArrayList<>();
        tencacghe = new ArrayList<>();
        giatienghe = new ArrayList<>();
        final ArrayList<Integer> gheid = new ArrayList<>();
        list = new ArrayList<>();
        final GridView gridView = (GridView) findViewById(R.id.gridView);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_chonghe);
        toolbar = (Toolbar) findViewById(R.id.toolbar_chonghe);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        nav = (NavigationView) findViewById(R.id.navView_chonghe);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Intent t;
                switch (id) {
                    case R.id.home:
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


        //API
        RequestQueue requestQueue = Volley.newRequestQueue(ChonGheActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jr = new JSONArray(response);
                            JSONObject jb;
                            int n = jr.length();
                            int Loaighe_id;
                            int rap_id;
                            int trangthai;
                            int giaghe;
                            int id;
                            for (int i = 0; i < n; i++) {
                                jb = jr.getJSONObject(i);
                                if(jb.getInt("rap_id") == 1) {
                                    String Soghe = jb.get("Soghe").toString();
                                    Loaighe_id = jb.getInt("Loaighe_id");
                                    rap_id = jb.getInt("rap_id");
                                    trangthai = jb.getInt("Trangthai");
                                    giaghe = jb.getInt("giatien");
                                    id = jb.getInt("id");
                                    list.add(new Ghe(id,Soghe, Loaighe_id, rap_id, trangthai, giaghe));
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        gridView.setAdapter(new GidAdapter(getApplicationContext(), list));
                        gridView.setBackgroundResource(R.color.nomo);
                        gridView.invalidate();
                        //API lấy vé đã mua
                        RequestQueue requestQueue = Volley.newRequestQueue(ChonGheActivity.this);
                        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlve,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        try {
                                            JSONArray jr = new JSONArray(response);
                                            JSONObject jb;
                                            int n = jr.length();
                                            int rap_id_, suatchieu_id_;
                                            int gheid_;
                                            for (int h = 0; h < n; h++){
                                                jb = jr.getJSONObject(h);
                                                rap_id_ = jb.getInt("rap_id");
                                                suatchieu_id_ = jb.getInt("suatchieu_id");
                                                if(rap_id_ == rap_id_)
                                                {
                                                    if (suatchieu_id_ == suatchieu_id)
                                                    {
                                                        gheid_ = jb.getInt("ghe_id");
                                                        for (int i = 0; i < list.size(); i++)
                                                        {
                                                            if (list.get(i).getId() == gheid_) {
                                                                list.get(i).setTrangthai_(2);
                                                                gridView.getChildAt(i).setBackgroundResource(R.color.nomi);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Toast.makeText(getApplicationContext(), "Erorr!",Toast.LENGTH_LONG).show();
                                    }
                                }
                        );
                        requestQueue.add(stringRequest);
                        //
                        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            public void onItemClick(
                                    AdapterView<?> arg0,View arg1, int arg2,long arg3) {
                                if (list.get(arg2).getTrangthai_()==1)
                                {
                                    list.get(arg2).setTrangthai_(0);
                                    gridView.getChildAt(arg2).setBackgroundResource(R.color.nomo);
                                } else if (list.get(arg2).getTrangthai_() == 0)
                                {
                                    list.get(arg2).setTrangthai_(1);
                                    gridView.getChildAt(arg2).setBackgroundResource(R.color.noma);
                                } else Toast.makeText(getApplicationContext(), "Chọn ghế khác đi ba!!!",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Erorr!",Toast.LENGTH_LONG).show();
                    }
                }
        );
        requestQueue.add(stringRequest);
        //
        chonghe = findViewById(R.id.btnchonghe);
        chonghe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < list.size(); i++){
                    if (list.get(i).getTrangthai_() == 1) {
                        soluongghe.add(list.get(i).getId());
                        tencacghe.add(list.get(i).getSoghe_());
                        giatienghe.add(list.get(i).getGia());
                        tongtien += list.get(i).getGia();
                    }
                }
                soluong = soluongghe.size();
                if (soluong < 1) {
                    Toast.makeText(getApplicationContext(), "Chưa chọn ghế nha!!!",Toast.LENGTH_SHORT).show();
                } else {
                    Intent t = new Intent(ChonGheActivity.this, ThanhToanActivity.class);
                    t.putExtra("soluong", soluong);
                    if (soluong == 1) {
                        t.putExtra("giatienghe2", giatienghe.get(0));
                        t.putExtra("dsghe_id2", soluongghe.get(0));
                        t.putExtra("dstenghe2", tencacghe.get(0));
                    } else {
                        t.putIntegerArrayListExtra("giatienghe", giatienghe);
                        t.putIntegerArrayListExtra("dsghe_id", soluongghe);
                        t.putStringArrayListExtra("dstenghe", tencacghe);
                    }
                    t.putExtra("tenphim", tenphim);
                    t.putExtra("tenrap", tenrap);
                    t.putExtra("chinhanh", chinhanh);
                    t.putExtra("ngaychieu", ngaychieu);
                    t.putExtra("giochieu", giochieu);
                    t.putExtra("phim_id", phim_id);
                    t.putExtra("rap_id", rap_id);
                    t.putExtra("suatchieu_id", suatchieu_id);
                    t.putExtra("hinhanh", "Adios.jpg");
                    t.putExtra("tongtien", tongtien);

                    startActivity(t);
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_khachhang, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.back:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void LayVeDaMua(String urlve, ArrayList<Ghe> list){
        RequestQueue requestQueue = Volley.newRequestQueue(ChonGheActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlve,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
                            JSONArray jr = new JSONArray(response);
                            JSONObject jb;
                            int n = jr.length();
                            int rap_id_, suatchieu_id_;
                            int gheid_;
                            for (int h = 0; h < n; h++){
                                jb = jr.getJSONObject(h);
                                rap_id_ = jb.getInt("rap_id");
                                suatchieu_id_ = jb.getInt("suatchieu_id");
                                if(rap_id_ == rap_id_)
                                {
                                    if (suatchieu_id_ == suatchieu_id)
                                    {
                                        gheid_ = jb.getInt("ghe_id");
                                        for (int i = 0; i < list.size(); i++)
                                        {
                                                if (list.get(i).getId() == gheid_) {
                                                    list.get(i).setTrangthai_(2);
                                                    Toast.makeText(getApplicationContext(),list.get(i).getId()+"",Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Erorr!",Toast.LENGTH_LONG).show();
                    }
                }
        );
        requestQueue.add(stringRequest);
    }

}