import { createRouter, createWebHistory } from 'vue-router'
import App from './App.vue'
import Login from './components/Login.vue'
import SignUp from './components/SignUp.vue'
import Home from './components/Home.vue'
import Empleado from './components/Empleado.vue'
import Producto from './components/Producto.vue'

//Aqui se agregan los direccionamientos
const routes = [
  {
    path: '/',
    name: 'root',
    component: App
  },
  {
    path: '/empleado/login',
    name: 'logIn',
    component: Login
  },
  {
    path: '/empleado/signup',
    name: 'signUp',
    component: SignUp

  },
  {
    path: '/empleado/home',
    name: 'home',
    component: Home

  },
  {
    path: '/empleado/cuentaEmpleado',
    name: 'cuentaEmpleado',
    component: Empleado

  },
  {
    path: '/producto/detalleProductos/agregar',
    name: 'detalleProductos',
    component: Producto
  
  }

];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router