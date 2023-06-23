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
SELECT MAX(pr_code) FROM product WHERE pr_ctgry = '커피'