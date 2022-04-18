function water(callback){
    setTimeout(()=>{
        console.log("1:烧水");
        callback();
    },1000);
}
function cup(callback){
    setTimeout(()=>{
        console.log("2:洗杯子");
        callback();
    },500);
}
function tea(callback){
    setTimeout(()=>{
        console.log("3:放茶叶泡茶");
        callback();
    },500);
}
water(function(){
    cup(function(){
        tea(function(){

        })
    })
})
//整个泡茶的各个异步功能之间保持了设定的同步执行顺序，