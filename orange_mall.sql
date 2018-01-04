
CREATE TABLE `user` (

`id` int UNSIGNED NOT NULL AUTO_INCREMENT,

`name` varchar(22) NOT NULL,

`user_phone` varchar(33) NOT NULL,

`password` varchar(33) NOT NULL,

PRIMARY KEY (`id`) 

);



CREATE TABLE `fruit` (

`fruit_no` int UNSIGNED NOT NULL AUTO_INCREMENT,

`fruit_name` varchar(11) NOT NULL,

`fruit_price` decimal NOT NULL,

`fruit_content` varchar(33) NULL,

PRIMARY KEY (`fruit_no`) 

);



CREATE TABLE `clothes` (

`clothes_no` int UNSIGNED NOT NULL AUTO_INCREMENT,

`clothes_name` varchar(22) NOT NULL,

`clothes_price` decimal NOT NULL,

`clothes_content` varchar(33) NOT NULL,

PRIMARY KEY (`clothes_no`) 

);



CREATE TABLE `shoes` (

`shoes_no` int UNSIGNED NOT NULL AUTO_INCREMENT,

`shoes_name` varchar(22) NOT NULL,

`shoes_price` decimal NULL,

`shoes_content` varchar(33) NULL,

PRIMARY KEY (`shoes_no`) 

);



CREATE TABLE `food` (

`food_no` int UNSIGNED NOT NULL AUTO_INCREMENT,

`food_name` varchar(22) NULL,

`food_price` decimal NULL,

`food_content` varchar(33) NULL,

PRIMARY KEY (`food_no`) 

);



CREATE TABLE `cart` (

`cart_no` int UNSIGNED NOT NULL AUTO_INCREMENT,

`price` float(6,2) NOT NULL,

`number` int NOT NULL,

`uid` int NULL,

PRIMARY KEY (`cart_no`) 

);



CREATE TABLE `cartItem` (

`id` int UNSIGNED NOT NULL AUTO_INCREMENT,

`pid` int UNSIGNED NOT NULL AUTO_INCREMENT,

`number` int NOT NULL,

`cart_no` int NOT NULL,

PRIMARY KEY (`id`) 

);



CREATE TABLE `order_` (

`id` int UNSIGNED NOT NULL AUTO_INCREMENT,

`orderCode` varchar(22) NULL,

`cartid` int NULL,

`uid` int NULL,

`address` varchar(44) NOT NULL,

`post` varchar(22) NOT NULL,

`receiver` varchar(22) NULL,

`mobile` varchar(22) NULL,

`userMessage` varchar(44) NULL,

`createDate` timestamp NULL,

`payDate` timestamp NULL,

`deliveryDate` timestamp NULL,

`confirmDate` timestamp NULL,

`status` varchar(22) NULL,

`price` float(6,2) NULL

);



CREATE TABLE `Property` (

`id` int UNSIGNED NOT NULL AUTO_INCREMENT,

`cid` int NOT NULL,

`name` varchar(22) NULL,

PRIMARY KEY (`id`) 

);



CREATE TABLE `PropertyValue` (

`id` int UNSIGNED NOT NULL AUTO_INCREMENT,

`pid` int NULL,

`ptid` int NULL,

`value` varchar(22) NULL,

PRIMARY KEY (`id`) 

);



CREATE TABLE `OrderItem` (

`id` int UNSIGNED NOT NULL AUTO_INCREMENT,

`pid` int NULL,

`oid` int NULL,

`uid` int NULL,

`number` int NULL COMMENT '商品购买的数量',

PRIMARY KEY (`id`) 

);



CREATE TABLE `Product` (

`id` int UNSIGNED NOT NULL AUTO_INCREMENT,

`name` varchar(22) NOT NULL,

`subTitle` varchar(22) NOT NULL,

`orignalPrice` float(6,2) NOT NULL,

`promotePrice` float(6,2) NOT NULL,

`stock` int NULL,

`cid` int NULL,

`createDate` timestamp NULL,

PRIMARY KEY (`id`) 

);



CREATE TABLE `ProductImage` (

`id` int UNSIGNED NOT NULL AUTO_INCREMENT,

`type` varchar(33) NULL,

`pid` int NULL,

PRIMARY KEY (`id`) 

);



CREATE TABLE `Review` (

`id` int UNSIGNED NOT NULL AUTO_INCREMENT,

`content` varchar(99) NULL,

`uid` int NULL,

`pid` int NULL,

`create_data` timestamp NULL,

PRIMARY KEY (`id`) 

);



CREATE TABLE `categorys` (

`id` varchar(22) NOT NULL,

`name` varchar(33) NOT NULL,

PRIMARY KEY (`id`) 

);



CREATE TABLE `catogorys` (

`id` varchar(22) NOT NULL,

`name` varchar(33) NULL,

PRIMARY KEY (`id`) 

);





ALTER TABLE `cart` ADD CONSTRAINT `fk_basket_user_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`);

ALTER TABLE `order_` ADD CONSTRAINT `fk_order_user_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`);

ALTER TABLE `cartItem` ADD CONSTRAINT `fk_cartno_cart` FOREIGN KEY (`cart_no`) REFERENCES `cart` (`cart_no`);

ALTER TABLE `order_` ADD CONSTRAINT `fk_order__cart_1` FOREIGN KEY (`cartid`) REFERENCES `cart` (`cart_no`);

ALTER TABLE `Product` ADD CONSTRAINT `fk_Product_catogorys_1` FOREIGN KEY (`cid`) REFERENCES `catogorys` (`id`);

ALTER TABLE `ProductImage` ADD CONSTRAINT `fk_ProductImage_Product_1` FOREIGN KEY (`pid`) REFERENCES `Product` (`id`);

ALTER TABLE `PropertyValue` ADD CONSTRAINT `fk_PropertyValue_Product_1` FOREIGN KEY (`pid`) REFERENCES `Product` (`id`);

ALTER TABLE `Review` ADD CONSTRAINT `fk_Review_user_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`);

ALTER TABLE `Review` ADD CONSTRAINT `fk_Review_Product_1` FOREIGN KEY (`pid`) REFERENCES `Product` (`id`);

ALTER TABLE `OrderItem` ADD CONSTRAINT `fk_OrderItem_user_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`);

ALTER TABLE `Property` ADD CONSTRAINT `fk_Property_catogorys_1` FOREIGN KEY (`cid`) REFERENCES `catogorys` (`id`);

ALTER TABLE `PropertyValue` ADD CONSTRAINT `fk_PropertyValue_Property_1` FOREIGN KEY (`ptid`) REFERENCES `Property` (`id`);

ALTER TABLE `OrderItem` ADD CONSTRAINT `fk_OrderItem_Product_1` FOREIGN KEY (`pid`) REFERENCES `Product` (`id`);

ALTER TABLE `OrderItem` ADD CONSTRAINT `fk_OrderItem_order__1` FOREIGN KEY (`oid`) REFERENCES `order_` (`id`);



