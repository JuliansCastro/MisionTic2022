from datetime import datetime
from django.db import models
from .miscelanea import Miscelanea
from .producto import Producto

class Inventario(models.Model):
    codigo_barras = models.BigAutoField(primary_key=True)
    fecha_vencimiento = models.DateField('fecha_vencimiento')
    fecha_ingreso = models.DateField('fecha_ingreso', default=datetime.now, blank=True)
    precio_compra = models.DecimalField('precio_compra', max_digits=10, decimal_places=2)
    precio_venta = models.DecimalField('precio_venta', max_digits=10, decimal_places=2)
    id_producto = models.ForeignKey(Producto, related_name='id_producto', on_delete=models.CASCADE)
    id_miscelanea = models.ForeignKey(Miscelanea, related_name='miscelanea', on_delete=models.CASCADE)
