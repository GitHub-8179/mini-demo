/*
SQLyog Job Agent Version 8.14 Copyright(c) Webyog Softworks Pvt. Ltd. All Rights Reserved.


MySQL - 5.6.42 : Database - zz_wechat
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`zz_wechat` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `zz_wechat`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article1` (
  `article_id` varchar(32) NOT NULL,
  `article_type_id` int(16) DEFAULT NULL,
  `article_title` varchar(300) DEFAULT NULL,
  `article_keyword` varchar(300) DEFAULT NULL,
  `author` varchar(150) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `source` varchar(150) DEFAULT NULL,
  `share_count` int(8) unsigned zerofill DEFAULT NULL,
  `collect_count` int(8) unsigned zerofill DEFAULT NULL,
  `collect_initcount` int(10) DEFAULT NULL,
  `share_initcount` int(10) DEFAULT NULL,
  `content_type` int(1) DEFAULT NULL,
  `content_crawl` longtext,
  `content_manual` longtext,
  `content_readcount` int(11) unsigned zerofill DEFAULT NULL,
  `content_excerpt` varchar(6000) DEFAULT NULL,
  `image_path` varchar(1000) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  `details_txt` longblob,
  `details_div` longblob,
  `details_path` varchar(255) DEFAULT NULL,
  `content_text` varchar(3000) DEFAULT NULL,
  `word_count` int(100) DEFAULT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `article_type` */

DROP TABLE IF EXISTS `article_type`;

CREATE TABLE `article_type` (
  `article_type_id` int(16) NOT NULL AUTO_INCREMENT,
  `article_type_name` varchar(50) DEFAULT NULL,
  `article_type_keyword` varchar(1000) DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `iamge_icon` varchar(100) DEFAULT NULL,
  `iamge_back` varchar(100) DEFAULT NULL,
  `parentid` int(8) NOT NULL,
  `last_day` time(6) DEFAULT NULL,
  PRIMARY KEY (`article_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
