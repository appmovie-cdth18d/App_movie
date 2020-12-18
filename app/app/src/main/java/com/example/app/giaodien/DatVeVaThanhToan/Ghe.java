package com.example.app.giaodien.DatVeVaThanhToan;

public class Ghe {
    private String soghe_;
    private int loaigheid_;
    private int rap_;
    private int trangthai_;

    public Ghe (String soghe, int loaigheid, int rap, int trangthai) {
        this.setSoghe_(soghe);
        this.setLoaigheid_(loaigheid);
        this.setRap_(rap);
        this.setTrangthai_(trangthai);
    }

    public String getSoghe_() {
        return soghe_;
    }

    public void setSoghe_(String soghe_) {
        this.soghe_ = soghe_;
    }

    public int getLoaigheid_() {
        return loaigheid_;
    }

    public void setLoaigheid_(int loaigheid_) {
        this.loaigheid_ = loaigheid_;
    }

    public int getRap_() {
        return rap_;
    }

    public void setRap_(int rap_) {
        this.rap_ = rap_;
    }

    public int getTrangthai_() {
        return trangthai_;
    }

    public void setTrangthai_(int trangthai_) {
        this.trangthai_ = trangthai_;
    }
}