from rest_framework import serializers
from g6App.models.empleado import Empleado
from g6App.models.miscelanea import Miscelanea



class EmpleadoSerializer(serializers.ModelSerializer):
    class Meta:
        model = Empleado
        fields = ['id','username', 'nombre', 'apellido', 'cedula', 'email', 'password','create_time','miscelanea'] #En realidad en miscelanea el id es nit
       
    #PDT ARREGALAR PARA QUE EL METODO RECIBA  EL JSON DE MISCELANEA SIN INDICAR ESPECIFICAMENTE LA id
    def to_representation(self,obj):
        empleado = Empleado.objects.get(id=obj.id) #De el dato que usa "objects" trae los emmpleados donde el id del obj actual se igual al de la tabla
        miscelanea = Miscelanea.objects.get(nit=empleado.miscelanea_id) #trae la miscelanea asociada al empleado, en donde el nit sea igual al campo empleado.miscelanea_ID
        return{
            #'id': empleado.id,
            'username': empleado.username,
            'nombre': empleado.nombre,
            'apellido': empleado.apellido,
            'cedula': empleado.cedula,
            'email': empleado.email,
            #'password': empleado.password,
            'create_time': empleado.create_time,
            'miscelanea':{
                #'id' : miscelanea.id,
                'nit':miscelanea.nit,
                'nombre_misc':miscelanea.nombre_misc,
                'direccion_misc':miscelanea.direccion_misc
            }   
        }