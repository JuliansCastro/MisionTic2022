<template>
  <div id="app" class="app">
    <div class="header">
      <h1>Sistema de Inventarios</h1>
      <nav>
        <button v-if="is_auth" v-on:click = "loadHome">Inicio</button>
        <button v-if="is_auth"  v-on:click = "loadDetalleProductos">Productos</button>
        <button v-if="is_auth" v-on:click = "loadCuentaEmpleado">Cuenta</button>
        <button v-if="is_auth"  v-on:click = "logOut">Cerrar Sesión</button>

        <button v-if="!is_auth" v-on:click="loadLogIn">Iniciar Sesión</button>
        <button v-if="!is_auth" v-on:click="loadSignUp">Registrarse</button>
      </nav>
    </div>

    <div class="main-component">
      <router-view
        v-on:completedLogIn="completedLogIn"
        v-on:completedSignUp="completedSignUp"
        v-on:logOut="logOut"
        v-on:completedAddProduct="completedAddProduct"
      >
      </router-view>
    </div>

    <div class="footer">
      <h2>Misión TIC 2022</h2>
    </div>
  </div>
</template>

<script>
  export default {
  //lo que cargara por defecto
  name: "App",
  data: function () { 
    return {
      is_auth: false,
    };
  },

  components: {

  },

  methods: {
    //Aqui va las funciones javascript; como metods es un objeto, se separa por comas las funciones
    verifyAuth: function() { //valida si el usuario esta autenticado
    this.is_auth = localStorage.getItem("is_auth") || false;
    if(this.is_auth == false){
        this.$router.push({name: "logIn"});
    }else{
        this.$router.push({name: "home"});
      }
    },
    loadLogIn: function () { //pagina de inicio sesion
      this.$router.push({name: "logIn"})
    },
    loadSignUp: function () { //pagina de registro
      this.$router.push({name: "signUp"})
    },
    loadHome: function () { //pagina de inicio
      this.$router.push({name: "home"})
    },
    logOut: function(){ //cierre de sesion
      localStorage.clear();
      alert("Sesion terminada");
      this.verifyAuth();
    },
    loadCuentaEmpleado: function(){ //carga cuenta Empleado
      this.$router.push({name: "cuentaEmpleado"})
    },
    loadDetalleProductos: function(){ //carga lista Productos
      this.$router.push({name: "detalleProductos"})

    },


    completedLogIn: function (data) {
      localStorage.setItem("is_auth",true);
      localStorage.setItem("username",data.username);
      localStorage.setItem("token_access",data.token_access);
      localStorage.setItem("token_refresh",data.token_refresh);
      //console.log(localStorage.getItem("username"));
      alert("Login Exitoso")

      this.verifyAuth(); //Aqui se colocan las rutas a las que se redirige la pagina
    },
    completedSignUp: function (data) {
      alert("Registro Exitoso")
      this.completedLogIn(data); //Con la info de registro, llama al login y se loguea
    },
  },

  created: function () { //funciones que se cargan apenas se inicia la app
    this.verifyAuth() //Si no esta autorizdo, se carga el verifyAuth
  },
};
</script>

<style>
body {
  margin: 0 0 0 0;
}
.header {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 10vh;
  min-height: 100px;

  background-color: #283747;
  color: #e5e7e9;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.header h1 {
  width: 70%;
  text-align: center;
}

.header nav {
  height:100%;
  width: 25%;

  display: flex;
  justify-content: space-around;
  align-items: center;

  font-size: 20px;
}

.header nav button {
  color: #e5e7e9;
  background: #283747;
  border: 1px solid #e5e7e9;

  border-radius: 5px;
  padding: 10px 20px;
}

.header nav button:hover{
  color: #283747;
  background: #e5e7e9;
  border: 1px solid #e5e7e9;
}
.main-component{
  height: 75vh;
  margin: 0%;
  padding: 0%;

  background: #FDFEFE;
}

.footer{
  margin:0;
  padding: 0%;
  width: 100%;
  height: 10vh;
  min-height: 100px;

  background-color: #283747;
  color: #e5e7e9;
}

.footer h2{
  width: 100%;
  height: 100;

  display: flex;
  justify-content: center;
  align-items: center;
}

</style>
