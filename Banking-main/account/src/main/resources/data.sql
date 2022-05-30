DROP TABLE IF EXISTS accounts;

CREATE TABLE `accounts` (
  `account_number` int AUTO_INCREMENT PRIMARY KEY,
  `customer_id` int NOT NULL,
  `account_type` varchar(100) NOT NULL,
  `branch_address` varchar(200) NOT NULL,
  `create_dt` date DEFAULT NULL
);
 
INSERT INTO `accounts` (`customer_id`, `account_type`, `branch_address`, `create_dt`) VALUES (100, 'Savings', '123 Main Street, New York', CURDATE());
INSERT INTO `accounts` (`customer_id`, `account_type`, `branch_address`, `create_dt`) VALUES (101, 'Salary', '456 Main Street, India', CURDATE());
 