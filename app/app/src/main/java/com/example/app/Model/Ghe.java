package com.example.app.Model;

public class Ghe {
    private String soghe_;
    private  int id;
    private int loaigheid_;
    private int rap_;
    private int trangthai_;
    private int gia;

    public Ghe (int id, String soghe, int loaigheid, int rap, int trangthai, int giatien) {
        this.setSoghe_(soghe);
        this.setLoaigheid_(loaigheid);
        this.setRap_(rap);
        this.setTrangthai_(trangthai);
        this.setGia(giatien);
        this.setId(id);
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

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}