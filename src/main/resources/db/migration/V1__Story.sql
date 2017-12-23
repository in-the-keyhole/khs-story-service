CREATE TABLE story (
    id bigint NOT NULL AUTO_INCREMENT,
    title VARCHAR(30),
    description VARCHAR(255),
    project bigint,
    assignee bigint,
    story_id bigint,
    PRIMARY KEY (id)
);