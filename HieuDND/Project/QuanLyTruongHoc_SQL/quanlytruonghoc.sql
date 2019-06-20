-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 20, 2019 lúc 11:39 AM
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
-- Cơ sở dữ liệu: `quanlytruonghoc`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `diem_hoc_sinh`
--

CREATE TABLE `diem_hoc_sinh` (
  `Id_MonHoc` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Id_HocSinh` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Diem_Mieng` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Diem15p` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Diem1Tiet` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DiemHocKi` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `diem_hoc_sinh`
--

INSERT INTO `diem_hoc_sinh` (`Id_MonHoc`, `Id_HocSinh`, `Diem_Mieng`, `Diem15p`, `Diem1Tiet`, `DiemHocKi`) VALUES
('HH', 'HS190102', '2', '2.2', '3.2', '3.5'),
('SH', 'HS190101', '3.5', '9.1', '9.0', '7.8'),
('HH', 'HS190101', '5.0', '6.5', '8.0', '7.2'),
('VL', 'HS190103', '7', '2.2', '5.8', '6.3'),
('HH', 'HS190102', '8', '2.2', '3.2', '3.5');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giaovien`
--

CREATE TABLE `giaovien` (
  `Id_GiaoVien` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `FirstName` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `LastName` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Age` int(30) NOT NULL,
  `Address` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Sex` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Birth` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NumberPhone` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Email` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Position` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `giaovien`
--

INSERT INTO `giaovien` (`Id_GiaoVien`, `FirstName`, `LastName`, `Age`, `Address`, `Sex`, `Birth`, `NumberPhone`, `Email`, `Position`) VALUES
('GV190101', 'Trần Hoàng', 'Hữu Thanh', 31, 'Hải Châu-Đà Nẵng', 'Nam', '3/7/1989', '02115455456', 'huuthanh123@gmail.com', 'Hiệu Trưởng'),
('GV190102', 'Trần', 'Thanh Long', 30, 'Hải Châu-Đà Nẵng', 'Nam', '5/8/1980', '01664558878', 'thanhlong335@gmail.com', 'Hiệu Phó'),
('GV190103', 'Nguyễn', 'Kim Thoa', 27, 'Liên Chiểu-Đà Nẵng', 'Nữ', '8/9/1992', '0133548896', 'kimthoa@gmail.com', 'Giáo Viên '),
('GV190104', 'Nguyễn', 'Thuỳ Dạ', 28, 'Liên Chiểu-Đà Nẵng', 'Nữ', '8/9/1991', '0133540223', 'thuyda@gmail.com', 'Giáo Viên ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hocsinh`
--

CREATE TABLE `hocsinh` (
  `Id_HocSinh` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `FirstName` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `LastName` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Age` int(30) NOT NULL,
  `Address` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Sex` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Birth` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NumberPhone` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Absence` int(20) NOT NULL,
  `Id_Lop` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hocsinh`
--

INSERT INTO `hocsinh` (`Id_HocSinh`, `FirstName`, `LastName`, `Age`, `Address`, `Sex`, `Birth`, `NumberPhone`, `Email`, `Absence`, `Id_Lop`) VALUES
('HS190101', 'Đặng Nguyễn', 'Đức Hiếu', 20, 'Ngũ Hành Sơn- Đà Nẵng', 'Nam', '5/5/2000', '0388933660', 'danghieu100@gmail.com', 2, 'CL1201'),
('HS190102', 'Đoàn Huỳnh', 'Ngọc Tài', 19, 'Ngũ Hành Sơn- Đà Nẵng', 'Nam', '10/8/2000', '0355699861', 'ngoctai@gmail.com', 5, 'CL1202'),
('HS190103', 'Trần Lê', 'Thái Bình', 19, 'Ngũ Hành Sơn- Đà Nẵng', 'Nam', '10/10/2000', '0315520215', 'binhtran@gmail.com', 4, 'CL1216');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hosogiaovien`
--

CREATE TABLE `hosogiaovien` (
  `Id_GiaoVien` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `FirstName` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `LastName` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Age` int(30) NOT NULL,
  `Address` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Sex` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Birth` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NumberPhone` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Email` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `University` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Experience` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hosogiaovien`
--

INSERT INTO `hosogiaovien` (`Id_GiaoVien`, `FirstName`, `LastName`, `Age`, `Address`, `Sex`, `Birth`, `NumberPhone`, `Email`, `University`, `Experience`) VALUES
('GV190101', 'Trần Hoàng', 'Hữu Thanh', 31, 'Hải Châu-Đà Nẵng', 'Nam', '3/7/1989', '02115455456', 'huuthanh123@gmail.com', 'Sư Phạm Đà Nẵng', '7 năm'),
('GV190102', 'Trần', 'Thanh Long', 29, 'Hải Châu-Đà Nẵng', 'Nam', '5/8/1980', '01664558878', 'thanhlong335@gmail.com', 'Sư Phạm Huế', '5 năm'),
('GV190103', 'Nguyễn', 'Kim Thoa', 27, 'Liên Chiểu - Đà Nẵng', 'Nữ', '8/9/1992', '0133548896', 'kimthoa@gmail.com', 'Sư Phạm Huế', '3 năm'),
('GV190104', 'Nguyễn', 'Thuỳ Dạ', 28, 'Liên Chiểu - Đà Nẵng', 'Nữ', '8/9/1991', '0133540223', 'thuyda@gmail.com', 'Sư Phạm Huế', '4 năm');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hosohocsinh`
--

CREATE TABLE `hosohocsinh` (
  `Id_HocSinh` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `FirstName` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `LastName` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Age` int(30) NOT NULL,
  `Address` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Sex` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Birth` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `PrimarySchool` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `JuniorHighSchool` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `HighSchool` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `StudyCapacity` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Conduct` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hosohocsinh`
--

INSERT INTO `hosohocsinh` (`Id_HocSinh`, `FirstName`, `LastName`, `Age`, `Address`, `Sex`, `Birth`, `PrimarySchool`, `JuniorHighSchool`, `HighSchool`, `StudyCapacity`, `Conduct`) VALUES
('HS190101', 'Đặng Nguyễn', 'Đức Hiếu', 19, 'Ngũ Hành Sơn- Đà Nẵng', 'Nam', '5/52000', 'Kim Đồng', 'Trần Hưng Đạo', 'Núi Thành', 'Giỏi', 'Tốt'),
('HS190102', 'Nguyễn Ngọc', 'Ngà', 19, 'Cẩm Lệ - Đà Nẵng', 'Nữ', '5/52000', 'Kim Đồng', 'Trần Hưng Đạo', 'Núi Thành', 'Giỏi', 'Tốt');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lop`
--

CREATE TABLE `lop` (
  `Id_Lop` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ClassName` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Id_NienKhoa` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `lop`
--

INSERT INTO `lop` (`Id_Lop`, `ClassName`, `Id_NienKhoa`) VALUES
('CL1201', '12A1', 'N219N220'),
('CL1202', '12A2', 'N219N220'),
('CL1203', '12A3', 'N219N220'),
('CL1204', '12A4', 'N219N220'),
('CL1205', '12A5', 'N219N220'),
('CL1216', '12C6', 'N219N220'),
('CL1217', '12C7', 'N219N220'),
('CL1218', '12C8', 'N219N220');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mon_hoc`
--

CREATE TABLE `mon_hoc` (
  `Id_MonHoc` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Ten_Mon` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Id_GiaoVien` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `mon_hoc`
--

INSERT INTO `mon_hoc` (`Id_MonHoc`, `Ten_Mon`, `Id_GiaoVien`) VALUES
('HH', 'Hoá Học', 'GV190102'),
('LS', 'Lịch Sử', 'GV190103'),
('SH', 'Sinh Học', 'GV190101'),
('TH', 'Toán Học', 'GV190103'),
('VH', 'Văn Học', 'GV190104'),
('VL', 'Vật Lý', 'GV190102');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nien_khoa`
--

CREATE TABLE `nien_khoa` (
  `Id_NienKhoa` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SchoolYear` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nien_khoa`
--

INSERT INTO `nien_khoa` (`Id_NienKhoa`, `SchoolYear`) VALUES
('N218N219', '2018-2019'),
('N219N220', '2019-2020');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
  `id_role` int(10) NOT NULL,
  `name_id` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `role`
--

INSERT INTO `role` (`id_role`, `name_id`) VALUES
(1, 'Giáo Viên'),
(2, 'Học Sinh');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tongket`
--

CREATE TABLE `tongket` (
  `Id_HocSinh` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `FirstName` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `LastName` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Id_Lop` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `StudyCapacity_Semester1` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Conduct_Semester1` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `StudyCapacity_Semester2` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Conduct_Semester2` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `StudyCapacity_WholeYear` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Conduct_WholeYear` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Id_NienKhoa` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tongket`
--

INSERT INTO `tongket` (`Id_HocSinh`, `FirstName`, `LastName`, `Id_Lop`, `StudyCapacity_Semester1`, `Conduct_Semester1`, `StudyCapacity_Semester2`, `Conduct_Semester2`, `StudyCapacity_WholeYear`, `Conduct_WholeYear`, `Id_NienKhoa`) VALUES
('HS190101', 'Đặng Nguyễn', 'Đức Hiếu', 'CL1201', 'Khá', 'Tốt', 'Giỏi', 'Tốt', 'Giỏi', 'Tốt', 'N219N220'),
('HS190102', 'Trần Lê ', 'Thái Bình', 'CL1202', 'Giỏi', 'Tốt', 'Khá', 'Khá', 'Khá', 'Tốt', 'N219N220');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `UserName` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Password` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_role` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`UserName`, `Password`, `id_role`) VALUES
('binh', 'binh123', 2),
('hieu', 'hieu123', 1),
('tai', 'tai123', 2);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `diem_hoc_sinh`
--
ALTER TABLE `diem_hoc_sinh`
  ADD PRIMARY KEY (`Diem_Mieng`),
  ADD KEY `Id_HocSinh` (`Id_HocSinh`);

--
-- Chỉ mục cho bảng `giaovien`
--
ALTER TABLE `giaovien`
  ADD PRIMARY KEY (`Id_GiaoVien`);

--
-- Chỉ mục cho bảng `hocsinh`
--
ALTER TABLE `hocsinh`
  ADD PRIMARY KEY (`Id_HocSinh`),
  ADD KEY `quanlyhocsinh_ibfk_1` (`Id_Lop`);

--
-- Chỉ mục cho bảng `hosogiaovien`
--
ALTER TABLE `hosogiaovien`
  ADD PRIMARY KEY (`Id_GiaoVien`);

--
-- Chỉ mục cho bảng `hosohocsinh`
--
ALTER TABLE `hosohocsinh`
  ADD PRIMARY KEY (`Id_HocSinh`);

--
-- Chỉ mục cho bảng `lop`
--
ALTER TABLE `lop`
  ADD PRIMARY KEY (`Id_Lop`);

--
-- Chỉ mục cho bảng `mon_hoc`
--
ALTER TABLE `mon_hoc`
  ADD PRIMARY KEY (`Id_MonHoc`),
  ADD KEY `Id_GiaoVien` (`Id_GiaoVien`);

--
-- Chỉ mục cho bảng `nien_khoa`
--
ALTER TABLE `nien_khoa`
  ADD PRIMARY KEY (`Id_NienKhoa`);

--
-- Chỉ mục cho bảng `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id_role`);

--
-- Chỉ mục cho bảng `tongket`
--
ALTER TABLE `tongket`
  ADD PRIMARY KEY (`Id_HocSinh`),
  ADD KEY `tongket_ibfk_2` (`Id_NienKhoa`),
  ADD KEY `tongket_ibfk_3` (`Id_Lop`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UserName`),
  ADD KEY `id_rule` (`id_role`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `diem_hoc_sinh`
--
ALTER TABLE `diem_hoc_sinh`
  ADD CONSTRAINT `diem_hoc_sinh_ibfk_1` FOREIGN KEY (`Id_HocSinh`) REFERENCES `hocsinh` (`Id_HocSinh`);

--
-- Các ràng buộc cho bảng `hocsinh`
--
ALTER TABLE `hocsinh`
  ADD CONSTRAINT `hocsinh_ibfk_1` FOREIGN KEY (`Id_Lop`) REFERENCES `lop` (`Id_Lop`);

--
-- Các ràng buộc cho bảng `hosogiaovien`
--
ALTER TABLE `hosogiaovien`
  ADD CONSTRAINT `hosogiaovien_ibfk_1` FOREIGN KEY (`Id_GiaoVien`) REFERENCES `giaovien` (`Id_GiaoVien`);

--
-- Các ràng buộc cho bảng `hosohocsinh`
--
ALTER TABLE `hosohocsinh`
  ADD CONSTRAINT `hosohocsinh_ibfk_1` FOREIGN KEY (`Id_HocSinh`) REFERENCES `hocsinh` (`Id_HocSinh`);

--
-- Các ràng buộc cho bảng `mon_hoc`
--
ALTER TABLE `mon_hoc`
  ADD CONSTRAINT `mon_hoc_ibfk_1` FOREIGN KEY (`Id_GiaoVien`) REFERENCES `giaovien` (`Id_GiaoVien`);

--
-- Các ràng buộc cho bảng `tongket`
--
ALTER TABLE `tongket`
  ADD CONSTRAINT `tongket_ibfk_1` FOREIGN KEY (`Id_HocSinh`) REFERENCES `hocsinh` (`Id_HocSinh`),
  ADD CONSTRAINT `tongket_ibfk_2` FOREIGN KEY (`Id_NienKhoa`) REFERENCES `nien_khoa` (`Id_NienKhoa`),
  ADD CONSTRAINT `tongket_ibfk_3` FOREIGN KEY (`Id_Lop`) REFERENCES `lop` (`Id_Lop`);

--
-- Các ràng buộc cho bảng `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
