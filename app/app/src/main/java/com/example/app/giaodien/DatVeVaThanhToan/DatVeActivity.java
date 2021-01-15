package com.example.app.giaodien.DatVeVaThanhToan;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
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
import com.example.app.Model.SuatChieu;
import com.example.app.R;
import com.example.app.giaodien.DanhSachPhim.DanhsachphimActivity;
import com.example.app.giaodien.ThongTinKhachHang.ThongTinKhachHang;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DatVeActivity extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    TextView rap1, rap2, tenphim_, ngaychieu;
    String tenphim, tenrap1,tenrap2;
    String url = "http://192.168.1.4:8080/cinema_admin/api/lichchieu";
    TextView giochieu;
    String giochieu_, giochieu_2;
    GridView girdGio;
    GridView girdGio2;
    private int phim_id, taikhoan_id;
    private int rap_id1, rap_id2;
    private ArrayList<SuatChieu> list;
    private ArrayList<SuatChieu> list2;
    private ArrayList<String> NgayChieu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datve);
        list = new ArrayList();
        list2 = new ArrayList<>();
        NgayChieu = new ArrayList<>();
        rap1 = findViewById(R.id.txtrap1);
        rap2 = findViewById(R.id.txtrap2);
        tenphim_ = findViewById(R.id.toolbar_title_datve);
        ngaychieu = findViewById(R.id.NgayChieu);
        giochieu = findViewById(R.id.giochieu);
        girdGio = (GridView) findViewById(R.id.gridGio);
        girdGio2 = (GridView) findViewById(R.id.gridGio2);
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
                        t.putExtra("taikhoan_id", taikhoan_id);
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
        //API lấy ngày chiếu
        RequestQueue requestQueue = Volley.newRequestQueue(DatVeActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jr = new JSONArray(response);
                            JSONObject jb;
                            int n = jr.length();
                            int k = 0;
                            for (int i = 0; i < n; i++) {
                                jb = jr.getJSONObject(i);
                                for ( int j = 0; j < NgayChieu.size(); j++)
                                {
                                    if (NgayChieu.get(j).equals(jb.getString("NgayChieu")) == true)
                                    k++;
                                }
                                if (k == 0) {NgayChieu.add(jb.getString("NgayChieu"));}
                                else k = 0;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Lấy đối tượng Spinner ra
                        Spinner spin=(Spinner) findViewById(R.id.spinner);
                        //Gán Data source (arr) vào Adapter
                        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                                (
                                        DatVeActivity.this,
                                        android.R.layout.simple_spinner_item,
                                        NgayChieu
                                );
                        //phải gọi lệnh này để hiển thị danh sách cho Spinner
                        adapter.setDropDownViewResource
                                (android.R.layout.simple_list_item_single_choice);
                        //Thiết lập adapter cho Spinner
                        spin.setAdapter(adapter);
                        //thiết lập sự kiện chọn phần tử cho Spinner
                        spin.setOnItemSelectedListener(new MyProcessEvent());

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
    //Class tạo sự kiện
    private class MyProcessEvent implements
            AdapterView.OnItemSelectedListener
    {
        //Khi có chọn lựa thì vào hàm này
        public void onItemSelected(AdapterView<?> arg0,
                                   View arg1,
                                   int arg2,
                                   long arg3) {
            //arg2 là phần tử được chọn trong data source
            ngaychieu.setText(NgayChieu.get(arg2));
            list.clear();
            list2.clear();
            tenrap1 = "";
            tenrap2 = "";
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
                                    if(jb.getInt("rap_id" )==1) {
                                        if(jb.getInt("phim_id")==1) {
                                            if (ngaychieu.getText().toString().equals(jb.getString("NgayChieu"))) {
                                                tenrap1 = jb.getString("Tenrap");
                                                giochieu_ = jb.getString("GioChieu").toString();
                                                phim_id = jb.getInt("phim_id");
                                                rap_id1 = jb.getInt("rap_id");
                                                list.add(new SuatChieu(giochieu_, phim_id, rap_id1));
                                            }
                                        }
                                    } else if(jb.getInt("rap_id" )==2) {
                                        if (jb.getInt("phim_id")==1){
                                            if (ngaychieu.getText().toString().equals(jb.getString("NgayChieu"))) {
                                                tenrap2 = jb.getString("Tenrap");
                                                giochieu_2 = jb.getString("GioChieu").toString();
                                                phim_id = jb.getInt("phim_id");
                                                rap_id2 = jb.getInt("rap_id");
                                                list2.add(new SuatChieu(giochieu_2, phim_id, rap_id2));
                                            }
                                        }
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            tenphim_.setText(tenphim);
                            rap1.setText( tenrap1);
                            rap2.setText(tenrap2);
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
        }
        //Nếu không chọn gì cả
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    }
}