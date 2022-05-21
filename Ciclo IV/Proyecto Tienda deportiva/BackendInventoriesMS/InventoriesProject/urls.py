"""InventoriesProject URL Configuration

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
from InventoriesApp import views



urlpatterns = [
    path('login/', TokenObtainPairView.as_view()),                              # Cada vez que una persona logue, retorna los tokens de acceso y refresh correspondientes -- Ready!
    path('refresh/', TokenRefreshView.as_view()),                               # Genera nuevo token de acceso
    path('inventario/', views.InventarioView.as_view()),                        # Retorna una lista de inventarios - check!
    path('inventario/<int:pk>', views.InventarioDetailView.as_view()),          # Retorna un Inventario específico - check!
    path('inventario/create', views.InventarioCreateView.as_view()),            # Crea un item de inventario - check!
    path('inventario/update/<int:pk>', views.InventarioUpdateView.as_view()),   # Actualiza un item de inventario - check!
    path('inventario/delete/<int:pk>', views.InventarioDeleteView.as_view()),   # Elimina un item de inventario - check!
    path('tienda/', views.TiendaView.as_view()),                                # Retorna las tiendas - check!
    path('tienda/<int:pk>', views.TiendaDetailView.as_view()),                  # Retorna una tienda - check!
    path('tienda/create', views.TiendaCreateView.as_view()),                    # Crea una tienda  - check!
    path('tienda/update/<int:pk>', views.TiendaUpdateView.as_view()),           # Actualiza una tienda - check!
    path('tienda/delete/<int:pk>', views.TiendaDeleteView.as_view()),           # Elimina una tienda - check!
    path('tallas/', views.TallaView.as_view()),                                 # Retorna las tallas - check!
    path('tallas/<int:pk>', views.TallaDetailView.as_view()),                   # Retorna una tallas - check!
    path('tallas/create', views.TallaCreateView.as_view()),                     # Crea una talla - check!
    path('tallas/update/<int:pk>', views.TallaUpdateView.as_view()),            # Actualiza una talla - check!
    path('tallas/delete/<pk>', views.TallaDeleteView.as_view()),                # Elimina una talla - check!
]
