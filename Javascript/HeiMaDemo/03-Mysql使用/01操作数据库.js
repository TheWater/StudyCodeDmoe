// 导入模块
const mysql = require('mysql')
// 与mysql建立连接关系
const db =mysql.createPool({

  host:'127.0.0.1',//地址
  user:'root',//用户名
  password:'010505',//密码
  database:'jslab'//数据库名

})

// 测试mysql模块能否正常规则
db.query('select 1',(err,results)=>{
  if(err) return console.log(err.message);
  console.log(results);
}) 

// 查询数据库
db.query('select * from user',(err,results)=>{
  if(err) return console.log(err.message);
  console.log(results);
}) 

// 插入书