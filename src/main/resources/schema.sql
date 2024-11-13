-- Tabela clients
CREATE TABLE customers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    document VARCHAR(255),
    phone VARCHAR(255),
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

CREATE TABLE service_cars (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(255),
    customer_id BIGINT,
    car_id BIGINT,
    date DATE,
    guarantee INT,
    total_value DECIMAL(20, 2),
    creation_date DATETIME,
    update_date DATETIME,
    status ENUM('OPEN', 'FINISHED', 'CANCELED'),
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (car_id) REFERENCES cars(id)
);
CREATE TABLE product_cars (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(255),
    quantity INT,
    unit_value DECIMAL(20, 2),
    total_value DECIMAL(20, 2),
    service_car_id BIGINT,
    FOREIGN KEY (service_car_id) REFERENCES service_cars(id)
);
