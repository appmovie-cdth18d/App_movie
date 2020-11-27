package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app.giaodien.DanhSachPhim.DanhsachphimActivity;
import com.example.app.giaodien.DatVeVaThanhToan.ChonGheActivity;
import com.example.app.giaodien.DatVeVaThanhToan.DatVeActivity;
import com.example.app.giaodien.ThongTinKhachHang.ThongTinKhachHang;
import com.example.app.giaodien.TrangChu.PageAdapter;
import com.example.app.giaodien.TrangChu.Trangchu;
import com.example.app.giaodien.TrangTimKiem.TrangTimKiem;
import com.example.app.giaodien.dangky;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    EditText user;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.inputEmail);
        pass = (EditText) findViewById(R.id.inputPassword);

    }

    public void LOGIN(View view) {
        Intent t = new Intent(this, Trangchu.class);
        startActivity(t);
        /*if (user.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Chưa nhập User", Toast.LENGTH_SHORT).show();
        }
        if (pass.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Chưa nhập PassWord", Toast.LENGTH_SHORT).show();
        }
        if (user.getText().toString().equals(pass.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(), "Đăng nhập thất bại, vui lòng kiểm tra lại", Toast.LENGTH_SHORT).show();
    */
    }

    public void gotoRegister(View view) {
        Intent intent = new Intent(MainActivity.this, dangky.class);
        startActivity(intent);
    }
}