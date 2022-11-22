/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.MuonDTO;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.DbConnect;

/**
 *
 * @author itngu
 */
public class MuonDAO {

    static DbConnect myConnect = new DbConnect();
    
    public static int choMuonSach(MuonDTO obj) throws Exception {
        int rs = 0;        
        // Convert java.ulti.Date to java.sql.Date
        Date ngayMuon= new Date(obj.getNgaychomuon().getTime());
        Date ngayHenTra= new Date(obj.getNgayhentra().getTime());
   
        String str = "INSERT INTO chomuon (madocgia, masach, ngaychomuon, ngayhentra) VALUES ("
            + "'" + obj.getMadocgia()+ "'"
            + ", " + "'" + obj.getMasach()+ "'"    
            + ", " + "'" + ngayMuon + "'"    
            + ", " + "'" + ngayHenTra + "')" ;     
        
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

    public static int kiemTraHanSuDung(String theDocGia) {
        
        int i= 0;
        String sql = "SELECT 1 FROM docgia WHERE ngayhethan > now() AND cccd = '" + theDocGia +"' LIMIT 1";
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
    
    public static int kiemTraSach(String maSach) {
        int i= 0;
        String sql = "SELECT 1 FROM sach WHERE status = 'Y' AND ISBN = '" + maSach +"'";
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

    public static int kiemTraSoLuong(String theDocGia) {
        int i= 0;
        String sql = "SELECT COUNT(madocgia) FROM chomuon";
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

    public static ArrayList<MuonDTO> loadDocGiaMuonSach() {       
        ArrayList<MuonDTO> arr = new ArrayList<MuonDTO>();        
        String sql = "SELECT cccd, hotendocgia, s.isbn, s.tensach, ngayhentra FROM docgia d"
                + " JOIN chomuon c ON d.cccd = c.madocgia \n" 
                + " JOIN sach s ON c.masach = s.isbn \n" 
                + "AND flag = 'Y'";         
        try {
            myConnect.open();
            ResultSet rs = myConnect.excuteQuery(sql);
            while(rs.next()){
                MuonDTO dto = new MuonDTO();
                dto.setMadocgia(rs.getString("cccd"));
                dto.setTendocgia(rs.getString("hotendocgia"));
                dto.setMasach(rs.getString("s.isbn"));
                dto.setTensach(rs.getString("s.tensach"));
                dto.setNgayhentra(rs.getDate("ngayhentra"));                
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

    public static int traSach(String maSach) {
        int rs = 0;
        String sql = "DELETE FROM chomuon WHERE masach='" + maSach + "'";
         try {
            myConnect.open();
            rs+= myConnect.excuteUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            myConnect.close();
        }
        return rs;   
    }
}
