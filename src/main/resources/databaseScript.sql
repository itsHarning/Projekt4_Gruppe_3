DROP DATABASE IF EXISTS wishify;
CREATE DATABASE wishify;
USE wishify;

CREATE TABLE user(
    user_id         INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email           VARCHAR(50) UNIQUE NOT NULL,
    full_name       VARCHAR(50) NOT NULL,
    password        VARCHAR(50) NOT NULL,
    profile_picture VARCHAR(50) DEFAULT NULL
);

INSERT INTO user (email, full_name, password, profile_picture) VALUES
                                                   ('frmo@dong.dk', 'Frederik Morsing', 'blyat', 'rickroll-roll.gif'),
                                                   ('julius@test.dk', 'Julius Test', '1234', 'Placeholder.jpg');


CREATE TABLE wishlist(
    list_id                 INT AUTO_INCREMENT PRIMARY KEY,
    list_name               VARCHAR(50) NOT NULL,
    list_description        VARCHAR(250),
    last_updated            DATE NOT NULL,
    list_image              VARCHAR(50) DEFAULT NULL,
    user_id                 INT NOT NULL,
    FOREIGN KEY (user_id)   REFERENCES user(user_id)
);

INSERT INTO wishlist (list_name, wishlist.list_description, last_updated, user_id) VALUES
                                                          ('fødselsdags', 'mine fødselsdags gaver', '2000-12-30', 1);

INSERT INTO wishlist (list_name, wishlist.list_description, last_updated, user_id) VALUES
                                                    ('juleønsker', 'mine juleaftens ønsker', '2000-12-30', 2);
INSERT INTO wishlist (list_name, wishlist.list_description, last_updated, list_image, user_id) VALUES
                                                    ('juleønsker', 'mine juleaftens ønsker', '2000-12-30','Placeholder.jpg', 2);

CREATE TABLE wish(
    wish_id                INT AUTO_INCREMENT PRIMARY KEY,
    wish_name              VARCHAR(50) NOT NULL,
    price                  INT DEFAULT NULL,
    wish_description       VARCHAR(250),
    quantity               INT NOT NULL,
    priority               INT DEFAULT NULL,
    booked_status          BOOLEAN DEFAULT FALSE,
    booked_by              VARCHAR(50) DEFAULT NULL,
    wish_image             VARCHAR(50) DEFAULT NULL,
    link                   VARCHAR(250) DEFAULT NULL,
    list_id                INT NOT NULL,
    FOREIGN KEY (list_id)  REFERENCES wishlist(list_id)
);

INSERT INTO wish (wish_name, price, wish_description, quantity, priority, booked_status,booked_by, wish_image, link, list_id) VALUES
        ('Lenovo', 1000, 'PC', 1, 1, true, 'lucas', 'Placeholder.jpg', 'www.lenovo.com', 1),
        ('Careve', 150, 'cream', 1, 3, true, 'Helle', 'Placeholder.jpg', 'www.Matas.dk', 1),
        ('T-shirt', 400, 'tshirt', 1, 3, true, 'Henrik', 'Placeholder.jpg', 'www.supreme.com', 1),
        ('Bukser', 700, 'jeans', 1, 3, true, 'Martin', 'Placeholder.jpg', 'www.bukser.com', 1),
        ('Kaffekop', 80, 'keramik', 5, 2, true, 'Astrid', 'Placeholder.jpg', 'www.kerakop.com', 1),
        ('Kaffekop', 80, 'keramik', 5, 2, true, 'Astrid', 'Placeholder.jpg', 'www.kerakop.com', 2)
;


