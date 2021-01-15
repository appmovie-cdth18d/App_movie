package com.example.app.giaodien.ThongTinKhachHang;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;
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
import com.example.app.Model.TaiKhoan;
import com.example.app.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class SuaThongTin extends AppCompatActivity {
    SharedPreferences taikhoan;
    Toolbar toolbar;
    EditText hoten, sdt,email, ngay, tendangnhap, diachi;
    RadioButton nam, nu;
    Button suathongtin;
    int id;
    String url="http://192.168.0.10:8080/cinema_admin/api/taikhoan";
    String urlUpdate;
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
        diachi = (EditText) findViewById(R.id.editDiachi);
        taikhoan = getSharedPreferences("TK",MODE_PRIVATE);
        id = taikhoan.getInt("ID_TK",0);
        urlUpdate = intent.getStringExtra("url");
        //API
        RequestQueue requestQueue = Volley.newRequestQueue(SuaThongTin.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jr = new JSONArray(response);
                            JSONObject jb;
                            int n = jr.length();
                            for (int i = 0; i < n; i++) {
                                if ((id - 1) == i) {
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
                                    String DiaChi = jb.getString("Diachi");
                                    diachi.setText(DiaChi);
                                    TaiKhoan taiKhoan = new TaiKhoan(id, hoten.getText().toString(),tendangnhap.getText().toString(),sdt.getText().toString(),diachi.getText().toString(),ngay.getText().toString(),jb.getString("Phai"));
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
        suathongtin = (Button) findViewById(R.id.btnsuathongtin);
        suathongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hotenkhachhang = hoten.getText().toString().trim();
                String tentaikhoan = tendangnhap.getText().toString().trim();
                String sodienthoai = sdt.getText().toString().trim();
                if(hotenkhachhang.matches("")||tentaikhoan.matches("")||sodienthoai.matches("")){
                    Toast.makeText(getApplicationContext(),"Vui Lòng Nhập Đủ Thông Tin!", Toast.LENGTH_LONG).show();

                }else {
                    SuaThongTin(urlUpdate);
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


    private void SuaThongTin(String urlUpdate)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(SuaThongTin.this);
        StringRequest stringRequest = new StringRequest(Request.Method.PUT, urlUpdate,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Intent inten = new Intent(SuaThongTin.this,ThongTinKhachHang.class);
                        startActivity(inten);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Intent inten = new Intent(SuaThongTin.this,ThongTinKhachHang.class);
                        startActivity(inten);
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Ten_TK", tendangnhap.getText().toString());
                params.put("HoTen", hoten.getText().toString());
                params.put("SDT", sdt.getText().toString());
                params.put("Email", email.getText().toString());
                params.put("Diachi", diachi.getText().toString());
                if (nam.isChecked()) {
                    params.put("Phai", "Nam");
                } else {
                    params.put("Phai", "Nu");
                }
                params.put("NgaySinh", ngay.getText().toString());
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