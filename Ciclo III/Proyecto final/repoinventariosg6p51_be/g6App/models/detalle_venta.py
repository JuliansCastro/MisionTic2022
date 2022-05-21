from django.db import models
from .venta import Venta
from .inventario import Inventario


class Detalle_venta(models.Model):
    id = models.BigAutoField(primary_key=True)
    precio_venta = models.FloatField('precio', default=0)
    id_inventario = models.ForeignKey(Inventario, related_name="id_inventario", on_delete=models.CASCADE)
    id_venta = models.ForeignKey(Venta, related_name="id_venta", on_delete=models.CASCADE)

   