import Vue from 'vue'
import Router from 'vue-router'


Vue.use(Router)



export default new Router({
  routes: [
    {
      path: '/',
      name: 'Main',
      component: ()=> import('../view/Main.vue'),
      children:[
        {
          path: 'user',
          name: 'user',
          component: () => import('../view/user')
        },
        {
          path: 'mall',
          name: 'mall',
          component: () => import('../view/mall')
        },
        {
          path: 'order',
          name: 'order',
          component: () => import('../view/order')
        }
      ]
    },

  ]
})
