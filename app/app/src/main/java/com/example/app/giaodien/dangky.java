package com.example.app.giaodien;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.app.MainActivity;
import com.example.app.R;


import java.util.HashMap;
import java.util.Map;

public class dangky extends AppCompatActivity {
    EditText email, user, pass, cfpass, hoten, ngaysinh, sdt, diachi;
    RadioButton nam, nu;
    Button signup;
    String url = "http://192.168.64.2/cinema_admin/api/taikhoan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        email = (EditText) findViewById(R.id.inputEmail);
        user = (EditText) findViewById(R.id.inputUserName);
        pass = (EditText) findViewById(R.id.inputPassword);
        cfpass = (EditText) findViewById(R.id.inputCFPassword);
        hoten = (EditText) findViewById(R.id.inputName);
        ngaysinh = (EditText) findViewById(R.id.inputNgaySinh);
        diachi = (EditText) findViewById(R.id.inputDiachi);
        sdt = (EditText) findViewById(R.id.inputSDT);
        nam = (RadioButton) findViewById(R.id.radioNam);
        nu = (RadioButton) findViewById(R.id.radioNu);
        signup = findViewById(R.id.btnSignup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Check()){
                    RequestQueue requestQueue = Volley.newRequestQueue(dangky.this);
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
                            }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("Ten_TK",user.getText().toString());
                            params.put("Email", email.getText().toString());
                            params.put("Matkhau",pass.getText().toString());
                            params.put("HoTen",hoten.getText().toString());
                            params.put("Ngaysinh",ngaysinh.getText().toString());
                            String phai=null;
                            if (nam.isChecked()){
                                params.put("Phai", "Nam"); }
                            else  if (nu.isChecked()) {
                                params.put("Phai", "Nu");
                            }
                            params.put("SDT",sdt.getText().toString());
                            params.put("Diachi",diachi.getText().toString());
                            return params;
                        }
                    };
                    requestQueue.add(stringRequest);
                    Toast.makeText(getApplicationContext(),"Sussces!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(dangky.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext()," Nhập Chua Đủ Thông Tin!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean Check (){
        if(user.getText().toString().isEmpty()||email.getText().toString().isEmpty()||pass.getText().toString().isEmpty()||hoten.getText().toString().isEmpty()
                    ||ngaysinh.getText().toString().isEmpty()||diachi.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Vui Lòng Nhập Đủ Thông Tin!", Toast.LENGTH_LONG).show();
            }
        if(user.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Vui Lòng Nhập UserName!", Toast.LENGTH_LONG).show();
            }
        if(email.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Vui Lòng Nhập Email!", Toast.LENGTH_LONG).show();
            }
        if(pass.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Vui Lòng Nhập PasWord!", Toast.LENGTH_LONG).show();
            }
        if(cfpass.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Vui Lòng Nhập ConfirmPassWprd!", Toast.LENGTH_LONG).show();
            }
        if(hoten.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Vui Lòng Nhập Họ Tên!", Toast.LENGTH_LONG).show();
            }
        if(ngaysinh.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Vui Lòng Nhập Ngày Sinh!", Toast.LENGTH_LONG).show();
            }
        if(diachi.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Vui Lòng Nhập Địa Chỉ!", Toast.LENGTH_LONG).show();
            }
        if(sdt.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Vui Lòng Nhập Số Điện Thoại!", Toast.LENGTH_LONG).show();
        }
        return true;
    }
    public void Dang_ky(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(dangky.this);
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
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Ten_TK",user.getText().toString());
                params.put("Email", email.getText().toString());
                params.put("Matkhau",pass.getText().toString());
                params.put("HoTen",hoten.getText().toString());
                params.put("Ngaysinh",ngaysinh.getText().toString());
                String phai;
                if (nam.isChecked())
                    phai="nam";
                else
                    phai="nữ";

                params.put("Phai",phai);
                params.put("SDT",sdt.getText().toString());
                params.put("Diachi",diachi.getText().toString());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

}