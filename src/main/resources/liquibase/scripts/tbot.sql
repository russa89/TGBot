-- liquibase formatted sql

-- changeset nast:1
CREATE TABLE notification_task(
id SERIAL PRIMARY KEY,
chatId INTEGER,
message TEXT,
timing TIMESTAMP
)

