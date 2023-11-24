/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.crypto.interfaces.DHKey;
import models.HoaDon;
import models.HoaDonChiTiet;
import models.SanPham;
import utils.Auth;
import utils.DBContext;

/**
 *
 * @author dovan
 */
public class HoaDonService {

    public ArrayList<HoaDon> pagingByTen(int page, int limit, int trangThai) {
        String sql = "select * from HoaDon where trangThai = ? or loaiDonHang = ? or loaiDonHang=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, trangThai);
            pstm.setInt(2, 0);
            pstm.setInt(3, 1);
            ResultSet rs = pstm.executeQuery();
            ArrayList<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                HoaDon x = new HoaDon();
                x.setMaHoaDon(rs.getInt("maHoaDon"));
                x.setMaKhachHang(rs.getInt("maKhachHang"));
                x.setMaNhanVien(rs.getString("maNhanVien"));
                x.setTenNguoiNhan(rs.getString("tenNguoiNhan"));
                x.setDiaChi(rs.getString("diaChi"));
                x.setSoDienThoai(rs.getString("soDienThoai"));
                x.setTienHang(rs.getFloat("tienHang"));
                x.setTienShip(rs.getFloat("phiShip"));
                x.setTongTien(rs.getFloat("tongTien"));
                x.setTrangThai(rs.getInt("trangThai")==1?true:false);
                x.setLoaiDH(rs.getInt("loaiDonHang"));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer insertHD(HoaDon x) {
        String sql = "insert into HoaDon(maNhanVien,trangThai,loaiDonHang,ngayTao) values \n"
                + "(?,?,?,getDate())";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, Auth.user.getMaNhanVien());
            pstm.setInt(2, x.getTrangThai()?1:0);
            pstm.setInt(3, x.getLoaiDH());
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer insertHDCT(HoaDonChiTiet x) {
        String sql = "insert into HoaDonChiTiet(maHoaDon,maImei,donGia,soLuong,TongGia) values \n"
                + "(?,?,?,?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, x.getMaHD());
            pstm.setInt(2, x.getMaImei());
            pstm.setDouble(3, x.getDonGia());
            pstm.setInt(4, x.getSoLuong());
            pstm.setFloat(5, x.getTongGia());
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer deleteHDCT(HoaDonChiTiet x) {
        String sql = "delete HoaDonChiTiet where maHoaDonChiTiet = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, x.getMaHDCT());
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoaDonChiTiet> gethdct(int maHD) {
        String sql = "select * from HoaDonChiTiet where maHoaDon = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, maHD);

            ResultSet rs = pstm.executeQuery();
            ArrayList<HoaDonChiTiet> list = new ArrayList<>();
            while (rs.next()) {
                HoaDonChiTiet x = new HoaDonChiTiet();
                x.setMaHDCT(rs.getInt("maHoaDonChiTiet"));
                x.setMaHD(rs.getInt("maHoaDon"));
                x.setMaImei(rs.getInt("maImei"));
                x.setSoLuong(rs.getInt("soLuong"));
                x.setTongGia(rs.getFloat("tongGia"));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer updateHoaDon(HoaDon hd) {
        String sql = "update HoaDon set maKhachHang=?,trangThai=?,loaiDonHang=?,phiShip=?,tienHang=?,tongTien=?,soDienThoai=? where maHoaDon =?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setObject(1, hd.getMaKhachHang() == 0 ? null : hd.getMaKhachHang());
            pstm.setInt(2, hd.getTrangThai()?1:0);
            pstm.setInt(3, hd.getLoaiDH());
            pstm.setFloat(4, hd.getTienShip());
            pstm.setFloat(5, tongTienDH(hd.getMaHoaDon()));
            pstm.setFloat(6, hd.getTongTien()==0?tongTienDH(hd.getMaHoaDon())+hd.getTienShip():hd.getTongTien());
            pstm.setString(7, hd.getSoDienThoai());
            pstm.setInt(8, hd.getMaHoaDon());
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public float tongTienDH(int maDH) {
        String sql = "select SUM(tongGia) from HoaDonChiTiet where maHoaDon=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, maDH);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getFloat(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
