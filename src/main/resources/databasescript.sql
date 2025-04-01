DROP DATABASE if exists wishify;
CREATE DATABASE wishify;
USE wishify;

CREATE TABLE users(
                      user_id                 int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      email                   varchar(50) NOT NULL,
                      full_name               varchar(50) NOT NULL,
                      password                varchar(50) NOT NULL
);

INSERT INTO users (email, full_name, password) VALUES
                                                            ('frmo@dong', 'Frederik Morsing', 'blyat');


CREATE TABLE wishlist(
                         list_id                 int AUTO_INCREMENT PRIMARY KEY,
                         list_name               varchar(50) NOT NULL,
                         created_at              int,
                         user_id                 int NOT NULL,
                         FOREIGN KEY (user_id)   REFERENCES users(user_id)
);
INSERT INTO wishlist (list_name, created_at, user_id) VALUES
                                                          ('fødselsdags', 301200,1);


CREATE TABLE wish(
                     wish_id            int AUTO_INCREMENT PRIMARY KEY,
                     wish_name          varchar(50) NOT NULL,
                     wish_price              int DEFAULT NULL,
                     wish_description        varchar(200),
                     wish_quantity           int NOT NULL,
                     wish_priority           int DEFAULT NULL,
                     wish_booked_status      boolean DEFAULT FALSE,
                     wish_booked_by          varchar(50) DEFAULT NULL,
                     wish_picture            varchar(100) DEFAULT NULL,
                     wish_link            varchar(200) DEFAULT NULL,
                     list_id                 int NOT NULL,
                     FOREIGN KEY (list_id)   REFERENCES wishlist(list_id)
);

INSERT INTO wish (wish_name, wish_price, wish_description, wish_quantity, wish_priority, wish_booked_status,wish_booked_by, wish_picture, wish_link, list_id) VALUES
        ('Lenovo', 1000, 'PC', 1, 1, true, 'lucas', 'pcImg', 'www.lenovo.com', 1),
        ('Careve', 150, 'cream', 1, 3, true, 'Helle', 'creampng', 'www.Matas.dk', 1),
        ('T-shirt', 400, 'tshirt', 1, 3, true, 'Henrik', 'supremepng', 'www.supreme.com', 1),
        ('Bukser', 700, 'jeans', 1, 3, true, 'Martin', 'bukspng', 'www.bukser.com', 1),
        ('Kaffekop', 80, 'keramik', 5, 2, true, 'Astrid', 'kopjpeg', 'www.kerakop.com', 1)


