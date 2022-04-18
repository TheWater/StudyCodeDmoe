const http=require('http');
const url=require('url');
const server=http.createServer(function(req,res){
  res.writeHead(200,{"content-type":"text/html;character=utf8"});
  switch (req.url) {
    case '/a.html':
      res.write('a页面');
      break;
    case '/b.html':
      res.write('b页面');
      break;
    default:
      res.write('404');
      break;
  }
  res.end();
})
server.listen(3100)