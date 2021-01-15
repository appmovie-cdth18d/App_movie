package com.example.app.Model;

public class BinhLuan {
    private int ID;
    private String NoiDung;
    private String TaiKhoan;
    private String NgayDang;

    public BinhLuan (int id, String taiKhoan, String noiDung, String ngayDang){
        this.ID = id;
        TaiKhoan = taiKhoan;
        NoiDung = noiDung;
        NgayDang = ngayDang;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public int getID() {
        return ID;
    }

    public String getNgayDang() {
        return NgayDang;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setNgayDang(String ngayDang) {
        NgayDang = ngayDang;
    }

    public void setTaiKhoan(String taiKhoan) {
        TaiKhoan = taiKhoan;
    }
}
