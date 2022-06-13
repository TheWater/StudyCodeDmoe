<template>

 <el-menu
  default-active="2"
  class="el-menu-vertical-demo"
  @open="handleOpen"
  @close="handleClose"
  background-color="#000"
  text-color="#fff"
  active-text-color="#a1c4fd"
  :default-active="this.$route.path">
    <h3>掌上商城后台管理系统</h3>
    <div class="block"><el-avatar :size="90" :src="circleUrl"></el-avatar>
    </div>
    <p style="text-align: center;font-size:12px;color:white">water003</p>
	  <el-menu-item :index="item.path" v-for="item in noChildren" :key="item.path">
	    <i :class="'el-icon-' + item.icon"></i>
	    <span slot="title">{{item.label}}</span>
	  </el-menu-item>	

	  <el-submenu :index=index.toString() v-for="(item,index) in hasChildren" :key="index">
		    <template slot="title">
		      <i :class="'el-icon-'+item.icon"></i>
		      <span>{{item.label}}</span> 
		     </template>
		    <el-menu-item-group>
		      <el-menu-item :index="subItem.path" v-for="(subItem,subIndex) in item.children" :key="subIndex">
            <i :class="'el-icon-'+subItem.icon"></i>
		        {{subItem.label}}
		      </el-menu-item>
	        </el-menu-item-group>
      </el-submenu>
</el-menu>


</template>


<style lang="less" scoped>
  .el-menu-vertical-demo:not(.el-menu-collapse){
    width: 200px;
    min-height: 600px;
    h3{
      color: white;
      text-align: center;
      line-height: 48px;
    }
    .block{
      margin-left:55px ;
    }
   }


</style>
<script>
  export default {
    data(){
      return{
        isCollapse:false,
        circleUrl: "https://s1.328888.xyz/2022/04/20/rjox2.jpg",
        asideMenu: [{
          path: '/', 
            label: '首页', 
            icon: 's-home', 
          },
          {
            path: "/user",
            label: '用户管理',
            icon: 'user'
          },
          {
            path: "/mall",
            label: '商品管理',
            icon: 'menu'
          },
          {
            path: "/order",
            label: '订单管理',
            icon: 's-data'
          },
          //二级菜单
          {
            label: '其他',
            icon: 'more',
            children: [{
                path: "/page1",
                label: '设置',
                icon: 'setting'
              },
              {
                path: "/page2",
                label: '联系我们',
                icon: 's-promotion'
              },
            ]
          },
        ]


      }
    },
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      clickMenu(item){
        this.$router.push({
          name:item.name
        }).catch(err => {})
      }
    },
 computed: {
		noChildren() {
		  return this.asideMenu.filter(item =>
		    !item.children
		  )
		},
		hasChildren() {
		  return this.asideMenu.filter(item =>
		    item.children
		  )
		}
}
  }
</script>
