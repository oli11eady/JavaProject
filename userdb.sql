DROP TABLE IF EXISTS user;

CREATE TABLE user (
user_id INT NOT NULL AUTO_INCREMENT,
user_name VARCHAR(50) NOT NULL,
user_pass VARCHAR(50) NOT NULL,
status VARCHAR(50) NOT NULL,
PRIMARY KEY (user_id)
);
