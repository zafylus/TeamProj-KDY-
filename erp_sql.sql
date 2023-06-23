CREATE TABLE tbl_board(
	bno INT NOT NULL PRIMARY KEY,
	title VARCHAR(20) NOT NULL,
	author VARCHAR(15) NOT NULL,
	content VARCHAR(500),
	wdate DATE DEFAULT NOW()
);
DESC tbl_board
SELECT * FROM tbl_board
INSERT INTO tbl_board (bno, title, author, content)
VALUES (2, 'test', 'aaa', 'abcde')



CREATE TABLE tbl_comment(
	bno INT NOT NULL,
	cno INT NOT NULL,
	author VARCHAR(15) NOT NULL,
	content VARCHAR(500),
	wdate DATE DEFAULT NOW(),
	
	PRIMARY KEY(bno, cno),
	CONSTRAINT fk_comment_bno FOREIGN KEY (bno)
	REFERENCES tbl_board(bno)
		ON UPDATE CASCADE
		ON DELETE cascade 
);
desc tbl_comment
SELECT * FROM tbl_comment WHERE bno = 1
SELECT COUNT(*) FROM tbl_comment WHERE bno=1
SELECT MAX(cno) FROM tbl_comment WHERE bno = 1
INSERT INTO tbl_comment (bno, cno, author, content) VALUES
(2, 1, 'c', 'cccccc')
(1, 1, 'a', 'aaaaa'),
(1, 2, 'b', 'bbbbb')

CREATE TABLE tbl_depth(
	bno INT NOT NULL,
	bdno VARCHAR(8) NOT NULL,
	depth INT NOT NULL,
	title VARCHAR(20) NOT NULL,
	author VARCHAR(15) NOT NULL,
	content VARCHAR(500),
	wdate DATE DEFAULT NOW(),
	PRIMARY KEY (bno, bdno),
	CONSTRAINT fk_depth_bno FOREIGN KEY (bno)
	REFERENCES tbl_board(bno)
		ON UPDATE CASCADE
		ON DELETE CASCADE 
);

SELECT * FROM tbl_depth
SELECT MAX(bdno) FROM tbl_depth WHERE bno = 1
DROP table tbl_depth
INSERT INTO tbl_depth (bno, bdno, depth, title, author) VALUES
(1, '1_1_1', 1, 'a', 'aaaa'),
(1, '1_1_2', 1, 'a', 'aaaa'),
(1, '1_3_1', 3, 'a', 'aaaa'),
(2, '2_1_1', 1, 'a', 'aaaa')
