var express = require('express');
const db = require('../utils/db');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});
router.get('/a', function(req, res) {
  res.send('i am a beautiful butterfly a');
  console.log("this gets executed a");
});
router.get('/b', function(req, res) {
  return res.send('i am a beautiful butterfly b');
  console.log("this gets executed b");
});

router.get('/menu',function(req,res){
  let sql = "select * from menu"
  db.query(sql,(err,data)=>{
    if(err){
      res.send({flag:false,msg:"haha"})
    }
  })
})
module.exports = router;
