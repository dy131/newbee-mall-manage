/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.49 : Database - ratel_shop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ratel_shop` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `ratel_shop`;

/*Table structure for table `t_carousel` */

DROP TABLE IF EXISTS `t_carousel`;

CREATE TABLE `t_carousel` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `carousel_id` bigint(10) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `carousel_url` varchar(50) NOT NULL DEFAULT '',
  `redirect_url` varchar(50) NOT NULL DEFAULT '',
  `carousel_rank` varchar(50) NOT NULL DEFAULT '',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` bigint(10) NOT NULL DEFAULT '0' COMMENT '创建者',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` bigint(10) NOT NULL DEFAULT '0' COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_carousel` */

/*Table structure for table `t_goods_category` */

DROP TABLE IF EXISTS `t_goods_category`;

CREATE TABLE `t_goods_category` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `category_id` bigint(10) NOT NULL DEFAULT '0' COMMENT '分类ID',
  `category_level` tinyint(1) NOT NULL DEFAULT '0' COMMENT '分类等级',
  `parent_id` bigint(10) NOT NULL DEFAULT '0' COMMENT '父ID',
  `category_name` varchar(50) NOT NULL DEFAULT '' COMMENT '分类名称',
  `category_rank` mediumint(5) NOT NULL DEFAULT '0' COMMENT '分类层级',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` tinyint(10) NOT NULL DEFAULT '0' COMMENT '创建者',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` tinyint(10) NOT NULL DEFAULT '0' COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_goods_category` */

insert  into `t_goods_category`(`id`,`category_id`,`category_level`,`parent_id`,`category_name`,`category_rank`,`is_deleted`,`create_time`,`create_user`,`update_time`,`update_user`) values (1,1,1,0,'衣服',0,0,'2021-03-29 18:43:06',0,'2021-03-29 18:43:06',0),(2,2,2,1,'上衣',1,0,'2021-03-29 18:43:23',0,'2021-03-29 18:43:23',0),(3,3,3,2,'衬衫',2,0,'2021-03-29 18:44:00',0,'2021-03-29 18:44:00',0);

/*Table structure for table `t_index_config` */

DROP TABLE IF EXISTS `t_index_config`;

CREATE TABLE `t_index_config` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `config_id` bigint(10) NOT NULL DEFAULT '0',
  `config_name` varchar(50) NOT NULL DEFAULT '',
  `config_type` varchar(50) NOT NULL DEFAULT '',
  `goods_id` varchar(50) NOT NULL DEFAULT '',
  `redirect_url` varchar(50) NOT NULL DEFAULT '',
  `config_rank` varchar(50) NOT NULL DEFAULT '',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` tinyint(10) NOT NULL DEFAULT '0' COMMENT '创建者',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` tinyint(10) NOT NULL DEFAULT '0' COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_index_config` */

/*Table structure for table `t_shop_goods` */

DROP TABLE IF EXISTS `t_shop_goods`;

CREATE TABLE `t_shop_goods` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `goods_id` bigint(10) NOT NULL DEFAULT '0',
  `goods_name` varchar(50) NOT NULL DEFAULT '',
  `goods_intro` varchar(50) NOT NULL DEFAULT '',
  `goods_category_id` varchar(50) NOT NULL DEFAULT '',
  `goods_cover_img` varchar(50) NOT NULL DEFAULT '',
  `goods_carousel` varchar(50) NOT NULL DEFAULT '',
  `original_price` varchar(50) NOT NULL DEFAULT '',
  `selling_price` varchar(50) NOT NULL DEFAULT '',
  `stock_num` varchar(50) NOT NULL DEFAULT '',
  `tag` varchar(50) NOT NULL DEFAULT '',
  `goods_sell_status` varchar(50) NOT NULL DEFAULT '',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` tinyint(10) NOT NULL DEFAULT '0' COMMENT '创建者',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` tinyint(10) NOT NULL DEFAULT '0' COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_shop_goods` */

/*Table structure for table `t_shop_order` */

DROP TABLE IF EXISTS `t_shop_order`;

CREATE TABLE `t_shop_order` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `order_id` bigint(10) NOT NULL DEFAULT '0',
  `order_no` varchar(50) NOT NULL DEFAULT '',
  `user_id` varchar(50) NOT NULL DEFAULT '',
  `total_price` varchar(50) NOT NULL DEFAULT '',
  `pay_status` varchar(50) NOT NULL DEFAULT '',
  `pay_type` varchar(50) NOT NULL DEFAULT '',
  `pay_time` varchar(50) NOT NULL DEFAULT '',
  `order_status` varchar(50) NOT NULL DEFAULT '',
  `extra_info` varchar(50) NOT NULL DEFAULT '',
  `is_deleted` varchar(50) NOT NULL DEFAULT '',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_shop_order` */

/*Table structure for table `t_shop_order_item` */

DROP TABLE IF EXISTS `t_shop_order_item`;

CREATE TABLE `t_shop_order_item` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `order_item_id` bigint(10) NOT NULL DEFAULT '0',
  `order_id` varchar(50) NOT NULL DEFAULT '',
  `goods_id` varchar(50) NOT NULL DEFAULT '',
  `goods_name` varchar(50) NOT NULL DEFAULT '',
  `goods_cover_img` varchar(50) NOT NULL DEFAULT '',
  `selling_price` varchar(50) NOT NULL DEFAULT '',
  `goods_count` varchar(50) NOT NULL DEFAULT '',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_shop_order_item` */

/*Table structure for table `t_shop_user` */

DROP TABLE IF EXISTS `t_shop_user`;

CREATE TABLE `t_shop_user` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(10) NOT NULL DEFAULT '0',
  `nick_name` varchar(50) NOT NULL DEFAULT '',
  `login_name` varchar(50) NOT NULL DEFAULT '',
  `password_md5` varchar(50) NOT NULL DEFAULT '',
  `introduce_sign` varchar(50) NOT NULL DEFAULT '',
  `locked_flag` varchar(50) NOT NULL DEFAULT '',
  `is_deleted` varchar(50) NOT NULL DEFAULT '',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_shop_user` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(50) NOT NULL DEFAULT '' COMMENT '账号',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '密码',
  `nick_name` varchar(50) NOT NULL DEFAULT '' COMMENT '昵称',
  `locked` tinyint(1) NOT NULL DEFAULT '0' COMMENT '锁',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`user_name`,`password`,`nick_name`,`locked`,`create_time`,`update_time`) values (1,'13162004767','e10adc3949ba59abbe56e057f20f883e','管理员',0,'2021-03-29 14:28:51','2021-03-29 18:15:55');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
