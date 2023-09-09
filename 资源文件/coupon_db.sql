/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80032
Source Host           : localhost:3306
Source Database       : coupon_db

Target Server Type    : MYSQL
Target Server Version : 80032
File Encoding         : 65001

Date: 2023-09-09 13:28:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `template_id` int NOT NULL DEFAULT '0' COMMENT '主键',
  `user_id` bigint NOT NULL DEFAULT '0' COMMENT '拥有这张券的用户ID',
  `created_time` datetime NOT NULL DEFAULT '2021-12-13 00:00:00' COMMENT '领券时间',
  `status` int NOT NULL DEFAULT '0' COMMENT '优惠券的状态，比如未用，已用',
  `shop_id` bigint DEFAULT NULL COMMENT '冗余字段，方便查找',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_template_id` (`template_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COMMENT='领到手的优惠券';

-- ----------------------------
-- Table structure for coupon_template
-- ----------------------------
DROP TABLE IF EXISTS `coupon_template`;
CREATE TABLE `coupon_template` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `available` tinyint(1) NOT NULL DEFAULT '0' COMMENT '优惠券可用状态',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '优惠券名称',
  `description` varchar(256) NOT NULL DEFAULT '' COMMENT '优惠券详细信息',
  `type` varchar(10) NOT NULL DEFAULT '' COMMENT '优惠券类型，比如满减、随机立减、晚间双倍等等',
  `shop_id` bigint DEFAULT NULL COMMENT '优惠券适用的门店，如果是空则代表全场适用',
  `created_time` datetime NOT NULL DEFAULT '2021-12-13 00:00:00' COMMENT '创建时间',
  `rule` varchar(2000) NOT NULL DEFAULT '' COMMENT '详细的使用规则',
  PRIMARY KEY (`id`),
  KEY `idx_shop_id` (`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COMMENT='优惠券模板';
