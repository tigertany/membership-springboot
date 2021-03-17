/*
Navicat MySQL Data Transfer

Source Server         : 192.168.5.123
Source Server Version : 50728
Source Host           : 192.168.5.123:3306
Source Database       : membership

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2021-03-17 21:36:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mem_card_extend
-- ----------------------------
DROP TABLE IF EXISTS `mem_card_extend`;
CREATE TABLE `mem_card_extend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL COMMENT '1=男,0=女',
  `idcard` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `tax` varchar(255) DEFAULT NULL,
  `inputer` int(11) DEFAULT NULL,
  `input_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mem_card_extend
-- ----------------------------

-- ----------------------------
-- Table structure for mem_card_info
-- ----------------------------
DROP TABLE IF EXISTS `mem_card_info`;
CREATE TABLE `mem_card_info` (
  `uid` varchar(32) NOT NULL,
  `card_no` varchar(32) DEFAULT NULL,
  `inner_no` varchar(32) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1=现金消费,2=次数消费,3=时段内消费',
  `face_money` decimal(18,2) DEFAULT NULL,
  `real_money` decimal(18,2) DEFAULT NULL,
  `face_times` decimal(18,2) DEFAULT NULL,
  `real_times` decimal(18,2) DEFAULT NULL,
  `balance` decimal(18,2) DEFAULT NULL,
  `balance_times` decimal(18,2) DEFAULT NULL,
  `expire` datetime DEFAULT NULL,
  `open_date` datetime DEFAULT NULL,
  `inputer` int(11) DEFAULT NULL,
  `input_date` datetime DEFAULT NULL,
  `changer` int(11) DEFAULT NULL COMMENT '换卡人',
  `change_date` datetime DEFAULT NULL,
  `cardno_new` varchar(32) DEFAULT NULL,
  `innerno_new` varchar(32) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '1=正常,2=挂失,3=遗失换新此卡作废',
  `deleted` int(11) DEFAULT '0',
  `deleter` int(11) DEFAULT NULL,
  `deleted_date` datetime DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mem_card_info
-- ----------------------------

-- ----------------------------
-- Table structure for mem_card_record
-- ----------------------------
DROP TABLE IF EXISTS `mem_card_record`;
CREATE TABLE `mem_card_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_no` varchar(32) DEFAULT NULL,
  `inner_no` varchar(32) DEFAULT NULL,
  `card_uid` varchar(32) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `money` decimal(18,2) DEFAULT NULL,
  `balance` decimal(18,2) DEFAULT NULL,
  `balance_times` decimal(18,2) DEFAULT NULL,
  `place_id` int(11) DEFAULT NULL,
  `opr` int(11) DEFAULT NULL,
  `opr_date` datetime DEFAULT NULL,
  `deleted` int(11) DEFAULT '0',
  `deleter` int(11) DEFAULT NULL,
  `deleted_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mem_card_record
-- ----------------------------

-- ----------------------------
-- Table structure for mem_card_type
-- ----------------------------
DROP TABLE IF EXISTS `mem_card_type`;
CREATE TABLE `mem_card_type` (
  `id` int(11) NOT NULL,
  `prefix` varchar(10) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL COMMENT '1=消费现金,2=消费次数,3=时段内任意消费',
  `face_money` decimal(18,2) DEFAULT NULL,
  `face_times` decimal(18,2) DEFAULT NULL,
  `face_month` decimal(18,2) DEFAULT NULL,
  `expire_month` int(11) DEFAULT NULL,
  `inputer` int(11) DEFAULT NULL,
  `input_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` int(11) DEFAULT NULL,
  `deleter` int(11) DEFAULT NULL,
  `deleted_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mem_card_type
-- ----------------------------

-- ----------------------------
-- Table structure for mem_place
-- ----------------------------
DROP TABLE IF EXISTS `mem_place`;
CREATE TABLE `mem_place` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `place` varchar(255) DEFAULT NULL,
  `inputer` int(11) DEFAULT NULL,
  `input_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` int(11) DEFAULT NULL,
  `deleter` int(11) DEFAULT NULL,
  `delete_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mem_place
-- ----------------------------

-- ----------------------------
-- Table structure for mem_place_card
-- ----------------------------
DROP TABLE IF EXISTS `mem_place_card`;
CREATE TABLE `mem_place_card` (
  `place_id` int(11) NOT NULL,
  `card_uid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mem_place_card
-- ----------------------------

-- ----------------------------
-- Table structure for mem_place_user
-- ----------------------------
DROP TABLE IF EXISTS `mem_place_user`;
CREATE TABLE `mem_place_user` (
  `place_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mem_place_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` int(11) NOT NULL,
  `dept_name` varchar(255) DEFAULT NULL,
  `dept_code` varchar(255) DEFAULT NULL,
  `dept_desc` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `inputer` int(11) DEFAULT NULL,
  `input_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` int(11) DEFAULT '0',
  `deleter` int(11) DEFAULT NULL,
  `deleted_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dept_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_user`;
CREATE TABLE `sys_dept_user` (
  `dept_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_dept_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_image
-- ----------------------------
DROP TABLE IF EXISTS `sys_image`;
CREATE TABLE `sys_image` (
  `img_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `ext` varchar(10) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `inputer` varchar(255) DEFAULT NULL,
  `input_date` datetime DEFAULT NULL,
  PRIMARY KEY (`img_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_image
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL COMMENT '权限类型(1=菜单,2=按钮,3=其他页面元素)',
  `parent_id` int(11) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `words` varchar(255) DEFAULT NULL COMMENT '权限字符串',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `status` int(11) DEFAULT NULL COMMENT '是否有效',
  `deleted` int(11) DEFAULT '0' COMMENT '1=删除,0=未删除',
  `deleted_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100304 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('8', '卡片管理', '1', '0', '0', null, 'card:menu', 'mdi-cards', '10', null, '0', null);
INSERT INTO `sys_permission` VALUES ('9', '财务统计', '1', '0', '0', null, 'rpt:menu', 'mdi-chart-areaspline', '20', null, '0', null);
INSERT INTO `sys_permission` VALUES ('10', '系统设置', '1', '0', '0', null, 'sys:menu', 'mdi-cogs', '30', null, '0', null);
INSERT INTO `sys_permission` VALUES ('801', '发卡', '1', '8', '0/8', null, 'card:init', null, '10', null, '0', null);
INSERT INTO `sys_permission` VALUES ('802', '消费', '1', '8', '0/8', null, 'card:consume', null, '20', null, '0', null);
INSERT INTO `sys_permission` VALUES ('803', '卡类型设置', '1', '8', '0/8', null, 'card:type', null, '30', null, '0', null);
INSERT INTO `sys_permission` VALUES ('804', '清卡', '1', '8', '0/8', null, 'card:clear', null, '40', null, '0', null);
INSERT INTO `sys_permission` VALUES ('805', '擦卡', '1', '8', '0/8', null, 'card:reset', null, '50', null, '0', null);
INSERT INTO `sys_permission` VALUES ('806', '遗失换卡', '1', '8', '0/8', null, 'card:change', null, '60', null, '0', null);
INSERT INTO `sys_permission` VALUES ('807', '旧卡换新卡', '1', '8', '0/8', null, 'card:oldtonew', null, '70', null, '0', null);
INSERT INTO `sys_permission` VALUES ('808', '卡状态修改', '1', '8', '0/8', null, 'card:status', null, '80', null, '0', null);
INSERT INTO `sys_permission` VALUES ('809', '消费冲减', '1', '8', '0/8', null, 'card:unconsume', null, '90', null, '0', null);
INSERT INTO `sys_permission` VALUES ('810', '卡消费记录查询', '1', '8', '0/8', null, 'card:query', null, '100', null, '0', null);
INSERT INTO `sys_permission` VALUES ('901', '报表A', '1', '9', '0/9', null, 'rpt:t1', null, '10', null, '0', null);
INSERT INTO `sys_permission` VALUES ('902', '报表B', '1', '9', '0/9', null, 'rpt:t2', null, '20', null, '0', null);
INSERT INTO `sys_permission` VALUES ('903', '日报', '1', '9', '0/9', null, 'rpt:t3', null, '30', null, '0', null);
INSERT INTO `sys_permission` VALUES ('1001', '用户管理', '1', '10', '0/10', '/sys/user.html', 'user:menu', 'mdi-account-circle', '10', null, '0', null);
INSERT INTO `sys_permission` VALUES ('1002', '角色管理', '1', '10', '0/10', '/sys/role.html', 'role:menu', 'mdi-account-multiple', '20', null, '0', null);
INSERT INTO `sys_permission` VALUES ('1003', '权限管理', '1', '10', '0/10', '/sys/permission.html', 'perm:menu', 'mdi-key', '30', null, '0', null);
INSERT INTO `sys_permission` VALUES ('100101', '用户查询', '2', '1001', '0/10/1001', null, 'user:query', null, null, null, '0', null);
INSERT INTO `sys_permission` VALUES ('100102', '新增用户', '2', '1001', '0/10/1001', null, 'user:add', null, null, null, '0', null);
INSERT INTO `sys_permission` VALUES ('100103', '修改用户', '2', '1001', '0/10/1001', null, 'user:modify', null, null, null, '0', null);
INSERT INTO `sys_permission` VALUES ('100104', '删除用户', '2', '1001', '0/10/1001', null, 'user:delete', null, null, null, '0', null);
INSERT INTO `sys_permission` VALUES ('100105', '分配角色', '2', '1001', '0/10/1001', null, 'user:setrole', null, null, null, '0', null);
INSERT INTO `sys_permission` VALUES ('100201', '角色查询', '2', '1002', '0/10/1002', null, 'role:query', null, null, null, '0', null);
INSERT INTO `sys_permission` VALUES ('100202', '新增角色', '2', '1002', '0/10/1002', null, 'role:add', null, null, null, '0', null);
INSERT INTO `sys_permission` VALUES ('100203', '修改角色', '2', '1002', '0/10/1002', null, 'role:modify', null, null, null, '0', null);
INSERT INTO `sys_permission` VALUES ('100204', '删除角色', '2', '1002', '0/10/1002', null, 'role:delete', null, null, null, '0', null);
INSERT INTO `sys_permission` VALUES ('100205', '配置用户', '2', '1002', '0/10/1002', null, 'role:setuser', null, null, null, '0', null);
INSERT INTO `sys_permission` VALUES ('100301', '权限查询', '2', '1003', '0/10/1003', null, 'perm:query', null, null, null, '0', null);
INSERT INTO `sys_permission` VALUES ('100302', '授权', '2', '1003', '0/10/1003', null, 'perm:setperm', null, null, null, '0', null);
INSERT INTO `sys_permission` VALUES ('100303', '刷卡', '1', '8', '0/8', null, '', '', '1', null, '0', null);

-- ----------------------------
-- Table structure for sys_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_relation`;
CREATE TABLE `sys_permission_relation` (
  `share_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  `type` int(11) DEFAULT '1' COMMENT '1=role,2=user,3=dept'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_permission_relation
-- ----------------------------
INSERT INTO `sys_permission_relation` VALUES ('7', '8', '1');
INSERT INTO `sys_permission_relation` VALUES ('7', '801', '1');
INSERT INTO `sys_permission_relation` VALUES ('7', '804', '1');
INSERT INTO `sys_permission_relation` VALUES ('7', '805', '1');
INSERT INTO `sys_permission_relation` VALUES ('7', '9', '1');
INSERT INTO `sys_permission_relation` VALUES ('7', '901', '1');
INSERT INTO `sys_permission_relation` VALUES ('7', '902', '1');
INSERT INTO `sys_permission_relation` VALUES ('7', '903', '1');
INSERT INTO `sys_permission_relation` VALUES ('2', '8', '1');
INSERT INTO `sys_permission_relation` VALUES ('2', '801', '1');
INSERT INTO `sys_permission_relation` VALUES ('2', '803', '1');
INSERT INTO `sys_permission_relation` VALUES ('2', '1001', '1');
INSERT INTO `sys_permission_relation` VALUES ('2', '10', '1');
INSERT INTO `sys_permission_relation` VALUES ('2', '100101', '1');
INSERT INTO `sys_permission_relation` VALUES ('2', '100102', '1');
INSERT INTO `sys_permission_relation` VALUES ('2', '100104', '1');
INSERT INTO `sys_permission_relation` VALUES ('3', '1002', '1');
INSERT INTO `sys_permission_relation` VALUES ('3', '10', '1');
INSERT INTO `sys_permission_relation` VALUES ('3', '100202', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '0', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '8', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '801', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '802', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '803', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '804', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '805', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '806', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '807', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '808', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '10', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '1001', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '100101', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '100102', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '100103', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '100105', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '1002', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '100201', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '100202', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '100203', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '100204', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '100205', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '1003', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '100301', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '100302', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '9', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '901', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '902', '1');
INSERT INTO `sys_permission_relation` VALUES ('1', '903', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `recorder` varchar(255) DEFAULT NULL,
  `record_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` int(11) DEFAULT '0' COMMENT '1=删除,0=未删除',
  `deleted_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '管理员', '拥有所有权限', '1', null, null, '0', null);
INSERT INTO `sys_role` VALUES ('2', 'member', '普通会员', 'abc11', '1', '1', '2021-03-17 21:29:26', '0', null);
INSERT INTO `sys_role` VALUES ('3', 'manager', '经理', 'a112', '1', 'demo', '2021-02-16 16:35:20', '0', null);
INSERT INTO `sys_role` VALUES ('4', 'employee', '员工', null, '1', null, null, '0', null);
INSERT INTO `sys_role` VALUES ('6', 'advanced', '高级会员', null, '1', null, '2021-01-19 09:04:23', '0', null);
INSERT INTO `sys_role` VALUES ('7', 'accounting', '财务人员', null, '1', null, '2021-01-19 09:57:31', '0', null);
INSERT INTO `sys_role` VALUES ('8', 'buzhang', '部长', '', '0', 'demo', '2021-02-16 16:30:09', '0', null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `locked` int(11) DEFAULT '0' COMMENT '1=锁定,0=未锁定',
  `recorder` varchar(255) DEFAULT NULL,
  `record_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` int(11) DEFAULT '0' COMMENT '1=删除,0=未删除',
  `deleted_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '管理员', '123', '0', null, '2021-01-19 09:05:49', '0', null);
INSERT INTO `sys_user` VALUES ('2', 'user01', '1号员工', '123', '0', null, '2021-01-19 09:06:12', '0', null);
INSERT INTO `sys_user` VALUES ('3', 'user02', '2号员工', '123', '0', null, '2021-01-19 09:06:30', '0', null);
INSERT INTO `sys_user` VALUES ('4', 'guest', '游客', '123', '0', null, '2021-01-19 09:06:46', '0', null);
INSERT INTO `sys_user` VALUES ('5', 'tempadmin', '临时管理员', '123', '0', null, '2021-01-27 11:03:53', '0', null);
INSERT INTO `sys_user` VALUES ('7', 'abc1', 'abc2', 'abc', '1', 'demo', '2021-02-14 21:38:07', '0', null);
INSERT INTO `sys_user` VALUES ('8', 'a1', 'a1', 'a1', '0', '1', '2021-03-17 21:23:06', '0', null);
INSERT INTO `sys_user` VALUES ('9', 'a2', 'a22', 'a2', '0', null, '2021-02-12 12:16:53', '1', '2021-02-12 13:15:45');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '7');
INSERT INTO `sys_user_role` VALUES ('3', '7');
INSERT INTO `sys_user_role` VALUES ('4', '2');
INSERT INTO `sys_user_role` VALUES ('1', '3');
INSERT INTO `sys_user_role` VALUES ('5', '1');
INSERT INTO `sys_user_role` VALUES ('7', '7');
INSERT INTO `sys_user_role` VALUES ('7', '6');
INSERT INTO `sys_user_role` VALUES ('8', '2');

-- ----------------------------
-- Table structure for sys_version_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_version_info`;
CREATE TABLE `sys_version_info` (
  `ver_id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) DEFAULT NULL,
  `file_stream` varbinary(0) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL COMMENT '相对根目录',
  `version_no` decimal(18,2) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `forced` tinyint(4) DEFAULT NULL COMMENT '是否强制更新到这一版本,即便不是最新版',
  `customer` varchar(255) DEFAULT 'hilton' COMMENT '哪家客户',
  `publish_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ver_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_version_info
-- ----------------------------
