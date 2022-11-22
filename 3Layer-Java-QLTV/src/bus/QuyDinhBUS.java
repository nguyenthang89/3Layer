/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import dao.QuyDinhDAO;
import dto.QuyDinhDTO;
import java.util.ArrayList;

/**
 *
 * @author itngu
 */
public class QuyDinhBUS {

    public static ArrayList<QuyDinhDTO> loadTheLoaiSach() {
        return QuyDinhDAO.loadTheLoaiSach();
    }  

    public static int save(String minTuoi, String maxTuoi, String thoiHanThe, String theLoaiSach1, String theLoaiSach2, String theLoaiSach3, String namXuatBan, String soLuong) {
        return QuyDinhDAO.save(minTuoi, maxTuoi, thoiHanThe, theLoaiSach1, theLoaiSach2, theLoaiSach3, namXuatBan, soLuong);
    }

}
