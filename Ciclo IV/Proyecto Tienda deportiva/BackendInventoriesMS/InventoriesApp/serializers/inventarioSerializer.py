from rest_framework import serializers
from InventoriesApp.models.inventario import Inventario
from InventoriesApp.models.tienda import Tienda
from InventoriesApp.serializers.tiendaSerializer import TiendaSerializer


class InventarioSerializer(serializers.ModelSerializer):
    #tienda = TiendaSerializer()
    class Meta:
        model = Inventario
        fields = ['codigo_barras', 'nombre_prod', 'descripcion', 'talla', 'cantidad',
                  'fecha_ingreso', 'precio_compra', 'precio_venta', 'nit_tienda']

