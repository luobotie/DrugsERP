<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>付款单查询</title>
<link rel="stylesheet" href="../layui/css/layui.css" media="all">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js"></script>
<script src="../layui/layui.js"></script>
<style type="text/css">
body {
	margin: 0 auto;
	width: 100%;
	height: 100%;
}

.demoTable {
	width: 100%;
	height: 50px;
	margin: 0px auto;
	line-height: 50px;
}
label{
	font-size: 13px;
}

</style>
</head>
<body>
<script src="../layui/layui.js"></script>
<script>
	layui.use('laydate', function(){
	  var laydate = layui.laydate;
		//日期时间选择器
		  laydate.render({
		    elem: '#test5'
		    ,type: 'date'
		  });
	});
</script>
	<!-- <iframe src="Pay.html" width="890px" height= "400px" name="topFrame" scrolling="no" frameborder="0" id="topFrame" style="display: none;"></iframe> -->

	<script type="text/html" id="toolbarDemo">
	<div class="layui-inline" >
<form class="layui-form" action="" >
		<div class="layui-inline" style="margin-left:20px;">
			<label>付款日期：</label>
			<div class="layui-input-inline" style="margin-left:5px;">
				<input type="text" class="layui-input" id="test5"
					placeholder="年--月--日 ">
			</div>
		</div>

		<div class="layui-inline" style="margin-left:20px;">
			<label>分店：</label>
			<div class="layui-input-inline" style="margin-left:5px;">
				<select name="audit"  lay-search="required">
					<option value="1">请选择</option>
					<option value="2">王五</option>
				</select>
			</div>
		</div>

		<div class="layui-inline" style="margin-left:20px;">
			<label>付款的类型：</label>
			<div class="layui-input-inline" style="margin-left:5px;">
				<select name="audit" lay-search="required">
					<option value="1">请选择</option>
					<option>采购付款</option>
					<option>分店退货</option>
				</select>
			</div>
		</div>

		<div class="layui-inline" >
			<button class="layui-btn layui-btn-normal" data-type="reload" display>搜索</button>		
		</div> 
</form>

	<div id="layerDemo" class="layui-btn-group demoTable">
  		<button data-method="offset" data-type="auto" class="layui-btn layui-btn-normal"><i class="layui-icon" ></i>付款单</button>
	</div>
</div>

	
	</script>
	
	<div class="layui-tab layui-tab-card">
	  <ul class="layui-tab-title">
	    <li class="layui-this">采购结算</li>
	    <li>销售退货</li>
	  </ul>
	  <div class="layui-tab-content" style="height: 100px;">
	    <div class="layui-tab-item layui-show">
			<table id="demo" lay-filter="demo"></table>
		</div>

	    <div class="layui-tab-item">
			<table id="demo1" lay-filter="demo1"></table>
	    </div>	   
	  </div>
	</div>
		
		<script type="text/javascript">
	    var table2 = null ;
		layui.use(['table','form', 'element','form'], function(){
			var table = layui.table, form = layui.form, element = layui.element, form = layui.form;
		  
		  //执行一个 table 实例
 		 	table2 =  table.render({
		    elem: '#demo'
		    ,height:563
		    ,url: '../../allfpc.do' //数据接口
		    ,title: '付款单查询'
		    ,page: true //开启分页
		    ,toolbar: '#toolbarDemo' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
		    ,totalRow: true //开启合计行
		    ,cols: [[ //表头
		    	//{type: 'normal', fixed: 'left'}
		        {field: 'financePurchaseCloseId', title: '采购结算id', width:150, sort: true, unresize:true}
		        //采购结算表
		        ,{field: 'closeTime', title: '结算时间',unresize:true}
		        , {field: 'financeManId', title: '经办人', unresize:true}
		        , {field: 'paidMoney', title: '已结算金额', unresize:true}
		        ,{field: 'unPaidMoney', title: '未结算金额', unresize:true}
		        , {field: 'firstMoney', title: '首付款', unresize:true}
		        , {field: 'lastMoney', title: '尾款', unresize:true}
		        , {field: 'practicalPaidMoney', title: '实际支出金额', unresize:true}
		        ,{field: 'shouldPaidMoney', title: '应支出金额', unresize:true}
		        ,{field: 'purchaseorderId', title: '采购单id', unresize:true}
		        ,{field: 'fPCRemark', title:'备注', unresize:true}
		        ,{
		    		fixed: 'right', title:'操作',width:178, align:'center', toolbar: '#barDemo',unresize:true
		          }
		        ]]
		  });
		  
		 	//头工具栏事件
		 	   table.on('toolbar(demo)', function(obj){
		 	    //var checkStatus = table.checkStatus(obj.config.id);
		 	    /* switch(obj.event){
		 	      case 'getCheckData':
		 	    		layer.open({
		 	    		  title: '在线调试'
		 	    		  ,content: $("#topFrame")
		 	    		  ,area: ['80%', '90%']
		 	    		}); 
		 	      break;
		 	    }; */
		 	  }); 
		 	
		 	//触发事件
		 	 var active = {
		 	    offset: function(othis){
		 	     var type = othis.data('type')
		 	     ,text = othis.text();
		 	     
		 	     layer.open({
		 	        type: 1, 
		 	        title : '付款单' //标题
		 	       ,offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
		 	       ,id: 'layerDemo'+type //防止重复弹出
		 	      ,content: '<iframe src="Pay.html" width="100%" height= "98%" name="topFrame" scrolling="no" frameborder="0" id="topFrame"></iframe>'
		 	       ,area: ['90%', '95%']
		 			,success:function(){
		 				layui.use('laydate', function(){
		 					  var laydate = layui.laydate;
		 						//日期时间选择器
		 						  laydate.render({
		 						    elem: '#test1'
		 						    ,type: 'date'
		 						  });
		 					});
		 				form.render();//表单渲染
		 			}
		 	     });
		 	   }
		 	 }
		 	 
		 	 $('#layerDemo .layui-btn').on('click', function(){
		 	   var othis = $(this), method = othis.data('method');
		 	   active[method] ? active[method].call(this, othis) : '';
		 	 });
		 	  
		 	  
		 	$(function() {
			 	//查询
		 		$("#seachTable").on("click",function(){
		 			//iframe层
		 			console.info("111");
		 			table2.reload({
		 				where : {
		 					flowerName:$("#name").val(),
		 				},
		 				page : {
		 					curr : 1
		 				}
		 			});
		 		});
		 	});
		  
	 	
		//监听操作
		table.on('tool(demo)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			var data = obj.data; //获得当前行数据
			var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			var tr = obj.tr; //获得当前行 tr 的DOM对象
	
			if (layEvent === 'del') { //查看
				layer.confirm('真的删除行么',function(index) {
					obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
					layer.close(index);
					//向服务端发送删除指令
					var url = "../../deletefpc.do";
					var data$ = {financePurchaseCloseId : data.financePurchaseCloseId};
					$.post(url,data$,function(obj) {
						layer.msg(obj.msg);//提示
						table2.reload(); //也是刷新父页面的
					},"json");
				});
			} else if (layEvent === 'edit') { //编辑
				var data = obj.data;//行数据
				//iframe层
				layer.open({
					type: 1, 
				  	title:'修改',
				  	area: ['auto', 'auto'],
				  	offset: ['0px', '50px'],
					content: $('#updateFinancepurchaseclose'),
					success:function(index){
						  form.val("dataform",data);
						  //urls="updatesrc.do";
						  
					  }
				});
			}
		});
	    
	    var table3 = null ;
		  
		  //执行一个 table 实例
 		 	table3 =  table.render({
		    elem: '#demo1'
		    ,height:563
		    ,url: '../../allsrc.do' //数据接口
		    ,title: '付款单查询'
		    ,page: true //开启分页
		    ,toolbar: '#toolbarDemo' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
		    ,totalRow: true //开启合计行
		    ,cols: [[ //表头
		    	//{type: 'normal', fixed: 'left'}
		    	//销售退货表
		        {field: 'sellReturnCloseId', title: '销售退货id', width:150, sort: true, unresize:true}
		        ,{field: 'sRCTime', title: '结算时间', unresize:true}
		        , {field: 'financeManId', title: '经办人', unresize:true}
		        , {field: 'paidMoney', title: '已结算金额', unresize:true}
		        ,{field: 'unPaidMoney', title: '未结算金额', unresize:true}
		        , {field: 'sellOrderId', title: '销售单id', unresize:true}
		        ,{field: 'sRCRemark', title:'备注', unresize:true}
		        ,{
		    		fixed: 'right', title:'操作',width:178, align:'center', toolbar: '#barDemo',unresize:true
		          }
		        ]]
		  });
		  
		 	//头工具栏事件
		 	   table.on('toolbar(demo1)', function(obj){
		 	    //var checkStatus = table.checkStatus(obj.config.id);
		 	    /* switch(obj.event){
		 	      case 'getCheckData':
		 	    		layer.open({
		 	    		  title: '在线调试'
		 	    		  ,content: $("#topFrame")
		 	    		  ,area: ['80%', '90%']
		 	    		}); 
		 	      break;
		 	    }; */
		 	  }); 
		 	
		 	//触发事件
		 	 var active = {
		 	    offset: function(othis){
		 	     var type = othis.data('type')
		 	     ,text = othis.text();
		 	     
		 	     layer.open({
		 	        type: 1, 
		 	        title : '付款单' //标题
		 	       ,offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
		 	       ,id: 'layerDemo'+type //防止重复弹出
		 	      ,content: '<iframe src="Pay.html" width="100%" height= "98%" name="topFrame" scrolling="no" frameborder="0" id="topFrame"></iframe>'
		 	       ,area: ['90%', '95%']
		 			,success:function(){
		 				layui.use('laydate', function(){
		 					  var laydate = layui.laydate;
		 						//日期时间选择器
		 						  laydate.render({
		 						    elem: '#test1'
		 						    ,type: 'date'
		 						  });
		 					});
		 				form.render();//表单渲染
		 			}
		 	     });
		 	   }
		 	 }
		 	 
		 	 $('#layerDemo .layui-btn').on('click', function(){
		 	   var othis = $(this), method = othis.data('method');
		 	   active[method] ? active[method].call(this, othis) : '';
		 	 });
		 	  
		 	  
		 	$(function() {
			 	//查询
		 		$("#seachTable").on("click",function(){
		 			//iframe层
		 			console.info("111");
		 			table3.reload({
		 				where : {
		 					flowerName:$("#name").val(),
		 				},
		 				page : {
		 					curr : 1
		 				}
		 			});
		 		});
		 	});
		  
	 	
		//监听操作
		table.on('tool(demo1)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			var data = obj.data; //获得当前行数据
			var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			var tr = obj.tr; //获得当前行 tr 的DOM对象
	
			if (layEvent === 'del') { //查看
				layer.confirm('真的删除行么',function(index) {
					obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
					layer.close(index);
					//向服务端发送删除指令
					var url = "../../deletesrc.do";
					var data$ = {sellReturnCloseId : data.sellReturnCloseId};
					$.post(url,data$,function(obj) {
						layer.msg(obj.msg);//提示
						table3.reload(); //也是刷新父页面的
					},"json");
				});
			} else if (layEvent === 'edit') { //编辑
				var data = obj.data;//行数据
				//iframe层
				layer.open({
					type: 1, 
				  	title:'修改',
				  	area: ['auto', 'auto'],
				  	offset: ['0px', '50px'],
					content: $('#updateSellReturnClose'),
					success:function(index){
						  form.val("dataform",data);
						  //urls="updatesrc.do";
						  
					  }
				});
			}
		});
		
	});
		
		//});
</script>
<!-- 销售退货 -->
<div id="updateSellReturnClose" style="display: none;">
<h2 align="center"><b>销售退货信息修改</b></h2>
<form class="layui-form" lay-filter="dataform" id="dataform" method="post" action="../../updatesrc.do">
  <table class="layui-table">
  	<tr>
  	<div class="layui-form-item" style="display: none;">
    <label class="layui-form-label" style="font-size:13px;">销售退货id：</label>
    <div class="layui-input-block">
      <input name="sellReturnCloseId" class="layui-input" type="number" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
    
  	</div>
  		<td>
  			<label class="layui-form-label" style="font-size:13px;">经办人</label>
   			<div class="layui-input-block">
      			<input name="financeManId" class="layui-input" type="text" autocomplete="off" lay-verify="title">
    		</div>
		</td>
		
  		<td>
  			<label class="layui-form-label" style="font-size:13px;">已结算金额</label>
    			<div class="layui-input-block">
      				<input name="paidMoney" class="layui-input" type="text" autocomplete="off" lay-verify="title">
    			</div>
    	</td>
    	<td>
  			<label class="layui-form-label" style="font-size:13px;">未结算金额</label>
    			<div class="layui-input-block">
      				<input name="unPaidMoney" class="layui-input" type="text" autocomplete="off" lay-verify="title">
    			</div>
    	</td>
    	
  	</tr>
  	<tr>
  		<td>
    		<label class="layui-form-label" style="font-size:13px;">销售订单id</label>
   			<div class="layui-input-block">
      			<input name="sellOrderId" class="layui-input" type="text" autocomplete="off" lay-verify="title">
    		</div>
    	</td>
  		<td>
  			<label class="layui-form-label" style="font-size:13px;">结算时间</label>
   			<div class="layui-input-block">
      			<input name="sRCTime" class="layui-input" id="date" type="text" placeholder="yyyy-MM-dd" autocomplete="off" lay-verify="date"/>
    		</div>
  		</td>
  		<td>
  			<label class="layui-form-label" style="font-size:13px;">备注</label>
   			<div class="layui-input-block">
      			<textarea placeholder="请输入内容" cols="70px" rows="15px" name="sRCRemark"></textarea>
    		</div>
  		</td>
  	</tr>
  	
  	<tr>
  	
  		<td colspan="3"> 
  		<div class="layui-form-item">
   		 <div class="layui-input-block" style="align-center">
   		   <button class="layui-btn" lay-filter=demo1 lay-submit="" >立即提交</button>
   		   <button class="layui-btn layui-btn-primary" type="reset">重置</button>
   		 </div>
  		</div>
		</td>
  	</tr>
  	
  </table>
</form>
</div>
<!-- 采购付款 -->
<div id="updateFinancepurchaseclose" style="display: none;">
<h2 align="center"><b>采购结算信息信息修改</b></h2>
<form class="layui-form" lay-filter="dataform" id="dataform" method="post" action="../../updatefpc.do">
  <table class="layui-table">
  	<tr>
  	<div class="layui-form-item" style="display: none;">
    <label class="layui-form-label" style="font-size:13px;">采购结算：</label>
    <div class="layui-input-block">
      <input name="financePurchaseCloseId" class="layui-input" type="number" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
    
  	</div>
  		<td>
  			<label class="layui-form-label" style="font-size:13px;">经办人</label>
   			<div class="layui-input-block">
      			<input name="financeManId" class="layui-input" type="text" autocomplete="off" lay-verify="title">
    		</div>
		</td>
		
  		<td>
  			<label class="layui-form-label" style="font-size:13px;">已结算金额</label>
    			<div class="layui-input-block">
      				<input name="paidMoney" class="layui-input" type="text" autocomplete="off" lay-verify="title">
    			</div>
    	</td>
    	<td>
  			<label class="layui-form-label" style="font-size:13px;">未结算金额</label>
    			<div class="layui-input-block">
      				<input name="unPaidMoney" class="layui-input" type="text" autocomplete="off" lay-verify="title">
    			</div>
    	</td>
    	
  	</tr>
  	<tr>
  		<td>
    		<label class="layui-form-label" style="font-size:13px;">采购订单id</label>
   			<div class="layui-input-block">
      			<input name="purchaseorderId" class="layui-input" type="text" autocomplete="off" lay-verify="title">
    		</div>
    	</td>
  		<td>
  			<label class="layui-form-label" style="font-size:13px;">结算时间</label>
   			<div class="layui-input-block">
      			<input name="closeTime" class="layui-input" id="date" type="text" placeholder="yyyy-MM-dd" autocomplete="off" lay-verify="date"/>
    		</div>
  		</td>
  		<td>
  			<label class="layui-form-label" style="font-size:13px;">备注</label>
   			<div class="layui-input-block">
      			<textarea placeholder="请输入内容" cols="50px" rows="15px" name="fPCRemark"></textarea>
    		</div>
  		</td>
  	</tr>
  	<tr>
  		<td>
    		<label class="layui-form-label" style="font-size:13px;">首付款</label>
   			<div class="layui-input-block">
      			<input name="firstMoney" class="layui-input" type="text" autocomplete="off" lay-verify="title">
    		</div>
    	</td>
  		<td>
  			<label class="layui-form-label" style="font-size:13px;">尾款</label>
   			<div class="layui-input-block">
      			<input name="lastMoney" class="layui-input" type="text" autocomplete="off" lay-verify="title">
    		</div>
  		</td>
  		<td>
  			<label class="layui-form-label" style="font-size:13px;">应付金额</label>
   			<div class="layui-input-block">
      			<input name="shouldPaidMoney" class="layui-input" type="text" autocomplete="off" lay-verify="title">
    		</div>
  		</td>
  		<td>
  			<label class="layui-form-label" style="font-size:13px;">实付金额</label>
   			<div class="layui-input-block">
      			<input name="practicalPaidMoney" class="layui-input" type="text" autocomplete="off" lay-verify="title">
    		</div>
  		</td>
  	</tr>
  	<tr>
  	
  		<td colspan="3"> 
  		<div class="layui-form-item">
   		 <div class="layui-input-block" style="align-center">
   		   <button class="layui-btn" lay-filter=demo1 lay-submit="" >立即提交</button>
   		   <button class="layui-btn layui-btn-primary" type="reset">重置</button>
   		 </div>
  		</div>
		</td>
  	</tr>
  	
  </table>
</form>
</div>

<!-- <button class="layui-btn layui-btn-sm" lay-event="getCheckData"><i class="layui-icon" ></i>付款单</button> -->

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


</body>
</html>