// 导入依赖
const express=require('express')
const app=express()


// 中间件 POST请求数据
app.use(express.urlencoded({extended:false}))

//监听
app.listen(3000)
// 请求
let users={'admin':'123'}


app.use('/',(req,res,next)=>{
  res.setHeader('Access-Control-Allow-Origin','*')
  next()
})

app.get('/reg',(req,res)=>{
  // console.log(req.query)
  let {username,password}=req.query // req.query GET 请求数据
  console.log(req.query);
  if(users[username]){
    res.send({flag:false,msg:'账号已经存在'})
  }else{
    users[username]=password
    res.send({flag:true,msg:'注册成功'})
  }

  res.end()
},

app.post('/login',(req,res)=>{
  console.log(req.body); // req.body POST 请求数据

  let{username,password}=req.body
  if(users[username]==null){
    res.send({flag:false,msg:'该账号不存在'})
  }else if(users[username]!=password){
    res.send({flag:false,msg:'密码错误'})
  }else{
    res.send({flag:true,msg:'登录成功'})
  }
})


) 