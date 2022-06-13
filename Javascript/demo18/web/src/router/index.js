import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Login from '../views/Login'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path:'/login',
    name:'login',
    component: Login
  },
  {
    path: '/home',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue'),
    children:[
      {
        path:'first',
        component:() => import(/* webpackChunkName: "Frist" */ '../views/First.vue')
      },
      {
        path:'second',
        component:() => import(/* webpackChunkName: "Frist" */ '../views/second.vue')
      },
      {
        path:'third',
        component:() => import(/* webpackChunkName: "Frist" */ '../views/Third.vue')
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

router.beforeEach((to,from,next)=>{
  if(to.path==='/login') return next()
  let tokenStr=window.sessionStorage.getItem('token')
  if(!tokenStr)  return  next('/login')
  next()
})



export default router
