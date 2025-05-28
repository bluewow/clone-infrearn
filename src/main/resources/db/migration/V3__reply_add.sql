CREATE TABLE reply
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime NULL COMMENT '최초 생성 시간',
    updated_at datetime NULL COMMENT '마지막 수정 시간',
    content    VARCHAR(255) NULL COMMENT '답글 내용',
    user_id    BIGINT NULL COMMENT '답글 작성자 아이디',
    board_id   BIGINT NULL COMMENT '게시판 아이디',
    CONSTRAINT pk_reply PRIMARY KEY (id)
);

ALTER TABLE reply
    ADD CONSTRAINT FK_REPLY_ON_BOARD FOREIGN KEY (board_id) REFERENCES board (id);