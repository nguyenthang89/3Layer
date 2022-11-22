/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import dao.DocGiaDAO;
import dao.QuyDinhDAO;
import dto.DocGiaDTO;
import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 *
 * @author itngu
 */
public class DocGiaBUS {
    
    public static int kiemTraTuoi(LocalDate ngaySinh){
        LocalDate currenDate = LocalDate.now();
        Period period = ngaySinh.until(currenDate);        
        int tuoi = period.getYears();
        return tuoi;
    }
    
    public static Date tinhNgayHetHanThe(){
        // load qui dinh tu database
        int i = QuyDinhDAO.getQuiDinhThoiHanThe();
        LocalDate currenDate = LocalDate.now();
        LocalDate nextSixMonths = currenDate.plusMonths(i);
        Date ngay = java.sql.Date.valueOf(nextSixMonths);        
        return ngay;              
    }
    
    public static int themDocGia(DocGiaDTO docgia) throws Exception{
        // Logic handle
        int tuoi = kiemTraTuoi(LocalDate.parse(docgia.getNgaySinh().toString()));        
        Date ngayHetHan = tinhNgayHetHanThe();
        int i = QuyDinhDAO.getQuiDinhTuoiToiDa();
        int j = QuyDinhDAO.getQuiDinhTuoiToiThieu();
        if(tuoi > i || tuoi < j){
            return -1;
        }else{
            docgia.setNgayHetHan(ngayHetHan);
            return DocGiaDAO.themDocGia(docgia);    
        }        
    }
    
    public static ArrayList<DocGiaDTO> layTatCaDocGia(){      
        return DocGiaDAO.layTatCaDocGia();
    }
    
    public static ArrayList<DocGiaDTO> timDocGia(String ten, String cccd, String email, Date ngaySinh, String diachi){      
        return DocGiaDAO.timKiemDocGia(ten, cccd, email, ngaySinh, diachi);
    }

    public static int capNhatDocGia(String oldCCCD, DocGiaDTO docgia) throws Exception{        
        int tuoi = kiemTraTuoi(LocalDate.parse(docgia.getNgaySinh().toString()));        
        Date ngayHetHan = tinhNgayHetHanThe();
        if(tuoi > 35 || tuoi < 18){
            return -1;
        }else{
            docgia.setNgayHetHan(ngayHetHan);
            return DocGiaDAO.capNhatDocGia(oldCCCD, docgia);    
        }
    }

    public static int Xoa(ArrayList<String> arr) throws Exception{
        return DocGiaDAO.Xoa(arr);
    }
    
}
