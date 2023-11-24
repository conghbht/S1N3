/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author dovan
 */
public class Imei {

    private int ma;
    private String soImei;
    private int maSanPhamChiTiet;
    private boolean trangThai;

    public Imei() {
    }

    public Imei(int ma, String soImei, int maSanPhamChiTiet) {
        this.ma = ma;
        this.soImei = soImei;
        this.maSanPhamChiTiet = maSanPhamChiTiet;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getSoImei() {
        return soImei;
    }

    public void setSoImei(String soImei) {
        this.soImei = soImei;
    }

    public int getMaSanPhamChiTiet() {
        return maSanPhamChiTiet;
    }

    public void setMaSanPhamChiTiet(int maSanPhamChiTiet) {
        this.maSanPhamChiTiet = maSanPhamChiTiet;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
