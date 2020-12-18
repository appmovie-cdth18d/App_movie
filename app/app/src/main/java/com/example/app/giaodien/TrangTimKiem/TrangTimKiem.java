package com.example.app.giaodien.TrangTimKiem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.app.MainActivity;
import com.example.app.Model.Phim;
import com.example.app.R;
import com.example.app.giaodien.DanhSachPhim.ChitietphimActivity;
import com.example.app.giaodien.DanhSachPhim.DanhsachphimActivity;
import com.example.app.giaodien.ThongTinKhachHang.ThongTinKhachHang;
import com.example.app.giaodien.TrangChu.Trangchu;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class TrangTimKiem extends AppCompatActivity {
    private ListView lvPhim;
    private List<Phim> filter_phim;
    private SearchView search;
    private TimKiemAdapter timKiemAdapter;
    private List<Phim> lstPhim;
    private NavigationView nav;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timkiem);

        Menu();
        lstPhim = new ArrayList<>();
        lstPhim.add(new Phim(R.mipmap.cucnohoacuccung, "Ròm", "Phim Hành Động"));
        lstPhim.add(new Phim(R.mipmap.cucnohoacuccung, "Đại Dịch Xác Sống", "Phim Kinh Dị"));
        lstPhim.add(new Phim(R.mipmap.cucnohoacuccung, "Cục Nợ Hóa Cục Cưng", "Phim Tình Cảm"));
        lstPhim.add(new Phim(R.mipmap.cucnohoacuccung, "Vì Sao Đưa Bạn Tới", "Phim Hoat Hình"));
        lstPhim.add(new Phim(R.mipmap.cucnohoacuccung, "Phi Vụ Hoàn Lương", "Phim Hành Động"));
        lstPhim.add(new Phim(R.mipmap.cucnohoacuccung, "Quái Vật Săn Đêm", "Phim Kinh Dị"));
        lstPhim.add(new Phim(R.mipmap.cucnohoacuccung, "Chiến Binh Hồi Sinh", "Phim Khoa Học Viễn Tưỡng"));
        lstPhim.add(new Phim(R.mipmap.cucnohoacuccung, "Tí Hon Hậu Đậu", "Phim Hoạt Hình"));
        lstPhim.add(new Phim(R.mipmap.cucnohoacuccung, "Tay Đấm Mỹ", "Phim Hành Động"));
        lstPhim.add(new Phim(R.mipmap.cucnohoacuccung, "Sóng Thần", "Phim Hành Động"));
        filter_phim = new ArrayList<>();

        lvPhim = (ListView) findViewById(R.id.list_Phim);
        timKiemAdapter = new TimKiemAdapter(lstPhim,getApplicationContext(),R.layout.item_phim);
        lvPhim.setAdapter(timKiemAdapter);
        lvPhim.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(filter_phim.isEmpty()) Toast.makeText(TrangTimKiem.this, ""+lstPhim.get(position).getTen(), Toast.LENGTH_SHORT).show();
                else Toast.makeText(TrangTimKiem.this, ""+filter_phim.get(position).getTen(), Toast.LENGTH_SHORT).show();
            }
        });

        search = (SearchView) findViewById(R.id.search_Phim);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            //Hàm xử lý xự kiện khi thay đổi listview theo từ khóa khi search
            @Override
            public boolean onQueryTextChange(String newText) {
                for (Phim x : lstPhim){
                    if(x.getTen().contains(newText))
                        filter_phim.add(x);
                }
                ((TimKiemAdapter)lvPhim.getAdapter()).Update(filter_phim);
                return false;
            }
        });
    }
    public void Menu(){
        drawerLayout = (DrawerLayout) findViewById(R.id.drawable_timkiem);
        toolbar = (Toolbar) findViewById(R.id.toolbar_timkiem);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        nav = (NavigationView) findViewById(R.id.navView_timkiem);
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