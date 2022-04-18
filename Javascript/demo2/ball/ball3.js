let ball = document.querySelectorAll('.ball');
let [b1,b2,b3]=ball;
function move(ele,length) {
  return new Promise((resolve,reject)=>{
    let left=parseInt(window.getComputedStyle(ele).left);
    let timer=setInterval(() => {
      if (left<length) {
        left=left+2;
        ele.style.left = left+'px';
      }else{
        clearInterval(timer);
        resolve();
      }
    }, 4);
  })
}

async function test() {
  
  await move(b1,200);
  await move(b2,400);
  await move(b3,600);


}

test(); 
