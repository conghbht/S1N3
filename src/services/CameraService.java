/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.CPU;
import models.Camera;
import models.ManHinh;
import utils.DBContext;

/**
 *
 * @author dovan
 */
public class CameraService {
    public ArrayList<Camera> getAll() {
        String sql = "select * from Camera";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            ArrayList<Camera> list = new ArrayList<>();
            while (rs.next()) {
                Camera x = new Camera();
                x.setMa(rs.getInt(1));
                x.setTen(rs.getString(2));
                x.setDungLuong(rs.getString(3));
                x.setTrangThai(rs.getInt(4) == 1 ? true : false);
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Camera searchByID(int id) {
        String sql = "select * from Camera where ma = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            ArrayList<Camera> list = new ArrayList<>();
            while (rs.next()) {
                Camera x = new Camera();
                x.setMa(rs.getInt(1));
                x.setTen(rs.getString(2));
                x.setDungLuong(rs.getString(3));
                x.setTrangThai(rs.getInt(4) == 1 ? true : false);
                list.add(x);
            }
            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
