<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>角色管理</title>
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
</head>
<body class="childrenBody">
	<!-- 搜索条件开始 -->
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
	  <legend>查询条件</legend>
	</fieldset>
	<form class="layui-form" method="post" id="searchFrm">
		<div class="layui-form-item">
		    <div class="layui-block"style="text-align:center">
		      <label class="layui-form-label">角色名称:</label>
		      <div class="layui-input-inline">
		        <input type="text" name="rolename"  autocomplete="off" class="layui-input">
		      </div>
		    </div>
		    <div class="layui-block"style="text-align:center">
		      <label class="layui-form-label">角色备注:</label>
		      <div class="layui-input-inline">
		        <input type="text" name="roledesc"  autocomplete="off" class="layui-input">
		      </div>
		    </div>
		     <div class="layui-block"style="text-align:center">
		      <label class="layui-form-label">是否可用:</label>
		      <div class="layui-input-inline">
		       		 <input type="radio" name="available" value="1" title="可用">
					 <input type="radio" name="available" value="0" title="不可用">
		      </div>
		    </div>
		    <div class="layui-block"style="text-align:center">
		      <button type="button" class="layui-btn layui-btn-normal  layui-icon layui-icon-search" id="doSearch">查询</button>
		      <button type="reset" class="layui-btn layui-btn-warm  layui-icon layui-icon-refresh">重置</button>
		    </div>
		 </div>
	</form>
	
	<!-- 搜索条件结束 -->
	
	<!-- 数据表格开始 -->
	<table class="layui-hide" id="roleTable" lay-filter="roleTable"></table>
	<div style="display: none;" id="roleToolBar">
		    <button type="button" class="layui-btn layui-btn-sm" lay-event="add">增加</button>
		    <button type="button" class="layui-btn layui-btn-danger layui-btn-sm" lay-event="deleteBatch">批量删除</button>
	</div>
	<div  id="roleBar" style="display: none;">
	  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑角色</a>
	  <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="selectRoleMenu">分配角色菜单</a>
	  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除角色</a>
	   <a class="layui-btn llayui-btn-warm  layui-btn-xs" lay-event="fDep">角色分配部门</a>
	</div>
	<!-- 数据表格结束 -->
	
	<!-- 添加和修改的弹出层开始 -->
	<div style="display: none;padding: 20px" id="saveOrUpdateDiv" >
		<form class="layui-form"  lay-filter="dataFrm" id="dataFrm">
			<div class="layui-form-item">
				<label class="layui-form-label">角色名称:</label>
				<div class="layui-input-block">
					<input type="hidden" name="roleid" id="roleid">
					<input type="text" name="rolename"  placeholder="请输入角色名称" autocomplete="off"
						class="layui-input" lay-verify="required" id="rolename">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">角色备注:</label>
				<div class="layui-input-block">
					<input type="text" name="roledesc" placeholder="请输入角色备注" autocomplete="off"
						class="layui-input" lay-verify="required">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">是否可用:</label>
					<div class="layui-input-inline">
						 <input type="radio" name="available" value="1" checked="checked" title="可用">
						 <input type="radio" name="available" value="0" title="不可用">
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
	
	<!-- 分配部门的弹出层开始 -->
	<div style="display: none;padding: 20px" id="fenDep" >
		<form class="layui-form"  lay-filter="fenForm" id="fenForm">
			<div class="layui-form-item">
				<label class="layui-form-label">角色名称:</label>
				<div class="layui-input-block">
					<input type="hidden" name="roleid" id="roleid">
					<input type="text" name="rolename" readonly  autocomplete="off"
						class="layui-input" lay-verify="required" id="rolename">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">角色备注:</label>
				<div class="layui-input-block">
					<input type="text" name="roledesc" readonly  autocomplete="off"
						class="layui-input" lay-verify="required">
				</div>
			</div>
			 <div class="layui-form-item">
			    <label class="layui-form-label">部门选择</label>
			    <div class="layui-input-block">
			      <select name="depid" lay-filter="depid" id="depid" lay-verify="required" readonly>
			      </select>
			    </div>
			  </div>
			<div class="layui-form-item" style="text-align: center;">
			    <div class="layui-input-block">
			      <button type="button" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release" lay-filter="fenSubmit" lay-submit="">提交</button>
			      <button type="button" class="layui-btn layui-btn-warm layui-btn-sm layui-icon layui-icon-close"  id="quxiao">取消</button>
			    </div>
		  	</div>
		</form>
	
	</div>
	<!-- 分配部门的弹出层结束 -->
	
	<!-- 角色分配菜单的弹出层开始 -->
	<div style="display: none;" id="selectRoleMenu">
		<ul id="menuTree" class="dtree" data-id="0"></ul>
	</div>
	<!-- 角色分配菜单的弹出层结束 -->
	
	<script src="../resources/layui/layui.js"></script>
	<script type="text/javascript">
	    var tableIns;
	    layui.extend({
			dtree:'../resources/layui_ext/dist/dtree'
		}).use([ 'jquery', 'layer', 'form', 'table','dtree'  ], function() {
			var $ = layui.jquery;
			var layer = layui.layer;
			var form = layui.form;
			var table = layui.table;
			var dtree=layui.dtree;
			var flag;
			var checkTitle;
			var uporaddurl;
			var fenIndex;
			//渲染数据表格
			 tableIns=table.render({
				 elem: '#roleTable'   //渲染的目标对象
			    ,url:'../loadAllRole.do' //数据接口
			    ,title: '用户数据表'//数据导出来的标题
			    ,toolbar:"#roleToolBar"   //表格的工具条
			    ,height:'full-140'
			    ,cellMinWidth:100 //设置列的最小默认宽度
			    ,page: true  //是否启用分页
			    ,cols: [[   //列表数据
			     {type: 'checkbox', fixed: 'left'}
			      ,{field:'roleid', title:'ID',align:'center'}
			      ,{field:'rolename', title:'角色名称',align:'center'}
			      ,{field:'roledesc', title:'角色备注',align:'center'}
			      ,{field:'depid', title:'角色所属部门',align:'center',templet:function(d){
				    	 var bumen="";
				    	 if(d.depid==undefined){
				    		 bumen="该角色未属于任何部门";
				    		 return bumen;
				    	 }else{
				    		 $.ajax({
					    		 type:'post',
					    		 async:false,
					    		 url:"../queryDepNameBydepId.do?depId="+d.depid,
					    		 success:function(back){
					    			 bumen=back.depName;
					    		 }
					    	 });
					    	 return bumen;
				    	 }
				    	
				      }}
			      ,{field:'available', title:'是否可用',align:'center',templet:function(d){
			    	  return d.available=='1'?'<font color=blue>可用</font>':'<font color=red>不可用</font>';
			      }}
			      ,{fixed: 'right', title:'操作', toolbar: '#roleBar', width:400,align:'center'}
			    ]]
			})
			//模糊查询
			$("#doSearch").click(function(){
				var params=$("#searchFrm").serialize();
				tableIns.reload({
					url:"../loadAllRole.do?"+params,
					page:{curr:1}
				})
			});
			
			//监听头部工具栏事件
			table.on("toolbar(roleTable)",function(obj){
				 switch(obj.event){
				    case 'add':
				      openAddRole();
				    break;
				    case 'deleteBatch':
				    	deleteBatch();
					break;
				  };
			})
			//监听行工具事件
		   table.on('tool(roleTable)', function(obj){
			   var data = obj.data; //获得当前行数据
			   var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			  if(layEvent === 'del'){ //删除
				  layer.confirm('真的删除【'+data.rolename+'】这个角色吗', function(index){
				       //向服务端发送删除指令
				       $.post("../deleteRole.do",{roleid:data.roleid},function(res){
				    	   layer.msg(res.msg);
				    	    //刷新数据 表格
							tableIns.reload();
				       })
				     }); 
			   } else if(layEvent === 'edit'){ //编辑
			     openUpdateRole(data);
			   }else if(layEvent==='selectRoleMenu'){
				 openselectRoleMenu(data);
			   }else if(layEvent==='fDep'){
				   if(data.available==0){
					   layer.msg('该角色不可用，无法分配部门！', {
		            		  icon: 2,
		            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
		            		});
				   }else{
					   $.ajax({
						   url:"../getAllDepAndvisibles.do",
						   type:'post',
						   success:function(data){
							  // alert(data.length);
							  $("#depid").empty();//清空该元素
							  $.each(data,function(index,item){
								  $("#depid").append("<option value='"+item.depId+"'>"+item.depName+"</option>");
							  })
							  form.render();
						   }
					   })
					   openFenDep(data);
				   }
				  
			   }
			 });
			
			var url;
			var mainIndex;
			//打开添加页面
			function openAddRole(){
				mainIndex=layer.open({
					type:1,
					title:'添加角色',
					content:$("#saveOrUpdateDiv"),
					area:['500px','300px'],
					success:function(index){
						//清空表单数据       
						$("#dataFrm")[0].reset();
						url="../addRole.do";
						checkTitle=true;
						uporaddurl="../checkRoleName.do";
					}
				});
			}
			//打开修改页面
			function openUpdateRole(data){
				mainIndex=layer.open({
					type:1,
					title:'修改用户',
					content:$("#saveOrUpdateDiv"),
					area:['500px','300px'],
					success:function(index){
						form.val("dataFrm",data);
						url="../updateRole.do";
						 checkTitle=false;
						 uporaddurl="../checkUpdateRoleName.do";
					}
				});
			}
			//打开角色分配部门
			function  openFenDep(data){
				fenIndex=layer.open({
					type:1,
					title:'修改用户',
					content:$("#fenDep"),
					area:['500px','300px'],
					success:function(index){
						form.val("fenForm",data);
					}
				});
			}
			//保存分配部门
			form.on("submit(fenSubmit)",function(obj){
				//序列化表单数据
				var params=$("#fenForm").serialize();
				$.post("../saveDepByRoleId.do",params,function(obj){
					layer.msg(obj.msg);
					//关闭弹出层
					layer.close(fenIndex)
					//刷新数据 表格
					tableIns.reload();
				}) 
				
			});
			//当这个输入框失去焦点时触发
			$("#rolename").blur(function(){
				var rolename=$("#rolename").val().trim();
				if(checkTitle){
					if(rolename==""){
						layer.msg('角色名不能为空', {
		            		  icon: 2,
		            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
		            		});
					}else{
					$.post(uporaddurl,"rolename="+rolename,function(obj){
						flag=obj;
						if(obj){
							layer.msg('角色名不能重复', {
			            		  icon: 2,
			            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
			            		});
						}else{
							layer.msg('角色名可以使用', {
			            		  icon: 1,
			            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
			            		});
						}
					});
					}
				}else{
					var roleid=$("#roleid").val();
					$.post(uporaddurl,"rolename="+rolename+"&roleid="+roleid,function(obj){
						flag=obj;
						if(obj){
							layer.msg('角色名不能重复', {
			            		  icon: 2,
			            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
			            		});
						}else{
							layer.msg('角色名可以使用', {
			            		  icon: 1,
			            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
			            		});
						}
					});
				}
				
				
			
			}) 
			$("#quxiao").click(function(){
				layer.close(fenIndex);
			})
			//保存
			form.on("submit(doSubmit)",function(obj){
				if(flag){
					layer.msg('角色名重复', {
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
				})
				}
			});
			
			//批量删除
			function deleteBatch(){
				//得到选中的数据行
				var checkStatus = table.checkStatus('roleTable');
			    var data = checkStatus.data;
			    var params="";
			    $.each(data,function(i,item){
			    	if(i==0){
			    		params+="ids="+item.roleid;
			    	}else{
			    		params+="&ids="+item.roleid;
			    	}
			    });
			    layer.confirm('真的删除选中的这些角色吗', function(index){
				       //向服务端发送删除指令
				       $.post("../deleteBatchRole.do",params,function(res){
				    	   layer.msg(res.msg);
				    	    //刷新数据 表格
							tableIns.reload();
				       })
				     }); 
			}
			
			//打开分配菜单的弹出层
			function openselectRoleMenu(data){
				if(data.available==0){
					layer.msg('不可用角色无法分配菜单', {
	            		  icon: 2,
	            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
	            		});
				}else{
					var menuTree;
					mainIndex=layer.open({
						type:1,
						title:'分配【'+data.rolename+'】的角色',
						content:$("#selectRoleMenu"),
						area:['400px','500px'],
						btnAlign:'c',
						btn:['<div class="layui-icon layui-icon-release">确认分配</div>','<div class="layui-icon layui-icon-close">取消分配</div>'],
						yes:function(index, layero){
							var nodes = dtree.getCheckbarNodesParam("menuTree");
							var roleid=data.roleid;
							var params="roleid="+roleid;
							
							$.each(nodes,function(i,item){
								params+="&ids="+item.nodeId;
							})
							//保存角色和菜单的关系
							$.post("../saveRoleMenu.do",params,function(obj){
								layer.msg(obj.msg);
								layer.close(mainIndex);
							})
						},
						success:function(index){
							//初始化树
						   menuTree = dtree.render({
						      elem: "#menuTree",
							  dataStyle: "layuiStyle",  //使用layui风格的数据格式
						      response:{message:"msg",statusCode:0},  //修改response中返回数据的定义
					          dataFormat: "list",  //配置data的风格为list
					          checkbar: true,  
				              checkbarType: "all", // 默认就是all，其他的值为： no-all  p-casc   self  only\
				              checkbarData: "choose" ,
					          url: "../initRoleMenuTreeJson.do?roleid="+data.roleid // 使用url加载（可与data加载同时存在）
						    });
						}
					});
				}
				
			}
		});
	</script>
</body>
</html>