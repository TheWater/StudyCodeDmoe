const mysql=require('mysql')

const pool=mysql.createPool({
  host:'127.0.0.1',
  user:'root',
  password:'010505',
  database:'jslab'
});

function query(sql,callback){
  pool.getConnection(function(err,connection){
    if(err) throw err;
    connection.query(sql,function(err,result){
      callback(err,result);
      connection.release();
    })
  })
}
exports.query=query;