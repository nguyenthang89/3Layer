/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import dao.QuyDinhDAO;
import dao.SachDAO;
import dto.SachDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author itngu
 */
public class SachBUS {

    public static int checkNamXB(Integer namXuatBan){
        int namHienTai = LocalDate.now().getYear();
        int ketQua = namHienTai - namXuatBan;
        return ketQua;        
    }
    
    public static int themSach(SachDTO sach) throws Exception {
        if(checkNamXB(sach.getNamXuatBan()) > QuyDinhDAO.getQDNamXuatBan()){
            return -1;
        }else{
            return SachDAO.themSach(sach);
        }
    }

    public static ArrayList<SachDTO> timKiemSach(String ISBN, String tenSach, String tenTacGia, String theLoai, Date ngayNhap, Integer namXuatBan, String nhaXuatBan){
        return SachDAO.timKiemSach(ISBN, tenSach, tenTacGia, theLoai, ngayNhap, namXuatBan, nhaXuatBan);
    }
    
    public static ArrayList<SachDTO> timKiemSachChoMuon(String ISBN, String tenSach, String tenTacGia, String theLoai, Date ngayNhap, Integer namXuatBan, String nhaXuatBan){
        return SachDAO.timKiemSach(ISBN, tenSach, tenTacGia, theLoai, ngayNhap, namXuatBan, nhaXuatBan);
    }
    
    public static ArrayList<SachDTO> loadSachCoTheChoMuon(String ISBN, String tenSach, String flag) {
        return SachDAO.loadSachCoTheChoMuon(ISBN, tenSach, flag);
    }
}
