<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>生产领料</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
  <link rel="stylesheet" href="../layui/css/notice.css" />
  
  <script src="../layui/layui.js"></script>
  <script type="text/javascript" >
		 layui.config({
		        base: '../layui/'
		    });
  </script>
  <script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<style>
/*table外边距*/
.layui-table, .layui-table-view {
	margin: 0px 0;
}
/*弹出层table外边距*/
.layui-table, .layui-table-view {
	margin: 0px;
	padding: 0px;
	margin-bottom: 0px;
}
</style>
<body>

<table class="layui-hide" id="test" lay-filter="test"></table>
<div id="table2Div">
<table class="layui-hide" id="test2"  style="display:none;"></table>
	</div>


<script type="text/html" id="toolbarDemo">
<div class="layui-input-inline">
  <div class="layui-btn-container" style="margin-top:10px;padding-left:20px;">
    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckData"><i class="layui-icon layui-icon-survey"></i>审核领料单 </button>
    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckLength"><i class="layui-icon layui-icon-release"></i>申请领料</button>
	<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckDataAgain"><i class="layui-icon layui-icon-refresh-3"></i>刷新出库状态 </button>
  </div>
</div>
</script>

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
layui.use(['table','laydate','form','layer','notice'], function(){
  var $ = layui.jquery; 
  var layer = layui.layer; //独立版的layer无需执行这一句
  var table = layui.table;
  var laydate = layui.laydate;
  var form = layui.form;
  var notice = layui.notice;
  
//初始化配置，同一样式只需要配置一次，非必须初始化，有默认配置
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
  //年月选择器
  laydate.render({
    elem: '#test3'
    ,type: 'datetime'
  });
  
  table.render({
    elem: '#test'
    ,url:'../../getAllMaterialOrder.do'
    ,toolbar: '#toolbarDemo'
    ,title: '领料单'
    ,cols: [[
      {type: 'checkbox'}
      ,{field:'moId', title:'领料单编号', unresize:true,align:'center'}
      ,{field:'orderId', title:'生产订单编号',unresize:true,align:'center'}
      ,{field:'applydate', title:'领料单申请时间', unresize:true,align:'center'}
      ,{field:'proposerId', title:'领料单申请人', unresize:true,align:'center'}
      ,{field:'moStatus', title:'审核状态', unresize:true,align:'center'}
      ,{field:'auditingdate', title:'领料单审核时间', unresize:true,align:'center'}
      ,{field:'auditorId', title:'审核人编号', unresize:true,align:'center'}
      ,{field:'warehouseStatus', title:'出库状态', unresize:true,align:'center'}
      ,{fixed: 'right', width:178, align:'center', toolbar: '#barDemo',unresize:true}
    ]]
    ,page: true
    ,limit:10
	,limits:[10,20,30,50]  
  });
  
  //工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    var data = checkStatus.data;
    switch(obj.event){
      case 'getCheckData':
    	  if(data.length == 1){
				//判断订单审核状态
				if(data[0].moStatus == '未审核'){
					var index2 = layer.confirm('你确认审核该领料单？', {
						  btn: ['确认', '取消'] //可以无限个按钮
						  ,btn2: function(index, layero){
						    layer.close(index2);
						  }
						}, function(layero){
							layer.close(index2);
							var index88 = layer.open({
								  type: 1,
								  shade: 0.25,
								  area: ['400px', '350px'],
								  content: $('#nameAndTimeDiv2'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
								  success: function(layero, index){
									  form.render();
									  },
								  btn: ['确认', '取消'],
								  yes: function(layero){
									  $.ajax({
										  url:'../../updateThisMaterialOrderStatus.do?moId='+data[0].moId,
										  data:$("#formIdOne2").serialize(),
										  type:'post',
										  dataType:'json',
										  success:function(data){
											if(data == '1'){
												//layer.msg('审核成功');
												notice.success("审核成功");
												table.reload("test",{});
											}else{
												//layer.msg('审核失败');
												notice.error("审核失败");
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
							
						});
				}else{
					//layer.msg('该订单已审核');
					notice.warning("该订单已审核");
				}
			}else if(data.length >1){
				//layer.msg('最多只能审核一个订单');
				notice.warning("最多只能审核一个订单");
			}else {
				//layer.msg('请选择要审核的订单');
				notice.warning("请选择要审核的订单");
			}
    	  
      break;
      case 'getCheckLength':
    	  if(data.length == 1){
				//判断领料订单状态
				if(data[0].moStatus == '已审核'){
					 var index2 = layer.confirm('确定为该订单申请领料？', {
						  btn: ['确认', '取消'] //可以无限个按钮
						  ,btn2: function(index, layero){
						    layer.close(index2);
						  }
						}, function(layero){
							$.ajax({
								url:'../../insertRawMaterialOutbound.do?moId='+data[0].moId,
								  type:'post',
								  dataType:'json',
								  success:function(data){
									if(data == '1'){
										//layer.msg('发起领料成功');
										notice.success("发起领料成功");
										table.reload("test",{});
									}else{
										//layer.msg('发起领料失败');
										notice.error("发起领料失败");
									}
								  }
							});
							layer.close(index2);
						});
				}else{
					//layer.msg('该领料订单未审核');
					notice.warning("该领料订单未审核");
				}
				
			}else if(data.length >1){
				//layer.msg('只能为一个订单领料审核');
				notice.warning("只能为一个订单领料审核");
			}else {
				//layer.msg('请选择要领料的领料订单');
				notice.warning("请选择要领料的领料订单");
			}
      break;
      case 'getCheckDataAgain':
    	  if(data.length == 1){
				//判断领料订单状态
				if(data[0].moStatus == '已审核'){
					$.ajax({
						url:'../../selectRawMaterialOutbound.do?moId='+data[0].moId,
						  type:'post',
						  dataType:'json',
						  success:function(data){
							if(data == '1'){
								//layer.msg('刷新成功');
								notice.success("刷新成功");
								table.reload("test",{});
							}else{
								//layer.msg('领料未申请或仓库未响应');
								notice.error("领料未申请或仓库未响应");
							}
						  }
					});
				}else{
					//layer.msg('该领料订单未审核');
					notice.warning("该领料订单未审核");
				}
				
			}else if(data.length >1){
				//layer.msg('只能刷新一个领料订单');
				notice.warning("只能刷新一个领料订单");
			}else {
				//layer.msg('请选择要刷新的领料订单');
				notice.warning("请选择要刷新的领料订单");
			}
      break;
    };
  });
  
  //监听工具条
  table.on('tool(test)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
    	layer.open({
  		  title: '订单详情',
  		  type:1,
  		  area : [ '660px', '415px' ],//大小
  		  content: $("#table2Div"),
				end : function() {
					$('[lay-id="test2"]').css("display", "none");
				}
  		});
  	  
  	  table.render({
		    elem: '#test2'
		    ,url:'../../getMaterialInfo.do?orderId='+data.orderId+"&moId="+data.moId
		    ,cols: [[
		      {field:'materialId', title:'原料编号', unresize:true,align:'center'}
		      ,{field:'materialName', title:'原料名称',unresize:true,align:'center'}
		      ,{field:'productionQuantity', title:'所需数量', unresize:true,align:'center'}
		      ,{field:'proId', title:'产品编号', unresize:true,align:'center'} 
		    ]]
		});
  	} else if(obj.event === 'del'){
      layer.confirm('确认删除该计划？', function(index){
    	  $.ajax({
				url:'../../deleteMaterialOrderByMoId.do?moId='+data.moId,
				  type:'post',
				  dataType:'json',
				  success:function(data){
					if(data == '1'){
						//layer.msg('删除成功');
						notice.success("删除成功");
						table.reload("test",{});
						
						/* notice.warning("成功");
						notice.info("提示信息：毛都没有...");
						notice.error("大佬，我咋知道怎么肥四！");
						notice.success("大佬，我咋知道怎么肥四！"); */
					}else{
						//layer.msg('删除失败');
						notice.error("删除失败");
					}
				  }
			});
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
    	layer.open({
    		  title: '修改日计划',
    		  type:1,
    		  shadeClose : true,
    		  content: $("#dibId"),
    		  end : function() {
  					$('[lay-id="test2"]').css("display", "none");
  			  }
    		});
    }
  });
});
</script>


<!-- 审核人和审核时间 -->
<div style="display:none;" id="nameAndTimeDiv2" >

<form class="layui-form" lay-filter="formAuthority2" id="formIdOne2">	  
<div class="layui-inline" style="padding-left:0px;margin-top:20px;">
	<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">审核日期</label>
	<div class="layui-input-inline">
		<input type="text" class="layui-input" id="test5" placeholder="yyyy-MM-dd" name="auditingdate">
	</div>
</div>
<div style="padding-left:0px;margin-top:15px;">
<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">审核人员</label>
	<div class="layui-input-inline">
		<input type="text" name="auditorId" lay-verify="number" value="1"  class="layui-input" readonly>
	</div>
<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">备注信息</label>
				<div class="layui-input-inline" style="margin-left:-5px;">
      				<textarea name="des" required lay-verify="required" cols="35px" rows="4px" placeholder="请输入计划描述" class="layui-textarea"></textarea>
    			</div>
			</div>	
</div>
</form>
 </div>	
</body>
</html>