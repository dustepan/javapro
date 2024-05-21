create table users(id bigserial primary key, user_name varchar(255));

insert into users(id, user_name) values
(12, 'Stiven'),
(2, 'Petr'),
(11, 'Sergey')

create table products(id bigserial primary key, account_number varchar(255), balance varchar(255), product_type varchar(255), user_id bigserial references users(id));

insert into products(id, account_number, balance, product_type, user_id) values
(1,'1234', '100', 'ACCOUNT', 12),
(2, '12345', '120', 'CARD', 12),
(3, '1234', '0', 'ACCOUNT', 11)
