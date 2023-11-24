/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;
import javax.swing.ImageIcon;



/**
 *
 * @author dovan
 */
public class SanPham {
    private String maSP;
    private String ten;
    private String mota;
    private String anh;
    private int maHDH;
    private int maHang;
    
    public SanPham() {
    }

    public SanPham(String maSP, String ten, String mota, String anh, int maHDH, int maHang) {
        this.maSP = maSP;
        this.ten = ten;
        this.mota = mota;
        this.anh = anh;
        this.maHDH = maHDH;
        this.maHang = maHang;
    }

    @Override
    public String toString() {
        return ten;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getMaHDH() {
        return maHDH;
    }

    public void setMaHDH(int maHDH) {
        this.maHDH = maHDH;
    }

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }
    
    
}