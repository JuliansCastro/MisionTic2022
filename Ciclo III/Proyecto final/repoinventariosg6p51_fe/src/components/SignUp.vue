<template>
  <div class="signUp_Empleado">
    <div class="container_signUp_Empleado">
      <h2>Registrarse</h2>
      <form v-on:submit.prevent="processSignUp">
        <input type="text" v-model="user.username" placeholder="Username" />
        <br />
        <input type="password" v-model="user.password" placeholder="Password" />
        <br />
        <input type="text" v-model="user.nombre" placeholder="nombre" />
        <br />
        <input type="text" v-model="user.apellido" placeholder="apellido" />
        <br />
        <input type="text" v-model="user.cedula" placeholder="cedula" />
        <br />
        <input type="email" v-model="user.email" placeholder="Email" />
        <br />
        <input type="number" v-model="user.miscelanea" placeholder="Nit Lugar de trabajo" />
        <br />
        <button type="submit">Registrarse</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "SignUp",
  data: function () {
    return {
      user: {
        username: "",
        nombre: "",
        apellido: "",
        cedula: "",
        email:"",
        password:"",
        create_time :(new Date()).toJSON().toString(), //No es recomendable, toma es la hora del equipo cliente
        miscelanea: 0,
      },
    };
  },
  methods: {
    processSignUp: function () { 
      axios.post(
          "https://misiontic-inventarios-g6p51-be.herokuapp.com/empleado/create/",
          //"https://mision-tic-bank-be.herokuapp.com/user/",

          this.user,
          {
            headers: {},
          }
        )
        .then((result) => {
          let dataSignUp = {
            username: this.user.username,
            token_access: result.data.access,
            token_refresh: result.data.refresh,
          };
          //console.log(dataSignUp)
          this.$emit("completedSignUp", dataSignUp);

        })
        .catch((error) => {
          console.log(error);
          alert("ERROR: Fallo en el registro.");
        });
    },
  },
};
</script>


<style>
.signUp_Empleado {
  margin: 0;
  padding: 0%;
  height: 100%;
  width: 100%;

  display: flex;
  justify-content: center;
  align-items: center;
}
.container_signUp_Empleado {
  border: 3px solid #283747;
  border-radius: 10px;
  width: 25%;
  height: 100%;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.signUp_Empleado input {
  height: 40px;
  width: 100%;
  box-sizing: border-box;
  padding: 10px 20px;
  margin: 5px 0;
  border: 1px solid #283747;
}
.signUp_Empleado button {
  width: 100%;
  height: 40px;
  color: #e5e7e9;
  background: #283747;
  border: 1px solid #e5e7e9;
  border-radius: 5px;
  padding: 10px 25px;
  margin: 5px 0 25px 0;
}
.signUp_Empleado button:hover {
  color: #e5e7e9;
  background: crimson;
  border: 1px solid #283747;
}
</style>


