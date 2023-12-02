package views;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.HoaDonChiTiet;
import models.HoaDonModel;
import models.Imei;
import models.SanPham;
import models.SanPhamChiTiet;
import services.HoaDonService;
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

public class HoaDonView extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultTableModel dtm1 = new DefaultTableModel();
    private int soTrang = 1; //số Trang hiện tại
    private int soDong = 6;//Số dòng hiển thị mỗi trang của bảng
    private ArrayList<HoaDonModel> listHDByStatus = new ArrayList<>();
    private ArrayList<HoaDonChiTiet> listHDCT = new ArrayList<>();
    private HoaDonService hds = new HoaDonService();
    SanPhamService service1 = new SanPhamService();
    ImeiService imeis = new ImeiService();
    RamService rams = new RamService();
    BoNhoTrongService bnts = new BoNhoTrongService();
    ManHinhService mhs = new ManHinhService();
    MauSacService mss = new MauSacService();

    public HoaDonView() {
        initComponents();
        setOpaque(false);
        dtm = (DefaultTableModel) tblHoaDon.getModel();
        dtm1 = (DefaultTableModel) tblHDCT.getModel();
        dtm.setRowCount(6);
        listHDByStatus = hds.getHDByStatus("1");
        fillTable();
        configTable();
    }

    private void configTable() {
        int[] configHD = {50, 50, 50, 80, 110, 120, 90, 80};
        int[] configHDCT = {70, 70, 150, 110,120, 80, 80, 110,110};
        for (int i = 0; i < configHD.length; i++) {
            this.tblHoaDon.getColumnModel().getColumn(i).setPreferredWidth(configHD[i]);
        }
        for (int i = 0; i < configHDCT.length; i++) {
            this.tblHDCT.getColumnModel().getColumn(i).setPreferredWidth(configHDCT[i]);
        }
    }

    private void fillTable() {
        int startIdx = (soTrang - 1) * soDong;
        int endIdx = Math.min(startIdx + soDong, listHDByStatus.size());

        dtm.setRowCount(0);

        for (int i = startIdx; i < endIdx; i++) {
            HoaDonModel h = listHDByStatus.get(i);
            int tt = h.getTrangThai();
            if (tt == 1) {
                dtm.addRow(new Object[]{
                    dtm.getRowCount() + 1,
                    h.getMaHD(), h.getKhachHang().getMaKhachHang(),
                    h.getNhanVien().getMaNhanVien(), h.getTongTien(),
                    h.getNgayTao(), h.getLoaiDonHang(), h.getTrangThai()
                });
            }
        }
        int maxPage = (int) Math.ceil((double) listHDByStatus.size() / soDong);
        lblTrang.setText("Trang " + soTrang + "/" + maxPage);

    }

    private void next() {
        int maxPage = (int) Math.ceil((double) listHDByStatus.size() / soDong);
        if (soTrang < maxPage) {
            soTrang++;
            fillTable();
        }
    }

    private void prev() {
        if (soTrang > 1) {
            soTrang--;
            fillTable();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHD = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        txtMaHD = new javax.swing.JTextField();
        lblTrang = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHDCT = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jdcTu = new com.toedter.calendar.JDateChooser();
        jdcDen = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtMaKH = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlHD.setBackground(new java.awt.Color(255, 255, 255));
        pnlHD.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quản lý hóa đơn");

        tblHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblHoaDon.setForeground(new java.awt.Color(0, 51, 255));
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HĐ", "Mã KH", "Mã NV", "Tổng tiền", "Ngày tạo", "Loại đơn hàng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblHoaDon.setGridColor(new java.awt.Color(153, 204, 255));
        tblHoaDon.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tblHoaDon.setOpaque(false);
        tblHoaDon.setRowHeight(30);
        tblHoaDon.setSelectionBackground(new java.awt.Color(0, 51, 255));
        tblHoaDon.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);
        if (tblHoaDon.getColumnModel().getColumnCount() > 0) {
            tblHoaDon.getColumnModel().getColumn(0).setResizable(false);
            tblHoaDon.getColumnModel().getColumn(1).setResizable(false);
            tblHoaDon.getColumnModel().getColumn(2).setResizable(false);
            tblHoaDon.getColumnModel().getColumn(3).setResizable(false);
            tblHoaDon.getColumnModel().getColumn(4).setResizable(false);
            tblHoaDon.getColumnModel().getColumn(5).setResizable(false);
            tblHoaDon.getColumnModel().getColumn(6).setResizable(false);
            tblHoaDon.getColumnModel().getColumn(7).setResizable(false);
        }

        txtMaHD.setBackground(new java.awt.Color(204, 204, 204));
        txtMaHD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMaHD.setForeground(new java.awt.Color(0, 51, 255));
        txtMaHD.setBorder(null);
        txtMaHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaHDKeyReleased(evt);
            }
        });

        lblTrang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTrang.setForeground(new java.awt.Color(0, 51, 255));
        lblTrang.setText("Trang");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 255));
        jButton1.setText(">");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 51, 255));
        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblHDCT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblHDCT.setForeground(new java.awt.Color(51, 102, 255));
        tblHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HĐCT", "Số IMEI", "Tên SP", "Ram", "Rom", "Màn", "Màu", "Đơn giá", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHDCT.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblHDCT.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tblHDCT.setRowHeight(30);
        tblHDCT.setSelectionBackground(new java.awt.Color(0, 0, 255));
        tblHDCT.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(tblHDCT);
        if (tblHDCT.getColumnModel().getColumnCount() > 0) {
            tblHDCT.getColumnModel().getColumn(0).setResizable(false);
            tblHDCT.getColumnModel().getColumn(1).setResizable(false);
            tblHDCT.getColumnModel().getColumn(2).setResizable(false);
            tblHDCT.getColumnModel().getColumn(3).setResizable(false);
            tblHDCT.getColumnModel().getColumn(4).setResizable(false);
            tblHDCT.getColumnModel().getColumn(5).setResizable(false);
            tblHDCT.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Hóa đơn chi tiết");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(795, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jdcTu.setDateFormatString("yyyy-MM-dd");

        jdcDen.setDateFormatString("yyyy-MM-dd");
        jdcDen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jdcDenKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Từ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Đến");

        jButton3.setText("Tìm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtMaKH.setBackground(new java.awt.Color(204, 204, 204));
        txtMaKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMaKH.setForeground(new java.awt.Color(0, 51, 255));
        txtMaKH.setBorder(null);
        txtMaKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaKHKeyReleased(evt);
            }
        });

        txtMaNV.setBackground(new java.awt.Color(204, 204, 204));
        txtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMaNV.setForeground(new java.awt.Color(0, 51, 255));
        txtMaNV.setBorder(null);
        txtMaNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaNVKeyReleased(evt);
            }
        });

        jLabel3.setText("Mã HD");

        jLabel6.setText("Mã KH");

        jLabel7.setText("Mã NV");

        txtSDT.setBackground(new java.awt.Color(204, 204, 204));
        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSDT.setForeground(new java.awt.Color(0, 51, 255));
        txtSDT.setBorder(null);
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSDTKeyReleased(evt);
            }
        });

        jLabel8.setText("SDT");

        lblError.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblError.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout pnlHDLayout = new javax.swing.GroupLayout(pnlHD);
        pnlHD.setLayout(pnlHDLayout);
        pnlHDLayout.setHorizontalGroup(
            pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlHDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHDLayout.createSequentialGroup()
                        .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(301, 301, 301))
                    .addGroup(pnlHDLayout.createSequentialGroup()
                        .addGroup(pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlHDLayout.createSequentialGroup()
                                .addGroup(pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdcTu, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlHDLayout.createSequentialGroup()
                                        .addComponent(jdcDen, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3))
                                    .addComponent(jLabel5)))
                            .addGroup(pnlHDLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(lblTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(pnlHDLayout.createSequentialGroup()
                .addGroup(pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlHDLayout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlHDLayout.setVerticalGroup(
            pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHDLayout.createSequentialGroup()
                        .addGroup(pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jdcDen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jdcTu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlHDLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlHDLayout.createSequentialGroup()
                                .addGroup(pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlHDLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlHDLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlHDLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        prev();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        next();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtMaHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaHDKeyReleased
        String maHD = txtMaHD.getText().trim();
        lblError.setText("");
        if (!maHD.isEmpty()) {
            ArrayList<HoaDonModel> hd = hds.getHDByMaHD(maHD);
            if (hd != null && !hd.isEmpty()) {
                listHDByStatus = hd;
                fillTable();
            } else {
                lblError.setText("Không tìm thấy!");
            }
        } else {
            listHDByStatus = hds.getHDByStatus("1");
            fillTable();
        }
    }//GEN-LAST:event_txtMaHDKeyReleased

    private void jdcDenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdcDenKeyReleased

    }//GEN-LAST:event_jdcDenKeyReleased

    private void txtMaKHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaKHKeyReleased
        String maKH = txtMaKH.getText().trim();
        lblError.setText("");
        if (!maKH.isEmpty()) {
            ArrayList<HoaDonModel> hd = hds.getHDByMaKH(maKH);
            if (hd != null && !hd.isEmpty()) {
                listHDByStatus = hd;
                fillTable();
            } else {
                lblError.setText("Không tìm thấy!");
            }
        } else {
            listHDByStatus = hds.getHDByStatus("1");
            fillTable();
        }
    }//GEN-LAST:event_txtMaKHKeyReleased

    private void txtMaNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaNVKeyReleased
        String maNV = txtMaNV.getText().trim();
        lblError.setText("");
        if (!maNV.isEmpty()) {
            ArrayList<HoaDonModel> hd = hds.getHDByMaNV(maNV);
            if (hd != null && !hd.isEmpty()) {
                listHDByStatus = hd;
                fillTable();
            } else {
                lblError.setText("Không tìm thấy!");
            }
        } else {
            listHDByStatus = hds.getHDByStatus("1");
            fillTable();
        }
    }//GEN-LAST:event_txtMaNVKeyReleased

    private void txtSDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyReleased
        String sdt = txtSDT.getText().trim();
        lblError.setText("");
        if (!sdt.isEmpty()) {
            ArrayList<HoaDonModel> hd = hds.getHDBySdt(sdt);
            if (hd != null && !hd.isEmpty()) {
                listHDByStatus = hd;
                fillTable();
            } else {
                lblError.setText("Không tìm thấy!");
            }
        } else {
            listHDByStatus = hds.getHDByStatus("1");
            fillTable();
        }
    }//GEN-LAST:event_txtSDTKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Date toDate = new Date(jdcTu.getDate().getTime());

        Date fromDate = new Date(jdcDen.getDate().getTime());

        if (toDate.after(fromDate)) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không thể sau ngày kết thúc.");
            System.out.println("Ngày bắt đầu không thể sau ngày kết thúc.");
            return;
        }

        ArrayList<HoaDonModel> result = hds.getHDByDate(toDate, fromDate);
        if (toDate != null || fromDate != null) {
            if (result != null && !result.isEmpty()) {
                for (HoaDonModel hoaDon : result) {
                    listHDByStatus = result;
                    fillTable();
                }
                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
            } else {
                JOptionPane.showMessageDialog(this, "Không có hóa đơn trong khoảng thời gian này.");
                System.out.println("Không có hóa đơn trong khoảng thời gian này.");
            }
        } else {
            listHDByStatus = hds.getHDByStatus("1");
            fillTable();
            System.out.println("tìm theo ngày hủy");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int row = tblHoaDon.getSelectedRow();
        int rowHienTai = (soTrang - 1) * soDong + row;
        if (row >= 0) {

            HoaDonModel h = listHDByStatus.get(rowHienTai);
            System.out.println("Index row HD = " + rowHienTai + " ID HD: " + h.getMaHD());
            int idHoaDon = h.getMaHD();
            loadToGioHang(idHoaDon);
            lblError.setText(null);
        } else {
            lblError.setText("Chọn một hóa đơn");
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcDen;
    private com.toedter.calendar.JDateChooser jdcTu;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblTrang;
    private javax.swing.JPanel pnlHD;
    private javax.swing.JTable tblHDCT;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables
private void loadToGioHang(int maHD) {
        listHDCT = hds.gethdct(maHD);
        dtm1.setRowCount(0);
        for (HoaDonChiTiet hdct : listHDCT) {
            Imei imei = imeis.searchByID(hdct.getMaImei());
            SanPhamChiTiet spct = service1.searchBymaSPCT(imei.getMaSanPhamChiTiet());
            SanPham sp = service1.searchByid(spct.getMaSP());
            dtm1.addRow(new Object[]{
                hdct.getMaHDCT(),imei.getSoImei(),sp.getTen(),
                rams.searchByID(spct.getMaRam()).toString(),
                bnts.searchByID(spct.getMaBoNhoTrong()).toString(), mhs.searchById(spct.getMaManHinh()).toString(),
                mss.searchByID(spct.getMaMauSac()), hdct.getDonGia(), hdct.getTongGia()
            });
        }
    }
}
