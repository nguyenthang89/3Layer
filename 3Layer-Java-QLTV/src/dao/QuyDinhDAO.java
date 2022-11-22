/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.QuyDinhDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.DbConnect;

/**
 *
 * @author itngu
 */
public class QuyDinhDAO {

    static DbConnect myConnect = new DbConnect();
    
    public static ArrayList<QuyDinhDTO> loadTheLoaiSach() {
        ArrayList<QuyDinhDTO> arr = new ArrayList<QuyDinhDTO>();        
        String sql = "SELECT QD_theloaisach1, QD_theloaisach2, QD_theloaisach3 FROM quydinh WHERE maQD = 'QD1' ";         
        try {
            myConnect.open();
            ResultSet rs = myConnect.excuteQuery(sql);
            QuyDinhDTO dto = new QuyDinhDTO();
            while(rs.next()){                
                dto.setQD_theloaisach1(rs.getString("QD_theloaisach1"));
                dto.setQD_theloaisach2(rs.getString("QD_theloaisach2"));
                dto.setQD_theloaisach3(rs.getString("QD_theloaisach3"));                                
                arr.add(dto);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            myConnect.close();
        }
        return arr;
    }

    public static int getQuiDinhTuoiToiDa() {
        int i = 0;
        String sql = "SELECT QD_tuoitoida FROM quydinh WHERE maQD = 'QD1' ";
        try  {
            myConnect.open();
            ResultSet rs = myConnect.excuteQuery(sql);
            while(rs.next()){
                i+= rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            myConnect.close();
        }      
        return i;
    }
    
    public static int getQuiDinhTuoiToiThieu() {
        int i = 0;
        String sql = "SELECT QD_tuoitoithieu FROM quydinh WHERE maQD = 'QD1' ";
        try  {
            myConnect.open();
            ResultSet rs = myConnect.excuteQuery(sql);
            while(rs.next()){
                i+= rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            myConnect.close();
        }      
        return i;
    }

    public static int getQDSoLuong() {
        int i = 0;
        String sql = "SELECT QD_soluongmuon FROM quydinh WHERE maQD = 'QD1' ";
        try  {
            myConnect.open();
            ResultSet rs = myConnect.excuteQuery(sql);
            while(rs.next()){
                i+= rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            myConnect.close();
        }      
        return i;
    }

    public static int getQuiDinhThoiHanThe() {
        int i = 0;
        String sql = "SELECT QD_thoihanthe FROM quydinh WHERE maQD = 'QD1' ";
        try  {
            myConnect.open();
            ResultSet rs = myConnect.excuteQuery(sql);
            while(rs.next()){
                i+= rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            myConnect.close();
        }      
        return i;
    }

    public static int getQDNamXuatBan() {
        int i = 0;
        String sql = "SELECT QD_namxuatban FROM quydinh WHERE maQD = 'QD1' ";
        try  {
            myConnect.open();
            ResultSet rs = myConnect.excuteQuery(sql);
            while(rs.next()){
                i+= rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            myConnect.close();
        }      
        return i;
    }
    
    public static int save(String minTuoi, String maxTuoi, String thoiHanThe, String theLoaiSach1, String theLoaiSach2, String theLoaiSach3, String namXuatBan, String soLuong) {
        String str = "";
        if(!minTuoi.isEmpty()){
            str += ", QD_tuoitoithieu ='" + minTuoi + "'";
        }
        
        if(!maxTuoi.isEmpty()){
            str += ", QD_tuoitoida ='" + maxTuoi + "'";
        }
        
        if(!thoiHanThe.isEmpty()){
            str += ", QD_thoihanthe ='" + thoiHanThe + "'";
        }
        
        if(!theLoaiSach1.isEmpty()){
            str += ", QD_theloaisach1 ='" + theLoaiSach1 + "'";
        }
        
        if(!theLoaiSach2.isEmpty()){
            str += ", QD_theloaisach2 ='" + theLoaiSach2 + "'";
        }
        
        if(!theLoaiSach3.isEmpty()){
            str += ", QD_theloaisach3 ='" + theLoaiSach3 + "'";
        }
        
        if(!namXuatBan.isEmpty()){
            str += ", QD_namxuatban ='" + namXuatBan + "'";
        }
        
        if(!soLuong.isEmpty()){
            str += ", QD_soluongmuon ='" + soLuong + "'";
        }

        int rs = 0;
        if(str.length() > 0){
            String conditionString = str.substring(1);
            String sql = "UPDATE quydinh SET " + conditionString + " WHERE maQD = 'QD1' ";  
            try  {
                myConnect.open();
                rs+= myConnect.excuteUpdate(sql);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            } finally {
                myConnect.close();
            }           
        }
        return rs;         
    }

    public static int kiemTraSoNgayMuon() {
        int i = 0;
        String sql = "SELECT QD_songaymuon FROM quydinh WHERE maQD = 'QD1' ";
        try  {
            myConnect.open();
            ResultSet rs = myConnect.excuteQuery(sql);
            while(rs.next()){
                i+= rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            myConnect.close();
        }      
        return i;
    }
    
    
}
