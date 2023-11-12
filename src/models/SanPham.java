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
    private String ma;
    private int machitet;
    private String ten;
    private String mota;
    private String anh;
    private int maHang;
    private int maMauSac;
    private int maManHinh;
    private int maBoNhoTrong;
    private int maCamera;
    private int maRam;
    private int maCPU;
    private int maXuatXu;
    private int maLoaiHang;
    private int maHDH;
    private double giaNhap;
    private double giaBan;
    private String ngayTao;
    private String trangThai;

    public SanPham() {
    }

    public SanPham(String ma, int machitet, String ten, String mota, String anh, int maHang, int maMauSac, int maManHinh, int maBoNhoTrong, int maCamera, int maRam, int maCPU, int maXuatXu, int maLoaiHang, double giaNhap, String ngayTao, String trangThai) {
        this.ma = ma;
        this.machitet = machitet;
        this.ten = ten;
        this.mota = mota;
        this.anh = anh;
        this.maHang = maHang;
        this.maMauSac = maMauSac;
        this.maManHinh = maManHinh;
        this.maBoNhoTrong = maBoNhoTrong;
        this.maCamera = maCamera;
        this.maRam = maRam;
        this.maCPU = maCPU;
        this.maXuatXu = maXuatXu;
        this.maLoaiHang = maLoaiHang;
        this.giaNhap = giaNhap;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public int getMachitet() {
        return machitet;
    }

    public void setMachitet(int machitet) {
        this.machitet = machitet;
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

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public int getMaMauSac() {
        return maMauSac;
    }

    public void setMaMauSac(int maMauSac) {
        this.maMauSac = maMauSac;
    }

    public int getMaManHinh() {
        return maManHinh;
    }

    public void setMaManHinh(int maManHinh) {
        this.maManHinh = maManHinh;
    }

    public int getMaBoNhoTrong() {
        return maBoNhoTrong;
    }

    public void setMaBoNhoTrong(int maBoNhoTrong) {
        this.maBoNhoTrong = maBoNhoTrong;
    }

    public int getMaCamera() {
        return maCamera;
    }

    public void setMaCamera(int maCamera) {
        this.maCamera = maCamera;
    }

    public int getMaRam() {
        return maRam;
    }

    public void setMaRam(int maRam) {
        this.maRam = maRam;
    }

    public int getMaCPU() {
        return maCPU;
    }

    public void setMaCPU(int maCPU) {
        this.maCPU = maCPU;
    }

    public int getMaXuatXu() {
        return maXuatXu;
    }

    public void setMaXuatXu(int maXuatXu) {
        this.maXuatXu = maXuatXu;
    }

    public int getMaLoaiHang() {
        return maLoaiHang;
    }

    public void setMaLoaiHang(int maLoaiHang) {
        this.maLoaiHang = maLoaiHang;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getMaHDH() {
        return maHDH;
    }

    public void setMaHDH(int maHDH) {
        this.maHDH = maHDH;
    }

    @Override
    public String toString() {
        return ten;
    }
    
    
}