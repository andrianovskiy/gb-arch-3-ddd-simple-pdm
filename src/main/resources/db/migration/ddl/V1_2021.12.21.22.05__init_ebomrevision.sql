CREATE TABLE ebom_revision
(
    id            BIGINT       NOT NULL,
    item_id       BIGINT       NOT NULL,
    number        VARCHAR(255) NOT NULL,
    description   VARCHAR(255),
    approved      BOOLEAN      NOT NULL,
    approved_date TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_ebomrevision PRIMARY KEY (id)
);

ALTER TABLE ebom_revision
    ADD CONSTRAINT FK_EBOMREVISION_ON_ITEM FOREIGN KEY (item_id) REFERENCES item (id);