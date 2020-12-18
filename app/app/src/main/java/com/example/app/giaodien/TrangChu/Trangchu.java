package com.example.app.giaodien.TrangChu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.app.MainActivity;
import com.example.app.R;
import com.example.app.giaodien.DanhSachPhim.DanhsachphimActivity;
import com.example.app.giaodien.DatVeVaThanhToan.DatVeActivity;
import com.example.app.giaodien.ThongTinKhachHang.ThongTinKhachHang;
import com.example.app.giaodien.TrangTimKiem.TrangTimKiem;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class Trangchu extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapter pageAdapter;

    private TextView txtTim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        //Ánh xạ dữ liệu
        Anhxa();
        //Khởi tạo menu drawable
        Menu();
        //Khởi tạo trang slide phim
        PagePhim();

        txtTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(getApplicationContext(), TrangTimKiem.class);
                startActivity(t);
            }
        });
    }
    public void Anhxa(){
        txtTim = (TextView) findViewById(R.id.txt_timkiem);
        //ánh xạ menu
        drawerLayout = (DrawerLayout) findViewById(R.id.drawable_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        nav = (NavigationView) findViewById(R.id.navView_main);

        //Ánh xạ Page chuyển trang
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.pagePhim);

        //Slide phim hot

    }
    public void Menu(){

        setSupportActionBar(toolbar);
        nav.bringToFront();
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
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
    }
    public void PagePhim(){
        tabLayout.addTab(tabLayout.newTab().setText("Phim Đang Chiếu"));
        tabLayout.addTab(tabLayout.newTab().setText("Phim Sắp Chiếu"));

        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);

        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}