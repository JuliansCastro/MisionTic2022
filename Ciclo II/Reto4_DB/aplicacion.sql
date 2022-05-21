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
