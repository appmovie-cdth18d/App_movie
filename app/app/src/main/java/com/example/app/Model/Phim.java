package com.example.app.Model;

public class Phim {
    private int ID;
    private int Diem;
    private String Hinh, Ten, TheLoai, Trangthai, Mota, Dinhdang, Trailer, Daodien, Thoiluong;

    public Phim(int ID, int diem, String hinh, String ten, String theLoai,
                String trangthai, String mota, String dinhdang,
                String trailer, String daodien, String thoiluong) {
        this.ID = ID;
        Diem = diem;
        Hinh = hinh;
        Ten = ten;
        TheLoai = theLoai;
        Trangthai = trangthai;
        Mota = mota;
        Dinhdang = dinhdang;
        Trailer = trailer;
        Daodien = daodien;
        Thoiluong = thoiluong;
    }
    public Phim(int ID, int diem, String hinh, String ten, String theLoai) {
        this.ID = ID;
        Diem = diem;
        Hinh = hinh;
        Ten = ten;
        TheLoai = theLoai;
    }
    public String getTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(String trangthai) {
        Trangthai = trangthai;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public String getDinhdang() {
        return Dinhdang;
    }

    public void setDinhdang(String dinhdang) {
        Dinhdang = dinhdang;
    }

    public String getTrailer() {
        return Trailer;
    }

    public void setTrailer(String trailer) {
        Trailer = trailer;
    }

    public String getDaodien() {
        return Daodien;
    }

    public void setDaodien(String daodien) {
        Daodien = daodien;
    }

    public String getThoiluong() {
        return Thoiluong;
    }

    public void setThoiluong(String thoiluong) {
        Thoiluong = thoiluong;
    }

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

}
