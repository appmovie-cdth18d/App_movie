package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.app.giaodien.ThongTinKhachHang.SuaThongTin;
import com.example.app.giaodien.ThongTinKhachHang.ThongTinKhachHang;
import com.example.app.giaodien.TrangChu.Trangchu;
import com.example.app.giaodien.TrangTimKiem.TrangTimKiem;
import com.example.app.giaodien.dangky;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText user;
    EditText pass;
    Button login;
    String url = "http://192.168.137.1:8080/WebAdmin1/api/taikhoan/";
    String url1 = "http://192.168.137.1:8080/WebAdmin1/api/taikhoan";
    private int soluong = 0;
    private ArrayList<String> tentk, mk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.inputEmail);
        pass = (EditText) findViewById(R.id.inputPassword);
        login = findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url1,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONArray jr = new JSONArray(response);
                                    int i = jr.length();
                                    for (int j = 1; j <= i; j++){
                                        //
                                        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                                        StringRequest stringRequest = new StringRequest(Request.Method.GET, url+j+"",
                                                new Response.Listener<String>() {
                                                    @Override
                                                    public void onResponse(String response) {
                                                        try {
                                                            int taikhoan_id, tientrongtaikhoan;
                                                            String Tentaikhoan, Matkhau;
                                                            JSONObject jb = new JSONObject(response);
                                                            Tentaikhoan = jb.getString("Ten_TK");
                                                            Matkhau = jb.getString("Matkhau");
                                                            if (user.getText().toString().equals(Tentaikhoan))
                                                            {
                                                                if (pass.getText().toString().equals(Matkhau))
                                                                {
                                                                    taikhoan_id = jb.getInt("id");
                                                                    tientrongtaikhoan = jb.getInt("Tien_TK");
                                                                    Intent intent = new Intent(MainActivity.this, Trangchu.class);
                                                                    intent.putExtra("taikhoan_id", taikhoan_id);
                                                                    intent.putExtra("tientaikhoan", tientrongtaikhoan);
                                                                    startActivity(intent);
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
                                                        Toast.makeText(getApplicationContext(),"Error Connection ??",Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                        requestQueue.add(stringRequest);
                                        //
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
                        });
                requestQueue.add(stringRequest);
            }
        });


    }


    public void gotoRegister(View view) {
        Intent intent = new Intent(MainActivity.this, dangky.class);
        startActivity(intent);
    }

}