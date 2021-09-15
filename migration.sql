DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), price numeric(6, 2));
INSERT INTO products (title, price) VALUES
('Bread', 40),
('Milk', 80),
('Cheese', 150),
('Sausage', 250),
('Cookies', 90),
('Tea', 200),
('Yogurt', 45),
('Salmon', 500),
('Sugar', 70),
('Salt', 99);