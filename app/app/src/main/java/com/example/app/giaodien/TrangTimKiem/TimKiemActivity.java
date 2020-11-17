package com.example.app.giaodien.TrangTimKiem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.app.Phim;
import com.example.app.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TimKiemActivity extends AppCompatActivity {
    private EditText edtTim;
    private ImageButton btnTimKiem;
    private RecyclerView recyclerPhim;
    private TimKiemAdapter timKiemAdapter;
    private List<Phim> lstPhim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timkiem);
        Init();
    }

    public void Init() {
        edtTim = (EditText) findViewById(R.id.edtTimKiem);
        btnTimKiem = (ImageButton) findViewById(R.id.btnTim);

        recyclerPhim = (RecyclerView) findViewById(R.id.recylerPhim);
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