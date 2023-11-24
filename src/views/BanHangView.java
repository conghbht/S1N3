/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.util.ArrayList;
import java.util.List;
import javax.crypto.interfaces.DHKey;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.BoNhoTrong;
import models.HoaDon;
import models.HoaDonChiTiet;
import models.Imei;
import models.KhachHang;
import models.ManHinh;
import models.SanPham;
import models.SanPhamChiTiet;
import services.BoNhoTrongService;
import services.HoaDonService;
import services.ImeiService;
import services.KhachHangService;
import services.LoaiHangService;
import services.ManHinhService;
import services.MauSacService;
import services.RamService;
import services.SanPhamService;
import utils.Auth;

/**
 *
 * @author Acer
 */
public class BanHangView extends javax.swing.JPanel {

    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();

    HoaDonService service = new HoaDonService();
    SanPhamService service1 = new SanPhamService();
    RamService rams = new RamService();
    BoNhoTrongService bnts = new BoNhoTrongService();
    ManHinhService mhs = new ManHinhService();
    MauSacService mss = new MauSacService();
    LoaiHangService lhs = new LoaiHangService();
    KhachHangService khs = new KhachHangService();

    ArrayList<HoaDon> list = new ArrayList<>();
    ArrayList<SanPhamChiTiet> list1 = new ArrayList<>();
    ArrayList<HoaDonChiTiet> list2 = new ArrayList<>();

    ImeiService imeis = new ImeiService();
    HoaDon hd = new HoaDon();
    int page = 1;
    String ten = "";
    int maHD = 0, index = -1;

    public BanHangView() {
        initComponents();
        model = (DefaultTableModel) tblHoaDon1.getModel();
        model1 = (DefaultTableModel) tblSanPham.getModel();
        model2 = (DefaultTableModel) tblGioHang.getModel();

        loaddatatpHoaDon();
        loaddatattoSP();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnnext = new javax.swing.JButton();
        btnprev = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txt_sp = new javax.swing.JTextField();
        btnnext1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cbo = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_khachDua = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_ttoan = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        txt_tenKH = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_maNV = new javax.swing.JLabel();
        txt_tienHang = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        txt_tongTien = new javax.swing.JLabel();
        txt_tienThua = new javax.swing.JLabel();
        btn_gh = new javax.swing.JButton();
        btn_hthanh = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txt_phiShip = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_tienSP = new javax.swing.JLabel();
        thanhToan = new javax.swing.JCheckBox();
        btn_huy = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnPrev = new javax.swing.JButton();
        txt_datHang = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));

        tblHoaDon1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblHoaDon1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã NV", "Mã KH", "Tổng giá", "Loại DH", "Trạng Thái"
            }
        ));
        tblHoaDon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDon1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon1);
        if (tblHoaDon1.getColumnModel().getColumnCount() > 0) {
            tblHoaDon1.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnnext.setText("Next");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        btnprev.setText("Prev");
        btnprev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprevActionPerformed(evt);
            }
        });

        tblSanPham.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên SP", "Ram", "Rom", "Màn Hình", "Màu sắc", "Số Lượng", "Giá"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(0).setMinWidth(50);
            tblSanPham.getColumnModel().getColumn(0).setMaxWidth(50);
            tblSanPham.getColumnModel().getColumn(1).setMinWidth(120);
        }

        txt_sp.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_spInputMethodTextChanged(evt);
            }
        });

        btnnext1.setText("QR");
        btnnext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnext1ActionPerformed(evt);
            }
        });

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cbo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboItemStateChanged(evt);
            }
        });
        cbo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cboMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cboMouseReleased(evt);
            }
        });
        cbo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboActionPerformed(evt);
            }
        });

        jButton4.setText("Chọn");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnprev, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnnext1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(29, 29, 29)
                                .addComponent(cbo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(cbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnprev)
                    .addComponent(btnnext)
                    .addComponent(btnnext1))
                .addGap(0, 0, 0))
        );

        jButton1.setText("Tạo HD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Mã NV");

        jLabel6.setText("Tổng Tiền ");

        jLabel7.setText("Tiền Thừa");

        txt_khachDua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_khachDuaMouseReleased(evt);
            }
        });
        txt_khachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_khachDuaActionPerformed(evt);
            }
        });

        jLabel8.setText("Tiền khách đưa");

        btn_ttoan.setText("Thanh Toán");
        btn_ttoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ttoanActionPerformed(evt);
            }
        });

        jLabel9.setText("SDT");

        txt_sdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sdtActionPerformed(evt);
            }
        });

        txt_tenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenKHActionPerformed(evt);
            }
        });

        jLabel10.setText("Tên KH");

        txt_maNV.setText(".");

        jButton5.setText("Tìm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txt_tongTien.setText("0");

        txt_tienThua.setText("0");

        btn_gh.setText("Giao hàng");
        btn_gh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ghActionPerformed(evt);
            }
        });

        btn_hthanh.setText("Hoàn Thành");
        btn_hthanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hthanhActionPerformed(evt);
            }
        });

        jLabel11.setText("Phí ship");

        txt_phiShip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_phiShipMouseReleased(evt);
            }
        });

        jLabel12.setText("Tiền hàng");

        txt_tienSP.setText("0");

        thanhToan.setText("Thanh toán");
        thanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thanhToanActionPerformed(evt);
            }
        });

        btn_huy.setText("Hủy");
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txt_khachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(txt_tienHang, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(47, 47, 47)
                                .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_ttoan, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_tienSP, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(btn_gh)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btn_hthanh))))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(56, 56, 56)
                                    .addComponent(txt_phiShip, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(60, 60, 60)
                                    .addComponent(txt_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jButton5)))))
                            .addComponent(thanhToan)
                            .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_maNV))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jButton5)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_phiShip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_tienSP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_tongTien))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_tienHang, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_khachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_tienThua))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thanhToan)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_ttoan)
                            .addComponent(btn_gh)
                            .addComponent(btn_hthanh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_huy)
                        .addContainerGap(12, Short.MAX_VALUE))))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblGioHang.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "TenSP", "Ram", "Rom", "Màn Hình", "Màu sắc", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ));
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblGioHang);
        if (tblGioHang.getColumnModel().getColumnCount() > 0) {
            tblGioHang.getColumnModel().getColumn(0).setMinWidth(150);
            tblGioHang.getColumnModel().getColumn(0).setMaxWidth(150);
            tblGioHang.getColumnModel().getColumn(4).setResizable(false);
        }

        btnPrev.setText("Remove");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPrev)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrev)
                .addGap(6, 6, 6))
        );

        txt_datHang.setText("Đặt hàng");
        txt_datHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_datHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(txt_datHang)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(txt_datHang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed

    }//GEN-LAST:event_btnnextActionPerformed

    private void btnprevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprevActionPerformed

    }//GEN-LAST:event_btnprevActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        HoaDon x = new HoaDon();
        x.setTrangThai(false);
        x.setMaNhanVien(Auth.user.getMaNhanVien());
        if (txt_datHang.isSelected()) {
            x.setLoaiDH(0);
        } else {
            x.setLoaiDH(4);
        }
        Integer kq = service.insertHD(x);
        if (kq != null) {
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            loaddatatpHoaDon();
        } else
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_spInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_spInputMethodTextChanged
        // TODO add your handling code here:
        ten = txt_sp.getText();
        loaddatattoSP();
    }//GEN-LAST:event_txt_spInputMethodTextChanged

    private void btnnext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnext1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnnext1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ten = txt_sp.getText();
        loaddatattoSP();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblSanPhamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSanPhamMouseEntered

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        index = tblSanPham.getSelectedRow();
        JOptionPane.showMessageDialog(null, "Mời chọn imei");
        loadToImei();
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void tblHoaDon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDon1MouseClicked
        // TODO add your handling code hereind
        index = tblHoaDon1.getSelectedRow();
        hd = list.get(index);
        maHD = hd.getMaHoaDon();
        loadToGioHang();
        showForm();
    }//GEN-LAST:event_tblHoaDon1MouseClicked

    public void showForm() {
        txt_maNV.setText(hd.getMaNhanVien());
        txt_tienSP.setText(String.valueOf(hd.getTienHang()));
        txt_phiShip.setText(String.valueOf(hd.getTienShip()));
        txt_tongTien.setText(String.valueOf(hd.getTongTien()));
        txt_sdt.setText(hd.getSoDienThoai());
        if (hd.getLoaiDH() == 4) {
            btn_gh.setEnabled(false);
            btn_hthanh.setEnabled(false);
            btn_huy.setEnabled(false);
            btn_ttoan.setEnabled(true);
            txt_phiShip.setEditable(false);
        } else {
            btn_gh.setEnabled(true);
            btn_huy.setEnabled(true);
            btn_ttoan.setEnabled(false);
            txt_phiShip.setEditable(true);
            if (hd.getLoaiDH() == 1) {
                btn_gh.setEnabled(false);
                btn_hthanh.setEnabled(true);
            }
        }

    }

    private void cboMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboMouseExited

    }//GEN-LAST:event_cboMouseExited

    private void cboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboItemStateChanged

    }//GEN-LAST:event_cboItemStateChanged

    private void cboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboActionPerformed

    private void cboMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboMouseReleased

    }//GEN-LAST:event_cboMouseReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        // TODO add your handling code here:
        // TODO add your handling code here:
        SanPhamChiTiet spct = list1.get(index);
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        String soImei = cbo.getSelectedItem() + "";
        hdct.setMaHD(maHD);
        hdct.setMaImei(imeis.searchBySoImei(soImei).getMa());
        hdct.setDonGia((float) spct.getGiaBan());
        hdct.setSoLuong(1);
        hdct.setTongGia((float) spct.getGiaBan());
        service.insertHDCT(hdct);
        Imei imei = imeis.searchByID(hdct.getMaImei());
        imei.setTrangThai(false);
        imeis.update(imei);
        loaddatattoSP();
        loadToGioHang();
        hd.setMaHoaDon(maHD);
        service.updateHoaDon(hd);
        loaddatatpHoaDon();
        JOptionPane.showMessageDialog(null, "Thêm thành công");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        BoSpKhoiGioHang();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        // TODO add your handling code here:
        index = tblGioHang.getSelectedRow();
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        ArrayList<KhachHang> khlist = khs.paging(1, 1, txt_sdt.getText(), "");
        if (khlist.size() != 0) {
            KhachHang kh = khlist.get(0);
            txt_tenKH.setText(kh.getTenKhachHang());
            hd.setMaKhachHang(kh.getMaKhachHang());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txt_datHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_datHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_datHangActionPerformed

    private void txt_sdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sdtActionPerformed

    private void txt_tenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenKHActionPerformed

    private void txt_khachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_khachDuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_khachDuaActionPerformed

    private void btn_ttoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ttoanActionPerformed
        // TODO add your handling code here:
        readForm();
        hd.setTrangThai(true);
        Integer rs = service.updateHoaDon(hd);
        if (rs != null) {
            JOptionPane.showMessageDialog(null, "Thanh toán thành công");
            loaddatatpHoaDon();
        } else {
            JOptionPane.showMessageDialog(null, "Thanh toán thất bại");
        }
    }//GEN-LAST:event_btn_ttoanActionPerformed

    private void btn_ghActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ghActionPerformed
        // TODO add your handling code here:
        readForm();
        if (thanhToan.isSelected()) {
            hd.setTrangThai(true);
        } else {
            hd.setTrangThai(false);
        }
        hd.setLoaiDH(1);
        Integer rs = service.updateHoaDon(hd);
        if (rs != null) {
            JOptionPane.showMessageDialog(null, "Đặt hàng thành công");
            loaddatatpHoaDon();
        } else {
            JOptionPane.showMessageDialog(null, "Đặt hàng thất bại");
        }
    }//GEN-LAST:event_btn_ghActionPerformed

    private void thanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thanhToanActionPerformed

    private void btn_hthanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hthanhActionPerformed
        // TODO add your handling code here:
        hd.setTrangThai(true);
        hd.setLoaiDH(2);
        Integer rs = service.updateHoaDon(hd);
        if (rs != null) {
            JOptionPane.showMessageDialog(null, "Hoàn thành đơn hàng thành công");
            loaddatatpHoaDon();
        } else {
            JOptionPane.showMessageDialog(null, "Hoàn thành đơn hàng thất bại");
        }
    }//GEN-LAST:event_btn_hthanhActionPerformed

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_huyActionPerformed

    private void txt_phiShipMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_phiShipMouseReleased
        // TODO add your handling code here:
        float phiship = Float.valueOf(txt_phiShip.getText());
        float tienHang = Float.valueOf(txt_tienSP.getText());
        txt_tongTien.setText(String.valueOf(phiship + tienHang));
    }//GEN-LAST:event_txt_phiShipMouseReleased

    private void txt_khachDuaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_khachDuaMouseReleased
        // TODO add your handling code here:
        float khachDua = Float.valueOf(txt_khachDua.getText());
        float tongTien = Float.valueOf(txt_tongTien.getText());
        txt_tienThua.setText(String.valueOf(khachDua>=tongTien?khachDua-tongTien:"thiếu"));
    }//GEN-LAST:event_txt_khachDuaMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btn_gh;
    private javax.swing.JButton btn_hthanh;
    private javax.swing.JButton btn_huy;
    private javax.swing.JButton btn_ttoan;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnnext1;
    private javax.swing.JButton btnprev;
    private javax.swing.JComboBox<String> cbo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon1;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JCheckBox thanhToan;
    private javax.swing.JCheckBox txt_datHang;
    private javax.swing.JTextField txt_khachDua;
    private javax.swing.JLabel txt_maNV;
    private javax.swing.JTextField txt_phiShip;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_sp;
    private javax.swing.JTextField txt_tenKH;
    private javax.swing.JLabel txt_tienHang;
    private javax.swing.JLabel txt_tienSP;
    private javax.swing.JLabel txt_tienThua;
    private javax.swing.JLabel txt_tongTien;
    // End of variables declaration//GEN-END:variables

    private void loaddatatpHoaDon() {
        model.setRowCount(0);
        list = service.pagingByTen(page, 3, 0);
        if (list.isEmpty()) {
            System.out.println("null");
        }
        for (HoaDon x : list) {
            model.addRow(new Object[]{x.getMaHoaDon(), x.getMaNhanVien(), x.getMaKhachHang(), x.getTongTien(),
                x.getLoaiDH() == 4 ? "Tại quầy" : x.getLoaiDH() == 0 ? "Chờ lấy hàng" : "Đang giao",
                x.getTrangThai() ? "Đã thanh toán" : "Chưa thanh toán"});
        }
    }

    private void loaddatattoSP() {
        model1.setRowCount(0);
        list1 = service1.pagingByTen(page, 5, ten, "1");
        int vi = 1;
        if (page != 1) {
            vi = page * 5 + 1;
        }
        for (SanPhamChiTiet spct : list1) {
            int sl = service1.soLuongTonSP(spct.getMaSPCT(), "1").size();
            SanPham sp = service1.searchByid(spct.getMaSP());
            if (sl > 0) {
                model1.addRow(new Object[]{vi, sp.getTen(), rams.searchByID(spct.getMaRam()).toString(),
                    bnts.searchByID(spct.getMaBoNhoTrong()).toString(), mhs.searchById(spct.getMaManHinh()).toString(),
                    mss.searchByID(spct.getMaMauSac()), sl, spct.getGiaBan()});
            }
            vi++;
        }
    }

    private void themSPVaoGioHang() {
    }

    private void loadToImei() {
        cbo.removeAllItems();
        SanPhamChiTiet x = list1.get(index);
        List<Imei> listi = imeis.searchBymasqpct(x.getMaSPCT(), "1");
        for (Imei imei : listi) {
            cbo.addItem(imei.getSoImei());
        }
    }

    private void loadToGioHang() {
        list2 = service.gethdct(maHD);
        model2.setRowCount(0);
        for (HoaDonChiTiet hdct : list2) {
            Imei imei = imeis.searchByID(hdct.getMaImei());
            SanPhamChiTiet spct = service1.searchBymaSPCT(imei.getMaSanPhamChiTiet());
            SanPham sp = service1.searchByid(spct.getMaSP());
            model2.addRow(new Object[]{
                sp.getTen(), rams.searchByID(spct.getMaRam()).toString(),
                bnts.searchByID(spct.getMaBoNhoTrong()).toString(), mhs.searchById(spct.getMaManHinh()).toString(),
                mss.searchByID(spct.getMaMauSac()), 1, hdct.getDonGia(), hdct.getTongGia()
            });
        }
    }

    private void BoSpKhoiGioHang() {
        HoaDonChiTiet hdct = list2.get(index);
        Imei imei = imeis.searchByID(hdct.getMaImei());
        imei.setTrangThai(true);
        imeis.update(imei);
        Integer rs = service.deleteHDCT(hdct);
        if (rs != null) {
            JOptionPane.showMessageDialog(null, "Xóa sản phẩm thành công!");
            service.updateHoaDon(hd);
            loaddatatpHoaDon();
        }
        loadToGioHang();
        loaddatattoSP();
    }

    public void readForm() {
        hd.setSoDienThoai(txt_sdt.getText());
        hd.setTienShip(Float.valueOf(txt_phiShip.getText()));
        hd.setTienHang(Float.valueOf(txt_tienSP.getText()));
        hd.setTongTien(Float.valueOf(txt_tongTien.getText()));
    }
}
