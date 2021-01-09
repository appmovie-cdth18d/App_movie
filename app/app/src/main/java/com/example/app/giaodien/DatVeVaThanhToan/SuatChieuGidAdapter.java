package com.example.app.giaodien.DatVeVaThanhToan;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.app.Model.SuatChieu;
import com.example.app.R;

import java.util.List;

public class SuatChieuGidAdapter  extends BaseAdapter {
    private List<SuatChieu> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public SuatChieuGidAdapter(Context aContext,  List<SuatChieu> listData) {
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
        if (position < 0 || position >= getCount()) {
            return null;
        } else {
         return listData.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.grid_item_giochieu_layout, null);
            holder = new ViewHolder();
            holder.giochieu = (TextView) convertView.findViewById(R.id.giochieu);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        SuatChieu suatChieu = this.listData.get(position);
        holder.giochieu.setText(suatChieu.getGioChieu());
        return convertView;
    }
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();

        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomGridView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder {
        TextView giochieu;
    }
}
