package com.example.app.giaodien.ThongTinKhachHang;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app.Model.Ve;
import com.example.app.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GiaoDich extends AppCompatActivity {
    Toolbar toolbar;
    String url;
    SharedPreferences taikhoan;
    private List<Ve> list;
    int tongtien = 0, id;
    TextView TongTienThang, TongTienNam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giao_dich);
        Intent t = getIntent();
        taikhoan = getSharedPreferences("TK",MODE_PRIVATE);
        id = taikhoan.getInt("ID_TK",0);
        url = "http://192.168.0.10:8080/cinema_admin/api/ve";
        list = new ArrayList<>();
        final ListView listView = (ListView) findViewById(R.id.listview);
        TongTienThang = (TextView)  findViewById(R.id.txttongchitieuthang);
        TongTienNam = (TextView) findViewById(R.id.txttongtientrongnam) ;
        //API
        RequestQueue requestQueue = Volley.newRequestQueue(GiaoDich.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jr = new JSONArray(response);
                            JSONObject jb;
                            int n = jr.length();
                            String hinhanhphim;
                            String tenphim;
                            String rap;
                            String soghe;
                            String giochieu;
                            String ngaychieu;
                            int taikhoan_id;
                            int giave;
                            for (int i = 0; i < n; i++) {
                                jb = jr.getJSONObject(i);
                                taikhoan_id = jb.getInt("taikhoan_id");
                                if (id == taikhoan_id) {
                                    hinhanhphim = jb.getString("Hinhanh").toString();
                                    tenphim = jb.getString("Tenphim").toString();
                                    rap = jb.getString("Tenrap").toString();
                                    soghe = jb.getString("Soghe").toString();
                                    giave = jb.getInt("Thanhtien");
                                    giochieu = jb.getString("GioChieu");
                                    ngaychieu = jb.getString("NgayChieu");
                                    tongtien += giave;
                                    list.add(new Ve(hinhanhphim, tenphim, rap, soghe, giave, giochieu, ngaychieu));
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        TongTienThang.setText(tongtien+"");
                        TongTienNam.setText(tongtien+"");
                        listView.setAdapter(new CustomListAdapter(GiaoDich.this, list));
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


        // When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Ve Ve = (Ve) o;
                Toast.makeText(GiaoDich.this, "Selected :" + " " + Ve, Toast.LENGTH_LONG).show();
            }
        });
        toolbar = (Toolbar) findViewById(R.id.toolbar_lichsugiaodich);
        setSupportActionBar(toolbar);
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