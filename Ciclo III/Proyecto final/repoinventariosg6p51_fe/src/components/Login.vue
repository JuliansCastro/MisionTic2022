<template>
  <div class="loginEmployee">
    <div class="container_LoginEmployee">
      <h2>Iniciar sesión</h2>

      <form v-on:submit.prevent="processLoginEmployee">
        <input type="text" v-model="user.username" placeholder="Username" />
        <br />
        <input type="password" v-model="user.password" placeholder="Password" />
        <br />
        <button type="submit">Iniciar Sesion</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Login",
  data: function () {
    return {
      user: {
        username: "",
        password: "",
      },
    };
  },
  methods: {
    processLoginEmployee: function () {
      axios
        .post(
          "https://misiontic-inventarios-g6p51-be.herokuapp.com/login/",
          //"https://mision-tic-bank-be.herokuapp.com/login/",
          this.user,
          { headers: {} }
        )
        .then((result) => {
          let dataLogIn = {
            username: this.user.username,
            token_access: result.data.access,
            token_refresh: result.data.refresh,
          };
          console.log(dataLogIn),
          this.$emit("completedLogIn", dataLogIn); //El emit le envia la info al padre (clase app)
        })
        .catch((error) => {
          if (error.response.status == "401")
            alert("ERROR 401: Credenciales Incorrectas.");
        });
    },
  },
};
</script>

<style>
.loginEmployee {
  margin: 0;
  padding: 0%;
  height: 100%;
  width: 100%;

  display: flex;
  justify-content: center;
  align-items: center;
}
.container_LoginEmployee {
  border: 3px solid #283747;
  border-radius: 10px;
  width: 25%;
  height: 60%;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.loginEmployee h2 {
  color: #283747;
}

.loginEmployee form {
  width: 70%;
}
.loginEmployee input {
  height: 40px;
  width: 100%;
  box-sizing: border-box;
  padding: 10px 20px;
  margin: 5px 0;
  border: 1px solid #283747;
}
.loginEmployee button {
  width: 100%;
  height: 40px;
  color: #e5e7e9;
  background: #283747;
  border: 1px solid #e5e7e9;
  border-radius: 5px;
  padding: 10px 25px;
  margin: 5px 0;
}
.loginEmployee button:hover {
  color: #e5e7e9;
  background: crimson;
  border: 1px solid #283747;
}
</style>
