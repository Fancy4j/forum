/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : toutiao

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 14/04/2019 15:58:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  `entity_id` int(11) NOT NULL DEFAULT 0,
  `entity_type` int(11) NOT NULL DEFAULT 0,
  `created_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, '111', 1, 6, 1, '2019-03-27 21:21:25', 0);
INSERT INTO `comment` VALUES (63, '123', 1, 6, 0, '2019-04-11 22:06:57', 0);
INSERT INTO `comment` VALUES (64, '1231231', 3, 6, 0, '2019-04-11 22:18:24', 0);
INSERT INTO `comment` VALUES (65, '132', 13, 5, 0, '2019-04-12 19:57:42', 0);
INSERT INTO `comment` VALUES (66, '写的不错', 4, 7, 0, '2019-04-14 15:17:47', 0);
INSERT INTO `comment` VALUES (67, '你打球好像cxk', 4, 7, 0, '2019-04-14 15:20:04', 0);
INSERT INTO `comment` VALUES (68, '111', 11, 7, 0, '2019-04-14 15:23:06', 0);
INSERT INTO `comment` VALUES (69, '222', 11, 7, 0, '2019-04-14 15:24:22', 0);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_id` int(11) NULL DEFAULT NULL,
  `to_id` int(11) NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `created_date` datetime(0) NULL DEFAULT NULL,
  `has_read` int(11) NULL DEFAULT NULL,
  `conversation_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `conversation_index`(`conversation_id`) USING BTREE,
  INDEX `created_date`(`created_date`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 231 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `like_count` int(11) NULL DEFAULT NULL,
  `comment_count` int(11) NULL DEFAULT NULL,
  `created_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `userz_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (7, 'Fancy4j的毕业设计', 'https://github.com/Fancy4j/erp', 'https://wangdao12.oss-cn-hangzhou.aliyuncs.com/b5dc97afbee6429db7f8bfcfaf6a8f9c60.png?x-oss-process=image/resize,m_fill,h_100,w_80', 1, 4, '2019-04-14 15:17:05', 1);

-- ----------------------------
-- Table structure for userz
-- ----------------------------
DROP TABLE IF EXISTS `userz`;
CREATE TABLE `userz`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `head_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userz
-- ----------------------------
INSERT INTO `userz` VALUES (1, 'wawawa', '123456', NULL);
INSERT INTO `userz` VALUES (14, 'Fancy', 'fancy555', 'https://wangdao12.oss-cn-hangzhou.aliyuncs.com/0aa2fbc16e284a76a5802edc576751b4微信图片_20190414153722.jpg?x-oss-process=image/resize,m_fill,h_100,w_80');

SET FOREIGN_KEY_CHECKS = 1;
