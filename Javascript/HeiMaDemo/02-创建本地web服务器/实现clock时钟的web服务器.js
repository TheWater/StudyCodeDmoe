const http = require('http') //导入http模块
const fs = require('fs') // 导入fs文件系统模块
const path = require('path') // 导入path模块

// 创建web服务器
const server = http.createServer()
// 监听web服务器的request 事件
server.on('request',(req,res)=>{
  // 获取到客户端请求的url地址
  // /clock/index.html
  // /clovk/index.css
  // /clock/index.js

  // 把请求地址url映射为具体文件的存放路径
  const url = req.url
  const fpath = path.join(__dirname,url)


  // 根据映射过来的文件路径来读取文件内容
  fs.readFile(fpath,'utf-8',(err,dataStr)=>{
    // 读取失败，向客户端响应固定的错误消息
    if(err) return res.end('404 not found')
    res.end(dataStr)  
  })
})
// 启动服务器
server.listen(80,()=>{
  console.log('http://127.0.0.1');
})
