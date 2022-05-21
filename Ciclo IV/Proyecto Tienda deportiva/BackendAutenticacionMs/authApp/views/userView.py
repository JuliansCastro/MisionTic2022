from django.db.models import query
from rest_framework import status, views
from rest_framework import serializers
from rest_framework.response import Response
from rest_framework.serializers import Serializer
from rest_framework_simplejwt.serializers import TokenObtainPairSerializer
from authApp.models.user import User
from authApp.serializers.userSerializer import UserSerializer

class UserView (views.APIView):
 
    def get_object(self, pk):
        try:
            return User.objects.get(id=pk)
        except User.DoesNotExist:
            raise "Http404"

    def get(self, request, pk, format=None):
        usuario = self.get_object(pk)
        serializer = UserSerializer(usuario)
        return Response(serializer.data)

    def put(self, request, pk, format=None):
        usuario = self.get_object(pk)
        serializer = UserSerializer(usuario, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, pk, format=None):
        usuario = self.get_object(pk)
        usuario.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)