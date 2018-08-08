/*
Navicat MySQL Data Transfer

Source Server         : zy
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : live

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2018-08-08 16:02:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for live_user
-- ----------------------------
DROP TABLE IF EXISTS `live_user`;
CREATE TABLE `live_user` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `user_name` varchar(100) NOT NULL COMMENT '姓名',
  `sex` varchar(1) NOT NULL COMMENT '性别：0 男 1 女',
  `phone` varchar(11) NOT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of live_user
-- ----------------------------
INSERT INTO `live_user` VALUES ('314c7cd84e1b454093927b5bf7b17dae', 'dlyong', '0', '15566883366');
