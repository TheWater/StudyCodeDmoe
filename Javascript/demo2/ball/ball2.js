let ball=document.querySelectorAll('.ball');
let [b1,b2,b3]=ball;
function move(ele,length,callback) {
  let left=parseInt(window.getComputedStyle(ele).left);
  let timer=setInterval(function(){
    if(left<length){
      left=left+2;
      ele.style.left = left+'px';
    }else{
      clearInterval(timer);
      callback();
    }
  },4)
}

move(b1,200,function(){
  move(b2,400,function(){
    move(b3,600,function(){
      console.log("success");

    })
  })
})