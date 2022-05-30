DROP TABLE IF EXISTS customers;

CREATE TABLE `customers` (
  `id` int AUTO_INCREMENT  PRIMARY KEY,
  `customer_id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobile_number` varchar(20) NOT NULL,
  `create_dt` date DEFAULT NULL
);

INSERT INTO `customers` (`customer_id`,`name`,`email`,`mobile_number`,`create_dt`) VALUES (100,'Ramkumar R','ram@abc.com','9876432101',CURDATE());
INSERT INTO `customers` (`customer_id`,`name`,`email`,`mobile_number`,`create_dt`) VALUES (101,'Saranya R','sara@abc.com','9765432189',CURDATE());