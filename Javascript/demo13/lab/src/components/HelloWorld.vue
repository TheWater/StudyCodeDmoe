<template>
  <div>
    <table border="1"  >
     <tr>
        <th></th>
        <th>书籍名称</th>
        <th>出版日期</th>
        <th>价格</th>
        <th>购买日期</th>
        <th>操作</th>
      </tr> 
        <tr v-for="item in books" :key="item.id">
        <td>{{item.id}}</td>
        <td>{{item.name}}</td>
        <td>{{item.date}}</td>
        <td>¥{{item.price}}</td>
        <td><button v-bind:disable="dis">-</button>{{item.count}}<button @click="add">+</button></td>
        <td><button v-on:click="del(item)">移除</button></td>
      </tr>
    </table>
    <h3>总价格：¥440.00</h3>
  </div>
</template>

<script>
export default {
  data(){
    return{
      dis:false,
      books: [
                   {
                       id: 1,
                       name: '《Effective Java中文版》',
                       date: '2021-12-11',
                       price: 30.00,
                       count: 1
                   },
                   {
                       id: 2,
                       name: '《Spring in Action》',
                       date: '2018-01-01',
                       price: 79.00,
                       count: 1
                   },
                   {
                       id: 3,
                       name: '《Spring揭秘》',
                       date: '2009-01-01',
                       price: 89.00,
                       count: 1
                   },
                   {
                       id: 4,
                       name: '《Spring实战（第3版》',
                       date: '2013-01-01',
                       price: 128.00,
                       count: 1
                   },
               ]
    }
  },
  methods:{

    del(e){
      this.books.splice(e,1)
    }
  }
}
</script>

<style>
 table{}
</style>