/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.22 : Database - tx_order
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tx_pay` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `tx_pay`;

/*Table structure for table `tx_order` */

DROP TABLE IF EXISTS `tx_pay`;

CREATE TABLE `tx_pay` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pay_no` varchar(50) NOT NULL COMMENT '交易单号',
  `order_no` varchar(50) NOT NULL COMMENT '订单号',

  `user_id` int(10) DEFAULT '0' COMMENT '用户账号ID',
  `amount` decimal(8,2) NOT NULL DEFAULT '0' COMMENT '交易金额',
  `pay_state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '支付类型 0:余额 1:微信 2:支付宝 3:xxx',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '支付状态 -1：取消 0 未完成 1已完成 -2:异常',
  `deleted` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '删除标志，默认0不删除，1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='支付交易表';
