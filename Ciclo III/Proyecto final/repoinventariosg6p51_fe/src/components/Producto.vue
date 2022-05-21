<template>
  <div class="row">
    <div class="col m12">
      <h1>
        Lista de productos
        <button class="btn btn-primary">Añadir Producto</button>
      </h1>
      <table class="Table bordered striped">
        <thead>
          <tr>
            <th>id</th>
            <th>Nombre</th>
            <th>descripcion</th>
            <th>Editar</th>
            <th>eliminar</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="producto in productos" v-bind:key="producto">
            <td>{{ producto.id }}</td>
            <td>{{ producto.nombre_prod }}</td>
            <td>{{ producto.descripcion }}</td>
            <td>

              <button class="btn btn-info" v-on:click="getProduct(producto.id)">Editar</button>

              
            </td>
            <td>
              <button class="btn btn-danger" v-on:click="deleteProduct(producto.id)"> Eliminar </button>
            </td>
          </tr>
        </tbody>
      </table>

      <!--MENU, AÑADIR PRODUCTO-->
      <div class="añadir_Producto">
        <div class="container_Añadir_Producto">
          <h2>Añadir Producto</h2>
          <button
            type="button"
            class="close"
            data-dismiss="modal"
            aria-label="Close"
          >
            cerrar
          </button>
          <form v-on:submit.prevent="addProduct()">
            <input
              type="text"
              v-model="producto.nombre_prod"
              placeholder="nombre"
            />
            <br />
            <input
              type="text"
              v-model="producto.descripcion"
              placeholder="descripcion"
            />
            <br />
            <button type="submit">añadirProducto</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import jwt_decode from "jwt-decode";



export default {
  name: "detalleProductos",
  data: function () {
    return {
      productos: [],
      producto: {
        nombre_prod: "",
        descripcion: "",
      },

    };
  },

  methods: {
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
          this.$emit("logOut");
        });
    },
    getProductList: async function () {
      if (
        localStorage.getItem("token_refresh") === null ||
        localStorage.getItem("token_access") === null
      ) {
        this.$emit("logOut");
        return;
      }
      await this.verifyToken();

      let token = localStorage.getItem("token_access");
      let userId = jwt_decode(token).user_id.toString();

      axios
        .get(`https://misiontic-inventarios-g6p51-be.herokuapp.com/productos/`, {
          headers: { Authorization: `Bearer ${token}` },
        })
        .then((result) => {
          this.productos = result.data;
        })
        .catch((error) => {
          console.log(error);
          if (error.response.status == "401") {
            alert("Usted no está autorizado para realizar esta operación.");
          } else if (error.response.status == "500") {
            alert(
              "La plataforma está presentando problemas.\nIntente de nuevo más tarde."
            );
          }
        });
    },

    addProduct: async function () {
      if (
        localStorage.getItem("token_access") === null ||
        localStorage.getItem("token_refresh") === null
      ) {
        //valida si esta logueado
        this.$emit("logOut");
        return;
      }
      await this.verifyToken();
      let token = localStorage.getItem("token_access");
      axios
        .post(
          "https://misiontic-inventarios-g6p51-be.herokuapp.com/productos/create/",this.producto,
          //"https://mision-tic-bank-be.herokuapp.com/user/",
          {
            headers: { 'Authorization': `Bearer ${token}` },
          }
        )
        .then((result) => {
          this.$emit("completedAddProduct")
          alert("productoCreado")
          this.getProductList();
        })
        .catch((error) => {
          console.log(error);
          alert("ERROR: Fallo en el registro.");
        });
    },

    getProduct: async function (product_id){
        if (localStorage.getItem("token_access")===null || localStorage.getItem("token_refresh")===null){
            this.$emit("logOut");
            return;
        }
        await this.verifyToken();
        //let userId = jwt_decode(token).user_id.toString();
        let token = localStorage.getItem("token_access");
        axios.get(`https://misiontic-inventarios-g6p51-be.herokuapp.com/productos/producto/${product_id}/`,
        { headers: { Authorization: `Bearer ${token}` } } //indica que el token es de tipo Bearer
          )
        .then((result) => {
            this.productoActual = result.data;
            console.log(result.data.nombre_prod);
        })
          .catch((error) => {

            this.$emit("logOut");
          });
      },


  /*
    updateProduct: async function (){
        if (localStorage.get("token_refresh")===null || localStorage.getItem(token_access)===null){
            this.$emit("logOut");
            return;
        }
        await this.verifyToken();        
        let token = localStorage.getItem("token_access");
      axios
        .put(
          `http://127.0.0.1:8000/productos/update/${this.productoActual.id}/`,
          this.productoActual,
          { headers: { Authorization: `Bearer ${token}` }, } //indica que el token es de tipo Bearer
        ).then((result) => {
          this.productoActual = result.data;
          this.getProductList();
        })
        .catch((error) => {
          this.$emit("logOut");
        });
        
    },
    deleteProduct: async function (product_id){
        if (localStorage.get("token_refresh")===null || localStorage.getItem(token_access)===null){
            this.$emit("logOut");
            return;
        }
        await this.verifyToken();        
        let token = localStorage.getItem("token_access");
      axios
        .put(
          `http://127.0.0.1:8000/productos/delete/${this.product_id}/`,
          { headers: { Authorization: `Bearer ${token}` }, } //indica que el token es de tipo Bearer
        ).then((result) => {
            alert("Registro eliminado")          
            this.getProductList();
        })
        .catch((error) => {
          this.$emit("logOut");
        });

    },
*/
  },
  created: async function () {
    this.getProductList();
    //this.getMyAccountsList();
  },
};
</script>