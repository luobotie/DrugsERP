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
	  <legend>个人信息</legend>
	</fieldset>
      <form class="layui-form layui-row" id="personalInfo" lay-filter="personalInfo" method="post">
	<div class="layui-col-md3 layui-col-xs12 user_right">
		<div class="layui-upload-list">
			<img class="layui-upload-img layui-circle userFaceBtn userAvatar" src="${employee.headUrl}" id="userFace">
		</div>
	</div>
	<div class="layui-col-md6 layui-col-xs12">
	     <div class="layui-form-item">
			<label class="layui-form-label">员工编号：</label>
			<div class="layui-input-block">
				<input type="text" name="employeeId" value="${employee.employeeId}" readonly class="layui-input layui-disabled">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">用户名：</label>
			<div class="layui-input-block">
				<input type="text" value="${employee.employeeName}" disabled class="layui-input layui-disabled">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">真实姓名：</label>
			<div class="layui-input-block">
				<input type="text" name="realName" value="${employee.realName}" placeholder="请输入真实姓名" lay-verify="required" class="layui-input realName">
			</div>
		</div>
		<div class="layui-form-item" pane="">
			<label class="layui-form-label">性别：</label>
			<div class="layui-input-block userSex">
				<input type="radio" name="employeeSex" value="男" title="男" checked>
				<input type="radio" name="employeeSex" value="女" title="女">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">地址：</label>
			<div class="layui-input-block">
				<input type="text" name="addr" value="${employee.addr}" placeholder="请输入地址" lay-verify="required" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">入职部门：</label>
			<div class="layui-input-block">
				<input type="text" value="${employee.depName}" disabled class="layui-input layui-disabled">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">部门角色：</label>
			<div class="layui-input-block">
				<input type="text" value="${employee.rolename}" disabled class="layui-input layui-disabled">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">入职时间：</label>
			<div class="layui-input-block">
				<input type="text" value="${employee.joinTime}" disabled class="layui-input layui-disabled">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">手机号码：</label>
			<div class="layui-input-block">
				<input type="text" name="employeeTel" value="${employee.employeeTel}" placeholder="请输入手机号码" lay-verify="phone" class="layui-input" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">身份证号：</label>
			<div class="layui-input-block">
				<input type="text" name="idCard" value="${employee.idCard}" placeholder="请输入身份证号码" lay-verify="required|idcard"   class="layui-input">
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
			$(function(){
				
			})
			
			form.verify({
				 idcard:[
					  /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/
					  ,'十八位身份证号码有误'
				  ]
				}); 
			
			//保存
			form.on("submit(doSubmit)",function(obj){
				//序列化表单数据
				 var params=$("#personalInfo").serialize();
				$.post("../updatePersonalInfo.do",params,function(data){
					layer.msg(data.msg+"2秒后跳转登录页面", {
						  icon: 1,
						  time: 2000 //2秒关闭（如果不配置，默认是3秒）
						}, function(){
							window.parent.frames.location.href="login.jsp";
						});
				}) 
			})
			
		});
	</script>
</body>
</html>