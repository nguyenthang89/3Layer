/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.DocGiaDTO;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import util.DbConnect;

/**
 *
 * @author itngu
 */
public class DocGiaDAO {
    static DbConnect myConnect = new DbConnect();
    
    public static int capNhatDocGia(String oldCCCD, DocGiaDTO docGia) throws Exception{  
        int rs = 0;
        String str = "UPDATE docgia SET "
            +" cccd= "+ "'" + docGia.getcCCD()+ "'"
            + ", " +"hotendocgia= " + "'" + docGia.getTenDocGia()+ "'"    
            + ", " +"loaidocgia= " + "'" + docGia.getLoaiDocGia()+ "'"
            + ", " +"diachi= " + "'" + docGia.getDiaChi()+ "'"
            + ", " +"email= " + "'" + docGia.getEmail()+ "'"
            + ", " +"ngaysinh= " + "'" + docGia.getNgaySinh()+ "'"
            + ", " +"cre_dt= " +  "'" + docGia.getNgayLapThe()+ "'"
            + ", " +"ngayhethan= " + "'" + docGia.getNgayHetHan()+ "' "
            + "WHERE cccd ='" + oldCCCD + "'";
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
    
    public static int themDocGia(DocGiaDTO docGia) throws Exception{
        int rs = 0;
        String str = "INSERT INTO docgia (cccd, hotendocgia,  loaidocgia, diachi, email, ngaysinh, cre_dt, ngayhethan) VALUES ("
            + "'" + docGia.getcCCD()+ "'"
            + ", " + "'" + docGia.getTenDocGia()+ "'"    
            + ", " + "'" + docGia.getLoaiDocGia()+ "'"
            + ", " + "'" + docGia.getDiaChi()+ "'"
            + ", " + "'" + docGia.getEmail()+ "'"
            + ", " + "'" + docGia.getNgaySinh()+ "'"
            + ", " + "'" + docGia.getNgayLapThe()+ "'"
            + ", " + "'" + docGia.getNgayHetHan()+ "')" ;
        
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

    public static ArrayList<DocGiaDTO> layTatCaDocGia() {
        ArrayList<DocGiaDTO> arr = new ArrayList<DocGiaDTO>();
        String sql = "SELECT * FROM docgia WHERE flag = 'Y' ";
        try {
            myConnect.open();
            ResultSet rs = myConnect.excuteQuery(sql);
            while(rs.next()){
                DocGiaDTO docgia = new DocGiaDTO();
                docgia.setcCCD(rs.getString("cccd"));
                docgia.setTenDocGia(rs.getString("hotendocgia"));
                docgia.setLoaiDocGia(rs.getString("loaidocgia"));
                docgia.setDiaChi(rs.getString("diachi"));
                docgia.setEmail(rs.getString("email"));
                docgia.setNgaySinh(rs.getDate("ngaysinh"));
                docgia.setNgayLapThe(rs.getDate("cre_dt"));
                docgia.setNgayHetHan(rs.getDate("ngayhethan"));
                arr.add(docgia);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            myConnect.close();
        }
        return arr;
    }
    
    public static ArrayList<DocGiaDTO> timKiemDocGia(String ten, String cccd, String email, Date ngaySinh, String diachi) {                   
        Map<String,String> map = new HashMap<String,String>();
        if (!ten.isEmpty()){
            map.put("hotendocgia", ten);
        }
        if (!cccd.isEmpty()){
            map.put("cccd", cccd);
        }
        if(!email.isEmpty()) {
            map.put("email", email);
        }
        if (ngaySinh != null) {
            map.put("ngaysinh", new SimpleDateFormat("yyyy-MM-dd").format(ngaySinh));    
        }        
        
        if (!diachi.isEmpty()) {
            map.put("diachi", diachi);
        }              
        
        StringBuilder whereCondititon = new StringBuilder("");
        if (!map.isEmpty()) {
            whereCondititon.append(" ");
        }
        
        for (Map.Entry<String, String> entry : map.entrySet()) {
            //System.out.println(entry.getKey() + " " + entry.getValue());
            if(!entry.getValue().isEmpty()){
               whereCondititon.append(entry.getKey()).append(" = '").append(entry.getValue()).append("' AND ");    
            }            
        }
        
        //        if(whereCondititon.length()> 5 && " AND ".equals(whereCondititon.substring(whereCondititon.length()-5))){
        //            whereCondititon.replace(whereCondititon.length() - 5, whereCondititon.length(), "");           
        //        }       
        
        ArrayList<DocGiaDTO> arr = new ArrayList<DocGiaDTO>();
        String sql = "SELECT * FROM docgia WHERE " + whereCondititon + " flag = 'Y'";
        
        try {
            myConnect.open();
            ResultSet rs = myConnect.excuteQuery(sql);
            while(rs.next()){
                DocGiaDTO docgia = new DocGiaDTO();
                docgia.setcCCD(rs.getString("cccd"));
                docgia.setTenDocGia(rs.getString("hotendocgia"));
                docgia.setLoaiDocGia(rs.getString("loaidocgia"));
                docgia.setDiaChi(rs.getString("diachi"));
                docgia.setEmail(rs.getString("email"));
                docgia.setNgaySinh(rs.getDate("ngaysinh"));
                docgia.setNgayLapThe(rs.getDate("cre_dt"));
                docgia.setNgayHetHan(rs.getDate("ngayhethan"));
                arr.add(docgia);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            myConnect.close();
        }
        return arr;
    }

    public static int kiemTraTonTai(String string) {
        int i = 0;
        String sql = "SELECT 1 FROM docgia WHERE cccd = '"+string +"'";
        try  {
            myConnect.open();
            ResultSet rs = myConnect.excuteQuery(sql);
            while(rs.next()){
                i += rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            myConnect.close();
        }      
        return i;
    }

    public static int Xoa(ArrayList<String> arr) throws Exception{
        int rs = 0;
        String s = "";
        String str="";
        for (int i = 0; i < arr.size(); i++) {            
            s+= "'" + arr.get(i) + "',";
        }        
        str+= s.substring(0, s.length()-1);                
        String sql = "UPDATE docgia SET flag = 'N' WHERE cccd IN (" + str + ")";
        
        try {
            myConnect.open();
            rs+= myConnect.excuteUpdate(sql);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            myConnect.close();
        }
        return rs;
    }

    
  
}
