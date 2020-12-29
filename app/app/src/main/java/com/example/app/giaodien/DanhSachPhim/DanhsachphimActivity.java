package com.example.app.giaodien.DanhSachPhim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.giaodien.DanhSachPhim.TrangPhim.fimlAdapter;

import java.util.ArrayList;

public class DanhsachphimActivity extends AppCompatActivity {

    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachphim);

        lst = (ListView)findViewById(R.id.listView);
        //Tạo dữ liệu
//        final ArrayList<fiml> arrayList = new ArrayList<>();
//
//        arrayList.add(new fiml(R.drawable.tiec_trang_mau,"TIỆC TRĂNG MÁU","23thg 10 2020","1giờ 46phút","18+", R.raw.cua_lai_vo_bau));
//        arrayList.add(new fiml(R.drawable.rom,"RÒM","31thg 7 2020","1giờ 46phút","18+", R.raw.cua_lai_vo_bau));
//        arrayList.add(new fiml(R.drawable.mat_biec,"MẮT BIẾC","20thg 12 2019","1giờ 46phút","18+", R.raw.cua_lai_vo_bau));
//        arrayList.add(new fiml(R.drawable.phap_su_mu,"PHÁP SƯ MÙ","8thg 11 2019","1giờ 46phút","18+", R.raw.cua_lai_vo_bau));
//        arrayList.add(new fiml(R.drawable.hai_phuong,"HAI PHƯỢNG","22thg 2 2019","1giờ 46phút","18+", R.raw.cua_lai_vo_bau));
//        arrayList.add(new fiml(R.drawable.cua_lai_vo_bau,"CUA LẠI VỢ BẦU","5thg 2 2019","1giờ 46phút","18+", R.raw.cua_lai_vo_bau));
//        arrayList.add(new fiml(R.drawable.tam_cam,"TẤM CÁM","5thg 2 2019","1giờ 46phút","18+", R.raw.cua_lai_vo_bau));
//        arrayList.add(new fiml(R.drawable.ong_ngoai_tuoi_30,"ÔNG NGOẠI TUỔI 30","30thg 3 2018","1giờ 46phút","18+", R.raw.cua_lai_vo_bau));
//        arrayList.add(new fiml(R.drawable.sieu_sao_sieu_ngo,"SIÊU SAO SIÊU NGỐ","16thg 2 2018","1giờ 46phút","18+", R.raw.cua_lai_vo_bau));
//        arrayList.add(new fiml(R.drawable.em_chua_18,"EM CHƯA 18","28thg 4 2017","1giờ 46phút","18+", R.raw.cua_lai_vo_bau));
//        arrayList.add(new fiml(R.drawable.trang_quynh,"TRẠNG QUỲNH","19thg 8 2016","1giờ 46phút","18+", R.raw.cua_lai_vo_bau));
//
//        //Khai báo fimlAdapter
//        fimlAdapter fimlAdapter = new fimlAdapter(this, R.layout.list_phim,arrayList);
//        lst.setAdapter(fimlAdapter);
//
//        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(DanhsachphimActivity.this, ChitietphimActivity.class);
//                intent.putExtra("tenFiml",lst.getItemAtPosition(position).toString());
//                startActivity(intent);
//            }
//        });
    }
}