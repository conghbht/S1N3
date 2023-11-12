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
import models.ManHinh;
import models.NhanVien;
import utils.DBContext;
import utils.XDate;

/**
 *
 * @author dovan
 */
public class NhanVienService {
    Connection con = DBContext.getConnection();
    
    public ArrayList<NhanVien> paging(int page,int limit) {
        String sql = "select * from NhanVien order by maNhanVien "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, (page - 1) * limit);
            pstm.setInt(2, limit);
            ResultSet rs = pstm.executeQuery();
            ArrayList<NhanVien> list = new ArrayList<>();
            while (rs.next()) {
                boolean gt= true;
                boolean vt = true;
                if(rs.getInt(7)==1) gt = true;
                else gt = false;
                
                if(rs.getString(10).equalsIgnoreCase("quản lí")) vt = true;
                else vt = false;
                NhanVien x = new NhanVien();
                x.setMaNhanVien(rs.getString(1));
                x.setMatKhau(rs.getString(2));
                x.setTenNhanVien(rs.getString(3));
                x.setAnhNhanVien(rs.getString(4));
                x.setSoDienThoai(rs.getString(5));
//                x.setNgaySinh(rs.getDate(6));
                x.setGioiTinh(gt);
                x.setDiaChi(rs.getString(8));
                x.setEmail(rs.getString(9));
                x.setVaiTro(vt);
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<NhanVien> pagingByVaiTro(int page,int limit,String vaitro,String trangThai) {
        String sql = "select * from NhanVien where VaiTro like ? and trangThai like ? order by maNhanVien "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1,"%" + vaitro + "%");
            pstm.setString(2,"%" + trangThai + "%");
            pstm.setInt(3, (page - 1) * limit);
            pstm.setInt(4,  limit );
            ResultSet rs = pstm.executeQuery();
            ArrayList<NhanVien> list = new ArrayList<>();
            while (rs.next()) {
                NhanVien x = new NhanVien();
                x.setMaNhanVien(rs.getString(1));
                x.setMatKhau(rs.getString(2));
                x.setTenNhanVien(rs.getString(3));
                x.setAnhNhanVien(rs.getString(4));
                x.setSoDienThoai(rs.getString(5));
                x.setNgaySinh(XDate.toString(rs.getDate(6), "dd-MM-yyyy"));
                x.setNgayTao(XDate.toString(rs.getDate("ngayTao"), "dd-MM-yyyy"));
                x.setGioiTinh(rs.getInt(7)==1?true:false);
                x.setDiaChi(rs.getString(8));
                x.setEmail(rs.getString(9));
                x.setVaiTro(rs.getString(10).equals("nhân viên")?false:true);
                x.setTrangThai(rs.getString("trangThai"));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer insert(NhanVien x) {
        String sql = "insert into NhanVien(maNhanVien,matKhau,tenNhanVien,anhNhanVien,soDienThoai,"
                + "ngaySinh,gioiTinh,diaChi,email,vaiTro,trangThai,ngayTao) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, x.getMaNhanVien());
            pstm.setString(2, x.getMatKhau());
            pstm.setString(3, x.getTenNhanVien());
            pstm.setString(4, x.getAnhNhanVien());
            pstm.setString(5, x.getSoDienThoai());
            pstm.setString(6, x.getNgaySinh());
            pstm.setInt(7, x.isGioiTinh()?1:0);
            pstm.setString(8, x.getDiaChi());
            pstm.setString(9, x.getEmail());
            pstm.setInt(10, x.isVaiTro()?1:0);
            pstm.setString(11, x.getTrangThai());
            pstm.setString(12, x.getNgayTao());
            int rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        return null;
    }
    
    public Integer update(NhanVien x){
        String sql = "update NhanVien set matKhau=?,tenNhanVien=?,anhNhanVien=?,soDienThoai=?,"
                + "ngaySinh=?,gioiTinh=?,diaChi=?,email=?,vaiTro=?,trangThai=? where maNhanVien=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(11, x.getMaNhanVien());
            pstm.setString(1, x.getMatKhau());
            pstm.setString(2, x.getTenNhanVien());
            pstm.setString(3, x.getAnhNhanVien());
            pstm.setString(4, x.getSoDienThoai());
            pstm.setString(5, x.getNgaySinh());
            pstm.setInt(6, x.isGioiTinh()?1:0);
            pstm.setString(7, x.getDiaChi());
            pstm.setString(8, x.getEmail());
            pstm.setString(9, x.isVaiTro()?"quản lí":"nhân viên");
            pstm.setString(10, x.getTrangThai());
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Integer delete(String key) {
        String sql = "delete NhanVien where maNhanVien=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, key);
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public NhanVien searchByid(String id) {
        String sql = "select * from NhanVien Where maNhanVien=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, id);
            List<NhanVien> list = new ArrayList<>();
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                NhanVien x = new NhanVien();
                 boolean gt= true;
                boolean vt = true;
                if(rs.getInt(7)==1) gt = true;
                else gt = false;
                x.setMaNhanVien(rs.getString(1));
                x.setMatKhau(rs.getString(2));
                x.setTenNhanVien(rs.getString(3));
                x.setAnhNhanVien(rs.getString(4));
                x.setSoDienThoai(rs.getString(5));
                x.setNgaySinh(XDate.toString(rs.getDate(6), "dd-MM-yyyy"));
                x.setGioiTinh(gt);
                x.setDiaChi(rs.getString(8));
                x.setEmail(rs.getString(9));
                x.setVaiTro(vt);
                list.add(x);
            }
            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
