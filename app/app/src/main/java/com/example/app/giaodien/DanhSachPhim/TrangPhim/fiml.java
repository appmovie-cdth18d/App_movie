package com.example.app.giaodien.DanhSachPhim.TrangPhim;

public class fiml {
    int Image;
    String TenFiml;
    String NgayCongChieu;
    String ThoiGianChieu;
    String DoTuoi;
    int Video;

    public fiml(int image, String tenFiml, String ngayCongChieu, String thoiGianChieu, String doTuoi,int video) {
        Image = image;
        TenFiml = tenFiml;
        NgayCongChieu = ngayCongChieu;
        ThoiGianChieu = thoiGianChieu;
        DoTuoi = doTuoi;
        Video = video;
    }


    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTenFiml() {
        return TenFiml;
    }

    public void setTenFiml(String tenFiml) {
        TenFiml = tenFiml;
    }

    public String getNgayCongChieu() {
        return NgayCongChieu;
    }

    public void setNgayCongChieu(String ngayCongChieu) {
        NgayCongChieu = ngayCongChieu;
    }

    public String getThoiGianChieu() {
        return ThoiGianChieu;
    }

    public void setThoiGianChieu(String thoiGianChieu) {
        ThoiGianChieu = thoiGianChieu;
    }

    public String getDoTuoi() {
        return DoTuoi;
    }

    public void setDoTuoi(String doTuoi) {
        DoTuoi = doTuoi;
    }
    public int getVideo(){
        return Video;
    }

    public  void setVideo(int video){
        Video = video;
    }
}
