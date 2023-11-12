/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.BoNhoTrong;
import models.ManHinh;
import utils.DBContext;

/**
 *
 * @author dovan
 */
public class BoNhoTrongService {
    public ArrayList<BoNhoTrong> getAll() {
        String sql = "select * from BoNhoTrong";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            ArrayList<BoNhoTrong> list = new ArrayList<>();
            while (rs.next()) {
                BoNhoTrong x = new BoNhoTrong();
                x.setMa(rs.getInt(1));
                x.setLoai(rs.getString(2));
                x.setDungLuong(rs.getString(3));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public BoNhoTrong searchByID(int id) {
        String sql = "select * from BoNhoTrong where ma = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            ArrayList<BoNhoTrong> list = new ArrayList<>();
            while (rs.next()) {
                BoNhoTrong x = new BoNhoTrong();
                x.setMa(rs.getInt(1));
                x.setLoai(rs.getString(2));
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
