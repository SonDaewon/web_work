CREATE TABLE board_cafe(
num NUMBER PRIMARY KEY,
writer VARCHAR2(100) NOT NULL,
title VARCHAR2(100) NOT NULL,
content CLOB,
viewCount NUMBER, 
regdate DATE
);

CREATE SEQUENCE board_cafe_seq;

-- 댓글 정보를 저장할 테이블
CREATE TABLE board_cafe_comment(
	num NUMBER PRIMARY KEY, -- 댓글의 글번호
	writer VARCHAR2(100), -- 댓글 작성자
	content VARCHAR2(500), -- 댓글 내용
	target_id VARCHAR2(100), -- 댓글의 대상이 되는 아이디(글작성자)
	ref_group NUMBER, -- 댓글 그룹번호
	comment_group NUMBER, -- 원글에 달린 댓글 내에서의 그룹번호
	regdate DATE -- 댓글 등록일 
);

SELECT * FROM board_cafe_comment;























