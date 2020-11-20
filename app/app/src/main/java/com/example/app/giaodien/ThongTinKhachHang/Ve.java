package com.example.app.giaodien.ThongTinKhachHang;

public class Ve {
    private int hinhanhphim;
    private String tenphim;
    private String rap;
    private String soghe;
    private int giave;

    public Ve(int hinhanhphim, String tenphim, String rap, String soghe, int giave) {
        this.setHinhanhphim(hinhanhphim);
        this.setTenphim(tenphim);
        this.setRap(rap);
        this.setSoghe(soghe);
        this.setGiave(giave);
    }

    public int getHinhanhphim() {
        return hinhanhphim;
    }

    public void setHinhanhphim(int hinhanhphim) {
        this.hinhanhphim = hinhanhphim;
    }

    public int getGiave() {
        return giave;
    }

    public void setGiave(int giave) {
        this.giave = giave;
    }

    public String getTenphim() {
        return tenphim;
    }

    public void setTenphim(String tenphim) {
        this.tenphim = tenphim;
    }

    public String getRap() {
        return rap;
    }

    public void setRap(String rap) {
        this.rap = rap;
    }

    public String getSoghe() {
        return soghe;
    }

    public void setSoghe(String soghe) {
        this.soghe = soghe;
    }
}

