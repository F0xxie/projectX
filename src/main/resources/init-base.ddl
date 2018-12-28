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