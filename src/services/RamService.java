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
import utils.DBContext;

/**
 *
 * @author dovan
 */
public class RamService {
    public ArrayList<Ram> getAll() {
        String sql = "select * from Ram";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            ArrayList<Ram> list = new ArrayList<>();
            while (rs.next()) {
                Ram x = new Ram();
                x.setMa(rs.getInt(1));
                x.setTen(rs.getString(2));
                x.setDungLuong(rs.getString(3));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Ram searchByID(int id) {
        String sql = "select * from Ram where ma = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            ArrayList<Ram> list = new ArrayList<>();
            while (rs.next()) {
                Ram x = new Ram();
                x.setMa(rs.getInt(1));
                x.setTen(rs.getString(2));
                x.setDungLuong(rs.getString(3));
                list.add(x);
            }
            return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
