<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>部门管理</title>
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
	<link rel="stylesheet" href="../resources/layui_ext/dtree/dtree.css">
	<link rel="stylesheet" href="../resources/layui_ext/dtree/font/dtreefont.css">
	
	<style type="text/css">
		.select-test{position: absolute;max-height: 500px;height: 350px;overflow: auto;width: 100%;z-index: 123;display: none;border:1px solid silver;top: 42px;}
		.layui-show{display: block!important;}
	</style>
</head>
<body class="childrenBody">
	<!-- 搜索条件开始 -->
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
	  <legend>查询条件</legend>
	</fieldset>
	<form class="layui-form" method="post" id="searchFrm">
		<div class="layui-form-item">
		    <div class="layui-inline">
		      <label class="layui-form-label">部门名称:</label>
		      <div class="layui-input-inline">
		        <input type="text" name="depName"  autocomplete="off" class="layui-input">
		      </div>
		    </div>
		    <div class="layui-inline">
					<label class="layui-form-label">是否可用:</label>
					<div class="layui-input-inline">
						 <input type="radio" name="visibles" value="1" title="可用">
						 <input type="radio" name="visibles" value="0" title="不可用">
					</div>
				</div>
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
		    <button type="button" class="layui-btn layui-btn-sm layui-icon layui-icon-add-circle-fine" lay-event="add">新增部门</button>
	</div>
	<div  id="menuBar" style="display: none;">
	  <a class="layui-btn layui-btn-xs layui-icon layui-icon-edit" lay-event="edit">编辑</a>
	  <a class="layui-btn layui-btn-danger layui-btn-xs layui-icon layui-icon-delete" lay-event="del">删除</a>
	</div>
	<!-- 数据表格结束 -->
	
	<!-- 添加和修改的弹出层开始 -->
	<div style="display: none;padding: 20px" id="saveOrUpdateDiv" >
		<form class="layui-form"  lay-filter="dataFrm" id="dataFrm">
			<div class="layui-form-item">
				<label class="layui-form-label">部门名称:</label>
				<div class="layui-input-block">
					<input type="hidden" name="depId" id="depId">
					<input type="text" name="depName"  id="depName" placeholder="请输入部门名称" autocomplete="off" lay-verify="required"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">部门描述:</label>
				<div class="layui-input-block">
					<input type="text" name="describes" placeholder="请输入部门描述" autocomplete="off" lay-verify="required"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">是否可用:</label>
					<div class="layui-input-inline">
						 <input type="radio" name="visibles" value="1" checked="checked" title="可用">
						 <input type="radio" name="visibles" value="0" title="不可">
					</div>
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
	
	<script src="../resources/layui/layui.js"></script>
	<script type="text/javascript">
	    var tableIns;
	    layui.use([ 'jquery', 'layer', 'form', 'table'  ], function() {
			var $ = layui.jquery;
			var layer = layui.layer;
			var form = layui.form;
			var table = layui.table;
			var flag;
			var checkTitle;
			var uporaddurl;
			//渲染数据表格
			 tableIns=table.render({
				 elem: '#menuTable'   //渲染的目标对象
			    ,url:'../loadAllDepartment.do' //数据接口
			    ,title: '部门数据表'//数据导出来的标题
			    ,toolbar:"#menuToolBar"   //表格的工具条
			    ,height:'full-150'
			    ,cellMinWidth:100 //设置列的最小默认宽度
			    ,page: true  //是否启用分页
			    ,cols: [[   //列表数据
			     {type: 'checkbox', fixed: 'left'}
			      ,{field:'depId', title:'部门ID',align:'center'}
			      ,{field:'depName', title:'部门名称',align:'center'}
			      ,{field:'describes', title:'部门描述',align:'center'}
			      ,{field:'propleNumber', title:'部门人数',align:'center',templet:function(d){
			    	 var renshu="";
			    	 $.ajax({
			    		 type:'post',
			    		 async:false,
			    		 url:"../queryDepNum.do?depId="+d.depId,
			    		 success:function(back){
			    			renshu=back;
			    		 }
			    	 });
			    	 return renshu;
			      }}
			      ,{field:'visibles', title:'是否可用',align:'center',templet:function(d){
			    	  return d.visibles=='1'?'<font color=blue>可用</font>':'<font color=red>不可用</font>';
			      }}
			      ,{fixed: 'right', title:'操作', toolbar: '#menuBar', width:220,align:'center'}
			    ]]
			})
			//模糊查询
			$("#doSearch").click(function(){
				var params=$("#searchFrm").serialize();
				tableIns.reload({
					url:"../loadAllDepartment.do?"+params
				})
			});
			
			//监听头部工具栏事件
			table.on("toolbar(menuTable)",function(obj){
				 switch(obj.event){
				    case 'add':
				      openAddMenu();
				    break;
				  };
			})
			//监听行工具事件
		   table.on('tool(menuTable)', function(obj){
			   var data = obj.data; //获得当前行数据
			   var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			  if(layEvent === 'del'){ //删除
				   alert(obj.data.depId);
			      $.post("../deleteDepartment.do","depId="+obj.data.depId,function(obj){
			    	  
			      })
			      
			   } else if(layEvent === 'edit'){ //编辑
			     openUpdateMenu(data);
			   }
			 });
			
			var url;
			var mainIndex;
			//打开添加页面
			function openAddMenu(){
				mainIndex=layer.open({
					type:1,
					title:'新增一个部门',
					content:$("#saveOrUpdateDiv"),
					area:['400px','300px'],
					success:function(index){
						//清空表单数据       
						$("#dataFrm")[0].reset();
						url="../addDepartment.do";
						checkTitle=true;
						uporaddurl="../checkDepName.do";
					}
				});
			}
			//打开修改页面
			function openUpdateMenu(data){
				mainIndex=layer.open({
					type:1,
					title:'修改部门信息',
					content:$("#saveOrUpdateDiv"),
					area:['400px','300px'],
					success:function(index){
						form.val("dataFrm",data);
						url="../updateDepartment.do";
					    checkTitle=false;
						uporaddurl="../checkUpdateDepName.do";
					}
				});
			}
			//当这个输入框失去焦点时触发
			$("#depName").blur(function(){
				var depName=$("#depName").val().trim();
				if(checkTitle){
					if(depName==""){
						layer.msg('部门名不能为空', {
		            		  icon: 2,
		            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
		            		});
					}else{
					$.post(uporaddurl,"depName="+depName,function(obj){
						flag=obj;
						if(obj){
							layer.msg('部门名不能重复', {
			            		  icon: 2,
			            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
			            		});
						}else{
							layer.msg('部门名可以使用', {
			            		  icon: 1,
			            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
			            		});
						}
					});
					}
				}else{
					var depId=$("#depId").val();
					$.post(uporaddurl,"depName="+depName+"&depId="+depId,function(obj){
						flag=obj;
						if(obj){
							layer.msg('部门名不能重复', {
			            		  icon: 2,
			            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
			            		});
						}else{
							layer.msg('部门名可以使用', {
			            		  icon: 1,
			            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
			            		});
						}
					});
				}
				
				
			
			}) 
			//保存
			form.on("submit(doSubmit)",function(obj){
				if(flag){
					layer.msg('部门名重复', {
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
				
			});
			
		});
	</script>
</body>
</html>