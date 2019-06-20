-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 20, 2019 lúc 11:52 AM
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
-- Cơ sở dữ liệu: `sqlquanlisinhvien`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bangdiem`
--

CREATE TABLE `bangdiem` (
  `mahocsinh` int(30) NOT NULL,
  `malop` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mamon` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mahocki` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `diem_mieng` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `diem_15p` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `diem_45p` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `diem_thi` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ghichu` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `bangdiem`
--

INSERT INTO `bangdiem` (`mahocsinh`, `malop`, `mamon`, `mahocki`, `diem_mieng`, `diem_15p`, `diem_45p`, `diem_thi`, `ghichu`) VALUES
(1, 'lp190', 'Anh11', 'hk1', '5', '6', '7', '8', 'binhbinh'),
(3, 'lp190', 'Toán10', 'hk1', '8', '5', '9', '4', 'saithongtin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giaovien`
--

CREATE TABLE `giaovien` (
  `magiaovien` int(20) NOT NULL,
  `hoten` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gioitinh` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `malop` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `namsinh` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mamon` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `giaovien`
--

INSERT INTO `giaovien` (`magiaovien`, `hoten`, `gioitinh`, `malop`, `namsinh`, `mamon`) VALUES
(1, 'trần lê thái bình', 'nam', 'lp123', '2000', 'Toán10'),
(2, 'Trần Công Vân', 'nam', 'lp190', '1986', 'Anh11'),
(4, '1', 'Nam', 'lp123', '123', ''),
(5, 'tho', 'Nam', 'lp123', '1231', ''),
(7, 'tho', 'Nam', 'lp123', '1231', ''),
(8, 'tho', 'Nam', 'lp123', '1231', ''),
(9, 'tho', 'Nam', 'lp123', '1231', 'Toán10'),
(12, 'tho', 'Nữ', 'lp123', '1231', 'Toán10'),
(13, 'tho', 'Nữ', 'lp123', '444', 'Toán10');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hocki`
--

CREATE TABLE `hocki` (
  `mahocki` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tenhocki` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hocki`
--

INSERT INTO `hocki` (`mahocki`, `tenhocki`) VALUES
('hk1', 'Học Kì 1'),
('hk2', 'Học KÌ 2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hocsinh`
--

CREATE TABLE `hocsinh` (
  `mahocsinh` int(11) NOT NULL,
  `hoten` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gioitinh` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `diachi` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `malop` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `namsinh` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `namhoc` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hocsinh`
--

INSERT INTO `hocsinh` (`mahocsinh`, `hoten`, `gioitinh`, `diachi`, `email`, `malop`, `namsinh`, `namhoc`) VALUES
(1, 'trần lê thái bình', 'nam', 'bình hải', 'binh123@gamil.com', 'lp123', '2000', 2019),
(2, 'Trần Công Vân', 'nam', 'Cẩm lệ', 'binh456@gamil.com', 'lp123', '1986', 2017),
(3, 'trần lê thái bình', '', 'binh123@gamil.com', 'bình hải', 'lp123', '2000', 2019),
(4, 'trần lê thái bình', 'Nam', 'bình hải', 'binh123@gamil.com', 'lp123', '2000', 2019),
(5, 'trần lê thái bình', '', 'binh123@gamil.com', 'bình hải', 'lp123', '2000', 2019),
(7, 'trần lê thái bình', '', 'bình hải', 'binh123@gamil.com', 'lp123', '2000', 2019),
(9, 'trần lê thái bình', 'Nữ', 'binh123@gamil.com', 'bình hải', 'lp123', '2000', 2019),
(10, 'trần lê thái bình', '', 'bình hải', 'binh123@gamil.com', 'lp123', '2000', 2019),
(11, 'trần lê thái bình', '', 'binh123@gamil.com', 'bình hải', 'lp123', '2000', 2019),
(12, 'trần lê thái bình', '', 'binh123@gamil.com', 'bình hải', 'lp123', '2000', 2019),
(13, 'trần lê thái bình', '', 'binh123@gamil.com', 'trfgtrgtr', 'lp123', '2000', 2019),
(14, 'trần lê thái bình', '', 'binh123@gamil.com', 'bình hải', 'lp123', '2000', 2019),
(15, 'trần lê thái bình', '', 'binh123@gamil.com', 'bình hải', 'lp123', '2000', 2019),
(16, 'trần lê thái bình', '', 'trfgtrgtr', 'binh123@gamil.com', 'lp123', '2000', 2019);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hosohocsinh`
--

CREATE TABLE `hosohocsinh` (
  `malop` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mahocsinh` int(11) NOT NULL,
  `hoten` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `diachi` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dantoc` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `namsinh` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gioitinh` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hotencha` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hotenme` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ghichu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hosohocsinh`
--

INSERT INTO `hosohocsinh` (`malop`, `mahocsinh`, `hoten`, `diachi`, `dantoc`, `namsinh`, `gioitinh`, `email`, `hotencha`, `hotenme`, `ghichu`) VALUES
('lp123', 1, 'trần lê thái bình', 'binh  hải', 'kinh', '2000', 'nam', 'binh123@gamil.com', 'minhnjbs', 'sadffvf', 0),
('lp190', 1, 'Trần Công Vân', 'Cẩm lệ', 'kinh', '1986', 'nam', 'sfdsf455', 'dsffsgvg', 'ngfdv', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ketquahoctap`
--

CREATE TABLE `ketquahoctap` (
  `mahocsinh` int(11) NOT NULL,
  `malop` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hoten` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hocluc` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hanhkiem` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `diemtrungbinh` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `xeploai` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tennienkhoa` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ketquahoctap`
--

INSERT INTO `ketquahoctap` (`mahocsinh`, `malop`, `hoten`, `hocluc`, `hanhkiem`, `diemtrungbinh`, `xeploai`, `tennienkhoa`) VALUES
(2, 'lp123', 'trần lê thái bình', 'khá', 'tốt', '9', '12', '2017-2021'),
(1, 'lp123', 'Trần Công Vân', 'khá', 'tốt', '8', '11', '2019-2020');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khoa`
--

CREATE TABLE `khoa` (
  `makhoa` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tenkhoa` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khoa`
--

INSERT INTO `khoa` (`makhoa`, `tenkhoa`) VALUES
('2018cntt', 'cộng nghệ thông tin'),
('2019cnot', 'lập trình viên');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khoi`
--

CREATE TABLE `khoi` (
  `makhoi` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tenkhoi` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khoi`
--

INSERT INTO `khoi` (`makhoi`, `tenkhoi`) VALUES
('mk1', 'Khối 10'),
('mk2', 'khối 11'),
('mk3', 'Khối 12');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lophoc`
--

CREATE TABLE `lophoc` (
  `malop` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tenlop` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gvchu_nghiem` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `makhoa` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `makhoi` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tennienkhoa` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `lophoc`
--

INSERT INTO `lophoc` (`malop`, `tenlop`, `gvchu_nghiem`, `makhoa`, `makhoi`, `tennienkhoa`) VALUES
('lp123', '18i3', 'thái bình', '2019cnot', 'mk1', '2019-2022'),
('lp190', '18if1', 'Công Vân', '2018cntt', 'mk2', '2017-2021');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `monhoc`
--

CREATE TABLE `monhoc` (
  `mamon` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tenmonhoc` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `magiaovien` int(30) NOT NULL,
  `sotietday` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `monhoc`
--

INSERT INTO `monhoc` (`mamon`, `tenmonhoc`, `magiaovien`, `sotietday`) VALUES
('Anh11', 'GDCD', 2, '10'),
('Toán10', 'Văn', 2, '20');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nienkhoa`
--

CREATE TABLE `nienkhoa` (
  `tenienkhoa` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `manienkhoa` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nienkhoa`
--

INSERT INTO `nienkhoa` (`tenienkhoa`, `manienkhoa`) VALUES
('2017-2021', 'nk17'),
('2018-2020', 'nk18'),
('2019-2020', 'nk20'),
('2019-2022', 'nk18');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `roles`
--

CREATE TABLE `roles` (
  `roleid` int(11) NOT NULL,
  `roleName` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `roles`
--

INSERT INTO `roles` (`roleid`, `roleName`) VALUES
(1, 'roles_user'),
(2, 'roles_admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `userid` int(11) NOT NULL,
  `username` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`userid`, `username`, `password`) VALUES
(1, 'admin', '123456'),
(2, 'binh', '111111');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_roles`
--

CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  `isDelete` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user_roles`
--

INSERT INTO `user_roles` (`id`, `userid`, `roleid`, `isDelete`) VALUES
(1, 1, 1, 0),
(2, 2, 2, 1),
(3, 1, 2, 1),
(4, 2, 2, 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bangdiem`
--
ALTER TABLE `bangdiem`
  ADD KEY `mahocsinh` (`mahocsinh`),
  ADD KEY `malop` (`malop`),
  ADD KEY `mamon` (`mamon`),
  ADD KEY `mahocki` (`mahocki`);

--
-- Chỉ mục cho bảng `giaovien`
--
ALTER TABLE `giaovien`
  ADD PRIMARY KEY (`magiaovien`),
  ADD KEY `malop` (`malop`),
  ADD KEY `mamon` (`mamon`);

--
-- Chỉ mục cho bảng `hocki`
--
ALTER TABLE `hocki`
  ADD PRIMARY KEY (`mahocki`);

--
-- Chỉ mục cho bảng `hocsinh`
--
ALTER TABLE `hocsinh`
  ADD PRIMARY KEY (`mahocsinh`),
  ADD KEY `malop` (`malop`);

--
-- Chỉ mục cho bảng `hosohocsinh`
--
ALTER TABLE `hosohocsinh`
  ADD KEY `mahocsinh` (`mahocsinh`),
  ADD KEY `malop` (`malop`);

--
-- Chỉ mục cho bảng `ketquahoctap`
--
ALTER TABLE `ketquahoctap`
  ADD KEY `mahocsinh` (`mahocsinh`),
  ADD KEY `malop` (`malop`),
  ADD KEY `tennienkhoa` (`tennienkhoa`);

--
-- Chỉ mục cho bảng `khoa`
--
ALTER TABLE `khoa`
  ADD PRIMARY KEY (`makhoa`);

--
-- Chỉ mục cho bảng `khoi`
--
ALTER TABLE `khoi`
  ADD PRIMARY KEY (`makhoi`);

--
-- Chỉ mục cho bảng `lophoc`
--
ALTER TABLE `lophoc`
  ADD PRIMARY KEY (`malop`,`tenlop`),
  ADD KEY `makhoa` (`makhoa`),
  ADD KEY `makhoi` (`makhoi`),
  ADD KEY `tennienkhoa` (`tennienkhoa`);

--
-- Chỉ mục cho bảng `monhoc`
--
ALTER TABLE `monhoc`
  ADD PRIMARY KEY (`mamon`),
  ADD KEY `magiaovien` (`magiaovien`);

--
-- Chỉ mục cho bảng `nienkhoa`
--
ALTER TABLE `nienkhoa`
  ADD PRIMARY KEY (`tenienkhoa`);

--
-- Chỉ mục cho bảng `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`roleid`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userid`);

--
-- Chỉ mục cho bảng `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `roleid` (`roleid`),
  ADD KEY `userid` (`userid`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `giaovien`
--
ALTER TABLE `giaovien`
  MODIFY `magiaovien` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `hocsinh`
--
ALTER TABLE `hocsinh`
  MODIFY `mahocsinh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `roles`
--
ALTER TABLE `roles`
  MODIFY `roleid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `user_roles`
--
ALTER TABLE `user_roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `bangdiem`
--
ALTER TABLE `bangdiem`
  ADD CONSTRAINT `bangdiem_ibfk_1` FOREIGN KEY (`mahocsinh`) REFERENCES `hocsinh` (`mahocsinh`),
  ADD CONSTRAINT `bangdiem_ibfk_2` FOREIGN KEY (`malop`) REFERENCES `lophoc` (`malop`),
  ADD CONSTRAINT `bangdiem_ibfk_3` FOREIGN KEY (`mamon`) REFERENCES `monhoc` (`mamon`),
  ADD CONSTRAINT `bangdiem_ibfk_4` FOREIGN KEY (`mahocki`) REFERENCES `hocki` (`mahocki`);

--
-- Các ràng buộc cho bảng `giaovien`
--
ALTER TABLE `giaovien`
  ADD CONSTRAINT `giaovien_ibfk_1` FOREIGN KEY (`malop`) REFERENCES `lophoc` (`malop`);

--
-- Các ràng buộc cho bảng `hocsinh`
--
ALTER TABLE `hocsinh`
  ADD CONSTRAINT `hocsinh_ibfk_1` FOREIGN KEY (`malop`) REFERENCES `lophoc` (`malop`);

--
-- Các ràng buộc cho bảng `hosohocsinh`
--
ALTER TABLE `hosohocsinh`
  ADD CONSTRAINT `hosohocsinh_ibfk_1` FOREIGN KEY (`mahocsinh`) REFERENCES `hocsinh` (`mahocsinh`),
  ADD CONSTRAINT `hosohocsinh_ibfk_2` FOREIGN KEY (`malop`) REFERENCES `lophoc` (`malop`);

--
-- Các ràng buộc cho bảng `ketquahoctap`
--
ALTER TABLE `ketquahoctap`
  ADD CONSTRAINT `ketquahoctap_ibfk_1` FOREIGN KEY (`mahocsinh`) REFERENCES `hocsinh` (`mahocsinh`),
  ADD CONSTRAINT `ketquahoctap_ibfk_2` FOREIGN KEY (`malop`) REFERENCES `lophoc` (`malop`),
  ADD CONSTRAINT `ketquahoctap_ibfk_3` FOREIGN KEY (`tennienkhoa`) REFERENCES `nienkhoa` (`tenienkhoa`);

--
-- Các ràng buộc cho bảng `lophoc`
--
ALTER TABLE `lophoc`
  ADD CONSTRAINT `lophoc_ibfk_1` FOREIGN KEY (`makhoa`) REFERENCES `khoa` (`makhoa`),
  ADD CONSTRAINT `lophoc_ibfk_2` FOREIGN KEY (`makhoi`) REFERENCES `khoi` (`makhoi`),
  ADD CONSTRAINT `lophoc_ibfk_3` FOREIGN KEY (`tennienkhoa`) REFERENCES `nienkhoa` (`tenienkhoa`);

--
-- Các ràng buộc cho bảng `monhoc`
--
ALTER TABLE `monhoc`
  ADD CONSTRAINT `monhoc_ibfk_1` FOREIGN KEY (`magiaovien`) REFERENCES `giaovien` (`magiaovien`);

--
-- Các ràng buộc cho bảng `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `user_roles_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `roles` (`roleid`),
  ADD CONSTRAINT `user_roles_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
