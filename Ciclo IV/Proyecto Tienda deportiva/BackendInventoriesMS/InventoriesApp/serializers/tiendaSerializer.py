from rest_framework.fields import NOT_REQUIRED_DEFAULT
from rest_framework import serializers
from InventoriesApp.models.tienda import Tienda

class TiendaSerializer(serializers.ModelSerializer):
    class Meta:
        model = Tienda
        fields = ['nit', 'nombre_tienda', 'direccion_tienda']
    
    def create(self, validated_data):
        return Tienda.objects.create(**validated_data) # Dict to Tienda instance
    
    
    def to_representation(self, obj):
        tienda = Tienda.objects.get(nit=obj.nit)
        return{
            'nit' : tienda.nit,
            'nombre_tienda' : tienda.nombre_tienda,
            'direccion_tienda' :  tienda.direccion_tienda
        }
    
