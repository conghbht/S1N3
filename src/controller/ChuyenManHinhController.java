/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.w3c.dom.Node;
import views.BanHangView;
import views.HoaDonView;
import views.KhachHangView;
import views.KhuyenMaiView;
import views.NhanVienView;
import views.SanPhamView;
import views.ThongKeView;

/**
 *
 * @author dovan
 */
public class ChuyenManHinhController {

    private JPanel root;
    private String kindSelected = "";
    private List<DanhMucBean> listItem;

    public ChuyenManHinhController(JPanel jplroot) {
        this.root = jplroot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangChu";

        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new KhachHangView());
        root.validate();
        root.repaint();
    }

    public void setEven(List<DanhMucBean> listItem) {
        this.listItem = listItem;
        for (DanhMucBean item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(),item.getJpn(),item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;

        private String kind;
        private JPanel jpnItem;
        private JLabel jlblItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlblItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlblItem = jlblItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "SanPham":
                    node = new SanPhamView();
                    break;
                case "KhachHang":
                    node = new KhachHangView();
                    break;
                case "NhanVien":
                    node = new NhanVienView();
                    break;
                case "HoaDon":
                    node = new HoaDonView();
                    break;
                case "KhuyenMai":
                    node = new KhuyenMaiView();
                    break;
                case "BanHang":
                    node = new BanHangView();
                    break;
                case "ThongKe":
                    node = new ThongKeView();
                    break;
                default:
                    throw new AssertionError();
            }

            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected=kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jlblItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96, 100, 191));
            jlblItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
           if(!kindSelected.equalsIgnoreCase(kind)){
               jpnItem.setBackground(new Color(0, 0, 204));
               jlblItem.setBackground(new Color(0, 0, 204));
           }
        }

    }
    private void setChangeBackground(String kind){
        for(DanhMucBean item : listItem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJlb().setBackground(new Color(96, 100, 191));
                item.getJpn().setBackground(new Color(96, 100, 191));
            }else{
                item.getJlb().setBackground(new Color(0,0,204));
                item.getJpn().setBackground(new Color(0,0,204));
            }
        }
    }
}
