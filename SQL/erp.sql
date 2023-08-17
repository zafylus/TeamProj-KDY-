drop TABLE stock;
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

DROP TABLE expense;
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
INSERT INTO expense VALUE (NULL, 'MA002', 2000, 5, CURRENT_TIMESTAMP, null);

DROP TABLE material;
CREATE TABLE material (
	ma_code CHAR(5) NOT NULL PRIMARY KEY,
	ma_name VARCHAR(20),
	ma_cost int
);

INSERT INTO material VALUE ('MA001', '원두', 15000);
INSERT INTO material VALUE ('MA002', '우유', 2000);
INSERT INTO material VALUE ('MA003', '시럽', 5000);

SELECT * FROM material;

DROP TABLE fixedcost;
CREATE TABLE fixedcost (
	fi_no INT NOT NULL PRIMARY KEY,
	fi_name VARCHAR(20) NOT NULL,
	fi_cost INT,
	fi_date INT
);

DELETE FROM fixedcost WHERE f_name = '임대료';
INSERT INTO fixedcost VALUE (1, '임대료',1000000 , 20);
INSERT INTO fixedcost VALUE (2, '인터넷',30000 , 25);

INSERT INTO material VALUE ('M001', '원두', '음료');

SELECT s_totalAmount FROM stock WHERE m_code = 'M001' ORDER BY s_no DESC LIMIT 1;

SELECT s_totalAmount FROM stock WHERE m_code = 'M001' ORDER BY recDate DESC LIMIT 1;

SELECT * FROM expense WHERE date(e_date) BETWEEN '2023-06-20' AND '2023-06-21';

SELECT m.m_name, SUM(s.s_amount) total
FROM stock s , material m
WHERE s.m_code = m.m_code
GROUP BY s.m_code
ORDER BY recDate DESC;

UPDATE fixedcost SET f_date = 21 WHERE f_name = '임대료';


CREATE TABLE employee (
	em_no INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	em_name VARCHAR(10) NOT NULL,
	em_position VARCHAR(10),
	em_joinDate DATE
);



ALTER TABLE employee AUTO_INCREMENT = 0001;

SELECT s.st_no, m.ma_name, s.st_ea, s.st_recDate, s.st_note
FROM stock s LEFT join  material m
on s.ma_code = m.ma_code
ORDER BY st_no DESC;

SELECT s.st_no, m.ma_name, s.st_ea, s.st_recDate, s.st_note 
FROM stock s LEFT join  material m
on s.ma_code = m.ma_code
ORDER BY st_no DESC LIMIT 60, 20;

SELECT COUNT(*) FROM stock;

DROP TABLE st_option;
CREATE TABLE st_option (
	alram BOOLEAN,
	alramNum int
);

DELETE FROM st_option alram;
INSERT INTO st_option VALUE (TRUE, 5);


CREATE VIEW stockList
as
SELECT s.st_no, m.ma_name, s.st_ea, s.st_recDate, s.st_note 
FROM stock s,  material m
WHERE s.ma_code = m.ma_code;

ORDER BY st_no DESC LIMIT 0, 20

SELECT * FROM stocklist
WHERE date(st_recDate) BETWEEN '2023-07-01' AND '2023-07-17'
ORDER BY st_recDate DESC LIMIT 0, 20;

DROP VIEW expenselist;
CREATE VIEW expenseList
AS
SELECT e.ex_no, m.ma_name, e.ex_cost, e.ex_ea, e.ex_date, e.ex_note
FROM expense e, material m
WHERE e.ma_code = m.ma_code;

SELECT * FROM expenselist
WHERE DATE(ex_date) BETWEEN '2023-07-16' AND '2023-07-18'
ORDER BY ex_date DESC LIMIT 0, 20;

CREATE TABLE product (
	pr_code CHAR(5) PRIMARY KEY,
	pr_name VARCHAR(50) NOT NULL,
	pr_price INT NOT NULL,
	pr_ctgry VARCHAR(20)
);

INSERT INTO product VALUES ('PR001', '아메리카노', 4000, '커피'),
('PR002', '카페라떼', 5000, '커피'),
('PR003', '바닐라라떼', 6000, '커피'),
('PR501', '빵', 3000, '디저트');

DROP TABLE recipe;
CREATE TABLE recipe (
	pr_code CHAR(5),
		FOREIGN KEY(pr_code) REFERENCES product(pr_code)
		ON UPDATE cascade,
	ma001 double,
	ma002 double,
	ma003 double
);

INSERT INTO recipe VALUES ('PR001', 0.02, 0, 0),
('PR002', 0.02, 0.2, 0),
('PR003', 0.02, 0.2, 0.05);

SELECT p.pr_name, r.ma001, r.ma002, r.ma003
FROM recipe r, product p
WHERE r.pr_code = p.pr_code

DROP VIEW Totalstock
CREATE VIEW TotalStock 
AS 
SELECT m.ma_name AS ma_name, SUM(s.st_ea) AS TotalEa
FROM stock s, material m
WHERE s.ma_code = m.ma_code
GROUP BY s.ma_code;

SELECT * FROM totalstock;

CREATE TABLE login(
	id VARCHAR(20) PRIMARY KEY,
	pw VARCHAR(20)
);

INSERT INTO login VALUES ('admin', '1234');