from rest_framework.fields import NOT_REQUIRED_DEFAULT
from rest_framework import serializers
from g6App.models.miscelanea import Miscelanea

class MiscelaneaSerializer(serializers.ModelSerializer):
    class Meta:
        model = Miscelanea
        fields = ['nit', 'nombre_misc','direccion_misc']
    
    
    def create(self, validated_data):
        return Miscelanea.objects.create(**validated_data) # Dict to Miscelanea instance
    
    
    def to_representation(self, obj):
        miscelanea = Miscelanea.objects.get(nit=obj.nit)
        return{
            'nit' : miscelanea.nit,
            'nombre_misc' : miscelanea.nombre_misc,
            'direccion_misc' :  miscelanea.direccion_misc
        }
    
