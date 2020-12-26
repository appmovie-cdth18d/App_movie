package com.example.app.giaodien.ThongTinKhachHang;


public class TaiKhoan {
    private int id;
    private String HoTen;
    private String Ten_TK;
    private String SDT;
    private String DiaChi;
    private String NgaySinh;
    private String GioiTinh;

    public TaiKhoan(){

    }
    public TaiKhoan(int id, String HoTen, String Ten_TK, String SDT, String DiaChi, String NgaySinh, String GioiTinh){
        this.id = id;
        setHoTen(HoTen);
        setDiaChi(DiaChi);
        setGioiTinh(GioiTinh);
        setNgaySinh(NgaySinh);
        setTen_TK(Ten_TK);
        setSDT(SDT);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getTen_TK() {
        return Ten_TK;
    }

    public void setTen_TK(String ten_TK) {
        Ten_TK = ten_TK;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }
}
