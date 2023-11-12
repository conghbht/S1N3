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
import models.ManHinh;
import utils.DBContext;

/**
 *
 * @author dovan
 */
public class CPUService {
    public ArrayList<CPU> getAll() {
        String sql = "select * from  CPU";
        try (Connection con = DBContext.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            ArrayList<CPU> list = new ArrayList<>();
            while (rs.next()) {
                CPU x = new CPU();
                x.setMa(rs.getInt(1));
                x.setLoai(rs.getString(2));  
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
