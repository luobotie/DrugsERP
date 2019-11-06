<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>员工管理</title>
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
	<!-- 搜索条件开始 -->
	<fieldset class="layui-elem-field layui-field-title" style="margin-top:10px;">
	  <legend>查询条件</legend>
	</fieldset>
	<form class="layui-form" method="post" id="searchFrm">
		   <div class="layui-form-item" >
			      <label class="layui-form-label">员工编号:</label>
			      <div class="layui-input-inline">
			        <input type="text" name="employeeId"  autocomplete="off" class="layui-input" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
			      </div>
			    <label class="layui-form-label">登录名称:</label>
			      <div class="layui-input-inline">
			        <input type="text" name="employeeName"  autocomplete="off" class="layui-input">
			      </div>
			      <label class="layui-form-label">真实姓名:</label>
				<div class="layui-input-inline">
					<input type="text" name="realName"  autocomplete="off" lay-verify="required" 
						class="layui-input">
				</div>
		    </div>
		       <div class="layui-form-item">
			      <label class="layui-form-label">员工电话:</label>
			      <div class="layui-input-inline">
			        <input type="text" name="employeeTel"  autocomplete="off" class="layui-input" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
			      </div>
			    <label class="layui-form-label">身份证号码:</label>
			      <div class="layui-input-inline">
			        <input type="text" name="idCard"  autocomplete="off" class="layui-input" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
			      </div>
			      <label class="layui-form-label">员工地址:</label>
			      <div class="layui-input-inline">
			        <input type="text" name="addr"  autocomplete="off" class="layui-input">
			      </div>
		    </div>
		       <div class="layui-form-item">
			      <label class="layui-form-label">部门名称:</label>
			      <div class="layui-input-inline">
			        <input type="text" name="depName"  autocomplete="off" class="layui-input">
			      </div>
			    <label class="layui-form-label">角色名称:</label>
			      <div class="layui-input-inline">
			        <input type="text" name="rolename"  autocomplete="off" class="layui-input">
			      </div>
			       <label class="layui-form-label">入职时间</label>
				   <div class="layui-input-inline">
				        <input type="text" class="layui-input" id="joinTime" name="joinTime" placeholder="yyyy-MM-dd" readonly>
				   </div>
		    </div>
		    	<div class="layui-form-item">
		    	  <label class="layui-form-label">员工年龄:</label>
			      <div class="layui-input-inline">
			        <input type="number" name="employeeAge"  autocomplete="off" class="layui-input">
			      </div>
				<label class="layui-form-label">员工性别:</label>
					<div class="layui-input-inline">
						 <input type="radio" name="employeeSex" value="男" title="男" >
						 <input type="radio" name="employeeSex" value="女" title="女" >
					</div>
				<label class="layui-form-label">是否可用:</label>
					<div class="layui-input-inline">
						 <input type="radio" name="visibles" value="1"  title="可用" >
						 <input type="radio" name="visibles" value="0" title="不可用" >
					</div>
			</div>
		   <div class="layui-form-item" style="text-align:center;">
				    <div class="layui-inline">
				      <button type="button" class="layui-btn layui-btn-normal  layui-icon layui-icon-search" id="doSearch">查询</button>
				      <button type="reset" class="layui-btn layui-btn-warm  layui-icon layui-icon-refresh">重置</button>
				   </div>
		   </div>
	</form>
	
	<!-- 搜索条件结束 -->
	
	
	<!-- 数据表格开始 -->
	<table class="layui-hide" id="menuTable" lay-filter="menuTable"></table>
	<div style="display: none;" id="menuToolBar">
		    <button type="button" class="layui-btn layui-btn-sm layui-icon layui-icon-add-circle-fine" lay-event="add">新增一个员工</button>
	</div>
	<div  id="menuBar" style="display: none;">
	  <a class="layui-btn layui-btn-xs layui-icon layui-icon-user" lay-event="show">查看员工详情</a>
	  <a class="layui-btn layui-btn-xs layui-icon layui-icon-edit" lay-event="edit">编辑</a>
	  	  <a class="layui-btn layui-btn-xs layui-icon layui-icon-edit" lay-event="restPwdBtn">重置密码</a>
	  <a class="layui-btn layui-btn-danger layui-btn-xs layui-icon layui-icon-delete" lay-event="del">删除</a>
	</div>
	<!-- 数据表格结束 -->
	
	<!-- 添加和修改的弹出层开始 -->
	<div  style="display: none;padding: 20px; background-color: #F2F2F2;" id="saveOrUpdateDiv" >
		<form class="layui-form"  lay-filter="dataFrm" id="dataFrm">
		   <div class="layui-row">
		    <div class="layui-col-md6">
		       <div class="layui-form-item">
				<label class="layui-form-label">员工编号:</label>
					<div class="layui-input-inline">
						<input type="text" name="employeeId" id="employeeId" readonly placeholder="员工编号自动生成"
							class="layui-input">
					</div>
				</div>
				 <div class="layui-form-item">
					<label class="layui-form-label">登录名称:</label>
					<div class="layui-input-inline">
						<input type="text" name="employeeName" id="employeeName" autocomplete="off" lay-verify="required|username"  onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"
							 placeholder="请输入登录名！"
							class="layui-input">
					</div>
				
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">真实姓名:</label>
				<div class="layui-input-inline">
					<input type="text" name="realName"  autocomplete="off" lay-verify="required"  onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"
							 placeholder="请输入真实姓名，无法输入空格！"
						class="layui-input">
				</div>
				</div>
				<div class="layui-form-item">
				<label class="layui-form-label">员工年龄:</label>
				<div class="layui-input-inline">
					<input type="text" name="employeeAge"  autocomplete="off" lay-verify="required|age|number"  min="0" max="150" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"
						class="layui-input">
				</div>
			</div>
		        <div class="layui-form-item" id="passDiv">	
				<label class="layui-form-label">登录密码:</label>
				<div class="layui-input-block">
					<input type="hidden" name="headUrl" id="headUrl" autocomplete="off" lay-verify="required"  readonly
						class="layui-input">
						<input type="password" name="employeePwd" id="employeePwd" autocomplete="off" lay-verify="required"  onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"
							 placeholder="密码中无法输入空格！" class="layui-input">
				</div>
			</div>
			</div>
			<div class="layui-col-md6">
			<div class="layui-form-item" style="text-align:center;">
				&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;员工头像显示区
		      <div class="layui-input-block"  >
		            <div class="layui-upload-list">
					<img class="layui-upload-img" id="myImage" width="150px" height="150px">
					</div><br> 
							<div style="width: 200px">
							<div class="layui-progress layui-progress-big" lay-showpercent="true" lay-filter="jindu">
					  					上传进度：<div class="layui-progress-bar layui-bg-red" lay-percent="0%"></div>
							</div>
						  </div>	<br>
					<button type="button" class="layui-btn layui-btn-normal" id="checkPicture">选择头像图片上传</button>
				</div>
			</div>
			
		</div>
		</div>		
			<div class="layui-form-item">
				<label class="layui-form-label">联系电话:</label>
				<div class="layui-input-inline"> 
					<input type="text" name="employeeTel"  autocomplete="off"  lay-verify="required|phone"  onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"
						class="layui-input">
				</div>
				<label class="layui-form-label">员工学历:</label>
					<div class="layui-input-inline">
							 <select name="studyUndergo" lay-verify="required" readonly>
						          <option value="初中">初中</option>
						          <option value="高中">高中</option>
						          <option value="大专">大专</option>
						          <option value="本科">本科</option>
						          <option value="研究生">研究生</option>
						          <option value="硕士">硕士</option>
						          <option value="博士">博士</option>
        					</select>
					</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">身份号码:</label>
				<div class="layui-input-inline">
					<input type="text" name="idCard"  autocomplete="off" lay-verify="required|idcard"  onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"
						class="layui-input">
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">员工地址:</label>
					<div class="layui-input-inline">
						<input type="text" name="addr"   lay-verify="required"   autocomplete="off" 
							class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
					<label class="layui-form-label">入职部门:</label>
						<div class="layui-input-inline">
						    <select name="depId" lay-filter="depId" id="depId" lay-verify="required" readonly>
			                </select>
						</div>
					<label class="layui-form-label">部门角色:</label>
						<div class="layui-input-inline">
						 <select name="roleId" lay-filter="roleId" id="roleId" lay-verify="required" readonly>
			             </select>
						</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">入职时间</label>
				   <div class="layui-input-inline">
				        <input type="text" class="layui-input" id="joinTimeAddAndUpdate"  lay-verify="required" name="joinTime" placeholder="yyyy-MM-dd" readonly>
				   </div>
				   
					<label class="layui-form-label">员工描述:</label>
					<div class="layui-input-inline">
					<input type="text" name="describes"  autocomplete="off" 
						class="layui-input">
					</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">员工性别:</label>
					<div class="layui-input-inline">
						 <input type="radio" name="employeeSex" value="男" checked title="男" >
						 <input type="radio" name="employeeSex" value="女" title="女" >
					</div>
				<label class="layui-form-label">是否可用:</label>
					<div class="layui-input-inline">
						 <input type="radio" name="visibles" value="1" checked="checked" title="可用" >
						 <input type="radio" name="visibles" value="0" title="不可用" >
					</div>
			</div>
			<div class="layui-form-item" style="text-align: center;">
			    <div class="layui-input-block">
			      <button type="button" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release" lay-filter="doSubmit" lay-submit="">提交</button>
			      <button type="reset" class="layui-btn layui-btn-warm layui-btn-sm layui-icon layui-icon-refresh" >重置</button>
			    </div>
		  	</div>
		</form>
	</div>
	<!-- 添加和修改的弹出层结束 -->
	
	<!-- 查看员工信息弹出层开始 -->
	<div style="display: none;padding: 20px" id="showEmpDiv" >
		<form class="layui-form"  lay-filter="showEmpForm" id="showEmpForm">
		   <div class="layui-row">
		    <div class="layui-col-md6">
		       <div class="layui-form-item">
				<label class="layui-form-label">员工编号:</label>
					<div class="layui-input-inline">
						<input type="text" name="employeeId"  readonly placeholder="员工编号自动生成" readonly
							class="layui-input">
					</div>
				</div>
				 <div class="layui-form-item">
					<label class="layui-form-label">登录名称:</label>
					<div class="layui-input-inline">
						<input type="text" name="employeeName"    autocomplete="off" lay-verify="required"  readonly
							class="layui-input">
					</div>
				
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">真实姓名:</label>
				<div class="layui-input-inline">
					<input type="text" name="realName"  autocomplete="off" lay-verify="required"  readonly
						class="layui-input">
				</div>
				</div>
				<div class="layui-form-item">
				<label class="layui-form-label">员工年龄:</label>
				<div class="layui-input-inline">
					<input type="text" name="employeeAge"  autocomplete="off" lay-verify="required"  readonly
						class="layui-input">
				</div>
			</div>
			
			
		         <div class="layui-form-item">	
				<label class="layui-form-label">员工头像url:</label>
				<div class="layui-input-block">
					<input type="text" name="headUrl"  autocomplete="off" lay-verify="required"  readonly
						class="layui-input">
				</div>
			</div>
			</div>
			<div class="layui-col-md6">
			<div class="layui-form-item" style="text-align:center;">
				&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;员工头像显示区
		      <div class="layui-input-block"  >
		            <div class="layui-upload-list">
					<img class="layui-upload-img" id="showImage" width="150px" height="150px">
					</div>
				</div>
			</div>
			
		</div>
		</div>		
			<div class="layui-form-item">
				<label class="layui-form-label">联系电话:</label>
				<div class="layui-input-inline"> 
					<input type="text" name="employeeTel"  autocomplete="off"  lay-verify="required"  readonly
						class="layui-input">
				</div>
				<label class="layui-form-label">员工学历:</label>
					<div class="layui-input-inline">
						<input type="text" name="studyUndergo"   autocomplete="off" lay-verify="required"  readonly
							class="layui-input">
					</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">身份号码:</label>
				<div class="layui-input-inline">
					<input type="text" name="idCard"  autocomplete="off" lay-verify="required"  readonly
						class="layui-input">
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">员工地址:</label>
					<div class="layui-input-inline">
						<input type="text" name="addr"   lay-verify="required"   autocomplete="off"  readonly
							class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
					<label class="layui-form-label">入职部门:</label>
						<div class="layui-input-inline">
							<input type="text" name="depName"  autocomplete="off"  lay-verify="required"  readonly
								class="layui-input">
						</div>
					<label class="layui-form-label">部门角色:</label>
						<div class="layui-input-inline">
							<input type="text" name="rolename"  autocomplete="off"  lay-verify="required"  readonly
								class="layui-input">
						</div>
					
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">入职时间</label>
				   <div class="layui-input-inline">
				        <input type="text" class="layui-input"  name="joinTime" autocomplete="off" readonly>
				   </div>
				   
					<label class="layui-form-label">员工描述:</label>
					<div class="layui-input-inline">
					<input type="text" name="describes"  autocomplete="off" lay-verify="required" 
						class="layui-input">
					</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">员工性别:</label>
					<div class="layui-input-inline">
						 <input type="radio" name="employeeSex" value="男"  title="男" >
						 <input type="radio" name="employeeSex" value="女" title="女" >
					</div>
				<label class="layui-form-label">是否可用:</label>
					<div class="layui-input-inline">
						 <input type="radio" name="visibles" value="1" checked="checked" title="可用" >
						 <input type="radio" name="visibles" value="0" title="不可用" >
					</div>
			</div>
		</form>
	</div>

	<!-- 查看员工信息弹出层结束 -->
	
	<!-- 重置密码信息弹出层开始 -->
	  <div style="display:none;text-align: center;" id="restPwdDiv" >
	      <form class="layui-form"  method="post" lay-verify="restPwdForm" id="restPwdForm">
	             <div class="layui-form-item" style="text-align: center;">
				    <label class="layui-form-label">新密码：</label>
				    <div class="layui-input-inline">
				      <input type="hidden" name="employeeId" id="restPwdEmpId" class="layui-input">
				      <input type="password" name="restPwd" lay-verify="restPwd" id="restPwd" placeholder="输入新密码" autocomplete="off" class="layui-input"  onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
				    </div>
                 </div>
               <div class="layui-form-item" style="text-align: center;">
			    <div class="layui-input-block" >
			      <button type="button" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-ok" lay-filter="restPwdSubmit" lay-submit="">确认</button>
			      <button type="button" class="layui-btn layui-btn-warm layui-btn-sm layui-icon layui-icon-close" id="noDoSubmit"  >取消</button>
			    </div>
		  	</div>
	      </form>
	  </div>
	<!-- 重置密码信息弹出层结束 -->
	<script src="../resources/layui/layui.js"></script>
	<script type="text/javascript">
	    var tableIns;
	    layui.use([ 'jquery', 'layer', 'form', 'table','laydate','element','upload'], function() {
			var $ = layui.jquery;
			var layer = layui.layer;
			var form = layui.form;
			var table = layui.table;
			var laydate=layui.laydate;
			var element=layui.element;
			var upload=layui.upload;
			var adddetele=true;
			var dosumitclose=true;
			var flag;
			var checkTitle;
			var uporaddurl;
			var showIndex;
			 //执行一个laydate实例
			  laydate.render({
			    elem: '#joinTime', //指定元素
			    type:'date',
			    range:'~', //或 range: '~' 来自定义分割字符
			    trigger: 'click'//采用click弹出
			  });
			  //执行一个laydate实例
			  laydate.render({
			    elem: '#joinTimeAddAndUpdate', //指定元素
			    type:'date',
			    trigger: 'click'//采用click弹出
			  });
			//渲染数据表格
			 tableIns=table.render({
				 elem: '#menuTable'   //渲染的目标对象
			    ,url:'../loadAllEmp.do' //数据接口
			    ,title: '用户数据表'//数据导出来的标题
			    ,toolbar:"#menuToolBar"   //表格的工具条
			    ,height:'full-150'
			    ,page: true  //是否启用分页
			    ,cols: [[   //列表数据
			     {type: 'checkbox', fixed: 'left'}
			      ,{field:'employeeId', title:'员工编号',align:'center',unresize:true}
			      ,{field:'headUrl', title:'员工头像',align:'center',unresize:true,templet:function(d){
			    	  return "<img class='layui-upload-img' width='100px' height='100px' src="+d.headUrl+">";
			      }}
			      ,{field:'employeeName', title:'员工登录账户',align:'center',unresize:true}
			      ,{field:'realName', title:'真实姓名',align:'center',unresize:true}
			      ,{field:'employeeSex', title:'性别',align:'center'}
			      ,{field:'employeeAge', title:'年龄',align:'center'}
			      ,{field:'joinTime', title:'入职时间',align:'center',unresize:true}
			      ,{field:'employeeTel', title:'联系电话',align:'center',unresize:true}
			      ,{field:'idCard', title:'身份证号码',align:'center',hide:true}
			      ,{field:'addr', title:'员工地址',align:'center',hide:true}
			      ,{field:'studyUndergo', title:'员工学历',align:'center',hide:true}
			      ,{field:'describes', title:'员工描述',align:'center',hide:true}
			      ,{field:'roleId', title:'员工角色id',align:'center',hide:true}
			      ,{field:'rolename', title:'角色名称',align:'center',hide:true}
			      ,{field:'depId', title:'所属部门id',align:'center',hide:true}
			      ,{field:'depName', title:'部门名称',align:'center',hide:true}
			      ,{field:'employeePwd', title:'密码加密后',align:'center',hide:true}
			      ,{field:'visibles ', title:'是否可用',align:'center',unresize:true,templet:function(d){
			    	  return d.visibles=='1'?'<font color=blue>可用</font>':'<font color=red>不可用</font>';
			      }}
			      ,{fixed: 'right', title:'操作', toolbar: '#menuBar', width:350,align:'center'}
			    ]]
			})
			form.verify({
				  username: function(value, item){ //value：表单的值、item：表单的DOM对象
				    if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
				      return '用户名不能有特殊字符';
				    }
				    if(/(^\_)|(\__)|(\_+$)/.test(value)){
				      return '用户名首尾不能出现下划线\'_\'';
				    }
				    if(/^\d+\d+\d$/.test(value)){
				      return '用户名不能全为数字';
				    }
				  }
				  
				  //我们既支持上述函数式的方式，也支持下述数组的形式
				  //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
				  ,age:[
					  /^(?:[1-9][0-9]?|1[01][0-9]|120)$/
					  ,'年龄是1-120之间有效'
				  ] 
				  ,idcard:[
					  /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/
					  ,'十八位身份证号码有误'
				  ]
				}); 
			
			//模糊查询
			$("#doSearch").click(function(){
				var params=$("#searchFrm").serialize();
				tableIns.reload({
					url:"../loadAllEmp.do?"+params
				})
			});
			
			//监听头部工具栏事件
			table.on("toolbar(menuTable)",function(obj){
				 switch(obj.event){
				    case 'add':
				    	 $.ajax({
							   url:"../getAllDepAndvisibles.do",
							   type:'post',
							   success:function(data){
								  // alert(data.length);
								  $("#depId").empty();//清空该元素
								  $("#depId").append("<option disabled selected hidden >--------选择入职部门------</option>");
								  $.each(data,function(index,item){
									  $("#depId").append("<option value='"+item.depId+"'>"+item.depName+"</option>");
								  })
								  form.render();
							   }
						   })
				      openAddMenu();
				    break;
				  };
			})
			//监听行工具事件
		   table.on('tool(menuTable)', function(obj){
			   var data1 = obj.data; //获得当前行数据
			   var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			  if(layEvent === 'del'){ //删除
				       if(data1.visibles==0){
				    	   layer.msg('该员工已删除', {
			            		  icon: 2,
			            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
			            		});
				       }else{
				    	   layer.confirm('真的删除【'+data1.realName+'】这个员工吗？', function(index){
								$.post("../deleteEmpByEmpId.do","employeeId="+data1.employeeId,function(obj){
									layer.msg(obj.msg);
									//关闭弹出层
									layer.close(mainIndex)
									//刷新数据 表格
									tableIns.reload();
									
								});
						     });  
				       }
						 
			   } else if(layEvent === 'edit'){ //编辑
				   $.ajax({
					   url:"../getAllDepAndvisibles.do",
					   type:'post',
					   success:function(data){
						  $("#depId").empty();//清空该元素
						  $.each(data,function(index,item){
							  if(item.depId===data1.depId){
								  $("#depId").append("<option value='"+item.depId+"' selected>"+item.depName+"</option>");
							  }else{
								  $("#depId").append("<option value='"+item.depId+"'>"+item.depName+"</option>");
							  }
						  })
						  form.render();
					   }
				   })
			     openUpdateMenu(data1);
			   }else if(layEvent === 'show'){ //查看员工详情
			     openShowEmp(data1);
			   }else if(layEvent === 'restPwdBtn'){ //重置密码
			         openRestPwd(data1);
			   }
			   
			  
			 });
			
			form.on('select(depId)', function(obj){
				  console.log(obj.elem); //得到select原始DOM对象
				  console.log(obj.value); //得到被选中的值
				  console.log(obj.othis); //得到美化后的DOM对象
				   $.ajax({
					   url:"../getAllRoleByDepId.do?depId="+obj.value,
					   type:'post',
					   success:function(data){
						  $("#roleId").empty();//清空该元素
						  $.each(data,function(index,item){
								  $("#roleId").append("<option value='"+item.roleid+"' selected>"+item.rolename+"</option>");
						  })
						  form.render();
					   }
				   })
				  
				}); 
			var url;
			var mainIndex;
			//打开添加页面
			function openAddMenu(){
				 $("#myImage").attr("src","../downloadFile.do?path=2019-11-05/201911051113117759630.png");
				 element.progress('jindu', '0%');
				 $("#employeeId").attr("value","");
				 $("#headUrl").prop("value","");
				 $("#employeePwd").attr("value","");
				 adddetele=true;
				mainIndex=layer.open({
					type:1,
					title:'新增一条员工',
					content:$("#saveOrUpdateDiv"),
					area:['700px','450px'],
					success:function(index){
						//清空表单数据       
						$("#dataFrm")[0].reset();
						url="../addEmp.do";
						checkTitle=true;
						uporaddurl="../checkAddEmpName.do";
						 $("#passDiv").show();
					},end: function(){ 
						 var headImage=$("#headUrl").val();
						 if(dosumitclose){
							 if(headImage !=""){
					    		  $.post("../deleteHeadImage.do","headImage="+headImage,function(back){
					    			  
					    		  });
						 }else{
							 
							 
						 }
						 }
						//刷新数据 表格
							tableIns.reload();
					    }
				});
			}
			
			//打开修改页面
			function openUpdateMenu(data){
				adddetele=false;
				dosumitclose=true;
				 $("#myImage").attr("src",data.headUrl);
				 element.progress('jindu', '0%');
				 $("#employeeId").attr("value",data.employeeId);
				 $("#employeePwd").attr("value",data.employeePwd);
				 mainIndex=layer.open({
					type:1,
					title:'修改员工信息',
					content:$("#saveOrUpdateDiv"),
					area:['700px','450px'],
					success:function(index){
						form.val("dataFrm",data);
						url="../updateEmp.do";
					    checkTitle=false;
						uporaddurl="../checkUpdateEmpName.do";
                       $("#passDiv").hide();						
					},end: function(){ 
						//刷新数据 表格
						tableIns.reload();
					    }
				});
			}
			//打开查看员工详情页面
			function  openShowEmp(data){
				 $("#showImage").attr("src",data.headUrl);
				showIndex=layer.open({
					type:1,
					title:'查看员工详情',
					content:$("#showEmpDiv"),
					area:['700px','450px'],
					success:function(index){
						form.val("showEmpForm",data);
					}
				});
			}
			//打开重置密码页面
			var restPwdLayer;
			function openRestPwd(data){
				$("#restPwdEmpId").attr("value",data.employeeId);
				restPwdLayer=layer.open({
					type:1,
					title:'重置员工密码',
					content:$("#restPwdDiv"),
					area:['400px','200px'],
					success:function(index){
						$("#restPwdForm")[0].reset();
						
					}
				});
			}
			//保存重置密码
			form.on("submit(restPwdSubmit)",function(obj){
				var pwd= $("#restPwd").val();
				if(pwd==''){
					layer.msg('密码不能为空！', {
	            		  icon: 2,
	            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
	            		});
				}else{
					//序列化表单数据
					var params=$("#restPwdForm").serialize();
					$.post("../restPwd.do",params,function(data){
						layer.msg(data.msg);
						layer.close(restPwdLayer);
					})
				}
			})
			//关闭修改密码弹出层
			$("#noDoSubmit").click(function(){
				layer.close(restPwdLayer);
			})
			//图片的不自动上传
			  upload.render({
				  elem:'#checkPicture',
				  url: '../upload.do',
				  field:'mf',
				  accept:'images',
				  acceptMime:'image/*',
				  auto:false,  //去掉自动上传
				  progress: function(n){
					     var percent = n + '%' //获取进度百分比
					    element.progress('jindu', percent); //可配合 layui 进度条元素使用 
					  },
				  choose: function(obj){  
                      // 确定导入文件并进行线上合规验证吗？
                    //确认框
                    layer.confirm('确定上传该头像文件吗？', {icon: 3, title:'提示'}, function(index){
                         //读取本地文件
                        obj.preview(function(index, file, result){
                          //单个重传
                            obj.upload(index, file);
                        });
                            layer.close(index);
                      });
                  },
				  done: function(res){
				      if(res.code > 0){
				        return layer.msg('上传失败');
				      }else{
				    	  var headImage=$("#headUrl").val();
				    	  var employeeId=$("#employeeId").val();
				    	  if(adddetele){
				    		  if(headImage !=""){
					    		  $.post("../deleteHeadImage.do","headImage="+headImage,function(back){
					    			  
					    		  });
					    	  } 
					    	  //上传成功
						      layer.msg("上传成功");
					    	  $("#myImage").attr("src",res.data.src);
					    	  $("#headUrl").prop("value",res.data.src);
				    	  }else{
				    		  if(headImage !=""){
					    		  $.post("../deleteHeadImage.do","headImage="+headImage,function(back){
					    			  
					    		  });
					    	  } 
				    		  $.post("../updateHeadImage.do","headUrl="+res.data.src+"&employeeId="+employeeId,function(){
				    			  
				    		  })
					    	  //上传成功
						      layer.msg('头像变更成功！', {
					            		  icon: 1,
					            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
					            		});
					    	  $("#myImage").attr("src",res.data.src);
					    	  $("#headUrl").prop("value",res.data.src);
				    	  }
				    	 
				      }
				    },
				  error:function(){
					  layer.msg("服务器异常");
				  }
				  
			  })
			
			//当这个输入框失去焦点时触发
			$("#employeeName").blur(function(){
				var title=$("#employeeName").val().trim();
				if(checkTitle){
					if(title==""){
						layer.msg('登录名不能为空', {
		            		  icon: 2,
		            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
		            		});
					}else{
					$.post(uporaddurl,"employeeName="+title,function(obj){
						flag=obj;
						if(obj){
							layer.msg('登录名不能重复', {
			            		  icon: 2,
			            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
			            		});
						}else{
							layer.msg('登录名可以使用', {
			            		  icon: 1,
			            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
			            		});
						}
					});
					}
				}else{
					var mid=$("#employeeId").val();
					$.post(uporaddurl,"employeeName="+title+"&employeeId="+mid,function(obj){
						flag=obj;
						if(obj){
							layer.msg('登录名不能重复', {
			            		  icon: 2,
			            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
			            		});
						}else{
							layer.msg('登录名可以使用', {
			            		  icon: 1,
			            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
			            		});
						}
					});
				}
				
				
			
			}) 
			//保存
			form.on("submit(doSubmit)",function(obj){
				dosumitclose=false;
				var depId=$("#depId").val();
				if(flag){
					layer.msg('登录名重复', {
	            		  icon: 2,
	            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
	            		});
				}else{
					if(depId==null){
						layer.msg('请选择入职部门', {
		            		  icon: 2,
		            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
		            		});
					}else{
						//序列化表单数据
						var params=$("#dataFrm").serialize();
						$.post(url,params,function(obj){
							layer.msg(obj.msg);
							//关闭弹出层
							layer.close(mainIndex)
							//刷新数据 表格
							tableIns.reload();
							
						});
					}
				
				}
			});
		});
	</script>
</body>
</html>