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
        String sql = "insert into Imei(soImei,maSanPhamChiTiet)"
                + " values(?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, x.getSoImei());
            pstm.setInt(2, x.getMaSanPhamChiTiet());
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
