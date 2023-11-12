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
import utils.DBContext;
import utils.XDate;

/**
 *
 * @author dovan
 */
public class SanPhamService {

    public ArrayList<SanPham> pagingByTen(int page, int limit, String ten, String trangThai) {
        String sql = "select * from SanPham "
                + "inner join SanPhamChiTiet on SanPham.maSanPham = SanPhamChiTiet.maSanPham "
                + "where tenSanPham like ? and SanPhamChiTiet.trangThai like ? order by SanPham.maSanPham "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY ";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, ten + "%");
            pstm.setString(2, trangThai + "%");
            pstm.setInt(3, (page - 1) * limit);
            pstm.setInt(4, limit);
            ResultSet rs = pstm.executeQuery();
            ArrayList<SanPham> list = new ArrayList<>();
            while (rs.next()) {
                SanPham x = new SanPham();
                x.setMa(rs.getString("maSanPham"));
                x.setTen(rs.getString("tenSanPham"));
                x.setMachitet(rs.getInt("maSanPhamChiTiet"));
                x.setAnh(rs.getString("anhSanPham"));
                x.setTrangThai(rs.getString(21));
                x.setMaHang(rs.getInt("maHang"));
                x.setMaMauSac(rs.getInt("maMauSac"));
                x.setMaManHinh(rs.getInt("maManHinh"));
                x.setMaBoNhoTrong(rs.getInt("maBoNhoTrong"));
                x.setMaCamera(rs.getInt("maCamera"));
                x.setMaRam(rs.getInt("maRam"));
                x.setMaCPU(rs.getInt("maCPU"));
                x.setMaXuatXu(rs.getInt("maXuatXu"));
                x.setMaLoaiHang(rs.getInt("maLoaiHang"));
                x.setMaHDH(rs.getInt("maHDH"));
                x.setGiaNhap(rs.getDouble("giaNhap"));
                x.setGiaBan(rs.getDouble("giaSanPham"));
                x.setNgayTao(rs.getString("ngayTao"));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer insert(SanPham x) {
        String sql = "insert into SanPham(maSanPham,tenSanPham,anhSanPham,moTa,trangThai,maHDH,maHang)\n"
                + " values(?,?,?,?,?,?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, x.getMa());
            pstm.setString(2, x.getTen());
            pstm.setString(3, x.getAnh());
            pstm.setString(4, x.getMota());
            pstm.setString(5, x.getTrangThai());
            pstm.setInt(6, x.getMaHDH());
            pstm.setInt(7, x.getMaHang());
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer insertSPCT(SanPham x) {
//        if (searchByid(x.getMa()) == null) {
//            insert(x);
//        }
        String sql = "insert into SanPhamChiTiet(maSanPham,maMauSac,maManHinh,maBoNhoTrong,maCamera,maRam,maCPU,maXuatXu,maLoaiHang,giaSanPham,giaNhap,ngayTao,trangThai)\n"
                + "    values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, x.getMa());
            pstm.setInt(2, x.getMaMauSac());
            pstm.setInt(3, x.getMaManHinh());
            pstm.setInt(4, x.getMaBoNhoTrong());
            pstm.setInt(5, x.getMaCamera());
            pstm.setInt(6, x.getMaRam());
            pstm.setInt(7, x.getMaCPU());
            pstm.setInt(8, x.getMaXuatXu());
            pstm.setInt(9, x.getMaLoaiHang());
            pstm.setDouble(10, x.getGiaBan());
            pstm.setDouble(11, x.getGiaNhap());
            pstm.setString(12,x.getNgayTao());
            pstm.setString(13, x.getTrangThai());

            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer update(SanPham x) {
        String sql = "update SanPhamChiTiet set maMauSac=?,maManHinh=?,maBoNhoTrong=?,maCamera=?,maRam=?,maCPU=?,maXuatXu=?"
                + ",maLoaiHang=?,giaSanPham=?,giaNhap=?,ngayTao=?,trangThai=? where maSanPhamChiTiet = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            
            pstm.setInt(1, x.getMaMauSac());
            pstm.setInt(2, x.getMaManHinh());
            pstm.setInt(3, x.getMaBoNhoTrong());
            pstm.setInt(4, x.getMaCamera());
            pstm.setInt(5, x.getMaRam());
            pstm.setInt(6, x.getMaCPU());
            pstm.setInt(7, x.getMaXuatXu());
            pstm.setInt(8, x.getMaLoaiHang());
            pstm.setDouble(9, x.getGiaBan());
            pstm.setDouble(10, x.getGiaNhap());
            pstm.setString(11, x.getNgayTao());
            pstm.setString(12, x.getTrangThai());
            
            pstm.setInt(13, x.getMachitet());
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<SanPham> searchByTen(String ten) {
        String sql = "select * from SanPham Where tenSanPham like ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, ten + "%");
            ArrayList<SanPham> list = new ArrayList<>();
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham x = new SanPham();
                x.setMa(rs.getString("maSanPham"));
                x.setTen(rs.getString("tenSanPham"));

                x.setAnh(rs.getString("anhSanPham"));
                x.setTrangThai(rs.getString("trangThai"));
                list.add(x);
            }

            return list;

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
                x.setMa(rs.getString("maSanPham"));
                x.setTen(rs.getString("tenSanPham"));

                x.setAnh(rs.getString("anhSanPham"));
                x.setTrangThai(rs.getString("trangThai"));
                list.add(x);
            }
            if(list.isEmpty()){
                return null;
            }else return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<SanPham> getall() {
        String sql = "select * from SanPham";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
//            pstm.setString(1, trangThai + "%");
            ArrayList<SanPham> list = new ArrayList<>();
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham x = new SanPham();
                x.setMa(rs.getString("maSanPham"));
                x.setTen(rs.getString("tenSanPham"));
                x.setMota(rs.getString("moTa"));
                x.setAnh(rs.getString("anhSanPham"));
                x.setTrangThai(rs.getString("trangThai"));
                x.setMaHDH(rs.getInt("maHDH"));
                x.setMaHang(rs.getInt("maHang"));
                list.add(x);
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
     public ArrayList<SanPham> getallSPCT() {
        String sql = "select * from SanPhamChiTiet";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
//            pstm.setString(1, trangThai + "%");
            ArrayList<SanPham> list = new ArrayList<>();
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham x = new SanPham();
                x.setMa(rs.getString("maSanPhamChiTiet"));
                list.add(x);
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Integer updateSP(SanPham x) {
        String sql = "update SanPham set tenSanPham =?, anhSanPham=?,trangThai=? where maSanPham = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, x.getTen());
            pstm.setString(2, x.getAnh());
            pstm.setString(3, x.getTrangThai());
            pstm.setString(4, x.getMa());
            ArrayList<SanPham> list = new ArrayList<>();
            Integer chon = pstm.executeUpdate();
            return chon;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Imei> soLuongTonSP(int maSPCT){
        String sql = "select * from Imei where maSanPhamChiTiet = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
//            pstm.setString(1, trangThai + "%");
            pstm.setInt(1, maSPCT);
            ArrayList<Imei> list = new ArrayList<>();
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Imei x = new Imei();
                x.setMaSanPhamChiTiet(maSPCT);
                x.setSoImei(rs.getString("soImei"));
                list.add(x);
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
