CREATE TABLE IF NOT EXISTS customer (
    customer_number BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(50) NOT NULL,
    customer_mobile VARCHAR(20) NOT NULL,
    customer_email VARCHAR(50) NOT NULL,
    address1 VARCHAR(100) NOT NULL,
    address2 VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS account (
    account_number BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_type VARCHAR(10) NOT NULL,
    available_balance DOUBLE NOT NULL,
    customer_number BIGINT,
    CONSTRAINT fk_customer
        FOREIGN KEY (customer_number) 
        REFERENCES customer(customer_number)
);