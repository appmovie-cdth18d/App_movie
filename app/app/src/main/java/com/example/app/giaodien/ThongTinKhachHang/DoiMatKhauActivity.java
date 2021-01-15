package com.example.app.giaodien.ThongTinKhachHang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app.R;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.security.KeyStore;

import java.util.HashMap;
import java.util.Map;


public class DoiMatKhauActivity extends AppCompatActivity {
    Toolbar toolbar;
    SharedPreferences taikhoan;
    String urlUpdate;
    int taikhoan_id;
    EditText MK, MKM, CMKM;
    String mk;
    Button DoiMK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_mat_khau);
        Intent t = getIntent();
        taikhoan = getSharedPreferences("TK",MODE_PRIVATE);
        taikhoan_id = taikhoan.getInt("ID_TK",0);
        urlUpdate = t.getStringExtra("url");
        toolbar = (Toolbar) findViewById(R.id.toolbar_doimatkhau);
        setSupportActionBar(toolbar);
        MK = (EditText) findViewById(R.id.editmatkhauhientai);
        MKM = (EditText) findViewById(R.id.editmatkhaumoi);
        CMKM = (EditText) findViewById(R.id.editnhaplaimatkhaumoi);
        //API
        RequestQueue requestQueue = Volley.newRequestQueue(DoiMatKhauActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlUpdate,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jb = new JSONObject(response);
                            mk = jb.getString("Matkhau");
                    } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(getApplicationContext(), "Erorr!",Toast.LENGTH_LONG).show();
                    }
                }

        );
        requestQueue.add(stringRequest);
        //
        DoiMK = findViewById(R.id.btndoimatkhau);
        DoiMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mkc = MK.getText().toString().trim();
                String mkm = MKM.getText().toString().trim();
                String cmkm = CMKM.getText().toString().trim();
                if(mkc.matches("")||mkm.matches("")||cmkm.matches("")){
                    Toast.makeText(getApplicationContext(),"Vui Lòng Nhập Đủ Thông Tin!", Toast.LENGTH_LONG).show();

                }else if(MK.getText().toString().equals(mk)){
                    DoiMatKhau(urlUpdate);
                } else {
                    Toast.makeText(getApplicationContext(),"Mật khẩu hiện tại không khớp!",Toast.LENGTH_SHORT).show();
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
    private void DoiMatKhau(String urlUpdate)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(DoiMatKhauActivity.this);

        StringRequest stringRequest = new StringRequest(Request.Method.PUT, urlUpdate,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Intent inten = new Intent(DoiMatKhauActivity.this,ThongTinKhachHang.class);
                        inten.putExtra("taikhoan_id", taikhoan_id);
                        startActivity(inten);
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Matkhau", MKM.getText().toString());
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