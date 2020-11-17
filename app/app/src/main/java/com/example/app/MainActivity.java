package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.app.giaodien.TrangChu.TrangChuActivity;
import com.example.app.giaodien.TrangTimKiem.TimKiemActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent t = new Intent(this, TimKiemActivity.class);
        startActivity(t);
    }
}