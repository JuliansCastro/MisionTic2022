from datetime import datetime
from django.db import models
from django.contrib.auth.models import AbstractBaseUser, PermissionsMixin, BaseUserManager
from django.contrib.auth.hashers import make_password
from .miscelanea import Miscelanea


class UserManager(BaseUserManager):
    def crear_empleado(self, username, password=None):

        if not username:
            raise ValueError('Los empleados deben tener un nombre de usuario')
        empleado = self.model(username=username)
        empleado.set_password(password)
        empleado.save(using=self._db)
        return empleado

    def crear_super_empleado(self, username, password):
        empleado = self.create_user(
            username=username,
            password=password,
        )
        empleado.is_admin = True
        empleado.save(using=self._db)
        return empleado


class Empleado(AbstractBaseUser, PermissionsMixin):
    id = models.BigAutoField(primary_key=True)
    username = models.CharField('username', max_length=16, unique=True)
    nombre = models.CharField('nombre', max_length=45)
    apellido = models.CharField('apellido', max_length=45)
    cedula = models.CharField('cedula', unique=True, max_length=20)
    email = models.EmailField('email', max_length=45, unique=True)
    password = models.CharField('password', max_length=256)
    create_time = models.DateTimeField('dateTime', default=datetime.now, blank=True)
    miscelanea = models.ForeignKey(Miscelanea, related_name='lugar_trabajo', on_delete=models.CASCADE)

    def save(self, **Kwargs):
        some_salt = 'mMUj0DrIK6vgtdIYepkIxN'
        self.password = make_password(self.password, some_salt)
        super().save(**Kwargs)

    objects = UserManager()
    USERNAME_FIELD = 'username'
