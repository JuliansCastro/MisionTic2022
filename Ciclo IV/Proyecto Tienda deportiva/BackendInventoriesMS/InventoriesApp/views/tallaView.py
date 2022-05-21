from rest_framework import generics, status
from rest_framework.response import Response
from rest_framework.permissions import IsAuthenticated
from InventoriesApp.models import Talla
from InventoriesApp.serializers import TallaSerializer
import logging as L

# Obtener Talla
class TallaView(generics.ListAPIView):  # Lista todas las tallas
    queryset = Talla.objects.all()
    serializer_class = TallaSerializer
    #permission_classes = (IsAuthenticated,) #Solo los usuarios autenticados pueden acceder a este endpoint

    def get(self, request, *args, **kwargs):
        queryset = self.get_queryset()
        serializer = TallaSerializer(queryset, many=True)
        return Response(serializer.data)


#listar una tienda existente
class TallaDetailView(generics.RetrieveAPIView):
    queryset = Talla.objects.all()
    lookup_field = 'pk'
    serializer_class = TallaSerializer
    #permission_classes = (IsAuthenticated,) #Solo los usuarios autenticados pueden acceder a este endpoint

    def get(self, *args, **kwargs):
        talla_qs = Talla.objects.filter(pk=self.kwargs[self.lookup_field])  # Devuelve un queryset tamaño 1
        if talla_qs.exists():
            serializer = TallaSerializer(talla_qs, many=True)
            return Response(serializer.data, status.HTTP_200_OK)
        else:
            L.error(
                f'Talla with id {self.kwargs[self.lookup_field]} not found.')
            return Response({'detail': f'Talla with nit {self.kwargs[self.lookup_field]} not found.'}, status.HTTP_404_NOT_FOUND)


# Crear Talla
class TallaCreateView(generics.CreateAPIView):  # Crea una miscelanea
    serializer_class = TallaSerializer
    #permission_classes = (IsAuthenticated,) #Solo los usuarios autenticados pueden acceder a este endpoint

    def post(self, request, *args, **kwargs):
        serializer = TallaSerializer(data=request.data)  # Datos enviados desde el frontend - type dict
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


#actualizar una talla
class TallaUpdateView(generics.RetrieveUpdateAPIView):
    queryset = Talla.objects.all()
    serializer_class = TallaSerializer
    #permission_classes = (IsAuthenticated,) #Solo los usuarios autenticados pueden acceder a este endpoint

    def update(self, request, *args, **kwargs):
        kwargs['partial'] = True
        return super().update(request, *args, **kwargs)


#eliminar una talla
class TallaDeleteView(generics.DestroyAPIView):
    queryset = Talla.objects.all()
    lookup_field = 'pk'
    serializer_class = TallaSerializer
    #permission_classes = (IsAuthenticated,) #Solo los usuarios autenticados pueden acceder a este endpoint

    def get(self, *args, **kwargs):
        # Devuelve un queryset tamaño 1
        talla_qs = Talla.objects.filter(pk=self.kwargs[self.lookup_field])
        if talla_qs.exists():
            serializer = TallaSerializer(talla_qs, many=True)
            return Response(serializer.data, status.HTTP_200_OK)
        else:
            L.error(
                f'Talla with id {self.kwargs[self.lookup_field]} not found.')
            return Response({'detail': f'Talla with id {self.kwargs[self.lookup_field]} not found.'}, status.HTTP_404_NOT_FOUND)

    def delete(self, request, *args, **kwargs):
        return self.destroy(request, *args, **kwargs)
