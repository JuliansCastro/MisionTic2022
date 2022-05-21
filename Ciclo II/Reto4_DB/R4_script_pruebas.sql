/*
 * RETO 4: Reto 4: Grupo P80_C2
 */

-- Crear DB
DROP DATABASE IF EXISTS tienda_contenidos;
CREATE SCHEMA tienda_contenidos;

-- Seleccionar DB
USE tienda_contenidos;


-- Crear tabla 'contenido'
DROP TABLE IF EXISTS contenido;	-- Verificar existencia de tabla
CREATE TABLE contenido (
	con_id			INT			NOT NULL,
    con_titulo		CHAR(50)	NOT NULL ,
    con_descripcion	CHAR(255)	NOT NULL,
    PRIMARY KEY (con_id)
);
-- Inserción de datos en la tabla 'contenido'
INSERT INTO contenido (con_id, con_titulo, con_descripcion) VALUES (1001,'Tetris Effect: Connected', 'Tetris Effect: Connected es una versión expandida del original Tetris Effect con nuevos modos de juego cooperativos y competitivos para poder disfrutar en línea y, además, opciones de multijugador en partida local.');
INSERT INTO contenido (con_id, con_titulo, con_descripcion) VALUES (1002,'FIFA 21', 'Comparte la gloria en EA SPORTS FIFA 21 con formas nuevas de jugar en equipo en la calle y el estadio para disfrutar de victorias aún más importantes.'); -- Verificar espacio final FIFA
INSERT INTO contenido (con_id, con_titulo, con_descripcion) VALUES (1003,'Crash Team Racing: Nitro Fueled', 'La auténtica experiencia de CTR y mucho más contenido remasterizado al máximo de revoluciones');
INSERT INTO contenido (con_id, con_titulo, con_descripcion) VALUES (1004, 'Spyro Reignited Trilogy', 'Spyro regresa en Spyro Reignited Trilogy con su aliento de fuego y la actitud de siempre, pero en una asombrosa alta definición.');
INSERT INTO contenido (con_id, con_titulo, con_descripcion) VALUES (1005, 'Grand Theft Auto V', 'Disfruta por completo de la trama de Grand Theft Auto V, accede gratuitamente al mundo de Grand Theft Auto Online y a todas las mejoras y contenidos existentes.');
INSERT INTO contenido (con_id, con_titulo, con_descripcion) VALUES (1006, 'HBO Max', 'HBO Max es la única plataforma de entretenimiento en streaming que incluye todo el contenido que amas de HBO, además de todas tus series de televisión favoritas, los estrenos de películas más esperados y nuevas e increíbles producciones originales.');
INSERT INTO contenido (con_id, con_titulo, con_descripcion) VALUES (1007, 'Spotify Music', 'Elige los temas que quieras a la carta y al instante, explora las listas de éxitos o disfruta de playlists ya hechas para cualquier género o estado de ánimo');
INSERT INTO contenido (con_id, con_titulo, con_descripcion) VALUES (1008, 'Crunchyroll', 'Lo mejor del anime japonés en tu pantalla.');
INSERT INTO contenido (con_id, con_titulo, con_descripcion) VALUES (1009, 'TuneIn Radio', 'TuneIn es una aplicación de audio gratuita que combina deportes en vivo, música, noticias, podcasts y más de 100,000 estaciones de radio en vivo de todo el mundo.');

-- Crear tabla 'cliente'
DROP TABLE IF EXISTS cliente;	-- Verificar existencia de tabla
CREATE TABLE cliente (
	cli_tag			CHAR(20)	NOT NULL,
    cli_nombre		CHAR(20)	NOT NULL,
    cli_email		CHAR(30)	NOT NULL,
    cli_celular		BIGINT		NULL DEFAULT NULL, -- revisar por si es NOT NULL
    cli_clave		CHAR(20)	NULL DEFAULT NULL, -- revisar por si es NOT NULL
    cli_fecha_nto	DATE		NOT NULL,
    PRIMARY KEY (cli_tag)
);
-- Inserción de datos en la tabla 'cliente'
INSERT INTO cliente (cli_tag, cli_nombre, cli_email, cli_celular, cli_clave, cli_fecha_nto) VALUES ('hoodoo', 'Samary Cardona', 'hoodoo@outloook.com', 3137495759, '012348765', '2021-09-01');
INSERT INTO cliente (cli_tag, cli_nombre, cli_email, cli_celular, cli_clave, cli_fecha_nto) VALUES ('andre09', 'Andrea Cardona', 'andre09@outloook.com', 3137495750, '012348765', '2021-09-02');
INSERT INTO cliente (cli_tag, cli_nombre, cli_email, cli_celular, cli_clave, cli_fecha_nto) VALUES ('holy', 'Carlos Alonso', 'holy@outloook.com', 3137495751, '012348765', '2021-09-03');
INSERT INTO cliente (cli_tag, cli_nombre, cli_email, cli_celular, cli_clave, cli_fecha_nto) VALUES ('jquispe', 'Julian Quispoe', 'jquispe@outloook.com', 3137495752, '012348765', '2021-09-04');
INSERT INTO cliente (cli_tag, cli_nombre, cli_email, cli_celular, cli_clave, cli_fecha_nto) VALUES ('cgallardo', 'Camilo Gallardo', 'cgallardo@outloook.com', 3137495753, '012348765', '2021-09-05');
INSERT INTO cliente (cli_tag, cli_nombre, cli_email, cli_celular, cli_clave, cli_fecha_nto) VALUES ('jk2929', 'Juana Camila', 'jk2929@outloook.com', 3137495754, '012348765', '2021-09-06');

-- Crear tabla 'biblioteca'
DROP TABLE IF EXISTS biblioteca; -- Verificar existencia de tabla
CREATE TABLE biblioteca (
	bib_id			INT			NOT NULL,
    bib_tag			CHAR(40)	NOT NULL,
    bib_contenido	INT			NOT NULL,
    bib_fecha		DATETIME	NOT NULL,
    PRIMARY KEY (bib_id),
    FOREIGN KEY (bib_tag)		REFERENCES cliente(cli_tag),
    FOREIGN KEY (bib_contenido)	REFERENCES contenido(con_id)
);
-- Inserción de datos en la tabla 'biblioteca'
INSERT INTO biblioteca (bib_id, bib_tag, bib_contenido, bib_fecha) VALUES (1, 'hoodoo', 1001, '2018-10-25 20:00:00');
INSERT INTO biblioteca (bib_id, bib_tag, bib_contenido, bib_fecha) VALUES (2, 'hoodoo', 1007, '2020-10-25 20:00:00');
INSERT INTO biblioteca (bib_id, bib_tag, bib_contenido, bib_fecha) VALUES (3, 'hoodoo', 1004, '2018-10-25 20:00:00');
INSERT INTO biblioteca (bib_id, bib_tag, bib_contenido, bib_fecha) VALUES (4, 'andre09', 1004, '2018-10-25 20:00:00');
INSERT INTO biblioteca (bib_id, bib_tag, bib_contenido, bib_fecha) VALUES (5, 'holy', 1004, '2018-12-25 20:00:00');
INSERT INTO biblioteca (bib_id, bib_tag, bib_contenido, bib_fecha) VALUES (6, 'holy', 1005, '2018-10-25 20:00:00');
INSERT INTO biblioteca (bib_id, bib_tag, bib_contenido, bib_fecha) VALUES (7, 'holy', 1001, '2018-10-25 20:00:00');
INSERT INTO biblioteca (bib_id, bib_tag, bib_contenido, bib_fecha) VALUES (8, 'holy', 1006, '2018-10-25 20:00:00');
INSERT INTO biblioteca (bib_id, bib_tag, bib_contenido, bib_fecha) VALUES (9, 'jquispe', 1009, '2018-10-25 20:00:00');
INSERT INTO biblioteca (bib_id, bib_tag, bib_contenido, bib_fecha) VALUES (10, 'jk2929', 1007, '2018-10-25 20:00:00');
INSERT INTO biblioteca (bib_id, bib_tag, bib_contenido, bib_fecha) VALUES (11, 'cgallardo', 1001, '2021-10-25 20:00:00');


-- Crear tabla 'aplicacion'
DROP TABLE IF EXISTS aplicacion; -- Verificar existencia de tabla
CREATE TABLE aplicacion (
	app_id		INT			NOT NULL,
    app_tipo	CHAR(50)	NOT NULL,
    PRIMARY KEY (app_id),
    FOREIGN KEY (app_id) REFERENCES contenido(con_id)
);
-- Inserción de datos en la tabla 'aplicacion'
INSERT INTO aplicacion (app_id, app_tipo) VALUES (1006, 'Entretenimiento');
INSERT INTO aplicacion (app_id, app_tipo) VALUES (1007, 'Música');
INSERT INTO aplicacion (app_id, app_tipo) VALUES (1008, 'Entretenimiento');
INSERT INTO aplicacion (app_id, app_tipo) VALUES (1009, 'Música');

-- Crear tabla 'distribuidora'
DROP TABLE IF EXISTS distribuidora;	-- Verificar existencia de tabla
CREATE TABLE distribuidora (
	dis_id		INT			NOT NULL,
    dis_nombre	CHAR(20)	NOT NULL,
    dis_pais 	CHAR(40)	NULL DEFAULT NULL,
    PRIMARY KEY (dis_id)
);
-- Inserción de datos en la tabla 'distribuidora'
INSERT INTO distribuidora (dis_id, dis_nombre, dis_pais) VALUES (101, 'Enhance', 'USA');
INSERT INTO distribuidora (dis_id, dis_nombre, dis_pais) VALUES (102, 'Electronic Arts', 'USA');
INSERT INTO distribuidora (dis_id, dis_nombre, dis_pais) VALUES (103, 'Activision', 'USA');
INSERT INTO distribuidora (dis_id, dis_nombre, dis_pais) VALUES (104, 'Rockstar Games', 'USA'); 
INSERT INTO distribuidora (dis_id, dis_nombre, dis_pais) VALUES (105, 'Bethesda', 'USA');
INSERT INTO distribuidora (dis_id, dis_nombre, dis_pais) VALUES (106, 'Konami', 'Japón');

-- Crear tabla 'juego'
DROP TABLE IF EXISTS juego;			-- Verificar existencia de tabla
CREATE TABLE juego (
	jug_id				INT			NOT NULL,
    jug_distribuidor	INT 		NOT NULL,
    jug_clasificacion	CHAR(45)	NOT NULL,
    jug_categoria		CHAR(45)	NULL DEFAULT NULL, -- revisar por si es NOT NULL
    PRIMARY KEY (jug_id),
    FOREIGN KEY (jug_id)	REFERENCES contenido(con_id),
    FOREIGN KEY (jug_distribuidor)	REFERENCES distribuidora(dis_id)
);
-- Inserción de datos en la tabla 'juego'
INSERT INTO juego (jug_id, jug_distribuidor, jug_clasificacion, jug_categoria) VALUES (1001, 101, 'Todos', 'Puzles y curiosidades');
INSERT INTO juego (jug_id, jug_distribuidor, jug_clasificacion, jug_categoria) VALUES (1002, 102, 'Todos', 'Deportes');
INSERT INTO juego (jug_id, jug_distribuidor, jug_clasificacion, jug_categoria) VALUES (1003, 103, 'Todos +10', 'Carreras y vuelo');
INSERT INTO juego (jug_id, jug_distribuidor, jug_clasificacion, jug_categoria) VALUES (1004, 103, 'Todos +10', 'Acción y aventura');
INSERT INTO juego (jug_id, jug_distribuidor, jug_clasificacion, jug_categoria) VALUES (1005, 104, 'Maduro 17+', 'Acción y aventura'); -- ¡OJO! Cuidado con el punto


-- MODIFICACIONES Y BORRADOS
SET SQL_SAFE_UPDATES=0;		-- Desactivar modo seguro. 1 para activar
SELECT * FROM contenido;	-- Mostrar tabla
SELECT * FROM cliente;		-- Mostrar tabla
SELECT * FROM biblioteca;	-- Mostrar tabla
SELECT * FROM distribuidora;	-- Mostrar tabla


-- Cambiar el nombre de la aplicación Spotify Music por Spotify.
UPDATE contenido SET con_titulo='Spotify' WHERE con_titulo='Spotify Music';
-- Cambiar el email del cliente andre09 por andre@outloook.com
UPDATE cliente SET cli_email='andre@outloook.com' WHERE cli_tag='andre09';
-- Borrar de la librería de holy el juego " Tetris Effect: Connected "
DELETE FROM biblioteca WHERE bib_tag='holy' AND bib_contenido=(
	SELECT con_id FROM contenido WHERE con_titulo='Tetris Effect: Connected');
-- Cambiar USA por Estados Unidos en todas las distribuidoras que sean de ese país.
UPDATE distribuidora SET dis_pais='Estados Unidos' WHERE dis_pais='USA';


-- CONSULTAS
-- Mostrar la información del título de todos los juegos y aplicaciones ordenados de la Z-A
SELECT 'Consulta 1';
SELECT con_titulo FROM contenido ORDER BY con_titulo DESC; -- ASC ascendente

-- Mostrar el nombre de los juegos que incluyan dentro de su clasificación el carácter + (más)
SELECT 'Consulta 2';
SELECT con_titulo FROM contenido JOIN juego ON con_id=jug_id WHERE jug_clasificacion LIKE '%+%';

-- Mostrar nombre, clasificación y categoría de los juegos de Activision 
SELECT 'Consulta 3';
SELECT con_titulo, jug_clasificacion, jug_categoria 
FROM contenido 
JOIN juego ON con_id=jug_id 
JOIN distribuidora ON jug_distribuidor=dis_id 
WHERE dis_nombre='Activision';

-- Mostrar el titulo de los juegos y aplicaciones que adquirió el usuario hoodoo
SELECT 'Consulta 4';
SELECT con_titulo FROM biblioteca
JOIN contenido ON bib_contenido=con_id
WHERE bib_tag='hoodoo';

-- Mostrar nombre completo de las personas que adquirieron Spyro Reignited Trilogy, ordenados de la A-Z
SELECT 'Consulta 5';
SELECT cli_nombre FROM cliente
JOIN biblioteca ON cli_tag=bib_tag
JOIN contenido ON bib_contenido=con_id
WHERE con_titulo='Spyro Reignited Trilogy'
ORDER BY cli_nombre ASC;

-- Mostrar cuantas aplicaciones son de tipo Música - COUNT()
SELECT 'Consulta 6';
SELECT COUNT(con_titulo) FROM contenido
JOIN aplicacion ON con_id=app_id
WHERE app_tipo='Música';

-- Mostrar la columna email del usuario andre09
SELECT 'Consulta 7';
SELECT cli_email FROM cliente
WHERE cli_tag='andre09';


/*
 * DOCUMENTACIÓN:
 * Eliminar DBs: https://www.neoguias.com/como-borrar-una-base-de-datos-mysql/
 * SQL FOREIGN KEY: https://www.w3schools.com/sql/sql_foreignkey.asp
 * DATA format: https://www.programaenlinea.net/como-manejar-fechas-en-mysql-explicacion-formato-date/
 * COUNT(): https://www.anerbarrena.com/mysql-count-5979/
 */