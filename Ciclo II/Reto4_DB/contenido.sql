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
