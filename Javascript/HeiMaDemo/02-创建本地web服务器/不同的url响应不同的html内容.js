const http = require('http')
const server = http.createServer()



server.on('request',(req,res)=>{
  // 请求url地址
  const url = req.url

  // 设置默认的响应内容
  let content = '<h>404 not found!</h>'

  // 判断地址
  if(url === '/' || url === '/index.html'){
    content = '<h>首页</h>'
  }else if(url === '/about.html'){
    content = '<h>关于页面</h>'
  }
  //设置响应头，防止中文乱码
  res.setHeader('Content-Type','text/html;charset=utf-8')
  res.end(content)
})

// 把内容响应给客户端
server.listen(80,()=>{
  console.log('server at http://127.0.0.1');
})