/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import models.Imei;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.DBContext;
/**
 *
 * @author dovan
 */
public class ImeiService {
    public Imei searchBySoImei(String soImei) {
        String sql = "select * from Imei Where soImei like ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, soImei + "%");
            List<Imei> list = new ArrayList<>();
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Imei x = new Imei();
                x.setMa(rs.getInt("maImei"));
                x.setSoImei(rs.getString("soImei"));
                x.setMaSanPhamChiTiet(rs.getInt("maSanPhamChiTiet"));
                x.setTrangThai(rs.getInt(4)==1?true:false);
                list.add(x);
            }
            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Imei> searchBymasqpct(int ma,String trangThai) {
        String sql = "select * from Imei Where maSanPhamChitiet = ? and trangThai like ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, ma);
            pstm.setString(2, trangThai + "%");
            List<Imei> list = new ArrayList<>();
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Imei x = new Imei();
                x.setMa(rs.getInt("maImei"));
                x.setSoImei(rs.getString("soImei"));
                x.setMaSanPhamChiTiet(rs.getInt("maSanPhamChiTiet"));
                x.setTrangThai(rs.getInt(4) == 1 ? true : false);
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Imei searchByID(int ma) {
        String sql = "select * from Imei Where maImei = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, ma);
            List<Imei> list = new ArrayList<>();
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Imei x = new Imei();
                x.setMa(rs.getInt("maImei"));
                x.setSoImei(rs.getString("soImei"));
                x.setMaSanPhamChiTiet(rs.getInt("maSanPhamChiTiet"));
                x.setTrangThai(rs.getInt(4) == 1 ? true : false);
                list.add(x);
            }
            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Integer delete(String key) {
        String sql = "delete Imei where soImei = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, key);
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Integer insert(Imei x) {
        String sql = "insert into Imei(soImei,maSanPhamChiTiet,trangThai)"
                + " values(?,?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, x.getSoImei());
            pstm.setInt(2, x.getMaSanPhamChiTiet());
            pstm.setInt(3, x.isTrangThai()?1:0);
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Integer update(Imei x) {
        String sql = "update Imei set trangThai = ? where maImei = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, x.isTrangThai()?1:0);
            pstm.setInt(2, x.getMa());
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
