<template>
<div id="app">
  <router-view></router-view>
</div>
</template>

<script>

export default {
  name: 'App'
}
</script>

<style lang="less" scoped>
html,body{
  margin: 0;
  padding: 0;
}
.el-header{
  background-color: #172254;
  color: white;
}
.el-main{
  background-color: rgb(87, 102, 197);
  padding-top: 0;
}
</style>
