#Recuperar registros de ventas ordenados por fecha
USE reto4;
SELECT bib_id,bib_fecha,bib_tag,cli_nombre,con_id,con_titulo 
from biblioteca JOIN cliente JOIN contenido
on biblioteca.bib_tag=cliente.cli_tag and biblioteca.bib_contenido=contenido.con_id
 order by bib_id desc ;
 
 #Seleccionar registros de un cliente
SELECT bib_fecha,bib_tag,cli_nombre,con_titulo 
from biblioteca JOIN cliente JOIN contenido
on biblioteca.bib_tag=cliente.cli_tag and biblioteca.bib_contenido=contenido.con_id
WHERE cli_tag= 'hoodoo'
 order by bib_fecha desc ;