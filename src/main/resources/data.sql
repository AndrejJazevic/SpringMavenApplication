DELETE FROM Order_items;
DELETE FROM Order;
DELETE FROM Item;
DELETE FROM Customer;


INSERT INTO Customer (firstname, lastname, personal_code) VALUES ('Petras', 'Jonas', '12345');
INSERT INTO Customer (firstname, lastname, personal_code) VALUES ('P', 'Jonas', '67890');
INSERT INTO Customer (firstname, lastname, personal_code) VALUES ('P', 'J', '54321');
INSERT INTO Customer (firstname, lastname, personal_code) VALUES ('Petras', 'J', '11111');
INSERT INTO Customer (firstname, lastname, personal_code) VALUES ('Jonas', 'Jonas', '99999');

INSERT INTO Item (name, price, amount) VALUES ('Klaviatūra', 10.00, 10);
INSERT INTO Item (name, price, amount) VALUES ('Laidas', 4.32, 99);
INSERT INTO Item (name, price, amount) VALUES ('Mikorofonas', 45.50, 3);
INSERT INTO Item (name, price, amount) VALUES ('Vaizdo plokštė', 142.99, 15);

INSERT INTO Order (order_date, customer_id) VALUES ('2016-09-09', 1);
INSERT INTO Order (order_date, customer_id) VALUES ('2017-12-09', 3);
INSERT INTO Order (order_date, customer_id) VALUES ('2019-01-24', 1);

INSERT INTO Order_items (order_id, item_id) VALUES (1, 4);
INSERT INTO Order_items (order_id, item_id) VALUES (1, 3);
INSERT INTO Order_items (order_id, item_id) VALUES (2, 4);
INSERT INTO Order_items (order_id, item_id) VALUES (3, 1);
