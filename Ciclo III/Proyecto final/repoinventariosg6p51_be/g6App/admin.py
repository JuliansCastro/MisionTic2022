from django.contrib import admin
# Register your models here.
from .models.cliente import Cliente
from .models.detalle_venta import Detalle_venta
from .models.empleado import Empleado
from .models.inventario import Inventario
from .models.miscelanea import Miscelanea
from .models.producto import Producto
from .models.venta import Venta

admin.site.register(Cliente)
admin.site.register(Detalle_venta)
admin.site.register(Empleado)
admin.site.register(Inventario)
admin.site.register(Miscelanea)
admin.site.register(Producto)
admin.site.register(Venta)



