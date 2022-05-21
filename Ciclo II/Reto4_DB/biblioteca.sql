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
