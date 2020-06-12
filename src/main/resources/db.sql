USE o2o;

CREATE TABLE
IF NOT EXISTS `tb_area` (
	`area_id` INT (11) NOT NULL auto_increment,
	`area_name` VARCHAR (30) NOT NULL COMMENT '区域名字',
	`priority` INT (2) DEFAULT 0 COMMENT '优先级',
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`last_edit_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`area_id`),
	UNIQUE KEY `UK_AREA` (`area_name`)
) ENGINE = INNODB auto_increment = 1 DEFAULT charset = UTF8 COMMENT '区域表';

CREATE TABLE
IF NOT EXISTS `tb_person_info` (
	`user_id` INT (11) NOT NULL auto_increment,
	`name` VARCHAR (32) NOT NULL COMMENT '用户名',
	`profile_img` VARCHAR (1024) DEFAULT NULL COMMENT '用户图像',
	`email` VARCHAR (1024) DEFAULT NULL COMMENT '用户邮箱',
	`gender` VARCHAR (2) DEFAULT NULL COMMENT '用户性别',
	`enable_status` INT (2) DEFAULT 0 COMMENT '用户可用状态 0禁止使用 1可以使用',
	`user_type` INT (3) NOT NULL DEFAULT 1 COMMENT '用户类型 1 顾客 2商家 3 管理员',
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`last_edit_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`user_id`)
) ENGINE = INNODB auto_increment = 1 DEFAULT charset = UTF8 COMMENT '用户信息表';

CREATE TABLE
IF NOT EXISTS `tb_wechat_auth` (
	`wechat_auth_id` INT (11) NOT NULL auto_increment,
	`open_id` VARCHAR (32) NOT NULL COMMENT '微信授权的openid',
	`user_id` INT (11) NOT NULL,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`wechat_auth_id`),
	CONSTRAINT `FK_WECHAT_USER_ID` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`),
  UNIQUE KEY `UK_WECHAT_OPEN_ID`(`open_id`)
) ENGINE = INNODB auto_increment = 1 DEFAULT charset = UTF8 COMMENT '微信授权登录表';

CREATE TABLE
IF NOT EXISTS `tb_local_auth` (
	`local_auth_id` INT (11) NOT NULL auto_increment,
	`user_name` VARCHAR (128) NOT NULL COMMENT '用户名',
	`password` VARCHAR (1024) NOT NULL COMMENT '密码',
	`user_id` INT (10) NOT NULL,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`last_edit_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`local_auth_id`),
	UNIQUE KEY `UK_LOCAL_AUTJ_USER_NAME` (`user_name`),
	CONSTRAINT `FK_LOCAL_USER_ID` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`)
) ENGINE = INNODB auto_increment = 1 DEFAULT charset = UTF8 COMMENT '本地用户表';

#ALTER TABLE tb_wechat_auth ADD UNIQUE INDEX (`open_id`);

create TABLE IF not EXISTS `tb_head_line`(
`line_id` INT(11) not NULL auto_increment,
`line_name` VARCHAR(1024) NOT NULL COMMENT '标题',
`priority` INT(2) DEFAULT 0 COMMENT '优先级',
`enable_status` INT(2) NOT NULL DEFAULT 0 COMMENT '0禁用 1启用',
`line_img` varchar(1024) NOT NULL COMMENT '轮播图url',
`line_link` VARCHAR(1024) COMMENT '点击图片跳转的链接',
`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
`last_edit_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(`line_id`)
)ENGINE = INNODB auto_increment =1 DEFAULT CHARSET=utf8 COMMENT '头条轮播表';


create TABLE IF not EXISTS `tb_shop_category`(
`shop_category_id` INT(11) NOT NULL auto_increment,
`shop_category_name` VARCHAR(128) NOT NULL COMMENT '类别名字' DEFAULT '',
`shop_category_desc` VARCHAR(128) NOT NULL COMMENT '类别描述' DEFAULT '',
`shop_category_img` VARCHAR(1024) NOT NULL COMMENT '类别图片url' DEFAULT '',
`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
`last_edit_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
`enable_status` INT(2) DEFAULT 0 COMMENT '0不可用1 可用',
`priority` INT(2) NOT NULL DEFAULT 0  ,
`parent_id` INT(11) DEFAULT NULL,
PRIMARY KEY(`shop_category_id`),
UNIQUE KEY  `UK_SHOP_CATEGORY_NAME`(`shop_category_name`),
CONSTRAINT `FK_SHOP_CATEGORY_SELF` FOREIGN KEY(`parent_id`) REFERENCES `tb_shop_category`(`shop_category_id`)
)ENGINE = INNODB auto_increment =1 DEFAULT CHARSET=utf8 COMMENT '店铺类别表';


CREATE TABLE IF NOT EXISTS `tb_shop`(
`shop_id` INT(11) NOT NULL auto_increment,
`shop_name` VARCHAR(128) NOT NULL COMMENT '店铺名称',
`shop_addr` VARCHAR(1024) NOT NULL COMMENT '店铺地址',
`shop_img` VARCHAR(128) NOT NULL COMMENT '店铺图片url',
`phone` VARCHAR(64) NOT NULL COMMENT '店铺电话',
`shop_desc` VARCHAR(2000) NOT NULL COMMENT '店铺描述',
`priority` INT(2) DEFAULT 0,
`owner_id` INT(10) NOT NULL COMMENT '创建店铺的用户',
`shop_category_id` INT(11) NOT NULL COMMENT '商铺类别',
`advice` VARCHAR(2000) DEFAULT NULL COMMENT '管理员给商铺的建议',
`area_id` INT(5) NOT NULL COMMENT '店铺所在区域',
`enable_status` INT(2) NOT NULL DEFAULT 0 COMMENT '-1禁用 0审核中 1可用',
`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
`last_edit_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(`shop_id`),
CONSTRAINT `FK_TB_SHOP_AREA_ID` FOREIGN KEY(`area_id`) REFERENCES `tb_area`(`area_id`),
CONSTRAINT `FK_TB_SHOP_CATEGORY_ID` FOREIGN KEY(`shop_category_id`) REFERENCES `tb_shop_category`(`shop_category_id`),
CONSTRAINT `FK_TB_SHOP_USER_ID` FOREIGN KEY(`owner_id`) REFERENCES `tb_person_info`(`user_id`)
)ENGINE = INNODB auto_increment =1 DEFAULT CHARSET=utf8 COMMENT '商铺表';


CREATE TABLE IF NOT EXISTS 	`tb_product_category`(
`product_category_id` INT(11) NOT NULL auto_increment,
`shop_id` INT(11) NOT NULL COMMENT '此商品来自哪个商铺',
`product_category_name` VARCHAR(128) NOT NULL COMMENT '产品类别名称',
`priority` INT(2)  DEFAULT 0 ,
`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY(`product_category_id`),
CONSTRAINT `FK_PRODUCT_CATEGORY_SHOP_ID` FOREIGN KEY(`shop_id`) REFERENCES `tb_shop`(`shop_id`)
)ENGINE = INNODB auto_increment =1 DEFAULT charset = utf8 COMMENT '产品类别表';


CREATE TABLE IF NOT EXISTS `tb_product`(
`product_id` INT(11) NOT NULL auto_increment,
`product_name` VARCHAR(128) NOT NULL COMMENT '商品名称',
`product_desc` VARCHAR(2000) COMMENT '商品描述' DEFAULT '',
`product_thumb` VARCHAR(512) NOT NULL COMMENT '商品缩略图',
`enable_status` INT(2) DEFAULT 1 COMMENT '0下架 1上架',
`product_price` DECIMAL(10,2) NOT NULL COMMENT '商品正常价格',
`discount_price` DECIMAL(10.2) DEFAULT NULL COMMENT '商品打折后的价格',
`priority` INT(5) DEFAULT 0,
`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
`last_edit_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
`shop_id` INT(11) NOT NULL COMMENT '属于哪个商铺',
`product_category_id` INT(11) NOT NULL COMMENT '属于哪个产品种类',
PRIMARY KEY(`product_id`),
CONSTRAINT `FK_PRODUCT_SHOP_ID` FOREIGN KEY(`shop_id`) REFERENCES `tb_shop`(`shop_id`),
CONSTRAINT `FK_PRODUCT_CATEGORY_ID` FOREIGN KEY(`product_category_id`) REFERENCES `tb_product_category`(`product_category_id`)
)ENGINE = INNODB auto_increment =1 DEFAULT charset = utf8 COMMENT '商品表';


CREATE TABLE IF NOT EXISTS `tb_product_img`(
`product_img_id` INT(11) not NULL auto_increment,
`product_id` INT(11) NOT NULL,
`product_desc` VARCHAR(1024) DEFAULT NULL COMMENT '商品描述',
`img_url` VARCHAR(1024) NOT NULL COMMENT '商品图片',
`priority` INT(5) DEFAULT 0,
`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(`product_img_id`),
CONSTRAINT `FK_PRODUCT_IMAG_PRODUCT_ID` FOREIGN KEY(`product_id`) REFERENCES `tb_product`(`product_id`)
)ENGINE = INNODB auto_increment =1 DEFAULT charset = utf8 COMMENT '商品图片详情表';


