package com.example.app.giaodien.DanhSachPhim;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app.MainActivity;
import com.example.app.Model.Phim;
import com.example.app.R;
import com.example.app.giaodien.DanhSachPhim.TrangPhim.dsAdapter;
import com.example.app.giaodien.DanhSachPhim.TrangPhim.fimlAdapter;
import com.example.app.giaodien.ThongTinKhachHang.ThongTinKhachHang;
import com.example.app.giaodien.TrangChu.Trangchu;
import com.example.app.giaodien.DanhSachPhim.TrangPhim.dsAdapter;
import com.example.app.giaodien.TrangTimKiem.TimKiemAdapter;
import com.example.app.giaodien.TrangTimKiem.TrangTimKiem;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class DanhsachphimActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private NavigationView nav;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private dsAdapter dsAdapter;

    private int ID_Phim;

    public int getID_phim() {
        return ID_Phim;
    }

    public void setID_phim(int ID_phim) {
        this.ID_Phim = ID_phim;
    }
    private TextView txtTim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachphim);

        txtTim = (TextView) findViewById(R.id.txt_timkiem);
        //Ánh xạ menu
        drawerLayout = (DrawerLayout) findViewById(R.id.drawable_dsPhim);
        nav = (NavigationView) findViewById(R.id.navView_dsPhim);
        toolbar = (Toolbar) findViewById(R.id.tbListFiml);

        //Ánh xạ Page chuyển trang
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.pagePhim);
        Menu();



        txtTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(getApplicationContext(), TrangTimKiem.class);
                startActivity(t);
            }
        });
    }

    public void PagePhim() {
        tabLayout.addTab(tabLayout.newTab().setText("Phim Đang Chiếu"));
        tabLayout.addTab(tabLayout.newTab().setText("Phim Sắp Chiếu"));

        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);

        dsAdapter = new dsAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(dsAdapter);
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

    public void Menu() {
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
                        t = new Intent(getApplicationContext(), Trangchu.class);
                        startActivity(t);
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
}