<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title>质检</title>
		<meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  		<script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>
		<link rel="stylesheet" href="../layui/css/layui.css" />
		<link rel="stylesheet" href="../layui/css/notice.css" />

		<script src="../layui/layui.js"></script>
		<script type="text/javascript" >
		 layui.config({
		        base: '../layui/'
		    });
		</script>

		<style type="text/css">
			.layui-form-item {
				margin-bottom: 0px;
				margin-top: -5px;
				clear: both;
				*zoom: 1;
			}

			.layui-btn-container {
				width: 250px;
				float: left;
			}
			#tableName{
				margin-bottom: -10px;
				margin-top: -15px;
			}
		</style>
	</head>
	<body>
	<div style="margin-top:20px;">
		 <form class="layui-form layui-form-pane" id="we">
		  		<div class="layui-form-item" pane>
		  			<label class="layui-form-label layui-bg-orange">审核状态</label>
		  			<div class="layui-input-inline" style="width:120px;">
		  				<select name="qualitystatus" lay-filter="" > 
		  					<option value="-1">请选择</option>
		  					<option value="未质检">未质检</option>
		  					<option value="已通过">已通过</option>
		  					<option value="未通过">未通过</option>
		  				</select>
		  			</div>
		  			<button type="button" class="layui-btn layui-btn-search"  id="search" >搜索</button>
		  		</div>
		  	</form>
		  	</div>
		<table id="test" lay-filter="test"></table>
		<div id="table2Div">
			<table class="layui-hide" style="display: none;" id="test2"
			lay-data="{id: 'idTest'}" lay-filter="test2"></table>
		</div>

		<!-- 头部工具栏 -->
		<div id="toolbarDemo" style="display:none">
		<div class="layui-btn-container">
		    <button class="layui-btn layui-btn-sm layui-icon layui-icon-add-1 " lay-event="add">成品质检</button>
		  </div>
		 
		</div>

		<!-- 列工具栏 -->
		<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="edit">查看详情</a>
		  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>


		<script>
			layui.use(['notice', 'table', 'form', 'transfer', 'layer' ,'jquery','laydate'], function() {
				var $ = layui.jquery;
				var notice = layui.notice;
				var table = layui.table;
				var form = layui.form;
				var laydate = layui.laydate;
				var transfer = layui.transfer;
				var layer = layui.layer;
				//server模式
				/* formSelects.data('select1', 'server', {
					url: 'selects.json',
				}); */

				// 初始化配置，同一样式只需要配置一次，非必须初始化，有默认配置
				notice.options = {
					closeButton: true, //显示关闭按钮
					debug: false, //启用debug
					positionClass: "toast-top-center", //弹出的位置,
					showDuration: "500", //显示的时间
					hideDuration: "1000", //消失的时间
					timeOut: "2000", //停留的时间
					extendedTimeOut: "1000", //控制时间
					showEasing: "swing", //显示时的动画缓冲方式
					hideEasing: "linear", //消失时的动画缓冲方式
					iconClass: 'layui-icon-tips', // 自定义图标，有内置，如不需要则传空 支持layui内置图标/自定义iconfont类名
					onclick: null, // 点击关闭回调
				};

				//常规用法
				  laydate.render({
				    elem: '#test5'
				    ,type: 'datetime'
				  });
				
			 var tableIndex=table.render({
					elem: '#test',
					title: '生产计划表',
					url: '../../getAllCheckProduct.do',
					toolbar: '#toolbarDemo',
					page: true,
					limit:10,
					limits:[10,20,30,50],
					cols: [[ //表头
						{type: 'checkbox'}
					      ,{field:'podId', title:'质检单编号',sort: true,align: 'center',unresize: true}
					      ,{field:'orderId', title:'生产订单编号',align: 'center',unresize: true}
					      ,{field:'qualitystatus', title:'质检状态',align: 'center',unresize: true}
					      ,{field:'statusMan', title:'质检人',align: 'center',unresize: true}
					      ,{field:'statustime', title:'质检时间',align: 'center',unresize: true}
					      ,{fixed: 'right', title:'操作', align: 'center',toolbar: '#barDemo'}
						]]
				});
				//头工具栏事件
				table.on('toolbar(test)', function(obj) {
					var checkStatus = table.checkStatus(obj.config.id);
					var data = checkStatus.data;
					switch (obj.event) {
						case 'add':
							if(data.length == 1){
								//判断订单审核状态
								if(data[0].qualitystatus == '未质检'){
									var index88 = layer.open({
										  type: 1,
										  shade: 0.25,
										  area: ['400px', '350px'],
										  content: $('#nameAndTimeDiv'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
										  success: function(layero, index){
											  form.render();
											  },
										  btn: ['确认', '取消'],
										  yes: function(layero){
											  $.ajax({
												  url:'../../updateThisCheckProductStatus.do?podId='+data[0].podId,
												  data:$("#formIdOne").serialize(),
												  type:'post',
												  dataType:'json',
												  success:function(data){
													if(data == '1'){
														notice.success("审核成功");
														table.reload("test",{});
													}else{
														notice.error('审核失败');
													}
												  }
							                  //return false;
							                });
											  layer.close(index88);
											}
										  ,btn2: function(index, layero){
												  layer.close(index88);
											}
									});
								}else{
									//layer.msg('该订单已质检');
									notice.info("该订单已质检");
								}
							}else if(data.length >1){
								//layer.msg('最多只能质检一个订单');
								notice.warning("最多只能质检一个订单");
							}else {
								//layer.msg('请选择要质检的订单');
								notice.warning("请选择要质检的订单");
							}
							
							break;
						/* case 'search':
							var qualitystatus = $("#qualitystatus").val();
							if(qualitystatus == '-1'){
								table.reload("test",{});
							}else{
								var param = $("#we").serialize();
								alert(param);
								table.reload({
									url:'../../getCheckProductWithStatus.do?'+param
								}); 
							}
							
							break;
						case 'look':
							//layer.msg(checkStatus.isAll ? '全选' : '未全选');
							break; */
					};
				});
				
				//监听提交
				  $("#search").click(function(){
					var param = $("#we").serialize();
					tableIndex.reload({
					url:'../../getCheckProductWithStatus.do?'+param
					}); 
				  })
				
				//监听工具条
				table.on('tool(test)', function(obj) {
					var data = obj.data; //获得当前行数据
					var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
					var tr = obj.tr; //获得当前行 tr 的DOM对象
					
					if (layEvent === 'edit') { //查看详情
						layer.open({
							type: 1,
							area : [ '660px', '415px' ],//大小
							content: $("#table2Div"),
							end : function() {
								$('[lay-id="test2"]').css("display", "none");
							}
						});
					
						table.render({
						    elem: '#test2'
						    ,url:'../../getThisCheckProductInfo.do?podId='+data.podId
						    ,cols: [[
						    	{field:'dailyPlanid', title:'日计划编号', unresize:true,align:'center'}
						      ,{field:'proId', title:'药品编号', unresize:true,align:'center'}
						      ,{field:'chineseName', title:'药品名称',unresize:true,align:'center'}
						      ,{field:'productionQuantity', title:'所需数量', unresize:true,align:'center'}
						      ,{field:'daypracticalQuantity', title:'实际生产数量', edit: 'text',unresize:true,align:'center'}
						    ]]
						});
						
					} else if (layEvent === 'del') { //删除
						layer.confirm('真的删除行么', function(index) {
							$.ajax({
								url:'../../deleteCheckProductByPodId.do?podId='+data.podId,
								  type:'post',
								  dataType:'json',
								  success:function(data){
									if(data == '1'){
										notice.success("删除成功");
										table.reload("test",{});
										/* notice.warning("成功");
										notice.info("提示信息：毛都没有...");
										notice.error("大佬，我咋知道怎么肥四！");
										notice.success("大佬，我咋知道怎么肥四！"); */
									}else{
										notice.error('删除失败');
									}
								  }
							});
							layer.close(index);
							//向服务端发送删除指令
						});
					}
				});
				
				//监听单元格编辑
				  table.on('edit(test2)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
					  var data = obj.data;
					  $.ajax({
						  url:'../../updateRealNum.do?dpId='+data.dailyPlanid,
						  data:obj.data,
						  type:'post',
						  dataType:'json',
						  success:function(data){
							if(data == '1'){
								layer.msg('修改成功');
								//notice.success("修改成功");
								table.reload('test2',{});
							}else{
								layer.msg('修改失败');
								//notice.error("修改失败");
							}
						  }
					  });
					});
				
			});
		</script>
		<div style="display:none;" id="nameAndTimeDiv" >

<form class="layui-form" lay-filter="formAuthority2" id="formIdOne">	  
<div class="layui-inline" style="padding-left:0px;margin-top:20px;">
	<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">质检日期</label>
	<div class="layui-input-inline">
		<input type="text" class="layui-input" id="test5" placeholder="yyyy-MM-dd" name="statustime">
	</div>
</div>
<div style="padding-left:0px;margin-top:15px;">
<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">质检人员</label>
	<div class="layui-input-inline">
		<input type="text" name="statusMan" lay-verify="number" value="1"  class="layui-input" readonly>
	</div>
<div class="layui-input-inline" style="margin-top:10px;">
	<label style="margin:0 10px 0 20px;font-size:13px;">审核状态</label>
	<div class="layui-input-inline" style="margin-left:-5px;">
  				<select name="qualitystatus" lay-filter="qualitystatus">
					<option value="已通过">已通过</option>
					<option value="未通过">未通过</option>
				</select>
  	</div>
</div>	
</div>
</form>
 </div>	
	</body>
</html>
