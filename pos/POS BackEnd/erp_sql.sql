--주문 테이블
CREATE TABLE order_tbl(
	odr_code VARCHAR(12) PRIMARY KEY,
	odr_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP()
);
DROP TABLE order_tbl
INSERT INTO order_tbl (odr_code) VALUES
('OR0000000001'), ('OR0000000006'); 
DELETE FROM order_tbl WHERE odr_code = 'or10'
SELECT * FROM order_tbl ORDER BY odr_code DESC;
SELECT MAX(odr_code) FROM order_tbl


--판매기록
CREATE VIEW ordr_view AS
SELECT o.odr_no, ot.odr_code, p.pr_code, p.pr_name, p.pr_price, o.amount, p.pr_price*o.amount AS sales, ot.odr_date AS order_date
FROM product p, orderlist o, order_tbl ot 
WHERE p.pr_code = o.pr_code 
GROUP BY o.odr_no
oRDER BY order_date DESC;

SELECT * FROM ordr_view;


-- 주문 상세  테이블
CREATE TABLE orderlist(
	odr_no INT,
	odr_code VARCHAR(12) NOT null,
	pr_code VARCHAR(5) NOT NULL,
	amount INT NOT NULL,
	PRIMARY KEY(odr_no, odr_code, pr_code),
	CONSTRAINT fk_odrlst_odr_code FOREIGN KEY(odr_code)
	REFERENCES order_tbl(odr_code)
		ON UPDATE cascade
		ON DELETE CASCADE,
	CONSTRAINT fk_odrlst_pr_code FOREIGN KEY(pr_code)
	REFERENCES product(pr_code)
		ON UPDATE cascade
);
DESC orderlist
ALTER TABLE orderlist MODIFY odr_no int AUTO_INCREMENT;
ALTER TABLE orderlist AUTO_INCREMENT = 20230001;
SELECT * FROM orderlist ORDER BY odr_no desc

INSERT INTO orderlist (odr_code, pr_code, amount) values
('OR001', 'PR001', 5),
('OR001','PR001', 1 ),
('OR001','PR001', 2 ),
('OR002','PR001', 4 ),
('OR002','PR001', 9 ),
('OR002','PR001', 1 ),
('OR002','PR002', 1 ),
('OR002','PR002', 3 ),
('OR003','PR002', 2 ),
('OR003','PR002', 4 ),
('OR005','PR002', 2 ),
('OR004','PR003', 1 ),
('OR004','PR003', 1 ),
('OR005','PR003', 2 ),
('OR005','PR501', 1 );


-- 일별 매출 기록
SELECT pr_code, pr_name, sum(amount) AS amount, sum(sales) AS sales
FROM ordr_view
WHERE order_date BETWEEN '2023-07-25 00:00:00' and '2023-07-25 23:59:59'
GROUP BY pr_code
ORDER BY sales DESC

--일별 매출
CREATE VIEW sales_date as
SELECT DATE(order_date) DATE , SUM(sales) sales
FROM ordr_view
GROUP BY order_date;

SELECT * FROM sales_date;

--총매출
SELECT SUM(sales) FROM sales_date


-- 월 매출
SELECT DATE_FORMAT(order_date, '%Y-%m') AS mon, SUM(sales)
FROM ordr_view
WHERE DATE_FORMAT(order_date, '%Y-%m') = '2023-07'
GROUP BY mon


-- 기간 매출
SELECT DATE_FORMAT(DATE, '%Y-%m') AS order_date, SUM(sales) sales
FROM sales_date
WHERE DATE(date) >= '2023-02-20' AND DATE(date) <= '2023-07-30'
GROUP BY order_date