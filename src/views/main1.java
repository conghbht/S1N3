/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import bean.DanhMucBean;
import controller.ChuyenManHinhController;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author dovan
 */
public class main1 extends javax.swing.JFrame {
    
  
    public main1() {
        initComponents();
        
        setTitle("Hệ Thống Bán Điện Thoại");
        setLocationRelativeTo(null);
        ChuyenManHinhController controller = new ChuyenManHinhController(jpnView);
        List<DanhMucBean> listItem = new ArrayList<>();
        
        listItem.add(new DanhMucBean("SanPham", jpnSanPham, jlblSanPham));
        listItem.add(new DanhMucBean("KhachHang", jpnKhachHang, jlblKhachHang));
        listItem.add(new DanhMucBean("NhanVien", jpnNhanVien, jlblNhanVien));
        listItem.add(new DanhMucBean("KhuyenMai", jpnKhuyenMai, jlblKhuyenMai));
        listItem.add(new DanhMucBean("BanHang", jpnBanHang, jlblBanHang));
        listItem.add(new DanhMucBean("HoaDon", jpnHoaDon, jlblHoaDon));
        listItem.add(new DanhMucBean("ThongKe", jpnThongKe, jlblThongKe));
        controller.setEven(listItem);
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jpnKhachHang = new javax.swing.JPanel();
        jlblKhachHang = new javax.swing.JLabel();
        jpnNhanVien = new javax.swing.JPanel();
        jlblNhanVien = new javax.swing.JLabel();
        jpnKhuyenMai = new javax.swing.JPanel();
        jlblKhuyenMai = new javax.swing.JLabel();
        jpnBanHang = new javax.swing.JPanel();
        jlblBanHang = new javax.swing.JLabel();
        jpnHoaDon = new javax.swing.JPanel();
        jlblHoaDon = new javax.swing.JLabel();
        jpnThongKe = new javax.swing.JPanel();
        jlblThongKe = new javax.swing.JLabel();
        jpnSanPham = new javax.swing.JPanel();
        jlblSanPham = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnRoot.setBackground(new java.awt.Color(37, 108, 205));
        jpnRoot.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnMenu.setBackground(new java.awt.Color(37, 108, 205));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo.png"))); // NOI18N
        jLabel7.setText("APPLICATION");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jpnKhachHang.setBackground(new java.awt.Color(172, 214, 255));
        jpnKhachHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jlblKhachHang.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        jlblKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/3.png"))); // NOI18N
        jlblKhachHang.setText("   KHÁCH HÀNG");
        jlblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblKhachHangMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnKhachHangLayout = new javax.swing.GroupLayout(jpnKhachHang);
        jpnKhachHang.setLayout(jpnKhachHangLayout);
        jpnKhachHangLayout.setHorizontalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnKhachHangLayout.setVerticalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhachHangLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jlblKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jpnNhanVien.setBackground(new java.awt.Color(172, 214, 255));
        jpnNhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jlblNhanVien.setBackground(new java.awt.Color(172, 214, 255));
        jlblNhanVien.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        jlblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/3.png"))); // NOI18N
        jlblNhanVien.setText("   NHÂN VIÊN");
        jlblNhanVien.setOpaque(true);
        jlblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblNhanVienMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnNhanVienLayout = new javax.swing.GroupLayout(jpnNhanVien);
        jpnNhanVien.setLayout(jpnNhanVienLayout);
        jpnNhanVienLayout.setHorizontalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnNhanVienLayout.setVerticalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhanVienLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jlblNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jpnKhuyenMai.setBackground(new java.awt.Color(172, 214, 255));
        jpnKhuyenMai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jlblKhuyenMai.setBackground(new java.awt.Color(172, 214, 255));
        jlblKhuyenMai.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        jlblKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/3.png"))); // NOI18N
        jlblKhuyenMai.setText("   KHUYẾN MÃI");
        jlblKhuyenMai.setOpaque(true);
        jlblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblKhuyenMaiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnKhuyenMaiLayout = new javax.swing.GroupLayout(jpnKhuyenMai);
        jpnKhuyenMai.setLayout(jpnKhuyenMaiLayout);
        jpnKhuyenMaiLayout.setHorizontalGroup(
            jpnKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnKhuyenMaiLayout.setVerticalGroup(
            jpnKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhuyenMaiLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jlblKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jpnBanHang.setBackground(new java.awt.Color(172, 214, 255));
        jpnBanHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jlblBanHang.setBackground(new java.awt.Color(172, 214, 255));
        jlblBanHang.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        jlblBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/3.png"))); // NOI18N
        jlblBanHang.setText("   BÁN HÀNG");
        jlblBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblBanHangMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnBanHangLayout = new javax.swing.GroupLayout(jpnBanHang);
        jpnBanHang.setLayout(jpnBanHangLayout);
        jpnBanHangLayout.setHorizontalGroup(
            jpnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBanHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnBanHangLayout.setVerticalGroup(
            jpnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBanHangLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jlblBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jpnHoaDon.setBackground(new java.awt.Color(172, 214, 255));
        jpnHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jlblHoaDon.setBackground(new java.awt.Color(172, 214, 255));
        jlblHoaDon.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        jlblHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/3.png"))); // NOI18N
        jlblHoaDon.setText("   HÓA ĐƠN");
        jlblHoaDon.setOpaque(true);
        jlblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblHoaDonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnHoaDonLayout = new javax.swing.GroupLayout(jpnHoaDon);
        jpnHoaDon.setLayout(jpnHoaDonLayout);
        jpnHoaDonLayout.setHorizontalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnHoaDonLayout.setVerticalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jlblHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jpnThongKe.setBackground(new java.awt.Color(172, 214, 255));
        jpnThongKe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jlblThongKe.setBackground(new java.awt.Color(172, 214, 255));
        jlblThongKe.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        jlblThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/3.png"))); // NOI18N
        jlblThongKe.setText("   THỐNG KÊ");
        jlblThongKe.setOpaque(true);
        jlblThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblThongKeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnThongKeLayout = new javax.swing.GroupLayout(jpnThongKe);
        jpnThongKe.setLayout(jpnThongKeLayout);
        jpnThongKeLayout.setHorizontalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jlblThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnThongKeLayout.setVerticalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jlblThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jpnSanPham.setBackground(new java.awt.Color(172, 214, 255));
        jpnSanPham.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jlblSanPham.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        jlblSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/3.png"))); // NOI18N
        jlblSanPham.setText("   SẢN PHẨM");
        jlblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblSanPhamMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnSanPhamLayout = new javax.swing.GroupLayout(jpnSanPham);
        jpnSanPham.setLayout(jpnSanPhamLayout);
        jpnSanPhamLayout.setHorizontalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnSanPhamLayout.setVerticalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSanPhamLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jlblSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnMenuLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jpnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnHoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnBanHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jpnKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jpnNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jpnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jpnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jpnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jpnKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jpnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jpnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jpnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jpnRoot.add(jpnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, 830));

        jpnView.setBackground(new java.awt.Color(37, 108, 205));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );

        jpnRoot.add(jpnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 1100, 840));

        getContentPane().add(jpnRoot, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 880));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblSanPhamMouseClicked
 
    }//GEN-LAST:event_jlblSanPhamMouseClicked

    private void jlblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblKhachHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlblKhachHangMouseClicked

    private void jlblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblNhanVienMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlblNhanVienMouseClicked

    private void jlblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblKhuyenMaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlblKhuyenMaiMouseClicked

    private void jlblBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblBanHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlblBanHangMouseClicked

    private void jlblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblHoaDonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlblHoaDonMouseClicked

    private void jlblThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblThongKeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlblThongKeMouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel jlblBanHang;
    private javax.swing.JLabel jlblHoaDon;
    private javax.swing.JLabel jlblKhachHang;
    private javax.swing.JLabel jlblKhuyenMai;
    private javax.swing.JLabel jlblNhanVien;
    private javax.swing.JLabel jlblSanPham;
    private javax.swing.JLabel jlblThongKe;
    private javax.swing.JPanel jpnBanHang;
    private javax.swing.JPanel jpnHoaDon;
    private javax.swing.JPanel jpnKhachHang;
    private javax.swing.JPanel jpnKhuyenMai;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnNhanVien;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnSanPham;
    private javax.swing.JPanel jpnThongKe;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
