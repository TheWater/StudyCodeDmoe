var express = require('express');
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
module.exports = router;
