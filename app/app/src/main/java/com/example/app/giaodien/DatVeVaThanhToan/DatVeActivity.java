package com.example.app.giaodien.DatVeVaThanhToan;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.app.MainActivity;
import com.example.app.R;
import com.example.app.giaodien.ThongTinKhachHang.ThongTinKhachHang;
import com.example.app.giaodien.TrangTimKiem.TrangTimKiem;
import com.google.android.material.navigation.NavigationView;

public class DatVeActivity extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datve);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_datve);
        toolbar = (Toolbar) findViewById(R.id.toolbar_datve);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        nav = (NavigationView) findViewById(R.id.navView_datve);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Intent t;
                switch (id) {
                    case R.id.home:
                        t = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(t);
                        return true;
                    case R.id.tim:
                        t = new Intent(getApplicationContext(), TrangTimKiem.class);
                        startActivity(t);
                        return true;
                    case R.id.canhan:
                        t = new Intent(getApplicationContext(), ThongTinKhachHang.class);
                        startActivity(t);
                        return true;
                }
                return false;
            }
        });
    }

    public void ChonGio(View view) {
        Intent intent = new Intent(DatVeActivity.this, ChonGheActivity.class);
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
}