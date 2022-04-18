new Promise((resolve,reject)=>{
    reject("拒绝状态") //不用像回调函数那样一层一层跟着调用
    //promise 使用通知来决定执行什么内容
    //resolve("成功的状态")  //成功是用成功的状态通知
})
    .then(value=>{
        console.log("成功的业务状态1")
    },
    reason=>{
        console.log("拒绝的业务状态1")
        return new Promise((resolve,reject)=>{
            reject();
        })
    })
    .then(value=>{
        console.log("成功的业务状态2")
    },
    reason=>{
        console.log("拒绝的业务状态2")
    });