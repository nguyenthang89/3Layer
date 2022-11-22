/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import util.DbConnect;

/**
 *
 * @author itngu
 */
public class DangNhapDAO {
    static DbConnect myConnect = new DbConnect();
    
    public static int checkLoginDAO(String username, String password){
        int i = 0;
        String sql = "SELECT 1 FROM USER WHERE username = BINARY '"+username +"' AND password = BINARY '" +password +"'";
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
}
