-- liquibase formatted sql

-- changeset nast:1
CREATE TABLE notification_task (
id BIGSERIAL PRIMARY KEY,
chat_id INTEGER NOT NULL,
message TEXT NOT NULL,
message_timing TIMESTAMP NOT NULL
);

-- changeset nast:2
ALTER TABLE notification_task
ALTER COLUMN chat_id TYPE BIGINT;

-- changeset nast:3
ALTER TABLE notification_task
ADD CONSTRAINT chat_id_unique UNIQUE (chat_id);










