package com.example.app.giaodien.TrangTimKiem;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app.MainActivity;
import com.example.app.Model.Phim;
import com.example.app.Networking.MyAsyncTask;
import com.example.app.R;
import com.example.app.giaodien.DanhSachPhim.DanhsachphimActivity;
import com.example.app.giaodien.ThongTinKhachHang.ThongTinKhachHang;
import com.example.app.giaodien.TrangChu.Trangchu;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TrangTimKiem extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private static final String URL_CONNECT = "http://10.0.2.2:8080/cinema_admin/api/phim";
    private LoaderManager loaderManager;

    private List<Phim> filter_phim;
    private List<Phim> lstPhim;

    private RecyclerView recy_Phim;
    private TimKiemAdapter timKiemAdapter;
    private SearchView search;

    private NavigationView nav;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timkiem);

        search = (SearchView) findViewById(R.id.search_Phim);
        recy_Phim = (RecyclerView) findViewById(R.id.list_Phim);

        Menu();

        Bundle bundle = new Bundle();
        bundle.putString("url", URL_CONNECT);
        loaderManager = LoaderManager.getInstance(this);
        loaderManager.initLoader(1, bundle, this);
//        Load_data("http://10.0.2.2:8080/cinema_admin/api/phim");

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                timKiemAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                timKiemAdapter.getFilter().filter(newText);
                return false;
            }
        });

    }

    public void Menu() {
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

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new MyAsyncTask(this, args.getString("url"));
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            JSONArray arr_Phim = new JSONArray(data);
            JSONObject item_phim;
            lstPhim = new LinkedList<>();

            int ID, Diem;
            String Hinhanh, Tenphim, Theloai;
            int len = arr_Phim.length();
            for (int i = 0; i < len; i++) {
                try {
                    item_phim = (JSONObject) arr_Phim.get(i);
                    ID = item_phim.getInt("id");
                    Diem = item_phim.getInt("Diem");
                    Hinhanh = item_phim.getString("Hinhanh");
                    Tenphim = item_phim.getString("Tenphim");
                    Theloai = item_phim.getString("Tentheloai");

                    lstPhim.add(new Phim(ID, Diem, Hinhanh, Tenphim, Theloai));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            timKiemAdapter = new TimKiemAdapter(lstPhim, getApplicationContext());
            recy_Phim.setAdapter(timKiemAdapter);
            recy_Phim.setLayoutManager(new LinearLayoutManager(TrangTimKiem.this));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}