package dao;

import dto.employeeDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.DbConnect;

public class employeeDAO {
    
    static DbConnect my = new DbConnect();

    public static ArrayList<employeeDTO> employeeAll(){
        ArrayList<employeeDTO> arr = new ArrayList<employeeDTO>();
        String sql = "select * from tbl_employee";
        try {
            my.open();
            ResultSet rs = my.excuteQuery(sql);
            while(rs.next()){
                employeeDTO em = new employeeDTO();
                em.setEmployeeId(rs.getInt("employee_id"));
                em.setEmployeeName(rs.getString("employee_name"));
                em.setPhoneNumber(rs.getInt("phonenumber"));
                em.setAddress(rs.getString("address"));
                arr.add(em);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally{
            my.close();
        }
        return arr;
    }
    
    public static int updateEmployee (int id_update, employeeDTO em) {        
        int rs = 0;
        String str = "UPDATE tbl_employee SET employee_id = " + em.getEmployeeId() 
            + ", employee_name = " + "'" +em.getEmployeeName() + "'"
            + ", phonenumber = " + "'" + em.getPhoneNumber() + "'"
            + ", address = " + "'" + em.getAddress() + "'"
            + " WHERE employee_id = " + id_update ;       
        try {            
            my.open();
            rs += my.excuteUpdate(str);

        } catch (Exception e) {            
            System.err.println(e.getMessage());
        } finally{
            my.close();
        }       
        return rs;
   }
    
    
   public static int deleteEmployee (int id_delete) {        
        int rs = 0;
        String str = "DELETE FROM tbl_employee  WHERE employee_id = " + id_delete ;       
        try {            
            my.open();
            rs += my.excuteUpdate(str);

        } catch (Exception e) {            
            System.err.println(e.getMessage());
        } finally{
            my.close();
        }       
        return rs;
   }

    public static int addEmployee(employeeDTO emp) {
        int rs = 0;
        String str = "INSERT INTO tbl_employee (employee_id,  employee_name, phonenumber, address) VALUES (" + emp.getEmployeeId() 
            + ", " + "'" + emp.getEmployeeName() + "'"
            + ", " + "'" + emp.getPhoneNumber() + "'"
            + ", " + "'" + emp.getAddress() + "')" ;
        
        System.out.println(str);
        try {            
            my.open();
            rs += my.excuteUpdate(str);

        } catch (Exception e) {            
            System.err.println(e.getMessage());
        } finally{
            my.close();
        }       
        return rs;
    }
}
