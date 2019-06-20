-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 20, 2019 lúc 11:34 AM
-- Phiên bản máy phục vụ: 10.1.37-MariaDB
-- Phiên bản PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `duan`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dangnhap`
--

CREATE TABLE `dangnhap` (
  `UserId` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `dangnhap`
--

INSERT INTO `dangnhap` (`UserId`, `password`) VALUES
('admin', '123456'),
('admin2', '123456');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giangvien`
--

CREATE TABLE `giangvien` (
  `magv` varchar(20) NOT NULL,
  `tengv` varchar(50) DEFAULT NULL,
  `gioitinh` varchar(5) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phanloaigv` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `giangvien`
--

INSERT INTO `giangvien` (`magv`, `tengv`, `gioitinh`, `phone`, `email`, `phanloaigv`) VALUES
('V070307', 'Thang', 'Nam ', 372333943, 'thang@gmail.com', 'loai 1'),
('V070308', 'Huynhw22', 'Nam', 2, 'huynh@gmail.com', 'loai 2 ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ketqua`
--

CREATE TABLE `ketqua` (
  `masv` varchar(20) DEFAULT NULL,
  `hoten` varchar(50) DEFAULT NULL,
  `diemtb` varchar(3) DEFAULT NULL,
  `diemthilan1` varchar(3) DEFAULT NULL,
  `diemthilan2` varchar(3) DEFAULT NULL,
  `diemtongket` varchar(3) DEFAULT NULL,
  `hanhkiem` varchar(10) DEFAULT NULL,
  `mamon` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `ketqua`
--

INSERT INTO `ketqua` (`masv`, `hoten`, `diemtb`, `diemthilan1`, `diemthilan2`, `diemtongket`, `hanhkiem`, `mamon`) VALUES
('180003254', 'ng?c tài ', '7.6', '8.9', '8.9', '7', 'kha', '00102133');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khoa`
--

CREATE TABLE `khoa` (
  `makhoa` varchar(20) NOT NULL,
  `tenkhoa` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `khoa`
--

INSERT INTO `khoa` (`makhoa`, `tenkhoa`) VALUES
('7140114', 'Lich su'),
('7140115', 'Dia ly');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lop`
--

CREATE TABLE `lop` (
  `makhoa` varchar(20) DEFAULT NULL,
  `malop` varchar(20) NOT NULL,
  `tenlop` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `lop`
--

INSERT INTO `lop` (`makhoa`, `malop`, `tenlop`) VALUES
('7140114', '18', '18if1'),
('7140115', '19', '18if2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mon`
--

CREATE TABLE `mon` (
  `mamon` varchar(20) NOT NULL,
  `tenmon` varchar(50) DEFAULT NULL,
  `magv` varchar(20) DEFAULT NULL,
  `hocki` varchar(3) DEFAULT NULL,
  `makhoa` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `mon`
--

INSERT INTO `mon` (`mamon`, `tenmon`, `magv`, `hocki`, `makhoa`) VALUES
('001021', 'Mac LeNin', 'V070307', '2', '7140114'),
('0010213', NULL, 'V070307', '2', '7140114'),
('00102133', 'Mác Lê Nin', 'V070307', '2', '7140114'),
('001021334', 'V?n Hóa Vi?t Nam', 'V070307', '2', '7140114'),
('00102134', NULL, 'V070307', '2', '7140114'),
('001025', 'Tu tuong HCM', 'V070308', '2', '7140114'),
('0010254', NULL, 'V070308', '2', '7140114');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sinhvien`
--

CREATE TABLE `sinhvien` (
  `masv` varchar(20) NOT NULL,
  `hoten` varchar(50) DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `gioitinh` varchar(5) DEFAULT NULL,
  `diachi` varchar(50) DEFAULT NULL,
  `malop` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `sinhvien`
--

INSERT INTO `sinhvien` (`masv`, `hoten`, `ngaysinh`, `gioitinh`, `diachi`, `malop`) VALUES
('1', 'Ngoc Tai', '2019-06-05', 'Nam', 'Nam phuoc duy xuyen quang nam', '18'),
('180003254', 'Dang Nguyen Duc Hieu', '2019-06-26', 'Nam', 'Nui thanh quang nam', '19'),
('180003256', 'Ngoc Taiy', '2019-06-05', 'Nam', 'Nam phuoc duy xuyen quang nam', '18'),
('1800032564', 'Ngoc Taiy', '2019-06-05', 'Nam', 'Nam phuoc duy xuyen quang nam', '18'),
('18000325644', 'Ngoc Taiy', '2019-06-05', 'Nam', 'Nam phuoc duy xuyen quang nam', '18');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `dangnhap`
--
ALTER TABLE `dangnhap`
  ADD PRIMARY KEY (`UserId`);

--
-- Chỉ mục cho bảng `giangvien`
--
ALTER TABLE `giangvien`
  ADD PRIMARY KEY (`magv`);

--
-- Chỉ mục cho bảng `ketqua`
--
ALTER TABLE `ketqua`
  ADD KEY `masv` (`masv`),
  ADD KEY `mamon` (`mamon`);

--
-- Chỉ mục cho bảng `khoa`
--
ALTER TABLE `khoa`
  ADD PRIMARY KEY (`makhoa`);

--
-- Chỉ mục cho bảng `lop`
--
ALTER TABLE `lop`
  ADD PRIMARY KEY (`malop`),
  ADD KEY `makhoa` (`makhoa`);

--
-- Chỉ mục cho bảng `mon`
--
ALTER TABLE `mon`
  ADD PRIMARY KEY (`mamon`),
  ADD KEY `magv` (`magv`);

--
-- Chỉ mục cho bảng `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD PRIMARY KEY (`masv`),
  ADD KEY `malop` (`malop`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `ketqua`
--
ALTER TABLE `ketqua`
  ADD CONSTRAINT `ketqua_ibfk_2` FOREIGN KEY (`masv`) REFERENCES `sinhvien` (`masv`),
  ADD CONSTRAINT `ketqua_ibfk_3` FOREIGN KEY (`mamon`) REFERENCES `mon` (`mamon`);

--
-- Các ràng buộc cho bảng `lop`
--
ALTER TABLE `lop`
  ADD CONSTRAINT `lop_ibfk_1` FOREIGN KEY (`makhoa`) REFERENCES `khoa` (`makhoa`);

--
-- Các ràng buộc cho bảng `mon`
--
ALTER TABLE `mon`
  ADD CONSTRAINT `mon_ibfk_1` FOREIGN KEY (`magv`) REFERENCES `giangvien` (`magv`);

--
-- Các ràng buộc cho bảng `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD CONSTRAINT `sinhvien_ibfk_1` FOREIGN KEY (`malop`) REFERENCES `lop` (`malop`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
