CREATE TABLE IF NOT EXISTS users
(
user_id int AUTO_INCREMENT NOT NULL,
login varchar NOT NULL,
password varchar NOT NULL,
PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS content
(
content_id int AUTO_INCREMENT NOT NULL,
author_id int  NOT NULL,
type int  NOT NULL,
parent_content_id int  NULL,
date int  NOT NULL,
title varchar  NULL,
content_body text  NOT NULL,
PRIMARY KEY (content_id)
);

CREATE TABLE IF NOT EXISTS content_type
(
type_id int AUTO_INCREMENT NOT NULL,
type text NOT NULL,
PRIMARY KEY (type_id),
);

CREATE TABLE IF NOT EXISTS content_image
(
content_id int NOT NULL,
image_url varchar  NOT NULL
);

CREATE TABLE IF NOT EXISTS votes
(
user_id int NOT NULL,
content_id int  NOT NULL,
PRIMARY KEY (user_id,content_id)
);
