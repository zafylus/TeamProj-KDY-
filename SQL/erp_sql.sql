--주문 테이블
CREATE TABLE order_tbl(
	odr_code VARCHAR(12) PRIMARY KEY,
	odr_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP()
);

SELECT * FROM order_tbl ORDER BY odr_code DESC;
SELECT MAX(odr_code) FROM order_tbl

insert INTO order_tbl VALUES
('OR016', '2023-08-02'),
('OR017', '2023-08-04'),
('OR018', '2023-08-06'),
('OR019', '2023-08-08'),
('OR020', '2023-08-10'),
('OR021', '2023-08-12'),
('OR022', '2023-08-14'),
('OR023', '2023-08-16');


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
('OR020','PR001', 5),
('OR020','PR001', 1 ),
('OR021','PR001', 2 ),
('OR021','PR001', 4 ),
('OR022','PR001', 9 ),
('OR022','PR001', 1 ),
('OR022','PR002', 1 ),
('OR023','PR002', 3 ),
('OR022','PR002', 2 ),
('OR022','PR002', 4 ),
('OR023','PR002', 2 ),
('OR023','PR003', 1 ),
('OR023','PR003', 1 ),
('OR023','PR003', 2 ),
('OR023','PR501', 1 );


--판매기록
CREATE VIEW ordr_view AS
SELECT ot.odr_code, p.pr_code, p.pr_name, p.pr_price,
       SUM(o.amount) AS amount,
       SUM(p.pr_price * o.amount) AS sales,
       MAX(ot.odr_date) AS order_date
FROM product p
JOIN orderlist o ON p.pr_code = o.pr_code
JOIN order_tbl ot ON o.odr_code = ot.odr_code
GROUP BY ot.odr_code, p.pr_code, p.pr_name, p.pr_price
ORDER BY ot.odr_code DESC;

SELECT * FROM ordr_view;
SELECT * FROM ordr_view
WHERE order_date BETWEEN DATE_SUB(CURRENT_DATE(), INTERVAL 6 MONTH) AND CURRENT_DATE()+1;
SELECT order_date, odr_code, sum(sales) total_sales
FROM ordr_view
WHERE order_date BETWEEN '2023-07-25 00:00:00' and '2023-07-25 23:59:59'
GROUP BY odr_code
HAVING sum(sales) >=0 AND (sum(sales) >= 0 AND sum(sales) <= 100000) AND odr_code = 'or001';
SELECT order_date, odr_code, sum(sales) total_sales FROM ordr_view 
WHERE order_date BETWEEN '2023-06-01 00:00:00' and '2026-08-16 23:59:59' 
GROUP BY odr_code 
HAVING sum(sales)AND (sum(sales) >= 0 AND sum(sales) <= 80000) AND odr_code = 'or001';


-- 일별 매출 기록
SELECT pr_code, pr_name, sum(amount) AS amount, sum(sales) AS sales
FROM ordr_view
WHERE order_date BETWEEN '2023-07-25 00:00:00' and '2023-07-25 23:59:59'
GROUP BY pr_code
ORDER BY sales DESC

--일별 매출
CREATE VIEW sales_date AS
SELECT DATE(order_date) DATE , SUM(sales) sales
FROM ordr_view
GROUP BY date;

SELECT * FROM sales_date ORDER BY DATE desc;

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
