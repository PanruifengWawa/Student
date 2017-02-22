/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : springmvc

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-02-15 11:31:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentid` bigint(11) NOT NULL AUTO_INCREMENT,
  `postsid` bigint(11) DEFAULT NULL,
  `contents` varchar(255) DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL,
  `userid` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`commentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', 'a', '2017-01-02 15:35:28', '1');
INSERT INTO `comment` VALUES ('2', '2', 'dsadsadas', '2017-01-03 12:40:36', '2');
INSERT INTO `comment` VALUES ('3', '2', 'sadsa', '2017-01-02 13:00:32', '2');
INSERT INTO `comment` VALUES ('4', '3', 'sads', '2016-12-21 13:11:15', '3');
INSERT INTO `comment` VALUES ('5', '3', 'sas', '2017-01-02 13:30:41', '3');
INSERT INTO `comment` VALUES ('6', '3', 'sas', '2017-01-02 14:37:06', '4');
INSERT INTO `comment` VALUES ('7', '4', 'dadqwwewq', '2017-01-03 14:40:14', '1');

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` int(255) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `imgsrc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file
-- ----------------------------

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `itemid` bigint(11) NOT NULL AUTO_INCREMENT,
  `userid` bigint(11) DEFAULT NULL,
  `itemtype` varchar(255) DEFAULT NULL,
  `itemname` varchar(255) DEFAULT NULL,
  `itemleader` varchar(255) DEFAULT NULL,
  `teacher` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `itembrief` varchar(255) DEFAULT NULL,
  `expectresult` varchar(255) DEFAULT NULL,
  `exitbasic` varchar(255) DEFAULT NULL,
  `memberdemand` varchar(255) DEFAULT NULL,
  `releasedate` timestamp NULL DEFAULT NULL,
  `itemresult` varchar(255) DEFAULT NULL,
  `innovate` varchar(255) DEFAULT NULL,
  `itemcyle` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `starttime` datetime,
  `endtime` datetime,
  `now_people` int default 0,
  `all_people` int default 0,
  `type` bigint(255) DEFAULT NULL,
  `state` bigint(255) DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL,
  `labels` varchar(255) DEFAULT NULL,
  `exitbasicfilesrc` varchar(255) DEFAULT NULL,
  `memberdemandfilesrc` varchar(255) DEFAULT NULL,
  `projectdirection` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`itemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `userid` bigint(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of label
-- ----------------------------

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `newsid` bigint(11) NOT NULL AUTO_INCREMENT,
  `userid` bigint(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL,
  `contents` varchar(255) DEFAULT NULL,
  `state` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`newsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '1', 'a', '2017-01-03 10:29:49', 'sasas', '0');
INSERT INTO `news` VALUES ('2', '2', 'a', '2017-01-02 10:14:21', 'a', '1');
INSERT INTO `news` VALUES ('3', '3', 's', '2017-01-02 10:14:40', 's', '1');
INSERT INTO `news` VALUES ('4', '4', 's', '2017-01-01 10:14:53', 's', '0');

-- ----------------------------
-- Table structure for posts
-- ----------------------------
DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts` (
  `postsid` bigint(255) NOT NULL AUTO_INCREMENT,
  `userid` bigint(11) DEFAULT NULL,
  `theme` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `contents` varchar(255) DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`postsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table posts add column read_count bigint default 0;

-- ----------------------------
-- Records of posts
-- ----------------------------
INSERT INTO `posts` VALUES ('2', '2', 'a', 'a', 'a', '2017-01-02 14:05:49');
INSERT INTO `posts` VALUES ('3', '3', 'w', 'w', 'q', '2017-01-04 10:21:36');
INSERT INTO `posts` VALUES ('4', '4', 'q', 'q', 'q', '2017-01-03 10:21:48');
INSERT INTO `posts` VALUES ('5', '5', 'w', '2', '1', '2017-01-04 10:21:58');

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `token` varchar(255) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  `logindate` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of token
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `applicationid` bigint(20) DEFAULT NULL,
  `registerdate` datetime NULL DEFAULT NULL,
  `type` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'nxa', 'nxa', '123', '2016-12-08 00:00:00', '1');
INSERT INTO `t_user` VALUES ('2', null, null, null, null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `studentid` bigint(11) DEFAULT NULL unique,
  `password` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `personalbrief` varchar(255) DEFAULT NULL,
  `usertype` int(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `registertime` datetime  DEFAULT NULL ,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


alter table user add column personal_tag varchar(1000);
-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'nxa', '1321112', '111212', '信息', '软件', '13166227136@163.com', '擦是的撒打算', '0', '13122212212', '2017-01-02 10:24:32');
INSERT INTO `user` VALUES ('2', 'ws', '1321113', '112121', 'sas', 'wdq', '213213213', 'cdasds', '1', '13213213132', '2017-01-18 14:49:45');
INSERT INTO `user` VALUES ('3', 'xyh', '1321112', 'qwq121', '321sa', 'dsad', 'xsadad', 'dsads', '0', '12312111111', '2017-01-18 14:49:48');
INSERT INTO `user` VALUES ('4', 'aa', '1', '12', 'q', 'q', 'q', 'q', '1', 'q', '2017-01-18 14:49:51');
INSERT INTO `user` VALUES ('5', 'w', '12', 's', 'w', 's', 's', 's', '1', 's', '2017-01-18 14:49:53');
INSERT INTO `user` VALUES ('6', 's', '1', 'w', 'w', 'w', 'ww', 'w', '1', 'w', '2017-01-18 14:49:56');
INSERT INTO `user` VALUES ('7', 'a', '2', 'a', 'a', 'a', 'a', 'a', '1', '21', '2017-01-18 14:49:58');
INSERT INTO `user` VALUES ('8', 'x', '1', 'x', 'x', 'x', 'x', 'x', '1', 'x', '2017-01-18 14:50:01');
INSERT INTO `user` VALUES ('9', 'j', '1', 'j', 'j', 'j', 'j', 'j', '1', 'j', '2017-01-18 14:50:03');
INSERT INTO `user` VALUES ('10', 'i', '1', 'k', 'k', 'k', 'k', 'k', '1', 'k', '2017-01-18 14:50:06');
