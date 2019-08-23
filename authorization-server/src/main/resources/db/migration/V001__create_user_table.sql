CREATE TABLE users (
    id BINARY(16),
    username VARCHAR(255),
    password VARCHAR(255),
    status VARCHAR(255),

    CONSTRAINT pk_user PRIMARY KEY(id)
);

CREATE INDEX idx_users_username ON users(username);

CREATE TABLE users_roles (
  user_id BINARY(16),
  role VARCHAR(255),

  CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);