
<template>
  <div>
    <div class="information" v-if="loaded">
      <h1>Información de empleado</h1>
      <h2>
        Nombre: <span>{{ nombre }}</span>
      </h2>
      <h2>
        Apellido: <span>{{ apellido }}</span>
      </h2>
      <h2>
        Cedula: <span>{{ cedula }}</span>
      </h2>
      <h2>
        Email: <span>{{ email }}</span>
      </h2>
      <h2>
        Lugar de trabajo: <span>{{ nombre_misc }}</span>
      </h2>
      <h2>
        Direccion: <span>{{ direccion_misc }}</span>
      </h2>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import jwt_decode from "jwt-decode";
export default {
  name: "cuentaEmpleado",
  data: function () {
    return {
      loaded: false,
      nombre: "",
      apellido: "",
      cedula: "",
      email: "",
      nombre_misc: "",
      direccion_misc: "",
    };
  },

  methods: {
    getData: async function () {
      if (
        localStorage.getItem("token_access") === null ||localStorage.getItem("token_refresh") === null
      ) {
        //valida si esta logueado
       
        this.$emit("logOut");
        return;
      }
      await this.verifyToken(); //si esta logueado, crea token de acceso por si esta expirado
      let token = localStorage.getItem("token_access");
      let userId = jwt_decode(token).user_id.toString(); //decodifica el token de acceso y saca el userID
      axios
        .get(
          `https://misiontic-inventarios-g6p51-be.herokuapp.com/empleado/${userId}/`,
          { headers: { Authorization: `Bearer ${token}` } } //indica que el token es de tipo Bearer
        )
        .then((result) => {
          //trae la informacion del empleado
          this.loaded = true;
          this.nombre = result.data.nombre;
          this.apellido = result.data.apellido;
          this.cedula = result.data.cedula;
          this.email = result.data.email;
          this.nombre_misc = result.data.miscelanea.nombre_misc;
          this.direccion_misc = result.data.miscelanea.direccion_misc;
        })
        .catch((error) => {
            
          this.$emit("logOut");
        });
    },
    verifyToken: async function () {
      return axios
        .post(
          "https://misiontic-inventarios-g6p51-be.herokuapp.com/refresh/",
          { refresh: localStorage.getItem("token_refresh") },
          { headers: {} }
        )
        .then((result) => {
          localStorage.setItem("token_access", result.data.access);
        })
        .catch((error) => {
            console.log("error generando token")
          this.$emit("logOut");
        });
    },
  },
  //Aqui apenas cargue la pagina, carga la data
  created: async function () {
    this.getData();
  },
};
</script>
<!--
<style>
.information {
  margin: 0;
  padding: 0%;
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.information h1 {
  font-size: 60px;
  color: #0f1316;
}
.information h2 {
  font-size: 40px;
  color: #283747;
}
.information span {
  color: crimson;
  font-weight: bold;
}
</style>
-->
