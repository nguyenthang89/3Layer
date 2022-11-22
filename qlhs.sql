
CREATE TABLE LopHoc (
    maLopHoc INT(2) NOT NULL PRIMARY KEY,
    tenLopHoc VARCHAR(2) NOT NULL,
    LEVEL TINYINT(1) DEFAULT 1 NOT NULL
);
 
CREATE TABLE HocSinh(
    maHocSinh INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    hoTenHocSinh VARCHAR(50) NOT NULL ,
    email VARCHAR (50) NOT NULL ,
    ngaySinh timestamp,
    FOREIGN KEY (groupid) REFERENCES Groups1(groupid)
);
