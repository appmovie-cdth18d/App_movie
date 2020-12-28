package com.example.app.giaodien.DatVeVaThanhToan;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
import com.example.app.giaodien.ThongTinKhachHang.ThongTinKhachHang;
import com.example.app.giaodien.TrangTimKiem.TrangTimKiem;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThanhToanActivity extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    Button thanhtoan;
    private String tenphim, tenrap, chinhanh, ngaychieu, Ten_ghe;
    private String giochieu, hinhanh, tencacghe = "", giatienghe_="";;
    private int phim_id, suatchieu_id;
    private int rap_id, tongtien, dsve_id, Ghe_id, GiaTienGhe;
    private int soluong, id_ghe;
    private ArrayList<Integer> ghe_id, giatienghe;
    private ArrayList<String> tenghe;
    String url = "http://192.168.64.2/WebAdmin/api/dsve";
    String url2 = "http://192.168.64.2/WebAdmin/api/ve";
    TextView soluongve_, tenphim_, ngaychieu_, rap_, ghe_, giochieu_, tongtienve, tongcong, conlai;
    ImageView hinhanhphim_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);
        ghe_id = new ArrayList<>();
        tenghe = new ArrayList<>();
        giatienghe = new ArrayList<>();
        hinhanhphim_ = findViewById(R.id.hinhphimthanhtoan);
        soluongve_ = findViewById(R.id.soluong);
        tenphim_ = findViewById(R.id.txttenphimthanhtoan);
        ngaychieu_ = findViewById(R.id.txtngaythangxemphim);
        rap_ = findViewById(R.id.txtrapxemphim);
        ghe_ = findViewById(R.id.txtghexemphim);
        giochieu_ = findViewById(R.id.txtgiochieu);
        tongtienve = findViewById(R.id.tongtien);
        tongcong = findViewById(R.id.tongcong);
        conlai = findViewById(R.id.conlai);
        thanhtoan = findViewById(R.id.btnthanhtoan);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_thanhtoan);
        toolbar = (Toolbar) findViewById(R.id.toolbar_thanhtoan);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        nav = (NavigationView) findViewById(R.id.navView_thanhtoan);
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

        Intent intent = getIntent();
        soluong = intent.getIntExtra("soluong", 0);
        //Lấy dữ liệu

        if (soluong == 1)
        {
            tenphim = intent.getStringExtra("tenphim");
            tenrap = intent.getStringExtra("tenrap");
            chinhanh = intent.getStringExtra("chinhanh");
            ngaychieu = intent.getStringExtra("ngaychieu");
            giochieu = intent.getStringExtra("giochieu");
            phim_id = intent.getIntExtra("phim_id", 0);
            rap_id = intent.getIntExtra("rap_id", 0);
            hinhanh = intent.getStringExtra("hinhanh");
            suatchieu_id = intent.getIntExtra("suatchieu_id", 0);
            Ghe_id = intent.getIntExtra("dsghe_id2", 0);
            Ten_ghe = intent.getStringExtra("dstenghe2");
            tongtien = intent.getIntExtra("tongtien", 0);
            GiaTienGhe = intent.getIntExtra("giatienghe2", 0);
            ghe_id.add(Ghe_id);
            tenghe.add(Ten_ghe+"");
            giatienghe.add(GiaTienGhe);
        } else if (soluong > 1) {
            tenphim = intent.getStringExtra("tenphim");
            tenrap = intent.getStringExtra("tenrap");
            chinhanh = intent.getStringExtra("chinhanh");
            ngaychieu = intent.getStringExtra("ngaychieu");
            giochieu = intent.getStringExtra("giochieu");
            phim_id = intent.getIntExtra("phim_id", 0);
            rap_id = intent.getIntExtra("rap_id", 0);
            hinhanh = intent.getStringExtra("hinhanh");
            suatchieu_id = intent.getIntExtra("suatchieu_id", 0);
            ghe_id = intent.getIntegerArrayListExtra("dsghe_id");
            tenghe = intent.getStringArrayListExtra("dstenghe");
            tongtien = intent.getIntExtra("tongtien", 0);
            giatienghe = intent.getIntegerArrayListExtra("giatienghe");
        }




        //Truyền dữ liệu
        Picasso.with(getApplicationContext())
                .load("http://192.168.64.2/WebAdmin/public/Image/"+ hinhanh)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(hinhanhphim_);

        soluongve_.setText(ghe_id.size()+"");
        tenphim_.setText(tenphim+"");
        rap_.setText("Rạp : "+tenrap+"");
        for(int i = 0; i < tenghe.size(); i++)
        {
            if (i == 0) {
                tencacghe += tenghe.get(i);
            } else tencacghe += "," +tenghe.get(i);
        }
        ghe_.setText("Ghế : "+tencacghe+"");
        ngaychieu_.setText(ngaychieu+"");
        giochieu_.setText(giochieu+"");
        tongtienve.setText(tongtien+"");
        tongcong.setText(tongtien+"");
        conlai.setText(tongtien+"");
        //



        //API
        RequestQueue requestQueue = Volley.newRequestQueue(ThanhToanActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jr = new JSONArray(response);
                            dsve_id = jr.length();
                            thanhtoan.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    TaoDsVe(url);
                                    for (int i = 0; i < soluong; i++) {
                                        DatVe(url2, dsve_id + 1,ghe_id.get(i),giatienghe.get(i));
                                    }
                                    Toast.makeText(getApplicationContext(),"Đặt vé thành công!!!", Toast.LENGTH_SHORT).show();
                                }
                            });
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
    public void TaoDsVe(String url1){

        RequestQueue requestQueue = Volley.newRequestQueue(ThanhToanActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("soluong", soluongve_.getText().toString());
                params.put("tongtien", conlai.getText().toString());
                params.put("taikhoan_id", "2");
                return params;
            }

            @Override
            public Priority getPriority() {
                return Priority.HIGH;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void DatVe(String url, int dsve, int gheid, int giatien) {
            RequestQueue requestQueue = Volley.newRequestQueue(ThanhToanActivity.this);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("dsve_id", dsve + "");
                    params.put("ghe_id", gheid +"");
                    params.put("phim_id", phim_id + "");
                    params.put("thanhtien", giatien+"");
                    return params;
                }

                @Override
                public Priority getPriority() {
                    return Priority.HIGH;
                }
            };
            requestQueue.add(stringRequest);
        }
}