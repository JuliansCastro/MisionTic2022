from django.db.models.query import QuerySet
from rest_framework import generics, status
from rest_framework.response import Response
from rest_framework.permissions import IsAuthenticated
from InventoriesApp.models.tienda import Tienda
from InventoriesApp.serializers.tiendaSerializer import TiendaSerializer
import logging as L
#from rest_framework.permissions import IsAuthenticated


# Obtener Tienda
class TiendaView(generics.ListAPIView): # Lista todas las tienda
    queryset = Tienda.objects.all()
    serializer_class = TiendaSerializer
    #permission_classes = (IsAuthenticated,) #Solo los usuarios autenticados pueden acceder a este endpoint

    def get(self, request, *args, **kwargs):
        queryset = self.get_queryset()
        serializer = TiendaSerializer(queryset, many=True)
        return Response(serializer.data)


#listar una tienda existente
class TiendaDetailView(generics.RetrieveAPIView):
    queryset = Tienda.objects.all()
    lookup_field = 'pk'
    serializer_class = TiendaSerializer    
    #permission_classes = (IsAuthenticated,) #Solo los usuarios autenticados pueden acceder a este endpoint

    def get(self, *args, **kwargs):
        tienda_qs = Tienda.objects.filter(pk=self.kwargs[self.lookup_field])  # Devuelve un queryset tamaño 1
        if tienda_qs.exists():
            serializer = TiendaSerializer(tienda_qs, many=True)
            return Response(serializer.data, status.HTTP_200_OK)
        else:
            L.error(f'Tienda with nit {self.kwargs[self.lookup_field]} not found.')
            return Response({'detail':f'Tienda with nit {self.kwargs[self.lookup_field]} not found.'}, status.HTTP_404_NOT_FOUND)


# Crear Tienda
class TiendaCreateView(generics.CreateAPIView): # Crea una miscelanea
    serializer_class= TiendaSerializer
    #permission_classes = (IsAuthenticated,) #Solo los usuarios autenticados pueden acceder a este endpoint
    
    def post(self, request, *args, **kwargs):        
        serializer = TiendaSerializer(data=request.data)  # Datos enviados desde el frontend - type dict
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)            
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


#actualizar una tienda
class TiendaUpdateView(generics.RetrieveUpdateAPIView):
    queryset = Tienda.objects.all()
    serializer_class = TiendaSerializer
    #permission_classes = (IsAuthenticated,) #Solo los usuarios autenticados pueden acceder a este endpoint
    
    def update(self, request, *args, **kwargs):
        kwargs['partial'] = True
        return super().update(request, *args, **kwargs)


#eliminar una tienda
class TiendaDeleteView(generics.DestroyAPIView):
    queryset = Tienda.objects.all()
    lookup_field = 'pk'
    serializer_class = TiendaSerializer
    #permission_classes = (IsAuthenticated,) #Solo los usuarios autenticados pueden acceder a este endpoint
    
    def get(self, *args, **kwargs):
        # Devuelve un queryset tamaño 1
        tienda_qs = Tienda.objects.filter(pk=self.kwargs[self.lookup_field])
        if tienda_qs.exists():
            serializer = TiendaSerializer(tienda_qs, many=True)
            return Response(serializer.data, status.HTTP_200_OK)
        else:
            L.error(f'Tienda with nit {self.kwargs[self.lookup_field]} not found.')
            return Response({'detail': f'Tienda with nit {self.kwargs[self.lookup_field]} not found.'}, status.HTTP_404_NOT_FOUND)

    def delete(self, request, *args, **kwargs):
        return self.destroy(request, *args, **kwargs)
    