CREATE DATABASE IF NOT EXISTS temperature;
USE temperature;

CREATE TABLE IF NOT EXISTS temperature (
        temp_id INT(11) AUTO_INCREMENT NOT NULL,
        temp_value INT(11) NOT NULL,
        PRIMARY KEY (temp_id)
);