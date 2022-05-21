from django.db import models

class Producto(models.Model):
    id = models.AutoField(primary_key=True)
    nombre_prod = models.CharField('nombre', max_length=45)
    descripcion = models.TextField('descripción', max_length=200)