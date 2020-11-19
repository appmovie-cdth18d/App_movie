package com.example.app.giaodien.TrangTimKiem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.app.Model.Phim;
import com.example.app.R;

import java.util.ArrayList;
import java.util.List;

public class fragment_TrangTimKiem extends Fragment {
    private EditText edtTim;
    private ImageButton btnTimKiem;
    private RecyclerView recyclerPhim;
    private TimKiemAdapter timKiemAdapter;
    private List<Phim> lstPhim;
    View v;
    public fragment_TrangTimKiem() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_timkiem, container, false);
        edtTim = (EditText) v.findViewById(R.id.edtTimKiem);
        btnTimKiem = (ImageButton) v.findViewById(R.id.btnTim);

        recyclerPhim = (RecyclerView) v.findViewById(R.id.recylerPhim);
        timKiemAdapter = new TimKiemAdapter(lstPhim, recyclerPhim);

        recyclerPhim.setAdapter(timKiemAdapter);
        recyclerPhim.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }

    public void Init() {

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
        recyclerPhim.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}