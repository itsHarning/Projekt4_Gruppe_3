DROP DATABASE IF EXISTS wishify;
CREATE DATABASE wishify;
USE wishify;

CREATE TABLE users(
    user_id         INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email           VARCHAR(50) NOT NULL,
    full_name       VARCHAR(50) NOT NULL,
    password        VARCHAR(50) NOT NULL,
    profile_picture VARCHAR(50)
);

INSERT INTO users (email, full_name, password, profile_picture) VALUES
                                                   ('frmo@dong.dk', 'Frederik Morsing', 'blyat', 'Placeholder.jpg');

CREATE TABLE wishlist(
    list_id                 INT AUTO_INCREMENT PRIMARY KEY,
    list_name               VARCHAR(50) NOT NULL,
    list_description        VARCHAR(200),
    created_at              INT,
    user_id                 INT NOT NULL,
    list_image              VARCHAR(50),
    FOREIGN KEY (user_id)   REFERENCES users(user_id)
);

INSERT INTO wishlist (list_name, wishlist.list_description, created_at, user_id, list_image) VALUES
                                                          ('fødselsdags', 'mine fødselsdags gaver', 301200, 1,'Placeholder.jpg');

CREATE TABLE wish(
    wish_id                INT AUTO_INCREMENT PRIMARY KEY,
    wish_name              VARCHAR(50) NOT NULL,
    price                  INT DEFAULT NULL,
    wish_description       VARCHAR(200),
    quantity               INT NOT NULL,
    priority               INT DEFAULT NULL,
    booked_status          BOOLEAN DEFAULT FALSE,
    booked_by              VARCHAR(50) DEFAULT NULL,
    wish_image             VARCHAR(100) DEFAULT NULL,
    link                   VARCHAR(200) DEFAULT NULL,
    list_id                INT NOT NULL,
    FOREIGN KEY (list_id)  REFERENCES wishlist(list_id)
);

INSERT INTO wish (wish_name, price, wish_description, quantity, priority, booked_status,booked_by, wish_image, link, list_id) VALUES
        ('Lenovo', 1000, 'PC', 1, 1, true, 'lucas', 'pcImg', 'www.lenovo.com', 1),
        ('Careve', 150, 'cream', 1, 3, true, 'Helle', 'creampng', 'www.Matas.dk', 1),
        ('T-shirt', 400, 'tshirt', 1, 3, true, 'Henrik', 'supremepng', 'www.supreme.com', 1),
        ('Bukser', 700, 'jeans', 1, 3, true, 'Martin', 'bukspng', 'www.bukser.com', 1),
        ('Kaffekop', 80, 'keramik', 5, 2, true, 'Astrid', 'kopjpeg', 'www.kerakop.com', 1)


