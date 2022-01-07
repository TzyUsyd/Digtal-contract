/*
 Navicat Premium Data Transfer

 Source Server         : COMP5619
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : comp5619_g12

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 30/10/2021 00:53:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact`  (
  `contact_id` int NOT NULL AUTO_INCREMENT COMMENT 'the pk of contact ',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'the fk, the user of this contact',
  `contact_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `contact_gender` int NULL DEFAULT NULL COMMENT '0 is male. 1 is female. 3 is other.',
  `contact_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `contact_verification` int NULL DEFAULT 0 COMMENT '1 is verified. 0 is not. default 0',
  `contact_licence_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contact_licence_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contact_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Tel phone number',
  `contact_address` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'the address of contact',
  PRIMARY KEY (`contact_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES (1, '2', '1', 0, '2', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (2, '2', '555', 0, '555', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (3, '2', '1', 0, '2', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (4, '3', 'sd', 0, 'gg', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (5, '3', 'sdsad', 0, 'asdasd', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (6, '3', 'alex', 0, 'alex', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (7, '3', '1212', 0, '1212', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (8, '3', '111', 0, '111', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (9, '3', 'sadsd', 0, '啊实打实大', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (10, '3', '王企鹅群无', 0, '萨顶顶', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (11, '3', 'MADEAPPL', 0, 'SDASD', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (12, '3', 'FSDFSD', 0, 'SFSDF', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (13, '3', '是的撒多', 0, '撒大声地', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (14, '3', '啊实打实大', 0, '按时大大', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (15, '3', '阿闪大大', 0, '爱迪生大', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (16, '3', '请问请问', 0, '驱蚊器', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (17, '3', 'dasd', 0, 'sadas', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (18, '3', 'asda', 0, 'dasda', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (19, 'fnzehqmvua@pussport.com', 'iiiiiiiiii', 0, 'iiiiiiiiiii', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (20, 'fnzehqmvua@pussport.com', 'zzzzzzzzzzzz', 0, 'zzzzzzzzzzzzzzzz', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (21, 'fnzehqmvua@pussport.com', 'mmmmmmmmmmm', 0, 'mmmmmmmmmmm', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (22, 'fnzehqmvua@pussport.com', 'yyyyyyyyyyyyyyy', 0, 'yyyyyyyyyyyy', 0, NULL, NULL, NULL, NULL);
INSERT INTO `contact` VALUES (23, 'fnzehqmvua@pussport.com', 'uuuuuuuuuuuu', 0, 'uuuuuuuuuuuuuuuuu', 0, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `contract_id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `partya_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `partya_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `partyb_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `budget` decimal(65, 2) NULL DEFAULT NULL,
  `partyb_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `partyb_licence_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `partyb_licence_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `partyb_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Tel phone number',
  `partyb_address` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'the address of user',
  `begin_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `end_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `contract_contents` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `comments` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `attachment` blob NULL COMMENT 'attachment image',
  `form` blob NULL COMMENT 'the form of this iou',
  PRIMARY KEY (`contract_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES (1, '2', '', '', 'alibaba', 566.00, 'all@ali.com', 'gongshang', '11111dsd', '186', 'beijing', '2021-10-14 17:33:07', '2021-10-20 18:08:08', 'sadadsasda', NULL, NULL, NULL);
INSERT INTO `contract` VALUES (2, '3', 'sdasda', 'asdfasd', 'dasd', 100.00, 'sadas', NULL, NULL, NULL, NULL, '2021-10-16', '2021-11-15', 'asdasd', NULL, NULL, NULL);
INSERT INTO `contract` VALUES (4, 'fnzehqmvua@pussport.com', 'yyyyyyyyyyyyyy', 'yyyyyyyyyyyyyyy', 'yyyyyyyyyyyyyyy', 100.00, 'yyyyyyyyyyyy', NULL, NULL, NULL, NULL, '2021-10-12', '2021-11-24', 'yyyyyyyyyyyyyyyyyy', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for iou
-- ----------------------------
DROP TABLE IF EXISTS `iou`;
CREATE TABLE `iou`  (
  `iou_id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `payer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `payer_gender` int NULL DEFAULT NULL COMMENT '0 is male. 1 is female. 3 is other.',
  `payer_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `payer_licence_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `payer_licence_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `payer_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Tel phone number',
  `payer_address` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'the address of user',
  `amount` decimal(20, 2) NOT NULL COMMENT 'the money amount',
  `reason` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'own money reason ',
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'pay date\r\n',
  `interest_rate` decimal(4, 2) NULL DEFAULT 0.00,
  `payment_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comments` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `attachment` blob NULL COMMENT 'attachment image',
  `form` blob NULL COMMENT 'the form of this iou',
  PRIMARY KEY (`iou_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of iou
-- ----------------------------
INSERT INTO `iou` VALUES (1, '2', 'tom', 1, 'ggg@ddsd', 'sdasd', 'sssssssssss', '139', 'sadasd', 777.00, 'sdasd', '2021-10-13', 0.36, 'ali', NULL, NULL, NULL);
INSERT INTO `iou` VALUES (2, '3', 'sd', 0, 'gg', NULL, NULL, NULL, NULL, 100.00, 'dfsdf', '2021-10-28', 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `iou` VALUES (3, '3', 'sdsad', 0, 'asdasd', NULL, NULL, NULL, NULL, 100.00, 'asda', '2021-10-28', 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `iou` VALUES (4, '3', 'alex', 0, 'alex', NULL, NULL, NULL, NULL, 100.00, 'alex', '2021-10-28', 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `iou` VALUES (5, '3', '1212', 0, '1212', NULL, NULL, NULL, NULL, 100.00, '121212', '2021-10-12', 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `iou` VALUES (6, '3', '111', NULL, '111', NULL, NULL, NULL, NULL, 100.00, '111', '2021-10-28', 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `iou` VALUES (7, '3', 'sadsd', NULL, '啊实打实大', NULL, NULL, NULL, NULL, 100.00, '阿达', '2021-10-28T21:20:40+08:00', 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `iou` VALUES (8, '3', '王企鹅群无', NULL, '萨顶顶', NULL, NULL, NULL, NULL, 100.00, '啊实打实大', '2021-10-28T21:26:14+08:00', 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `iou` VALUES (9, '3', 'MADEAPPL', NULL, 'SDASD', NULL, NULL, NULL, NULL, 100.00, 'ASDASD', '2021-10-28', 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `iou` VALUES (10, '3', 'FSDFSD', NULL, 'SFSDF', NULL, NULL, NULL, NULL, 100.00, 'SFDS', '2021-10-28', 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `iou` VALUES (11, '3', '是的撒多', NULL, '撒大声地', NULL, NULL, NULL, NULL, 100.00, '撒大声地', '2021-10-26', 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `iou` VALUES (12, '3', '啊实打实大', NULL, '按时大大', NULL, NULL, NULL, NULL, 100.00, '啊实打实大', '2021-10-07', 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `iou` VALUES (14, 'fnzehqmvua@pussport.com', 'zzzzzzzzzzzz', NULL, 'zzzzzzzzzzzzzzzz', NULL, NULL, NULL, NULL, 100.00, 'zzzzzzzzzzzzzzzzzzzzzzz', '2021-10-30', 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `iou` VALUES (15, 'fnzehqmvua@pussport.com', 'mmmmmmmmmmm', NULL, 'mmmmmmmmmmm', NULL, NULL, NULL, NULL, 100.00, 'mmmmmmmmmmmmmm', '2021-10-30', 0.00, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for receipt
-- ----------------------------
DROP TABLE IF EXISTS `receipt`;
CREATE TABLE `receipt`  (
  `own_id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `payer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `payer_gender` int NULL DEFAULT NULL COMMENT '0 is male. 1 is female. 3 is other.',
  `payer_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `payer_licence_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `payer_licence_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `payer_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Tel phone number',
  `payer_address` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'the address of user',
  `amount` decimal(20, 2) NOT NULL COMMENT 'the money amount',
  `reason` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'own money reason ',
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'pay date\r\n',
  `payment_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comments` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `attachment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'attachment image',
  `form` blob NULL COMMENT 'the form of this iou',
  PRIMARY KEY (`own_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of receipt
-- ----------------------------
INSERT INTO `receipt` VALUES (1, '2', '1', 0, '2', '', '', '3', '', 444.00, 'sadad', '2021-10-05 16:20:37', '', '', '', NULL);
INSERT INTO `receipt` VALUES (2, '2', '555', 0, '555', '', '', '555', '', 555.00, '555', '2021-10-06 17:55:24', '', '', '', NULL);
INSERT INTO `receipt` VALUES (3, '2', '1', 0, '2', NULL, NULL, '3', NULL, 555.00, '444', '2021-10-19 18:12:02', NULL, NULL, '', NULL);
INSERT INTO `receipt` VALUES (4, '2', '1', 0, '555', NULL, NULL, '3', NULL, 5.00, '555', '2021-10-11 18:41:39', NULL, NULL, '', NULL);
INSERT INTO `receipt` VALUES (6, 'fnzehqmvua@pussport.com', 'iiiiiiiiii', 0, 'iiiiiiiiiii', NULL, NULL, NULL, NULL, 100.00, 'iiiiiiiiiiii', '2021-10-30', NULL, NULL, NULL, NULL);
INSERT INTO `receipt` VALUES (7, 'fnzehqmvua@pussport.com', 'uuuuuuuuuuuu', 0, 'uuuuuuuuuuuuuuuuu', NULL, NULL, NULL, NULL, 100.00, 'uuuuuuuuuuuuuuuuu', '2021-10-30', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT 'the user id and pri key',
  `user_seq_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_gender` int NULL DEFAULT NULL COMMENT '0 is male. 1 is female. 3 is other.',
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_verification` int NULL DEFAULT 0 COMMENT '1 is verified. 0 is not. default 0',
  `user_licence_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_licence_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Tel phone number',
  `user_address` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'the address of user',
  `user_signature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'the signature image, maximum size is 16M',
  `user_premium` int NULL DEFAULT 0 COMMENT '1 Is premium. 0 is not. default 0',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'fnzehqmvua@pussport.com', NULL, 0, NULL, NULL, 0, NULL, NULL, NULL, NULL, '9fdb5455-3a9f-4b81-80f6-df8a2c1bfbd0.png', 0);

SET FOREIGN_KEY_CHECKS = 1;
