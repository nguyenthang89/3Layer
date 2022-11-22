/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  itngu
 * Created: Nov 8, 2022
 */

CREATE TABLE `qltv`.`new_table` (
  `madocgia` INT NOT NULL,
  `hotendocgia` VARCHAR(255) NULL,
  `loaidocgia` VARCHAR(1) NULL,
  `diachi` VARCHAR(255) NULL,
  `email` VARCHAR(45) NULL,
  `ngaysinh` DATETIME NULL,
  `cre_dt` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`madocgia`));
