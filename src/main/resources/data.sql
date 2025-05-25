SET
FOREIGN_KEY_CHECKS = 0;

truncate table user;

SET
FOREIGN_KEY_CHECKS = 1;

INSERT INTO `user` (`status`, `created_at`, `updated_at`, `user_id`, `password`)
VALUES ('ACTIVE', NOW(), NOW(), 'test', '123456789');

