from django.conf                          import settings
from rest_framework                       import status, views,generics
from rest_framework.response              import Response
from rest_framework_simplejwt.backends    import TokenBackend
from rest_framework.permissions           import IsAuthenticated
from rest_framework_simplejwt.serializers import TokenObtainPairSerializer
from g6App.models.empleado                import Empleado
from g6App.serializers.empleadoSerializer import EmpleadoSerializer



class EmpleadoCreateView(views.APIView):
    def post(self, request, *args, **kwargs):     
        # Si 'request.data['miscelanea']' es un diccionario devuelve unicamente el 'id'
        if type(request.data['miscelanea']) == dict:
            request.data['miscelanea'] = request.data['miscelanea']['nit']

        serializer = EmpleadoSerializer(data=request.data) #CRea el serializer, Recibe del json y lo convierte al objeto  que corresponda

        serializer.is_valid(raise_exception=True) #valida si los objetos fueron creados correctamente
        serializer.save() #Guarda esos objetos en la base de datos/insert
        #Si el serializer confirma que el json recibido es correcto, crea el token de autenticacion
        tokenData = {
                        "username":request.data["username"],
                        "password":request.data["password"]
                    } #SE crea un token a partir de los usuario y contrasena
        try:
            tokenSerializer = TokenObtainPairSerializer(data=tokenData) #CRea los tokens de refresh y access
            tokenSerializer.is_valid(raise_exception=True)
            return Response(tokenSerializer.validated_data, status=status.HTTP_201_CREATED)
        except Exception as e:
            print("ERROR", e)
            return Response('Error in token generation', status=status.HTTP_500_INTERNAL_SERVER_ERROR)


#Obtener informacion de un empleado
class EmpleadoDetailView(generics.RetrieveAPIView):
    queryset = Empleado.objects.all() #valida cuales empleados puede buscar y los guarda en ram
    serializer_class = EmpleadoSerializer
    permission_classes = (IsAuthenticated,)

    def get(self, request, *args, **kwargs):
        token = request.META.get('HTTP_AUTHORIZATION')[7:]
        tokenBackend = TokenBackend(algorithm=settings.SIMPLE_JWT['ALGORITHM'])
        valid_data = tokenBackend.decode(token, verify=False)
      
        if valid_data['user_id'] != kwargs['pk']:
            stringResponse = {'detail': 'Unauthorized Request'}
            return Response(stringResponse, status=status.HTTP_401_UNAUTHORIZED)
        return super().get(request, *args, **kwargs)

