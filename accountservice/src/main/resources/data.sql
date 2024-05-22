INSERT INTO customer (customer_number, customer_name, customer_mobile, customer_email, address1, address2)
VALUES (1, 'Tone Test', '09123123123', 'tone.test@example.com', '123 Rob St', 'Don Ma');

INSERT INTO account (account_number, account_type, available_balance, customer_number)
VALUES (10001, 'SAVINGS', 1000.0, 1);