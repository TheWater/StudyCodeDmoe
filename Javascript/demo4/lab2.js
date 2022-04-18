const http=require('http');
const fs=require('fs');
const { lookup } = require('dns');
let decumentRoot='D:/CODE/springDemo/StudyCodeDmoe/Javascript/demo4/www';
let server=http.createServer(function(req,res){
  let url=req.url;
  let file=decumentRoot+url;
  fs.readFile(file,function (err,data){
    if (err) {
      res.writeHead(404,{'content-type':'text/html;charaset="utf-8"'});
      res.write('<h1>404</h1>');
      res.end();
    }else{
      res.writeHead(200,{'content-type':'text/html;charaset="utf-8"'});
      res.write(data);
      console.log(data);
      res.end();
    }

 
    
  });
});
server.listen(4000,'127.0.0.1',function(){
  console.log('success');
})