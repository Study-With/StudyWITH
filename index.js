var express = require('express');
var router = express.Router();
var fs=require('fs');
var posts = require('../posts.json');
const uuidv1 = require('uuid4');
/* GET home page. */
// router.get('/', function(req, res, next) {
  // res.render('index', { title: 'Express' });
// });

//'/'가 요청되었을 때 mainpage.ejs를 랜더링하여 웹페이지에 띄어준다.
router.get('/', function(req, res, next){
  res.render('mainpage', {posts:posts});
});

//'/'POST요청 받았을 때
//게시글 작성
//routes/index.js
router.post('/', function(req, res){
  var newpost={
    id:uuidv1(),
    title: req.body.title,
    body: req.body.body
  }

  posts.push(newpost)

  fs.writeFile('posts.json', JSON.stringify(posts), function(){
    res.render('mainpage', {posts:posts});
  })
})

//게시글 상세조회
//routes/index.js
router.get('/:post_id', function(req, res){
  var targetIndex = posts.findIndex(function(element){
    return element.id == req.params.post_id
  })
  var targetPost=posts[targetIndex]
  res.render('detail',{post:targetPost})
})

//5월11일
//update_post get요청
router.get('/update_post/:post_id', function(req,res){
  var targetIndex = posts.findIndex(function(element){
    return element.id == req.params.post_id
  })
  res.render('update', {post:posts[targetIndex]})
})

//update_post post요청
router.post('/update_post/:post_id', function(req, res){
  var index = posts.findIndex(function(element){
    return element.id==req.params.post_id
  })
  posts[index].title=req.body.title
  posts[index].body=req.body.body
  fs.writeFile('posts.json', JSON.stringify(posts), function(){
    res.redirect('/')
  })
})

//delete_post post요청
router.post("/delete_post/:post_id", function(req, res){
  var index = posts.findIndex(function(element){
    return element.id==req.params.post_id
  })
  posts.splice(index,1)
  fs.writeFile('posts.json', JSON.stringify(posts), function(){
    res.redirect('/')
  })
})
module.exports = router;
