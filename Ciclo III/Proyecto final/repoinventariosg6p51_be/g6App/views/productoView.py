from django.conf                          import settings
from rest_framework                       import status, views,generics
from rest_framework.response              import Response
from rest_framework_simplejwt.backends    import TokenBackend
from rest_framework.permissions           import IsAuthenticated
from rest_framework_simplejwt.serializers import TokenObtainPairSerializer

from g6App.models.producto import Producto
from g6App.serializers.productoSerializer import ProductoSerializer

#ObtenerProducto
class ProductoView(generics.RetrieveAPIView):
    queryset = Producto.objects.all() #valida cuales empleados puede buscar y los guarda en ram
    serializer_class = ProductoSerializer
    permission_classes = (IsAuthenticated,)
    
    def get(self, request, *args, **kwargs):        
        return super().get(request, *args, **kwargs)


#listar los productos existentes
class ProductoDetailView(generics.ListAPIView):
    queryset = Producto.objects.all()
    serializer_class = ProductoSerializer    
    permission_classes = (IsAuthenticated,)  # Solo los usuarios autenticados pueden acceder a este endpoint

    def get(self, request, *args, **kwargs):
           serializer = ProductoSerializer(self.get_queryset(), many=True)  # many=True para que devuelva una lista
           return Response(serializer.data)
   
#crear un producto nuevo
class ProductoCreateView(generics.CreateAPIView):
    serializer_class = ProductoSerializer
    permission_classes = (IsAuthenticated,) #Solo los usuarios autenticados pueden acceder a este endpoint
    def post(self, request, *args, **kwargs):
            serializer = ProductoSerializer(data=request.data)
            if serializer.is_valid():
                serializer.save()
                return Response(serializer.data, status=status.HTTP_201_CREATED)
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)    
#actualizar un producto
class ProductoUpdateView(generics.RetrieveUpdateAPIView):
    queryset = Producto.objects.all()
    serializer_class = ProductoSerializer
    permission_classes = (IsAuthenticated,) #Solo los usuarios autenticados pueden acceder a este endpoint
    
    def update(self, request, *args, **kwargs):
            instanceProduct = self.get_object()
            serializer = ProductoSerializer(data=request.data)
            if serializer.is_valid():
                productUpdated = serializer.update(instanceProduct, serializer.validated_data)
                serializer = ProductoSerializer(productUpdated)
                return Response(serializer.data, status=status.HTTP_200_OK)
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

#eliminar un producto
class ProductoDeleteView(generics.DestroyAPIView):
    queryset = Producto.objects.all()
    serializer_class = ProductoSerializer
    http_method_names = ['get', 'delete', 'options']
    #lookup_field = 'pk' 
     
    permission_classes = (IsAuthenticated,) #Solo los usuarios autenticados pueden acceder a este endpoint
    
    def get(self, request, *args, **kwargs):
        self.queryset = Producto.objects.filter(id=kwargs['pk'])
        serializer = ProductoSerializer(self.queryset, many=True)
        #print('>>>>>>>>>>>>>>>> Lista: ', serializer.data)
        if serializer.data != []:
            return Response(serializer.data[0], status=status.HTTP_200_OK)
        else:
            message = {    "detail": "Not found. The resource doesn't exist"   }
            return Response(message, status=status.HTTP_404_NOT_FOUND)      

    def delete(self, request, *args, **kwargs):
        return self.destroy(request, *args, **kwargs)
