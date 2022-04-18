const http=require('http');
/*http模块封装了高效的http服务器的http客户端
http.server是一个基于事件的HTTP服务器，内部由c++实现，接口由
*/
http.get('http://nodejs.cn/api/',function(res){
  let html='';
  res.on('data',function(chunk){
    html+=chunk;
  })
  res.on('end',function(){
    console.log(html);
  })
})