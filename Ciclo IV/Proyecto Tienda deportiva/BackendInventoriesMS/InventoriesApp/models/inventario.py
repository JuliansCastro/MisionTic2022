from datetime import datetime
from django.db import models

from .talla import Talla
from .tienda import Tienda

class Inventario(models.Model):
    codigo_barras = models.BigAutoField(primary_key=True)
    nombre_prod = models.CharField('nombre', max_length=45)
    descripcion = models.TextField('descripción', max_length=1000)
    talla = models.ForeignKey(Talla, related_name='talla', on_delete=models.CASCADE)
    cantidad = models.IntegerField('cantidad', default=0)
    fecha_ingreso = models.DateField('fecha_ingreso', default=datetime.now, blank=True)
    precio_compra = models.DecimalField('precio_compra', max_digits=10, decimal_places=2)
    precio_venta = models.DecimalField('precio_venta', max_digits=10, decimal_places=2)
    nit_tienda = models.ForeignKey(Tienda, related_name='tienda', on_delete=models.CASCADE)
