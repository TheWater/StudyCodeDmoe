water().then(()=>{
    return cup();
}).then(()=>{
    return tea();
});

function water(){
   return new Promise((resolve,reject)=>{
       setTimeout(()=>{
           console.log("1:烧水");
           resolve();
       },1000);
   });
}
function cup(){
   return new Promise((resolve,reject)=>{
       setTimeout(()=>{
           console.log("2:洗杯子");
           resolve();
       },500);
   });
}
function tea(){
    return new Promise((resolve,reject)=>{
        setTimeout(()=>{
            console.log("3:放茶叶泡茶");
            resolve();
        },500);
    });
}