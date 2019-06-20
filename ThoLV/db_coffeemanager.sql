-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 20, 2019 lúc 10:49 AM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `db_coffeemanager`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `itemsareselling`
--

CREATE TABLE `itemsareselling` (
  `MaBan` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaDoUong` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoLuong` int(10) NOT NULL,
  `GhiChu` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `listtable`
--

CREATE TABLE `listtable` (
  `MaBan` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenBan` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `listtable`
--

INSERT INTO `listtable` (`MaBan`, `TenBan`) VALUES
('0', 'A1'),
('1', 'A2'),
('10', 'B5'),
('11', 'B6'),
('12', 'B7'),
('13', 'B8'),
('14', 'B9'),
('15', 'B10'),
('16', 'C1'),
('17', 'C2'),
('18', 'D1'),
('19', 'D2'),
('2', 'A3'),
('20', 'D3'),
('21', 'D4'),
('22', 'D5'),
('23', 'D6'),
('3', 'A4'),
('4', 'A5'),
('5', 'A6'),
('6', 'B1'),
('7', 'B2'),
('8', 'B3'),
('9', 'B4');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `menu`
--

CREATE TABLE `menu` (
  `MaDoUong` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenDoUong` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Gia` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `menu`
--

INSERT INTO `menu` (`MaDoUong`, `TenDoUong`, `Gia`) VALUES
('0001', 'cf đen', 10000),
('0002', 'cf sữa', 12000),
('0003', 'chanh', 15000),
('0004', 'chanh dây', 15000),
('0005', 'latte', 25000),
('0006', 'capuchino', 25000),
('0007', 'việt quốc tuyết', 22000),
('0008', 'sữa chua', 12000),
('0009', 'trà đào', 18000),
('0010', 'trà táo', 18000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `MaNhanVien` int(10) NOT NULL,
  `TenNhanVien` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `NameLogin` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PassLogin` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Role` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`MaNhanVien`, `TenNhanVien`, `NameLogin`, `PassLogin`, `Role`) VALUES
(1, 'Admin', '1', '1', 'Quản lí'),
(4, 'Lê Văn Thọ', 'vantho', '1', 'Nhân viên');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `itemsareselling`
--
ALTER TABLE `itemsareselling`
  ADD KEY `MaDoUong` (`MaDoUong`),
  ADD KEY `MaBan` (`MaBan`);

--
-- Chỉ mục cho bảng `listtable`
--
ALTER TABLE `listtable`
  ADD PRIMARY KEY (`MaBan`);

--
-- Chỉ mục cho bảng `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`MaDoUong`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`MaNhanVien`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `MaNhanVien` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `itemsareselling`
--
ALTER TABLE `itemsareselling`
  ADD CONSTRAINT `itemsareselling_ibfk_1` FOREIGN KEY (`MaBan`) REFERENCES `listtable` (`MaBan`),
  ADD CONSTRAINT `itemsareselling_ibfk_2` FOREIGN KEY (`MaDoUong`) REFERENCES `menu` (`MaDoUong`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
