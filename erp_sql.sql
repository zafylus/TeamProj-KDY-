--상품 테이블
CREATE TABLE product(
	pr_code VARCHAR(5) NOT NULL PRIMARY KEY,
	pr_name VARCHAR(20) NOT NULL,
	pr_price INT NOT NULL,
	pr_ctgry varchar(10)
);
DESC product
SELECT * FROM product;

INSERT INTO product VALUES 
('PR001', '아메리카노', 4000, '커피'),
('PR002', '카페라떼', 5000, '커피'),
('PR003', '바닐라라떼', 6000, '커피'),
('PR501', '빵', 3000, '디저트');
UPDATE product SET pr_name = 'aa카마', pr_price = 5000, pr_ctgry = '커피' WHERE pr_code = 'PR004';
SELECT MAX(pr_code) FROM product WHERE pr_ctgry = '커피';


-- 재료 테이블
CREATE table material(
	ma_code VARCHAR(5) PRIMARY KEY,
	ma_name VARCHAR(20),
	ma_cost INT NOT NULL
);

SELECT * FROM material;

INSERT INTO material VALUES
('MA001', '원두', 100),
('MA002', '우유', 200),
('MA003', '시럽', 300),
('MA004', '빵', 2000)


-- 상품 재료 테이블
CREATE TABLE product_ingredient(
	pr_code VARCHAR(5) NOT NULL PRIMARY KEY,
	MA001 INT NOT NULL,
	MA002 INT NOT NULL,
	MA003 INT NOT NULL,
	MA004 INT NOT NULL
);
SELECT * FROM product_ingredient
INSERT INTO product_ingredient VALUES
('PR001', 1, 0, 0, 0),
('PR002', 1, 1, 0, 0),
('PR003', 1, 1, 1, 0),
('PR501', 0, 0, 0, 1);