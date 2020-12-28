package com.example.app.giaodien.DatVeVaThanhToan;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app.MainActivity;
import com.example.app.R;
import com.example.app.giaodien.DanhSachPhim.DanhsachphimActivity;
import com.example.app.giaodien.ThongTinKhachHang.CustomListAdapter;
import com.example.app.giaodien.ThongTinKhachHang.ThongTinKhachHang;
import com.example.app.giaodien.TrangTimKiem.TrangTimKiem;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Time;
import java.util.ArrayList;

public class DatVeActivity extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    TextView rap1, rap2, tenphim_, ngaychieu, chinhanh1_,chinhanh2_;
    String tenphim, tenrap1,tenrap2, chinhanh, chinhanh2;
    String url = "http://192.168.64.2/WebAdmin/api/lichchieu";
    TextView giochieu;
    String giochieu_, giochieu_2;
    private int phim_id;
    private int rap_id1, rap_id2;
    private ArrayList<SuatChieu> list;
    private ArrayList<SuatChieu> list2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datve);
        list = new ArrayList();
        list2 = new ArrayList<>();
        rap1 = findViewById(R.id.txtrap1);
        rap2 = findViewById(R.id.txtrap2);
        tenphim_ = findViewById(R.id.toolbar_title_datve);
        ngaychieu = findViewById(R.id.NgayChieu);
        chinhanh1_ = findViewById(R.id.txtchinhanh1);
        chinhanh2_ = findViewById(R.id.txtchinhanh2);
        giochieu = findViewById(R.id.giochieu);
        final GridView girdGio = (GridView) findViewById(R.id.gridGio);
        final GridView girdGio2 = (GridView) findViewById(R.id.gridGio2);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_datve);
        toolbar = (Toolbar) findViewById(R.id.toolbar_datve);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        nav = (NavigationView) findViewById(R.id.navView_datve);
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
            RequestQueue requestQueue = Volley.newRequestQueue(DatVeActivity.this);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray jr = new JSONArray(response);
                                JSONObject jb;
                                int n = jr.length();


                                for (int i = 0; i < n; i++) {
                                    jb = jr.getJSONObject(i);
                                    tenphim = jb.getString("Tenphim");
                                    ngaychieu.setText(jb.getString("NgayChieu"));
                                    if(jb.getInt("rap_id" )==1) {
                                        if(jb.getInt("phim_id")==1) {
                                            tenrap1 = jb.getString("Tenrap");
                                            giochieu_ = jb.getString("GioChieu").toString();
                                            phim_id = jb.getInt("phim_id");
                                            rap_id1 = jb.getInt("rap_id");
                                            chinhanh = jb.getString("chinhanh");
                                            list.add(new SuatChieu(giochieu_, phim_id, rap_id1));
                                        }
                                    } else if(jb.getInt("rap_id" )==2) {
                                        if (jb.getInt("phim_id")==1){
                                            tenrap2 = jb.getString("Tenrap");
                                            giochieu_2= jb.getString("GioChieu").toString();
                                            phim_id = jb.getInt("phim_id");
                                            rap_id2 = jb.getInt("rap_id");
                                            chinhanh2 = jb.getString("chinhanh");
                                            list2.add(new SuatChieu(giochieu_2, phim_id, rap_id2));
                                        }
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            chinhanh1_.setText(chinhanh);
                            chinhanh2_.setText(chinhanh2);
                            tenphim_.setText(tenphim);
                            rap1.setText("Phòng : " +tenrap1);
                            rap2.setText("Phòng : " +tenrap2);
                            girdGio.setAdapter(new SuatChieuGidAdapter(getApplicationContext(), list));
                            girdGio.setOnItemClickListener(new AdapterView .OnItemClickListener() {
                                public void onItemClick(
                                        AdapterView<?> arg0,View arg1, int arg2,long arg3) {
                                    Intent intent = new Intent(DatVeActivity.this, ChonGheActivity.class);
                                    intent.putExtra("suatchieu_id", arg2+1);
                                    intent.putExtra("rap_id", rap_id1);
                                    intent.putExtra("phim_id", phim_id);
                                    intent.putExtra("giochieu", giochieu_);
                                    intent.putExtra("tenphim", tenphim);
                                    intent.putExtra("tenrap", tenrap1);
                                    intent.putExtra("ngaychieu", ngaychieu.getText().toString());
                                    intent.putExtra("chinhanh", chinhanh);
                                    startActivity(intent);
                                }
                            });
                            girdGio2.setAdapter(new SuatChieuGidAdapter(getApplicationContext(), list2));
                            girdGio2.setOnItemClickListener(new AdapterView .OnItemClickListener() {
                                public void onItemClick(
                                        AdapterView<?> arg0,View arg1, int arg2,long arg3) {
                                    Intent intent = new Intent(DatVeActivity.this, ChonGheActivity.class);
                                    intent.putExtra("suatchieu_id", arg2+1);
                                    intent.putExtra("rap_id", rap_id2);
                                    intent.putExtra("phim_id", phim_id);
                                    intent.putExtra("giochieu", giochieu_);
                                    intent.putExtra("tenphim", tenphim);
                                    intent.putExtra("tenrap", tenrap2);
                                    intent.putExtra("ngaychieu", ngaychieu.getText().toString());
                                    intent.putExtra("chinhanh", chinhanh2);
                                    startActivity(intent);
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

        girdGio2.setOnItemClickListener(new AdapterView .OnItemClickListener() {
            public void onItemClick(
                    AdapterView<?> arg0,View arg1, int arg2,long arg3) {

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
}