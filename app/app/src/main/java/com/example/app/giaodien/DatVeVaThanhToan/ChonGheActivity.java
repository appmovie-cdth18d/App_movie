package com.example.app.giaodien.DatVeVaThanhToan;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.app.MainActivity;
import com.example.app.R;
import com.example.app.giaodien.DanhSachPhim.DanhsachphimActivity;
import com.example.app.giaodien.ThongTinKhachHang.ThongTinKhachHang;
import com.example.app.giaodien.TrangTimKiem.TrangTimKiem;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class ChonGheActivity extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_ghe);
        Intent intent = getIntent();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_chonghe);
        toolbar = (Toolbar) findViewById(R.id.toolbar_chonghe);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        nav = (NavigationView) findViewById(R.id.navView_chonghe);
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
                        t = new Intent(getApplicationContext(), ThongTinKhachHang.class);
                        startActivity(t);
                        drawerLayout.closeDrawer(nav);
                        break;
                    case R.id.ve_phim:
                        t = new Intent(getApplicationContext(), DanhsachphimActivity.class);
                        startActivity(t);
                        drawerLayout.closeDrawer(nav);
                        break;
                    case R.id.dangxuat:
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

        List<Ghe> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new GidAdapter(this, image_details));

    }

    public void ChonGhe(View view) {
        Intent intent = new Intent(ChonGheActivity.this,ThanhToanActivity.class);
        this.startActivity(intent);
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

    private  List<Ghe> getListData() {
        List<Ghe> list = new ArrayList<Ghe>();
        Ghe so1 = new Ghe("00", 3, 1,0);
        Ghe so2 = new Ghe("01", 3, 1,0);
        Ghe so3 = new Ghe("02", 3, 1,0);
        Ghe so4 = new Ghe("03", 3, 1,0);
        Ghe so5 = new Ghe("04", 3, 1,0);
        Ghe so6 = new Ghe("05", 3, 1,0);

        list.add(so1);
        list.add(so2);
        list.add(so3);
        list.add(so4);
        list.add(so5);
        list.add(so6);
        return list;
    }
}