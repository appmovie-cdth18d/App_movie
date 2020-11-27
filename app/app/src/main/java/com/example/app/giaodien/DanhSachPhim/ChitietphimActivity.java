package com.example.app.giaodien.DanhSachPhim;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;

public class ChitietphimActivity extends AppCompatActivity {

    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietphim);

        videoView = findViewById(R.id.videoView);
        String videoPath = "android.resource://"+ getPackageName() + "/"+ R.raw.cua_lai_vo_bau;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();

        //Bundle bundle = getIntent().getExtras();
    }

    public void back(View view) {
        Intent intent = new Intent(ChitietphimActivity.this, DanhsachphimActivity.class);
        startActivity(intent);
    }
}