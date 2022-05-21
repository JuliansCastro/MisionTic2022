from django.db import models

class Tienda(models.Model):
    nit = models.IntegerField(primary_key=True)
    nombre_tienda = models.CharField('nombre_tienda', max_length=45)
    direccion_tienda = models.CharField('direccion_tienda', max_length=150)
