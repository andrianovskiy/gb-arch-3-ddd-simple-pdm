CREATE TABLE item
(
    id          BIGINT       NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    CONSTRAINT pk_item PRIMARY KEY (id)
);