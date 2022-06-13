var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
var app = express();

const config=require('./utils/config')
const {expressjwt}=require('express-jwt')
const jwt=require('jsonwebtoken')
// 定义一个secret密钥。建议将密钥命名为secreKey
app.use( expressjwt({secret:config.secretKey,algorithms:['HS256']}).unless({path:['/users/login']})  )

app.use(expressjwt({secret:config.secretKey,algorithms:['HS256']}).unless({path:['/users/login','','',]}))

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');


app.all('*', function(req, res, next) {
  res.header('Access-Control-Allow-Origin', '*')
  res.header('Access-Control-Allow-Headers', 'Content-Type,Content-Length, Authorization, Accept,X-Requested-With')
  res.header('Access-Control-Allow-Methods', 'PUT,POST,GET,DELETE,OPTIONS')
  next()
})

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);
app.use('/users', usersRouter);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  if(err.name==='UnauthorizedError') return res.send({flag:false,msg:'认证失败'})

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

//解析token获取用户信息
app.use(function(req, res, next) {
  //注意此处token；authorization设置要与设置一致否则可能出现token为空
   var token = req.headers['authorization'];  
   if(token == undefined){
       return next();
   }else{
       vertoken.getToken(token).then((data)=> {
           req.data = data;             //解析成功后返回设置基本信息（通过req.data判断是否过期）
           return next();
       }).catch((error)=>{
           return next();
       })
   }
});

//验证token是否过期并规定那些路由不需要验证
app.use(expressjwt({
   secret:'zgs_first_token',
   algorithms:['HS256']
}).unless({
   path:['/login','/register']  //不需要验证的接口名称
}))

//设置托管静态目录; 项目根目录+ public.可直接访问public文件下的文件eg:http://localhost:3000/images/url.jpg
app.use(express.static(path.join(__dirname, 'public')));
app.use('/', indexRouter);
app.use('/', usersRouter);



//token失效返回信息
app.use(function(err,req,res,next){
   if(err.status==401){
       return res.status(401).send('token失效')
        //可以设置返回json 形式  res.json({message:'token失效'})
   }
})

module.exports = app;
