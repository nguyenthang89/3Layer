/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import dao.MuonDAO;
import dao.QuyDinhDAO;
import dto.MuonDTO;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author itngu
 */
public class MuonBUS {

    // Kiểm tra hạn sử dụng thẻ
    public static boolean kiemTraHanSuDung(String theDocGia){
        int i = MuonDAO.kiemTraHanSuDung(theDocGia);
        return i == 1; //return true
    }

    // Kiểm tra sách này cho mượn được hay không
    public static boolean kiemTraSach(String maSach){
        int i = MuonDAO.kiemTraSach(maSach);
        return i == 1; //true
    }
    
    // Kiểm tra số ngày tối đa được mượn
    public static boolean kiemTraSoNgayMuon(Date date1, Date date2){   
        long diff = date1.getTime() - date2.getTime();
        long days = diff / (24 * 60 * 60 * 1000);
        return days <= QuyDinhDAO.kiemTraSoNgayMuon(); //true
    }
    
    // Kiểm tra số lượng sách độc giả mượn
    public static boolean kiemTraSoLuong(String theDocGia){
        int i = MuonDAO.kiemTraSoLuong(theDocGia);
        return i < QuyDinhDAO.getQDSoLuong() && i>=0; //true
    }
    public static int choMuonSach(MuonDTO obj) throws Exception {  
        //Duration diff = Duration.between(obj.getNgaychomuon().atStartOfDay(), d2.atStartOfDay());

        if(!kiemTraSach(obj.getMasach())){
            return -1;  //false
        }else if(!kiemTraHanSuDung(obj.getMadocgia())){
            return -2;  // false
        }else if(!kiemTraSoLuong(obj.getMadocgia())){
            return -3;  // false
        }else if(!kiemTraSoNgayMuon(obj.getNgayhentra(), obj.getNgaychomuon())){
            return -4;  // false        
        }else if(kiemTraSach(obj.getMasach()) && kiemTraHanSuDung(obj.getMadocgia()) && kiemTraSoLuong(obj.getMadocgia()) ){
            return MuonDAO.choMuonSach(obj); //true
        }else{
            return 0;
        }       
    }
    
    public static ArrayList<MuonDTO> loadDocGiaMuonSach() {
        return MuonDAO.loadDocGiaMuonSach();
    }

    public static int traSach(String maSach) {
        return MuonDAO.traSach(maSach);
    }
}
