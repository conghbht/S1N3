/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.io.ByteArrayInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import models.Imei;
import models.SanPham;
import models.SanPhamChiTiet;
import utils.DBContext;
import utils.XDate;

/**
 *
 * @author dovan
 */
public class SanPhamService {

    public ArrayList<SanPhamChiTiet> pagingByTen(int page, int limit, String ten, String trangThai) {
        String sql = "select * from SanPhamChiTiet "
                + "inner join SanPham on SanPham.maSanPham = SanPhamChiTiet.maSanPham "
                + "where tenSanPham like ? and SanPhamChiTiet.trangThai like ? order by SanPham.maSanPham "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY ";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1,"%"+ ten + "%");
            pstm.setString(2, trangThai + "%");
            pstm.setInt(3, (page - 1) * limit);
            pstm.setInt(4, limit);
            ResultSet rs = pstm.executeQuery();
            ArrayList<SanPhamChiTiet> list = new ArrayList<>();
            while (rs.next()) {
                SanPhamChiTiet x = new SanPhamChiTiet();
                x.setMaSPCT(rs.getInt("maSanPhamChiTiet"));
                x.setMaSP(rs.getString("maSanPham"));
                x.setMaMauSac(rs.getInt("maMauSac"));
                x.setMaManHinh(rs.getInt("maManHinh"));
                x.setMaBoNhoTrong(rs.getInt("maBoNhoTrong"));
                x.setMaCamera(rs.getInt("maCamera"));
                x.setMaRam(rs.getInt("maRam"));
                x.setMaCPU(rs.getInt("maCPU"));
                x.setMaXuatXu(rs.getInt("maXuatXu"));
                x.setMaLoaiHang(rs.getInt("maLoaiHang"));
                x.setGiaNhap(rs.getFloat("giaNhap"));
                x.setGiaBan(rs.getFloat("giaSanPham"));
                x.setNgayTao(rs.getString("ngayTao"));
                x.setTrangThai(rs.getInt("trangThai") == 1 ? true : false);
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer insertSP(SanPham x) {
        String sql = "insert into SanPham(maSanPham,tenSanPham,anhSanPham,moTa,maHDH,maHang)\n"
                + " values(?,?,?,?,?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, x.getMaSP());
            pstm.setString(2, x.getTen());
            pstm.setString(3, x.getAnh());
            pstm.setString(4, x.getMota());
            pstm.setInt(5, x.getMaHDH());
            pstm.setInt(6, x.getMaHang());
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer insertSPCT(SanPham sp, SanPhamChiTiet spct) {
        if (searchByid(sp.getMaSP()) == null) {
            insertSP(sp);
        }
        String sql = "insert into SanPhamChiTiet(maSanPham,maMauSac,maManHinh,maBoNhoTrong,maCamera,maRam,maCPU,maXuatXu,maLoaiHang,giaSanPham,giaNhap,ngayTao,trangThai)\n"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, spct.getMaSP());
            pstm.setInt(2, spct.getMaMauSac());
            pstm.setInt(3, spct.getMaManHinh());
            pstm.setInt(4, spct.getMaBoNhoTrong());
            pstm.setInt(5, spct.getMaCamera());
            pstm.setInt(6, spct.getMaRam());
            pstm.setInt(7, spct.getMaCPU());
            pstm.setInt(8, spct.getMaXuatXu());
            pstm.setInt(9, spct.getMaLoaiHang());
            pstm.setDouble(10, spct.getGiaBan());
            pstm.setDouble(11, spct.getGiaNhap());
            pstm.setString(12, spct.getNgayTao());
            pstm.setInt(13, spct.isTrangThai() ? 1 : 0);
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer updateSPCT(SanPhamChiTiet spct, SanPham sp) {
//        updateSP(sp);
        String sql = "update SanPhamChiTiet set maMauSac=?,maManHinh=?,maBoNhoTrong=?,maCamera=?,maRam=?,maCPU=?,maXuatXu=?"
                + ",maLoaiHang=?,giaSanPham=?,giaNhap=?,ngayTao=?,trangThai=? where maSanPhamChiTiet = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, spct.getMaMauSac());
            pstm.setInt(2, spct.getMaManHinh());
            pstm.setInt(3, spct.getMaBoNhoTrong());
            pstm.setInt(4, spct.getMaCamera());
            pstm.setInt(5, spct.getMaRam());
            pstm.setInt(6, spct.getMaCPU());
            pstm.setInt(7, spct.getMaXuatXu());
            pstm.setInt(8, spct.getMaLoaiHang());
            pstm.setFloat(9, spct.getGiaBan());
            pstm.setFloat(10, spct.getGiaNhap());
            pstm.setString(11, spct.getNgayTao());
            pstm.setInt(12, spct.isTrangThai() ? 1 : 0);
            System.out.println(spct.isTrangThai() ? 1 : 0);
            pstm.setInt(13, spct.getMaSPCT());
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SanPham searchByid(String ten) {
        String sql = "select * from SanPham Where maSanPham = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, ten);
            ArrayList<SanPham> list = new ArrayList<>();
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham x = new SanPham();
                x.setMaSP(rs.getString("maSanPham"));
                x.setTen(rs.getString("tenSanPham"));
                x.setMota(rs.getString("moTa"));
                x.setAnh(rs.getString("anhSanPham"));
                x.setMaHang(rs.getInt("maHang"));
                x.setMaHDH(rs.getInt("maHDH"));
                list.add(x);
            }
            if (list.isEmpty()) {
                return null;
            } else {
                return list.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer searchNewSPCT() {
        String sql = "select * from SanPhamChiTiet order by maSanPhamChiTiet desc";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            ArrayList<SanPham> list = new ArrayList<>();
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("maSanPhamChiTiet");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    

    public SanPhamChiTiet searchBymaSPCT(int ma) {
        String sql = "select * from SanPhamChiTiet where maSanPhamChiTiet = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, ma);
            ArrayList<SanPham> list = new ArrayList<>();
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPhamChiTiet x = new SanPhamChiTiet();
                x.setMaSPCT(rs.getInt("maSanPhamChiTiet"));
                x.setMaSP(rs.getString("maSanPham"));
                x.setMaMauSac(rs.getInt("maMauSac"));
                x.setMaManHinh(rs.getInt("maManHinh"));
                x.setMaBoNhoTrong(rs.getInt("maBoNhoTrong"));
                x.setMaCamera(rs.getInt("maCamera"));
                x.setMaRam(rs.getInt("maRam"));
                x.setMaCPU(rs.getInt("maCPU"));
                x.setMaXuatXu(rs.getInt("maXuatXu"));
                x.setMaLoaiHang(rs.getInt("maLoaiHang"));
                x.setGiaNhap(rs.getFloat("giaNhap"));
                x.setGiaBan(rs.getFloat("giaSanPham"));
                x.setNgayTao(rs.getString("ngayTao"));
                x.setTrangThai(rs.getInt("trangThai") == 1 ? true : false);
                return x;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public SanPhamChiTiet searchBySoImei(String soImei) {
        String sql = "select * from SanPhamChiTiet where maSanPhamChiTiet in (select maSanPhamChiTiet from Imei where soImei = ?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, soImei);
            ArrayList<SanPham> list = new ArrayList<>();
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPhamChiTiet x = new SanPhamChiTiet();
                x.setMaSPCT(rs.getInt("maSanPhamChiTiet"));
                x.setMaSP(rs.getString("maSanPham"));
                x.setMaMauSac(rs.getInt("maMauSac"));
                x.setMaManHinh(rs.getInt("maManHinh"));
                x.setMaBoNhoTrong(rs.getInt("maBoNhoTrong"));
                x.setMaCamera(rs.getInt("maCamera"));
                x.setMaRam(rs.getInt("maRam"));
                x.setMaCPU(rs.getInt("maCPU"));
                x.setMaXuatXu(rs.getInt("maXuatXu"));
                x.setMaLoaiHang(rs.getInt("maLoaiHang"));
                x.setGiaNhap(rs.getFloat("giaNhap"));
                x.setGiaBan(rs.getFloat("giaSanPham"));
                x.setNgayTao(rs.getString("ngayTao"));
                x.setTrangThai(rs.getInt("trangThai") == 1 ? true : false);
                return x;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer updateSP(SanPham x) {
        String sql = "update SanPham set tenSanPham =?, anhSanPham=?,moTa=?,maHang=?,maHDH=? where maSanPham = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, x.getTen());
            pstm.setString(2, x.getAnh());
            pstm.setString(3, x.getMota());
            pstm.setInt(4, x.getMaHang());
            pstm.setInt(5, x.getMaHDH());
            pstm.setString(6, x.getMaSP());
            Integer chon = pstm.executeUpdate();
            return chon;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Imei> soLuongTonSP(int maSPCT, String trangThai) {
        String sql = "select * from Imei where maSanPhamChiTiet = ? and  trangThai like ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, maSPCT);
            pstm.setString(2, trangThai + "%");
            ArrayList<Imei> list = new ArrayList<>();
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Imei x = new Imei();
                x.setMaSanPhamChiTiet(maSPCT);
                x.setSoImei(rs.getString("soImei"));
                x.setTrangThai(rs.getInt("trangThai") == 1 ? true : false);
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<SanPhamChiTiet> searchSPCTByKM(int page, int limit, String ten, String trangThai) {
        String sql = "select * from SanPhamChiTiet "
                + "inner join SanPham on SanPham.maSanPham = SanPhamChiTiet.maSanPham "
                + "where SanPham.tenSanPham like ? and SanPhamChiTiet.trangThai like ?"
                + " and maSanPhamChiTiet not in (select maSanPhamChiTiet from KhuyenMaiSanPham) order by SanPhamChiTiet.maSanPhamChiTiet "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY ";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, ten + "%");
            pstm.setString(2, trangThai + "%");
            pstm.setInt(3, (page - 1) * limit);
            pstm.setInt(4, limit);
            ResultSet rs = pstm.executeQuery();
            ArrayList<SanPhamChiTiet> list = new ArrayList<>();
            while (rs.next()) {
                SanPhamChiTiet x = new SanPhamChiTiet();
                x.setMaSPCT(rs.getInt("maSanPhamChiTiet"));
                x.setMaSP(rs.getString("maSanPham"));
                x.setMaMauSac(rs.getInt("maMauSac"));
                x.setMaManHinh(rs.getInt("maManHinh"));
                x.setMaBoNhoTrong(rs.getInt("maBoNhoTrong"));
                x.setMaCamera(rs.getInt("maCamera"));
                x.setMaRam(rs.getInt("maRam"));
                x.setMaCPU(rs.getInt("maCPU"));
                x.setMaXuatXu(rs.getInt("maXuatXu"));
                x.setMaLoaiHang(rs.getInt("maLoaiHang"));
                x.setGiaNhap(rs.getFloat("giaNhap"));
                x.setGiaBan(rs.getFloat("giaSanPham"));
                x.setNgayTao(rs.getString("ngayTao"));
                x.setTrangThai(rs.getInt("trangThai") == 1 ? true : false);
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
