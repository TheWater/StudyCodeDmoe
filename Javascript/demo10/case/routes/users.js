var express = require('express');
const db = require('../../../demo9/case/utils/db');
var router = express.Router();

/* GET users listing. */
router.get('/reg', function(req, res, next) {
  if(!req.body.username){
    return res.send({flag:false,msg:'用户名不能为空'})
  }else if(!res.body.password){
    return res.send({flag:false,msg:'密码不能为空'})
  }
  next()
});
async (req,res,next)=>{
  let sql="select * from user where username?"
  let resSelect=await db.queryAsync(sql,[req.body.username])
  if(resSelect.length!==0){
    res.send({flag:false,msg:'此账号已经存在'})
  }else{
    let sql ="insert into user(username,password,status) value(?,?,?)"
    let params=[
      req.body.username,
      req.body.password,
      0
    ]
    let resInsert=await db.queryAsync(sql,params)
    if(resInsert.affectedRows!==0){
      res.send({flag:true,msg:'注册成功'})
    }else{
      res.send({flag:false,msg:'注册失败'})
    }
  }
}

module.exports = router;
