/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Hang;
import models.HeDieuHanh;
import models.ManHinh;
import utils.DBContext;

/**
 *
 * @author dovan
 */
public class HeDieuHanhService {

    public ArrayList<HeDieuHanh> getAll() {
        String sql = "select * from HeDieuHanh";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            ArrayList<HeDieuHanh> list = new ArrayList<>();
            while (rs.next()) {
                HeDieuHanh x = new HeDieuHanh();
                x.setMa(rs.getInt(1));
                x.setTen(rs.getString(2));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer insert(HeDieuHanh x) {
        String sql = "insert into HeDieuHanh\n"
                + " values(?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, x.getTen());
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public HeDieuHanh searchById(int ma) {
        String sql = "select * from HeDieuHanh where ma = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, ma);
            ResultSet rs = pstm.executeQuery();
            ArrayList<HeDieuHanh> list = new ArrayList<>();
            while (rs.next()) {
                HeDieuHanh x = new HeDieuHanh();
                x.setMa(rs.getInt(1));
                x.setTen(rs.getString(2));
                list.add(x);
            }
                return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
