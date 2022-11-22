/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

/**
 *
 * @author itngu
 */
public class DocGiaDTO {
    private String cCCD;
    private String tenDocGia;
    private String loaiDocGia;
    private String diaChi;
    private String email;
    private Date ngaySinh;
    private Date ngayLapThe;
    private Date ngayHetHan;
    
    public String getcCCD() {
        return cCCD;
    }

    public void setcCCD(String cCCD) {
        this.cCCD = cCCD;
    }
    
    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public String getLoaiDocGia() {
        return loaiDocGia;
    }

    public void setLoaiDocGia(String loaiDocGia) {
        this.loaiDocGia = loaiDocGia;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayLapThe() {
        return ngayLapThe;
    }

    public void setNgayLapThe(Date ngayLapThe) {
        this.ngayLapThe = ngayLapThe;
    }    

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

}
