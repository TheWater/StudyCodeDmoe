let ball = document.querySelectorAll('.ball');
let [b1,b2,b3]=ball;
function move(ele,length) {
  return new Promise((resolve,reject)=>{
    let left=parseInt(window.getComputedStyle(ele).left);
    let timer=setInterval(function () {
      if(left<length){
        left=left + 2;
        ele.style.left = left +'px';
      }else{
        clearInterval(timer);
        resolve();
      }
    },4)
  });
}

move(b1,200).then(function(){
  return move(b2,400);
}).then(function(){
  return move(b3,600);
}).then(function(){
  console.log("success");
})