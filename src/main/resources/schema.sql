-- Tabela clients
CREATE TABLE customers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    document BIGINT,
    phone BIGINT,
    email VARCHAR(255),
    creation_date TIMESTAMP,
    update_date TIMESTAMP
);

-- Tabela cars
CREATE TABLE cars (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    plate VARCHAR(50) UNIQUE,
    color VARCHAR(50),
    model VARCHAR(255),
    car_year INT,
    creation_date TIMESTAMP,
    update_date TIMESTAMP,
    customer_id BIGINT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);
