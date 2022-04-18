// 导入http模块
const http=require('http');
// 创建实例
const server = http.createServer();
// 绑定request事件
server.on('request',function(req,res){
  console.log('visit our web server .');
})
// 初始化启动
server.listen(8080,function(){
  console.log('running at 172.0.0.1:8080');
})
