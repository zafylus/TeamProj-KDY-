-- 상품 등록 테이블
CREATE TABLE product(
	pr_code CHAR(8) NOT NULL PRIMARY KEY,
	pr_name VARCHAR(50) NOT NULL,
	pr_price INT NOT NULL,
	pr_ctgry VARCHAR(20)
);
SELECT * FROM product;

INSERT INTO product VALUES ('01010003', 'ㅋ', 4000, '커피');
UPDATE product SET prodname = '바닐라라떼', price = 6000, category = '커피' WHERE prodno = '01010003'
DELETE from product WHERE prodno = '01010003';
SELECT MAX(prodno) FROM product WHERE category = '커피';

SELECT * from material;
SELECT * FROM product_ingredient

-- 판매 기록 테이블
CREATE TABLE orderlist(
	odr_no INT AUTO_INCREMENT,
	pr_code VARCHAR(5) NOT NULL,
	amount INT NOT NULL,
	odr_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(odr_no, pr_code),
	CONSTRAINT fk_odrlst_pr_code FOREIGN KEY(pr_code)
	REFERENCES product(pr_code)
		ON UPDATE cascade
		ON DELETE cascade
);
ALTER TABLE orderlist AUTO_INCREMENT=20230001;
SELECT * FROM orderlist ORDER BY odr_date desc

INSERT INTO orderlist (pr_code, amount, odr_date) VALUES 
('PR001', 5 , '2023-07-01'),
('PR001', 1 , '2023-07-10'),
('PR001', 2 , '2023-07-11'),
('PR001', 4 , '2023-07-20'),
('PR001', 9 , '2023-03-24'),
('PR001', 1 , '2023-08-05'),
('PR002', 1 , '2023-10-01'),
('PR002', 3 , '2023-12-05'),
('PR002', 2 , '2023-01-13'),
('PR002', 4 , '2023-05-22'),
('PR002', 2 , '2023-02-28'),
('PR003', 1 , '2023-05-01'),
('PR003', 1 , '2023-07-15'),
('PR003', 2 , '2023-11-30'),
('PR501', 1 , '2023-04-15');

--판매기록
CREATE VIEW ordr_view AS
SELECT o.odr_no, p.pr_code, p.pr_name, p.pr_price, o.amount,
p.pr_price*o.amount AS sales, o.odr_date
FROM product p, orderlist o WHERE p.pr_code = o.pr_code ORDER BY odr_date DESC;
SELECT * FROM ordr_view;

-- 일별 매출 기록
SELECT pr_code, pr_name, amount, sales
FROM ordr_view
WHERE odr_date = '2023-06-01'
GROUP BY pr_code
ORDER BY sales DESC

--매출
CREATE VIEW sales_date as
SELECT DATE(odr_date) DATE , SUM(sales) sales
FROM ordr_view
GROUP BY odr_date

SELECT * FROM sales_date
SELECT SUM(sales) FROM sales_date


-- 월 매출
SELECT DATE_FORMAT(odr_date, '%Y-%m') AS mon, SUM(sales)
FROM ordr_view
WHERE DATE_FORMAT(odr_date, '%Y-%m') = '2023-07'
GROUP BY mon


-- 기간 매출
SELECT DATE_FORMAT(DATE, '%Y-%m') AS odr_date, SUM(sales) sales
FROM sales_date
WHERE DATE(date) >= '2023-02-20' AND DATE(date) <= '2023-06-30'
GROUP BY odr_date