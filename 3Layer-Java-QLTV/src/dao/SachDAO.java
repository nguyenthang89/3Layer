/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.SachDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import util.DbConnect;

/**
 *
 * @author itngu
 */
public class SachDAO {
    static DbConnect myConnect = new DbConnect();

    public static ArrayList<SachDTO> timKiemSach(String ISBN, String tenSach, String tenTacGia, String theLoai, Date ngayNhap, Integer namXuatBan, String nhaXuatBan){
        Map<String,String> map = new HashMap<String,String>();
        if (!ISBN.isEmpty()){
            map.put("isbn", ISBN);
        }               
        
        if (!tenSach.isEmpty()){
            map.put("tensach", tenSach);
        }
        if (!tenTacGia.isEmpty()){
            map.put("tentacgia", tenTacGia);
        }
        if(!theLoai.isEmpty()) {
            map.put("theloai", theLoai);
        }
        if (ngayNhap != null) {
            map.put("ngaynhap", new SimpleDateFormat("yyyy-MM-dd").format(ngayNhap));    
        }        
        if (namXuatBan != null) {
            map.put("namxuatban", new SimpleDateFormat("yyyy-MM-dd").format(namXuatBan));    
        }          
        
        StringBuilder whereCondititon = new StringBuilder("");
        if (!map.isEmpty()) {
            whereCondititon.append(" WHERE ");
        }
        
        for (Map.Entry<String, String> entry : map.entrySet()) {
            //System.out.println(entry.getKey() + " " + entry.getValue());
            if(!entry.getValue().isEmpty()){
               whereCondititon.append(entry.getKey()).append(" = '").append(entry.getValue()).append("' AND ");    
            }            
        }
        
        if(whereCondititon.length()> 5 && " AND ".equals(whereCondititon.substring(whereCondititon.length()-5))){
            whereCondititon.replace(whereCondititon.length() - 5, whereCondititon.length(), "");           
        }       
        
        ArrayList<SachDTO> arr = new ArrayList<SachDTO>();
        String sql = "SELECT * FROM sach  " + whereCondititon;
        
        try {
            myConnect.open();
            ResultSet rs = myConnect.excuteQuery(sql);
            while(rs.next()){
                SachDTO sach = new SachDTO();
                sach.setISBN(rs.getString("isbn"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setTacGia(rs.getString("tentacgia"));
                sach.setTheLoaiSach(rs.getString("theloai"));
                sach.setTinhTrangSach(rs.getString("tinhtrang"));
                sach.setNamXuatBan(rs.getInt("namxuatban"));
                sach.setNgayNhap(rs.getDate("ngaynhap"));
                arr.add(sach);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            myConnect.close();
        }
        return arr;
    }

    public static int themSach(SachDTO sach) throws Exception {
        int rs = 0;
        String str = "INSERT INTO sach (isbn, nhaxuatban,  tentacgia, tensach, theloai, namxuatban, ngaynhap, tinhtrang) VALUES ("
            + "'" + sach.getISBN()+ "'"
            + ", " + "'" + sach.getNhaXuatBan()+ "'"    
            + ", " + "'" + sach.getTacGia()+ "'"
            + ", " + "'" + sach.getTenSach()+ "'"
            + ", " + "'" + sach.getTheLoaiSach()+ "'"
            + ", " + "'" + sach.getNamXuatBan()+ "'"    
            + ", " + "'" + sach.getNgayNhap()+ "'"    
            + ", " + "'" + sach.getTinhTrangSach()+ "')" ;        
        
        try {
            myConnect.open();
            rs+= myConnect.excuteUpdate(str);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            myConnect.close();
        }
        return rs;
    }

    public static ArrayList<SachDTO> loadSachCoTheChoMuon(String ISBN, String tenSach, String flag) {        
        String string1 = "";
        if(!ISBN.isEmpty()){
            string1 += " AND isbn = '" + ISBN + "'";
        }
        
        String string2 = "";
        if(!tenSach.isEmpty()){
            string2 += " AND tensach = '" + tenSach + "'";
        }
        ArrayList<SachDTO> arr = new ArrayList<SachDTO>();
        String sql = "SELECT * FROM sach WHERE status = 'Y' " + string1 + string2;
        
        try {
            myConnect.open();
            ResultSet rs = myConnect.excuteQuery(sql);
            while(rs.next()){
                SachDTO sach = new SachDTO();
                sach.setISBN(rs.getString("isbn"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setTacGia(rs.getString("tentacgia"));
                sach.setTheLoaiSach(rs.getString("theloai"));
                sach.setTinhTrangSach(rs.getString("tinhtrang"));
                sach.setNamXuatBan(rs.getInt("namxuatban"));
                sach.setNgayNhap(rs.getDate("ngaynhap"));
                arr.add(sach);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            myConnect.close();
        }
        return arr;
    }   
    
}
