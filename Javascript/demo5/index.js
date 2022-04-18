const { Cheerio } = require("cheerio");
const path=require('path')
const { options } = require("superagent")

let url="https://www.seig.edu.cn/sise/fengmian/fmgs_59/simumian.html"
let option={}

function start(){

  https.get(url,options,res=>{
    let html='';
    let a=0;
    res.on('data',chunk=>{
      data+=chunk;
    })
    res.on('end',()=>{
      const $=Cheerio.load(html)
      let result=[],i=0
     $('table:nth=child(2) tr td:nth-child(2) table tbody tr:nth-child(2)').find('img').each(function(i){
       let map={}
       let url=$(this).attr('src')
       let title=$('.fmgs2_style2').eq(i).text()
       map.picURL=url
       map.picTitle=title
       result.push(map)
     })
     fs.writeFile('./mumian.txt',JSON.stringify(result),{'flag':'a'},function(err){
       if(err){
         throw err
       }else{
         console.log('success');
       }
     })
    })

  })
}
start();