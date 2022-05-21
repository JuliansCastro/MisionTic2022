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
