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
