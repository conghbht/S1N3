/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author dovan
 */
public class ManHinh {
    private int maManHinh;
    private String tenManHinh;
    private boolean trangThai;

    public ManHinh() {
    }

    public ManHinh(int maManHinh, String tenManHinh, boolean trangThai) {
        this.maManHinh = maManHinh;
        this.tenManHinh = tenManHinh;
        this.trangThai = trangThai;
    }

    public int getMaManHinh() {
        return maManHinh;
    }

    public void setMaManHinh(int maManHinh) {
        this.maManHinh = maManHinh;
    }

    public String getTenManHinh() {
        return tenManHinh;
    }

    public void setTenManHinh(String tenManHinh) {
        this.tenManHinh = tenManHinh;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return  tenManHinh;
    }
    
    
}
