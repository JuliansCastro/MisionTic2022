--DROP all tables from DB
DROP TABLE IF EXISTS "public"."auth_group" CASCADE;
DROP TABLE IF EXISTS "public"."auth_group_permissions" CASCADE;
DROP TABLE IF EXISTS "public"."auth_permission" CASCADE;
DROP TABLE IF EXISTS "public"."django_admin_log" CASCADE;
DROP TABLE IF EXISTS "public"."django_content_type" CASCADE;
DROP TABLE IF EXISTS "public"."django_migrations" CASCADE;
DROP TABLE IF EXISTS "public"."django_session" CASCADE;
DROP TABLE IF EXISTS "public"."g6App_cliente" CASCADE;
DROP TABLE IF EXISTS "public"."g6App_detalle_venta" CASCADE;
DROP TABLE IF EXISTS "public"."g6App_empleado" CASCADE;
DROP TABLE IF EXISTS "public"."g6App_empleado_groups" CASCADE;
DROP TABLE IF EXISTS "public"."g6App_empleado_user_permissions" CASCADE;
DROP TABLE IF EXISTS "public"."g6App_inventario" CASCADE;
DROP TABLE IF EXISTS "public"."g6App_miscelanea" CASCADE;
DROP TABLE IF EXISTS "public"."g6App_producto" CASCADE;
DROP TABLE IF EXISTS "public"."g6App_venta" CASCADE;

--INSERTS TABLE PRODUCTO
INSERT INTO "public"."g6App_producto" ("nombre_prod", "descripcion") VALUES ('Lápiz', 'Mina 2HB, Faber Castell');
INSERT INTO "public"."g6App_producto" ("nombre_prod", "descripcion") VALUES ('Esfero Bic', 'Esfero Bic -Tinta gel');
INSERT INTO "public"."g6App_producto" ("nombre_prod", "descripcion") VALUES ('Regla metálica', 'Regla de 1m-100cm, Metálica');
INSERT INTO "public"."g6App_producto" ("nombre_prod", "descripcion") VALUES ('Papel A4', 'Resma 80g/m2 papel carta');
INSERT INTO "public"."g6App_producto" ("nombre_prod", "descripcion") VALUES ('Lápiz pastell', 'Color sangría, Faber Castell');
INSERT INTO "public"."g6App_producto" ("nombre_prod", "descripcion") VALUES ('prueba', 'descripcion de la prueba');
--INSERT INTO "public"."g6App_producto" ("id", "nombre_prod", "descripcion") VALUES ('3', 'prueba', 'descripcion de la prueba');


--INSERTS MISCELLANEA
INSERT INTO "public"."g6App_miscelanea" ("nit", "nombre_misc", "direccion_misc") VALUES ('123456', 'SiempreViva', 'Av Siempre Viva');
INSERT INTO "public"."g6App_miscelanea" ("nit", "nombre_misc", "direccion_misc") VALUES ('789456', 'La esperanza', 'AV esperanza');
INSERT INTO "public"."g6App_miscelanea" ("nit", "nombre_misc", "direccion_misc") VALUES ('256645252', 'Pepe.com', 'Carrera 30 #26-01');
INSERT INTO "public"."g6App_miscelanea" ("nit", "nombre_misc", "direccion_misc") VALUES ('25367097', 'Comercial Papelera', 'Carrera 7 #45-01');

--INSERTS EMPLEADO
INSERT INTO "public"."g6App_empleado" ("last_login", "is_superuser", "id", "username", "nombre", "apellido", "cedula", "email", "password", "create_time", "miscelanea_id") VALUES (NULL, 'false', 1, 'fabianceiba', 'fabian', 'castro', '1235689', 'fabian@gmail.com', 'pbkdf2_sha256$260000$mMUj0DrIK6vgtdIYepkIxN$z7Jk9Cw0+Aar7ZCFTrNN2OJt/OqEbmD544EkD6XiQAk=', '2021-10-18 13:32:00+00', 123456);
INSERT INTO "public"."g6App_empleado" ("last_login", "is_superuser", "id", "username", "nombre", "apellido", "cedula", "email", "password", "create_time", "miscelanea_id") VALUES (NULL, 'false', 2, 'hatori', 'Wilson', 'Arguello', '7894562365', 'wilson@gmail.com', 'pbkdf2_sha256$260000$mMUj0DrIK6vgtdIYepkIxN$z7Jk9Cw0+Aar7ZCFTrNN2OJt/OqEbmD544EkD6XiQAk=', '2021-10-21 10:34:41.683748+00', 789456);
INSERT INTO "public"."g6App_empleado" ("last_login", "is_superuser", "id", "username", "nombre", "apellido", "cedula", "email", "password", "create_time", "miscelanea_id") VALUES (NULL, 'false', 3, 'Pola', 'Paola', 'Rojas', '2365987456', 'paola@gmail.com', 'pbkdf2_sha256$260000$mMUj0DrIK6vgtdIYepkIxN$z7Jk9Cw0+Aar7ZCFTrNN2OJt/OqEbmD544EkD6XiQAk=', '2021-10-21 10:38:01.124484+00', 256645252);
INSERT INTO "public"."g6App_empleado" ("last_login", "is_superuser", "id", "username", "nombre", "apellido", "cedula", "email", "password", "create_time", "miscelanea_id") VALUES (NULL, 'false', 4, 'julians', 'Andres', 'gonzales', '123456789', 'andres@gmail.com', 'pbkdf2_sha256$260000$mMUj0DrIK6vgtdIYepkIxN$H6GKp4bGiLbM4jIbZbHtTgIq0eHA4IFQOJpW1rPdTAA=', '2021-10-18 13:32:00+00', 25367097);
INSERT INTO "public"."g6App_empleado" ("last_login", "is_superuser", "id", "username", "nombre", "apellido", "cedula", "email", "password", "create_time", "miscelanea_id") VALUES (NULL, 'false', 5, 'julianscastro', 'Julian', 'Castro', '25563006', 'juacastropa@unal.edu.co', '123456789', '2021-10-18 13:32:00+00', 25367097);

--INSERTS TABLE INVENTARIO
INSERT INTO "public"."g6App_inventario" ("fecha_vencimiento", "fecha_ingreso", "precio_compra", "precio_venta", "miscelanea_id", "producto_id", "cantidad") VALUES ('2021-12-21', '2021-10-20', 700.00, 900.00, 25367097, 2, 1);


--QUERY-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--UPDATE DATA ON TABLES
UPDATE "public"."g6App_miscelanea" SET "direccion_misc" = 'Carrera 30 #26-00' WHERE "id" = 1;
UPDATE "public"."g6App_miscelanea" SET "nombre_misc" = 'Pepe.com' WHERE "id" = 3;

--DELETE ROWS FROM TABLES
DELETE FROM "public"."g6App_empleado" WHERE ("id" = 4);
--DELETE ROWS FROM TABLE empleado
DELETE FROM "public"."g6App_empleado" WHERE ("id" = 8) OR ("id" = 7);
DELETE FROM "public"."g6App_empleado" WHERE ("id" = 10);

--DELETE ROWS FROM TABLE miscelanea
DELETE FROM "public"."g6App_miscelanea" WHERE ("nit" = 312456);