/*
let p1=new Promise((resolve,reject)=>{
    resolve('hello');//同步任务
}).then( //微任务
    value=>{console.log("resolve "+value)},
    reason=>{console.log("reject "+reason)}
    );
//resolve hello
*/

let p1=new Promise((resolve,reject)=>{
    resolve('hello');//同步任务
});
let p2=p1.then( //微任务
    value=>{console.log("resolve "+value)},
    reason=>{console.log("reject "+reason)}
);
console.log(p1)
console.log(p2)
//Promise { 'hello' }
// Promise { <pending> }
// resolve hello
