<template>
  <el-container style="height:100%">
    <el-aside width="auto">
      <common-aside></common-aside>
    </el-aside>
    <el-container>
      <el-header>Header</el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
      <el-footer>hah</el-footer>
    </el-container>
  </el-container>
</template>

<script>
import CommonAside from '../components/CommonAside.vue'
export default {
  components:{
    CommonAside
  },
  data(){
    return{}
  }
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
