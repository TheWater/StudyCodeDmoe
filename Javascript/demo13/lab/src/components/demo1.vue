<template>
  <div class="hello">
    <div>购买数量</div>
    <div class="icon" @click="num--" disable="false">-</div>
    <input type="text" v-model="num">
    <div class="icon" @click="num++">+</div>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data(){
    return{
      num:1
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hello{
  display: flex;
  flex-direction: row;
}
span{
  width: 400px;
}
input{
  text-align: center;
}
.icon{
  width: 20px;
  background-color: antiquewhite;
  margin: 0 3px ;
}
</style>
