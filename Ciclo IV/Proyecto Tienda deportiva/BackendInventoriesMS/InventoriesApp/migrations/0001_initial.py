# Generated by Django 3.2.8 on 2021-11-30 09:19

import datetime
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Talla',
            fields=[
                ('id_talla', models.CharField(max_length=12, primary_key=True, serialize=False)),
                ('nombre_talla', models.CharField(max_length=45, verbose_name='nombre_talla')),
            ],
        ),
        migrations.CreateModel(
            name='Tienda',
            fields=[
                ('nit', models.IntegerField(primary_key=True, serialize=False)),
                ('nombre_tienda', models.CharField(max_length=45, verbose_name='nombre_tienda')),
                ('direccion_tienda', models.CharField(max_length=150, verbose_name='direccion_tienda')),
            ],
        ),
        migrations.CreateModel(
            name='Inventario',
            fields=[
                ('codigo_barras', models.BigAutoField(primary_key=True, serialize=False)),
                ('nombre_prod', models.CharField(max_length=45, verbose_name='nombre')),
                ('descripcion', models.TextField(max_length=1000, verbose_name='descripción')),
                ('cantidad', models.IntegerField(default=0, verbose_name='cantidad')),
                ('fecha_ingreso', models.DateField(blank=True, default=datetime.datetime.now, verbose_name='fecha_ingreso')),
                ('precio_compra', models.DecimalField(decimal_places=2, max_digits=10, verbose_name='precio_compra')),
                ('precio_venta', models.DecimalField(decimal_places=2, max_digits=10, verbose_name='precio_venta')),
                ('nit_tienda', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='tienda', to='InventoriesApp.tienda')),
                ('talla', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='talla', to='InventoriesApp.talla')),
            ],
        ),
    ]