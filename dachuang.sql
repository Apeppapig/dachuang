USE dachuang;
/*
    用户模块
 */

DROP TABLE IF EXISTS `dc_user`;
CREATE TABLE `dc_user`(
    `id` INT(11) AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    `tel_num` CHAR(11) NOT NULL COMMENT '电话号码' ,
    `password` VARCHAR(64) NOT NULL COMMENT '密码' ,
    `nickname` VARCHAR(32) NOT NULL COMMENT '昵称' ,
    `avatar_url` VARCHAR(256) DEFAULT NULL COMMENT '头像url' ,
    `balance` DECIMAL(32, 2) DEFAULT 0 COMMENT '账户余额' ,
    UNIQUE tel_num(tel_num)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';

INSERT INTO `dc_user` VALUE (null, 13000000000, '$2a$10$xarbk4AxMqgGiu2YqVd2f.m9OHnnCEXRJCmQCvutIdGqZTWKQgEjK', 'admin', '/static/default/admin.jpg', 9999.00);
INSERT INTO `dc_user` VALUE (null, 13000000001, '$2a$10$xarbk4AxMqgGiu2YqVd2f.m9OHnnCEXRJCmQCvutIdGqZTWKQgEjK', 'teacher', '/static/default/teacher.jpg', 9999.00);
INSERT INTO `dc_user` VALUE (null, 13000000002, '$2a$10$xarbk4AxMqgGiu2YqVd2f.m9OHnnCEXRJCmQCvutIdGqZTWKQgEjK', 'student', '/static/default/student.jpg', 9999.00);


DROP TABLE IF EXISTS `dc_role`;
CREATE TABLE `dc_role`(
    `id` TINYINT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    `name` VARCHAR(32) NOT NULL COMMENT '1->admin 2->teacher 3->student'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '角色表';

INSERT INTO `dc_role` value (null, 'admin');
INSERT INTO `dc_role` value (null, 'teacher');
INSERT INTO `dc_role` value (null, 'student');
INSERT INTO `dc_role` value (null, 'vip student');


# 用户与角色为多对多关系
DROP TABLE IF EXISTS `dc_user_role_relation`;
CREATE TABLE `dc_user_role_relation`(
  `id` INT(11) AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  `user_id` INT(11) NOT NULL COMMENT '用户id' ,
  `role_id` TINYINT NOT NULL COMMENT '角色id' ,
  INDEX user_id(user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户角色关系表';

INSERT INTO `dc_user_role_relation` VALUE (null, 1, 1);
INSERT INTO `dc_user_role_relation` VALUE (null, 2, 2);
INSERT INTO `dc_user_role_relation` VALUE (null, 3, 3);


DROP TABLE IF EXISTS `dc_permission`;
CREATE TABLE `dc_permission`(
    `id` TINYINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `value` VARCHAR(128) DEFAULT NULL COMMENT '权限值'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '权限表';

INSERT INTO `dc_permission` VALUE (null, '创建直播间');
INSERT INTO `dc_permission` VALUE (null, '禁言');
INSERT INTO `dc_permission` VALUE (null, '踢人');
INSERT INTO `dc_permission` VALUE (null, '解散直播间');
INSERT INTO `dc_permission` VALUE (null, '弹幕');
INSERT INTO `dc_permission` VALUE (null, '评论');


DROP TABLE IF EXISTS `dc_role_permission_relation`;
CREATE TABLE `dc_role_permission_relation`(
    `id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    `role_id` TINYINT NOT NULL COMMENT '角色id' ,
    `permission_id` TINYINT NOT NULL COMMENT '权限id' ,
    INDEX role_id(role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '角色权限关系表';

INSERT INTO `dc_role_permission_relation` VALUE (null, 1, 1);
INSERT INTO `dc_role_permission_relation` VALUE (null, 1, 2);
INSERT INTO `dc_role_permission_relation` VALUE (null, 1, 3);
INSERT INTO `dc_role_permission_relation` VALUE (null, 1, 4);
INSERT INTO `dc_role_permission_relation` VALUE (null, 1, 5);
INSERT INTO `dc_role_permission_relation` VALUE (null, 1, 6);
INSERT INTO `dc_role_permission_relation` VALUE (null, 1, 7);
INSERT INTO `dc_role_permission_relation` VALUE (null, 2, 2);
INSERT INTO `dc_role_permission_relation` VALUE (null, 2, 3);
INSERT INTO `dc_role_permission_relation` VALUE (null, 2, 4);
INSERT INTO `dc_role_permission_relation` VALUE (null, 2, 5);
INSERT INTO `dc_role_permission_relation` VALUE (null, 2, 6);
INSERT INTO `dc_role_permission_relation` VALUE (null, 2, 6);
INSERT INTO `dc_role_permission_relation` VALUE (null, 2, 7);
INSERT INTO `dc_role_permission_relation` VALUE (null, 3, 6);
INSERT INTO `dc_role_permission_relation` VALUE (null, 4, 6);
INSERT INTO `dc_role_permission_relation` VALUE (null, 4, 7);



/*
    礼物模块
 */
DROP TABLE IF EXISTS `dc_gift`;
CREATE TABLE `dc_gift`(
    `id` TINYINT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    `name` VARCHAR(32) NOT NULL COMMENT '礼物名字' ,
    `price` DECIMAL(16, 2) NOT NULL COMMENT '礼物单价' ,
    `icon_url` VARCHAR(256) NOT NULL COMMENT '图标URL'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '礼物表';

INSERT INTO `dc_gift` VALUE (null, 'test', 0.00, '/static/default/icon.jpg');
INSERT INTO `dc_gift` VALUE (null, 'test', 0.00, '/static/default/icon.jpg');
INSERT INTO `dc_gift` VALUE (null, 'test', 0.00, '/static/default/icon.jpg');


DROP TABLE IF EXISTS `dc_user_gift_relation`;
CREATE TABLE `dc_user_gift_relation`(
    `id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    `user_id` INT(11) NOT NULL COMMENT '用户id' ,
    `gift_id` TINYINT NOT NULL COMMENT '礼物id' ,
    `num` INT DEFAULT 0 COMMENT '数量' ,
    INDEX user_id(user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户礼物关系表';

INSERT INTO `dc_user_gift_relation` VALUE (null, 3, 1, 99);
INSERT INTO `dc_user_gift_relation` VALUE (null, 3, 2, 99);
INSERT INTO `dc_user_gift_relation` VALUE (null, 3, 3, 99);


/*
    直播间模块
 */

DROP TABLE IF EXISTS `dc_tag`;
CREATE TABLE `dc_tag`(
    `id` TINYINT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    `name` VARCHAR(32) NOT NULL COMMENT '标签名'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '课程标签表';

INSERT INTO `dc_tag` VALUE (null, 'IT/互联网');
INSERT INTO `dc_tag` VALUE (null, '语文');
INSERT INTO `dc_tag` VALUE (null, '数学');
INSERT INTO `dc_tag` VALUE (null, '英语');
INSERT INTO `dc_tag` VALUE (null, '法律');
INSERT INTO `dc_tag` VALUE (null, '法语');


DROP TABLE IF EXISTS `dc_classroom`;
CREATE TABLE `dc_classroom`(
    `id` INT(11) AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    `owner` INT(11) NOT NULL COMMENT '创建者' ,
    `status` TINYINT DEFAULT 1 COMMENT '0->无法使用 1->正常使用',
    `description` VARCHAR(512) DEFAULT NULL COMMENT '课程介绍' ,
    `img_url` VARCHAR(256) DEFAULT NULL COMMENT '课程首页图片'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '直播间表';

INSERT INTO `dc_classroom` VALUE (null, 1, 1, '测试课程', '/static/default/course.jpg');
INSERT INTO `dc_classroom` VALUE (null, 2, 1, '测试课程', '/static/default/course.jpg');


DROP TABLE IF EXISTS `dc_user_classroom_relation`;
CREATE TABLE `dc_user_classroom_relation`(
    `id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    `user_id` INT(11) NOT NULL COMMENT '用户id' ,
    `classroom_id` INT(11) NOT NULL COMMENT '直播间id' ,
    `status` TINYINT DEFAULT 1 COMMENT '0->被拉黑 1->正常' ,
    INDEX user_id(user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户直播间关系表';

INSERT INTO `dc_user_classroom_relation` VALUE (null, 1, 1, 1);
INSERT INTO `dc_user_classroom_relation` VALUE (null, 1, 1, 0);
INSERT INTO `dc_user_classroom_relation` VALUE (null, 2, 1, 1);
INSERT INTO `dc_user_classroom_relation` VALUE (null, 1, 1, 0);


DROP TABLE IF EXISTS `dc_group`;
CREATE TABLE `dc_group`(
    `id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    `classroom_id` INT(11) NOT NULL COMMENT '小组所属直播间' ,
    `order_num` TINYINT UNIQUE NOT NULL COMMENT '小组在直播间的序号' ,
    INDEX classroom_id(classroom_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '小组表';

INSERT INTO `dc_group` VALUE (null, 1, 1);
INSERT INTO `dc_group` VALUE (null, 1, 2);
INSERT INTO `dc_group` VALUE (null, 1, 3);
INSERT INTO `dc_group` VALUE (null, 1, 4);


DROP TABLE IF EXISTS `dc_user_group_relation`;
CREATE TABLE `dc_user_group_relation`(
    `id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    `user_id` INT(11) NOT NULL COMMENT '用户id' ,
    `group_id` INT NOT NULL COMMENT '所属小组id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户小组关系表';

/*
    评论模块
 */

DROP TABLE IF EXISTS `dc_comment`;
CREATE TABLE `dc_comment`(
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    `user_id` INT(11) NOT NULL COMMENT '评论者' ,
    `content` VARCHAR(512) DEFAULT NULL  COMMENT '评论内容' ,
    INDEX user_id(user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '评论表';

INSERT INTO `dc_comment` VALUE (null, 1, 'test');
INSERT INTO `dc_comment` VALUE (null, 1, 'test');
INSERT INTO `dc_comment` VALUE (null, 1, 'test');


DROP TABLE IF EXISTS `dc_classroom_comment_relation`;
CREATE TABLE `dc_classroom_comment_relation`(
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    `classroom_id` INT(11) NOT NULL COMMENT '直播间id' ,
    `comment_id` BIGINT NOT NULL COMMENT '评论id' ,
    INDEX classroom_id(classroom_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '直播间评论关系表';

INSERT INTO `dc_classroom_comment_relation` VALUE (null, 1, 1);
INSERT INTO `dc_classroom_comment_relation` VALUE (null, 1, 1);
INSERT INTO `dc_classroom_comment_relation` VALUE (null, 1, 1);


/*
    支付模块
 */
DROP TABLE IF EXISTS `dc_payment`;
CREATE TABLE `dc_payment`(
    `id` TINYINT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    `method` TINYINT NOT NULL COMMENT '支付方式: 0->微信 1->支付宝'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '支付方式表';

INSERT INTO `dc_payment` VALUE (null, 0);
INSERT INTO `dc_payment` VALUE (null ,1);


DROP TABLE IF EXISTS `dc_charge_order`;
CREATE TABLE `dc_charge_order`(
    `id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    `user_id` INT(11) NOT NULL COMMENT '充值者' ,
    `money` DECIMAL(16, 2) NOT NULL DEFAULT 0 COMMENT '充值金额' ,
    `create_time` TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '充值订单创建时间' ,
    `payment_time` TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '充值订单支付时间' ,
    `status` TINYINT NOT NULL DEFAULT 0 COMMENT '0->未支付 1->已支付'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户充值记录表';

INSERT INTO `dc_charge_order` VALUE (null, 1, 999, now(), now(), 1);
INSERT INTO `dc_charge_order` VALUE (null, 1, 999, now(), now(), 0);


DROP TABLE IF EXISTS `dc_purchase_order`;
CREATE TABLE `dc_purchase_order`(
    `id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    `user_id` INT(11) NOT NULL COMMENT '购买者' ,
    `time` TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '购买时间' ,
    INDEX user_id(user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户购买礼物记录表';

INSERT INTO `dc_purchase_order` VALUE (null, 1, now());
INSERT INTO `dc_purchase_order` VALUE (null, 1, now());


DROP TABLE IF EXISTS `dc_purchase`;
CREATE TABLE `dc_purchase`(
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    `gift_id` TINYINT NOT NULL COMMENT '购买的礼物id' ,
    `order_id` INT NOT NULL COMMENT '所属购买订单' ,
    `num` INT NOT NULL DEFAULT 0 COMMENT '购买数量' ,
    INDEX order_id(order_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '购买礼物记录条目表';

INSERT INTO `dc_purchase` VALUE (null, 1, 1, 9);
INSERT INTO `dc_purchase` VALUE (null, 1, 1, 9);
INSERT INTO `dc_purchase` VALUE (null, 1, 1, 9);

