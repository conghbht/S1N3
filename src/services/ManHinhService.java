/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.ManHinh;
import utils.DBContext;

/**
 *
 * @author tranv
 */
public class ManHinhService {
    Connection con = DBContext.getConnection();
    
    public ArrayList<ManHinh> getAll() {
        String sql = "select * from ManHinh";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            ArrayList<ManHinh> list = new ArrayList<>();
            while (rs.next()) {
                ManHinh x = new ManHinh();
                x.setMaManHinh(rs.getInt(1));
                x.setTenManHinh(rs.getString(2));
                x.setTrangThai(rs.getString(3));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<ManHinh> paging(int page,int limit) {
        String sql = "select * from ManHinh order by maManHinh "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, (page - 1) * limit);
            pstm.setInt(2, limit);
            ResultSet rs = pstm.executeQuery();
            ArrayList<ManHinh> list = new ArrayList<>();
            while (rs.next()) {
                ManHinh x = new ManHinh();
                x.setMaManHinh(rs.getInt(1));
                x.setTenManHinh(rs.getString("tenManHinh"));
                x.setTrangThai(rs.getString("trangThai"));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer insert(ManHinh x) {
        String sql = "insert into ManHinh(tenManHinh,trangThai)\n"
                + " values(?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, x.getTenManHinh());
            pstm.setString(2, x.getTrangThai());
            int rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Integer update(ManHinh x,int key) {
        String sql = "update ManHinh set tenManHinh=?,"
                + "trangThai=? where maManHinh=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, x.getTenManHinh());
            pstm.setString(2, x.getTrangThai());
            pstm.setInt(3, key);
            int rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Integer delete(int key) {
        String sql = "delete ManHinh where maManHinh=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, key);
            int rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<ManHinh> searchByTrangThai(int page,int limit,String tt) {
        String sql = "select * from ManHinh Where trangThai like ?  order by maManHinh"
                + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1,"%" + tt + "%");
            pstm.setInt(2, (page - 1) * limit);
            pstm.setInt(3, limit);
            ResultSet rs = pstm.executeQuery();
            ArrayList<ManHinh> list = new ArrayList<>();
            while (rs.next()) {
                ManHinh x = new ManHinh();
                x.setMaManHinh(rs.getInt(1));
                x.setTenManHinh(rs.getString("ten"));
                x.setTrangThai(rs.getString("trangThai"));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ManHinh searchById(int id) {
        String sql = "select * from ManHinh Where ma = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            ArrayList<ManHinh> list = new ArrayList<>();
            while (rs.next()) {
                ManHinh x = new ManHinh();
                x.setMaManHinh(rs.getInt(1));
                x.setTenManHinh(rs.getString("ten"));
                x.setTrangThai(rs.getString("trangThai"));
                list.add(x);
            }
            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
