<template>
  <div class="login">
    <h3>用户登录</h3>
    <el-form ref="loginRef" :model="loginForm" :rules="loginRules" label-width="50px">
      <el-form-item label="账号" prop="username">
        <el-input v-model="loginForm.username"/>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="loginForm.password"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" size="small" @click="login()">登录</el-button>
        <el-button type="success" size="small">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      loginForm: {
        username: 'admin',
        password: 'admin'
      },
      loginRules: {
        username: [{required: true, message: '请输入账号', trigger: 'blur'}],
        password: [{required: true, message: '请输入密码', trigger: 'blur'}],
      }
    }
  },
  methods: {
    login() {
     this.$refs.loginRef.validate(async v=>{
       // console.log(v)
       if(!v) return
       const {data:res}=await this.$http.post('/users/login',this.loginForm)
       // console.log(res)
       if(res.flag===false) return this.$message.error(res.msg)
       this.$message.success(res.msg)
       window.sessionStorage.setItem('token',res.token)
       await this.$router.push('/about')
     })
    }
  }
}
</script>

<style scoped>
.login {
  width: 300px;
  height: 240px;
  margin: 0 auto;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 0 2px rgba(0, 0, 0, 0.2);
  border: 1px solid #ccc
}
</style>