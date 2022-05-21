from rest_framework import serializers
from g6App.models.inventario import Inventario
from g6App.models.miscelanea import Miscelanea
from g6App.models.producto import Producto
from g6App.serializers.miscelaneaSerializer import MiscelaneaSerializer
from g6App.serializers.productoSerializer import ProductoSerializer

class InventarioSerializer(serializers.ModelSerializer):
    miscelanea=MiscelaneaSerializer()
    producto=ProductoSerializer()
    class Meta:
        model = Inventario
        fields = ['codigo_barras', 'fecha_vencimiento','fecha_ingreso','precio_compra','precio_venta', 'id_producto', 'nit_miscelanea']

    
    def create(self, validated_data):
        miscelaneaData= validated_data.pop('miscelanea')
        productoData= validated_data.pop('producto')
        inventarioInstance = Inventario.objects.create(**validated_data)
        Miscelanea.objects.create(inventario=inventarioInstance, **miscelaneaData)
        Producto.objects.create(inventario=inventarioInstance, **productoData)
        return inventarioInstance
   
    
    def to_representation(self,obj):
        inventario = Inventario.objects.get(id=obj.id)
        miscelanea = Miscelanea.objects.get(inventario=obj.id)
        producto = Producto.objects.get(inventario=obj.id)
        return{
            'codigo_barras': inventario.codigo_barras,
            'fecha_vencimiento': inventario.fecha_vencimiento,
            'fecha_ingreso': inventario.fecha_ingreso,
            'precio_compra': inventario.precio_compra,
            'precio_venta': inventario.precio_venta,
            'id_producto':{
                'id': producto.id,
                'nombre': producto.nombre_prod,
                'descripcion': producto.descripcion,
            },     
            'nit_miscelanea':{
                'nit': miscelanea.nit,
                'nombre': miscelanea.nombre_misc,
                'direccion': miscelanea.direccion_misc
            }    
        }
    