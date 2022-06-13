import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import installElementPlus from './plugins/element'

import axios from "axios";
axios.defaults.baseURL='http://127.0.0.1:3000' //    http://127.0.0.1:3000 /users/login

axios.interceptors.request.use(config=>{
    config.headers.Authorization=window.sessionStorage.getItem('token')
    // console.log(config)
    return config
})


const app = createApp(App)
app.config.globalProperties.$http=axios   // prototype

installElementPlus(app)
app.use(router).mount('#app')