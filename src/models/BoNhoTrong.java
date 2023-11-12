/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author dovan
 */
public class BoNhoTrong {
    private int ma;
    private String loai;
    private String dungLuong;

    public BoNhoTrong() {
    }

    public BoNhoTrong(int ma, String loai, String dungLuong) {
        this.ma = ma;
        this.loai = loai;
        this.dungLuong = dungLuong;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(String dungLuong) {
        this.dungLuong = dungLuong;
    }

    @Override
    public String toString() {
        return loai + " - " + dungLuong;
    }
    
    
}
