var express = require('express');
var router = express.Router();
const db=require('../utils/db')

/* GET users listing.  1--- */
router.post('/reg',
  (req, res, next)=> {
    if(!req.body.username){
      return res.send({flag:false,msg:'用户名不能为空'})
    }else if(!req.body.password){
      return res.send({flag:false,msg:'密码不能为空'})
    }
    next()
  },
  async (req, res, next) => {
   let sql="select * from user where username=?"
   let resSelect=await db.queryAsync(sql,[req.body.username])
    if(resSelect.length!==0){
      res.send({flag:false,msg:'此账号已经存在'})
    }else{
      let sql="insert into user(username,photo,password,mobile,email,status,create_time) value(?,?,?,?,?,?,?)"
      let params=[
          req.body.username,
          'images/photo.webp',
          req.body.password,
          req.body.mobile,
          req.body.email,
          0,
          new Date()
      ]
      let resInsert=await db.queryAsync(sql,params)
      if(resInsert.affectedRows!==0){
          res.send({flag:true,msg:'注册成功'})
      }else{
          res.send({flag:false,msg:'注册失败'})
      }
    }
  }
);

/* 2---*/
router.post('/log',async (req, res, next) => {
    let sql = "select * from user where username=? and password=?"
    let params = [
        req.body.username,
        req.body.password
    ]
    let resSelect = await db.queryAsync(sql, params)
    if (resSelect.length !== 0) {
        res.send({flag: true, msg: '登录成功'})
    } else {
        res.send({flag: false, msg: '登录失败'})
    }
  }
)
/*3-------*/
router.get('/getUserById/:id', (req, res, next) => {
    let id=req.params.id
    let sql="select * from user where id=?"
    db.query(sql,[id],(err,data)=>{
        if(err){
            res.send({flag: false, msg: '查询出错'})
        }else if(data.length!==0){
            res.send({flag: true, msg: '查询成功',data:data})
        }else {
            res.send({flag: true, msg: '没有这个用户'})
        }
    })
})

/*4----*/
router.get('/getAllUser',(req, res) => {
    
    let{query,pagesize,pagenum}=req.query
    if(query==''){
      // 分页显示查询结果
      let sql="select * from user"
      const total=(await db.queryAsync(sql,[])).length
      sql="select * from user limit ?,?"
      db.query(sql,[parseInt((pagenum-1)*pagesize),pagesize],(err,data)=>{
          if(err){
            return res.send({flag:false,msg:'查询出错'})
          }else if(data.length!==0){
            return res.send({flag:true,msg:'查询用户信息成功',users:data,total:total})
          }else{
            return res.send({flag:false,msg:'没有用户信息'})
          }
      })
    }else{
      // 分页显示搜索结构


    }
})


module.exports = router;
