var express = require('express');
const db = require('../utils/db');
var router = express.Router();

/* GET users listing. */
router.get('/reg', function(req, res, next) {
  console.log(req.query);
  let sql="select * from user where username =?"
  let selectRes=await db.queryAsync(sql,req.query.username)
  if(selectRes.length!==0){
    res.send({flag:false,msg:'同名用户已存在'})
  }else{
    let sql="insert into user(username,password,create_time) values(?,?,?)"
    let create_time=new Date()
    let insertRes=await db.queryAsync(sql,[req.query.username,req.query.password,ceate_time])
    if(insertRes.affectedRows!==0){
      res.send({flag:true,msg:'注册成功'})
    }else{
      res.send({flag:false,msg:'注册失败'})
    }
  }
 

});

router.post('/login',(req,res)=>{
  let set = 'select * from user where username=? and password=?'
  let resS=db.query(sql,[req.body.username,req.body.password],(err,data)=>{
    if(err){
      console.log('错误');
    }else if(data.length!==0){
      res.send({flag:true,msg:'success'})
    }else{
      res.send({flag:true,msg:'成功'})
    }
  })
})

module.exports = router;
