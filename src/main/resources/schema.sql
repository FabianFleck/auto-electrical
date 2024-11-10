 CREATE TABLE clients (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    document BIGINT,
    phone BIGINT,
    email VARCHAR(255),
    creation_date DATETIME,
    update_date DATETIME
);