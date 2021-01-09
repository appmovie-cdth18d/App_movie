package com.example.app.Model;

public class SuatChieu {
    private String GioChieu;
    private int Phim_Id;
    private int Rap_Id;

    public SuatChieu (String gioChieu, int phim_Id, int rap_Id) {
        this.setGioChieu(gioChieu);
        this.setPhim_Id(phim_Id);
        this.setRap_Id(rap_Id);
    }

    public String getGioChieu() {
        return GioChieu;
    }

    public void setGioChieu(String gioChieu) {
        GioChieu = gioChieu;
    }

    public int getPhim_Id() {
        return Phim_Id;
    }

    public void setPhim_Id(int phim_Id) {
        Phim_Id = phim_Id;
    }

    public int getRap_Id() {
        return Rap_Id;
    }

    public void setRap_Id(int rap_Id) {
        Rap_Id = rap_Id;
    }
}
