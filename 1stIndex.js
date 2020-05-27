var express = require('express');
var router = express.Router();

const Sequelize = require('sequelize');

//Option 1: Passing parameters separately
const sequelize = new Sequelize('gnb', 'root', 'qmffld99@', {
  host: 'localhost',
  dialect: 'mysql'
});

const Post = sequelize.define('post', {
  id: {
    primaryKey : true,
    type: Sequelize.INTEGER,
    autoIncrement: true
  },
  title: {
    type: Sequelize.STRING
  },
  body: {
    type: Sequelize.STRING
  }
});

Post.sync()//우리가 만든 테이블이 데이터베이스에 만들어짐.

router.get('/', function(req, res, next){
 Post.findAll().then(function(posts){
   res.render('mainpage', {posts:posts})
 })
});


router.post('/', function(req, res){

  //posts.push(newpost)

  Post.create({title:req.body.title, body:req.body.body}).then(function(){
    res.redirect('back')
  })
})

router.get('/:post_id', function(req, res){

 Post.findByPk(req.params.post_id).then(function(post){
   res.render('detail', {post:post})
 })
})

router.get('/update_post/:post_id', function(req,res){
  Post.findByPk(req.params.post_id).then(function(post){
    res.render('update', {post:post})
  })
});

router.post('/update_post/:post_id', function(req, res){

 Post.update({title:req.body.title, body:req.body.body}, {where:{id:req.params.post_id}}).then(function(){
   res.redirect('/')
 })
})

router.post("/delete_post/:post_id", function(req, res){
  Post.destroy({where:{id:req.params.post_id}}).then(function(){
    res.redirect('/')
  })
})
module.exports = router;
