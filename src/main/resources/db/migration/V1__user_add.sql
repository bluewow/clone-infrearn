CREATE TABLE user
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    status     VARCHAR(255) NULL COMMENT '상태',
    created_at datetime NULL COMMENT '최초 생성 시간',
    updated_at datetime NULL COMMENT '마지막 수정 시간',
    user_id    VARCHAR(255) NULL COMMENT '아이디',
    password   VARCHAR(255) NULL COMMENT '비밀번호',
    CONSTRAINT pk_user PRIMARY KEY (id)
);