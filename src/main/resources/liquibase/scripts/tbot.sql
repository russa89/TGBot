-- liquibase formatted sql

-- changeset nast:1
CREATE TABLE notification_task (
id SERIAL PRIMARY KEY,
chatId INTEGER,
message TEXT,
timing TIMESTAMP
);

-- changeset nast:2
SELECT timing AS message_timing
FROM notification_task;

-- changeset nast:3
ALTER TABLE notification_task
ALTER COLUMN id TYPE BIGSERIAL,
ALTER COLUMN chatId SET NOT NULL,
ALTER COLUMN message SET NOT NULL,
ALTER COLUMN message_timing SET NOT NULL,
ADD CONSTRAINT chatId_unique UNIQUE (chatId);


