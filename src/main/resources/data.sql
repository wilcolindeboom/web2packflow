/*
Spring runt dit SQL-bestand automatisch. Spring zoekt namelijk naar een bestand dat data.sql heet (in deze folder) en
voert de SQL commando's voor je uit. Dit is een van de manier om de database te vullen. Om dit te laten werken, is het
volgende aan application.properties toegevoegd:

spring.datasource.initialization-mode=always

Zoals gezegd, dit is een van de manieren. De huidige opzet avn deze applicatie heeft een vast aantal user-rollen. Deze
kunnen niet door eindgebruikers, moderators of admins toegevoegd worden. Alleen de programmeur kan user-rollen
toevoegen. Daarom is er ook geen Service & repo voor de user-rollen geprogrammeerd. De enige manier om dan iets in de
database te krijgen is via SQL statements in dit bestand.

 */

INSERT INTO role(name) VALUES('ROLE_USER');
INSERT INTO role(name) VALUES('ROLE_EDITOR');
INSERT INTO role(name) VALUES('ROLE_ADMIN');

insert into product_groups (id, description) VALUES (21, 'zelfklevende etiketten');

insert into customers (id, company_name, email, first_name, last_name) VALUES (0,'Brouwerij Heukels', 'lheukels@brouwerijheukels.nl', 'Lisette', 'Heukels');

insert into orders (source_order_id, store_front_id, customer_id) values ('order1',3, 0);
insert into orders (source_order_id, store_front_id, customer_id) values ('order2',3, 0);
insert into orders (source_order_id, store_front_id, customer_id) values ('order3',3, 0);
insert into orders (source_order_id, store_front_id, customer_id) values ('order4',3, 0);
insert into orders (source_order_id, store_front_id, customer_id) values ('order5',3, 0);

insert into batches (id, open, substrate_id, finish_name, product_group_id, store_front_id) VALUES (0,true,'000269','IVO43', 21, 3 );

insert into orderitems (source_item_id, finish_name, substrate_id, source_order_id, batch_id, product_group_id, quantity) VALUES ('item1', 'IVO43','000269','order1',0,'21', 1000);
insert into orderitems (source_item_id, finish_name, substrate_id, source_order_id, batch_id, product_group_id, quantity) VALUES ('item2', 'IVO43','000269','order2',0,'21', 2000);
insert into orderitems (source_item_id, finish_name, substrate_id, source_order_id, batch_id, product_group_id, quantity) VALUES ('item3', 'IVO43','000269','order3',0,'21', 500);
insert into orderitems (source_item_id, finish_name, substrate_id, source_order_id, batch_id, product_group_id, quantity) VALUES ('item4', 'IVO43','000269','order4',0,'21', 3000);
insert into orderitems (source_item_id, finish_name, substrate_id, source_order_id, batch_id, product_group_id, quantity) VALUES ('item1', 'IVO43','000269','order5',0,'21', 1000);

insert into app_user (id, username,email,enabled,password) values (0,'admin','admin@web2packflow.com',true,'$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica');
insert into user_role (user_id, role_id) VALUES (0,3);





