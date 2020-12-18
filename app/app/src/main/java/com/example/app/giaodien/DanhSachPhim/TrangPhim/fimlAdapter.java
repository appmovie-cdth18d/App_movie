package com.example.app.giaodien.DanhSachPhim.TrangPhim;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.app.Model.fiml;
import com.example.app.R;

import java.util.ArrayList;

public class fimlAdapter extends ArrayAdapter<fiml> {
    private Context mContext;
    private int mResource;


    public fimlAdapter(@NonNull Context context, int resource, @NonNull ArrayList<fiml> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }
    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource,parent,false);
        VideoView videoView = convertView.findViewById(R.id.videoView);

        ImageView imageView = convertView.findViewById(R.id.imgPhim);

        TextView txtName = convertView.findViewById(R.id.txtTenPhim);

        TextView txtKhoiChieu = convertView.findViewById(R.id.txtNgayKhoiChieu);

        TextView txtThoiGIan = convertView.findViewById(R.id.txtTimeChieu);

        TextView txtDoTuoi = convertView.findViewById(R.id.txtDoTuoi);

        imageView.setImageResource(getItem(position).getImage());

        //videoView.setVideoPath(getItem(position).getVideo());

        txtName.setText(getItem(position).getTenFiml());

        txtKhoiChieu.setText(getItem(position).getNgayCongChieu());

        txtThoiGIan.setText(getItem(position).getThoiGianChieu());

        //txtDoTuoi.setText(getItem(position).getDoTuoi());

        return convertView;
    }

}
