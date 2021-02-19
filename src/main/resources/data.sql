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

insert into orders (source_order_id) values ('order1');
insert into orders (source_order_id) values ('order2');
insert into orders (source_order_id) values ('order3');
insert into orders (source_order_id) values ('order4');
insert into orders (source_order_id) values ('order5');


insert into orderitems (source_order_id, source_item_id) values ('order1', 'item1');
insert into orderitems (source_order_id, source_item_id) values ('order2', 'item2');
insert into orderitems (source_order_id, source_item_id) values ('order3', 'item3');
insert into orderitems (source_order_id, source_item_id) values ('order4', 'item4');
insert into orderitems (source_order_id, source_item_id) values ('order5', 'item1');

insert into batches (batch_id, closed) VALUES (1,false);

-- insert into app_user (id, username,email,enabled,password) values (0,'admin','admin@web2packflow.com',true,crypt('123456', gen_salt('bf')));
insert into app_user (id, username,email,enabled,password) values (0,'admin','admin@web2packflow.com',true,'$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica');
insert into user_role (user_id, role_id) VALUES (0,3);





