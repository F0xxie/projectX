CREATE TABLE IF NOT EXISTS users
(
user_id int AUTO_INCREMENT NOT NULL,
login varchar NOT NULL,
password varchar NOT NULL,
PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS content_type
(
type_id int AUTO_INCREMENT NOT NULL,
type text NOT NULL,
PRIMARY KEY (type_id),
);

CREATE TABLE IF NOT EXISTS tags
(
  tag_id int AUTO_INCREMENT NOT NULL,
  tag varchar NOT NULL,
  PRIMARY KEY (tag_id),
);

CREATE TABLE IF NOT EXISTS post_tags
(
  j_tag_id  int NOT NULL,
  j_type_id int NOT NULL,
  PRIMARY KEY (j_tag_id, j_type_id),
  CONSTRAINT fk_type_id FOREIGN KEY (j_type_id) REFERENCES content_type (type_id),
  CONSTRAINT fk_tag_id FOREIGN KEY (j_tag_id) REFERENCES tags (tag_id),
);