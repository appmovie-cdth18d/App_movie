package com.example.app.giaodien.ThongTinKhachHang;

import android.content.Context;

import com.example.app.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadJSONExample {
    public static khachhang readCompanyJSONFile(Context context) throws IOException, JSONException {
        String jsontext = readText(context, R.raw.khachhang);

        JSONObject jsonRoot = new JSONObject(jsontext);
        int id = jsonRoot.getInt("id");
        String tendangnhap = jsonRoot.getString("tendangnhap");
        String hoten = jsonRoot.getString("hoten");
        String gmail = jsonRoot.getString("gmail");
        String sdt = jsonRoot.getString("sdt");
        String ngaysinh = jsonRoot.getString("ngaysinh");
        String gioitinh = jsonRoot.getString("gioitinh");

        khachhang khachhang = new khachhang();
        khachhang.setId(id);
        khachhang.setHoten(hoten);
        khachhang.setGmail(gmail);
        khachhang.setGioitinh(gioitinh);
        khachhang.setNgay(ngaysinh);
        khachhang.setSdt(sdt);
        khachhang.setTendangnhap(tendangnhap);
        return khachhang;
    }

    private static String readText(Context context, int khachhang) throws IOException{
        InputStream is = context.getResources().openRawResource(khachhang);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String s = null;
        while ((s = br.readLine())!=null){
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
}
