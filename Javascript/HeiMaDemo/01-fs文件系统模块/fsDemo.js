// 导入fs模块，来操作文件
const fs= require('fs');
// 调用fs.readFile()方法来读取文件

fs.readFile('./files/1.txt','utf-8',function(err,dataStr){
  // 打印错误的结果
  console.log(err.message);
  console.log('------');
  // 打印成功的结果
  console.log(dataStr);
})