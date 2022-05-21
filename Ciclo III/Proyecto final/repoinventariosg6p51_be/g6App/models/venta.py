from datetime import datetime
from django.db import models
from .cliente import Cliente


class Venta(models.Model):
    id = models.BigAutoField(primary_key=True)
    fecha = models.DateTimeField('fecha', default=datetime.now, blank=True)
    id_cliente = models.ForeignKey(Cliente, related_name="id_cliente", on_delete=models.CASCADE)


   