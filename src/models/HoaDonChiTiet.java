/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author dovan
 */
public class HoaDonChiTiet {

    private int maHDCT;
    private int maHD;
    private int maImei;
    private double donGia;
    private int soLuong;
    private float tongGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int maHDCT, int maHD, int maImei, double donGia, int soLuong, float tongGia) {
        this.maHDCT = maHDCT;
        this.maHD = maHD;
        this.maImei = maImei;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.tongGia = tongGia;
    }

    public int getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(int maHDCT) {
        this.maHDCT = maHDCT;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaImei() {
        return maImei;
    }

    public void setMaImei(int maImei) {
        this.maImei = maImei;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getTongGia() {
        return tongGia;
    }

    public void setTongGia(float tongGia) {
        this.tongGia = tongGia;
    }

}
