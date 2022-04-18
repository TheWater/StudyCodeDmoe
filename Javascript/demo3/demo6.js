const buf3=Buffer.from('hello world')
console.log(buf3);
console.log(buf3.toString());
for(let i=0;i<buf3.length;i++){
  console.log(buf3[i]);
  console.log(String.fromCharCode(buf3[i]));  
}