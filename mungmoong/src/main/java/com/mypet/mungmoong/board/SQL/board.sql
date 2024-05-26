-- Active: 1713528331467@@127.0.0.1@3306@mungmoong
DROP TABLE board;

CREATE TABLE `board` (
  `no` int NOT NULL AUTO_INCREMENT COMMENT '번호',
  `title` varchar(100) NOT NULL COMMENT '제목',
  `writer` varchar(100) NOT NULL COMMENT '작성자',
  `content` text COMMENT '내용',
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일자',
  `upd_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일자',
  `views` int NOT NULL DEFAULT '0' COMMENT '조회수',
  PRIMARY KEY (`no`)
) COMMENT='게시판';

-- 테이블 데이터 전체 삭제
TRUNCATE board;


-- board, file 테이블 조인 조회
SELECT b.*
      ,f.no file_no
      ,f.file_name
      ,f.file_path
      ,f.file_code
FROM board b LEFT JOIN ( 
                         SELECT *
                         FROM file
                         WHERE parent_table = "board"
                           AND file_code = 1          # file_code = 1 (대표 썸네일)
                        ) f
             ON (b.no = f.parent_no)
;


TRUNCATE board;
TRUNCATE file;



-- 게시글 목록 페이징
SELECT *
FROM board
LIMIT #{index}, #{rows}
;





-- 샘플 데이터 등록
TRUNCATE board;

INSERT INTO board( title, writer, content ) 
VALUES ('제목01','작성자01','내용01')
      ,('제목02','작성자02','내용02')
      ,('제목03','작성자03','내용03')
      ,('제목04','작성자04','내용04')
      ,('제목05','작성자05','내용05')

INSERT INTO board (title, writer, content)
SELECT title, writer, content
FROM board
;


SELECT * FROM board;


-- 게시글 목록 검색
SELECT * 
FROM board
WHERE title LIKE '%검색어%'
   OR writer LIKE '%검색어%'
   OR content LIKE '%검색어%'
;



-- 게시글 목록 - [검색] + [페이징]
SELECT * 
FROM board
WHERE title LIKE '%고양이%'
LIMIT 0, 10
;



