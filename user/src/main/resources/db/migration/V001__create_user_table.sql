CREATE TABLE users(
    id BINARY(16),
    name VARCHAR(255) NOT NULL,
    bio VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255),

    CONSTRAINT pk_user PRIMARY KEY(id),
    CONSTRAINT unq_email UNIQUE (email)
);

CREATE INDEX idx_user_email on users(email);