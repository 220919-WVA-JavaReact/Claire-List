--THE solution to the SQL exercise before lunch! :3
CREATE TABLE inventory(
id INT PRIMARY KEY,
"name" VARCHAR(255),
price FLOAT,
description VARCHAR(255),
quantity INT DEFAULT(0)
);

INSERT INTO inventory (id, "name", price, description, quantity) 
VALUES 
(1002, 'Skittles', 3.05, 'A bag of rainbow colored candies', 100),
(2003, 'Gummy Bears', 5.55,	'A large bag of chewy fruit-flavored bears', 48),
(2005, 'Sour Gummy Worms', 9.55, 'A very large bag of gelatin worms', 20),
(3008, 'Lollipop', 2.25, 'A hard candy atop a stick', 268),
(9007, 'M&Ms', 1.95, 'A bag of small chocolate candies', 58);

SELECT * FROM inventory;

--update hershey bar quantitytte to be 48

UPDATE inventory SET quantity = 48 WHERE id = 1001;
--DONT use paren. Tempermental!

SELECT description FROM inventory;

--name AND price
SELECT name, price FROM inventory;

--new descriptoin for gummy worims
UPDATE inventory SET description = 'A very large, delicious bag of worms' WHERE id = 2005;

--m&ms restock; new quant = 100

UPDATE inventory SET quantity = 100 WHERE id = 9007;

--price inc lollis
UPDATE inventory SET price = 2.50 WHERE id = 3008;

-- ! EMPLOYEE TABLE STUFF

--EMPLOYEE TABLE:: FKEY ref to inventory, fav candy (id pkey)

CREATE TABLE employees(
id INT PRIMARY KEY,
"name" VARCHAR(255),
favorite_candy INT REFERENCES inventory
);

INSERT INTO employees (id, "name", favorite_candy) 
VALUES (4002, 'Milton Hershey', 1001),
(4003, 'Franklin Mars', 9007),
(4004, 'John Cadbury', NULL);

SELECT * FROM employees;