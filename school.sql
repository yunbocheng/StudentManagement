/*
 Navicat Premium Data Transfer

 Source Server         : 学生信息
 Source Server Type    : MySQL
 Source Server Version : 50536
 Source Host           : localhost:3306
 Source Schema         : school

 Target Server Type    : MySQL
 Target Server Version : 50536
 File Encoding         : 65001

 Date: 05/04/2022 11:40:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tab_province
-- ----------------------------
DROP TABLE IF EXISTS `tab_province`;
CREATE TABLE `tab_province`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '省份编号',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份名称',
  `capital` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份省会\n',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '省份表\n' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tab_province
-- ----------------------------
INSERT INTO `tab_province` VALUES (1, '河北省', '石家庄');
INSERT INTO `tab_province` VALUES (2, '山西省', '太原市');
INSERT INTO `tab_province` VALUES (3, '山东省', '济南市');

-- ----------------------------
-- Table structure for tab_student
-- ----------------------------
DROP TABLE IF EXISTS `tab_student`;
CREATE TABLE `tab_student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `province` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份',
  `city` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市区',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `score` double NULL DEFAULT NULL,
  `room` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生班级',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `tab_student_num_uindex`(`num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tab_student
-- ----------------------------
INSERT INTO `tab_student` VALUES (2, '110502', '山西省', '忻州市', '李宏伟', 22, 90, 'Java1105');
INSERT INTO `tab_student` VALUES (3, '110503', '山西省', '大同市', '张学伟', 22, 90, 'Java1105');
INSERT INTO `tab_student` VALUES (7, '110507', '山西省', '吕梁市', '梁朝晖', 22, 90, 'Java1105');
INSERT INTO `tab_student` VALUES (8, '110508', '山西省', '忻州市', '杨凯', 21, 90, 'Java1105');
INSERT INTO `tab_student` VALUES (15, '110509', '山西省', '长治市', '药彧', 24, 90, 'Java1105');
INSERT INTO `tab_student` VALUES (16, '100510', '山西省', '晋中市', '宋英姿', 22, 90, 'Java1105');
INSERT INTO `tab_student` VALUES (17, '110511', '山西省', '太原市', '高源浩', 18, 90, 'Java1105');
INSERT INTO `tab_student` VALUES (18, '110512', '山西省', '运城市', '石锐坚', 21, 90, 'Java1105');
INSERT INTO `tab_student` VALUES (19, '110513', '山西省', '大同市', '刘涛', 22, 60, 'Java1105');
INSERT INTO `tab_student` VALUES (20, '110514', '山西省', '吕梁市', '杜少雄', 21, 90, 'Java1105');
INSERT INTO `tab_student` VALUES (21, '110515', '山西省', '长治市', '申高昂', 21, 90, 'Java1105');
INSERT INTO `tab_student` VALUES (22, '110516', '山西省', '太原市', '王佳敏', 22, 90, 'Java1105');
INSERT INTO `tab_student` VALUES (24, '110402', '山西省', '大同市', '段延平', 22, 90, 'Java1104');
INSERT INTO `tab_student` VALUES (25, '110403', '山西省', '朔州市', '郝善江', 21, 90, 'Java1104');
INSERT INTO `tab_student` VALUES (26, '110404', '山西省', '运城市', '力尚阔', 23, 90, 'Java1104');
INSERT INTO `tab_student` VALUES (27, '110405', '山西省', '大同市', '高晨阳', 21, 80, 'Java1104');
INSERT INTO `tab_student` VALUES (28, '110406', '山西省', '运城市', '白海斌', 22, 90, 'Java1104');
INSERT INTO `tab_student` VALUES (29, '110407', '山西省', '晋中市', '胡卓然', 21, 80, 'Java1104');
INSERT INTO `tab_student` VALUES (30, '110408', '山西省', '长治市', '杨博文', 23, 90, 'Java1104');
INSERT INTO `tab_student` VALUES (31, '110409', '山西省', '大同市', '候超', 21, 90, 'Java1104');
INSERT INTO `tab_student` VALUES (32, '110410', '山西省', '运城市', '白瑾瑞', 22, 80, 'Java1104');
INSERT INTO `tab_student` VALUES (33, '110411', '山西省', '吕梁市', '冉雄伟', 23, 90, 'Java1104');
INSERT INTO `tab_student` VALUES (34, '110412', '山西省', '太原市', '毕文义', 21, 60, 'Java1104');
INSERT INTO `tab_student` VALUES (35, '110413', '山西省', '大同市', '刘文嘉', 22, 90, 'Java1104');
INSERT INTO `tab_student` VALUES (36, '110414', '山西省', '朔州市', '张杰', 21, 90, 'Java1104');
INSERT INTO `tab_student` VALUES (37, '110415', '山西省', '大同市', '王则茜', 22, 80, 'Java1104');
INSERT INTO `tab_student` VALUES (38, '110301', '山西省', '太原市', '张涛', 22, 90, 'Java1103');
INSERT INTO `tab_student` VALUES (39, '110302', '山西省', '大同市', '郑佳乐', 21, 90, 'Java1103');
INSERT INTO `tab_student` VALUES (40, '110303', '山西省', '长治市', '李慧宁', 20, 40, 'Java1103');
INSERT INTO `tab_student` VALUES (41, '110304', '山西省', '朔州市', '卫昕华', 21, 90, 'Java1103');
INSERT INTO `tab_student` VALUES (42, '110305', '山西省', '吕梁市', '段甜雨', 20, 90, 'Java1103');
INSERT INTO `tab_student` VALUES (43, '110306', '山西省', '长治市', '李建梅', 21, 90, 'Java1103');
INSERT INTO `tab_student` VALUES (44, '110307', '山西省', '晋中市', '白扬', 22, 90, 'Java1103');
INSERT INTO `tab_student` VALUES (45, '110308', '山西省', '运城市', '吴昱净', 20, 80, 'Java1103');
INSERT INTO `tab_student` VALUES (46, '110309', '山西省', '太原市', '范宇波', 22, 90, 'Java1103');
INSERT INTO `tab_student` VALUES (47, '110310', '山西省', '朔州市', '白嘉琦', 20, 90, 'Java1103');
INSERT INTO `tab_student` VALUES (48, '110311', '山西省', '吕梁市', '侯超', 22, 90, 'Java1103');
INSERT INTO `tab_student` VALUES (49, '110312', '山西省', '太原市', '杨颖', 21, 90, 'Java1103');

-- ----------------------------
-- Table structure for tab_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tab_teacher`;
CREATE TABLE `tab_teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员编号\n',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员姓名',
  `account` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员账号',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `tab_teacher_id_uindex`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tab_teacher
-- ----------------------------
INSERT INTO `tab_teacher` VALUES (1, '周老师', '1234567', 'ZHOUls456.');
INSERT INTO `tab_teacher` VALUES (2, '王老师', '2345678', 'WANGls234.');

-- ----------------------------
-- Table structure for table_city
-- ----------------------------
DROP TABLE IF EXISTS `table_city`;
CREATE TABLE `table_city`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '市区编号',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市区名字',
  `province` int(11) NULL DEFAULT NULL COMMENT '省份编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `table_city_tab_province_id_fk`(`province`) USING BTREE,
  CONSTRAINT `table_city_tab_province_id_fk` FOREIGN KEY (`province`) REFERENCES `tab_province` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '市区表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of table_city
-- ----------------------------
INSERT INTO `table_city` VALUES (1, '承德市', 1);
INSERT INTO `table_city` VALUES (2, '大同市', 2);
INSERT INTO `table_city` VALUES (3, '吕梁市', 2);
INSERT INTO `table_city` VALUES (4, '长治市', 2);
INSERT INTO `table_city` VALUES (5, '忻州市', 2);
INSERT INTO `table_city` VALUES (6, '枣庄市', 3);

SET FOREIGN_KEY_CHECKS = 1;
