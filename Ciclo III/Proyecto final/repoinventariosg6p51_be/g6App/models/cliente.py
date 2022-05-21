from django.db import models

class Cliente (models.Model):
    id = models.BigAutoField(primary_key=True)
    nombre = models.CharField('nombre', max_length = 45)
    documento = models.FloatField('documento', unique=True)

