/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author dovan
 */
public class HoaDon {

    private int maHoaDon;
    private int maKhachHang;
    private String maNhanVien;
    private String tenNguoiNhan;
    private String diaChi;
    private String soDienThoai;
    private float tienShip;
    private float tienHang;
    private float tongTien;
    private boolean trangThai;
    private int loaiDH;
    private String ngayTao;

    public HoaDon(int maHoaDon, int maKhachHang, String maNhanVien, String tenNguoiNhan, String diaChi, String soDienThoai, float tongTien, boolean trangThai, String ngayTao, int maspct, int soluong, float dongia, float tonggia) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }

    public HoaDon() {
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public float getTienShip() {
        return tienShip;
    }

    public void setTienShip(float tienShip) {
        this.tienShip = tienShip;
    }

    public float getTienHang() {
        return tienHang;
    }

    public void setTienHang(float tienHang) {
        this.tienHang = tienHang;
    }

    public int getLoaiDH() {
        return loaiDH;
    }

    public void setLoaiDH(int loaiDH) {
        this.loaiDH = loaiDH;
    }

}
