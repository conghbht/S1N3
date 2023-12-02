package models;

import java.util.Date;


public class HoaDonModel {
    private int maHD;
    private KhachHang khachHang;
    private NhanVien nhanVien;
    private String maVcct;
    private String tenNgNhan,diaChi,sdt;
    private float tienHang,phiShip,tongTien;
    private int giamGia;
    private String donViGiam;
    private float tongTienSauGiam;
    private int trangThai;
    private int loaiDonHang;
    private Date ngayTao;

    public HoaDonModel(int maHD, KhachHang khachHang, NhanVien nhanVien, String maVcct, String tenNgNhan, String diaChi, String sdt, float tienHang, float phiShip, float tongTien, int giamGia, String donViGiam, float tongTienSauGiam, int trangThai, int loaiDonHang, Date ngayTao) {
        this.maHD = maHD;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.maVcct = maVcct;
        this.tenNgNhan = tenNgNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.tienHang = tienHang;
        this.phiShip = phiShip;
        this.tongTien = tongTien;
        this.giamGia = giamGia;
        this.donViGiam = donViGiam;
        this.tongTienSauGiam = tongTienSauGiam;
        this.trangThai = trangThai;
        this.loaiDonHang = loaiDonHang;
        this.ngayTao = ngayTao;
    }

    public HoaDonModel(int maHD, KhachHang khachHang, NhanVien nhanVien, float tongTien, int trangThai, int loaiDonHang, Date ngayTao) {
        this.maHD = maHD;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.loaiDonHang = loaiDonHang;
        this.ngayTao = ngayTao;
    }


 

    public HoaDonModel() {
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getMaVcct() {
        return maVcct;
    }

    public void setMaVcct(String maVcct) {
        this.maVcct = maVcct;
    }

    public String getTenNgNhan() {
        return tenNgNhan;
    }

    public void setTenNgNhan(String tenNgNhan) {
        this.tenNgNhan = tenNgNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public float getTienHang() {
        return tienHang;
    }

    public void setTienHang(float tienHang) {
        this.tienHang = tienHang;
    }

    public float getPhiShip() {
        return phiShip;
    }

    public void setPhiShip(float phiShip) {
        this.phiShip = phiShip;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public String getDonViGiam() {
        return donViGiam;
    }

    public void setDonViGiam(String donViGiam) {
        this.donViGiam = donViGiam;
    }

    public float getTongTienSauGiam() {
        return tongTienSauGiam;
    }

    public void setTongTienSauGiam(float tongTienSauGiam) {
        this.tongTienSauGiam = tongTienSauGiam;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getLoaiDonHang() {
        return loaiDonHang;
    }

    public void setLoaiDonHang(int loaiDonHang) {
        this.loaiDonHang = loaiDonHang;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
    
    
}
