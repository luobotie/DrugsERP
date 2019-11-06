<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登录-医药ERP</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="../css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="../css/fontastic.css">
    <!-- Google fonts - Poppins -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="../css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="../css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="">
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
  </head>
  <body>
    <div class="page login-page">
      <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
          <div class="row">
            <!-- Logo & Information Panel-->
            <div class="col-lg-6">
              <div class="info d-flex align-items-center">
                <div class="content">
                  <div class="logo">
                    <h1>医药ERP后台登录系统</h1>
                  </div>
                  <p>Medical ERP background login system.</p>
                </div>
              </div>
            </div>
            <!-- Form Panel    -->
            <div class="col-lg-6 bg-white">
              <div class="form d-flex align-items-center">
                <div class="content">
                  <form method="post" class="form-validate" id="myform">
                    <div class="form-group">
                      <input id="username" type="text" name="loginUsername" required data-msg="Please enter your username" class="input-material" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
                      <label for="login-username" class="label-material">User Name</label>
                    </div>
                    <div class="form-group">
                      <input id="pwd" type="password" name="loginPassword" required data-msg="Please enter your password" class="input-material" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
                      <label for="login-password" class="label-material">Password</label>
                    </div><a id="login"  class="btn btn-primary">Login</a>
                    <!-- This should be submit button but I replaced it with <a> for demo purposes-->
                  </form><a href="" class="forgot-pass">Forgot Password?</a><br><small>Do not have an account? </small><a href="" class="signup">Signup</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="copyrights text-center">
        <p>XX小组 by <a href="#" class="external">医药erp系统</a>
          <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
        </p>
      </div>
    </div>
    <!-- JavaScript files-->
   <script src="../js/jquery-3.4.1.min.js"></script>
    <script src="../js/popper.min.js"> </script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery.cookie.js"> </script>
    <script src="../js/Chart.min.js"></script>
    <script src="../js/jquery.validate.min.js"></script>
    <!-- Main File-->
    <script src="../js/front.js"></script>
    <script type="text/javascript">
    layui.use([ "element", "jquery", "layer"],
			function() {
				var $ = layui.jquery;
				var element = layui.element;
				var layer = layui.layer;
				//按下回车键触发方法
				$(function(){ 
			    	$(document).keydown(function(event){ 
			    		if(event.keyCode==13){ 
			    			var username=$("#username").val();
				            var pwd=$("#pwd").val();
				            if(username=="" || pwd==""){
				            	layer.msg('用户名或密码不能为空', {
				            		  icon: 2,
				            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
				            		});
				            }else{
				            	 $.post("../login.do",$("#myform").serialize(),function(back){
				            		if(back){
				            			window.location.assign("../admin/adminindex.jsp");
				            		}else{
				            			layer.msg('用户名或密码输入错误请重新输入登录', {
						            		  icon: 2,
						            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
						            		});
				            		}
				            		
				            	}) 
				            }
				          
			    		} 
			    	}); 
			    })
			    
				  $("#login").click(function(){
			        	var username=$("#username").val();
			            var pwd=$("#pwd").val();
			            if(username=="" || pwd==""){
			            	layer.msg('用户名或密码不能为空', {
			            		  icon: 2,
			            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
			            		});
			            }else{
			            	 $.post("../login.do",$("#myform").serialize(),function(back){
			            		if(back){
			            			window.location.assign("../admin/adminindex.jsp");
			            		}else{
			            			layer.msg('用户名或密码输入错误请重新输入登录', {
					            		  icon: 2,
					            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
					            		});
			            		}
			            		
			            	}) 
			            }
			          
			        })	
    
    })    
    
      
    </script> 
    
  </body>
</html>