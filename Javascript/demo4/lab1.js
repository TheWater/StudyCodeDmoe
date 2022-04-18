let fs=require('fs');
let path=require('path');
let target=path.join(__dirname,'../demo4');


console.log(__dirname);
console.log(target);

function loadTree(target,deep){
  let prev=new Array(deep).join('|');
  let dirInfo=fs.readdirSync(target);
  console.log(dirInfo);

  let files=[];
  let dirs=[];

  for (let i = 0; i < dirInfo; i++) {
    let start=fs.statSync(path.join(target,dirInfo[i]))
    if(start.isFile()){
      files.push(dirInfo[i])
    }else{
      dirs.push(dirInfo[i])
    }
    
  }


  for(let i=0;i<dirs.length;i++){
    console.log('${prev}├ ${dirs[i]}');
    let nextPath=path.join(target.dirs[i]);
    let nextDeep=deep+1;
    loadTree(nextPath,nextDeep);
  }
  for(let i=0;i<files.length;i++){
    if(i===files.length-1){
      console.log('${prev} └ $(files[i]}');
    }else{
      console.log('${prev} ├ ${files[i]}');
    }
  }



}

loadTree(target,1);