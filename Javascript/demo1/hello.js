const http=require('http')
const server=http.createServer(function (req,res){
    res.writeHead(200,{'Content-type':'text/html;charset=utf-8'})
    res.end('Hello world')
})
server.listen(8088,"127.0.0.1")