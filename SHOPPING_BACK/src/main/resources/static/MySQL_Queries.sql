create database shopping;

use shopping;

CREATE TABLE IF NOT EXISTS `address` (
	`id`   MEDIUMINT UNSIGNED  NOT NULL AUTO_INCREMENT,
   `entity_id`   MEDIUMINT UNSIGNED  NOT NULL,
   `street`      VARCHAR(60),
   `address`      VARCHAR(60),
   `city`         VARCHAR(15),
   `region`       VARCHAR(15),
   `postal_code`   VARCHAR(10),
   `country`      VARCHAR(15),
   PRIMARY KEY (`id`,`entity_id`),
   INDEX (`city`),
   INDEX (`postal_code`),
   INDEX (`region`)
       -- Build indexes on these columns for fast search
);

CREATE TABLE IF NOT EXISTS `customer` (
   `customer_id`   MEDIUMINT UNSIGNED  NOT NULL AUTO_INCREMENT,
   `company_name`  VARCHAR(40)  NOT NULL,
   `contact_name`  VARCHAR(30),
   `contact_title` VARCHAR(30),   
   `phone`        VARCHAR(24),
   `email`          VARCHAR(100),
   PRIMARY KEY (`customer_id`)
       -- Build indexes on these columns for fast search
);

CREATE TABLE IF NOT EXISTS `employee` (
   `employee_id`      MEDIUMINT UNSIGNED  NOT NULL AUTO_INCREMENT,
                     -- [0, 65535]
   `last_name`        VARCHAR(20)         NOT NULL,
   `first_name`       VARCHAR(10)         NOT NULL,
   `title`           VARCHAR(30),  -- e.g., 'Sales Coordinator'
   `title_of_courtesy` VARCHAR(25),  -- e.g., 'Mr.' 'Ms.' (ENUM??)
   `birth_date`       DATE,         -- 'YYYY-MM-DD'
   `hire_date`        DATE,
    `home_phone`       VARCHAR(24),
   `extension`       VARCHAR(4),
   `notes`           TEXT                NOT NULL,  -- 64KB
   `reports_to`       MEDIUMINT UNSIGNED  NULL,  -- Manager's ID
                                                -- Allow NULL for boss
   `photo_path`       VARCHAR(255),
   `salary`          INT,
   INDEX (`last_name`),
   PRIMARY KEY (`employee_id`),
   FOREIGN KEY (`reports_to`) REFERENCES `employee` (`employee_id`)
);
  
CREATE TABLE IF NOT EXISTS `region` (
   `region_id`           TINYINT UNSIGNED  NOT NULL AUTO_INCREMENT,
                        -- [0,255]
   `region_desc`  VARCHAR(50)       NOT NULL,
                        -- e.g., 'Eastern','Western','Northern','Southern'
                        -- Could use an ENUM and eliminate this TABLE IF NOT EXISTS
   PRIMARY KEY (`region_id`)
);

CREATE TABLE IF NOT EXISTS `category` (
   `category_id`   TINYINT UNSIGNED  NOT NULL AUTO_INCREMENT,
                  -- [0, 255], not expected to be large
   `category_name` VARCHAR(30)       NOT NULL,
                  -- e.g., 'Beverages','Condiments',etc
   `description`  TEXT,       -- up to 64KB characters
   `picture_path`      VARCHAR(255),       -- up to 64KB binary
   `discontinued`    BOOLEAN                 NOT NULL DEFAULT FALSE,
   PRIMARY KEY  (`category_id`),
   UNIQUE INDEX (`category_name`)
      -- Build index on this unique-value column for fast search
);

CREATE TABLE IF NOT EXISTS `supplier` (
   `supplier_id`   SMALLINT UNSIGNED  NOT NULL AUTO_INCREMENT,
                                     -- [0, 65535]
   `company_name`  VARCHAR(40)        NOT NULL,
   `contact_name`  VARCHAR(30),
   `contact_title` VARCHAR(30),
   `phone`        VARCHAR(24),
   `email`          VARCHAR(100),
   `website`     TEXT,          -- 64KB?? VARCHAR(255)?
    PRIMARY KEY (`supplier_id`),
    INDEX (`company_name`)
);

CREATE TABLE IF NOT EXISTS `product` (
   `product_id`       SMALLINT UNSIGNED       NOT NULL AUTO_INCREMENT,
   `product_name`     VARCHAR(40)             NOT NULL,
   `picture_path`      VARCHAR(255),
   `supplier_id`      SMALLINT UNSIGNED       NOT NULL,  -- one supplier only
   `category_id`      TINYINT UNSIGNED        NOT NULL,
   `quantity_per_unit` VARCHAR(20),            -- e.g., '10 boxes x 20 bags'
   `unit_price`       DECIMAL(10,2) UNSIGNED  DEFAULT 0,
   `units_in_stock`    SMALLINT                DEFAULT 0,  -- Negative??
   `units_on_order`    SMALLINT UNSIGNED       DEFAULT 0,
   `reorder_level`    SMALLINT UNSIGNED       DEFAULT 0,
   `discontinued`    BOOLEAN                 NOT NULL DEFAULT FALSE,
   PRIMARY KEY (`product_id`),
   INDEX (`product_name`),
   FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
   FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`)
);

CREATE TABLE IF NOT EXISTS `shipper` (
   `shipper_id`   TINYINT UNSIGNED  NOT NULL AUTO_INCREMENT,
   `company_name` VARCHAR(40)       NOT NULL,
   `phone`       VARCHAR(24),
   `email`          VARCHAR(100),
   PRIMARY KEY (`shipper_id`)
);

CREATE TABLE IF NOT EXISTS `order` (
   `order_id`        INT UNSIGNED        NOT NULL AUTO_INCREMENT,
                    -- Use UNSIGNED INT to avoid run-over
   `customer_id`     MEDIUMINT UNSIGNED  NOT NULL,
   `employee_id`     MEDIUMINT UNSIGNED  NOT NULL,
   `order_date`      DATE,
   `required_date`   DATE,
   `shipped_date`    DATE,
   `ship_via`        TINYINT UNSIGNED,
   `freight`        DECIMAL(10,2) UNSIGNED  DEFAULT 0,
   `ship-name`       VARCHAR(40),
   `ship_dddress`    VARCHAR(60),
   `ship_city`       VARCHAR(15),
   `ship_region`     VARCHAR(15),
   `ship_postal_code` VARCHAR(10),
   `ship_country`    VARCHAR(15),
   PRIMARY KEY (`order_id`),
   INDEX (`order_date`),
   INDEX (`shipped_date`),
   INDEX (`ship_postal_code`),
   FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
   FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
   FOREIGN KEY (`ship_via`)    REFERENCES `shipper`  (`shipper_id`)
);

-- Many-to-many Junction TABLE IF NOT EXISTS between Orders and Products
CREATE TABLE IF NOT EXISTS `order_detail` (
   `order_id`   INT UNSIGNED           NOT NULL,
   `product_id` SMALLINT UNSIGNED      NOT NULL,
   `unit_price` DECIMAL(8,2) UNSIGNED  NOT NULL DEFAULT 999999.99,
                                      -- max value as default
   `ouantity`  SMALLINT(2) UNSIGNED   NOT NULL DEFAULT 1,
   `discount`  DOUBLE(8,0)            NOT NULL DEFAULT 0, -- e.g., 0.15
   PRIMARY KEY (`order_id`, `product_id`),
   FOREIGN KEY (`order_id`)   REFERENCES `order`   (`order_id`),
   FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
);

CREATE TABLE IF NOT EXISTS `cart` (
   `cart_id`        INT UNSIGNED        NOT NULL AUTO_INCREMENT,
                    -- Use UNSIGNED INT to avoid run-over
   `customer_id`     MEDIUMINT UNSIGNED  NOT NULL,
   `cart_date`      DATE,
   PRIMARY KEY (`cart_id`),
   INDEX (`cart_date`),
   FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
);

CREATE TABLE IF NOT EXISTS `cart_detail` (
   `cart_id`        INT UNSIGNED        NOT NULL,
                    -- Use UNSIGNED INT to avoid run-over
   `customer_id`     MEDIUMINT UNSIGNED  NOT NULL,
   `product_id`     SMALLINT UNSIGNED  NOT NULL,
   `date_added`      DATE,
	`unit_price` DECIMAL(8,2) UNSIGNED  NOT NULL DEFAULT 999999.99,-- max value as default
   `quantity`  SMALLINT(2) UNSIGNED   NOT NULL DEFAULT 1,
   PRIMARY KEY (`cart_id`,`customer_id`,`product_id`),
   INDEX (`date_added`),
   FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
   FOREIGN KEY (`cart_id`)   REFERENCES `cart`   (`cart_id`),
   FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
);


CREATE TABLE IF NOT EXISTS `customer_demographic` (
   `customer_type_id`  VARCHAR(10)  NOT NULL,
   `customer_desc`    TEXT,        -- 64KB
   PRIMARY KEY (`customer_type_id`)
);


CREATE TABLE IF NOT EXISTS `customer_custom_demo` (
   `customer_id`     MEDIUMINT UNSIGNED  NOT NULL,
   `customer_type_id` VARCHAR(10)  NOT NULL,
   PRIMARY KEY (`customer_id`, `customer_type_id`),
   FOREIGN KEY (`customer_type_id`) REFERENCES `customer_demographic` (`customer_type_id`),
   FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
);

alter table customer
add column password varchar(50);
alter table customer
add column is_active boolean default true;

alter table employee
add column is_active boolean default true;
alter table employee
add column password varchar(50);

alter table supplier
add column is_active boolean default true;

alter table shipper
add column is_active boolean default true;

INSERT INTO `shopping`.`category` (`category_id`, `category_name`, `description`, `picture_path`, `discontinued`) VALUES ('1', 'Apple Products', 'Apple\'s Electronics', 'apple.png', 0);
