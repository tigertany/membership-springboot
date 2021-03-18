/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : membership

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 18/03/2021 11:39:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mem_card_extend
-- ----------------------------
DROP TABLE IF EXISTS `mem_card_extend`;
CREATE TABLE `mem_card_extend`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gender` int(11) NULL DEFAULT NULL COMMENT '1=男,0=女',
  `idcard` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `tax` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `creater` bigint(20) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `updater` bigint(20) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '1=删除,0=未删除',
  `deleter` bigint(20) NULL DEFAULT NULL,
  `deleted_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mem_card_info
-- ----------------------------
DROP TABLE IF EXISTS `mem_card_info`;
CREATE TABLE `mem_card_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `card_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `inner_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `tel` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL COMMENT '1=现金消费,2=次数消费,3=时段内消费',
  `face_money` decimal(18, 2) NULL DEFAULT NULL,
  `real_money` decimal(18, 2) NULL DEFAULT NULL,
  `face_times` decimal(18, 2) NULL DEFAULT NULL,
  `real_times` decimal(18, 2) NULL DEFAULT NULL,
  `balance` decimal(18, 2) NULL DEFAULT NULL,
  `balance_times` decimal(18, 2) NULL DEFAULT NULL,
  `expire` datetime(0) NULL DEFAULT NULL,
  `open_date` datetime(0) NULL DEFAULT NULL,
  `cardno_new` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `innerno_new` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL COMMENT '1=正常,2=挂失,3=遗失换新此卡作废',
  `creater` bigint(20) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `updater` bigint(20) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '1=删除,0=未删除',
  `deleter` bigint(20) NULL DEFAULT NULL,
  `deleted_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mem_card_record
-- ----------------------------
DROP TABLE IF EXISTS `mem_card_record`;
CREATE TABLE `mem_card_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `card_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `inner_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `card_uid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `money` decimal(18, 2) NULL DEFAULT NULL,
  `balance` decimal(18, 2) NULL DEFAULT NULL,
  `balance_times` decimal(18, 2) NULL DEFAULT NULL,
  `place_id` int(11) NULL DEFAULT NULL,
  `opr` bigint(20) NULL DEFAULT NULL,
  `opr_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mem_card_type
-- ----------------------------
DROP TABLE IF EXISTS `mem_card_type`;
CREATE TABLE `mem_card_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prefix` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '1=消费现金,2=消费次数,3=时段内任意消费',
  `face_money` decimal(18, 2) NULL DEFAULT NULL,
  `face_times` decimal(18, 2) NULL DEFAULT NULL,
  `face_month` decimal(18, 2) NULL DEFAULT NULL,
  `expire_month` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `creater` bigint(20) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `updater` bigint(20) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '1=删除,0=未删除',
  `deleter` bigint(20) NULL DEFAULT NULL,
  `deleted_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mem_place
-- ----------------------------
DROP TABLE IF EXISTS `mem_place`;
CREATE TABLE `mem_place`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `place` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `creater` bigint(20) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `updater` bigint(20) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '1=删除,0=未删除',
  `deleter` bigint(20) NULL DEFAULT NULL,
  `deleted_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mem_place_card
-- ----------------------------
DROP TABLE IF EXISTS `mem_place_card`;
CREATE TABLE `mem_place_card`  (
  `place_id` bigint(20) NOT NULL,
  `card_id` bigint(20) NULL DEFAULT NULL,
  `creater` bigint(20) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `updater` bigint(20) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '1=删除,0=未删除',
  `deleter` bigint(20) NULL DEFAULT NULL,
  `deleted_date` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mem_place_user
-- ----------------------------
DROP TABLE IF EXISTS `mem_place_user`;
CREATE TABLE `mem_place_user`  (
  `place_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `creater` bigint(20) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `updater` bigint(20) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '1=删除,0=未删除',
  `deleter` bigint(20) NULL DEFAULT NULL,
  `deleted_date` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `dept_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `dept_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `creater` bigint(20) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `updater` bigint(20) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '1=删除,0=未删除',
  `deleter` bigint(20) NULL DEFAULT NULL,
  `deleted_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dept_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_user`;
CREATE TABLE `sys_dept_user`  (
  `dept_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `creater` bigint(20) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `updater` bigint(20) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '1=删除,0=未删除',
  `deleter` bigint(20) NULL DEFAULT NULL,
  `deleted_date` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_image
-- ----------------------------
DROP TABLE IF EXISTS `sys_image`;
CREATE TABLE `sys_image`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ext` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `creater` bigint(20) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `updater` bigint(20) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '1=删除,0=未删除',
  `deleter` bigint(20) NULL DEFAULT NULL,
  `deleted_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限类型(1=菜单,2=按钮,3=其他页面元素)',
  `parent_id` bigint(20) NOT NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `words` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限字符串',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `status` int(11) NULL DEFAULT NULL COMMENT '是否有效',
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '1=删除,0=未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100304 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (8, '卡片管理', '1', 0, '0', NULL, 'card:menu', 'mdi-cards', 10, NULL, b'0');
INSERT INTO `sys_permission` VALUES (9, '财务统计', '1', 0, '0', NULL, 'rpt:menu', 'mdi-chart-areaspline', 20, NULL, b'0');
INSERT INTO `sys_permission` VALUES (10, '系统设置', '1', 0, '0', NULL, 'sys:menu', 'mdi-cogs', 30, NULL, b'0');
INSERT INTO `sys_permission` VALUES (801, '发卡', '1', 8, '0/8', NULL, 'card:init', NULL, 10, NULL, b'0');
INSERT INTO `sys_permission` VALUES (802, '消费', '1', 8, '0/8', NULL, 'card:consume', NULL, 20, NULL, b'0');
INSERT INTO `sys_permission` VALUES (803, '卡类型设置', '1', 8, '0/8', NULL, 'card:type', NULL, 30, NULL, b'0');
INSERT INTO `sys_permission` VALUES (804, '清卡', '1', 8, '0/8', NULL, 'card:clear', NULL, 40, NULL, b'0');
INSERT INTO `sys_permission` VALUES (805, '擦卡', '1', 8, '0/8', NULL, 'card:reset', NULL, 50, NULL, b'0');
INSERT INTO `sys_permission` VALUES (806, '遗失换卡', '1', 8, '0/8', NULL, 'card:change', NULL, 60, NULL, b'0');
INSERT INTO `sys_permission` VALUES (807, '旧卡换新卡', '1', 8, '0/8', NULL, 'card:oldtonew', NULL, 70, NULL, b'0');
INSERT INTO `sys_permission` VALUES (808, '卡状态修改', '1', 8, '0/8', NULL, 'card:status', NULL, 80, NULL, b'0');
INSERT INTO `sys_permission` VALUES (809, '消费冲减', '1', 8, '0/8', NULL, 'card:unconsume', NULL, 90, NULL, b'0');
INSERT INTO `sys_permission` VALUES (810, '卡消费记录查询', '1', 8, '0/8', NULL, 'card:query', NULL, 100, NULL, b'0');
INSERT INTO `sys_permission` VALUES (901, '报表A', '1', 9, '0/9', NULL, 'rpt:t1', NULL, 10, NULL, b'0');
INSERT INTO `sys_permission` VALUES (902, '报表B', '1', 9, '0/9', NULL, 'rpt:t2', NULL, 20, NULL, b'0');
INSERT INTO `sys_permission` VALUES (903, '日报', '1', 9, '0/9', NULL, 'rpt:t3', NULL, 30, NULL, b'0');
INSERT INTO `sys_permission` VALUES (1001, '用户管理', '1', 10, '0/10', '/sys/user.html', 'user:menu', 'mdi-account-circle', 10, NULL, b'0');
INSERT INTO `sys_permission` VALUES (1002, '角色管理', '1', 10, '0/10', '/sys/role.html', 'role:menu', 'mdi-account-multiple', 20, NULL, b'0');
INSERT INTO `sys_permission` VALUES (1003, '权限管理', '1', 10, '0/10', '/sys/permission.html', 'perm:menu', 'mdi-key', 30, NULL, b'0');
INSERT INTO `sys_permission` VALUES (100101, '用户查询', '2', 1001, '0/10/1001', NULL, 'user:query', NULL, NULL, NULL, b'0');
INSERT INTO `sys_permission` VALUES (100102, '新增用户', '2', 1001, '0/10/1001', NULL, 'user:add', NULL, NULL, NULL, b'0');
INSERT INTO `sys_permission` VALUES (100103, '修改用户', '2', 1001, '0/10/1001', NULL, 'user:modify', NULL, NULL, NULL, b'0');
INSERT INTO `sys_permission` VALUES (100104, '删除用户', '2', 1001, '0/10/1001', NULL, 'user:delete', NULL, NULL, NULL, b'0');
INSERT INTO `sys_permission` VALUES (100105, '分配角色', '2', 1001, '0/10/1001', NULL, 'user:setrole', NULL, NULL, NULL, b'0');
INSERT INTO `sys_permission` VALUES (100201, '角色查询', '2', 1002, '0/10/1002', NULL, 'role:query', NULL, NULL, NULL, b'0');
INSERT INTO `sys_permission` VALUES (100202, '新增角色', '2', 1002, '0/10/1002', NULL, 'role:add', NULL, NULL, NULL, b'0');
INSERT INTO `sys_permission` VALUES (100203, '修改角色', '2', 1002, '0/10/1002', NULL, 'role:modify', NULL, NULL, NULL, b'0');
INSERT INTO `sys_permission` VALUES (100204, '删除角色', '2', 1002, '0/10/1002', NULL, 'role:delete', NULL, NULL, NULL, b'0');
INSERT INTO `sys_permission` VALUES (100205, '配置用户', '2', 1002, '0/10/1002', NULL, 'role:setuser', NULL, NULL, NULL, b'0');
INSERT INTO `sys_permission` VALUES (100301, '权限查询', '2', 1003, '0/10/1003', NULL, 'perm:query', NULL, NULL, NULL, b'0');
INSERT INTO `sys_permission` VALUES (100302, '授权', '2', 1003, '0/10/1003', NULL, 'perm:setperm', NULL, NULL, NULL, b'0');
INSERT INTO `sys_permission` VALUES (100303, '刷卡', '1', 8, '0/8', NULL, '', '', 1, NULL, b'0');

-- ----------------------------
-- Table structure for sys_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_relation`;
CREATE TABLE `sys_permission_relation`  (
  `share_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  `type` int(11) NULL DEFAULT 1 COMMENT '1=role,2=user,3=dept',
  `creater` bigint(20) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '1=删除,0=未删除',
  `deleter` bigint(20) NULL DEFAULT NULL,
  `deleted_date` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission_relation
-- ----------------------------
INSERT INTO `sys_permission_relation` VALUES (7, 8, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (7, 801, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (7, 804, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (7, 805, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (7, 9, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (7, 901, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (7, 902, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (7, 903, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (2, 8, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (2, 801, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (2, 803, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (2, 1001, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (2, 10, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (2, 100101, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (2, 100102, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (2, 100104, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (3, 1002, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (3, 10, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (3, 100202, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 0, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 8, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 801, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 802, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 803, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 804, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 805, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 806, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 807, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 808, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 10, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 1001, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 100101, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 100102, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 100103, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 100105, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 1002, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 100201, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 100202, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 100203, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 100204, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 100205, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 1003, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 100301, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 100302, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 9, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 901, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 902, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);
INSERT INTO `sys_permission_relation` VALUES (1, 903, 1, NULL, '2021-03-18 10:51:26', b'0', NULL, NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT 1,
  `creater` bigint(20) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `updater` bigint(20) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '1=删除,0=未删除',
  `deleter` bigint(20) NULL DEFAULT NULL,
  `deleted_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin', '管理员', '拥有所有权限', 1, NULL, '2021-03-18 10:52:04', NULL, NULL, b'0', NULL, NULL);
INSERT INTO `sys_role` VALUES (2, 'member', '普通会员', 'abc11', 1, NULL, '2021-03-18 10:52:04', NULL, NULL, b'0', NULL, NULL);
INSERT INTO `sys_role` VALUES (3, 'manager', '经理', 'a112', 1, NULL, '2021-03-18 10:52:04', NULL, NULL, b'0', NULL, NULL);
INSERT INTO `sys_role` VALUES (4, 'employee', '员工', NULL, 1, NULL, '2021-03-18 10:52:04', NULL, NULL, b'0', NULL, NULL);
INSERT INTO `sys_role` VALUES (6, 'advanced', '高级会员', NULL, 1, NULL, '2021-03-18 10:52:04', NULL, NULL, b'0', NULL, NULL);
INSERT INTO `sys_role` VALUES (7, 'accounting', '财务人员', NULL, 1, NULL, '2021-03-18 10:52:04', NULL, NULL, b'0', NULL, NULL);
INSERT INTO `sys_role` VALUES (8, 'buzhang', '部长', '', 0, NULL, '2021-03-18 10:52:04', NULL, NULL, b'0', NULL, NULL);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `locked` int(11) NULL DEFAULT 0 COMMENT '1=锁定,0=未锁定',
  `creater` bigint(20) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `updater` bigint(20) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '1=删除,0=未删除',
  `deleter` bigint(20) NULL DEFAULT NULL,
  `deleted_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '管理员', '123', 0, NULL, '2021-03-18 10:52:35', NULL, NULL, b'0', NULL, NULL);
INSERT INTO `sys_user` VALUES (2, 'user01', '1号员工', '123', 0, NULL, '2021-03-18 10:52:35', NULL, NULL, b'0', NULL, NULL);
INSERT INTO `sys_user` VALUES (3, 'user02', '2号员工', '123', 0, NULL, '2021-03-18 10:52:35', NULL, NULL, b'0', NULL, NULL);
INSERT INTO `sys_user` VALUES (4, 'guest', '游客', '123', 0, NULL, '2021-03-18 10:52:35', NULL, NULL, b'0', NULL, NULL);
INSERT INTO `sys_user` VALUES (5, 'tempadmin', '临时管理员', '123', 0, NULL, '2021-03-18 10:52:35', NULL, NULL, b'0', NULL, NULL);
INSERT INTO `sys_user` VALUES (7, 'abc1', 'abc2', 'abc', 1, NULL, '2021-03-18 10:52:35', NULL, NULL, b'0', NULL, NULL);
INSERT INTO `sys_user` VALUES (8, 'a1', 'a1', 'a1', 0, NULL, '2021-03-18 10:52:35', NULL, NULL, b'0', NULL, NULL);
INSERT INTO `sys_user` VALUES (9, 'a2', 'a22', 'a2', 0, NULL, '2021-03-18 10:52:35', NULL, NULL, b'0', NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `creater` bigint(20) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '1=删除,0=未删除',
  `deleter` bigint(20) NULL DEFAULT NULL,
  `deleted_date` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, NULL, '2021-03-18 10:53:15', b'0', NULL, NULL);
INSERT INTO `sys_user_role` VALUES (2, 7, NULL, '2021-03-18 10:53:15', b'0', NULL, NULL);
INSERT INTO `sys_user_role` VALUES (3, 7, NULL, '2021-03-18 10:53:15', b'0', NULL, NULL);
INSERT INTO `sys_user_role` VALUES (4, 2, NULL, '2021-03-18 10:53:15', b'0', NULL, NULL);
INSERT INTO `sys_user_role` VALUES (1, 3, NULL, '2021-03-18 10:53:15', b'0', NULL, NULL);
INSERT INTO `sys_user_role` VALUES (5, 1, NULL, '2021-03-18 10:53:15', b'0', NULL, NULL);
INSERT INTO `sys_user_role` VALUES (7, 7, NULL, '2021-03-18 10:53:15', b'0', NULL, NULL);
INSERT INTO `sys_user_role` VALUES (7, 6, NULL, '2021-03-18 10:53:15', b'0', NULL, NULL);
INSERT INTO `sys_user_role` VALUES (8, 2, NULL, '2021-03-18 10:53:15', b'0', NULL, NULL);

-- ----------------------------
-- Table structure for sys_version_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_version_info`;
CREATE TABLE `sys_version_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `file_stream` varbinary(0) NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '相对根目录',
  `version_no` decimal(18, 2) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `forced` tinyint(4) NULL DEFAULT NULL COMMENT '是否强制更新到这一版本,即便不是最新版',
  `customer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'hilton' COMMENT '哪家客户',
  `publish_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
