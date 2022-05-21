-- Crear DB
DROP DATABASE IF EXISTS Reto5_BaseDatos;
CREATE SCHEMA Reto5_BaseDatos;
USE Reto5_BaseDatos;
#SELECT *From biblioteca;

# Verificaciones y limpiar
DROP TABLE IF EXISTS contenido;	-- Verificar existencia de tabla
DROP TABLE IF EXISTS cliente;	-- Verificar existencia de tabla
DROP TABLE IF EXISTS biblioteca; -- Verificar existencia de tabla
DROP TABLE IF EXISTS aplicacion; -- Verificar existencia de tabla
DROP TABLE IF EXISTS distribuidora;	-- Verificar existencia de tabla
DROP TABLE IF EXISTS juego;			-- Verificar existencia de tabla

#Tabla distribuidora
CREATE TABLE distribuidora(
	dis_id INT NOT NULL,
	dis_nombre CHAR(20) NOT NULL,
    dis_pais CHAR(40) NULL DEFAULT NULL,
    PRIMARY KEY(dis_ID)
);
#Registros Distribuidora
INSERT INTO distribuidora(dis_id,dis_nombre,dis_pais) VALUES(1,'Enhance','USA');
INSERT INTO distribuidora(dis_id,dis_nombre,dis_pais) VALUES(2,'Electronic Arts','USA');
INSERT INTO distribuidora(dis_id,dis_nombre,dis_pais) VALUES(3,'Activision','USA');
INSERT INTO distribuidora(dis_id,dis_nombre,dis_pais) VALUES(4,'Rockstar Games','USA');
INSERT INTO distribuidora(dis_id,dis_nombre,dis_pais) VALUES(5,'Bethesda','USA');
INSERT INTO distribuidora(dis_id,dis_nombre,dis_pais) VALUES(6,'Konami','Japón');
#Tabla cliente
CREATE TABLE cliente(
	cli_tag CHAR(20) NOT NULL,
    cli_nombre CHAR(20) NOT NULL,
	cli_email CHAR(30) NOT NULL,
    cli_celular BIGINT NULL DEFAULT NULL,
    cli_clave CHAR(20) NULL DEFAULT NULL,
    cli_fecha_n  DATE NOT NULL,
    PRIMARY KEY (cli_tag)
);
#Registros Cliente
INSERT INTO cliente(cli_tag,cli_nombre,cli_email,cli_celular,cli_clave,cli_fecha_n) VALUES ('hoodoo','Samary Cardona','scardona98@gmal.com',3456725372,'8yuh jgvytr','2021-05-24');
INSERT INTO cliente(cli_tag,cli_nombre,cli_email,cli_celular,cli_clave,cli_fecha_n) VALUES ('andre09','Andrea Cardona','AndreCardona@outllook.es','5364835263','fjcorf543','2021-06-2');
INSERT INTO cliente(cli_tag,cli_nombre,cli_email,cli_celular,cli_clave,cli_fecha_n) VALUES ('holy','Carlos Alonso','CarlitosAl@hotmaill.com','9878675345','456tgybuhnj','2021-06-26');
INSERT INTO cliente(cli_tag,cli_nombre,cli_email,cli_celular,cli_clave,cli_fecha_n) VALUES ('jquispe','Julian Quispoe','JQUISPOE@bancodexx.com','3136745792','6sv38de','2021-06-30');
INSERT INTO cliente(cli_tag,cli_nombre,cli_email,cli_celular,cli_clave,cli_fecha_n) VALUES ('cgallardo','Camilo Gallardo','CamiloGallardo@gmal.com','6475892536','gdtbsyey7','2021-07-04');
INSERT INTO cliente(cli_tag,cli_nombre,cli_email,cli_celular,cli_clave,cli_fecha_n) VALUES ('jk2929','Juana Camila','Juanac_24@gmal.com','2334568903','2345tyhn8','2021-10-29');
#Tabla Contenido
CREATE TABLE contenido(
	con_id INT NOT NULL,
    con_titulo CHAR(50) NOT NULL,
    con_descripcion CHAR(255) NOT NULL,
    PRIMARY KEY (con_id)
);
#Registros Contenido
INSERT INTO contenido(con_id,con_titulo,con_descripcion) VALUES (1,'Tetris Effect: Connected','Tetris Effect: Connected es una versión expandida del original Tetris Effect con nuevos modos de juego cooperativos y competitivos para poder disfrutar en línea y, además, opciones de multijugador en partida local.');
INSERT INTO contenido(con_id,con_titulo,con_descripcion) VALUES (2,'FIFA 21','Comparte la gloria en EA SPORTS FIFA 21 con formas nuevas de jugar en equipo en la calle y el estadio para disfrutar de victorias aún más importantes.');
INSERT INTO contenido(con_id,con_titulo,con_descripcion) VALUES (3,'Crash Team Racing: Nitro Fueled','La auténtica experiencia de CTR y mucho más contenido remasterizado al máximo de revoluciones');
INSERT INTO contenido(con_id,con_titulo,con_descripcion) VALUES (4,'Spyro Reignited Trilogy','Spyro regresa en Spyro Reignited Trilogy con su aliento de fuego y la actitud de siempre, pero en una asombrosa alta definición.');
INSERT INTO contenido(con_id,con_titulo,con_descripcion) VALUES (5,'Grand Theft Auto V','Disfruta por completo de la trama de Grand Theft Auto V, accede gratuitamente al mundo de Grand Theft Auto Online y a todas las mejoras y contenidos existentes.');
INSERT INTO contenido(con_id,con_titulo,con_descripcion) VALUES (6,'HBO Max','HBO Max es la única plataforma de entretenimiento en streaming que incluye todo el contenido que amas de HBO, además de todas tus series de televisión favoritas, los estrenos de películas más esperados y nuevas e increíbles producciones originales.');
INSERT INTO contenido(con_id,con_titulo,con_descripcion) VALUES (7,'Spotify Music','Elige los temas que quieras a la carta y al instante, explora las listas de éxitos o disfruta de playlists ya hechas para cualquier género o estado de ánimo');
INSERT INTO contenido(con_id,con_titulo,con_descripcion) VALUES (8,'Crunchyroll','Lo mejor del anime japonés en tu pantalla.');
INSERT INTO contenido(con_id,con_titulo,con_descripcion) VALUES (9,'TuneIn Radio','TuneIn es una aplicación de audio gratuita que combina deportes en vivo, música, noticias, podcasts y más de 100,000 estaciones de radio en vivo de todo el mundo.');
#Tabla Aplicación
CREATE TABLE aplicacion(
	app_id INT NOT NULL,
    app_tipo CHAR(50) NOT NULL,
    PRIMARY KEY(app_id),
    FOREIGN KEY (app_id) REFERENCES contenido(con_id)
);
#Registros aplicacion
INSERT INTO aplicacion(app_id,app_tipo) VALUES(6,'Entretenimiento');
INSERT INTO aplicacion(app_id,app_tipo) VALUES(7,'Música');
INSERT INTO aplicacion(app_id,app_tipo) VALUES(8,'Entretenimiento');
INSERT INTO aplicacion(app_id,app_tipo) VALUES(9,'Música');
#tabla Juego
CREATE TABLE juego(
	jug_id INT NOT NULL,
    jug_distribuidor INT NOT NULL,
    jug_clasificacion CHAR(45) NOT NULL,
    jug_categoria CHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (jug_id),
    FOREIGN KEY (jug_id) REFERENCES contenido(con_id),
    FOREIGN KEY (jug_distribuidor) REFERENCES distribuidora(dis_id)
);
#Registros juego
INSERT INTO juego(jug_id,jug_distribuidor,jug_clasificacion,jug_categoria) VALUES(1,1,'Todos','Puzles y curiosidades');
INSERT INTO juego(jug_id,jug_distribuidor,jug_clasificacion,jug_categoria) VALUES(2,2,'Todos','Deportes');
INSERT INTO juego(jug_id,jug_distribuidor,jug_clasificacion,jug_categoria) VALUES(3,3,'Todos +10','Carreras y vuelo');
INSERT INTO juego(jug_id,jug_distribuidor,jug_clasificacion,jug_categoria) VALUES(4,3,'Todos +10','Acción y aventura');
INSERT INTO juego(jug_id,jug_distribuidor,jug_clasificacion,jug_categoria) VALUES(5,4,'Maduro 17+','Acción y aventura');
#Tabla Biblioteca
CREATE TABLE biblioteca(
	bib_id INT AUTO_INCREMENT,
    bib_tag CHAR (40) NOT NULL,
    bib_contenido INT NOT NULL,
    bib_fecha DATETIME NOT NULL,
    PRIMARY KEY (bib_id),
    FOREIGN KEY (bib_tag) REFERENCES cliente(cli_tag),
    FOREIGN KEY (bib_contenido) REFERENCES contenido(con_id)
);
#Registros Biblioteca
INSERT INTO biblioteca(bib_tag,bib_contenido,bib_fecha) VALUES('hoodoo',1,'18-10-25 20:00:00');
INSERT INTO biblioteca(bib_tag,bib_contenido,bib_fecha) VALUES('hoodoo',7,'20-10-25 20:00:00');
INSERT INTO biblioteca(bib_tag,bib_contenido,bib_fecha) VALUES('hoodoo',4,'18-10-25 20:00:00');
INSERT INTO biblioteca(bib_tag,bib_contenido,bib_fecha) VALUES('andre09',4,'18-10-25 20:00:00');
INSERT INTO biblioteca(bib_tag,bib_contenido,bib_fecha) VALUES('holy',4,'18-12-25 20:00:00');
INSERT INTO biblioteca(bib_tag,bib_contenido,bib_fecha) VALUES('holy',5,'18-10-25 20:00:00');
INSERT INTO biblioteca(bib_tag,bib_contenido,bib_fecha) VALUES('holy',1,'18-10-25 20:00:00');
INSERT INTO biblioteca(bib_tag,bib_contenido,bib_fecha) VALUES('holy',6,'18-10-25 20:00:00');
INSERT INTO biblioteca(bib_tag,bib_contenido,bib_fecha) VALUES('jquispe',9,'18-10-25 20:00:00');
INSERT INTO biblioteca(bib_tag,bib_contenido,bib_fecha) VALUES('jk2929',7,'18-10-25 20:00:00');
INSERT INTO biblioteca(bib_tag,bib_contenido,bib_fecha) VALUES('cgallardo',1,'21-10-25 20:00:00');
INSERT INTO biblioteca(bib_tag,bib_contenido,bib_fecha) VALUES('cgallardo',1,'22-10-25 16:00:00');


