package com.example.app.giaodien.ThongTinKhachHang;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app.Model.khachhang;
import com.example.app.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SuaThongTin extends AppCompatActivity {
    Toolbar toolbar;
    EditText hoten, sdt,email, ngay, tendangnhap;
    RadioButton nam, nu,namsua, nusua;
    Button suathongtin;
    EditText hotensua, sdtsua,emailsua, ngaysua, tendangnhapsua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_thong_tin);
        Intent intent = this.getIntent();
        toolbar = (Toolbar) findViewById(R.id.toolbar_suathongtin);
        setSupportActionBar(toolbar);
        hoten = (EditText) findViewById(R.id.editHoten);
        sdt = (EditText) findViewById(R.id.editSDT);
        email = (EditText) findViewById(R.id.editEmail);
        ngay = (EditText) findViewById(R.id.editNgay);
        tendangnhap = (EditText) findViewById(R.id.edittextTendangnhap);
        nam = (RadioButton) findViewById(R.id.radioNam);
        nu = (RadioButton) findViewById(R.id.radioNu);

        LoadData();

        suathongtin = (Button) findViewById(R.id.btnsuathongtin);
        suathongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hotensua = (EditText) findViewById(R.id.editHoten);
                sdtsua = (EditText) findViewById(R.id.editSDT);
                emailsua = (EditText) findViewById(R.id.editEmail);
                ngaysua = (EditText) findViewById(R.id.editNgay);
                tendangnhapsua = (EditText) findViewById(R.id.edittextTendangnhap);
                namsua = (RadioButton) findViewById(R.id.radioNam);
                nusua = (RadioButton) findViewById(R.id.radioNu);
                if(namsua.isChecked())
                {
                    hoten.setText(hotensua+"");
                    sdt.setText(sdtsua+"");
                    email.setText(emailsua+"");
                    ngay.setText(ngaysua+"");
                    tendangnhap.setText(tendangnhapsua+"");
                    nam.setChecked(true);
                } else {
                    hoten.setText(hotensua+"");
                    sdt.setText(sdtsua+"");
                    email.setText(emailsua+"");
                    ngay.setText(ngaysua+"");
                    tendangnhap.setText(tendangnhapsua+"");
                    nu.setChecked(true);
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

    public void LoadData(){
        RequestQueue requestQueue = Volley.newRequestQueue(SuaThongTin.this);
        String url = "http://192.168.64.2/Admin/Admin/api/taikhoans?";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jr = new JSONArray(response);
                            JSONObject jb;
                            int a = 1;
                            for (int i = 0; i < 5; i++) {
                                if (a == i) {
                                    jb = jr.getJSONObject(i);
                                    String ho_ten = jb.getString("HoTen");
                                    hoten.setText(ho_ten);
                                    String SDT = jb.getString("SDT");
                                    sdt.setText(SDT);
                                    String Email = jb.getString("Email");
                                    email.setText(Email);
                                    String NgaySinh = jb.getString("Ngaysinh");
                                    ngay.setText(NgaySinh);
                                    String TenDangNhap = jb.getString("Ten_TK");
                                    tendangnhap.setText(TenDangNhap);
                                    String phai = jb.getString("Phai");
                                    if (phai.equals("nam"))
                                        nam.setChecked(true);
                                    else nu.setChecked(true);
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

                    }
                }

        );
        requestQueue.add(stringRequest);
    }

    private void SuaThongTin(String url)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(SuaThongTin.this);
        StringRequest stringRequest = new StringRequest(Request.Method.PATCH, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response == "successful")
                            Toast.makeText(SuaThongTin.this, "Update!", Toast.LENGTH_LONG).show();
                        else Toast.makeText(SuaThongTin.this, "Error!", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SuaThongTin.this, "Error!", Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Ten_TK", tendangnhap.getText().toString().trim());
                params.put("HoTen",hoten.getText().toString().trim());
                params.put("SDT", sdt.getText().toString().trim());
                params.put("id", "1");
                return super.getParams();
            }
        };
    }
}