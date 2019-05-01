DROP TABLE IF EXISTS posts;

CREATE TABLE posts (
  post_id bigserial PRIMARY KEY,
  content varchar(250) NOT NULL
);
