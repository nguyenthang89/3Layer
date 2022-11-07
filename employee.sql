-- phpMyAdmin SQL Dump
-- version 2.11.2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 16, 2010 at 03:52 PM
-- Server version: 5.0.45
-- PHP Version: 5.2.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `employee`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_employee`
--

CREATE TABLE `tbl_employee` (
  `employee_id` int(12) NOT NULL auto_increment,
  `employee_name` varchar(45) collate utf8_unicode_ci NOT NULL,
  `phonenumber` int(12) default NULL,
  `address` varchar(45) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`employee_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `tbl_employee`
--

INSERT INTO `tbl_employee` (`employee_id`, `employee_name`, `phonenumber`, `address`) VALUES
(1, 'cdphuc', 908888888, 'hcm'),
(2, 'messi', 900000000, 'barca'),
(3, 'ronaldo', 909999999, 'real');
