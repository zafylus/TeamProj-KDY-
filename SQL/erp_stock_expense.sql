CREATE TABLE expense (
   ex_no INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   ma_code CHAR(5) NOT NULL,
   ex_cost INT,
   ex_ea INT,
   ex_date TIMESTAMP,
   ex_note VARCHAR(100)
);
ALTER TABLE expense AUTO_INCREMENT = 20230001;

INSERT INTO expense VALUE (NULL, 'MA001', 15000, 10, NOW(), null);
INSERT INTO expense VALUE (NULL, 'MA001', null, -5, NOW(), NULL);
INSERT INTO expense VALUE (NULL, 'MA001', 15000, 5, CURRENT_TIMESTAMP, null);
INSERT INTO expense VALUE (NULL, 'MA002', 2000, 5, CURRENT_TIMESTAMP, NULL);

[도수현] [오전 9:59] CREATE TABLE st_option (
   alram BOOLEAN,
   alramNum int
);

[도수현] [오전 9:59] INSERT INTO st_option VALUE (TRUE, 5);

CREATE TABLE material (
   ma_code CHAR(5) NOT NULL PRIMARY KEY,
   ma_name VARCHAR(20),
   ma_cost int
);

INSERT INTO material VALUE ('MA001', '원두', 15000);
INSERT INTO material VALUE ('MA002', '우유', 2000);
INSERT INTO material VALUE ('MA003', '시럽', 5000);

CREATE TABLE stock (
   st_no INT PRIMARY KEY AUTO_INCREMENT,
   ma_code CHAR(5) NOT NULL,
   st_ea INT,
   st_recDate TIMESTAMP,
   st_note VARCHAR(100)
);

ALTER TABLE stock AUTO_INCREMENT = 100001;

INSERT INTO stock VALUE (NULL, 'MA001', 10, NOW(), null);
INSERT INTO stock VALUE (NULL, 'MA001', -5, NOW(), null);
INSERT INTO stock VALUE (NULL, 'MA001', 10, NOW(), null);
INSERT INTO stock VALUE (NULL, 'MA002', 15, NOW(), NULL);
INSERT INTO stock VALUE (NULL, 'MA003', 1, NOW(), NULL);
INSERT INTO stock VALUE (NULL, 'MA001', -10, NOW(), NULL);
INSERT INTO stock VALUE (NULL, 'MA001', -5, NOW(), null);
INSERT INTO stock VALUE (NULL, 'MA002', -10, NOW(), NULL);
INSERT INTO stock VALUE (NULL, 'MA001', 5, NOW(), NULL);
INSERT INTO stock VALUE (NULL, 'MA002', -5, NOW(), NULL);
INSERT INTO stock VALUE (NULL, 'MA002', 3, NOW(), NULL);

INSERT INTO stock VALUE (NULL, 'MA001', 3, '2023-07-03', null);
INSERT INTO stock VALUE (NULL, 'MA002', 3, '2023-07-03', NULL);
INSERT INTO stock VALUE (NULL, 'MA003', 1, '2023-07-03', NULL);