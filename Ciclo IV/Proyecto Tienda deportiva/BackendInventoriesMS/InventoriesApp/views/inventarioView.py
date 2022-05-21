from rest_framework import generics, status
from rest_framework.response import Response
from rest_framework.permissions import IsAuthenticated
from InventoriesApp.models import Inventario
from InventoriesApp.serializers import InventarioSerializer
import logging as L

#Lista todos los inventarios
class InventarioView(generics.ListAPIView):
    queryset = Inventario.objects.all()
    serializer_class = InventarioSerializer
    #permission_classes = (IsAuthenticated,)  # Solo los usuarios autenticados pueden acceder a este endpoint

    def get(self, request, *args, **kwargs):
        serializer = InventarioSerializer(self.get_queryset(), many=True)  # many=True para que devuelva una lista
        return Response(serializer.data)

#listar una Inventario específico
class InventarioDetailView(generics.RetrieveAPIView):
    queryset = Inventario.objects.all()
    lookup_field = 'pk'
    serializer_class = InventarioSerializer
    #permission_classes = (IsAuthenticated,)  # Solo los usuarios autenticados pueden acceder a este endpoint

    def get(self, *args, **kwargs):
        # Devuelve un queryset tamaño 1
        tienda_qs = Inventario.objects.filter(pk=self.kwargs[self.lookup_field])
        if tienda_qs.exists():
            serializer = InventarioSerializer(tienda_qs, many=True)
            return Response(serializer.data, status.HTTP_200_OK)
        else:
            L.error(
                f'Inventario with codigo_barras {self.kwargs[self.lookup_field]} not found.')
            return Response({'detail': f'Inventario with codigo_barras {self.kwargs[self.lookup_field]} not found.'}, status.HTTP_404_NOT_FOUND)




# Crear item inventario
class InventarioCreateView(generics.CreateAPIView):
    serializer_class = InventarioSerializer
    #permission_classes = (IsAuthenticated,) #Solo los usuarios autenticados pueden acceder a este endpoint

    def post(self, request, *args, **kwargs):
        serializer = InventarioSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
        


#actualizar un item de inventario
class InventarioUpdateView(generics.RetrieveUpdateAPIView):
    queryset = Inventario.objects.all()
    serializer_class = InventarioSerializer
    #permission_classes = (IsAuthenticated,) #Solo los usuarios autenticados pueden acceder a este endpoint
    
    def update(self, request, *args, **kwargs):
            instanceInventario = self.get_object()
            serializer = InventarioSerializer(data=request.data)
            if serializer.is_valid():
                inventarioUpdated = serializer.update(instanceInventario, serializer.validated_data)
                serializer = InventarioSerializer(inventarioUpdated)
                return Response(serializer.data, status=status.HTTP_200_OK)
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

#eliminar un Inventario
class InventarioDeleteView(generics.DestroyAPIView):
    queryset = Inventario.objects.all()
    lookup_field = 'pk'
    serializer_class = InventarioSerializer
    #permission_classes = (IsAuthenticated,)  # Solo los usuarios autenticados pueden acceder a este endpoint

    def get(self, *args, **kwargs):
        # Devuelve un queryset tamaño 1
        inventario_qs = Inventario.objects.filter(pk=self.kwargs[self.lookup_field])
        if inventario_qs.exists():
            serializer = InventarioSerializer(inventario_qs, many=True)
            return Response(serializer.data, status.HTTP_200_OK)
        else:
            L.error(f'Inventario with codigo_barras {self.kwargs[self.lookup_field]} not found.')
            return Response({'detail': f'Inventario with codigo_barras {self.kwargs[self.lookup_field]} not found.'}, status.HTTP_404_NOT_FOUND)

    def delete(self, request, *args, **kwargs):
        return self.destroy(request, *args, **kwargs)