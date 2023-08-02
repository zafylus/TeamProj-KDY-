-- 상품 등록 테이블
CREATE TABLE product(
	pr_code CHAR(8) PRIMARY KEY,
	pr_name VARCHAR(50) NOT NULL,
	pr_price INT NOT NULL,
	pr_ctgry VARCHAR(20)
);

ALTER TABLE product ADD pr_img VARCHAR(100);

INSERT INTO product VALUES 
('PR001', '아메리카노', 4000, '커피'),
('PR002', '카페라떼', 5000, '커피'),
('PR003', '바닐라라떼', 6000, '커피'),
('PR501', '빵', 3000, '디저트');

UPDATE product SET pr_img ='bread.png' WHERE pr_code = 'PR501';
UPDATE product SET pr_img ='Americano.jpg' WHERE pr_code = 'PR001';
UPDATE product SET pr_img ='CafeLatte.png' WHERE pr_code = 'PR002';
UPDATE product SET pr_img ='VanillaLatte.png' WHERE pr_code = 'PR003';

SELECT * FROM product;


-- 재료 테이블
CREATE TABLE material (
   ma_code CHAR(5) NOT NULL PRIMARY KEY,
   ma_name VARCHAR(20),
   ma_cost int
);

INSERT INTO material VALUE ('MA001', '원두', 15000);
INSERT INTO material VALUE ('MA002', '우유', 2000);
INSERT INTO material VALUE ('MA003', '시럽', 5000);

SELECT * FROM material;

SELECT MAX(pr_code) FROM product WHERE pr_ctgry = '커피';


-- 레시피 테이블
CREATE TABLE recipe(
	pr_code CHAR(8) PRIMARY KEY,
	ma001 double NOT null,
	ma002	double NOT null,
	ma003	double NOT NULL,
	CONSTRAINT fk_recipe_pr_code FOREIGN KEY(pr_code)
	REFERENCES product(pr_code)
		ON UPDATE cascade
		ON DELETE CASCADE
);

INSERT INTO recipe VALUES 
('PR001', 0.02, 0, 0),
('PR002', 0.02, 0.2, 0),
('PR003', 0.02, 0.2, 0.05);

SELECT * FROM recipe

-- 상품 원가 VIEW
CREATE view prod_cost as
SELECT
    pr.pr_code,
    IFNULL(SUM(rec.ma001 * mat1.ma_cost), 0) AS bean,
    IFNULL(SUM(rec.ma002 * mat2.ma_cost), 0) AS milk,
    IFNULL(SUM(rec.ma003 * mat3.ma_cost), 0) AS syrup,
    IFNULL(SUM(rec.ma001 * mat1.ma_cost), 0) + IFNULL(SUM(rec.ma002 * mat2.ma_cost), 0) + IFNULL(SUM(rec.ma003 * mat3.ma_cost), 0) AS total_cost
FROM
    product pr
JOIN
    recipe rec ON pr.pr_code = rec.pr_code
LEFT JOIN
    material mat1 ON rec.ma001 > 0 AND mat1.ma_code = 'MA001'
LEFT JOIN
    material mat2 ON rec.ma002 > 0 AND mat2.ma_code = 'MA002'
LEFT JOIN
    material mat3 ON rec.ma003 > 0 AND mat3.ma_code = 'MA003'
GROUP BY
    pr.pr_code;
DROP VIEW prod_cost
SELECT * FROM prod_cost


-- 상품조회 VIEW
CREATE VIEW prod_info AS 
SELECT p.pr_code, p.pr_name, p.pr_img, p.pr_ctgry, p.pr_price, c.total_cost, (p.pr_price - c.total_cost) AS margin , (p.pr_price - c.total_cost)/p.pr_price*100 AS margin_per
FROM product p, prod_cost c
WHERE p.pr_code = c.pr_code;
//카테고리 추가
SELECT * FROM prod_info;