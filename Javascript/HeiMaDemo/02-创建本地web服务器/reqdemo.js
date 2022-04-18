const http=require('http')

const server=http.createServer()

// req是请求对象，包含了与客户端相关的数据和属性
server.on('request',(req)=>{
  const url = req.url

  const method = req.method
// 这里是反单引号 ${}是占位符
  const str = `Your request url is ${url},and request method is ${method}`

  console.log(str);
})

server.listen(80,()=>{
  console.log('server at http://127.0.0.1');
})