package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

import com.example.app.giaodien.ThongTinKhachHang.DoiMatKhauActivity;
import com.example.app.giaodien.ThongTinKhachHang.ThongTinKhachHang;
import com.example.app.giaodien.TrangChu.Trangchu;

import com.example.app.giaodien.dangky;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    EditText user;
    EditText pass;
    Button login;
    String url = "http://192.168.0.10:8080/cinema_admin/api/taikhoan/";
    String url1 = "http://192.168.0.10:8080/cinema_admin/api/taikhoan";
    private int soluong = 0;
    int dangnhap;
    private ArrayList<String> tentk, mk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dangnhap = 0;
        user = (EditText) findViewById(R.id.inputEmail);
        pass = (EditText) findViewById(R.id.inputPassword);
        login = (Button) findViewById(R.id.btnLogin);

        sharedPreferences = getSharedPreferences("TK", MODE_PRIVATE);
        if(sharedPreferences.getInt("ID_TK",-1) != -1)
        {
            startActivity(new Intent(MainActivity.this, Trangchu.class));
        }
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
                                                            String Tentaikhoan, Matkhau, Email;
                                                            JSONObject jb = new JSONObject(response);
                                                            Tentaikhoan = jb.getString("Ten_TK");
                                                            Matkhau = jb.getString("Matkhau");
                                                            Email = jb.getString("Email");
                                                            if (user.getText().toString().equals(Tentaikhoan))
                                                            {
                                                                if (pass.getText().toString().equals(Matkhau))
                                                                {
                                                                    dangnhap = 1;
                                                                    taikhoan_id = jb.getInt("id");

                                                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                                                    editor.putInt("ID_TK", taikhoan_id);
                                                                    editor.putString("Email", Tentaikhoan);
                                                                    editor.putString("Pass", Matkhau);
                                                                    editor.putString("Name", Tentaikhoan);

                                                                    editor.commit();

                                                                    Intent intent = new Intent(MainActivity.this, Trangchu.class);
                                                                    intent.putExtra("taikhoan_id", taikhoan_id);
                                                                    startActivity(intent);


                                                                }
                                                            }
                                                            else if (user.getText().toString().equals(Email))
                                                            {
                                                                if (pass.getText().toString().equals(Matkhau))
                                                                {
                                                                    dangnhap = 1;
                                                                    taikhoan_id = jb.getInt("id");

                                                                    //////////
                                                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                                                    editor.putInt("ID_TK", taikhoan_id);
                                                                    editor.putString("Email", Email);
                                                                    editor.putString("Pass", Matkhau);
                                                                    editor.putString("Name", Tentaikhoan);

                                                                    editor.commit();


                                                                    Intent intent = new Intent(MainActivity.this, Trangchu.class);
                                                                    startActivity(intent);
                                                                }
                                                            } else dangnhap = 2;
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
                                    }
                                    if (dangnhap == 2) {Toast.makeText(getApplicationContext(),"Sai Tai Khoan Hoac Mat Khau",Toast.LENGTH_SHORT).show();}
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