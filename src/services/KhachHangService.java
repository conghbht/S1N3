/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.KhachHang;
import models.NhanVien;
import utils.DBContext;
import utils.XDate;

/**
 *
 * @author dovan
 */
public class KhachHangService {

    public ArrayList<KhachHang> paging(int page, int limit) {
        String sql = "select * from KhachHang order by maKhachHang"
                + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, (page - 1) * limit);
            pstm.setInt(2, limit);
            ResultSet rs = pstm.executeQuery();
            ArrayList<KhachHang> list = new ArrayList<>();
            while (rs.next()) {
                KhachHang x = new KhachHang();
                x.setMaKhachHang(rs.getString(1));
                x.setTenKhachHang(rs.getString(2));
                x.setSoDienThoai(rs.getString(3));
                x.setNgaySinh(rs.getString(4));
                x.setDiaChi(rs.getString(5));
                x.setGioiTinh(rs.getInt(6) == 1 ? "nam" : "nữ");
                x.setEmail(rs.getString("email"));
                x.setNgayTao(rs.getString("ngayTao"));
                x.setGhiChu(rs.getString("ghiChu"));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer insert(KhachHang x) {
        String sql = "insert into KhachHang(tenKhachHang,soDienThoai,ngaySinh,diaChi,gioiTinh,email,ngayTao,ghiChu)\n"
                + "values(?,?,?,?,?,?,?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, x.getTenKhachHang());
            pstm.setString(2, x.getSoDienThoai());
            pstm.setString(3, x.getNgaySinh());
            pstm.setString(4, x.getDiaChi());
            pstm.setInt(5, x.getGioiTinh().equalsIgnoreCase("nam") ? 1 : 0);
            pstm.setString(6, x.getEmail());
            pstm.setString(7, x.getNgayTao());
            pstm.setString(8, x.getGhiChu());
            int rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        return null;
    }

    public Integer update(KhachHang x) {
        String sql = "update KhachHang set tenKhachHang=?,soDienThoai=?,"
                + "ngaySinh=?,diaChi=?,gioiTinh=?,email=?,ngayTao=?,ghiChu=?\n"
                + " where maKhachHang=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(9, x.getMaKhachHang());
            pstm.setString(1, x.getTenKhachHang());
            pstm.setString(2, x.getSoDienThoai());
            pstm.setString(3, x.getNgaySinh());
            pstm.setString(4, x.getDiaChi());
            pstm.setInt(5, x.getGioiTinh().equalsIgnoreCase("nam") ? 1 : 0);
            pstm.setString(6, x.getEmail());
            pstm.setString(7, x.getNgayTao());
            pstm.setString(8, x.getGhiChu());
            int rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        return null;
    }

    public Integer delete(String key) {
        String sql = "delete KhachHang where maKhachHang=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, key);
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<KhachHang> searchBySDT(int page, int limit, String sdt) {
        String sql = "select * from KhachHang Where soDienThoai like ? order by maKhachHang"
                + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, sdt + "%");
            pstm.setInt(2, (page - 1) * limit);
            pstm.setInt(3, limit);
            ArrayList<KhachHang> list = new ArrayList<>();
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                KhachHang x = new KhachHang();
                x.setMaKhachHang(rs.getString(1));
                x.setTenKhachHang(rs.getString(2));
                x.setSoDienThoai(rs.getString(3));
                x.setNgaySinh(rs.getString(4));
                x.setDiaChi(rs.getString(5));
                x.setGioiTinh(rs.getInt(6) == 1 ? "nam" : "nữ");
                x.setEmail(rs.getString("email"));
                x.setNgayTao(rs.getString("ngayTao"));
                x.setGhiChu(rs.getString("ghiChu"));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
