const http=require('http')
const queryString=require('querystring')
let users={}
let server=http.createServer((req,res)=>{
  res.setHeader('Access-Control-Allow-Drigin','*')
  let setData='',i=0
  req.on('data',(data)=>{
    let POST=queryString.parse(postData)
    console.log(Post.act)
    switch(POST.act){
    case 'reg':
      console.log(1)
      if(users[POST.username]){
        console.log(2)
        res.write('{"flag":false,"msg":"已经存在同名用户"}')
      }else{
        console.log(3)
        users[POST.username]=POST.password
        console.log(users);
        res.write('{"flag":true,"msg":"注册成功"}')
      }
      break
      case 'login':
        if(users[POST.username]==null){
          res.write('{"flag":false,"msg":"用户不存在"}')
        }else if(users[POST.username]!=POST.password){
          res.write('{"flag":false,"msg":"密码错误"}')
        }else{
          res.write('{"flag":true,"msg":"登陆成功"}')
        }
        break
    }
    res.end()
  })
})