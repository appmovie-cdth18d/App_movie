package com.example.app.Model;

public class Phim {
    private int ID = 0;
    private int Hinh, diem, trailer;
    private String Ten, TheLoai, mota, tendaodien, tentrangthai, loaidinhdang;

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public int getTrailer() {
        return trailer;
    }

    public void setTrailer(int trailer) {
        this.trailer = trailer;
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

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getTendaodien() {
        return tendaodien;
    }

    public void setTendaodien(String tendaodien) {
        this.tendaodien = tendaodien;
    }

    public String getTentrangthai() {
        return tentrangthai;
    }

    public void setTentrangthai(String tentrangthai) {
        this.tentrangthai = tentrangthai;
    }

    public String getLoaidinhdang() {
        return loaidinhdang;
    }

    public void setLoaidinhdang(String loaidinhdang) {
        this.loaidinhdang = loaidinhdang;
    }

    public Phim(int hinh, int diem, int trailer, String ten, String theLoai, String mota, String tendaodien, String tentrangthai, String loaidinhdang) {
        Hinh = hinh;
        this.diem = diem;
        this.trailer = trailer;
        Ten = ten;
        TheLoai = theLoai;
        this.mota = mota;
        this.tendaodien = tendaodien;
        this.tentrangthai = tentrangthai;
        this.loaidinhdang = loaidinhdang;
    }
}
