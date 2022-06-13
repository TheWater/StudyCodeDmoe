<template>
  <div id="app">
    <!-- 头部导航栏 -->
    <div id="head">
      <ul>
        <li><button @click="show">已注册</button></li>
        <li><button @click="hide">未注册</button></li>
        <li v-if="flag"><a href="">登录</a></li>
        <li v-if="!flag"><a href="">注册</a></li>
      </ul>
    </div>
    <div id="boder">
      <span class="title">购物车</span>
      <!-- 内容 -->
      <div id="body">
        <div id="body_h">
          <span>
          <button @click="run">嗨起来</button>
          <button @click="stop">剁手</button>
          {{msg}}
        </span>
        </div>

        <div id="tab">
          <table cellpadding="10">
            <tr id="td1">
              <th>序号</th>
              <th>商品</th>
              <th>价格（RMB）</th>
              <th>数量</th>
              <th>总价（RMB）</th>
            </tr>
            <tr>
              <td>1</td>
              <td>足金闪光氪金钻石剁手刀</td>
              <td>{{single}}</td>
              <td>
                <button @click="seb()">-</button>
                <input v-model="price" style="width:15px">
                <button @click="add()">+</button>
              </td>
              <td>{{single*price}}</td>
            </tr>
          </table>
          <p>计算属性{{totle}}</p>
          <!-- <p>函数方法调用{{f()}}</p> -->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name:'Document',
  data(){
    return{
      info:['o','b','c'],
      flag:true,
      msg:"请在20分钟内结算支付，否则会被别人抢走哦！",
      intervalId: null, // 在data上定义 定时器Id
      price:2,
      single:9999.0
    }
  },
  computed:{
    //计算属性
    totle:function(){
      return this.price*this.num;
    }
  },
  watch:{
    deep:true,
    price(newer,order){
      if(this.price<0){
        this.price=order;
        alert("不可以小于0！");
      }else if(this.price>10){
        this.price=order;
        alert("不可以大于10！");
      }else{
        this.price=newer;
      }
      console.log(newer);
      console.log(order);
    },

  },
  methods:{
    show(){
      this.flag=true;
    },
    hide(){
      this.flag=false;
    },
    run(){
      // 获取到头的第一个字符
      // this
      if (this.intervalId != null) return;
      this.intervalId = setInterval(() => {
        var start = this.msg.substring(0, 1)
        // 获取到 后面的所有字符
        var end = this.msg.substring(1)
        // 重新拼接得到新的字符串，并赋值给 this.msg
        this.msg = end + start
      }, 400)
// 注意： VM实例，会监听自己身上 data 中所有数据的改变，只要数据一发生变化，就会自动把 最新的数据，从data 上同步到页面中去；【好处：程序员只需要关心数据，不需要考虑如何重新渲染DOM页面】
    },
    stop(){
    // 停止定时器
      clearInterval(this.intervalId)
      // 每当清除了定时器之后，需要重新把 intervalId 置为 null
      this.intervalId = null;
    },
    add(){
      this.price++;
    },
    seb(){
      this.price--;
    }
  }
}
</script>

<style scoped>
  #boder{
    border: 2px black;
    width:590px;
    height:150px;
    padding:10px 30px;
    margin:0 auto;
    border:2px solid #000000;
  } 
  .title{
    display:block;
    width:80px;
    height:20px;
    position:relative;
    top:-16px;
    text-align: center;
    background: white;
  }
  #app{
    display: block;
    width: 575px;
    margin: 0 auto;
  }
  #head{
    background-color: rgb(214, 214, 214);
    width: 650px;
    height: 60px;
    padding: 1px;
    margin: 5px;
  }
  li{
    float:right;
    list-style-type: none;
    
  }
  li a{
    display: block;
    padding: 7px 8px;
    text-decoration: none;
  }
  li button{
    display: block;
    padding: 7px 8px;
    margin: 0 5px;
    text-decoration: none;
    border: 2px;
  }
  #body{

    
  }
  #body_h{
    display: flex;
    align-items:center; 
  }
  #body_h button{
    margin: 0 8px;
    padding: 7px 8px;
  }
  #tab{
    width: 100%;
    
  }
  table{
    margin: 0 auto;
    
  }
  #td1{
    background-color: rgb(214, 214, 214);
  }
</style>
