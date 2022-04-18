//定时器设定一个时间，到达时间后不一定执行（如果当前还有其他同步任务正在处理，那么到时间也得等着）
setTimeout(()=>{
    console.log(1);
},30);
console.log(2);
setTimeout(()=>{
    console.log(3);
},10);
setTimeout(()=>{
    console.log(4);
},100);
for (let i = 0; i <900000000; i++) {

}
console.log(5);
// 2 5 3 1 4



