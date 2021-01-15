package com.example.app.giaodien.ThongTinKhachHang;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.app.MainActivity;
import com.example.app.R;
import com.example.app.giaodien.DanhSachPhim.DanhsachphimActivity;
import com.example.app.giaodien.DatVeVaThanhToan.ChonGheActivity;
import com.example.app.giaodien.DatVeVaThanhToan.DatVeActivity;
import com.example.app.giaodien.DatVeVaThanhToan.ThanhToanActivity;
import com.example.app.giaodien.TrangTimKiem.TrangTimKiem;
import com.google.android.material.navigation.NavigationView;

public class ThongTinKhachHang extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    private String url;
    private int id;
    TextView name;
    SharedPreferences taikhoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_khach_hang);
        Intent intent = getIntent();
        taikhoan = getSharedPreferences("TK",MODE_PRIVATE);
        id = taikhoan.getInt("ID_TK",0);
        url = "http://192.168.0.10:8080/cinema_admin/api/taikhoan/"+id+"";
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_khachhang);
        toolbar = (Toolbar) findViewById(R.id.toolbar_khachhang);
        name = findViewById(R.id.txtName_TK);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        nav = (NavigationView) findViewById(R.id.navView_khachhang);
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
                        t = new Intent(getApplicationContext(), DatVeActivity.class);
                        startActivity(t);
                        drawerLayout.closeDrawer(nav);
                        break;
                    case R.id.ve_phim:
                        t = new Intent(getApplicationContext(), DanhsachphimActivity.class);
                        startActivity(t);
                        drawerLayout.closeDrawer(nav);
                        break;
                    case R.id.dangxuat:
                        taikhoan = getSharedPreferences("TK", MODE_PRIVATE);
                        SharedPreferences.Editor editor = taikhoan.edit();
                        editor.remove("ID_TK");
                        editor.remove("Email");
                        editor.remove("Pass");
                        editor.remove("Name");
                        editor.commit();
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
    }

    public void Thongtin(View view) {

        Intent t = new Intent(this, SuaThongTin.class);
        t.putExtra("url", url);
        this.startActivity(t);
    }

    public void LichSu(View view) {
        Intent t = new Intent(this, GiaoDich.class);
        this.startActivity(t);
    }

    public void DoiMatKhau(View view) {
        Intent t = new Intent(this, DoiMatKhauActivity.class);
        t.putExtra("url", url);
        this.startActivity(t);
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