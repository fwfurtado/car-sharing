INSERT INTO users(id, username, password, status)
VALUES (
        uuid_to_bin('614f470d-4938-4484-9073-0f8c1363ef93'),
        'fernando@email.com',
        '{bcrypt}$2a$10$WOy7g2J6rEqeXcFp0dbP5eWd4jYa8C2kkWA6B.dPRvlo1KFHINZwG',
        'ACTIVE'
       );

INSERT INTO users_roles(user_id, role)
VALUES ( uuid_to_bin('614f470d-4938-4484-9073-0f8c1363ef93'), 'ROLE_USER');