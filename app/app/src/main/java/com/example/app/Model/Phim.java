package com.example.app.Model;

public class Phim {
    private int ID;
    private int Diem;
    private String Hinh, Ten, TheLoai, Trangthai, Mota, Dinhdang, Trailer, Daodien, Thoiluong, Ngaykhoichieu, DoTuoi;

    public Phim(int ID, int diem, String hinh, String ten, String theLoai,
                String trangthai, String mota, String dinhdang, String ngaykhoichieu, String doTuoi,
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
        Ngaykhoichieu = ngaykhoichieu;
        DoTuoi = doTuoi;
    }
    public Phim(int ID, int diem, String hinh, String ten, String theLoai) {
        this.ID = ID;
        Diem = diem;
        Hinh = hinh;
        Ten = ten;
        TheLoai = theLoai;
    }

    public Phim(int ID,int diem,String hinh,String ten,String thoiluong,String ngaykhoichieu,String dotuoi){
        this.ID = ID;
        Diem = diem;
        Hinh = hinh;
        Ten = ten;
        Thoiluong = thoiluong;
        Ngaykhoichieu = ngaykhoichieu;
        DoTuoi = dotuoi;
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

    public String getNgaykhoichieu() {
        return Ngaykhoichieu;
    }

    public void setNgaykhoichieu(String ngaykhoichieu) {
        Ngaykhoichieu = ngaykhoichieu;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDoTuoi() {
        return DoTuoi;
    }

    public void setDoTuoi(String doTuoi) {
        DoTuoi = doTuoi;
    }
}
