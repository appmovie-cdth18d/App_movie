package com.example.app.giaodien.ThongTinKhachHang;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.app.R;

import java.util.ArrayList;
import java.util.List;

public class GiaoDich extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giao_dich);
        Intent t = getIntent();
        List<Ve> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new CustomListAdapter(this, image_details));

        // When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Ve Ve = (Ve) o;
                Toast.makeText(GiaoDich.this, "Selected :" + " " + Ve, Toast.LENGTH_LONG).show();
            }
        });
        toolbar = (Toolbar) findViewById(R.id.toolbar_lichsugiaodich);
        setSupportActionBar(toolbar);
    }

    private  List<Ve> getListData() {
        List<Ve> list = new ArrayList<Ve>();
        Ve ConChimNon = new Ve(R.drawable.nam,"Con Chim Non", "Khá Bảnh","H11",75000);
        Ve SieuNhanGao = new Ve(R.drawable.nam,"Siêu Nhân Gao", "Khá Bảnh","G11",75000);
        Ve Friendzone = new Ve(R.drawable.nam,"Friendzone", "Khá Bảnh","F11",75000);
        Ve Alibaba = new Ve(R.drawable.nam,"Alibaba", "Khá Bảnh","E11",75000);
        Ve Shin = new Ve(R.drawable.nam,"Shin cậu bé bút chì", "Khá Bảnh","T11",75000);
        list.add(ConChimNon);
        list.add(SieuNhanGao);
        list.add(Friendzone);
        list.add(Alibaba);
        list.add(Shin);
        return list;
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