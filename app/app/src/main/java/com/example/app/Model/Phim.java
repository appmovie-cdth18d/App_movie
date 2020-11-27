package com.example.app.Model;

public class Phim {
    private int ID = 0;
    private int Hinh;
    private String Ten, TheLoai;

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String theLoai) {
        TheLoai = theLoai;
    }

    public Phim(int hinh, String ten, String theLoai) {
        Hinh = hinh;
        Ten = ten;
        TheLoai = theLoai;
    }

}
