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
