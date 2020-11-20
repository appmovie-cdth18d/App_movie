package com.example.app.giaodien.ThongTinKhachHang;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app.R;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {


    private List<Ve> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext,  List<Ve> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_layout, null);
            holder = new ViewHolder();
            holder.flagView = (ImageView) convertView.findViewById(R.id.imglichsugiaodich);
            holder.tenphim = (TextView) convertView.findViewById(R.id.txttenphimlichsugiaodich);
            holder.rap = (TextView) convertView.findViewById(R.id.txtraplichsugiaodich);
            holder.soghe = (TextView) convertView.findViewById(R.id.txtghelichsugiaodich);
            holder.giave = (TextView) convertView.findViewById(R.id.txtgialichsugiaodich);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Ve Ve = this.listData.get(position);
        holder.tenphim.setText(Ve.getTenphim());
        holder.rap.setText("Rạp: " + Ve.getRap());
        holder.soghe.setText("Ghế: " + Ve.getSoghe());
        holder.giave.setText("Giá Vé: " + Ve.getGiave());

        holder.flagView.setImageResource(Ve.getHinhanhphim());

        return convertView;
    }

    // Find Image ID corresponding to the name of the image (in the directory mipmap).
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder {
        ImageView flagView;
        TextView tenphim;
        TextView rap;
        TextView soghe;
        TextView giave;
    }
}
