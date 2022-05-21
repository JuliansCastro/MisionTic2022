<template>
    <div class="home">
        <h1>Bienvenido {{ username }} </h1>
    </div>


</template>


<script>
    export default{
        name: "home",
        data: function(){
            return {
                username: localStorage.getItem("username") || "none"
            }
        }
    }
</script>

<!--
<style>
    .home {
        margin         : 0;
        padding        : 0%;
        height         : 100%;
        width          : 100%;
        display        : flex;
        justify-content: center;
        align-items    : center;
    }
    .home h1 {
        font-size: 50px;
        color    : #283747;
    }
</style>
-->