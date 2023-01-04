CREATE TABLE IF NOT EXISTS Users
(
    Id          BIGSERIAL PRIMARY KEY,
    Email       VARCHAR(30) NOT NULL,
    Firstname   VARCHAR(30) NOT NULL,
    LastName    VARCHAR(30) NOT NULL,
    Phonenumber VARCHAR(12) NOT NULL,
    Password    VARCHAR(100) NOT NULL
    );

