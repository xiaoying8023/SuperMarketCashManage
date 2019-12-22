CREATE TABLE `vipcard` (

`v_card` varchar(10) CHARACTER SET utf8 NOT NULL DEFAULT "" COMMENT '会员卡号',

`v_name` varchar(10) CHARACTER SET utf8 NULL DEFAULT "" COMMENT '用户名',

`v_integral` int UNSIGNED NULL DEFAULT 0 COMMENT '会员积分',

PRIMARY KEY (`v_card`) 

);



CREATE TABLE `product` (

`p_id` varchar(20) NOT NULL COMMENT '商品号',

`p_name` varchar(15) NULL DEFAULT "" COMMENT '商品名称',

`p_price` float(7,2) NULL DEFAULT 0.00 COMMENT '商品价格',

`p_stock` int NULL DEFAULT 0 COMMENT '商品库存',

`p_gettime` date NULL COMMENT '商品入库时间',

PRIMARY KEY (`p_id`) 

);



CREATE TABLE `bill` (

`b_id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '账单号',

`u_id` varchar(6) NULL COMMENT '收款人',

`v_card` varchar(10) NULL COMMENT '会员卡号',

`p_id` varchar(15) CHARACTER SET utf8 NULL COMMENT '商品ID',

`p_num` int NULL DEFAULT 0 COMMENT '购买数量',

`b_money` float(7,2) UNSIGNED NULL DEFAULT 0.00 COMMENT '账单总价',

`b_discont` float(3,2) UNSIGNED NULL DEFAULT 1 COMMENT '账单折扣',

`s_card` varchar(10) CHARACTER SET utf8 NULL COMMENT '购物卡号',

`b_time` datetime NULL COMMENT '账单日期',

PRIMARY KEY (`b_id`) 

);



CREATE TABLE `shopcard` (

`s_card` varchar(10) CHARACTER SET utf8 NOT NULL DEFAULT "" COMMENT '购物卡号',

`v_card` varchar(10) NULL DEFAULT "" COMMENT '会员卡号',

`s_money` float(7,2) NULL DEFAULT 0.00 COMMENT '金额',

PRIMARY KEY (`s_card`) 

);



CREATE TABLE `user` (

`u_id` varchar(6) NOT NULL DEFAULT "" COMMENT '收款人工号',

`u_name` varchar(10) CHARACTER SET utf8 NULL DEFAULT "" COMMENT '收款人姓名',

`u_password` varchar(20) CHARACTER SET utf8 NULL DEFAULT "" COMMENT '收款人密码',

PRIMARY KEY (`u_id`) 

);



