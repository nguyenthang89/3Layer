/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import dao.DangNhapDAO;

/**
 *
 * @author itngu
 */
public class DangNhapBUS {
    public static int checkLoginBUS(String username, String password) {
        return DangNhapDAO.checkLoginDAO(username, password);        
    }
}
