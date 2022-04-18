setTimeout(()=>{
    console.log("setTimeout");
},0);

new Promise(resolve=>{//promise的构造函数中的代码也是同步执行的
    resolve(); //运行到这句话时就把任务then(value=>console.log("success")) 加入到微任务队列
    console.log("promise");
}).then(value=>console.log("success"))
console.log("Hello");

//所以输出顺序  优先级 同步任务 微任务 宏任务
// promise
// Hello
// success
//setTimeout