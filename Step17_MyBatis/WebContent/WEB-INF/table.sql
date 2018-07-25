CREATE TABLE board_cafe(
num NUMBER PRIMARY KEY,
writer VARCHAR2(100) NOT NULL,
title VARCHAR2(100) NOT NULL,
content CLOB,
viewCount NUMBER, 
regdate DATE
);

CREATE SEQUENCE board_cafe_seq;

SELECT * FROM board_cafe;


SELECT result1.*
FROM ( SELECT num, writer, title,
		LAG(num, 1, 0) OVER(ORDER BY num DESC) prevNum,
		LEAD(num, 1, 0) OVER(ORDER BY num DESC) nextNum
	 FROM board_cafe
	 ORDER BY num DESC ) result1
WHERE num=5;











