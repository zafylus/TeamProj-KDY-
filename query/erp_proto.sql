-- Create Table -- 
CREATE TABLE sale(
	sa_no INT,
	pr_no VARCHAR(5),
	pr_price INT,
	pr_ea INT,
	sa_date date
); 


CREATE TABLE product(
	pr_no VARCHAR(5),
	pr_name VARCHAR(25)
);



-- Create View -- 
CREATE VIEW sale_view AS
SELECT s.sa_no, s.pr_no ,p.pr_name, s.pr_price, s.pr_ea, (s.pr_price * s.pr_ea) AS pr_pay, s.sa_date
FROM sale s, product p
WHERE s.pr_no = p.pr_no;



-- Select --
SELECT * FROM sale_view;



-- Insert --
INSERT INTO product VALUES
('pr001', '아메리카노'),
('pr002', '카페라떼'),
('pr003', '바닐라라떼'),
('pr501', '디저트');


INSERT INTO sale VALUES
(100001,'pr001',1500,4,'2023-07-03'),
(100001,'pr002',2500,1,'2023-07-03'),
(100002,'pr001',1500,2,'2023-07-01'),
(100003,'pr002',2500,1,'2023-07-02'),
(100004,'pr003',2500,2,'2023-06-15'),
(100005,'pr501',4000,1,'2023-06-18'),
(100006,'pr002',2500,1,'2023-07-21'),
(100007,'pr003',2500,2,'2023-06-20'),
(100008,'pr501',4000,1,'2023-06-11');


INSERT INTO sale VALUES
(100009,'pr501',-4000,1,'2023-06-11'),
(100010,'pr002',-2500,1,'2023-07-02');



-- drop table --
DROP TABLE sale;
DROP TABLE product;



-- drop view --
DROP VIEW sale_view;



-- Product Analysis 시작 --


	-- 기간 별 판매 Top 3 --	
	SELECT pr_name, COUNT(pr_no) * pr_ea AS COUNT
	FROM sale_view
	WHERE sa_date BETWEEN '2023-06-10' AND '2023-07-21'
	  AND pr_price > 0
	GROUP BY pr_no
	ORDER BY COUNT(pr_no) * pr_ea DESC
	LIMIT 4;

	
	-- 기간 별 카테고리 별 주문 건수 --
	SELECT 
    CASE WHEN CAST(SUBSTRING(pr_no, 3) AS INT) <= 500 THEN '커피'
         WHEN CAST(SUBSTRING(pr_no, 3) AS INT) >= 501 THEN '디저트'
    END AS category,
    COUNT(*) AS count
	FROM sale
	WHERE sa_date BETWEEN '2023-06-01' AND '2023-07-30 ' 
	AND pr_price > 0
	GROUP BY category;
	

-- Product Analysis 끝 --



-- Sale Calendar 시작 -- 

	-- 일별 매출 -- 
	SELECT sa_date, SUM(pr_pay) AS pr_pay
	FROM sale_view
	WHERE sa_date BETWEEN '2023-06-01' AND '2023-07-30'
  	AND pr_price > 0
	GROUP BY sa_date;
	
	
	-- 기간 별 총환불 -- 
	SELECT  SUM(pr_pay) AS pr_pay
	FROM sale_view
	WHERE sa_date BETWEEN '2023-06-01' AND '2023-07-30'
  	AND pr_price < 0
	
-- Sale Calendar 끝 -- 



-- Product Analysis 시작 --

	-- 매출 --
	-- 기간 별 매출 --
	SELECT SUM(pr_pay) AS pr_pay
	FROM sale_view
	WHERE sa_date BETWEEN '2023-06-01' AND '2023-07-30'
  	AND pr_price > 0;
  	
  	
  	-- 기간 별 매출 건수 --
  	SELECT count(sa_no) AS sa_cnt
	FROM sale_view
	WHERE sa_date BETWEEN '2023-06-01' AND '2023-07-30'
  	AND pr_price > 0;


  	-- 기간 별 평균 결제 금액 --
  	SELECT CAST(AVG(pr_pay) AS INT) AS pr_avg
	FROM (
    SELECT sa_no, SUM(pr_pay) AS pr_pay
    FROM sale_view
    WHERE sa_date BETWEEN '2023-06-01' AND '2023-07-30'
      AND pr_price > 0
    GROUP BY sa_no
	) AS subquery;
	
	
	
	-- 환불  --
	-- 기간 별 환불금액 --
	SELECT SUM(pr_pay) AS pr_pay
	FROM sale_view
	WHERE sa_date BETWEEN '2023-06-01' AND '2023-07-30'
  	AND pr_price < 0;
  	
  	
  	-- 기간 별 환불 건수 --
  	SELECT count(sa_no) AS sa_cnt
	FROM sale_view
	WHERE sa_date BETWEEN '2023-06-01' AND '2023-07-30'
  	AND pr_price < 0;


  	-- 기간 별 평균 환불 금액 --
  	SELECT CAST(AVG(pr_pay) AS INT) AS pr_avg
	FROM (
    SELECT sa_no, SUM(pr_pay) AS pr_pay
    FROM sale_view
    WHERE sa_date BETWEEN '2023-06-01' AND '2023-07-30'
      AND pr_price < 0
    GROUP BY sa_no
	) AS subquery;
	
-- Product Analysis 끝 --
  	
  	
  	
