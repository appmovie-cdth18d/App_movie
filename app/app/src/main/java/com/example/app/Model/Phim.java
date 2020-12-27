package com.example.app.Model;

public class Phim {
    private int ID;
    private int Diem;
    private String Hinh, Ten, TheLoai;

    public int getID() {
        return ID;
    }

    public int getDiem() {
        return Diem;
    }

    public void setDiem(int diem) {
        Diem = diem;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String hinh) {
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

    public Phim(int ID, int diem, String hinh, String ten, String theLoai) {
        this.ID = ID;
        Diem = diem;
        Hinh = hinh;
        Ten = ten;
        TheLoai = theLoai;
    }
}
