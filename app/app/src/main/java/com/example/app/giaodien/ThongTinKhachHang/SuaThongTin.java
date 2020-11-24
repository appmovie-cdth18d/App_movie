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

import com.example.app.R;

public class SuaThongTin extends AppCompatActivity {
    Toolbar toolbar;
    String gioitinh;
    EditText hoten, sdt,email, ngay, tendangnhap;
    RadioButton nam, nu;
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
        //json
        try{
            khachhang khachhang = ReadJSONExample.readCompanyJSONFile(this);
            hoten.setText(khachhang.getHoten());
            tendangnhap.setText(khachhang.getTendangnhap());
            sdt.setText(khachhang.getSdt());
            ngay.setText(khachhang.getNgay());
            email.setText(khachhang.getGmail());
        } catch (Exception e){
            e.printStackTrace();
        }
        //
        suathongtin = (Button) findViewById(R.id.btnsuathongtin);
        suathongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nam.isChecked())
                {
                    hoten.setText(hoten+"");
                    sdt.setText(sdt+"");
                    email.setText(email+"");
                    ngay.setText(ngay+"");
                    tendangnhap.setText(tendangnhap+"");
                    nam.setChecked(true);
                } else {
                    hoten.setText(hoten+"");
                    sdt.setText(sdt+"");
                    email.setText(email+"");
                    ngay.setText(ngay+"");
                    tendangnhap.setText(tendangnhap+"");
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

}