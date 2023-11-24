/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.HeDieuHanh;
import models.LoaiHang;
import models.ManHinh;
import utils.DBContext;

/**
 *
 * @author dovan
 */
public class LoaiHangService {

    public ArrayList<LoaiHang> getAll() {
        String sql = "select * from LoaiHang";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            ArrayList<LoaiHang> list = new ArrayList<>();
            while (rs.next()) {
                LoaiHang x = new LoaiHang();
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

    public LoaiHang searchById(int ma) {
        String sql = "select * from LoaiHang where ma = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, ma);
            ResultSet rs = pstm.executeQuery();
            ArrayList<LoaiHang> list = new ArrayList<>();
            while (rs.next()) {
                LoaiHang x = new LoaiHang();
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
