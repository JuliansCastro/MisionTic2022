from django.contrib import admin
# Register your models here.
from .models.inventario import Inventario
from .models.tienda import Tienda
from .models.talla import Talla


admin.site.register(Inventario)
admin.site.register(Tienda)
admin.site.register(Talla)
