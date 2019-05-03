DROP TABLE IF EXISTS likes;

CREATE TABLE likes (
  like_id bigserial PRIMARY KEY,
  post_id bigserial REFERENCES posts(post_id),
  auth_user_id bigserial REFERENCES auth_user(auth_user_id)
);