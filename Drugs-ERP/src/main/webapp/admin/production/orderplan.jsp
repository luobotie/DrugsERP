<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>生产订单</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
  <script src="../layui/layui.js"></script>
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<!-- 审核人和审核时间 -->
<div style="display:none;" id="shenhe">
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
 <div id="xq" style="display:none;">
<table class="layui-hide" id="testxq" lay-filter="testxq" ></table>
</div>
<table class="layui-hide" id="test" lay-filter="test"></table>
<div id="mydiv"  style="display: none" >

		<form  class="layui-form" lay-filter="dataform" id="dataform" method="post" >
				<div class="layui-form-item" >
				<label class="layui-form-label">订单ID：</label>
				<div class="layui-input-inline">
					<input type="text" name="orderId" readonly
						autocomplete="off" placeholder="订单ID" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item" >
				<label class="layui-form-label">生产数量：</label>
				<div class="layui-input-inline">
					<input type="text" name="produceNumber" required lay-verify="required"
						autocomplete="off" placeholder="生产数量" class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">完成数量:</label>
				<div class="layui-input-inline">
					<input type="text"   name="finishNumber" required lay-verify="required"
						autocomplete="off" placeholder="完成数量" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">负责人:</label>
				<div class="layui-input-inline">
					<input type="text"   name="employName" required lay-verify="required"
						autocomplete="off" placeholder="负责人" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">订单日期:</label>
				<div class="layui-input-inline">
					<input type="text"   name="orderDate" required lay-verify="required"
						autocomplete="off" placeholder="订单日期" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">生产状态:</label>
				<div class="layui-input-inline">
					<input type="text"   name="produceState" required lay-verify="required"
						autocomplete="off" placeholder="生产状态" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">领料状态:</label>
				<div class="layui-input-inline">
					<input type="text"   name="materialState" required lay-verify="required"
						autocomplete="off" placeholder="领料状态" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">审核状态:</label>
				<div class="layui-input-inline">
					<input type="text"   name="auditState" required lay-verify="required"
						autocomplete="off" placeholder="审核状态" class="layui-input">
				</div>
			</div>
				<div class="layui-form-item">
				<label class="layui-form-label">日计划订单ID:</label>
				<div class="layui-input-inline">
					<input type="text"   name="dayPlanId" readonly
						autocomplete="off" placeholder="日计划订单ID" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button type="submit" class="layui-btn" lay-submit=""
						lay-filter="dosubmit">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>




<script type="text/html" id="toolbarDemo">

 
<div class="layui-input-inline">
  <div class="layui-btn-container" style="margin-top:10px;padding-left:20px;">
    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckData"><i class="layui-icon layui-icon-friends"></i>审核生产订单 </button>
    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckLength"><i class="layui-icon layui-icon-add-1"></i>生成领料单</button>
  </div>


</div>
	
</script>

<script type="text/html" id="barDemo">
<a class="layui-btn layui-btn-xs  layui-btn-radius layui-icon layui-icon-edit"
			lay-event="edit">编辑</a>
<a class="layui-btn layui-btn-xs  layui-btn-radius layui-icon layui-icon-edit"
			lay-event="select">查看详情</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
layui.use(['table','form','laydate','layer','jquery'], function(){
	var $ = layui.jquery;
  var table = layui.table;
  var form = layui.form;
  var laydate = layui.laydate;
  var layer=layui.layer;
  var tanIndex="";
  laydate.render({
		elem : '#test5'
	});
  var tableindex=table.render({
	    elem: '#test'
	    ,url:'../../selectorder.do'
	    ,toolbar: '#toolbarDemo'
	    ,cellMinWidth: 60
	    ,title: '生产订单'
	    ,cols: [[
	      {type: 'checkbox', fixed: 'left'}
	      ,{field:'orderId', title:'生产订单号', unresize:true}
	      ,{field:'produceNumber', title:'生产总数量',unresize:true}
	   
	      ,{field:'finishNumber', title:'完成量',unresize:true}
	      ,{field:'employName', title:'负责人', unresize:true}
	      ,{field:'orderDate', title:'订单生成时间', unresize:true}
	      ,{field:'produceState', title:'生产状态', unresize:true}
	      ,{field:'materialState', title:'领料状态', unresize:true}
	      ,{field:'auditState', title:'审核状态', unresize:true}
	      ,{field:'dayPlanId', title:'日生产计划订单ID', unresize:true}
	      ,{
			fixed: 'right', width:250, align:'center', toolbar: '#barDemo',unresize:true
	      }
	    ]]
	    ,page: true
	  });
	  
  //工具栏事件
  table.on('toolbar(test)', function(obj){
	
    var checkStatus = table.checkStatus(obj.config.id);
    var data= checkStatus.data;
    switch(obj.event){
      case 'getCheckData':
    	  if(data.length == 1){
				//判断订单审核状态
				if(data[0].auditState == '未审核'){
					var index2 = layer.confirm('你确认审核该生产订单？', {
						  btn: ['确认', '取消'] //可以无限个按钮
						  ,btn2: function(index, layero){
							  //点取消进这个方法
						    layer.close(index2);
						  }
						}, function(layero){
							layer.close(index2);
							var index88 = layer.open({
								  type: 1,
								  shade: 0.25,
								  area: ['400px', '350px'],
								  content:$("#shenhe"), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
								  success: function(layero, index){
									  form.render();
									  },
								  btn: ['确认', '取消'],
								  yes: function(layero){
									  layer.close(index88);
									  layer.msg('订单审核成功');
									}
								  ,btn2: function(index, layero){
										  layer.close(index88);
									}
							});
							
						});
				}else{
					layer.msg('该订单已审核');
				}
				
			}else if(data.length >1){
				layer.msg('最多只能审核一个订单');
			}else {
				layer.msg('请选择要审核的订单');
			}
      break;
      case 'getCheckLength':	//生成领料单
    	  if(data.length == 1){
				//判断日计划审核状态
				if(data[0].sex == '男'){
					 var index2 = layer.confirm('你确认为该订单生成领料订单？', {
						  btn: ['确认', '取消'] //可以无限个按钮
						  ,btn2: function(index, layero){
						    layer.close(index2);
						  }
						}, function(layero){
							layer.close(index2);
							layer.msg('领料订单生成成功');
							
						});
				}else{
					layer.msg('该生产订单未审核');
				}
				
			}else if(data.length >1){
				layer.msg('一次只能为一个订单生产领料单');
			}else {
				layer.msg('请选择要生成领料单的生产订单');
			}
      break;
      case 'isAll':
    	  if(data.length == 1){
				//判断日计划审核状态
				if(data[0].sex == '男'){
					 var index2 = layer.confirm('确认开始生产该订单？', {
						  btn: ['确认', '取消'] //可以无限个按钮
						  ,btn2: function(index, layero){
						    layer.close(index2);
						  }
						}, function(layero){
							layer.close(index2);
							layer.msg('该订单已开始生产');
							
						});
				}else{
					layer.msg('该订单未审核或未领料');
				}
				
			}else if(data.length >1){
				layer.msg('只能生产一个订单');
			}else {
				layer.msg('请选择要开始生产的订单');
			}
      break;
    };
  });
  
  function  openUpdate(data2){
	  tanIndex=layer.open({
				 type:1,  //设置类型 默认为0 1 页面层 2 iframe层
				 title:'查看或修改生产订单',  //标题
				 content:$("#mydiv"),//内容  type=0 的内容
				 skin:'layui-layer-molv',//skin - 样式类名
				 area:['340px','400px'],  //area - 宽高
				 //offset:'lt',//offset - 坐标 默认：垂直水平居中
				 btnAlign:'c',//按钮排列
				 closeBtn:2,  //设置关闭按钮的样式 默认是1  0是没有 2
			     shade:[0.8, '#000'],//shade - 遮罩
			     shadeClose:true,//点击遮罩 是否关闭弹层
			     anim: 4,//设置动画
				 maxmin:true,//该参数值对type:1和type:2有效。默认不显示最大小化按钮。需要显示配置maxmin: true即可
				 success:function(data1){
				  		form.val("dataform",data2);
			  }
	  });	
	 
 }
  

table.on('tool(test)', function(obj){
	var data=obj.data;
	  switch(obj.event){
	    case 'edit':
	    	openUpdate(data);
	    break;
	    case 'del':
	    	var result=confirm("确定删除吗");
	    	if(result){
	    		 obj.del();
	    	}
	    	break;
	    case 'select':
	      	 $.ajax({
	      		type:"post",
	      		url:'../../selectorderproductdetail.do',
	      		data:"dailyPlanid="+data.dayPlanId,
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
	    	break; 
};
});	
form.on("submit(dosubmit)",function(obj){
	 //序列化表单数据
	 $.ajax({
		type:"post",
		url:'../../updateorder.do',
		data:obj.field,
		success:function(data){
			//关闭弹出层
			layer.close(tanIndex);
			$("#test").reload();
		}
	 })	
	 });
  
  
})


</script>



 
</body>
</html>