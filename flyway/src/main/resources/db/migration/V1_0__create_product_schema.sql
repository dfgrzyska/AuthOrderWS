CREATE TABLE IF NOT EXISTS `customer` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` varchar(20),
`email` varchar(50)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `product` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` varchar(20),
`price` float(10)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `order_history` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`product_id` int NOT NULL,
`customer_email` varchar(30) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

insert into customer (name, email) values('Damian', 'damian@email.com');
insert into customer (name, email) values('Marta', 'marta@email.com');
insert into customer (name, email) values('Jan', 'jan@email.com');
insert into customer (name, email) values('Kuba', 'kuba@email.com');
insert into customer (name, email) values('Papaj', 'papaj@email.com');
insert into customer (name, email) values('Jinx', 'jinx@email.com');

insert into product (name, price) values('Microphone', 15);
insert into product (name, price) values('Keyboard', 25);
insert into product (name, price) values('CPU', 100);
insert into product (name, price) values('Motherboard', 50);
insert into product (name, price) values('RAM', 40);
insert into product (name, price) values('HDD', 20);


insert into order_history (product_id, customer_email) values(1, 'damian@email.com');
insert into order_history (product_id, customer_email) values(1, 'kuba@email.com');
insert into order_history (product_id, customer_email) values(1, 'jan@email.com');
insert into order_history (product_id, customer_email) values(2, 'papaj@email.com');
insert into order_history (product_id, customer_email) values(2, 'jinx@email.com');
insert into order_history (product_id, customer_email) values(3, 'jan@email.com');
insert into order_history (product_id, customer_email) values(3, 'jan@email.com');
insert into order_history (product_id, customer_email) values(3, 'kuba@email.com');



