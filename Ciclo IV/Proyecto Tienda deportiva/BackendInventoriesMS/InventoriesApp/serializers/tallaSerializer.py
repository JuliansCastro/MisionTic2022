from rest_framework import serializers
from InventoriesApp.models import Talla

class TallaSerializer(serializers.ModelSerializer):
    class Meta:
        model = Talla
        fields = ['id_talla', 'nombre_talla']

    def create(self, validated_data):
        return Talla.objects.create(**validated_data) # Dict to Talla instance