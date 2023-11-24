/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.ManHinh;
import models.Ram;
import models.XuatXu;
import utils.DBContext;

/**
 *
 * @author dovan
 */
public class XuatXuService {
    public ArrayList<XuatXu> getAll() {
        String sql = "select * from XuatXu";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            ArrayList<XuatXu> list = new ArrayList<>();
            while (rs.next()) {
                XuatXu x = new XuatXu();
                x.setMa(rs.getInt(1));
                x.setTen(rs.getString(2));
                x.setTrangThai(rs.getInt(3)==1?true:false);
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public XuatXu searchByID(int id) {
        String sql = "select * from XuatXu where ma = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            ArrayList<XuatXu> list = new ArrayList<>();
            while (rs.next()) {
                XuatXu x = new XuatXu();
                x.setMa(rs.getInt(1));
                x.setTen(rs.getString(2));
                x.setTrangThai(rs.getInt(3) == 1 ? true : false);
                list.add(x);
            }
            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
