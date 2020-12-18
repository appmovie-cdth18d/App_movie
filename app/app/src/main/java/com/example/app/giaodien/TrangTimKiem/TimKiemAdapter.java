package com.example.app.giaodien.TrangTimKiem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.Model.Phim;
import com.example.app.R;

import java.util.ArrayList;
import java.util.List;

public class TimKiemAdapter extends BaseAdapter {
    private List<Phim> lstPhim;
    private Context context;
    private int layout;

    public TimKiemAdapter(List<Phim> lstPhim, Context context, int layout) {
        this.lstPhim = lstPhim;
        this.context = context;
        this.layout = layout;
    }

    //Hàm cập nhật lại listview khi search
    public void Update(List<Phim> result){
        lstPhim = new ArrayList<>();
        lstPhim.addAll(result);
        notifyDataSetChanged(); //Thông báo data trong listview thay đổi cần refresh lại data
    }
    private class ViewHolder{
        TextView txtname, txttheloai;
        ImageView img;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.imgPhim);
            viewHolder.txtname = (TextView) convertView.findViewById(R.id.txt_tieude);
            viewHolder.txttheloai = (TextView) convertView.findViewById(R.id.txtTheloai);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Phim phim = lstPhim.get(position);
        viewHolder.img.setImageResource(phim.getHinh());
        viewHolder.txtname.setText(phim.getTen());
        viewHolder.txttheloai.setText(phim.getTheLoai());
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.animation_left);
        convertView.startAnimation(animation);
        return convertView;
    }

    @Override
    public int getCount() {
        return lstPhim.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
