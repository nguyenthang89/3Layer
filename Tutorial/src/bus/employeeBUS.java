package bus;

import dao.employeeDAO;
import dto.employeeDTO;
import java.util.ArrayList;

public class employeeBUS {

    public static ArrayList<employeeDTO> employeeAll(){
        return employeeDAO.employeeAll();
    }
    
    public static int updateEmployee (int id_update, employeeDTO emp) {
        return employeeDAO.updateEmployee(id_update, emp);        
    }
    
    public static int deleteEmployee (int id_delete) {
        return employeeDAO.deleteEmployee(id_delete);        
    }

    public static int addEmployee(employeeDTO emp) {
        return employeeDAO.addEmployee(emp); 
        
    }
}
