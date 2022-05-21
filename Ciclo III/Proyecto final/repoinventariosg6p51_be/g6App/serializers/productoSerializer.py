from g6App.models.producto import Producto
from rest_framework import serializers


class ProductoSerializer(serializers.ModelSerializer):
    class Meta:
        model = Producto
        fields = ['nombre_prod', 'descripcion']

    def create(self, validated_data):
        return Producto.objects.create(**validated_data)  # Dict to Miscelanea instance


    def to_representation(self, obj):
        producto = Producto.objects.get(id=obj.id)
        return{
            'id': producto.id,
            'nombre_prod': producto.nombre_prod,
            'descripcion':  producto.descripcion
        }
