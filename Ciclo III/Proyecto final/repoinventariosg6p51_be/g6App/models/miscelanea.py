from django.db import models

class Miscelanea(models.Model):
    nit = models.IntegerField(primary_key=True)
    nombre_misc = models.CharField('nombre_miscelanea', max_length=45)
    direccion_misc = models.CharField('direccion_miscelanea', max_length=150, unique=True)
    
