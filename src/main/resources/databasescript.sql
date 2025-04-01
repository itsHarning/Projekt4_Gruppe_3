DROP DATABASE if exists wishify;
CREATE DATABASE wishify;
USE wishify;

CREATE TABLE users(
                      user_id                 int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      email                   varchar(50) NOT NULL,
                      full_name               varchar(50) NOT NULL,
                      password                varchar(50) NOT NULL
);

CREATE TABLE wishlist(
                         list_id                 int AUTO_INCREMENT PRIMARY KEY,
                         list_name               varchar(50) NOT NULL,
                         created_at              int,
                         user_id                 int NOT NULL,
                         FOREIGN KEY (user_id)   REFERENCES users(user_id)
);

CREATE TABLE wish(
                     wish_id            int AUTO_INCREMENT PRIMARY KEY,
                     wish_name          varchar(50) NOT NULL,
                     price              int DEFAULT NULL,
                     description        varchar(200),
                     quantity           int NOT NULL,
                     priority           int DEFAULT NULL,
                     booked_status      boolean DEFAULT FALSE,
                     booked_by          varchar(50) DEFAULT NULL,
                     picture            varchar(100) DEFAULT NULL,
                     product_link            varchar(200) DEFAULT NULL,
                     list_id                 int NOT NULL,
                     FOREIGN KEY (list_id)   REFERENCES wishlist(list_id)
);


