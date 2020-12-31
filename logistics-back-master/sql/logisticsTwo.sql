/*
 Navicat Premium Data Transfer

 Source Server         : zlg
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : logistics

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 24/12/2020 19:33:26
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for billinfo
-- ----------------------------
DROP TABLE IF EXISTS `billinfo`;
CREATE TABLE `billinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accept_station` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bill_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bill_state` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bill_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `write_date` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of billinfo
-- ----------------------------
INSERT INTO `billinfo` VALUES (1, NULL, 'HY617055', '??', '???', '2020-12-15 21:33:13.470000');
INSERT INTO `billinfo` VALUES (2, NULL, 'HY617056', '??', '???', '2020-12-15 21:33:13.470000');
INSERT INTO `billinfo` VALUES (3, NULL, 'HY617057', '??', '???', '2020-12-15 21:33:13.470000');
INSERT INTO `billinfo` VALUES (4, NULL, 'HY617058', '??', '???', '2020-12-15 21:33:13.470000');
INSERT INTO `billinfo` VALUES (5, NULL, 'HY617059', '??', '???', '2020-12-15 21:33:13.470000');
INSERT INTO `billinfo` VALUES (6, NULL, 'HY617060', '??', '???', '2020-12-15 21:33:13.470000');
INSERT INTO `billinfo` VALUES (7, NULL, 'HY617061', '??', '???', '2020-12-15 21:33:13.470000');
INSERT INTO `billinfo` VALUES (8, NULL, 'HY617062', '??', '???', '2020-12-15 21:33:13.470000');
INSERT INTO `billinfo` VALUES (9, '???', 'HZ328683', '??', '?????', '2020-12-19 09:54:48.053000');
INSERT INTO `billinfo` VALUES (10, NULL, 'HY340660', '??', '???', '2020-12-20 09:03:52.089000');
INSERT INTO `billinfo` VALUES (11, '???', 'HZ855889', '??', '?????', '2020-12-20 09:06:29.368000');
INSERT INTO `billinfo` VALUES (12, NULL, 'HY756664', '??', '???', '2020-12-24 16:35:16.512000');
INSERT INTO `billinfo` VALUES (13, '???', 'HZ854408', '??', '?????', '2020-12-24 16:39:37.893000');
INSERT INTO `billinfo` VALUES (14, NULL, 'HY424342', '??', '???', '2020-12-24 19:06:16.344000');
INSERT INTO `billinfo` VALUES (15, '???', 'HZ389331', '??', '?????', '2020-12-24 19:09:33.855000');

-- ----------------------------
-- Table structure for billrelease
-- ----------------------------
DROP TABLE IF EXISTS `billrelease`;
CREATE TABLE `billrelease`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accept_station` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bill_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bill_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receive_bill_person` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receive_bill_time` date NULL DEFAULT NULL,
  `release_person` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of billrelease
-- ----------------------------
INSERT INTO `billrelease` VALUES (1, '??', 'HY617055', '???', 'SJ058684', '2020-12-19', 'GL846489');
INSERT INTO `billrelease` VALUES (2, '??', 'HY617056', '???', 'SJ058684', '2020-12-19', 'GL846489');
INSERT INTO `billrelease` VALUES (3, '??', 'HY617057', '???', 'SJ058684', '2020-12-19', 'GL846489');
INSERT INTO `billrelease` VALUES (4, 'ss', 'HY617058', '???', 'SJ058684', '2020-12-19', 'GL846489');
INSERT INTO `billrelease` VALUES (5, 'ss', 'HY617059', '???', 'SJ058684', '2020-12-19', 'GL846489');
INSERT INTO `billrelease` VALUES (6, 'sss', 'HY617060', '???', 'SJ058684', '2020-12-19', 'GL846489');
INSERT INTO `billrelease` VALUES (7, '1', 'HY617061', '???', 'SJ058684', '2020-12-19', 'GL846489');
INSERT INTO `billrelease` VALUES (8, '2', 'HY617062', '???', 'SJ066265', '2020-12-19', 'GL846489');
INSERT INTO `billrelease` VALUES (9, '111', 'HY340660', '???', 'SJ058684', '2020-12-20', 'GL846489');
INSERT INTO `billrelease` VALUES (10, '???', 'HY756664', '???', 'SJ058684', '2020-12-24', 'GL846489');
INSERT INTO `billrelease` VALUES (11, '???', 'HY424342', '???', 'SJ058684', '2020-12-24', 'GL846489');

-- ----------------------------
-- Table structure for callbackinfo
-- ----------------------------
DROP TABLE IF EXISTS `callbackinfo`;
CREATE TABLE `callbackinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bill_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bill_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dial_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `finally_dial_time` date NULL DEFAULT NULL,
  `goods_bill_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `locked` bit(1) NOT NULL,
  `success` bit(1) NOT NULL,
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `write_time` date NULL DEFAULT NULL,
  `writer` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of callbackinfo
-- ----------------------------
INSERT INTO `callbackinfo` VALUES (1, NULL, NULL, '111', '13959239996', NULL, 'HY617056', b'0', b'0', '????', '2020-12-19', 'GL846489');
INSERT INTO `callbackinfo` VALUES (2, NULL, NULL, 'sdfaf', '13959239999', NULL, 'HY617055', b'0', b'0', '????', '2020-12-19', 'GL846489');
INSERT INTO `callbackinfo` VALUES (3, NULL, NULL, 'fasdf', '13959239999', NULL, 'HY617058', b'0', b'0', '????', '2020-12-19', 'GL846489');
INSERT INTO `callbackinfo` VALUES (4, NULL, NULL, 'dsaf', '13959239996', NULL, 'HY617057', b'0', b'0', '????', '2020-12-23', 'GL846489');
INSERT INTO `callbackinfo` VALUES (5, NULL, NULL, 'ddd', '13959239996', NULL, 'HY617056', b'0', b'0', '????', '2020-12-23', 'GL846489');
INSERT INTO `callbackinfo` VALUES (6, NULL, NULL, '??', '13959239996', NULL, 'HY617062', b'0', b'0', '????', '2020-12-23', 'GL846489');
INSERT INTO `callbackinfo` VALUES (7, NULL, NULL, '??', '13959239999', NULL, 'HY617056', b'0', b'0', '????', '2020-12-23', 'GL846489');
INSERT INTO `callbackinfo` VALUES (8, NULL, NULL, 'sfda', '13959239999', NULL, 'HY617057', b'0', b'0', '????', '2020-12-24', 'GL846489');
INSERT INTO `callbackinfo` VALUES (9, NULL, NULL, 'fdsa', '13959239996', NULL, 'HY617057', b'0', b'0', '????', '2020-12-24', 'GL846489');
INSERT INTO `callbackinfo` VALUES (10, NULL, NULL, 'sdfs', '13959239996', NULL, 'HY617060', b'0', b'0', '????', '2020-12-24', 'GL846489');
INSERT INTO `callbackinfo` VALUES (11, NULL, NULL, 'ssss', '13959239999', NULL, 'HY756664', b'0', b'0', '????', '2020-12-24', 'GL846489');

-- ----------------------------
-- Table structure for carcost
-- ----------------------------
DROP TABLE IF EXISTS `carcost`;
CREATE TABLE `carcost`  (
  `driver_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `add_carriage_total` double NOT NULL,
  `allow_carry_weight` double NULL DEFAULT NULL,
  `back_bill_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `balance_time` datetime(6) NULL DEFAULT NULL,
  `car_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_width` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `carry_fee_total` double NOT NULL,
  `deal_goods_station` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fact_carriage_total` double NOT NULL,
  `goods_height` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `load_station` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`driver_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carcost
-- ----------------------------
INSERT INTO `carcost` VALUES ('SJ058684', 0, 20, NULL, NULL, '?A88885', 'c1', '10', 0, NULL, 0, '10', NULL);
INSERT INTO `carcost` VALUES ('SJ066265', 10, 20, NULL, NULL, '?A88888', 'c1', '10', 10, NULL, 0, '10', NULL);

-- ----------------------------
-- Table structure for cargoerror
-- ----------------------------
DROP TABLE IF EXISTS `cargoerror`;
CREATE TABLE `cargoerror`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_bill_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_revert_bill_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_value` double NULL DEFAULT NULL,
  `mistake_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `piece_amount` int(11) NULL DEFAULT NULL,
  `size` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cargoerror
-- ----------------------------

-- ----------------------------
-- Table structure for cargoreceipt
-- ----------------------------
DROP TABLE IF EXISTS `cargoreceipt`;
CREATE TABLE `cargoreceipt`  (
  `goods_revert_bill_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `accept_station` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `all_carriage` double NOT NULL,
  `arrive_time` date NULL DEFAULT NULL,
  `back_bill_state` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `carriage_banlance_mode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `carriage_mode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `carry_goods_bill_deposit` double NOT NULL,
  `carry_goods_insurance` double NOT NULL,
  `deal_goods_station` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dispatch_service_fee` double NOT NULL,
  `driver_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `if_balance` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `insurance` double NOT NULL,
  `linkman_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `load_station` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receive_goods_detail_addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receive_goods_linkman` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sign_time` date NULL DEFAULT NULL,
  `start_advance` double NOT NULL,
  `start_carry_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`goods_revert_bill_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cargoreceipt
-- ----------------------------
INSERT INTO `cargoreceipt` VALUES ('HZ328676', '1', 1, '2020-12-19', '????', '??', '1', 11, 1, '??', 1, 'SJ058684', NULL, 1, '13959239999', '??', '?????????', '????3', '?', '2020-12-19', 11, NULL);
INSERT INTO `cargoreceipt` VALUES ('HZ328677', '???', 1, '2020-12-20', '????', '???', '1?/?', 1, 1, '??', 1, 'SJ058684', NULL, 1, '13959239999', '??', '?????????', '????3', '1', '2020-12-19', 1, '2020-12-08');
INSERT INTO `cargoreceipt` VALUES ('HZ328678', '???', 5, '2020-12-24', '????', '???', '7', 2, 3, '??', 4, 'SJ058684', NULL, 6, '13959239999', '??', '?????????', '????3', '??1', '2020-12-17', 1, '2020-12-08');
INSERT INTO `cargoreceipt` VALUES ('HZ328679', '???', 5, '2020-12-19', '????', '???', '7', 2, 3, '??', 4, 'SJ058684', NULL, 6, '13959239999', '??', '?????????', '????3', '??1', '2020-12-19', 1, '2020-12-19');
INSERT INTO `cargoreceipt` VALUES ('HZ328680', '???', 7, '2020-12-19', '????', '1', '9', 4, 5, '??', 6, 'SJ058684', NULL, 8, '13959239999', '??', '?????????', '????3', '2', '2020-12-19', 3, '2020-12-19');
INSERT INTO `cargoreceipt` VALUES ('HZ328681', '9', 7, NULL, '????', '1', '10', 4, 5, '??', 6, 'SJ058684', NULL, 8, '13959239999', '??', '?????????', '????3', '2', '2020-12-19', 3, '2020-12-19');
INSERT INTO `cargoreceipt` VALUES ('HZ328682', '8', 6, NULL, '????', '1', '9', 3, 4, '??', 5, 'SJ058684', NULL, 7, '13959239999', '??', '?????????', '????3', '??', '2020-12-19', 2, '2020-12-19');
INSERT INTO `cargoreceipt` VALUES ('HZ328683', '???', 5, NULL, '????', '???', '7', 2, 3, '??', 4, 'SJ066265', NULL, 6, '13959239999', '??', '?????????', '????3', '??1', '2020-12-19', 1, NULL);
INSERT INTO `cargoreceipt` VALUES ('HZ389331', '???', 20, NULL, '????', '???', '11', 0, 0, '??', 0, '', NULL, 0, '13959239996', '??', '?????????', '????2', '?', '2020-12-24', 0, '2020-11-30');
INSERT INTO `cargoreceipt` VALUES ('HZ854408', '???', 20, '2020-12-24', '????', '???', '100?/?', 0, 0, '??', 0, '', NULL, 20, '13959239999', '??', '?????????', '????4', '?', '2020-12-24', 0, NULL);
INSERT INTO `cargoreceipt` VALUES ('HZ855889', '???', 100, '2020-12-20', '????', '???', '100/?', 0, 0, '??', 0, 'SJ058684', NULL, 20, '13959239999', '??', '?????????', '????3', '?', '2020-12-20', 0, '2020-12-20');

-- ----------------------------
-- Table structure for cargoreceiptdetail
-- ----------------------------
DROP TABLE IF EXISTS `cargoreceiptdetail`;
CREATE TABLE `cargoreceiptdetail`  (
  `goods_revert_bill_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `goods_bill_detail_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_value` double NOT NULL,
  `piece_amount` int(11) NOT NULL,
  `price_mode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price_standard` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `volume` double NOT NULL,
  `weight` double NOT NULL,
  PRIMARY KEY (`goods_revert_bill_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cargoreceiptdetail
-- ----------------------------
INSERT INTO `cargoreceiptdetail` VALUES ('HZ328676', 'HY617055', 1, 1, '1', '1', 1, 1);
INSERT INTO `cargoreceiptdetail` VALUES ('HZ328677', 'HY617056', 1, 1, '1', '1', 1, 1);
INSERT INTO `cargoreceiptdetail` VALUES ('HZ328678', 'HY617057', 1, 1, '1', '1', 1, 1);
INSERT INTO `cargoreceiptdetail` VALUES ('HZ328679', 'HY617058', 1, 1, '1', '1', 1, 1);
INSERT INTO `cargoreceiptdetail` VALUES ('HZ328680', 'HY617059', 1, 1, '1', '1', 1, 1);
INSERT INTO `cargoreceiptdetail` VALUES ('HZ328681', 'HY617060', 1, 1, '1', '1', 1, 1);
INSERT INTO `cargoreceiptdetail` VALUES ('HZ328682', 'HY617061', 1, 1, '1', '1', 1, 1);
INSERT INTO `cargoreceiptdetail` VALUES ('HZ328683', 'HY617062', 1, 1, '1', '1', 1, 1);
INSERT INTO `cargoreceiptdetail` VALUES ('HZ389331', 'HY424342', 100, 1, '?', '100', 110, 10);
INSERT INTO `cargoreceiptdetail` VALUES ('HZ854408', 'HY756664', 10, 1, '10?/kg', '10', 10, 20);
INSERT INTO `cargoreceiptdetail` VALUES ('HZ855889', 'HY340660', 20, 1, '20?/?', '20?/?', 10, 10);

-- ----------------------------
-- Table structure for cityexpand
-- ----------------------------
DROP TABLE IF EXISTS `cityexpand`;
CREATE TABLE `cityexpand`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) NOT NULL,
  `range_city` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cityexpand
-- ----------------------------
INSERT INTO `cityexpand` VALUES (26, 4, '5');
INSERT INTO `cityexpand` VALUES (28, 5, '2');
INSERT INTO `cityexpand` VALUES (30, 3, '4');
INSERT INTO `cityexpand` VALUES (31, 6, '3');
INSERT INTO `cityexpand` VALUES (34, 1, '4');

-- ----------------------------
-- Table structure for compensationinfo
-- ----------------------------
DROP TABLE IF EXISTS `compensationinfo`;
CREATE TABLE `compensationinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amends` double NOT NULL,
  `amends_time` date NULL DEFAULT NULL,
  `bad_destroy_goods` double NOT NULL,
  `customer` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receive_station_id` int(11) NOT NULL,
  `receive_station_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `write_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of compensationinfo
-- ----------------------------

-- ----------------------------
-- Table structure for complaintinfo
-- ----------------------------
DROP TABLE IF EXISTS `complaintinfo`;
CREATE TABLE `complaintinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `appeal_content` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `appeal_date` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `call_back_date` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deal_date` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deal_person` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deal_result` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_bill_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `if_callback` bit(1) NULL DEFAULT NULL,
  `if_handle` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of complaintinfo
-- ----------------------------

-- ----------------------------
-- Table structure for contactsservice
-- ----------------------------
DROP TABLE IF EXISTS `contactsservice`;
CREATE TABLE `contactsservice`  (
  `send_goods_customer` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `balance` double NOT NULL,
  `bill_money` double NOT NULL,
  `carriage` double NOT NULL,
  `goods_bill_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `insurance` double NOT NULL,
  `money_receivable` double NOT NULL,
  `receive_goods_addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `received_money` double NOT NULL,
  `send_goods_addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `send_goods_date` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`send_goods_customer`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of contactsservice
-- ----------------------------
INSERT INTO `contactsservice` VALUES ('????2', 0, 0, 20, 'HY617059', 20, 10, '???', 10, '???', '2020-12-15 00:00:00.000000');
INSERT INTO `contactsservice` VALUES ('????4', 0, 0, 20, 'HY756664', 20, 20, '?????????', 40, '?????????', '2020-12-24 00:00:00.000000');

-- ----------------------------
-- Table structure for customeramount
-- ----------------------------
DROP TABLE IF EXISTS `customeramount`;
CREATE TABLE `customeramount`  (
  `send_goods_customer` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `carriage_total` double NOT NULL,
  `insurance_total` double NOT NULL,
  `piece_amount_total` int(11) NOT NULL,
  PRIMARY KEY (`send_goods_customer`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customeramount
-- ----------------------------
INSERT INTO `customeramount` VALUES ('????2', 180, 180, 9);
INSERT INTO `customeramount` VALUES ('????4', 40, 20, 2);

-- ----------------------------
-- Table structure for customerbillclear
-- ----------------------------
DROP TABLE IF EXISTS `customerbillclear`;
CREATE TABLE `customerbillclear`  (
  `goods_bill_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `customer_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `balance` double NULL DEFAULT NULL,
  `balance_time` date NULL DEFAULT NULL,
  `balance_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bill_money` double NULL DEFAULT NULL,
  `carriage_reduce_fund` double NULL DEFAULT NULL,
  `carry_goods_fee` double NULL DEFAULT NULL,
  `insurance` double NULL DEFAULT NULL,
  `money_receivable` double NULL DEFAULT NULL,
  `pay_kickback` double NULL DEFAULT NULL,
  `prepay_money` double NULL DEFAULT NULL,
  `received_money` double NULL DEFAULT NULL,
  PRIMARY KEY (`goods_bill_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customerbillclear
-- ----------------------------
INSERT INTO `customerbillclear` VALUES ('HY340660', 'KH060624', 0, '2020-12-17', '??', 100, 0, 20, 20, 120, 0, 0, 120);
INSERT INTO `customerbillclear` VALUES ('HY617055', 'KH060624', 0, '2020-12-11', '??', 10, 10, 0, 20, 20, 0, 0, 20);
INSERT INTO `customerbillclear` VALUES ('HY617056', 'KH060624', 0, '2020-12-23', '??', 0, 10, 0, 20, 10, 0, 0, 10);
INSERT INTO `customerbillclear` VALUES ('HY617057', 'KH060624', 0, NULL, '??', 0, 10, 0, 20, 0, 0, 0, 0);
INSERT INTO `customerbillclear` VALUES ('HY617058', 'KH060624', 0, '2020-12-26', '??', 0, 10, 0, 20, 10, 0, 0, 10);
INSERT INTO `customerbillclear` VALUES ('HY617059', 'KH060624', 0, '2000-01-24', '??', 0, 10, 0, 20, 10, 0, 0, 10);
INSERT INTO `customerbillclear` VALUES ('HY756664', 'KH001722', 0, '2000-10-10', '??', 0, 0, 20, 20, 20, 0, 0, 40);

-- ----------------------------
-- Table structure for customerinfo
-- ----------------------------
DROP TABLE IF EXISTS `customerinfo`;
CREATE TABLE `customerinfo`  (
  `customer_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enterprise_property` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enterprise_size` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fax` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `linkman` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `linkman_mobile` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `post_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`customer_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customerinfo
-- ----------------------------
INSERT INTO `customerinfo` VALUES ('KH001722', '?????????', '????4', '??', '13959239995@11.com', '???', '20', '26737126', '??', '13959239991', '13959239999', '110220');
INSERT INTO `customerinfo` VALUES ('KH060624', '?????????', '????2', '??', '13959239992@11.com', '???', '2000', '26737124', '??', '13959239992', '13959239996', '110220');
INSERT INTO `customerinfo` VALUES ('KH447703', '?????????', '????3', '??', '13959239994@11.com', '??', '30', '26737125', '??', '13959239991', '13959239999', '320220');
INSERT INTO `customerinfo` VALUES ('KH794771', '?????????', '????1', '??', '13959239997@11.com', '??', '10', '26737123', '??', '13959239992', '13959239996', '320220');

-- ----------------------------
-- Table structure for customerreceiptinfo
-- ----------------------------
DROP TABLE IF EXISTS `customerreceiptinfo`;
CREATE TABLE `customerreceiptinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carry_bill_event_id` int(11) NOT NULL,
  `check_goods_record` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_bill_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receive_goods_date` date NULL DEFAULT NULL,
  `receive_goods_person` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customerreceiptinfo
-- ----------------------------

-- ----------------------------
-- Table structure for driveramount
-- ----------------------------
DROP TABLE IF EXISTS `driveramount`;
CREATE TABLE `driveramount`  (
  `driver_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `add_carriage_total` double NOT NULL,
  `carry_fee_total` double NOT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`driver_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of driveramount
-- ----------------------------
INSERT INTO `driveramount` VALUES ('', 0, 0, 1);
INSERT INTO `driveramount` VALUES ('SJ058684', 0, 12, 6);
INSERT INTO `driveramount` VALUES ('SJ066265', 10, 10, 1);

-- ----------------------------
-- Table structure for driverclear
-- ----------------------------
DROP TABLE IF EXISTS `driverclear`;
CREATE TABLE `driverclear`  (
  `back_bill_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `add_carriage` double NULL DEFAULT NULL,
  `balance` double NULL DEFAULT NULL,
  `balance_time` date NULL DEFAULT NULL,
  `balance_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bind_insurance` double NULL DEFAULT NULL,
  `carry_fee` double NULL DEFAULT NULL,
  `dispatch_service_fee` double NULL DEFAULT NULL,
  `driver_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `insurance` double NULL DEFAULT NULL,
  `need_payment` double NULL DEFAULT NULL,
  `payed_money` double NULL DEFAULT NULL,
  `prepay_money` double NULL DEFAULT NULL,
  PRIMARY KEY (`back_bill_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of driverclear
-- ----------------------------
INSERT INTO `driverclear` VALUES ('HZ328676', 0, 9, '2020-12-30', '??', 1, 10, 1, 'SJ058684', 1, 13, 2, 11);
INSERT INTO `driverclear` VALUES ('HZ328677', 0, -1, '2020-12-29', '??', 1, 0, 1, 'SJ058684', 1, 3, 2, 1);
INSERT INTO `driverclear` VALUES ('HZ328678', 0, 5, '2000-01-01', '??', 3, 2, 4, 'SJ058684', 6, 0, 0, 1);
INSERT INTO `driverclear` VALUES ('HZ328679', 0, -9, '2020-12-25', '??', 3, 0, 4, 'SJ058684', 6, 13, 12, 1);
INSERT INTO `driverclear` VALUES ('HZ328680', 0, -11, '2020-12-11', '??', 5, 0, 6, 'SJ058684', 8, 19, 16, 3);
INSERT INTO `driverclear` VALUES ('HZ328683', 10, 3, '2020-12-30', '??', 3, 10, 4, 'SJ066265', 6, 20, 20, 1);
INSERT INTO `driverclear` VALUES ('HZ854408', 0, 0, NULL, '??', 0, 0, 0, '', 20, 0, 0, 0);
INSERT INTO `driverclear` VALUES ('HZ855889', 0, -20, '2020-12-24', '??', 0, 0, 0, 'SJ058684', 20, 0, 20, 0);

-- ----------------------------
-- Table structure for driverinfo
-- ----------------------------
DROP TABLE IF EXISTS `driverinfo`;
CREATE TABLE `driverinfo`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `allow_carry_volume` double NULL DEFAULT NULL,
  `allow_carry_weight` double NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `biz_licence` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_dept` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_dept_tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_frame_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_length` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_width` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company_car` bit(1) NOT NULL,
  `drive_licence` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `driver_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `engine_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_height` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id_card` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `insurance_card` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `run_licence` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of driverinfo
-- ----------------------------
INSERT INTO `driverinfo` VALUES ('SJ058684', '?????????', 20, 20, '2020-12-10', '10', '??', '13959239995', '010', '10', '?A88885', 'c2', '10', b'1', '10', '????2', '10', '?', '10', '130425198708092081', '1', '13959239993', '??2', '10', '??');
INSERT INTO `driverinfo` VALUES ('SJ066265', '?????????', 20, 20, '2020-12-17', '100000', '??', '13959239992', '100000', '10', '?A88888', 'c1', '10', b'1', '100000', '????1', '100000', '?', '10', '130425198708092058', '100000', '13959239991', '??1', '100000', '??');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `employee_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birthday` date NULL DEFAULT NULL,
  `department` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employee_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`employee_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('GL315898', '2020-12-24', '???', '??', '?', '???');
INSERT INTO `employee` VALUES ('GL941974', '2020-12-24', '???', '??', '?', '??');

-- ----------------------------
-- Table structure for employeeuser
-- ----------------------------
DROP TABLE IF EXISTS `employeeuser`;
CREATE TABLE `employeeuser`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employeeuser
-- ----------------------------

-- ----------------------------
-- Table structure for employeewage
-- ----------------------------
DROP TABLE IF EXISTS `employeewage`;
CREATE TABLE `employeewage`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `allowance` double NOT NULL,
  `basic_wage` double NOT NULL,
  `date` date NULL DEFAULT NULL,
  `employee` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employee_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `station_wage` double NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employeewage
-- ----------------------------
INSERT INTO `employeewage` VALUES (1, 100, 2000, '2020-12-21', '??', 'GL315898', 100);
INSERT INTO `employeewage` VALUES (2, 10000, 100000, '2020-12-24', '??', 'GL315898', 100000);
INSERT INTO `employeewage` VALUES (3, 100, 100, '2020-12-24', '??', 'GL315898', 100);

-- ----------------------------
-- Table structure for extraclear
-- ----------------------------
DROP TABLE IF EXISTS `extraclear`;
CREATE TABLE `extraclear`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `balance_date` date NULL DEFAULT NULL,
  `balance_money` double NULL DEFAULT NULL,
  `balance_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subject_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of extraclear
-- ----------------------------
INSERT INTO `extraclear` VALUES (1, '2020-12-06', 1, '1', '1', '1');
INSERT INTO `extraclear` VALUES (2, '2020-12-01', 20, '??', '?', '??');
INSERT INTO `extraclear` VALUES (3, '2020-12-08', 1000, '??', '?', '??');
INSERT INTO `extraclear` VALUES (4, '2020-12-24', 10000, '??', '?', '??');

-- ----------------------------
-- Table structure for extraincome
-- ----------------------------
DROP TABLE IF EXISTS `extraincome`;
CREATE TABLE `extraincome`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `income_month` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` double NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `write_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of extraincome
-- ----------------------------
INSERT INTO `extraincome` VALUES (1, '2020-12', 1111, 'sdfa', '2020-12-23');
INSERT INTO `extraincome` VALUES (2, '2020-12', 111, 'fdsd', '2020-12-24');
INSERT INTO `extraincome` VALUES (3, '2020-12', 100000, '??', '2020-12-24');

-- ----------------------------
-- Table structure for financefee
-- ----------------------------
DROP TABLE IF EXISTS `financefee`;
CREATE TABLE `financefee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fee` double NOT NULL,
  `payout_month` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `write_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of financefee
-- ----------------------------
INSERT INTO `financefee` VALUES (1, 200, '2020-12', '2020-12-21');
INSERT INTO `financefee` VALUES (2, 20000, '2020-12', '2020-12-24');
INSERT INTO `financefee` VALUES (3, 1000, '2020-12', '2020-12-24');

-- ----------------------------
-- Table structure for function_
-- ----------------------------
DROP TABLE IF EXISTS `function_`;
CREATE TABLE `function_`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `page_function` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `page_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of function_
-- ----------------------------
INSERT INTO `function_` VALUES (1, NULL, '????');
INSERT INTO `function_` VALUES (2, NULL, '????');
INSERT INTO `function_` VALUES (3, NULL, '????');
INSERT INTO `function_` VALUES (4, NULL, '????');
INSERT INTO `function_` VALUES (5, NULL, '????');
INSERT INTO `function_` VALUES (6, NULL, '????');
INSERT INTO `function_` VALUES (7, NULL, '????');
INSERT INTO `function_` VALUES (8, NULL, '????');
INSERT INTO `function_` VALUES (9, NULL, '????');
INSERT INTO `function_` VALUES (10, NULL, '????');
INSERT INTO `function_` VALUES (11, NULL, '????');

-- ----------------------------
-- Table structure for functionwithgroup
-- ----------------------------
DROP TABLE IF EXISTS `functionwithgroup`;
CREATE TABLE `functionwithgroup`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `function_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of functionwithgroup
-- ----------------------------
INSERT INTO `functionwithgroup` VALUES (1, 1, 1);
INSERT INTO `functionwithgroup` VALUES (2, 2, 1);
INSERT INTO `functionwithgroup` VALUES (3, 3, 1);
INSERT INTO `functionwithgroup` VALUES (4, 4, 1);
INSERT INTO `functionwithgroup` VALUES (5, 5, 1);
INSERT INTO `functionwithgroup` VALUES (6, 6, 1);
INSERT INTO `functionwithgroup` VALUES (7, 7, 1);
INSERT INTO `functionwithgroup` VALUES (8, 8, 1);
INSERT INTO `functionwithgroup` VALUES (9, 9, 1);
INSERT INTO `functionwithgroup` VALUES (10, 10, 1);
INSERT INTO `functionwithgroup` VALUES (11, 11, 1);
INSERT INTO `functionwithgroup` VALUES (12, 1, 2);
INSERT INTO `functionwithgroup` VALUES (13, 2, 2);
INSERT INTO `functionwithgroup` VALUES (14, 3, 2);
INSERT INTO `functionwithgroup` VALUES (15, 1, 3);
INSERT INTO `functionwithgroup` VALUES (16, 2, 3);
INSERT INTO `functionwithgroup` VALUES (17, 4, 2);
INSERT INTO `functionwithgroup` VALUES (18, 5, 2);
INSERT INTO `functionwithgroup` VALUES (19, 6, 2);
INSERT INTO `functionwithgroup` VALUES (20, 7, 2);

-- ----------------------------
-- Table structure for goodsbill
-- ----------------------------
DROP TABLE IF EXISTS `goodsbill`;
CREATE TABLE `goodsbill`  (
  `goods_bill_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `accept_procedure_rate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `accept_station` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `carriage` double NULL DEFAULT NULL,
  `carry_goods_fee` double NULL DEFAULT NULL,
  `employee_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fact_deal_date` date NULL DEFAULT NULL,
  `fetch_goods_mode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `help_accept_payment` double NULL DEFAULT NULL,
  `if_audit` bit(1) NULL DEFAULT NULL,
  `if_settle_accounts` bit(1) NULL DEFAULT NULL,
  `insurance` double NULL DEFAULT NULL,
  `money_of_change_pay` double NULL DEFAULT NULL,
  `pay_kickback` double NULL DEFAULT NULL,
  `pay_mode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `predelivery_date` date NULL DEFAULT NULL,
  `receive_goods_addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receive_goods_customer` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receive_goods_customer_addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receive_goods_customer_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receive_goods_customer_tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reduce_fund` double NULL DEFAULT NULL,
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `send_goods_addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `send_goods_customer` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `send_goods_customer_addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `send_goods_customer_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `send_goods_customer_tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `send_goods_date` date NULL DEFAULT NULL,
  `transfer_fee` double NULL DEFAULT NULL,
  `transfer_station` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `validity` bit(1) NULL DEFAULT NULL,
  `write_bill_person` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `write_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`goods_bill_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodsbill
-- ----------------------------
INSERT INTO `goodsbill` VALUES ('HY340660', '1', '???', 20, 20, 'GL846489', '2020-12-20', '????', 20, b'1', b'0', 20, 0, 0, '???', '2020-12-11', '???', '????3', '?????????', 'KH447703', '13959239999', 0, '?', '???', '????2', '?????????', 'KH060624', '13959239996', '2020-12-20', 2.6, '??,??', b'1', 'GL846489', '2020-12-20');
INSERT INTO `goodsbill` VALUES ('HY424342', '0', '???', 20, 10, 'GL846489', '2020-12-02', '????', 0, b'0', b'0', 0, 0, 0, '???', '2020-12-24', '?????????sss', '????2', '?????????', 'KH060624', '13959239996', 0, '?', '?????????', '????4', '?????????', 'KH001722', '13959239999', '2020-12-24', 3.9000000000000004, '??,??,??', b'0', 'GL846489', '2020-12-24');
INSERT INTO `goodsbill` VALUES ('HY617055', '10', '????', 20, 0, 'GL846489', '2020-12-19', '????', 10, b'1', b'0', 20, 0, 0, '???', '2020-12-31', '???', '????3', '?????????', 'KH447703', '13959239999', 10, '???', '???', '????2', '?????????', 'KH060624', '13959239996', '2020-12-15', 0, '', b'1', 'GL846489', '2020-12-15');
INSERT INTO `goodsbill` VALUES ('HY617056', '10', '????', 20, 0, 'GL846489', '2020-12-20', '????', 10, b'1', b'0', 20, 0, 0, '???', '2020-12-31', '???', '????3', '?????????', 'KH447703', '13959239999', 10, '???', '???', '????2', '?????????', 'KH060624', '13959239996', '2020-12-15', 1.3, '', b'1', 'GL846489', '2020-12-15');
INSERT INTO `goodsbill` VALUES ('HY617057', '10', '????', 20, 0, 'GL846489', '2020-12-24', '????', 10, b'1', b'0', 20, 0, 0, '???', '2020-12-31', '???', '????3', '?????????', 'KH447703', '13959239999', 10, '???', '???', '????2', '?????????', 'KH060624', '13959239996', '2020-12-15', 0, '', b'1', 'GL846489', '2020-12-15');
INSERT INTO `goodsbill` VALUES ('HY617058', '10', '????', 20, 0, 'GL846489', '2020-12-19', '????', 10, b'1', b'0', 20, 0, 0, '???', '2020-12-31', '???', '????3', '?????????', 'KH447703', '13959239999', 10, '???', '???', '????2', '?????????', 'KH060624', '13959239996', '2020-12-15', 1.3, '', b'1', 'GL846489', '2020-12-15');
INSERT INTO `goodsbill` VALUES ('HY617059', '10', '????', 20, 0, 'GL846489', '2020-12-19', '????', 10, b'1', b'0', 20, 0, 0, '???', '2020-12-31', '???', '????3', '?????????', 'KH447703', '13959239999', 10, '???', '???', '????2', '?????????', 'KH060624', '13959239996', '2020-12-15', 1.3, '', b'1', 'GL846489', '2020-12-15');
INSERT INTO `goodsbill` VALUES ('HY617060', '10', '????', 20, 0, 'GL846489', NULL, '????', 10, b'1', b'0', 20, 0, 0, '???', '2020-12-31', '???', '????3', '?????????', 'KH447703', '13959239999', 10, '???', '???', '????2', '?????????', 'KH060624', '13959239996', '2020-12-15', 1.3, '', b'1', 'GL846489', '2020-12-15');
INSERT INTO `goodsbill` VALUES ('HY617061', '10', '????', 20, 0, 'GL846489', NULL, '????', 10, b'1', b'0', 20, 0, 0, '???', '2020-12-31', '???', '????3', '?????????', 'KH447703', '13959239999', 10, '???', '???', '????2', '?????????', 'KH060624', '13959239996', '2020-12-15', 1.3, '', b'1', 'GL846489', '2020-12-15');
INSERT INTO `goodsbill` VALUES ('HY617062', '10', '????', 20, 0, 'GL846489', NULL, '????', 10, b'1', b'0', 20, 0, 0, '???', '2020-12-31', '???', '????3', '?????????', 'KH447703', '13959239999', 10, '???', '???', '????2', '?????????', 'KH060624', '13959239996', '2020-12-15', 2.6, '??,??', b'1', 'GL846489', '2020-12-15');
INSERT INTO `goodsbill` VALUES ('HY756664', '10', '???', 20, 20, 'GL846489', '2020-12-24', '????', 10, b'0', b'0', 20, 0, 0, '???', '2020-12-08', '?????????', '????4', '?????????', 'KH001722', '13959239999', 0, '?', '?????????', '????4', '?????????', 'KH001722', '13959239999', '2020-12-24', 3.9000000000000004, '??,??,??', b'0', 'GL846489', '2020-12-24');

-- ----------------------------
-- Table structure for goodsbillevent
-- ----------------------------
DROP TABLE IF EXISTS `goodsbillevent`;
CREATE TABLE `goodsbillevent`  (
  `goods_bill_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `event_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `occur_time` datetime(6) NULL DEFAULT NULL,
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`goods_bill_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodsbillevent
-- ----------------------------
INSERT INTO `goodsbillevent` VALUES ('HY340660', '????', '2020-12-20 09:13:01.410000', '????');
INSERT INTO `goodsbillevent` VALUES ('HY424342', '??', '2020-12-24 19:10:04.958000', '????');
INSERT INTO `goodsbillevent` VALUES ('HY617055', '????', '2020-12-19 11:37:59.306000', '????');
INSERT INTO `goodsbillevent` VALUES ('HY617056', '????', '2020-12-20 09:07:34.066000', '????');
INSERT INTO `goodsbillevent` VALUES ('HY617057', '??', '2020-12-24 16:43:08.472000', '????');
INSERT INTO `goodsbillevent` VALUES ('HY617058', '????', '2020-12-19 20:07:15.402000', '????');
INSERT INTO `goodsbillevent` VALUES ('HY617059', '????', '2020-12-19 20:07:18.970000', '????');
INSERT INTO `goodsbillevent` VALUES ('HY617060', '??', '2020-12-19 09:49:20.192000', '????');
INSERT INTO `goodsbillevent` VALUES ('HY617061', '??', '2020-12-19 09:53:33.044000', '????');
INSERT INTO `goodsbillevent` VALUES ('HY617062', '??', '2020-12-19 09:53:42.391000', '????');
INSERT INTO `goodsbillevent` VALUES ('HY756664', '??', '2020-12-24 19:10:23.590000', '????');

-- ----------------------------
-- Table structure for goodsreceiptinfo
-- ----------------------------
DROP TABLE IF EXISTS `goodsreceiptinfo`;
CREATE TABLE `goodsreceiptinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `check_goods_record` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `driver_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_revert_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rceive_goods_date` date NULL DEFAULT NULL,
  `receive_goods_person` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodsreceiptinfo
-- ----------------------------
INSERT INTO `goodsreceiptinfo` VALUES (1, '22', '', 'HZ328676', '2020-12-19', '????3');
INSERT INTO `goodsreceiptinfo` VALUES (2, '22', '', 'HZ328679', '2020-12-19', '????3');
INSERT INTO `goodsreceiptinfo` VALUES (3, '22', '', 'HZ328680', '2020-12-19', '????3');
INSERT INTO `goodsreceiptinfo` VALUES (4, '111', '', 'HZ328677', '2020-12-20', '????3');
INSERT INTO `goodsreceiptinfo` VALUES (5, '1111', '', 'HZ855889', '2020-12-20', '????3');
INSERT INTO `goodsreceiptinfo` VALUES (6, 'sss', '??', 'HZ328678', '2020-12-24', '????3');
INSERT INTO `goodsreceiptinfo` VALUES (7, 'sss', '??', 'HZ854408', '2020-12-24', '????4');

-- ----------------------------
-- Table structure for incomemonthlytemp
-- ----------------------------
DROP TABLE IF EXISTS `incomemonthlytemp`;
CREATE TABLE `incomemonthlytemp`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `biz_fee` double NOT NULL,
  `biz_income` double NOT NULL,
  `car_carriage` double NOT NULL,
  `carriage_money` double NOT NULL,
  `convey_wage` double NOT NULL,
  `finance_fee` double NOT NULL,
  `house_rent` double NOT NULL,
  `income` double NOT NULL,
  `insurance_money` double NOT NULL,
  `manage_fee` double NOT NULL,
  `month` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `office_fee` double NOT NULL,
  `other` double NOT NULL,
  `payout` double NOT NULL,
  `phone_fee` double NOT NULL,
  `profit` double NOT NULL,
  `unbiz_income` double NOT NULL,
  `wage` double NOT NULL,
  `water_elec_fee` double NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of incomemonthlytemp
-- ----------------------------
INSERT INTO `incomemonthlytemp` VALUES (1, 500, 260, 500, 177, 0, 21200, 101, 101482, 83, 4405, '2020-12', 101, 4101, 234605, 1, -133123, 101222, 212500, 101);

-- ----------------------------
-- Table structure for lineoverall
-- ----------------------------
DROP TABLE IF EXISTS `lineoverall`;
CREATE TABLE `lineoverall`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `all_carriage_total` double NOT NULL,
  `deal_goods_station` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `insurance_total` double NOT NULL,
  `load_station` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `times` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lineoverall
-- ----------------------------
INSERT INTO `lineoverall` VALUES (1, 26, '??', 30, '??', 5);
INSERT INTO `lineoverall` VALUES (2, 40, '??', 20, '??', 2);
INSERT INTO `lineoverall` VALUES (3, 105, '??', 26, '??', 2);
INSERT INTO `lineoverall` VALUES (4, 1, '??', 1, '??', 1);
INSERT INTO `lineoverall` VALUES (5, 5, '??', 6, '??', 1);

-- ----------------------------
-- Table structure for managefee
-- ----------------------------
DROP TABLE IF EXISTS `managefee`;
CREATE TABLE `managefee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `house_rent` double NOT NULL,
  `office_fee` double NOT NULL,
  `other_payout` double NOT NULL,
  `payout_month` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone_fee` double NOT NULL,
  `water_elec_fee` double NOT NULL,
  `write_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of managefee
-- ----------------------------
INSERT INTO `managefee` VALUES (1, 20000, 2000, 200, '2020-01', 1000, 1000, '2020-12-01');
INSERT INTO `managefee` VALUES (2, 100, 100, 4100, '2020-12', 0, 100, '2020-12-24');
INSERT INTO `managefee` VALUES (3, 1, 1, 1, '2020-12', 1, 1, '2020-12-24');

-- ----------------------------
-- Table structure for proxyfeeclear
-- ----------------------------
DROP TABLE IF EXISTS `proxyfeeclear`;
CREATE TABLE `proxyfeeclear`  (
  `goods_bill_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `account_receivable` double NULL DEFAULT NULL,
  `balance_date` date NULL DEFAULT NULL,
  `commision_rate` float NULL DEFAULT NULL,
  `commision_receivable` double NULL DEFAULT NULL,
  `customer_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fact_receive_fund` double NULL DEFAULT NULL,
  `goods_pay_change` double NULL DEFAULT NULL,
  `received_commision` double NULL DEFAULT NULL,
  PRIMARY KEY (`goods_bill_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of proxyfeeclear
-- ----------------------------
INSERT INTO `proxyfeeclear` VALUES ('HY340660', 0, '2020-12-15', 0.02, 0.3999999910593033, 'KH060624', 20, -20, 0);
INSERT INTO `proxyfeeclear` VALUES ('HY617055', 0, '2020-12-15', 0.02, -9.800000004470348, 'KH060624', 10, -10, 10);
INSERT INTO `proxyfeeclear` VALUES ('HY617056', 0, '2020-12-10', 0.02, 10, 'KH060624', 10, -10, -9.800000004470348);
INSERT INTO `proxyfeeclear` VALUES ('HY617057', 0, NULL, 0.02, 0, 'KH060624', 10, -10, 0);
INSERT INTO `proxyfeeclear` VALUES ('HY617058', 0, '2020-12-09', 0.02, -9.800000004470348, 'KH060624', 10, -10, 10);
INSERT INTO `proxyfeeclear` VALUES ('HY617059', 0, NULL, 0.02, 0, 'KH060624', 10, -10, 0);
INSERT INTO `proxyfeeclear` VALUES ('HY756664', 0, NULL, 0.02, 0, 'KH001722', 10, -10, 0);

-- ----------------------------
-- Table structure for region
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of region
-- ----------------------------
INSERT INTO `region` VALUES (1, '??');
INSERT INTO `region` VALUES (2, '??');
INSERT INTO `region` VALUES (3, '??');
INSERT INTO `region` VALUES (4, '??');
INSERT INTO `region` VALUES (5, '??');
INSERT INTO `region` VALUES (6, '??');

-- ----------------------------
-- Table structure for routeinfo
-- ----------------------------
DROP TABLE IF EXISTS `routeinfo`;
CREATE TABLE `routeinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `distance` double NOT NULL,
  `end_station` int(11) NULL DEFAULT NULL,
  `fetch_time` double NOT NULL,
  `pass_station` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_station` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of routeinfo
-- ----------------------------
INSERT INTO `routeinfo` VALUES (1, 300, 2, 3, '4,5', 1);
INSERT INTO `routeinfo` VALUES (2, 200, 5, 2, '4', 1);
INSERT INTO `routeinfo` VALUES (3, 100, 4, 1, '', 1);
INSERT INTO `routeinfo` VALUES (4, 300, 2, 3, '4,5', 3);
INSERT INTO `routeinfo` VALUES (5, 200, 5, 2, '4', 3);
INSERT INTO `routeinfo` VALUES (6, 100, 4, 1, '', 3);
INSERT INTO `routeinfo` VALUES (7, 200, 2, 2, '5', 4);
INSERT INTO `routeinfo` VALUES (8, 100, 5, 1, '', 4);
INSERT INTO `routeinfo` VALUES (9, 100, 2, 1, '', 5);
INSERT INTO `routeinfo` VALUES (10, 400, 2, 4, '3,4,5', 6);
INSERT INTO `routeinfo` VALUES (11, 300, 5, 3, '3,4', 6);
INSERT INTO `routeinfo` VALUES (12, 200, 4, 2, '3', 6);
INSERT INTO `routeinfo` VALUES (13, 100, 3, 1, '', 6);

-- ----------------------------
-- Table structure for sentlist
-- ----------------------------
DROP TABLE IF EXISTS `sentlist`;
CREATE TABLE `sentlist`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `back_cost` double NOT NULL,
  `car_card_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cash_pay` double NOT NULL,
  `driver_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_revert_bill_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `help_accept_fund` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pickup_pay` double NOT NULL,
  `piece_amount` int(11) NOT NULL,
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `send_goods_customer` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `send_goods_customer_tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `transfer_destination` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sentlist
-- ----------------------------

-- ----------------------------
-- Table structure for transfercominfo
-- ----------------------------
DROP TABLE IF EXISTS `transfercominfo`;
CREATE TABLE `transfercominfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detail_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `link_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of transfercominfo
-- ----------------------------
INSERT INTO `transfercominfo` VALUES (1, '??', '??', '???', '10086');
INSERT INTO `transfercominfo` VALUES (2, '??', '??', '???', '10010');
INSERT INTO `transfercominfo` VALUES (3, '??', '??', '???', '100101');
INSERT INTO `transfercominfo` VALUES (4, '??', 'sss', 'ss', '12345678910');
INSERT INTO `transfercominfo` VALUES (5, '??', 'sss', '????', '12345678910');

-- ----------------------------
-- Table structure for transferinfo
-- ----------------------------
DROP TABLE IF EXISTS `transferinfo`;
CREATE TABLE `transferinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `after_transfer_bill` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `check_time` date NULL DEFAULT NULL,
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_bill_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `transfer_addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `transfer_check` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `transfer_company` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `transfer_fee` double NULL DEFAULT NULL,
  `transfer_station` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `transfer_station_tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of transferinfo
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `login_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `if_online` bit(1) NULL DEFAULT b'0',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`login_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('GL180060', b'0', 'E10ADC3949BA59ABBE56E057F20F883E');
INSERT INTO `user` VALUES ('GL846489', b'1', '111');
INSERT INTO `user` VALUES ('SJ058684', b'1', 'SJ058684');

-- ----------------------------
-- Table structure for usergroup
-- ----------------------------
DROP TABLE IF EXISTS `usergroup`;
CREATE TABLE `usergroup`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `group_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usergroup
-- ----------------------------
INSERT INTO `usergroup` VALUES (1, '??????????\n2. ', '???');
INSERT INTO `usergroup` VALUES (2, '??????????????', '???');
INSERT INTO `usergroup` VALUES (3, '????', '???');
INSERT INTO `usergroup` VALUES (4, '??????????????????????????????????????', '???');
INSERT INTO `usergroup` VALUES (5, '?????????????????', '???');
INSERT INTO `usergroup` VALUES (6, '?????', '???');
INSERT INTO `usergroup` VALUES (7, '???', '???');

-- ----------------------------
-- Table structure for userwithgroup
-- ----------------------------
DROP TABLE IF EXISTS `userwithgroup`;
CREATE TABLE `userwithgroup`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userwithgroup
-- ----------------------------
INSERT INTO `userwithgroup` VALUES (1, 1, 'GL846489');
INSERT INTO `userwithgroup` VALUES (3, 2, 'GL180060');
INSERT INTO `userwithgroup` VALUES (6, 2, 'GL991035');
INSERT INTO `userwithgroup` VALUES (8, 1, 'GL941974');

SET FOREIGN_KEY_CHECKS = 1;
