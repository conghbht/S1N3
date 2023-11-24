/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author dovan
 */
public class SanPhamChiTiet {
    private int maSPCT;
    private String maSP;
    private int maMauSac;
    private int maManHinh;
    private int maBoNhoTrong;
    private int maCamera;
    private int maRam;
    private int maCPU;
    private int maXuatXu;
    private int maLoaiHang;
    private double giaNhap;
    private double giaBan;
    private String ngayTao;
    private boolean trangThai;
    private int maimei;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(int maSPCT, String maSP, int maMauSac, int maManHinh, int maBoNhoTrong, int maCamera, int maRam, int maCPU, int maXuatXu, int maLoaiHang, double giaNhap, double giaBan, String ngayTao, boolean trangThai, int maimei) {
        this.maSPCT = maSPCT;
        this.maSP = maSP;
        this.maMauSac = maMauSac;
        this.maManHinh = maManHinh;
        this.maBoNhoTrong = maBoNhoTrong;
        this.maCamera = maCamera;
        this.maRam = maRam;
        this.maCPU = maCPU;
        this.maXuatXu = maXuatXu;
        this.maLoaiHang = maLoaiHang;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.maimei = maimei;
    }

    public int getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(int maSPCT) {
        this.maSPCT = maSPCT;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
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

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getMaimei() {
        return maimei;
    }

    public void setMaimei(int maimei) {
        this.maimei = maimei;
    }
    
    
}
