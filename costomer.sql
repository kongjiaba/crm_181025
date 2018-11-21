/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MariaDB
 Source Server Version : 100307
 Source Host           : localhost:3306
 Source Schema         : costomer

 Target Server Type    : MariaDB
 Target Server Version : 100307
 File Encoding         : 65001

 Date: 21/11/2018 21:53:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_dict
-- ----------------------------
DROP TABLE IF EXISTS `base_dict`;
CREATE TABLE `base_dict`  (
  `dict_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据字典id(主键)',
  `dict_type_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据字典类别代码',
  `dict_type_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据字典类别名称',
  `dict_item_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据字典项目代码',
  `dict_item_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据字典项目名称',
  `dict_sort` int(10) NULL DEFAULT NULL COMMENT '排序字段',
  `dict_enable` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '1：使用 0：停用',
  `dict_memo` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_dict
-- ----------------------------
INSERT INTO `base_dict` VALUES ('1', '001', '客户行业', NULL, '教育培训', 1, '1', NULL);
INSERT INTO `base_dict` VALUES ('10', '003', '公司性质', NULL, '名企', 3, '1', NULL);
INSERT INTO `base_dict` VALUES ('12', '004', '年营业额', NULL, '1-10万', 1, '1', NULL);
INSERT INTO `base_dict` VALUES ('13', '004', '年营业额', NULL, '10-20万', 2, '1', NULL);
INSERT INTO `base_dict` VALUES ('14', '004', '年营业额', NULL, '20-50万', 3, '1', NULL);
INSERT INTO `base_dict` VALUES ('15', '004', '年营业额', NULL, '50-100万', 4, '1', NULL);
INSERT INTO `base_dict` VALUES ('16', '004', '年营业额', NULL, '100-500万', 5, '1', NULL);
INSERT INTO `base_dict` VALUES ('17', '004', '年营业额', NULL, '1-10万', 6, '1', NULL);
INSERT INTO `base_dict` VALUES ('18', '005', '客户状态', NULL, '基础客户', 1, '1', NULL);
INSERT INTO `base_dict` VALUES ('19', '005', '客户状态', NULL, '潜在客户', 2, '1', NULL);
INSERT INTO `base_dict` VALUES ('2', '001', '客户行业', NULL, '电子商务', 2, '1', NULL);
INSERT INTO `base_dict` VALUES ('20', '005', '客户状态', NULL, '成功客户', 3, '1', NULL);
INSERT INTO `base_dict` VALUES ('21', '005', '客户状态', NULL, '无效客户', 4, '1', NULL);
INSERT INTO `base_dict` VALUES ('22', '006', '客户级别', NULL, '普通用户', 1, '1', NULL);
INSERT INTO `base_dict` VALUES ('23', '006', '客户级别', NULL, 'VIP用户', 2, '1', NULL);
INSERT INTO `base_dict` VALUES ('24', '007', '商机状态', NULL, '意向客户', 1, '1', NULL);
INSERT INTO `base_dict` VALUES ('25', '007', '商机状态', NULL, '初步沟通', 2, '1', NULL);
INSERT INTO `base_dict` VALUES ('26', '007', '商机状态', NULL, '深度沟通', 3, '1', NULL);
INSERT INTO `base_dict` VALUES ('27', '007', '商机状态', NULL, '签订合同', 4, '1', NULL);
INSERT INTO `base_dict` VALUES ('3', '001', '客户行业', NULL, '对外贸易', 3, '1', NULL);
INSERT INTO `base_dict` VALUES ('30', '008', '商机类型', NULL, '新业务', 1, '1', NULL);
INSERT INTO `base_dict` VALUES ('31', '008', '商机类型', NULL, '现有业务', 2, '1', NULL);
INSERT INTO `base_dict` VALUES ('32', '009', '商机来源', NULL, '电话英雄啊', 1, '1', NULL);
INSERT INTO `base_dict` VALUES ('33', '009', '商机来源', NULL, '网络营销', 2, '1', NULL);
INSERT INTO `base_dict` VALUES ('34', '009', '商机来源', NULL, '推广活动', 3, '1', NULL);
INSERT INTO `base_dict` VALUES ('4', '001', '客户行业', NULL, '酒店旅游', 4, '1', NULL);
INSERT INTO `base_dict` VALUES ('5', '001', '客户行业', NULL, '房地产', 5, '1', NULL);
INSERT INTO `base_dict` VALUES ('6', '002', '客户信息来源', NULL, '电话营销', 1, '1', NULL);
INSERT INTO `base_dict` VALUES ('7', '002', '客户信息来源', NULL, '网络营销', 2, '1', NULL);
INSERT INTO `base_dict` VALUES ('8', '003', '公司性质', NULL, '合资', 1, '1', NULL);
INSERT INTO `base_dict` VALUES ('9', '003', '公司性质', NULL, '国企', 2, '1', NULL);

-- ----------------------------
-- Table structure for cst_customer
-- ----------------------------
DROP TABLE IF EXISTS `cst_customer`;
CREATE TABLE `cst_customer`  (
  `cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `cust_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户名称',
  `cust_source` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户信息来源',
  `cust_industry` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户所属行业',
  `cust_level` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户级别',
  `cust_address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户联系地址',
  `cust_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户联系电话',
  PRIMARY KEY (`cust_id`) USING BTREE,
  INDEX `FKrty52nvbjg1echf0se39eng49`(`cust_level`) USING BTREE,
  INDEX `FKeh5g36duab8g1h051pdjfwcgd`(`cust_source`) USING BTREE,
  CONSTRAINT `FKeh5g36duab8g1h051pdjfwcgd` FOREIGN KEY (`cust_source`) REFERENCES `base_dict` (`dict_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKrty52nvbjg1echf0se39eng49` FOREIGN KEY (`cust_level`) REFERENCES `base_dict` (`dict_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cst_customer
-- ----------------------------
INSERT INTO `cst_customer` VALUES (1, '三星', '7', '家电', '23', '三里屯', '123456789');
INSERT INTO `cst_customer` VALUES (2, '里斯', '7', '工业', '23', '三里屯', '123456789');
INSERT INTO `cst_customer` VALUES (3, '洛基亚', '7', '家电', '23', '三里屯', '123456789');
INSERT INTO `cst_customer` VALUES (4, 'vivo', '7', '家电', '23', '三里屯', '123456789');
INSERT INTO `cst_customer` VALUES (12, '步步高', '7', '家电', '23', '嘎嘎嘎', '13155588555');
INSERT INTO `cst_customer` VALUES (13, 'apple', '7', '家电', '23', '急急急', '13155588555');
INSERT INTO `cst_customer` VALUES (14, '华为1', '7', '家电', '23', '哈哈哈', '12445485');
INSERT INTO `cst_customer` VALUES (15, '小米plus', '7', '建材', '22', '哈哈哈哈', '11111');
INSERT INTO `cst_customer` VALUES (16, '金立', '7', '建材', '23', '深圳', '444444');
INSERT INTO `cst_customer` VALUES (17, '华为2', '6', '五金', '22', '', '');
INSERT INTO `cst_customer` VALUES (18, '华为3', '6', '家电', '22', '', '');
INSERT INTO `cst_customer` VALUES (19, '华为4', '6', '家电', '22', '', '');
INSERT INTO `cst_customer` VALUES (20, '华为5', '6', '家电', '22', '', '');
INSERT INTO `cst_customer` VALUES (21, '华为6', '6', '家电', '22', '', '');
INSERT INTO `cst_customer` VALUES (22, '华为7', '6', '家电', '22', '', '');
INSERT INTO `cst_customer` VALUES (23, '华为8', '6', '家电', '22', '', '');
INSERT INTO `cst_customer` VALUES (24, '华为9', '6', '家电', '22', '', '');
INSERT INTO `cst_customer` VALUES (25, '华为10', '6', '家电', '22', '', '');
INSERT INTO `cst_customer` VALUES (26, '华为11', '6', '家电', '22', '', '');
INSERT INTO `cst_customer` VALUES (27, '华为12', '6', '家电', '22', '', '');
INSERT INTO `cst_customer` VALUES (28, '华为13', '6', '家电', '22', '', '');
INSERT INTO `cst_customer` VALUES (29, '华为14', '6', '家电', '22', '', '');

-- ----------------------------
-- Table structure for cst_linkman
-- ----------------------------
DROP TABLE IF EXISTS `cst_linkman`;
CREATE TABLE `cst_linkman`  (
  `lkm_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '联系人id',
  `lkm_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人姓名',
  `lkm_gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人性别',
  `lkm_phone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人办公电话',
  `lkm_mobile` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人手机',
  `lkm_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人邮箱',
  `lkm_position` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人职位',
  `lkm_memo` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人备注',
  `lkm_cust_id` bigint(32) NOT NULL COMMENT '客户编号',
  `customerEntity` tinyblob NULL,
  PRIMARY KEY (`lkm_id`) USING BTREE,
  INDEX `FKh9yp1nql5227xxcopuxqx2e7q`(`lkm_cust_id`) USING BTREE,
  CONSTRAINT `FKh9yp1nql5227xxcopuxqx2e7q` FOREIGN KEY (`lkm_cust_id`) REFERENCES `cst_customer` (`cust_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 111 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cst_linkman
-- ----------------------------
INSERT INTO `cst_linkman` VALUES (100, '张三', '1', '123456789', '123456789', 'qq.com', 'Java开发', 'test', 1, NULL);
INSERT INTO `cst_linkman` VALUES (101, '王麻子', '1', '444444', '444444', '', '经理', '', 3, NULL);
INSERT INTO `cst_linkman` VALUES (102, '李四', '1', '444444', '444444', '', '经理', '', 2, NULL);
INSERT INTO `cst_linkman` VALUES (103, '哈哈哈', '1', '13155588555', '13155588555', '', '', '', 12, NULL);
INSERT INTO `cst_linkman` VALUES (104, '哈哈哈', '1', '13155588555', '13155588555', '', '', '', 12, NULL);
INSERT INTO `cst_linkman` VALUES (105, '哈哈哈', '1', '13155588555', '13155588555', '', '', '', 12, NULL);
INSERT INTO `cst_linkman` VALUES (106, '哈哈哈', '1', '13155588555', '13155588555', '', '', '', 12, NULL);
INSERT INTO `cst_linkman` VALUES (107, '换行', '1', '13155588555', '13155588555', '5', '经理', 'test', 13, NULL);
INSERT INTO `cst_linkman` VALUES (108, '小一', NULL, '12445485', '12445485', 'hdhfhh@jj.com', '', '', 4, NULL);
INSERT INTO `cst_linkman` VALUES (110, '金立', '0', '444444', '444444', 'jinli.163com', '', '', 16, NULL);

SET FOREIGN_KEY_CHECKS = 1;
