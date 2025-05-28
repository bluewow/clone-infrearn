SET
FOREIGN_KEY_CHECKS = 0;

truncate table user;
truncate table board;
truncate table reply;

SET
FOREIGN_KEY_CHECKS = 1;

INSERT INTO `user` (`status`, `created_at`, `updated_at`, `user_id`, `password`)
VALUES ('ACTIVE', NOW(), NOW(), 'test', '123456789');

INSERT INTO `board` (`id`, `created_at`, `updated_at`, `title`, `content`)
VALUES (1, NOW(), NOW(), '테스트 게시글', '테스트 게시글 내용')
, (2, NOW(), NOW(), '두번째 게시글', '두번째 게시글 내용');