/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : 65001

 Date: 16/07/2020 14:44:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `salary` decimal(10,2) DEFAULT NULL,
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `hiredate` datetime DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
BEGIN;
INSERT INTO `person` VALUES (8888.88, 1, '张瑞丰', 23, '1998-01-15 17:21:09', '男');
INSERT INTO `person` VALUES (546654.45, 2, '张飞', 1056, '2020-02-18 18:47:39', '男');
INSERT INTO `person` VALUES (9999.00, 3, '刘备', 1059, '2020-02-20 13:56:39', '男');
INSERT INTO `person` VALUES (486.00, 4, '关羽', 1534, '2020-02-11 13:57:02', '男');
INSERT INTO `person` VALUES (21313.00, 5, '大乔', 1515, '2020-02-04 13:57:32', '女');
INSERT INTO `person` VALUES (135.00, 6, '小乔', 513, '2020-02-07 13:57:49', '女');
INSERT INTO `person` VALUES (123.00, 7, '关仓', 213, '2020-02-05 13:58:08', '男');
INSERT INTO `person` VALUES (56.00, 8, '李白', 213, '2020-02-26 13:58:25', '男');
INSERT INTO `person` VALUES (213.00, 9, '王伟', 456, '2020-02-19 13:58:39', '男');
INSERT INTO `person` VALUES (456.00, 10, '哪吒', 456, '2020-03-07 13:58:55', '女');
INSERT INTO `person` VALUES (456.00, 11, '张伟', 26, '2020-02-05 13:59:11', '男');
INSERT INTO `person` VALUES (54333.00, 12, '蒙奇·D·路飞', 16, '2020-02-19 13:59:44', '男');
INSERT INTO `person` VALUES (45466.00, 13, '罗罗诺亚·索隆', 20, '2020-02-19 14:00:04', '男');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
