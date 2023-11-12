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
import models.MauSac;
import utils.DBContext;

/**
 *
 * @author dovan
 */
public class MauSacService {
    public ArrayList<MauSac> getAll() {
        String sql = "select * from MauSac";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            ArrayList<MauSac> list = new ArrayList<>();
            while (rs.next()) {
                MauSac x = new MauSac();
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
}
