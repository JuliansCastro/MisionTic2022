SELECT 'Consulta 1';
SELECT con_titulo FROM contenido ORDER BY con_titulo DESC; -- ASC ascendente
SELECT 'Consulta 2';
SELECT con_titulo FROM contenido JOIN juego ON con_id=jug_id WHERE jug_clasificacion LIKE '%+%';
SELECT 'Consulta 3';
SELECT con_titulo, jug_clasificacion, jug_categoria 
FROM contenido 
JOIN juego ON con_id=jug_id 
JOIN distribuidora ON jug_distribuidor=dis_id 
WHERE dis_nombre='Activision';
SELECT 'Consulta 4';
SELECT con_titulo FROM biblioteca
JOIN contenido ON bib_contenido=con_id
WHERE bib_tag='hoodoo';
SELECT 'Consulta 5';
SELECT cli_nombre FROM cliente
JOIN biblioteca ON cli_tag=bib_tag
JOIN contenido ON bib_contenido=con_id
WHERE con_titulo='Spyro Reignited Trilogy'
ORDER BY cli_nombre ASC;
SELECT 'Consulta 6';
SELECT COUNT(con_titulo) FROM contenido
JOIN aplicacion ON con_id=app_id
WHERE app_tipo='Música';
SELECT 'Consulta 7';
SELECT cli_email FROM cliente
WHERE cli_tag='andre09';