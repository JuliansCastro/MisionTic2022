-- Seleccionar DB
USE `reto5_basedatos`;

SELECT  bib_id, bib_fecha, bib_tag,
        cli_nombre, con_id, con_titulo
FROM    biblioteca JOIN cliente JOIN contenido
ON      biblioteca.bib_tag=cliente.cli_tag
AND     biblioteca.bib_contenido=contenido.con_id
ORDER BY bib_id DESC;


SELECT DISTINCT bib_fecha
FROM biblioteca
ORDER BY bib_fecha DESC;

# obtener contenido
SELECT con_id,con_titulo,con_descripcion
FROM  contenido;

# obtener clientes
SELECT cli_tag, cli_nombre
FROM  cliente;

SELECT bib_id,bib_fecha,bib_tag,cli_nombre,con_id,con_titulo
FROM biblioteca JOIN cliente JOIN contenido
ON biblioteca.bib_tag=cliente.cli_tag
AND biblioteca.bib_contenido=contenido.con_id
WHERE bib_tag LIKE "%cgallardo%"
ORDER BY bib_id DESC;

SELECT bib_id,bib_fecha,bib_tag,cli_nombre,con_id,con_titulo
FROM biblioteca JOIN cliente JOIN contenido
ON biblioteca.bib_tag=cliente.cli_tag
AND biblioteca.bib_contenido=contenido.con_id
WHERE con_titulo LIKE "%Spotify Music%"
ORDER BY bib_id DESC;

USE `reto5_basedatos`;
UPDATE biblioteca
SET bib_contenido= 2,bib_tag='holy'
WHERE bib_id=4;