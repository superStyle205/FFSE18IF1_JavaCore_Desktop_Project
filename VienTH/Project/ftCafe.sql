-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.13 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for cafe
CREATE DATABASE IF NOT EXISTS `cafe` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `cafe`;

-- Dumping structure for table cafe.config
CREATE TABLE IF NOT EXISTS `config` (
  `configId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`configId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table cafe.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `customerGroup` int(11) DEFAULT NULL,
  `firstName` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `lastName` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `taxCode` varchar(12) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `thuDK` float DEFAULT NULL,
  `thuCK` float DEFAULT NULL,
  PRIMARY KEY (`customerId`),
  KEY `customerGroupFk_idx` (`customerGroup`),
  CONSTRAINT `customerGroupFk` FOREIGN KEY (`customerGroup`) REFERENCES `customergroup` (`customergroupid`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table cafe.customergroup
CREATE TABLE IF NOT EXISTS `customergroup` (
  `customerGroupId` int(11) NOT NULL AUTO_INCREMENT,
  `upperCustomerGroupId` int(11) DEFAULT NULL,
  `customerGroupName` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `groupType` int(1) DEFAULT NULL COMMENT '0 - Customer\n1 - Suppier',
  PRIMARY KEY (`customerGroupId`),
  KEY `upperCustomerGroupIdFk` (`upperCustomerGroupId`),
  CONSTRAINT `upperCustomerGrIDFk` FOREIGN KEY (`upperCustomerGroupId`) REFERENCES `customergroup` (`customergroupid`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table cafe.department
CREATE TABLE IF NOT EXISTS `department` (
  `deptId` int(11) NOT NULL AUTO_INCREMENT,
  `upperDeptId` int(11) DEFAULT NULL,
  `deptCode` varchar(7) NOT NULL,
  `deptName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`deptId`),
  UNIQUE KEY `deptId_UNIQUE` (`deptId`),
  UNIQUE KEY `deptCode_UNIQUE` (`deptCode`),
  KEY `upperDeptIdFk_idx` (`upperDeptId`),
  CONSTRAINT `upperDeptIdFk` FOREIGN KEY (`upperDeptId`) REFERENCES `department` (`deptid`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.
-- Dumping structure for table cafe.document
CREATE TABLE IF NOT EXISTS `document` (
  `docId` int(11) NOT NULL AUTO_INCREMENT,
  `docCode` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `docType` tinyint(4) DEFAULT NULL COMMENT '0 - Nhap\n1 - Xuat\n2 - Ban le\n3 - Thu\n4 - Chi\n5 - Don dat hang',
  `docDate` datetime DEFAULT NULL,
  `tableId` int(11) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `customerQty` int(11) DEFAULT NULL,
  `note` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cashierId` int(11) DEFAULT NULL,
  `waiterId` int(11) DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `vat` float DEFAULT NULL,
  `serviceCharge` float DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `debit` float DEFAULT NULL,
  `credit` float DEFAULT NULL,
  `reservedDate` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '0 - Don hang/Bill chua in\n1 - Da thanh toan',
  PRIMARY KEY (`docId`),
  UNIQUE KEY `docCode_UNIQUE` (`docCode`),
  KEY `tableIdFk_idx` (`tableId`),
  KEY `customerIdFk_idx` (`customerId`),
  KEY `cashierIdFk_idx` (`cashierId`),
  KEY `waiterIdFk_idx` (`waiterId`),
  CONSTRAINT `cashierIdFk` FOREIGN KEY (`cashierId`) REFERENCES `staff` (`staffid`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `customerIdFk` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerid`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `tableIdFk` FOREIGN KEY (`tableId`) REFERENCES `table` (`tableid`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `waiterIdFk` FOREIGN KEY (`waiterId`) REFERENCES `staff` (`staffid`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table cafe.pricelist
CREATE TABLE IF NOT EXISTS `pricelist` (
  `priceListId` int(11) NOT NULL AUTO_INCREMENT,
  `priceListCode` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL,
  `priceListName` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `isDefaultPl` bit(1) DEFAULT b'0',
  PRIMARY KEY (`priceListId`),
  UNIQUE KEY `priceListCode_UNIQUE` (`priceListCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table cafe.sector
CREATE TABLE IF NOT EXISTS `sector` (
  `sectorId` int(11) NOT NULL AUTO_INCREMENT,
  `sectorCode` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sectorName` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`sectorId`),
  UNIQUE KEY `sectorCode_UNIQUE` (`sectorCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table cafe.staff
CREATE TABLE IF NOT EXISTS `staff` (
  `staffId` int(11) NOT NULL AUTO_INCREMENT,
  `staffCode` varchar(7) NOT NULL,
  `firstName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lastName` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `taxCode` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `deptId` int(11) DEFAULT NULL,
  PRIMARY KEY (`staffId`),
  UNIQUE KEY `maNV_UNIQUE` (`staffId`),
  UNIQUE KEY `taxCode_UNIQUE` (`taxCode`),
  KEY `deptId_idx` (`deptId`),
  CONSTRAINT `deptId` FOREIGN KEY (`deptId`) REFERENCES `department` (`deptid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.
-- Dumping structure for table cafe.stock
CREATE TABLE IF NOT EXISTS `stock` (
  `stockId` int(11) NOT NULL AUTO_INCREMENT,
  `stockCode` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `stockGroupId` int(11) DEFAULT NULL,
  `stockName` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `unitId` int(11) DEFAULT NULL,
  `openingStock` float DEFAULT NULL,
  `closingStock` float DEFAULT NULL,
  `isMenu` bit(1) DEFAULT NULL,
  PRIMARY KEY (`stockId`),
  UNIQUE KEY `stockCode_UNIQUE` (`stockCode`),
  KEY `stockGroupIdFk_idx` (`stockGroupId`),
  KEY `unitIdFk_idx` (`unitId`),
  CONSTRAINT `stockGroupIdFk` FOREIGN KEY (`stockGroupId`) REFERENCES `stockgroup` (`stockgroupid`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `unitIdFk` FOREIGN KEY (`unitId`) REFERENCES `stockunit` (`stockunitid`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table cafe.stockgroup
CREATE TABLE IF NOT EXISTS `stockgroup` (
  `stockGroupId` int(11) NOT NULL AUTO_INCREMENT,
  `upperStockGroupId` int(11) DEFAULT NULL,
  `stockGroupCode` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL,
  `stockGroupName` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `stockGroupType` tinyint(1) DEFAULT '0' COMMENT '0 - Hang hoa\n1 - Nguyen lieu\n2 - San pham che bien\n3 - Dich vu tinh theo gio',
  PRIMARY KEY (`stockGroupId`),
  UNIQUE KEY `stockGroupCode_UNIQUE` (`stockGroupCode`),
  KEY `upperStockGrId_idx` (`upperStockGroupId`),
  CONSTRAINT `upperStockGrId` FOREIGN KEY (`upperStockGroupId`) REFERENCES `stockgroup` (`stockgroupid`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table cafe.stockprice
CREATE TABLE IF NOT EXISTS `stockprice` (
  `stockPriceid` int(11) NOT NULL AUTO_INCREMENT,
  `stockId` int(11) DEFAULT NULL,
  `priceListId` int(11) DEFAULT NULL,
  `price` float DEFAULT '0',
  PRIMARY KEY (`stockPriceid`),
  KEY `stockIdFk_idx` (`stockId`),
  KEY `priceListId_idx` (`priceListId`),
  CONSTRAINT `priceListId` FOREIGN KEY (`priceListId`) REFERENCES `pricelist` (`pricelistid`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `stockIdFk` FOREIGN KEY (`stockId`) REFERENCES `stock` (`stockid`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table cafe.stockunit
CREATE TABLE IF NOT EXISTS `stockunit` (
  `stockUnitid` int(11) NOT NULL AUTO_INCREMENT,
  `stockUnitCode` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL,
  `isDefaultUnit` bit(1) DEFAULT NULL,
  PRIMARY KEY (`stockUnitid`),
  UNIQUE KEY `stockUnitCode_UNIQUE` (`stockUnitCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table cafe.table
CREATE TABLE IF NOT EXISTS `table` (
  `tableId` int(11) NOT NULL AUTO_INCREMENT,
  `tableCode` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL,
  `priceListId` int(11) DEFAULT NULL,
  `sectorId` int(11) DEFAULT NULL,
  PRIMARY KEY (`tableId`),
  UNIQUE KEY `tableCode_UNIQUE` (`tableCode`),
  KEY `sectorIdFk_idx` (`sectorId`),
  KEY `priceListIdFk_idx` (`priceListId`),
  CONSTRAINT `priceListIdFk` FOREIGN KEY (`priceListId`) REFERENCES `pricelist` (`pricelistid`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `sectorIdFk` FOREIGN KEY (`sectorId`) REFERENCES `sector` (`sectorid`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table cafe.user
CREATE TABLE IF NOT EXISTS `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `staffId` int(11) DEFAULT NULL,
  `userName` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role` int(1) DEFAULT NULL COMMENT '1 - admin\n2 - accountant\n3 - cashier',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userName_UNIQUE` (`userName`),
  UNIQUE KEY `staffId_UNIQUE` (`staffId`),
  KEY `staffId_idx` (`staffId`),
  CONSTRAINT `staffId` FOREIGN KEY (`staffId`) REFERENCES `staff` (`staffid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
