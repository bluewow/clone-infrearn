CREATE TABLE board
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    status     VARCHAR(255) NULL COMMENT '상태',
    created_at datetime NULL COMMENT '최초 생성 시간',
    updated_at datetime NULL COMMENT '마지막 수정 시간',
    title      VARCHAR(255) NULL,
    content    VARCHAR(255) NULL,
    CONSTRAINT pk_board PRIMARY KEY (id)
);