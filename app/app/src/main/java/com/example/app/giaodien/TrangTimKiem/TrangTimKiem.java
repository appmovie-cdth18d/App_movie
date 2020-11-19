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
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.app.MainActivity;
import com.example.app.Model.Phim;
import com.example.app.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class TrangTimKiem extends AppCompatActivity {
    private EditText edtTim;
    private ImageButton btnTimKiem;
    private RecyclerView recyclerPhim;
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
                        t = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(t);
                        break;
                    case R.id.tim:
                        break;
                    default:
                        return true;
                }
                return false;
            }
        });
        edtTim = (EditText) findViewById(R.id.edtTimKiem);
        btnTimKiem = (ImageButton) findViewById(R.id.btnTim);
        lstPhim = new ArrayList<>();
        lstPhim.add(new Phim(R.mipmap.movie_0, "Ròm", "Phim Hành Động"));
        lstPhim.add(new Phim(R.mipmap.movie_1, "Đại Dịch Xác Sống", "Phim Kinh Dị"));
        lstPhim.add(new Phim(R.mipmap.movie_2, "Cục Nợ Hóa Cục Cưng", "Phim Tình Cảm"));
        lstPhim.add(new Phim(R.mipmap.movie_3, "Vì Sao Đưa Bạn Tới", "Phim Hoat Hình"));
        lstPhim.add(new Phim(R.mipmap.movie_4, "Phi Vụ Hoàn Lương", "Phim Hành Động"));
        lstPhim.add(new Phim(R.mipmap.movie_5, "Quái Vật Săn Đêm", "Phim Kinh Dị"));
        lstPhim.add(new Phim(R.mipmap.movie_6, "Chiến Binh Hồi Sinh", "Phim Khoa Học Viễn Tưỡng"));
        lstPhim.add(new Phim(R.mipmap.movie_7, "Tí Hon Hậu Đậu", "Phim Hoạt Hình"));
        lstPhim.add(new Phim(R.mipmap.movie_8, "Tay Đấm Mỹ", "Phim Hành Động"));
        lstPhim.add(new Phim(R.mipmap.movie_9, "Sóng Thần", "Phim Hành Động"));
        recyclerPhim = (RecyclerView) findViewById(R.id.recylerPhim);
        timKiemAdapter = new TimKiemAdapter(lstPhim, recyclerPhim);

        recyclerPhim.setAdapter(timKiemAdapter);
        recyclerPhim.setLayoutManager(new LinearLayoutManager(this));
    }

    public void search_by_name(View v) {
        List<Phim> result = new ArrayList<>();
        int count = lstPhim.size();
        String tim = edtTim.getText().toString();
        for (int i = 0; i < count; i++) {
            if (lstPhim.get(i).getTen().indexOf(tim) > 0) {
                result.add(new Phim(lstPhim.get(i).getHinh(), lstPhim.get(i).getTen(),lstPhim.get(i).getTheLoai()));
            }
        }
        timKiemAdapter = new TimKiemAdapter(result, recyclerPhim);
        recyclerPhim.setAdapter(timKiemAdapter);
        recyclerPhim.setLayoutManager(new LinearLayoutManager(this));
    }
}