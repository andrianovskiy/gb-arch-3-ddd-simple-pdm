CREATE TABLE ebom_line
(
    id                BIGINT  NOT NULL,
    ebom_revision_id  BIGINT  NOT NULL,
    number            INTEGER NOT NULL,
    component_item_id BIGINT  NOT NULL,
    qty               DECIMAL,
    CONSTRAINT pk_ebomline PRIMARY KEY (id)
);

ALTER TABLE ebom_line
    ADD CONSTRAINT FK_EBOMLINE_ON_COMPONENTITEM FOREIGN KEY (component_item_id) REFERENCES item (id);

ALTER TABLE ebom_line
    ADD CONSTRAINT FK_EBOMLINE_ON_EBOMREVISION FOREIGN KEY (ebom_revision_id) REFERENCES ebom_revision (id);