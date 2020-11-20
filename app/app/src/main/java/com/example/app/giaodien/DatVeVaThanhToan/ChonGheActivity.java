package com.example.app.giaodien.DatVeVaThanhToan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;

public class ChonGheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_ghe);
        Intent intent = getIntent();
    }

    public void ChonGhe(View view) {
        Intent intent = new Intent(ChonGheActivity.this,ThanhToanActivity.class);
        this.startActivity(intent);
    }
    public void QuayLai(View view) {
        Intent t = new Intent(this, DatVeActivity.class);
        this.startActivity(t);
    }
}