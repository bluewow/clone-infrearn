CREATE TABLE notification
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime NULL COMMENT '최초 생성 시간',
    updated_at datetime NULL COMMENT '마지막 수정 시간',
    message    VARCHAR(255) NULL COMMENT '알림 내용',
    board_id   BIGINT NULL COMMENT '관련 게시글 ID (nullable)',
    CONSTRAINT pk_notification PRIMARY KEY (id)
);