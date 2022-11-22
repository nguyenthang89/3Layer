package util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnect {

    Connection conn = null;   

    public void open(){
       try{
        conn =
       DriverManager.getConnection("jdbc:mysql://@localhost/qltv?" +
                                   "user=root&password=root");
       } catch(SQLException ex){
           System.err.println(ex.getMessage());
       }
    }
   
    public void close(){
       try {
           if(conn!=null)
               conn.close();
       } catch (SQLException ex) {
           System.err.println(ex.getMessage());
       }
    }
   
    // Thực hiện câu lệnh [SELECT]
    public ResultSet excuteQuery(String sql){
       ResultSet rs = null;
       try {
           Statement stm = (Statement) conn.createStatement();
           rs = stm.executeQuery(sql);
       } catch (SQLException ex) {
           System.err.println(ex.getMessage());
       }
       return rs;
    }
   
    // Thực hiện câu lệnh [UPDATE, DELETE]
    public int excuteUpdate(String sql){
       int rs = 0;
       try {
           Statement stm = (Statement) conn.createStatement();
           rs += stm.executeUpdate(sql);
       } catch (SQLException ex) {
           System.err.println(ex.getMessage());
       }
       return rs;
   }

}
