from rest_framework import generics, status
from rest_framework import serializers
from rest_framework.response import Response
from rest_framework.permissions import IsAuthenticated, AllowAny
from rest_framework.serializers import Serializer
from g6App.models import Inventario
from g6App.serializers import InventarioSerializer

#Lista todos los inventarios
class InventarioView(generics.ListAPIView):
    queryset = Inventario.objects.all()
    serializer_class = InventarioSerializer
    #permission_classes = (IsAuthenticated,)  # Solo los usuarios autenticados pueden acceder a este endpoint

    def get(self, request, *args, **kwargs):
        # many=True para que devuelva una lista
        serializer = InventarioSerializer(self.get_queryset(), many=True)
        return Response(serializer.data)


""" class InventarioCreateView(generics.CreateAPIView):
    serializer_class = InventarioSerializer
    #permission_classes = (IsAuthenticated,) #Solo los usuarios autenticados pueden acceder a este endpoint

    def post(self, request, *args, **kwargs):
        if request.method == 'POST':
            serializer = InventarioSerializer(data=request.data)
            if serializer.is_valid():
                serializer.save()
                return Response(serializer.data, status=status.HTTP_201_CREATED)
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
        #return Response(data=None, status=status.HTTP_405_METHOD_NOT_ALLOWED) """
