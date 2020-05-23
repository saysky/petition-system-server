/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50643
 Source Host           : localhost:3306
 Source Schema         : petition_system

 Target Server Type    : MySQL
 Target Server Version : 50643
 File Encoding         : 65001

 Date: 20/05/2020 23:30:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
BEGIN;
INSERT INTO `category` VALUES (1, '农林农业');
INSERT INTO `category` VALUES (2, '国土资源');
INSERT INTO `category` VALUES (3, '城乡建设');
INSERT INTO `category` VALUES (4, '劳动和社会保障');
INSERT INTO `category` VALUES (5, '卫生计本');
INSERT INTO `category` VALUES (6, '教育文体');
INSERT INTO `category` VALUES (7, '民政');
INSERT INTO `category` VALUES (8, '政法');
INSERT INTO `category` VALUES (9, '经济管理');
INSERT INTO `category` VALUES (10, '交通运输');
INSERT INTO `category` VALUES (11, '商贸旅游');
INSERT INTO `category` VALUES (12, '科技和信息产业');
INSERT INTO `category` VALUES (13, '环境保护');
INSERT INTO `category` VALUES (14, '党务政务');
COMMIT;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `log_type` varchar(255) DEFAULT NULL COMMENT '类型',
  `ip` varchar(255) DEFAULT NULL COMMENT 'IP',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
BEGIN;
INSERT INTO `log` VALUES (1, 1, '登录', '192.168.8.185', '2020-05-17 12:44:36');
INSERT INTO `log` VALUES (2, 1, '修改个人密码', '192.168.8.185', '2020-05-17 12:44:36');
INSERT INTO `log` VALUES (3, 1, '登录', '192.168.8.185', '2020-05-17 12:44:36');
INSERT INTO `log` VALUES (4, 4, '登录', '192.168.8.185', '2020-05-17 12:44:36');
INSERT INTO `log` VALUES (5, 6, '注册', '192.168.8.185', '2020-05-16 23:45:56');
INSERT INTO `log` VALUES (6, 6, '登录', '192.168.8.185', '2020-05-16 23:46:10');
INSERT INTO `log` VALUES (7, 6, '上传附件', '192.168.8.185', '2020-05-16 23:46:56');
INSERT INTO `log` VALUES (8, 6, '发布信访', '192.168.8.185', '2020-05-16 23:46:57');
INSERT INTO `log` VALUES (9, 1, '登录', '192.168.8.185', '2020-05-16 23:47:55');
INSERT INTO `log` VALUES (10, 1, '修改个人密码', '192.168.8.185', '2020-05-16 23:48:23');
INSERT INTO `log` VALUES (11, 4, '登录', '192.168.8.185', '2020-05-16 23:50:20');
INSERT INTO `log` VALUES (12, 4, '修改个人密码', '192.168.8.185', '2020-05-16 23:50:42');
INSERT INTO `log` VALUES (13, 7, '注册', '192.168.8.185', '2020-05-16 23:54:05');
INSERT INTO `log` VALUES (14, 7, '登录', '192.168.8.185', '2020-05-16 23:54:16');
INSERT INTO `log` VALUES (15, 7, '上传附件', '192.168.8.185', '2020-05-16 23:54:49');
INSERT INTO `log` VALUES (16, 7, '发布信访', '192.168.8.185', '2020-05-16 23:54:54');
INSERT INTO `log` VALUES (17, 1, '登录', '192.168.8.185', '2020-05-16 23:55:09');
INSERT INTO `log` VALUES (18, 1, '修改个人密码', '192.168.8.185', '2020-05-16 23:55:17');
INSERT INTO `log` VALUES (19, 4, '登录', '192.168.8.185', '2020-05-16 23:55:42');
INSERT INTO `log` VALUES (20, 4, '修改个人密码', '192.168.8.185', '2020-05-16 23:55:55');
INSERT INTO `log` VALUES (21, 7, '登录', '192.168.8.185', '2020-05-16 23:56:17');
INSERT INTO `log` VALUES (22, 7, '修改个人信息', '192.168.8.185', '2020-05-16 23:56:33');
INSERT INTO `log` VALUES (23, 7, '修改个人密码', '192.168.8.185', '2020-05-16 23:56:40');
INSERT INTO `log` VALUES (24, 1, '登录', '127.0.0.1', '2020-05-17 00:04:51');
INSERT INTO `log` VALUES (25, 1, '修改个人信息', '127.0.0.1', '2020-05-17 00:05:19');
INSERT INTO `log` VALUES (26, 1, '登录', '127.0.0.1', '2020-05-17 00:08:16');
INSERT INTO `log` VALUES (27, 1, '修改个人信息', '127.0.0.1', '2020-05-17 00:08:42');
INSERT INTO `log` VALUES (28, 1, '修改个人信息', '127.0.0.1', '2020-05-17 00:08:56');
INSERT INTO `log` VALUES (29, 1, '修改个人信息', '127.0.0.1', '2020-05-17 00:08:57');
INSERT INTO `log` VALUES (30, 1, '修改个人信息', '127.0.0.1', '2020-05-17 00:11:23');
INSERT INTO `log` VALUES (31, 1, '修改个人信息', '127.0.0.1', '2020-05-17 00:11:33');
INSERT INTO `log` VALUES (32, 1, '修改个人信息', '127.0.0.1', '2020-05-17 00:12:15');
INSERT INTO `log` VALUES (33, 1, '登录', '192.168.96.65', '2020-05-18 03:07:45');
INSERT INTO `log` VALUES (34, 4, '登录', '192.168.96.65', '2020-05-18 03:08:44');
INSERT INTO `log` VALUES (35, 7, '登录', '192.168.96.65', '2020-05-18 03:11:01');
INSERT INTO `log` VALUES (36, 7, '上传附件', '192.168.96.65', '2020-05-18 03:12:25');
INSERT INTO `log` VALUES (37, 7, '发布信访', '192.168.96.65', '2020-05-18 03:12:26');
INSERT INTO `log` VALUES (38, 7, '发布信访', '192.168.96.65', '2020-05-18 03:12:52');
INSERT INTO `log` VALUES (39, 7, '修改个人信息', '192.168.96.65', '2020-05-18 03:13:00');
INSERT INTO `log` VALUES (40, 4, '登录', '192.168.96.65', '2020-05-18 03:20:26');
INSERT INTO `log` VALUES (41, 1, '登录', '192.168.96.65', '2020-05-18 03:32:49');
INSERT INTO `log` VALUES (42, 1, '上传附件', '192.168.96.65', '2020-05-18 03:50:30');
INSERT INTO `log` VALUES (43, 1, '登录', '192.168.96.65', '2020-05-18 04:09:22');
INSERT INTO `log` VALUES (44, 8, '登录', '192.168.8.185', '2020-05-20 07:57:36');
INSERT INTO `log` VALUES (45, 8, '登录', '192.168.8.185', '2020-05-20 07:58:21');
INSERT INTO `log` VALUES (46, 8, '登录', '192.168.8.185', '2020-05-20 08:11:07');
INSERT INTO `log` VALUES (47, 1, '登录', '192.168.8.185', '2020-05-20 09:45:13');
INSERT INTO `log` VALUES (48, 1, '管理员登录', '192.168.8.185', '2020-05-20 09:46:31');
INSERT INTO `log` VALUES (49, 1, '管理员登录', '192.168.8.185', '2020-05-20 09:46:42');
INSERT INTO `log` VALUES (50, 1, '管理员登录', '192.168.8.185', '2020-05-20 09:46:54');
INSERT INTO `log` VALUES (51, 8, '管理员登录', '192.168.8.185', '2020-05-20 09:48:30');
INSERT INTO `log` VALUES (52, 8, '管理员登录', '192.168.8.185', '2020-05-20 09:51:25');
INSERT INTO `log` VALUES (53, 8, '管理员登录', '192.168.8.185', '2020-05-20 10:01:05');
INSERT INTO `log` VALUES (54, 8, '管理员登录', '192.168.8.185', '2020-05-20 10:02:37');
INSERT INTO `log` VALUES (55, 8, '删除用户', '192.168.8.185', '2020-05-20 10:02:40');
INSERT INTO `log` VALUES (56, 8, '删除用户', '192.168.8.185', '2020-05-20 10:03:00');
INSERT INTO `log` VALUES (57, 8, '添加用户', '192.168.8.185', '2020-05-20 10:04:55');
INSERT INTO `log` VALUES (58, 8, '添加用户', '192.168.8.185', '2020-05-20 10:06:10');
INSERT INTO `log` VALUES (59, 8, '管理员登录', '192.168.8.185', '2020-05-20 10:19:21');
INSERT INTO `log` VALUES (60, 8, '更新用户', '192.168.8.185', '2020-05-20 10:19:28');
INSERT INTO `log` VALUES (61, 8, '管理员登录', '192.168.8.185', '2020-05-20 10:23:21');
INSERT INTO `log` VALUES (62, 8, '删除案件', '192.168.8.185', '2020-05-20 10:26:12');
INSERT INTO `log` VALUES (63, 8, '删除案件', '192.168.8.185', '2020-05-20 10:26:20');
COMMIT;

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '案件ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `content` varchar(3000) NOT NULL COMMENT '内容',
  `category_id` bigint(20) DEFAULT NULL COMMENT '类型',
  `approval_time` datetime DEFAULT NULL COMMENT '审批时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `approval_state` varchar(2) DEFAULT NULL COMMENT '审批状态：0待审批，1已完成初级审批，2领导审批通过，-1驳回',
  `place` varchar(255) DEFAULT NULL COMMENT '问题发生地点',
  `attachment_url` varchar(255) DEFAULT NULL COMMENT '附件URL',
  `approval_suggestion` varchar(2000) DEFAULT NULL COMMENT '审批意见',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report
-- ----------------------------
BEGIN;
INSERT INTO `report` VALUES (9, 3, '信访标题1111', '信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，', 1, NULL, '2020-05-14 23:29:34', '1', '深圳福田', '1111', NULL);
INSERT INTO `report` VALUES (10, 3, '信访标题1111', '信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，', 1, '2020-05-16 20:01:05', '2020-05-14 23:29:34', '2', '深圳福田', '1111', NULL);
INSERT INTO `report` VALUES (11, 3, '信访标题1111', '信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，信访内容，，', 1, '2020-05-16 20:01:19', '2020-05-14 23:29:34', '2', '深圳福田', '1111', NULL);
INSERT INTO `report` VALUES (17, 4, '222', '22', 3, '2020-05-16 23:56:52', '2020-05-16 19:55:47', '-1', '22', '22', NULL);
INSERT INTO `report` VALUES (18, 4, 'aass', '22', 2, '2020-05-16 20:01:37', '2020-05-16 19:56:12', '2', '122', '221', NULL);
INSERT INTO `report` VALUES (19, 4, '1111', '11', 3, '2020-05-16 20:02:06', '2020-05-16 20:01:59', '2', '111', '11', NULL);
INSERT INTO `report` VALUES (20, 4, '222', '轻轻的我走了，\n正如我轻轻的来；\n我轻轻的招手，\n作别西天的云彩。\n那河畔的金柳，\n是夕阳中的新娘；\n波光里的艳影，\n在我的心头荡漾。\n软泥上的青荇，\n油油的在水底招摇；\n在康河的柔波里，\n我甘心做一条水草！\n那榆荫下的一潭，\n不是清泉，\n是天上虹；\n揉碎在浮藻间，\n沉淀着彩虹似的梦。\n寻梦？\n撑一支长篙，\n向青草更青处漫溯；\n满载一船星辉，\n在星辉斑斓里放歌。\n但我不能放歌，\n悄悄是别离的笙箫；\n夏虫也为我沉默，\n沉默是今晚的康桥！\n悄悄的我走了，\n正如我悄悄的来；\n我挥一挥衣袖，\n不带走一片云彩。', 1, NULL, '2020-05-16 20:02:57', '1', '22', '22', NULL);
INSERT INTO `report` VALUES (21, 4, '22', '轻轻的我走了，\n正如我轻轻的来；\n我轻轻的招手，\n作别西天的云彩。\n那河畔的金柳，\n是夕阳中的新娘；\n波光里的艳影，\n在我的心头荡漾。\n软泥上的青荇，\n油油的在水底招摇；\n在康河的柔波里，\n我甘心做一条水草！\n那榆荫下的一潭，\n不是清泉，\n是天上虹；\n揉碎在浮藻间，\n沉淀着彩虹似的梦。\n寻梦？\n撑一支长篙，\n向青草更青处漫溯；\n满载一船星辉，\n在星辉斑斓里放歌。\n但我不能放歌，\n悄悄是别离的笙箫；\n夏虫也为我沉默，\n沉默是今晚的康桥！\n悄悄的我走了，\n正如我悄悄的来；\n我挥一挥衣袖，\n不带走一片云彩。', 4, '2020-05-16 20:10:31', '2020-05-16 20:10:17', '-1', '2222', '22', NULL);
INSERT INTO `report` VALUES (22, 4, '222', '22', 2, '2020-05-16 23:56:59', '2020-05-16 20:17:31', '-1', '2', '22', NULL);
INSERT INTO `report` VALUES (23, 4, '22', '22', 3, NULL, '2020-05-16 20:18:10', '1', '22', '2', NULL);
INSERT INTO `report` VALUES (24, 4, '22', '22', 3, NULL, '2020-05-16 20:18:11', '1', '22', '2', NULL);
INSERT INTO `report` VALUES (25, 4, '22', '22', 4, NULL, '2020-05-16 20:18:23', '1', '22', '22', NULL);
INSERT INTO `report` VALUES (26, 4, '222', '22', 1, '2020-05-16 23:57:02', '2020-05-16 20:29:17', '-1', '22', '22', NULL);
INSERT INTO `report` VALUES (27, 1, '222', '22', 5, '2020-05-16 23:57:06', '2020-05-16 21:29:14', '-1', '22', NULL, NULL);
INSERT INTO `report` VALUES (28, 1, '22', '2', 3, NULL, '2020-05-16 21:34:36', '1', '22', NULL, NULL);
INSERT INTO `report` VALUES (29, 1, '22', '22', 4, NULL, '2020-05-16 21:35:16', '1', '22', NULL, NULL);
INSERT INTO `report` VALUES (30, 1, '22', '22', 3, NULL, '2020-05-16 21:36:38', '1', '22', NULL, '222');
INSERT INTO `report` VALUES (31, 1, '22', '22', 4, '2020-05-16 23:56:48', '2020-05-16 21:37:38', '-1', '22', NULL, NULL);
INSERT INTO `report` VALUES (32, 1, '22', '22', 5, NULL, '2020-05-16 22:11:54', '1', '22', NULL, NULL);
INSERT INTO `report` VALUES (33, 1, '22', '22', 5, NULL, '2020-05-16 22:16:23', '1', '22', NULL, '2222');
INSERT INTO `report` VALUES (34, 1, '22', '111', 2, NULL, '2020-05-16 22:24:06', '1', '222', NULL, NULL);
INSERT INTO `report` VALUES (35, 1, '2222', '2', 4, NULL, '2020-05-16 22:24:50', '1', '2', NULL, '同意！');
INSERT INTO `report` VALUES (36, 5, '12222', '222', 1, NULL, '2020-05-16 22:58:12', '1', '222', '/upload/2020/5/2.png', NULL);
INSERT INTO `report` VALUES (37, 5, '222', '222222', 2, NULL, '2020-05-16 23:00:50', '1', '222', 'http://localhost:8080//upload/2020/5/3.png', NULL);
INSERT INTO `report` VALUES (38, 5, '22', '22222', 2, NULL, '2020-05-16 23:53:27', '1', '222', 'http://localhost:8080/upload/2020/5/信访系统.docx', NULL);
INSERT INTO `report` VALUES (41, 7, 'XXXX信访', '内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容', 2, NULL, '2020-05-18 03:12:26', '0', '广东省深圳市动物园', 'http://localhost:8080/upload/2020/5/要求.docx', NULL);
INSERT INTO `report` VALUES (42, 7, '测试数据', 'test', 5, NULL, '2020-05-18 03:12:52', '0', '南京', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `real_name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮箱',
  `card` varchar(20) DEFAULT NULL COMMENT '身份证号码',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `type` varchar(255) DEFAULT NULL COMMENT '用户类型：群众user,  员工 staff，领导 leader',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `birth` date DEFAULT NULL COMMENT '生日',
  `staff_level` int(10) DEFAULT NULL COMMENT '管理员等级',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `username` (`name`) USING BTREE,
  UNIQUE KEY `card` (`card`) USING BTREE,
  UNIQUE KEY `email` (`email`) USING BTREE,
  UNIQUE KEY `phone` (`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'zhangsan', '123456', '张三', '男', 'zhangsan@qq.com', '360421199812291111', '222222222222222', '13512341234', 'staff', '2020-05-12 23:07:45', NULL, 1);
INSERT INTO `user` VALUES (3, 'wangwu', '123456', '王五', '男', '111@qq.com', '123456789123456782', '111', '13412341234', 'user', '2020-05-14 00:26:49', NULL, 1);
INSERT INTO `user` VALUES (4, 'mayun', '123456', '马云', '男', 'mayun@qq.com', '123456789123456787', '222', '13412341299', 'staff', '2020-05-16 18:44:35', NULL, 2);
INSERT INTO `user` VALUES (5, 'xiaoming', '111111', '王小明', '男', 'xiaoma@qq.com', '360421199711194567', '北京北京北京北京北京北京', '15712341228', 'user', '2020-05-16 22:33:06', NULL, NULL);
INSERT INTO `user` VALUES (6, 'zhangfei', '123456', '张飞', '女', 'zhangfei@qq.co', '360123199912201992', '张飞家庭住址张飞家庭住址张飞家庭住址', '15779218888', 'user', '2020-05-16 23:45:55', NULL, NULL);
INSERT INTO `user` VALUES (7, 'zhouyu', '123456', '周瑜', '女', 'zhouyu@gmail.com', '360421199912201234', '吴国吴国吴国吴国吴国吴国吴国', '13512347890', 'user', '2020-05-16 23:54:05', NULL, NULL);
INSERT INTO `user` VALUES (8, 'admin', '123456', '管理员', '男', NULL, NULL, NULL, NULL, 'admin', '2020-05-20 20:52:21', NULL, 999);
INSERT INTO `user` VALUES (9, '6666', '123456', '6666', '男', '11@qq.com', '360421199912113333', '1111111111', '13545678912', 'user', '2020-05-20 10:04:55', NULL, 1);
INSERT INTO `user` VALUES (10, 'xiaosan', '123456', '马小三', '女', 'san@qq.com', '360421199912234567', '1222222222', '13612345672', 'user', '2020-05-20 10:06:10', NULL, 1);
COMMIT;

-- ----------------------------
-- View structure for pvview
-- ----------------------------
DROP VIEW IF EXISTS `pvview`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `pvview` AS select sum(`petition_system`.`pv`.`pv`) AS `pv`,`petition_system`.`pv`.`uid` AS `uid` from `pv` group by `petition_system`.`pv`.`uid`;

-- ----------------------------
-- View structure for totalpvview
-- ----------------------------
DROP VIEW IF EXISTS `totalpvview`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `totalpvview` AS select sum(`a`.`pageView`) AS `totalPv`,`a`.`uid` AS `uid` from `article` `a` group by `a`.`uid`;

SET FOREIGN_KEY_CHECKS = 1;
