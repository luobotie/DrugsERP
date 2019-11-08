/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.17 : Database - drugserp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
USE `drugserp`;

/*Table structure for table `department` */

CREATE TABLE `department` (
  `depId` int(11) NOT NULL AUTO_INCREMENT,
  `depName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `describes` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `visibles` int(11) DEFAULT NULL,
  PRIMARY KEY (`depId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `department` */

insert  into `department`(`depId`,`depName`,`describes`,`visibles`) values (1,'总经理','部门中的老大',1),(2,'仓库管理','仓库的进销存管理',1);

/*Table structure for table `employee` */

CREATE TABLE `employee` (
  `employeeId` int(11) NOT NULL AUTO_INCREMENT,
  `employeeName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `realName` varchar(100) NOT NULL,
  `employeePwd` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `employeeAge` int(11) NOT NULL,
  `employeeSex` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `employeeTel` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `idCard` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `headUrl` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `addr` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `studyUndergo` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `visibles` int(11) DEFAULT NULL,
  `describes` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `depId` int(11) DEFAULT NULL,
  `joinTime` date DEFAULT NULL,
  PRIMARY KEY (`employeeId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

/*Data for the table `employee` */

insert  into `employee`(`employeeId`,`employeeName`,`realName`,`employeePwd`,`employeeAge`,`employeeSex`,`employeeTel`,`idCard`,`headUrl`,`addr`,`studyUndergo`,`visibles`,`describes`,`roleId`,`depId`,`joinTime`) values (1,'admin','罗波','e10adc3949ba59abbe56e057f20f883e',18,NULL,'13823459876','430626199111176736','../downloadFile.do?path=2019-11-05/201911051110468765356.jpg','湖南长沙',NULL,1,NULL,1,1,'2019-10-30'),(2,'hxb','','e10adc3949ba59abbe56e057f20f883e',18,NULL,NULL,NULL,'../downloadFile.do?path=2019-11-03/201911031157125582466.jpg',NULL,NULL,1,NULL,2,NULL,'2019-10-30'),(3,'dml','','e10adc3949ba59abbe56e057f20f883e',18,NULL,NULL,NULL,'../downloadFile.do?path=2019-11-03/201911031157243107452.jpg',NULL,NULL,1,NULL,4,NULL,'2019-10-30'),(4,'shw','','e10adc3949ba59abbe56e057f20f883e',18,NULL,NULL,NULL,'../downloadFile.do?path=2019-11-03/201911031157366531867.jpg',NULL,NULL,1,NULL,4,NULL,'2019-10-30'),(5,'hy','','e10adc3949ba59abbe56e057f20f883e',18,NULL,NULL,NULL,'../downloadFile.do?path=2019-11-03/201911031157472971000.jpg',NULL,NULL,1,NULL,3,NULL,'2019-10-30'),(6,'dh','','e10adc3949ba59abbe56e057f20f883e',18,NULL,NULL,NULL,'../downloadFile.do?path=2019-11-03/201911031157588378070.jpg',NULL,NULL,1,NULL,3,NULL,'2019-10-30'),(7,'zl','','e10adc3949ba59abbe56e057f20f883e',18,NULL,NULL,NULL,'../downloadFile.do?path=2019-11-03/201911031158164762046.jpg',NULL,NULL,1,NULL,5,NULL,'2019-10-30'),(8,'djl','','e10adc3949ba59abbe56e057f20f883e',18,NULL,NULL,NULL,'../downloadFile.do?path=2019-11-04/201911040835340405834.jpg',NULL,NULL,1,NULL,6,NULL,'2019-10-30'),(16,'luobo','luobo','e10adc3949ba59abbe56e057f20f883e',18,'男','13456780987','430626199111176736','../downloadFile.do?path=2019-11-04/201911041720069597162.jpg','jouoh','初中',0,'ddd',NULL,NULL,'2019-11-04'),(17,'luobo1','luobo','e10adc3949ba59abbe56e057f20f883e',18,'男','13578943256','430626199111176736','../downloadFile.do?path=2019-11-04/201911042238011824998.jpg','uioii','初中',0,'',NULL,NULL,'2019-11-04'),(18,'luobo11','luobo','e10adc3949ba59abbe56e057f20f883e',18,'男','13598764521','430626199111176736','../downloadFile.do?path=2019-11-06/201911060921352548000.jpg','rrttt','初中',0,'',NULL,NULL,'2019-11-04');

/*Table structure for table `loginlog` */

CREATE TABLE `loginlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `loginip` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `logintime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `loginlog` */

insert  into `loginlog`(`id`,`loginname`,`loginip`,`logintime`) values (33,'admin-罗波','0:0:0:0:0:0:0:1','2019-11-08 11:03:42'),(34,'admin-罗波','0:0:0:0:0:0:0:1','2019-11-08 11:06:06'),(35,'admin-罗波','0:0:0:0:0:0:0:1','2019-11-08 11:07:29'),(36,'admin-罗波','0:0:0:0:0:0:0:1','2019-11-08 11:14:08'),(37,'admin-罗波','0:0:0:0:0:0:0:1','2019-11-08 11:16:07'),(38,'admin-罗波','0:0:0:0:0:0:0:1','2019-11-08 11:18:43'),(39,'admin-罗波','0:0:0:0:0:0:0:1','2019-11-08 11:21:24'),(40,'admin-罗波','0:0:0:0:0:0:0:1','2019-11-08 11:24:50'),(41,'admin-罗波','0:0:0:0:0:0:0:1','2019-11-08 11:25:36'),(42,'admin-罗波','0:0:0:0:0:0:0:1','2019-11-08 11:26:59');

/*Table structure for table `menus` */

CREATE TABLE `menus` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `href` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `spread` int(255) DEFAULT NULL COMMENT '0不打1打开',
  `target` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `available` int(255) DEFAULT NULL COMMENT '0不可用1可用',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb4;

/*Data for the table `menus` */

insert  into `menus`(`mid`,`pid`,`title`,`href`,`spread`,`target`,`icon`,`available`) values (1,0,'医药erp系统',NULL,1,NULL,NULL,1),(2,1,'系统信息管理','',0,'','&#xe716;',1),(3,1,'采购管理','',0,'','&#xe698;',1),(4,1,'生产管理','',0,'','&#xe656;',1),(5,1,'库存管理','',0,'','&#xe62a;',1),(6,1,'财务管理','',0,'','&#xe65e;',1),(7,1,'分店管理','',0,'','&#xe663;',1),(8,1,'合同管理','',0,'','&#xe655;',1),(9,2,'员工管理','employeeManager.jsp',0,'','&#xe66f;',1),(10,2,'部门管理','departmentManager.jsp',0,'','&#xe66f;',1),(11,2,'菜单管理','menuManager.jsp',0,'','&#xe66f;',1),(12,2,'日志管理','log.jsp',0,'','&#xe66f;',1),(13,3,'供应商管理','purchase/supplier.jsp',0,'','&#xe66f;',1),(14,3,'采购申请','purchase/purchasingRequisition.jsp',0,'','&#xe66f;',1),(15,3,'采购计划','purchase/purchasePlan.jsp',0,'','&#xe66f;',1),(16,3,'采购报价单管理','purchase/quotation.jsp',0,'','&#xe66f;',1),(17,3,'样品质检','purchase/sampleAudit.jsp',0,'','&#xe66f;',1),(18,3,'采购订单','purchase/purchase.jsp',0,'','&#xe66f;',1),(19,3,'原料质检','purchase/materials.jsp',0,'','&#xe66f;',1),(20,3,'采购退货','purchase/purchaseReturn.jsp',0,'','&#xe66f;',1),(21,3,'采购审核管理','purchase/audit.jsp',0,'','&#xe66f;',1),(22,3,'采购数量报表','menu.jsp',0,'','&#xe66f;',1),(23,4,'月生产计划','production/plan.jsp',0,'','&#xe66f;',1),(24,4,'日生产计划','production/dayplan.jsp',0,'','&#xe66f;',1),(25,4,'成品及配方管理','production/recipe.jsp',0,'','&#xe66f;',1),(26,4,'生产订单','production/orderplan.jsp',0,'','&#xe66f;',1),(27,4,'生产领料','production/picking.jsp',0,'','&#xe66f;',1),(28,4,'退料管理','production/production4.html',0,'','&#xe66f;',1),(29,4,'补料管理','production/production3.html',0,'','&#xe66f;',1),(30,4,'废料管理','production/production1.html',0,'','&#xe66f;',1),(31,4,'成品质检','production/production2.html',0,'','&#xe66f;',1),(32,4,'生产报表1','.html',0,'','&#xe66f;',1),(33,4,'生产报表2','.html',0,'','&#xe66f;',1),(34,5,'仓库信息管理','warehouse/Warehouse.html',0,'','&#xe66f;',1),(35,5,'成品仓库','warehouse/FinishedGoodsSheet.html',0,'','&#xe66f;',1),(36,5,'原料仓库','warehouse/MaterialsWarehouse.html',0,'','&#xe66f;',1),(37,5,'废料仓库','warehouse/Abandon.jsp',0,'','&#xe66f;',1),(38,5,'原料出库','warehouse/MaterialOut.html',0,'','&#xe66f;',1),(39,5,'补料出库','warehouse/ReplenishmentMaterials.html',0,'','&#xe66f;',1),(40,5,'生产完工入库','warehouse/FinishedGoods.html',0,'','&#xe66f;',1),(41,5,'销售出库','warehouse/SalesOutbound.html',0,'','&#xe66f;',1),(42,5,'退货入库','warehouse/SalesReturn.html',0,'','&#xe66f;',1),(43,5,'废料入库','warehouse/WasteStorage.html',0,'','&#xe66f;',1),(44,5,'成品出入库报表','menu.jsp',0,'','&#xe66f;',1),(45,5,'原材料出入库报表','menu.jsp',0,'','&#xe66f;',1),(46,5,'采购入库','warehouse/MaterialEnter.html',0,'','&#xe66f;',1),(47,6,'支出单','finance/showPay.jsp',0,'','&#xe66f;',1),(48,6,'收入表','finance/receipt.jsp',0,'','&#xe66f;',1),(49,6,'财务报表','finance/NineChart.jsp',0,'','&#xe66f;',1),(50,7,'分店基本信息','finance/BranchManagement.jsp',0,'','&#xe66f;',1),(51,7,'总店销售管理','finance/eceipt.jsp',0,'','&#xe66f;',1),(52,7,'分店退货订单','finance/branchBack.jsp',0,'','&#xe66f;',1),(53,7,'分店销售报表','finance/branchSale.jsp',0,'','&#xe66f;',1),(54,8,'采购合同','menu.jsp',0,'','&#xe66f;',1),(55,8,'分店合同','menu.jsp',0,'','&#xe66f;',1),(56,8,'供应商管理','menu.jsp',0,'','&#xe66f;',1),(74,2,'角色管理','roleManager.jsp',0,'','&#xe66f;',1),(76,2,'数据源监控','../druid/',0,NULL,'&#xe66f;',1),(77,2,'首页公告管理','newsManager.jsp',0,'','&#xe66f;',1);

/*Table structure for table `menusrole` */

CREATE TABLE `menusrole` (
  `mid` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`mid`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `menusrole` */

insert  into `menusrole`(`mid`,`roleId`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(2,1),(3,1),(3,3),(4,1),(4,4),(5,1),(5,2),(6,1),(6,5),(7,1),(7,6),(8,1),(8,6),(9,1),(10,1),(11,1),(12,1),(13,1),(13,3),(14,1),(14,3),(15,1),(15,3),(16,1),(16,3),(17,1),(17,3),(18,1),(18,3),(19,1),(19,3),(20,1),(20,3),(21,1),(21,3),(22,1),(22,3),(23,1),(23,4),(24,1),(24,4),(25,1),(25,4),(26,1),(26,4),(27,1),(27,4),(28,1),(28,4),(29,1),(29,4),(30,1),(30,4),(31,1),(31,4),(32,1),(32,4),(33,1),(33,4),(34,1),(34,2),(35,1),(35,2),(36,1),(36,2),(37,1),(37,2),(38,1),(38,2),(39,1),(39,2),(40,1),(40,2),(41,1),(41,2),(42,1),(42,2),(43,1),(43,2),(44,1),(44,2),(45,1),(45,2),(46,1),(46,2),(47,1),(47,5),(48,1),(48,5),(49,1),(49,5),(50,1),(50,6),(51,1),(51,6),(52,1),(52,6),(53,1),(53,6),(54,1),(54,6),(55,1),(55,6),(56,6),(74,1),(76,1),(77,1);

/*Table structure for table `role` */

CREATE TABLE `role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `depid` int(11) DEFAULT NULL,
  `rolename` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `roledesc` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `available` int(11) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `role` */

insert  into `role`(`roleid`,`depid`,`rolename`,`roledesc`,`available`) values (1,1,'超级管理员','管理所有的功能',1),(2,2,'仓库管理hxb','仓库盘点和出入库管理里',1),(3,NULL,'采购管理(hy,dh)','负责采购的一切',1),(4,NULL,'生产管理(dml,shw)','月计划于日计划',1),(5,NULL,'财务管理(zl)','财务的收入与开支',1),(6,NULL,'分店管理和合同（djl）','分店管理和合同',1),(7,NULL,'合同管理','负责合同的签订',0);

/*Table structure for table `sys_news` */

CREATE TABLE `sys_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `content` varchar(4000) CHARACTER SET utf8 DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `opername` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `sys_news` */

insert  into `sys_news`(`id`,`title`,`content`,`createtime`,`opername`) values (1,'uouo','dddfff','2019-11-08 10:42:51','罗波');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
