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
public class HangService {
    public ArrayList<Hang> getAll(String mahdh) {
        String sql = "select * from Hang where maHeDieuHanh like ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, mahdh + "%");
            ResultSet rs = pstm.executeQuery();
            ArrayList<Hang> list = new ArrayList<>();
            while (rs.next()) {
                Hang x = new Hang();
                x.setMa(rs.getInt(1));
                x.setTen(rs.getString(2));
                x.setTrangThai(rs.getInt(3) == 1 ? true : false);
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Hang searchById(int ma) {
        String sql = "select * from Hang where ma = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, ma);
            ResultSet rs = pstm.executeQuery();
            ArrayList<Hang> list = new ArrayList<>();
            while (rs.next()) {
                Hang x = new Hang();
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
    
    public Integer insert(Hang x) {
        String sql = "insert into Hang\n"
                + " values(?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, x.getTen());
            pstm.setInt(2, x.isTrangThai()?1:0);
            Integer rs = pstm.executeUpdate();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
