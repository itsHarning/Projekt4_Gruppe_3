CREATE DATABASE wishify;
USE wishify;

CREATE TABLE users(
                      user_id                 int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      user_email              varchar(50) NOT NULL,
                      user_fullname           varchar(50) NOT NULL,
                      password                varchar(50) NOT NULL
);

CREATE TABLE wishlist(
                         list_id                 int AUTO_INCREMENT PRIMARY KEY,
                         list_name               varchar(50) NOT NULL,
                         list_created_at         int,
                         user_id                 int NOT NULL,
                         FOREIGN KEY (user_id)   REFERENCES users(user_id)
);

CREATE TABLE wish(
                     wish_id                 int AUTO_INCREMENT PRIMARY KEY,
                     wish_name               varchar(50) NOT NULL,
                     wish_price              int DEFAULT NULL,
                     wish_description        varchar(200),
                     wish_quantity           int NOT NULL,
                     wish_priority           int DEFAULT NULL,
                     wish_booked_status      boolean DEFAULT FALSE,
                     wish_booked_by          varchar(50) DEFAULT NULL,
                     wish_picture            varchar(100) DEFAULT NULL,
                     product_link            varchar(200) DEFAULT NULL,
                     list_id                 int NOT NULL,
                     FOREIGN KEY (list_id)   REFERENCES wishlist(list_id)
);


