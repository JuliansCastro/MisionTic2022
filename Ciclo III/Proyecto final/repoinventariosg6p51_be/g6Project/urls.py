"""g6Project URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/3.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path
from rest_framework_simplejwt.views import (TokenObtainPairView, TokenRefreshView) 
from g6App import views


urlpatterns = [
    path('login/', TokenObtainPairView.as_view()),                          # Cada vez que una persona logue, retorna los tokens de acceso y refresh correspondientes -- Ready!
    path('refresh/', TokenRefreshView.as_view()),                           # Genera nuevo token de acceso -- Ready!
    path('empleado/create/',   views.EmpleadoCreateView.as_view()),          # Crea un empleado - Ready!
    path('empleado/<int:pk>/', views.EmpleadoDetailView.as_view()),          #Retorna un empleado y la miscelanea en la que trabajan - Ready!
    path('miscelanea/', views.MiscelaneaView.as_view()),                    # Retorna una lista de miscelaneas - Ready!
    path('miscelanea/create/', views.MiscelaneaCreateView.as_view(), name="crear_miscelanea"), # Crea una miscelanea - Ready!
    path('productos/', views.ProductoDetailView.as_view()),                 # Retorna una lista de productos - Ready!
    path('productos/create/', views.ProductoCreateView.as_view()),           # Crea un producto - Ready!
    path('productos/producto/<int:pk>/', views.ProductoView.as_view()),     # Retorna un solo  producto - Ready!
    path('productos/update/<int:pk>/', views.ProductoUpdateView.as_view()), # Actualiza un producto - Ready!
    path('productos/delete/<int:pk>/', views.ProductoDeleteView.as_view()), # Elimina un producto - Ready!
    path('inventario/', views.InventarioView.as_view()),                    # Retorna una lista de inventarios - Ready!
    #path('inventario/create', views.InventarioCreateView.as_view()),        # Crea un inventario - Ready!
]

