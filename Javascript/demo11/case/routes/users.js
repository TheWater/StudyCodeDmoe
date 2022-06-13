var express = require('express');
var router = express.Router();
const db=require('../utils/db')



// GET 请求 路劲 路劲为 / 根路径 接口返回 GET request to the homepage
router.get('/', function (req, res) {
  res.send('GET request to the homepage')
})

// POST 请求 路劲为 / 根路径 POST request to the homepage
router.post('/', function (req, res) {
  res.send('POST request to the homepage')
})


router.post('/hah',function (req,res){

  // req: 客户端 携带的信息
  // console.log(req.query)
  // console.log(req.params)
  console.log(req.body)
  // console.log(req.get('Origin'))
  // console.log(req.url)

  // res 服务端 发送给 客户端的信息(数据)
  // res.send({
  //     msg: 'login 接口'
  // })
  // res.end('不会自动转换数据 容易乱码')
  // res.download('./static/dj.jpg') // 相对地址
  // res.sendFile(path.resolve('static','dj.jpg')) // 绝对地址
  // res.redirect('https://www.shiguangkey.com/')
  // res.redirect('https://www.shiguangkey.com/')
  res.set('sadsadsadsafdgsfadgfsdfsd','789')
  res.send({
      msg: 'set演示'
  })
})



/* GET users listing.  1 用户注册接口--- */
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

/* 2--用户登录接口-*/
router.post('/login',async (req, res, next) => {
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
/*3---按Id获取用户信息接口----*/
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

/*4---获取所有用户信息，并对信息进行分页，带搜索功能的分页-*/
/*router.get('/getAllUser',async (req, res) => {
    console.log(req.query)
    let pagenum=parseInt(req.query.pagenum)
    let pagesize=parseInt(req.query.pagesize)
    let sql="select * from user"
    let total=(await db.queryAsync(sql,[])).length
    if(total==0){
        res.send({flag:false,msg:'用户数量为0'})
    }else{
        let sql="select * from user limit ?,?"
        db.query(sql,[(pagenum-1)*pagesize,pagesize],(err,data)=>{
            if(err){
                console.log(err)
                res.send({flag: false, msg: '查询出错'})
            }else if(data.length!==0){
                res.send({flag: true, msg: '查询用户列表成功',users:data, total:total})
            }else{
                res.send({flag: true, msg: '没有一个用户'})
            }
        })
    }
})*/
/*4---获取所有用户信息，并对信息进行分页，带搜索功能的分页-*/
router.get('/getAllUser',async (req, res) => {
    console.log(req.query)
    let {query,pagenum,pagesize}=req.query
    let total=0
   if(query==''){
       let sql="select * from user"
       total=(await db.queryAsync(sql,[])).length
       sql="select * from user limit ?,?"
       db.query(sql,[parseInt((pagenum-1)*pagesize),parseInt(pagesize)],(err,data)=>{
           if(err){
               console.log(err)
               res.send({flag: false, msg: '查询出错1'})
           }else if(data.length!==0){
               res.send({flag: true, msg: '查询用户列表成功',users:data, total:total})
           }else{
               res.send({flag: true, msg: '没有一个用户1'})
           }
       })
   }else{
       let sql=`select * from user where username like ?`
       query="%"+query+"%"
       console.log(query)
       total=(await db.queryAsync(sql,[query])).length
       console.log(total,2)
        sql=`select * from user where username like ? limit ?,?`
       db.query(sql,[query,parseInt((pagenum-1)*pagesize),parseInt(pagesize)],(err,data)=>{
           if(err){
               console.log(err)
               res.send({flag: false, msg: '查询出错2'})
           }else if(data.length!==0){
               res.send({flag: true, msg: '查询用户列表成功',users:data, total:total})
           }else{
               res.send({flag: true, msg: '没有一个用户2'})
           }
       })
   }
})

/*5--------用户信息添加API----*/
router.post('/addUser',async (req,res)=>{
    let sql="select * from user where username=?"
    let resSelect=await db.queryAsync(sql,[req.body.username])
    if(resSelect.length!==0){
       return res.send({flag:false,msg:'此用户已经存在'})
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
           return res.send({flag:true,msg:'添加用户成功'})
        }else{
           return res.send({flag:false,msg:'添加用户失败'})
        }
    }
})

module.exports = router;

router.put('/editUser/:id',async (req,res) => {
  let sql = "update todos set completed = ? where id =?"

  let data = [false,req.params.id]
  await db.queryAsync(sql,data,(error,results,fields)=>{
    if(error){
      return console.error(error.message)
    }
    console.log('Rows affected:',results.affectedRows);
  })



})
