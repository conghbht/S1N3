/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import models.SanPham;
import models.SanPhamChiTiet;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author dovan
 */
public class ImportExcell {

    public static ArrayList<SanPham> importExcelDataSP(File file) {
        ArrayList<SanPham> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file); Workbook workbook = new XSSFWorkbook(fis)) {
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read the first sheet
            Iterator<Row> rowIterator = sheet.iterator();

            // Skip the header row
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                SanPham product = new SanPham();
                product.setMaSanPham(getStringCellValue(row.getCell(0)));
                product.setTenSanPham(getStringCellValue(row.getCell(1)));
                product.setMoTa(getStringCellValue(row.getCell(2)));
                product.setMaThuongHieu(getma(getStringCellValue(row.getCell(3))));
                product.setMaLoaiHang(getma(getStringCellValue(row.getCell(4))));
                product.setMaDongSanPham(getma(getStringCellValue(row.getCell(5))));
                product.setMaXuatXu(getma(getStringCellValue(row.getCell(6))));
                data.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static ArrayList<SanPhamChiTiet> importExcelDataSPCT(File file) {
        ArrayList<SanPhamChiTiet> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file); Workbook workbook = new XSSFWorkbook(fis)) {
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read the first sheet
            Iterator<Row> rowIterator = sheet.iterator();

            // Skip the header row
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                 SanPhamChiTiet x = new SanPhamChiTiet();
                x.setMaSPCT(rs.getInt("maSanPhamChiTiet"));
                x.setMaSP(rs.getString("maSanPham"));
                x.setMaMauSac(rs.getInt("maMauSac"));
                x.setMaManHinh(rs.getInt("maManHinh"));
                x.setMaBoNhoTrong(rs.getInt("maBoNhoTrong"));
                x.setMaCamera(rs.getInt("maCamera"));
                x.setMaRam(rs.getInt("maRam"));
                x.setMaCPU(rs.getInt("maCPU"));
                x.setMaXuatXu(rs.getInt("maXuatXu"));
                x.setMaLoaiHang(rs.getInt("maLoaiHang"));
                x.setGiaNhap(rs.getDouble("giaNhap"));
                x.setGiaBan(rs.getDouble("giaSanPham"));
                x.setNgayTao(rs.getString("ngayTao"));
                x.setTrangThai(rs.getInt("trangThai")==1?true:false);
                data.add(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private static Date convertExcelDateToJavaDate(double excelValueDate) {
        long javaDateValue = (long) ((excelValueDate - 25569) * 86400 * 1000);
        return new Date(javaDateValue);
    }

    public static String getStringCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            default:
                return null;
        }
    }

    public static int getma(String input) {
        // Tìm vị trí của dấu "-" trong chuỗi
        int dashIndex = input.indexOf("-");

        // Kiểm tra xem có dấu "-" trong chuỗi không
        if (dashIndex != -1 && dashIndex < input.length() - 1) {
            // Sử dụng substring để lấy phần sau dấu "-"
            String numberPart = input.substring(dashIndex + 1);

            // Chuyển đổi chuỗi số thành kiểu dữ liệu số nguyên (nếu cần)
            int number = Integer.parseInt(numberPart);

            // In ra số đã trích xuất
            return number;
        }
        return 1;
    }
}
