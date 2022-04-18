
const fs = require('fs')
const urlLib = require('url')
const http=require('http');

const querystring = require("querystring");
http.createServer(function(req,res){
  res.writeHead(200,{'Content-Type':'text/plain;charset=utf8'});

  // let params = url.parse(req.url,true).query;
  // res.write("网站名"+params.name);
  // res.write("\n");
  // res.write("网站URL："+params.url);
     // 解析数据
     var str = ''
     req.on('data', function(data) {
         str += data
     })
 
     req.on('end', function() {
         var obj = urlLib.parse(req.url, true)
         const url = obj.pathname
         const GET = obj.query
         const POST = querystring.parse(str) 
 
         // 区分
         if(url == '/url') { // 接口
             switch(GET.act) {
                 case 'reg':
 
                     // 1.检查用户名
                     // 2.插入users
                     if(users[GET.user]) {
                         res.write('{"ok": false, "msg": "此用户已存在"}')
                     } else {
                         users[GET.user] = GET.pass
                         res.write('{"ok": true, "msg": "注册成功！"}')
                     }
                     break;
 
                 case 'login':
 
                     if(users[GET.user] == null) {
                         res.write('{"ok": false, "msg": "此用户不存在"}')
                     } else if(users[GET.user] != GET.pass){
                         res.write('{"ok": false, "msg": "用户名或密码有误"}')
                     } else {
                         res.write('{"ok": true, "msg": "登录成功"}')
                     }
                     break
                 default:
                     res.write('{"ok": false, "msg": "未知的act"}')
             }
             res.end()
         } else {
             // 读取文件
             var file_name = './www' + url
             fs.readFile(file_name, function(err, data) {
                 if(err) {
                     res.write('404')
                 } else {
                     res.write(data)
                 }
                 res.end()
             })
         }
     })

}).listen(8000);