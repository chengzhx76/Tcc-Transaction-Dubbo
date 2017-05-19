/*
Navicat MySQL Data Transfer

Source Server         : localhost-1
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : tcc_dubbo

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-05-18 13:24:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `accountId` int(11) NOT NULL COMMENT '账户ID',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `balance` int(11) NOT NULL COMMENT '余额',
  PRIMARY KEY (`accountId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户';

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '1', '1000');

-- ----------------------------
-- Table structure for accountrecord
-- ----------------------------
DROP TABLE IF EXISTS `accountrecord`;
CREATE TABLE `accountrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '交易ID',
  `accountId` int(11) NOT NULL COMMENT '账户ID',
  `orderNo` int(11) NOT NULL COMMENT '订单号',
  `amount` int(11) NOT NULL COMMENT '金额',
  `state` varchar(255) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='账户交易记录';

-- ----------------------------
-- Records of accountrecord
-- ----------------------------

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `orderNO` int(11) NOT NULL,
  `productId` int(11) NOT NULL COMMENT '商品ID',
  `number` int(11) NOT NULL COMMENT '数量',
  `unitPrice` int(11) NOT NULL COMMENT '单个价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='订单详情';

-- ----------------------------
-- Records of orderdetail
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderNo` int(11) NOT NULL COMMENT '订单号',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `castAmount` int(11) NOT NULL COMMENT '花费金额',
  `costPoints` int(11) NOT NULL COMMENT '花费积分',
  `state` varchar(255) NOT NULL COMMENT '状态',
  PRIMARY KEY (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单';

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for points
-- ----------------------------
DROP TABLE IF EXISTS `points`;
CREATE TABLE `points` (
  `pointsId` int(11) NOT NULL COMMENT '积分ID',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `balance` varchar(255) NOT NULL COMMENT '余额',
  PRIMARY KEY (`pointsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分';

-- ----------------------------
-- Records of points
-- ----------------------------
INSERT INTO `points` VALUES ('1', '1', '1000');

-- ----------------------------
-- Table structure for pointsrecord
-- ----------------------------
DROP TABLE IF EXISTS `pointsrecord`;
CREATE TABLE `pointsrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '交易ID',
  `pointsId` int(11) NOT NULL COMMENT '积分ID',
  `orderNo` int(11) NOT NULL COMMENT '订单号',
  `cost` int(11) NOT NULL COMMENT '消费',
  `state` varchar(255) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='积分交易记录';

-- ----------------------------
-- Records of pointsrecord
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `productId` int(11) NOT NULL COMMENT '商品ID',
  `productName` varchar(255) NOT NULL COMMENT '商品名字',
  `count` int(11) NOT NULL COMMENT '数量',
  `price` int(11) NOT NULL COMMENT '价格',
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品';

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'iphone 6s', '99', '35');
