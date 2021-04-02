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

/*Table structure for table `t_goods_category` */

DROP TABLE IF EXISTS `t_goods_category`;

CREATE TABLE `t_goods_category` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_goods_category` */

insert  into `t_goods_category`(`id`,`category_level`,`parent_id`,`category_name`,`category_rank`,`is_deleted`,`create_time`,`create_user`,`update_time`,`update_user`) values (5,1,0,'衣服',0,0,'2021-03-31 16:12:57',0,'2021-03-31 16:12:57',0),(6,1,0,'玩具',1,0,'2021-03-31 16:13:08',0,'2021-03-31 16:13:08',0),(7,2,5,'上衣',0,0,'2021-03-31 16:13:27',0,'2021-03-31 16:13:27',0),(8,2,5,'下衣',1,0,'2021-03-31 16:13:37',0,'2021-03-31 16:13:37',0),(9,3,7,'衬衫',0,0,'2021-03-31 16:14:00',0,'2021-03-31 16:14:00',0),(10,3,7,'羽绒服',1,0,'2021-03-31 16:14:12',0,'2021-03-31 16:14:12',0),(11,3,8,'牛仔裤',0,0,'2021-03-31 16:14:29',0,'2021-03-31 16:14:29',0),(12,3,8,'短裤',1,0,'2021-03-31 16:14:40',0,'2021-03-31 16:14:40',0),(13,2,6,'儿童玩具',0,0,'2021-03-31 16:15:05',0,'2021-03-31 16:15:05',0),(14,3,13,'0-3岁玩具',0,0,'2021-03-31 16:15:19',0,'2021-03-31 16:15:19',0);

/*Table structure for table `t_index_config` */

DROP TABLE IF EXISTS `t_index_config`;

CREATE TABLE `t_index_config` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `config_name` varchar(50) NOT NULL DEFAULT '' COMMENT '配置项名称',
  `config_type` varchar(50) NOT NULL DEFAULT '' COMMENT '类型',
  `goods_id` varchar(50) NOT NULL DEFAULT '' COMMENT '商品编号',
  `redirect_url` varchar(50) NOT NULL DEFAULT '' COMMENT '跳转链接',
  `config_rank` varchar(50) NOT NULL DEFAULT '' COMMENT '排序值',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` tinyint(10) NOT NULL DEFAULT '0' COMMENT '创建者',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` tinyint(10) NOT NULL DEFAULT '0' COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_index_config` */

insert  into `t_index_config`(`id`,`config_name`,`config_type`,`goods_id`,`redirect_url`,`config_rank`,`is_deleted`,`create_time`,`create_user`,`update_time`,`update_user`) values (1,'1111','3','111111','http://www.baidu.com','0',0,'2021-04-02 16:19:40',0,'2021-04-02 16:23:06',0),(3,'1211','4','0','##','0',0,'2021-04-02 16:23:20',0,'2021-04-02 16:23:20',0),(4,'3221','5','0','##','0',0,'2021-04-02 16:23:27',0,'2021-04-02 16:23:27',0);

/*Table structure for table `t_shop_carousel` */

DROP TABLE IF EXISTS `t_shop_carousel`;

CREATE TABLE `t_shop_carousel` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `carousel_url` varchar(50) NOT NULL DEFAULT '' COMMENT '轮播图地址',
  `redirect_url` varchar(50) NOT NULL DEFAULT '' COMMENT '跳转链接',
  `carousel_rank` varchar(50) NOT NULL DEFAULT '' COMMENT '排序值',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` bigint(10) NOT NULL DEFAULT '0' COMMENT '创建者',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` bigint(10) NOT NULL DEFAULT '0' COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_shop_carousel` */

insert  into `t_shop_carousel`(`id`,`carousel_url`,`redirect_url`,`carousel_rank`,`is_deleted`,`create_time`,`create_user`,`update_time`,`update_user`) values (2,'http://localhost:8088/upload/20210402_15224693.png','##','2',0,'2021-04-02 15:22:47',0,'2021-04-02 15:23:07',0),(3,'http://localhost:8088/upload/20210402_15225548.png','##','1',0,'2021-04-02 15:22:58',0,'2021-04-02 15:22:58',0);

/*Table structure for table `t_shop_goods` */

DROP TABLE IF EXISTS `t_shop_goods`;

CREATE TABLE `t_shop_goods` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `goods_name` varchar(50) NOT NULL DEFAULT '' COMMENT '商品名称',
  `goods_intro` varchar(50) NOT NULL DEFAULT '' COMMENT '商品简介',
  `goods_category_id` varchar(50) NOT NULL DEFAULT '' COMMENT '商品类型ID',
  `goods_cover_img` varchar(50) NOT NULL DEFAULT '' COMMENT '商品封面图片',
  `goods_carousel` varchar(50) NOT NULL DEFAULT '' COMMENT '轮播图片',
  `original_price` int(4) NOT NULL DEFAULT '0' COMMENT '商品价格',
  `selling_price` int(4) NOT NULL DEFAULT '0' COMMENT '商品售卖价',
  `stock_num` int(4) NOT NULL DEFAULT '0' COMMENT '商品库存数',
  `tag` varchar(100) NOT NULL DEFAULT '' COMMENT '商品小标签',
  `goods_sell_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '上架状态 0上架 1下架',
  `goods_detail_content` varchar(500) NOT NULL DEFAULT '' COMMENT '商品详情',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` tinyint(10) NOT NULL DEFAULT '0' COMMENT '创建者',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` tinyint(10) NOT NULL DEFAULT '0' COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_shop_goods` */

insert  into `t_shop_goods`(`id`,`goods_name`,`goods_intro`,`goods_category_id`,`goods_cover_img`,`goods_carousel`,`original_price`,`selling_price`,`stock_num`,`tag`,`goods_sell_status`,`goods_detail_content`,`create_time`,`create_user`,`update_time`,`update_user`) values (1,'a','a','14','http://localhost:8088/upload/20210331_11091345.png','http://localhost:8088/upload/20210331_11091345.png',1,1,1,'a',0,'aaaa','2021-03-31 11:11:03',0,'2021-04-01 14:03:00',0),(4,'a','a','14','http://localhost:8088/upload/20210331_11091345.png','http://localhost:8088/upload/20210331_11091345.png',1,1,1,'a',1,'aaaabbbbbbbbbb','2021-04-01 13:41:29',0,'2021-04-01 14:03:10',0),(5,'11111','22','9','http://localhost:8088/upload/20210401_1404072.png','http://localhost:8088/upload/20210401_1404072.png',1,1,111,'11111',0,'aaaaaaaaaavvvvvvvvvvvvvvv','2021-04-01 14:04:08',0,'2021-04-01 14:04:08',0);

/*Table structure for table `t_shop_order` */

DROP TABLE IF EXISTS `t_shop_order`;

CREATE TABLE `t_shop_order` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `order_id` bigint(10) NOT NULL DEFAULT '0' COMMENT '订单ID',
  `order_no` varchar(50) NOT NULL DEFAULT '' COMMENT '订单号',
  `user_id` bigint(10) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `total_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '总价',
  `pay_status` tinyint(2) DEFAULT '0' COMMENT '支付状态',
  `pay_type` tinyint(2) DEFAULT '0' COMMENT '支付类型',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `order_status` tinyint(2) DEFAULT '0' COMMENT '订单状态',
  `extra_info` varchar(100) DEFAULT '',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_shop_order` */

insert  into `t_shop_order`(`id`,`order_id`,`order_no`,`user_id`,`total_price`,`pay_status`,`pay_type`,`pay_time`,`order_status`,`extra_info`,`is_deleted`,`create_time`,`update_time`) values (1,11,'1331',1,'23.05',1,1,'2021-04-01 00:00:00',-3,'','0','2021-04-01 14:52:54','2021-04-01 16:50:49');

/*Table structure for table `t_shop_order_item` */

DROP TABLE IF EXISTS `t_shop_order_item`;

CREATE TABLE `t_shop_order_item` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `order_item_id` bigint(10) NOT NULL DEFAULT '0' COMMENT '子订单号',
  `order_id` bigint(10) NOT NULL DEFAULT '0' COMMENT '订单号',
  `goods_id` bigint(10) NOT NULL DEFAULT '0' COMMENT '商品ID',
  `goods_name` varchar(50) NOT NULL DEFAULT '' COMMENT '商品名',
  `goods_cover_img` varchar(100) NOT NULL DEFAULT '' COMMENT '商品图片',
  `selling_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '售卖价格',
  `goods_count` tinyint(2) NOT NULL DEFAULT '1' COMMENT '商品数量',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_shop_order_item` */

insert  into `t_shop_order_item`(`id`,`order_item_id`,`order_id`,`goods_id`,`goods_name`,`goods_cover_img`,`selling_price`,`goods_count`,`create_time`,`update_time`) values (1,1311,11,1,'衣服','http://localhost:8088/upload/20210331_11091345.png','23.10',1,'2021-04-01 16:14:21','2021-04-01 16:18:25'),(2,1312,11,2,'裤子','http://localhost:8088/upload/20210331_11091345.png','11.00',2,'2021-04-01 16:19:31','2021-04-01 16:21:39');

/*Table structure for table `t_shop_user` */

DROP TABLE IF EXISTS `t_shop_user`;

CREATE TABLE `t_shop_user` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(10) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `nick_name` varchar(50) NOT NULL DEFAULT '' COMMENT '昵称',
  `login_name` varchar(50) NOT NULL DEFAULT '' COMMENT '登录名',
  `password_md5` varchar(50) NOT NULL DEFAULT '' COMMENT '密码',
  `introduce_sign` varchar(50) NOT NULL DEFAULT '' COMMENT '简介',
  `locked_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '身份状态 1锁定 0正常',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否注销 1注销 0正常',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_shop_user` */

insert  into `t_shop_user`(`id`,`user_id`,`nick_name`,`login_name`,`password_md5`,`introduce_sign`,`locked_flag`,`is_deleted`,`create_time`,`update_time`) values (1,11,'11','11','1234','1',1,1,'2021-04-01 14:16:04','2021-04-01 14:25:41');

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

insert  into `t_user`(`id`,`user_name`,`password`,`nick_name`,`locked`,`create_time`,`update_time`) values (1,'13162004767','c33367701511b4f6020ec61ded352059','管理员',0,'2021-03-29 14:28:51','2021-03-29 18:15:55');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
