package com.example.app.giaodien.ThongTinKhachHang;

public class khachhang {
    private int id;
    private String tendangnhap;
    private String hoten;
    private String gmail;
    private String sdt;
    private String ngay;
    private String gioitinh;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n id:" + this.id);
        sb.append("\n tendangnhap:" + this.tendangnhap);
        sb.append("\n hoten:" + this.hoten);
        sb.append("\n gmail:" + this.gmail);
        sb.append("\n sdt:" + this.sdt);
        sb.append("\n ngaysinh:"+this.ngay);
        sb.append("\n gioitinh:" + this.gioitinh);
        return sb.toString();
    }
}
