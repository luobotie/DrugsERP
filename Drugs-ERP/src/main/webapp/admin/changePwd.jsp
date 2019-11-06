<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>个人信息</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="icon" href="favicon.ico">
	<link rel="stylesheet" href="../resources/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="../resources/css/public.css" media="all" />
	<style type="text/css">
		.select-test{position: absolute;max-height: 500px;height: 350px;overflow: auto;width: 100%;z-index: 123;display: none;border:1px solid silver;top: 42px;}
		.layui-show{display: block!important;}
	</style>
</head>
<body class="childrenBody">
	<fieldset class="layui-elem-field layui-field-title" style="margin-top:10px;">
	  <legend>修改密码</legend>
	</fieldset>
     <form class="layui-form layui-row changePwd" id="uapdatePwd" lay-filter="uapdatePwd" method="post">
	<div class="layui-col-xs12 layui-col-sm6 layui-col-md6">
		<div class="layui-input-block layui-red pwdTips">旧密码请输入“登录密码”，新密码必须两次输入一致才能提交</div>
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-block">
			    <input type="hidden" name="employeeId" id="employeeId" value="${employee.employeeId}" readonly class="layui-input layui-disabled">
				<input type="text" value="${employee.employeeName}" disabled class="layui-input layui-disabled">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">旧密码</label>
			<div class="layui-input-block">
				<input type="password" value="" placeholder="请输入旧密码" id="oldPwd" lay-verify="required" class="layui-input" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">新密码</label>
			<div class="layui-input-block">
				<input type="password" value="" placeholder="请输入新密码" lay-verify="required" id="newPwd" class="layui-input" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">确认密码</label>
			<div class="layui-input-block">
				<input type="password" value="" placeholder="请确认密码" id="againPwd" lay-verify="required" class="layui-input" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
			   <button type="button" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release" lay-filter="doSubmit" lay-submit="">提交</button>
			   <button type="reset" class="layui-btn layui-btn-warm layui-btn-sm layui-icon layui-icon-refresh" >重置</button>
			</div>
		</div>
	</div>
</form>
	<!-- 重置密码信息弹出层结束 -->
	<script src="../resources/layui/layui.js"></script>
	<script type="text/javascript">
	    layui.use([ 'jquery', 'layer', 'form', 'table','laydate','element','upload'], function() {
			var $ = layui.jquery;
			var layer = layui.layer;
			var form = layui.form;
			var table = layui.table;
			var laydate=layui.laydate;
			var element=layui.element;
			var upload=layui.upload;
			var checkOldPwd=false; 
			//当这个输入框失去焦点时触发
			$("#oldPwd").blur(function(){
				var oldPwd=$("#oldPwd").val();
				var employeeId=$("#employeeId").val();
				if(oldPwd==''){
					layer.msg('旧密码不能为空', {
	            		  icon: 2,
	            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
	            		});
				}else{
					$.post("../checkOldPwdByEmpId.do","oldPwd="+oldPwd+"&employeeId="+employeeId,function(data){
						if(data){
							checkOldPwd=true;
							layer.msg('旧密码验证正确!', {
			            		  icon: 1,
			            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
			            		});
						}else{
							checkOldPwd=false;
							layer.msg('旧密码验证错误！请重新输入！', {
			            		  icon: 2,
			            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
			            		});
						}
					});
				}
			})
			//保存
			form.on("submit(doSubmit)",function(obj){
				var newPwd=$("#newPwd").val();
				var againPwd=$("#againPwd").val();
				var oldPwd=$("#oldPwd").val();
				var employeeId=$("#employeeId").val();
				var flag=false;
				if(checkOldPwd){
					if(newPwd!=againPwd){
						layer.msg('两次输入的密码不一致！请重新输入！', {
		            		  icon: 2,
		            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
		            		});
					}else{
						$.post("../updateNewPwdByEmpId.do","employeeId="+employeeId+"&newPwd="+newPwd,function(data){
						       if(data.code==0){
						    	   layer.msg(data.msg+"2秒后跳转登录页面", {
										  icon: 1,
										  time: 2000 //2秒关闭（如果不配置，默认是3秒）
										}, function(){
											window.parent.frames.location.href="login.jsp";
										});
						       }else{
						    	   layer.msg(data.msg, {
										  icon: 2,
										  time: 2000 //2秒关闭（如果不配置，默认是3秒）
										})
						       }
						})	 
					}
				}else{
					layer.msg('旧密码验证错误！请重新输入！', {
	            		  icon: 2,
	            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
	            		});
				}
			})
			
		});
	</script>
</body>
</html>