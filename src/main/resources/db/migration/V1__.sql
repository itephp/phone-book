CREATE TABLE groups
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_groups PRIMARY KEY (id)
);

CREATE TABLE persons
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name     VARCHAR(255)                            NOT NULL,
    phone    VARCHAR(255),
    group_id BIGINT                                  NOT NULL,
    CONSTRAINT pk_persons PRIMARY KEY (id)
);

ALTER TABLE persons
    ADD CONSTRAINT uc_persons_name UNIQUE (name);

ALTER TABLE persons
    ADD CONSTRAINT FK_PERSONS_ON_GROUPS FOREIGN KEY (group_id) REFERENCES groups (id);

INSERT INTO groups (id, name) VALUES (1, 'System'), (2, 'User');