<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>菜单</title>
  <link rel="stylesheet" href="../layui/css/layui.css">
  <script src="../layui/layui.js"></script>
  <script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>          
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>    
<table class="layui-hide" id="test" lay-filter="test"></table>
<div  id="dibId">
	<table class="layui-hide" id="test2"  lay-filter="test2" style="display:none;"></table>
</div>
<div id="xq" style="display:none;">
<table class="layui-hide" id="testxq" lay-filter="testxq" ></table>
</div>
<div id="mydiv"  style="display: none" >
<!-- 审核人和审核时间 -->
<div style="display:none;" id="nameAndTimeDiv2" >

<form class="layui-form" lay-filter="formAuthority2" id="formIdOne2">	  

<div class="layui-inline" style="padding-left:0px;margin-top:20px;">
	<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">审核日期</label>
	<div class="layui-input-inline">
		<input type="text" class="layui-input" id="test5" placeholder="yyyy-MM-dd">
	</div>
</div>
<div style="padding-left:0px;margin-top:15px;">
<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">审核人员</label>
	<div class="layui-input-inline">
		<select name="city" lay-verify="" lay-search="">
  			<option value="">制定人</option>
  			<option value="010">张三</option>
  			<option value="021">李四</option>
 			<option value="0571">王五</option>
		</select>  
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
<script type="text/html" id="toolbarDemo">

 
<div class="layui-input-inline">
  <div class="layui-btn-container" style="margin-top:10px;padding-left:20px;">
	<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckData"><i class="layui-icon layui-icon-friends"></i>审核日计划 </button>
    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckLength"><i class="layui-icon layui-icon-add-1"></i>制定生产订单</button>
  </div>


</div>
<div class="layui-input-inline" style="margin-top:10px;">
<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">状态查询</label>
	<div class="layui-input-inline">
		<select name="city" lay-verify="">
  			<option value="">审核状态</option>
  			<option value="010" >未审核</option>
  			<option value="021">审核未通过</option>
 			<option value="0571">审核通过</option>
		</select>  
	</div>
</div>
	
</script>


<script type="text/html" id="barDemo">
<a class="layui-btn layui-btn-xs  layui-btn-radius layui-icon layui-icon-edit"
			lay-event="edit">查看或编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
layui.use(['table','laydate','form','layer','jquery'], function(){
  var $=layui.jquery;
  var layer=layui.layer; //独立版的layer无需执行这一句
  var table = layui.table;
  var laydate = layui.laydate;
  var form = layui.form;
  var table2="";
  //常规用法
  laydate.render({
    elem: '#test1'
  });
  //年月选择器
  laydate.render({
    elem: '#test3'
    ,type: 'month'
  });
//常规用法
	laydate.render({
		elem : '#test5'
	});
  var testtable=table.render({
    elem: '#test'
    ,url:'../../selectDailyplan.do'
    ,toolbar: '#toolbarDemo'
    ,title: '日生产计划'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'dailyPlanid', title:'日生产计划编号', unresize:true}
      ,{field:'planId', title:'月生产计划编号',unresize:true}
      ,{field:'productionQuantity', title:'生产数量',unresize:true}
      ,{field:'auditorName', title:'负责人ID', unresize:true}
      ,{field:'auditingDate', title:'审核时间', unresize:true}
      ,{field:'productDate', title:'生产时间', unresize:true}
      ,{field:'auditingStatue', title:'审核状态', unresize:true}
      ,{
		fixed: 'right', width:178, align:'center', toolbar: '#barDemo',unresize:true
      }
    ]]
    ,page: true
  });
  
  
  
  //工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    var orderdata= checkStatus.data;
    switch(obj.event){
      case 'getCheckData':	//审核日计划
    	  if(orderdata.length == 1){
				//判断月计划审核状态
				if(orderdata[0].auditingStatue == '未审核'){
					var index2 = layer.confirm('你确认审核该生产计划？', {
						  btn: ['确认', '取消'] //可以无限个按钮
						  ,btn2: function(index, layero){
						    layer.close(index2);
						  }
						}, function(layero){
							layer.close(index2);
							$.ajax({
								type:"post",
								url:'../../updateDailyplanauditingStatue.do',
								data:"dailyPlanid="+orderdata[0].dailyPlanid,
								success:function(data){
									//关闭弹出层
									layer.msg('审核完成');
									testtable.reload();
								}
							 })	
							
						});
				}else{
					layer.msg('该日计划已审核');
				}
				
			}else if(data.length >1){
				layer.msg('最多只能审核一条日计划');
			}else {
				layer.msg('请选择一条要审核日计划');
			}
      break;
      case 'getCheckLength':	//制定生产订单
    	  if(orderdata.length == 1){
				//判断日计划审核状态
				if(orderdata[0].auditingStatue== '已审核'){
					 var index2 = layer.confirm('你确认为该计划制定生产订单？', {
						  btn: ['确认', '取消'] //可以无限个按钮
						  ,btn2: function(index, layero){
						    layer.close(index2);
						  }
						}, function(layero){
							$.ajax({
								  url:'../../insertorderproduct.do',
								  data:orderdata[0],
								  type:'post',
								  dataType:'json',
								  success:function(data){
										  layer.msg('生产订单制定成功,可到生产订单查看详情');
										  table.reload('test',{}); 
								  }
						});
						});
				}else{
					layer.msg('该日计划未审核');
				}
				
			}else if(orderdata.length >1){
				layer.msg('一次最多只能制定一条日计划');
			}else {
				layer.msg('请选择要制定订单的日计划');
			}
    	 
      break;
      case 'isAll':
        layer.msg(checkStatus.isAll ? '全选': '未全选')
      break;
    };
  });
  table.on('edit(testxq)',function(obj){
	  var data=obj.data;
	
	   $.ajax({
			type:"post",
			url:'../../updatedailyPlanDetails.do',
			data:data,
			success:function(data){
				//关闭弹出层
				layer.msg('修改成功');
				testtable.reload();	
			}
		 })	 
	  
	  
  });
//监听工具条
  table.on('tool(test)', function(obj){
    var data = obj.data;
 if(obj.event === 'del'){
      layer.confirm('确认删除该计划？', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
   	 $.ajax({
 		type:"post",
 		url:'../../selectDailyPlanDetails.do',
 		data:"dailyPlanid="+data.dailyPlanid,
 		success:function(data){
 			layer.open({
				 type:1,  //设置类型 默认为0 1 页面层 2 iframe层
				 title:'查看或修改生产订单',  //标题
				 content:$("#xq"),//内容  type=0 的内容
				 skin:'layui-layer-molv',//skin - 样式类名
				 area:['340px','400px'],  //area - 宽高
				 //offset:'lt',//offset - 坐标 默认：垂直水平居中
				 btnAlign:'c',//按钮排列
				 closeBtn:2,  //设置关闭按钮的样式 默认是1  0是没有 2
			     shade:[0.8, '#000'],//shade - 遮罩
			     shadeClose:true,//点击遮罩 是否关闭弹层
			     anim: 4,//设置动画
				 maxmin:true,//该参数值对type:1和type:2有效。默认不显示最大小化按钮。需要显示配置maxmin: true即可
				 success:function(){
				  var table2=table.render({
					    elem: '#testxq'
						    //,url:'../../selectorder.do'
						    ,cellMinWidth: 60
						    ,title: '日生产订单详情'
						    ,cols: [[
						    {field:'dpdId', title:'生产详情编号ID',unresize:true},
						     {field:'proId', title:'药品ID',unresize:true}
						      ,{field:'chineseName', title:'药品名字',unresize:true}
						      ,{field:'productionQuantity', title:'药品生产数量',edit:'true',unresize:true}
						  ]]
						  });
				  table.reload('testxq',{data:data})
			  }
	  });	
 		}
 	 })	
    }
  });
});
</script>



 

</body>
</html>
