from django.db import models

class Talla(models.Model):
    id_talla = models.CharField(primary_key=True, max_length=12)
    nombre_talla = models.CharField('nombre_talla', max_length=45)


# ref: https://es.scribd.com/document/67228083/Base-de-Datos-Tienda-de-Ropa